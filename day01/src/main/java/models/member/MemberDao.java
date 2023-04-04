package models.member;

import java.util.HashMap;
import java.util.Map;

// 데이터에 접근 할 수 있는 클래스
public class MemberDao {
    private static Map<String, Member> members = new HashMap<>();

    public void insert(Member member){

        members.put(member.getUserId(), member);
    }
    public Member get(String userId){

        return members.get(userId);
    }

}
