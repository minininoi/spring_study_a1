package config;

import controllers.HelloController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"controllers", "models"}) //controllers 하위 패키지 Scan을 통해 @Bean을 하지 않아도 한번에 객체를 관리한다
public class ControllerConfig {
    @Bean
    public HelloController helloController(){
        return new HelloController();
    }
}
