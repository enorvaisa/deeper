package lt.deeper.exceptions;

/**
 * Custom exception used for geometry validation
 * 
 * @author Evaldas Norvaiša
 *
 */
public class GeometryException extends Exception {

    private static final long serialVersionUID = 1L;
    
    public static final String NOT_SQUARE_EXCEPTION = "Geometry is not square";

    public GeometryException(String message) {
        super(message);
    }
    
}
