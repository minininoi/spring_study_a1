package Interceptors;

import models.member.Member;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MemberOnlyInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        request.setAttribute("commonData","공통데이터");

        HttpSession session = request.getSession(); //세션 가져오기
        Member member = (Member)session.getAttribute("member");
        if(member != null){ //회원인 경우
            return true;
        }
        //비회원-> 로그인페이지로 이동,  request.getContextPath
        response.sendRedirect(request.getContextPath() + "member/login");
        return false;
    }
}
