package models.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Service
public class InfoService {
    @Autowired
    private Optional<MemberDao> opt;
    private DateTimeFormatter formatter;

    public void print(String userId) {
        MemberDao memberDao = opt.get();



        Member member = memberDao.get(userId);
        if (formatter != null) {
            String dateStr = formatter.format(member.getRegDt());
            member.setRegDtStr(dateStr);
        }
        System.out.println(member);
    }
       // @Autowired(required = false) //null 값이 있어도 허용
    @Autowired
        public void setFormatter (@Nullable DateTimeFormatter formatter){
            this.formatter = formatter;

    }
}
