package lt.deeper.controllers;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Evaldas Norvaiša
 * 
 * Error handling controller
 *
 */
@RestController
public class AppErrorController implements ErrorController  {
    
    @RequestMapping(value = "/error")
    public String error() {
        return "Page not found";
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }

}
