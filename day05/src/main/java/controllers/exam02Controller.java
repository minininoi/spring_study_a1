package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class exam02Controller {
    @GetMapping("/ex01")
    public String ex01(){
        boolean result= false;
        if(!result){
            throw new RuntimeException("예외 발생");
        }
        return "mypage/index";
    }

    //매번 오류 발생시 컨트롤러 마다 추가하기가 힘들다
    @ExceptionHandler(RuntimeException.class)
    public String errorHandler(RuntimeException e, Model model){
        e.printStackTrace();
        model.addAttribute("message", e.getMessage());
        return "errors/common";
    }


}
