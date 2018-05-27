package lt.deeper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;


/**
 * Main application class
 * 
 * @author Evaldas Norvaiša
 *
 */
@SpringBootApplication
@EnableAsync
public class DeeperHomeworkApplication {

    public static void main(String[] args) {
        SpringApplication.run(DeeperHomeworkApplication.class, args);
    }
    
}
