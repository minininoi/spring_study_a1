package exam01;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ex01 {
    public static void main(String[] args){
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);
        Hello hello = ctx.getBean("hello", Hello.class);
        hello.greet("이이름");

        Hello hello2 = ctx.getBean("hello", Hello.class);
        hello2.greet("김이름");

        System.out.println(hello == hello2); // 동일성 비교 => 싱글톤패턴으로 관리 (동일한 객체 반환)

        ctx.close();
    }
}
