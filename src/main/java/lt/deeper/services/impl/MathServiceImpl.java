package lt.deeper.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.LineString;
import org.locationtech.jts.geom.LinearRing;
import org.locationtech.jts.geom.Polygon;
import org.springframework.stereotype.Service;

import lt.deeper.data.Line;
import lt.deeper.data.Point;
import lt.deeper.data.Square;
import lt.deeper.exceptions.GeometryException;
import lt.deeper.services.MathService;

import static lt.deeper.exceptions.GeometryException.NOT_SQUARE_EXCEPTION;;

/**
 * MathService implementation
 * 
 * @author Evaldas Norvaiša
 *
 */
@Service
public class MathServiceImpl implements MathService {
    
    @Override
    public List<Point> getIntersectionPoints(Square square, Line line) throws GeometryException {
        if (!isSquare(square)) {
            throw new GeometryException(NOT_SQUARE_EXCEPTION);
        }
        
        LinearRing squareGeom = new GeometryFactory().createLinearRing(new Coordinate[]{
                new Coordinate(square.getSp1x(), square.getSp1y()), 
                new Coordinate(square.getSp2x(), square.getSp2y()), 
                new Coordinate(square.getSp3x(), square.getSp3y()), 
                new Coordinate(square.getSp4x(), square.getSp4y()), 
                new Coordinate(square.getSp1x(), square.getSp1y())});
        
        LineString lineGeom = new GeometryFactory().createLineString(new Coordinate[]{
                new Coordinate(line.getLp1x(), line.getLp1y()), 
                new Coordinate(line.getLp2x(), line.getLp2y())});
        
        Coordinate[] coordinates = squareGeom.intersection(lineGeom).getCoordinates();
        
        List<Point> intersectionPoints = new ArrayList<>();
        for (Coordinate coordinate : coordinates) {
            intersectionPoints.add(new Point(coordinate.x, coordinate.y));
        }
        return intersectionPoints;
    }
    
    private boolean isSquare(Square square) {
        // Polygon is used only for validation, because acts not as expected when using intersection method
        Polygon squareGeom = new GeometryFactory().createPolygon(new Coordinate[]{
                new Coordinate(square.getSp1x(), square.getSp1y()), 
                new Coordinate(square.getSp2x(), square.getSp2y()), 
                new Coordinate(square.getSp3x(), square.getSp3y()), 
                new Coordinate(square.getSp4x(), square.getSp4y()), 
                new Coordinate(square.getSp1x(), square.getSp1y())});
        Coordinate[] c = squareGeom.getCoordinates();
        // check if object is rectangle and if all it's sides are of equal length
        double sideLength = squareGeom.getLength() / 4;
        return squareGeom.isRectangle() && 
                c[0].distance(c[1]) == sideLength && 
                c[1].distance(c[2]) == sideLength &&
                c[2].distance(c[3]) == sideLength &&
                c[3].distance(c[0]) == sideLength; 
    }

}
