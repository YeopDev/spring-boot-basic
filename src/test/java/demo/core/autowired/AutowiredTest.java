package demo.core.autowired;

import demo.core.member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;

import java.util.Optional;

public class AutowiredTest {

    // Autowired 옵션처리
    @Test
    void AutowiredOption(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class); // 요렇게 하면 그냥 스프링빈으로 등록함. 컴포넌트 스캔처럼
        
    }
    
    static class TestBean{

        @Autowired(required = false) // 의존관계가 없으면 메서드 자체가 호출이 안됨 (수정자 메서드)
        public void setNoBean1(Member noBean1){
            System.out.println("noBean1 = " + noBean1);
        }

        @Autowired
        public void setNoBean2(@Nullable Member noBean2){ // 호출은 되나 Null로 들어옴
            System.out.println("noBean2 = " + noBean2);
        }

        @Autowired
        public void setNoBean2(Optional<Member> noBean3){ // 없다면 Optional.empty 로 나옴
            System.out.println("noBean3 = " + noBean3);
        }
    }
}
