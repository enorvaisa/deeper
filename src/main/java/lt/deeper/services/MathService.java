package lt.deeper.services;

import java.util.List;

import lt.deeper.data.Line;
import lt.deeper.data.Point;
import lt.deeper.data.Square;
import lt.deeper.exceptions.GeometryException;

/**
 * Service used for math operations
 * 
 * @author Evaldas Norvaiša
 *
 */
public interface MathService {

    /**
     * Accept as an input information about a square and a line and return information where and if these two objects intersect
     * 
     * @param square Square 4 points coordinates
     * @param line Line 2 points coordinates
     * @return list of intersection points (x,y coordinates) or empty list if none
     * @throws GeometryException
     */
    List<Point> getIntersectionPoints(Square square, Line line) throws GeometryException;
    
}
