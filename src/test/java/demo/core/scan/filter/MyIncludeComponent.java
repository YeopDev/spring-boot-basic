package demo.core.scan.filter;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyIncludeComponent {
    // @MyIncludeComponent 라는 어노테이션이 붙은 애는 컴포넌트스캔에 추가할거야
}
