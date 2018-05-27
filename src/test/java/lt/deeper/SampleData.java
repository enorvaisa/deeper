package lt.deeper;

import lt.deeper.data.Line;
import lt.deeper.data.Square;

/**
 * Sample data for tests
 * 
 * @author Evaldas Norvaiša
 *
 */
public class SampleData {
    
    public static Square square = new Square(-3, -3, -3, 3, 3, 3, 3, -3);
    
    // no intersections
    public static Line squareLine0Points = new Line(5, -5, 6, -6);
    // intersect at (2, -3)
    public static Line squareLine1Point = new Line(0, -1, 3, -4);
    // intersect at (-3, 2)(2, -3)
    public static Line squareLine2Points = new Line(-4, 3, 3, -4);
    // intersect at (3, 3) (3, -3). Points where coincide starts and ends
    public static Line squareLineCoincide = new Line(3, 4, 3, -4);
    
    public static Square rectangle = new Square(-4, -3, -4, 3, 4, 3, 4, -3);
    public static Square rhombus = new Square(-3, 0, 0, 4, 3, 0, 0, -4);
    
    public static String squareLineUriParams = "sp1x=-3&sp1y=-3&sp2x=-3&sp2y=3&sp3x=3&sp3y=3&sp4x=3&sp4y=-3&lp1x=0&lp1y=-1&lp2x=3&lp2y=-4"; 
    
}
