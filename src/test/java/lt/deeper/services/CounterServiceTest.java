package lt.deeper.services;


import static org.junit.Assert.*;

import org.junit.Test;

import lt.deeper.services.impl.CounterServiceImpl;

/**
 * CounterService tests
 * 
 * @author Evaldas Norvaiša
 *
 */
public class CounterServiceTest {

    private CounterService counterService = new CounterServiceImpl();
    
    @Test
    public void testSimpleCount() {
        assertEquals(0, counterService.getCount());
        counterService.increaseCount();
        assertEquals(1, counterService.getCount());
        counterService.decreaseCount();
        assertEquals(0, counterService.getCount());
    }
    
}
