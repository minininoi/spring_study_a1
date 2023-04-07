package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller //요청 spring  관리 객체
public class HelloController {
    @GetMapping("/hello")
    public String hello(){
        return "hello";  // /WEB-INF/view/hello.jsp 경로
    }
}
