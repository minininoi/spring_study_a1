package controllers.members;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class LogoutController {
    @RequestMapping("/member/logout")
    public String logout(HttpSession session){ //로그아웃시 세션 필요
        session.invalidate(); //세션 제거
        return "redirect:/member/login";
    }
}
