package lt.deeper.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lt.deeper.services.CounterService;

/**
 * @author Evaldas Norvaiša
 *
 * Requests counter controller
 */
@RestController
public class RequestController {

    @Autowired
    private CounterService counterService;
    
    /**
     * Resturns information about how many requests are currently beying processed by the application
     * 
     * @return Number of requests
     */
    @RequestMapping(value = "/getCurrentRequests")
    public int getCurrentRequests() {
        return counterService.getCount();
    }
    
}
