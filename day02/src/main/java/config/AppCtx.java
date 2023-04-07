package config;

import models.member.InfoService;
import models.member.JoinService;
import models.member.ListService;
import models.member.MemberDao;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import javax.swing.text.DateFormatter;
import java.time.DateTimeException;
import java.time.format.DateTimeFormatter;

@Configuration
//@Import({AppCtx2.class})
public class AppCtx {
    @Bean //=> AppCtx2
    public MemberDao memberDao(){
        return new MemberDao();
    }
    @Bean
    public JoinService joinService(){
//        JoinService joinService = new JoinService();
//        joinService.setMemberDao(memberDao());
//        return new JoinService();
        return new JoinService();
    }
    @Bean
    public ListService listService(){
        return new ListService();
    }

    @Bean
    public InfoService infoService(){
        return new InfoService();
    }

    @Bean
    public DateTimeFormatter dateTimeFormatter(){
        DateTimeFormatter formatter =DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm");
        return formatter;
    }
}
