package lt.deeper.controllers;

import static org.assertj.core.api.Assertions.assertThat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;
import static lt.deeper.SampleData.*;

/**
 * REST services tests
 * 
 * @author Evaldas Norvaiša
 *
 */
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
public class ControllersTest extends AbstractTestNGSpringContextTests  {

    @Autowired
    private TestRestTemplate restTemplate;
    
    @Test
    public void appErrorControllerUnauthorisedTest() {
        String body = this.restTemplate.getForObject("/anyUrl", String.class);
        assertThat(body).contains("HTTP Status 401 - Full authentication is required to access this resource");
    }
    
    @Test
    public void appErrorControllerPageNotFoundTest() {
        String body = this.restTemplate.withBasicAuth("deeper", "deeper").getForObject("/anyUrl", String.class);
        assertThat(body).contains("Page not found");
    }
    
    @Test(invocationCount = 1000, threadPoolSize = 100)
    public void mathControllerTest() {
        String body = this.restTemplate.getForObject("/getIntersectionPoints?" + squareLineUriParams, String.class);
        assertThat(body).isEqualTo("[{\"p1x\":2.0,\"p1y\":-3.0}]");
    }
    
    @Test
    public void requestControllerTest() {
        String body = this.restTemplate.withBasicAuth("deeper", "deeper").getForObject("/getCurrentRequests?" + squareLineUriParams, String.class);
        assertThat(body).containsOnlyDigits();
        assertThat(Integer.parseInt(body)).isGreaterThanOrEqualTo(0);
    }
    
}
