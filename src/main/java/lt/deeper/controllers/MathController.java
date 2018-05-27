package lt.deeper.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lt.deeper.data.Line;
import lt.deeper.data.Point;
import lt.deeper.data.Square;
import lt.deeper.exceptions.GeometryException;
import lt.deeper.services.MathService;

/**
 * @author Evaldas Norvaiša
 *
 * Math operations controller
 */
@RestController
public class MathController {
    
    @Autowired
    public MathService mathService;
    
    /**
     * Accept as an input information about a square and a line and return information where and if these two objects intersect
     * 
     * @param square Square 4 points coordinates
     * @param line Line 2 points coordinates
     * @return list of intersection points (x,y coordinates) or empty list if none
     * @throws GeometryException
     */
    @RequestMapping(value = "/getIntersectionPoints")
    public List<Point> getIntersectionPoints(@ModelAttribute(value = "square") Square square, @ModelAttribute(value = "line") Line line) throws GeometryException {
        return mathService.getIntersectionPoints(square, line);
    } 
    
    @ExceptionHandler(GeometryException.class)
    public String handleException(GeometryException e) {
        return e.getMessage();
    }
}
