package models.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class JoinService {

    private MemberDao memberDao;
    @Autowired //의존성 컨테이너에 MemberDao가 존재 하면 주입만해준다
    public void setMemberDao(MemberDao memberDao){
        this.memberDao = memberDao;
    }

    public void join(Member member){
        memberDao.insert(member);
    }
}
