package models.member;

import config.ManualBean;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//데이터에 직접 접근 가능한 클래스
@Component
@ManualBean // 수동으로 Bean을 입력해야한다
public class MemberDao {
    private static Map<String, Member> members = new HashMap<>(); // key, value가 String 형태의 map
    public void insert(Member member){
        member.setRegDt(LocalDateTime.now());
        members.put(member.getUserId(), member);
    }
    public Member get(String userId ){
        return  members.get(userId);
    }

    public List<Member> gets(){ //map -> list
        List<Member> list = new ArrayList<>(members.values());
        return list;
    }


}
