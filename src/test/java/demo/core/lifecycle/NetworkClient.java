package demo.core.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class NetworkClient{

    private String url;

    public NetworkClient(){
        System.out.println("생성자 호출, url = " + url);
    }

    //외부에서 setter 로 넣을 수 있게
    public void setUrl(String url){
        this.url = url;
    }

    //서비스 시작 시 호출 -> connenct로 이 url에 붙어 라는 의미
    public void connect(){
        System.out.println("connect = " + url);
    }

    public void call(String message){ // 연결한 서버에 메시지를 던짐.
        System.out.println("call = " + url + " message = " + message);
    }

    //서비스 종료 시 호출
    public void disconnect(){
        System.out.println("close " + url);
    }

    //이 방법으로 초기화 , 종료 하자.
    @PostConstruct // 생성이 된 이후 호출 -> 스프링 권장 어노테이션
    public void init() { //의존관계 주입이 끝나면 호출
        System.out.println("NetworkClient.init");
        connect();
        call("초기화 연결 메시지");
    }

    @PreDestroy // 소멸 되기 전 호출 -> 스프링 권장 어노테이션
    public void close() { //disconnect를 호출
        System.out.println("NetworkClient.close");
        disconnect();
    }
}
