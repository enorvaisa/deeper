package lt.deeper.data;

/**
 * Object for storing intersection point information
 * 
 * @author Evaldas Norvaiša
 *
 */
public class Point {
    
    private double p1x;
    private double p1y;
    
    public Point(double p1x, double p1y) {
        this.p1x = p1x;
        this.p1y = p1y;
    }

    public double getP1x() {
        return p1x;
    }

    public void setP1x(double p1x) {
        this.p1x = p1x;
    }

    public double getP1y() {
        return p1y;
    }

    public void setP1y(double p1y) {
        this.p1y = p1y;
    }
    
}
