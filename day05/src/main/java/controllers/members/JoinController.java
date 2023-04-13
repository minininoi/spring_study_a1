package controllers.members;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import models.member.JoinService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/member/join") //member이하 모든 요청 mapping
@RequiredArgsConstructor //final, @NonNull이 있는 멤버변수 초기화 생성자
public class JoinController {

    private final JoinValidator validator;
    private final JoinService service;
    //@RequiredArgsConstructor, 멤버 변수 중에서 final이 있고 초기 값이 없는 경우 주입된다
//    public JoinController(Validator validator){
//        this.validator = validator;
//    }
    @GetMapping // /member/join -> /join
    public String join(Model model){
        Join join = new Join();
        model.addAttribute("join", join);
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
    public String joinPs(@Valid Join join, Errors errors, Model model){ //Join 검증 후 Error
        System.out.println(join);
        validator.validate(join, errors);

        if(errors.hasErrors()){
            //에러가 있으면 처리하지 않고 -> 양식
            return "member/join";
        }

            service.join(join);
            // 성공시 -> 회원 로그인
            return "redirect:/member/login";
    }
}
