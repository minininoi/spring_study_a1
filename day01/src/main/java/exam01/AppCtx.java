package exam01;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // 객체 어떻게 관리하는지 알려주기 위한 설정
public class AppCtx {
    @Bean // 생성한 객체를 관리
    public Hello hello(){
        Hello hello = new Hello();
        return hello;
    }

}
