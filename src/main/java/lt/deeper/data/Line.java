package lt.deeper.data;

/**
 * Object for storing line information
 * 
 * @author Evaldas Norvaiša
 *
 */
public class Line {
    
    private double lp1x;
    private double lp1y;
    private double lp2x;
    private double lp2y;
    
    public Line(double lp1x, double lp1y, double lp2x, double lp2y) {
        this.lp1x = lp1x;
        this.lp1y = lp1y;
        this.lp2x = lp2x;
        this.lp2y = lp2y;
    }

    public double getLp1x() {
        return lp1x;
    }

    public void setLp1x(double lp1x) {
        this.lp1x = lp1x;
    }

    public double getLp1y() {
        return lp1y;
    }

    public void setLp1y(double lp1y) {
        this.lp1y = lp1y;
    }

    public double getLp2x() {
        return lp2x;
    }

    public void setLp2x(double lp2x) {
        this.lp2x = lp2x;
    }

    public double getLp2y() {
        return lp2y;
    }

    public void setLp2y(double lp2y) {
        this.lp2y = lp2y;
    }
    
}
