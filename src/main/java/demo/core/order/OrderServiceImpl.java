package demo.core.order;

import demo.core.annotation.MainDiscountPolicy;
import demo.core.discount.DiscountPolicy;
import demo.core.member.Member;
import demo.core.member.MemberRepository;
import demo.core.member.MemoryMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService {

//     OCP, DIP 위반  - 코드는 기존코드가 그대로여야 한다.
//    필드주입, setter주입, 생성자주입
//    private final MemberRepository memberRepository = new MemoryMemberRepository();
//    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
//    private final DiscountPolicy discountPolicy = new RateDiscountPolicy();
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    //@Autowired // MemberServiceImpl 에서는 이렇게 안함. @RequiredArgsConstructor 씀. 생성자가 딱 1개면 선언 안해도됨
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }


    //싱글톤 깨지는지 테스트용도
    public MemberRepository getMemberRepository(){
        return memberRepository;
    }
}
