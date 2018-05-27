package lt.deeper.services;

/**
 * Service used for counting
 * 
 * @author Evaldas Norvaiša
 *
 */
public interface CounterService {

    /**
     * Increase current counter
     */
    void increaseCount();
    
    /**
     * Decrease current counter
     */
    void decreaseCount();
    
    /**
     * get current counter value
     * 
     * @return integer value
     */
    int getCount();
    
}
