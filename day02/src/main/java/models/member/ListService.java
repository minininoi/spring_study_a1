package models.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListService {
    @Autowired //AppCtx의 Bean 객체를 주입해준다
    //@Qualifier("memberDao2") //AppCtx의 memberDao2임을 명확하게 알려준다
    private MemberDao memberDao;
    public ListService(){}

    public ListService(MemberDao memberDao){
        this.memberDao = memberDao;
    }
    public void print(){
        List<Member> members = memberDao.gets();
        members.stream().forEach(System.out::println);
    }


}
