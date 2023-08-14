package demo.core.member;

import demo.core.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class MemberServiceTest {

    //    MemberService memberService = new MemberServiceImpl();
    MemberService memberService;

    //실행 전 실행
    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }

//    @ParameterizedTest
//    @ValueSource
//    @DisplayName()
    @Test
    void join() {
        //given 이러이러한 일
        Member member = new Member(1L, "memberA", Grade.VIP);

        //when 이렇게 됐을때
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        //then 이렇게 된다
        Assertions.assertThat(member).isEqualTo(findMember);
    }
}
