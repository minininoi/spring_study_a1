package exam2;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ex01 {
    public static void main (String[] args){
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);

        Message message = ctx.getBean(Message.class);
        message.send("메세지");

        Message message2 = ctx.getBean(Message.class);
        System.out.println(message == message2);

        ctx.close();
    }
}
