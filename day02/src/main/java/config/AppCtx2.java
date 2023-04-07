package config;

import models.member.MemberDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppCtx2 {
    @Bean
    public MemberDao memberDao(){
        return new MemberDao();
    }
}
