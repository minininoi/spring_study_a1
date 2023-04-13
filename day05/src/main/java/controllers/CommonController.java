package controllers;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice("controllers") //컨트롤러 공통 예외처리
public class CommonController {
        @ExceptionHandler(RuntimeException.class)
        public String errorHandler(RuntimeException e, Model model){
            e.printStackTrace();
            model.addAttribute("message", e.getMessage());
            return "errors/common";
        }
}
