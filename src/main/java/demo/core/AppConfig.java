package demo.core;

import demo.core.discount.DiscountPolicy;
import demo.core.discount.FixDiscountPolicy;
import demo.core.discount.RateDiscountPolicy;
import demo.core.member.MemberRepository;
import demo.core.member.MemberService;
import demo.core.member.MemberServiceImpl;
import demo.core.member.MemoryMemberRepository;
import demo.core.order.OrderService;
import demo.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    // @Configuration 과 싱글톤
    // @Bean memberService -> new MemoryMemberRepository()
    // @Bean orderService -> new MemoryMemberRepository()
    // 두번 호출되면 싱글톤이 깨지는게 아닌가? -> 이럴경우에는 그냥 테스트코드를 돌려본다.
    // memberRepository 메서드가 총 3번의 호출이 되어야 될거 같지만 1번만 호출됨

    //@Configuration 을 안붙이고 @Bean을 컨테이너로 올리면 싱글톤이 깨진다.

    //@Autowird MemberRepository memberRepository; // @Configuration 어노테이션을 안붙일때 -> 스프링이 컨테이너에서 끌어와서 자동으로 주입해줌.

    // @Bean만 사용해도 스프링 빈으로 등록되지만, 싱글톤을 보장하지 않는다.
    //크게 고민할 것 없다. 스프링 설정 정보는 항상 @Configuration을 사용하자.


    /**
     * 생성자 주입
     * 역할이 드러남.
     */
    @Bean // Bean(name="mmm") 이런식으로 이름을 변경할 수 있다.
    public MemberService memberService() {
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy(){
        // 정액할인 정책
//        return new FixDiscountPolicy();
        // 정률할인 정책
        return new RateDiscountPolicy();
    }
}
