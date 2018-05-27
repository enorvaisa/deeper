package lt.deeper.services;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import lt.deeper.data.Point;
import lt.deeper.exceptions.GeometryException;
import lt.deeper.services.impl.MathServiceImpl;

import static lt.deeper.SampleData.*;

/**
 * MathService tests
 * 
 * @author Evaldas Norvaiša
 *
 */
public class MathServiceTest {

    private MathService mathService = new MathServiceImpl();
    
    @Test
    public void testRectangle() {
        try {
            mathService.getIntersectionPoints(rectangle, squareLine1Point);
            fail("Expected an IndexOutOfBoundsException to be thrown");
        } catch (GeometryException e) {
            assertEquals(e.getMessage(), GeometryException.NOT_SQUARE_EXCEPTION);
        }
    }
    
    @Test
    public void testRhombus() {
        try {
            mathService.getIntersectionPoints(rhombus, squareLine1Point);
            fail("Expected an IndexOutOfBoundsException to be thrown");
        } catch (GeometryException e) {
            assertEquals(e.getMessage(), GeometryException.NOT_SQUARE_EXCEPTION);
        }
    }
    
    @Test
    public void testIntersect0Points() {
        try {
            List<Point> intersectionPoints = mathService.getIntersectionPoints(square, squareLine0Points);
            assertTrue(intersectionPoints.size() == 0);
        } catch (GeometryException e) {
            fail("Exception not expected");
        }
    }
    
    @Test
    public void testIntersect1Point() {
        try {
            List<Point> intersectionPoints = mathService.getIntersectionPoints(square, squareLine1Point);
            assertTrue(intersectionPoints.size() == 1);
            assertEquals(intersectionPoints.get(0).getP1x(), 2, 0);
            assertEquals(intersectionPoints.get(0).getP1y(), -3, 0);
        } catch (GeometryException e) {
            fail("Exception not expected");
        }
    }
    
    @Test
    public void testIntersect2Points() {
        try {
            List<Point> intersectionPoints = mathService.getIntersectionPoints(square, squareLine2Points);
            assertTrue(intersectionPoints.size() == 2);
            assertEquals(intersectionPoints.get(0).getP1x(), -3, 0);
            assertEquals(intersectionPoints.get(0).getP1y(), 2, 0);
            assertEquals(intersectionPoints.get(1).getP1x(), 2, 0);
            assertEquals(intersectionPoints.get(1).getP1y(), -3, 0);
        } catch (GeometryException e) {
            fail("Exception not expected");
        }
    }
    
    @Test
    public void testIntersectCoincide() {
        try {
            List<Point> intersectionPoints = mathService.getIntersectionPoints(square, squareLineCoincide);
            assertTrue(intersectionPoints.size() == 2);
            assertEquals(intersectionPoints.get(0).getP1x(), 3, 0);
            assertEquals(intersectionPoints.get(0).getP1y(), 3, 0);
            assertEquals(intersectionPoints.get(1).getP1x(), 3, 0);
            assertEquals(intersectionPoints.get(1).getP1y(), -3, 0);
        } catch (GeometryException e) {
            fail("Exception not expected");
        }
    }
    
}
