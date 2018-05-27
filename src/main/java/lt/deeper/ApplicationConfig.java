package lt.deeper; 

import javax.servlet.Filter;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;  
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;  
import org.springframework.security.config.annotation.web.builders.HttpSecurity;  
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;  
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.filter.AbstractRequestLoggingFilter;

import lt.deeper.services.CounterService;  

/**
 * Aplication configuration
 * 
 * @author Evaldas Norvaiša
 *
 */
@Configuration  
@EnableWebSecurity  
public class ApplicationConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private CounterService counterService;
    
    @Autowired
    private BasicAuthenticationPoint basicAuthenticationPoint;

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {  
        http.csrf().disable();
        // permit all only on /getIntersectionPoints url, others require authentication
        http.authorizeRequests().antMatchers("/getIntersectionPoints").permitAll().anyRequest().authenticated();
        http.httpBasic().authenticationEntryPoint(basicAuthenticationPoint);
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("deeper").password(passwordEncoder().encode("deeper")).roles("USER");
    }
    
    @Bean
    public Filter counterFilter(){
        return new AbstractRequestLoggingFilter() {

            @Override
            protected void beforeRequest(HttpServletRequest request, String message) {
                counterService.increaseCount();
            }

            @Override
            protected void afterRequest(HttpServletRequest request, String message) {
                counterService.decreaseCount();
            }
        };
    }
 }