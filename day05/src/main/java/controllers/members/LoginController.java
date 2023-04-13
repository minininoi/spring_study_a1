package controllers.members;

import lombok.RequiredArgsConstructor;
import models.member.LoginService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.awt.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/member/login")
public class LoginController {
    private  final LoginValidator validator;
    private  final LoginService service;
    @GetMapping
    public String login(Model model, @CookieValue(name = "saveId", required = false) String userId){ //saveId 쿠키에 Cookie 주입

        Login login = new Login();
        if(userId != null){
            login.setUserId(userId);
            login.setSaveId(true);
        }
        model.addAttribute("login", login);
        return "member/login";
    }
    @PostMapping
    public String loginPs(@Valid Login login, Errors errors) {
        validator.validate(login,errors);
        if (errors.hasErrors()) {
            return "member/login";
        }
        //로그인 처리
        service.login(login);
            return "redirect:/"; //로그인 성공시 메인페이지로 이동
    }

}
