package config;

import models.member.Member;
import models.member.MemberDao;
import org.springframework.context.annotation.*;

import java.time.format.DateTimeFormatter;

@Configuration
//@ComponentScan(basePackages = "models.member",
//    excludeFilters = @ComponentScan.Filter(type= FilterType.ANNOTATION, classes ={ManualBean.class})) // models.member의 하위 객체에 Bean이 없어도 모든 객체를 자동 생성해준다

@ComponentScan(basePackages = "models.member",
    excludeFilters = {
            @ComponentScan.Filter(type=FilterType.ASSIGNABLE_TYPE,classes = {MemberDao.class}),
            @ComponentScan.Filter(type=FilterType.ASPECTJ, pattern = {"models.member.**Service"})
    })

public class AppCtx3 {
    @Bean
    public DateTimeFormatter dateTimeFormatter(){ // 외부에서 값을 받아온 객체에는 @Bean
        DateTimeFormatter formatter =DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm");
        return formatter;
    }
}
