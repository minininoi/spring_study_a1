package exam2;

public class Message {
    public void init(){ //초기화
        System.out.println("init!!");
    }
    public void send(String msg) {
        System.out.printf("전송메세지: %s%n", msg);
    }

    public void close(){ //소멸
        System.out.println("close!!");
    }
}
