package demo.core;

import demo.core.member.MemberRepository;
import demo.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
// 스프링 빈을 긁어서 자동으로 스프링 빈을 긁어 와야한다. @Componet로 되어 있는 클래스들을 스프링빈으로 자동 등록해준다.
// @Configuration 붙은건 뺄거야(원래는 이렇게 안함. 예제코드를 보존하면서 하려고 붙임.) - Configuration.class - 지금 등록되어있으므로 뺐음. 중복방지
public class AutoAppConfig {
    //의존관계주입 방법? -> @Autowired 를 그래서 붙인다.
    // 컴포넌트 스캔을 사용하게 되면(@Service, @Controller, @Repository등등) 내 빈이 자동으로 등록이 되는데 DI를 할 방법이 없다. 수동 등록 장소가 없다.

    //이 경우 수동 빈이 자동빈을 오버라이딩 해버린다. - 수동 빈등록이 우선권을 가진다.
//    @Bean(name = "memoryMemberRepository") // 같은이름의 빈이 등록이 이미 되어있을때는 스프링이 붙은 상태로 돌릴 경우 스탑.
//    MemberRepository memberRepository(){
//        return new MemoryMemberRepository();
//    }

    // 자바빈 프로퍼티 - 규약 관련 검색
    //  @Autowired(required = false) - 주입할 대상이 없어도 동작하게 하는 방법

    //  생성자 의존관계 주입: 불변,필수 의존관계에 사용
    //  수정자(setter) 의존관계  주입: 선택, 변경 가능성이 있는 의존관계에 사용
    //  필드 의존관계 주입: 코드가 간결해지지만 사용하지 말자. 외부에서 변경이 불가능해서 테스트가 어려워진다.
        // @Configuration 같은 곳에서는 스프링에서만 사용하기 때문에 필드 주입을 사용해도 된다. 하지만 그냥 사용하지 말자

    //  일반 메서드 주입 : 일반적으로 사용하지 않는다.
}
