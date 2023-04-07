package exam;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Message implements InitializingBean, DisposableBean {
    public void send(String msg){
        System.out.printf("전송메시지: %s%n", msg);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("AfterPropertySet!!");
    }

    @Override
    public void destroy() throws Exception { // 객체 소멸 전 자원 정의
        System.out.println("Destroy");
    }

    //직접 정의 할 수 없는 경우

}
