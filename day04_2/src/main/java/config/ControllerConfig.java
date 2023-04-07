package config;

import controllers.HelloController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ControllerConfig {  //WebMvcConfigurer 인터페이스  상속
    @Bean
    public HelloController helloController() {
        return new HelloController();
    }

}
