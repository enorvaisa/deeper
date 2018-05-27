package lt.deeper.services.impl;

import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Service;

import lt.deeper.services.CounterService;

/**
 * CounterService implementation
 * 
 * @author Evaldas Norvaiša
 *
 */
@Service
public class CounterServiceImpl implements CounterService {

    private AtomicInteger counter = new AtomicInteger(0);
    
    @Override
    public void increaseCount() {
        counter.incrementAndGet();
    }
    
    @Override
    public void decreaseCount() {
        counter.decrementAndGet();
    }
    
    @Override
    public int getCount() {
        return counter.get();
    }
    
}
