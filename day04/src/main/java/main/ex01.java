package main;

import config.AppCtx;
import lombok.extern.java.Log;
import models.member.Member;
import models.member.MemberDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

@Log
public class ex01 {
    public static void main(String[] args){
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);

        MemberDao memberDao = ctx.getBean(MemberDao.class);

        Member member = new Member();
        member .setUserId("user02");
        member.setUserPw("123456");
        member.setUserNm("사용자03");

        /*
        boolean result = memberDao.insert(member);
        System.out.println("추가 성공 : " + result);
        */

        long userNo = memberDao.insert(member);
        System.out.println("추가 성공 : " + userNo);


        /*
        boolean result = memberDao.delete("user02");
        System.out.println("삭제 성공" + result);
        */

        /*
        List<Member> members =memberDao.get();
        members.stream().forEach(System.out::println);
        */

        /*
        Member member = memberDao.get("user01");
        if(member != null){
        log.info(member.toString());
        }
        */

        /*
        long total = memberDao.getTotal();
        log.info("총 회원 수:  "+ total);
        */

        ctx.close();

    }

}
