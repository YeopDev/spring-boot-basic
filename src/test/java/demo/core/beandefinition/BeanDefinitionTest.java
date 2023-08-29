package demo.core.beandefinition;

import demo.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class BeanDefinitionTest {

//    AnnotationConfigApplicationContext ac =  new AnnotationConfigApplicationContext(AppConfig.class);

    // 애는 제네릭 빈이라고 해서 명확하게 되어있음.
    // 팰토리메서드 등이 빠져있다.
    // 자바컨피그로 바뀌면서 - AnnotationConfigApplicationContext
    GenericXmlApplicationContext ac = new GenericXmlApplicationContext("appConfig.xml");

//    ApplicationContext ac = new GenericXmlApplicationContext("appConfig.xml"); //ac.getBeanDefinition() 등등을 사용못함. 다른 인터페이스가 있어야함.

    @Test
    @DisplayName("빈 설정 메타정보 확인")
    void findApplicationBean(){
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);

            if(beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION){
                System.out.println("beanDefinitionName = " + beanDefinitionName + " beanDefinition = "  + beanDefinition);
            }
        }
    }
}
