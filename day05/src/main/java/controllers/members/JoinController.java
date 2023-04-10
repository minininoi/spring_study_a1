package controllers.members;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member/join") //member이하 모든 요청 mapping
public class JoinController {
    @GetMapping // /member/join -> /join
    public String join(Model model){
        model.addAttribute("title", "회원가입"); // 속성만 추가
        model.addAttribute("content", "회원가입 내용");
        return "member/join";
    }
    /*
    @PostMapping
    public String joinPs(Join join){
        System.out.println(join);
        return "member/join";
    }
     */
    @PostMapping //커멘드 객체
    public String joinPs(Join join, Model model){
        System.out.println(join);
        return "redirect:/member/login";
    }
}
