package demo.core.singleton;

public class SingletonService {
    //싱글톤 패턴 적용
    // 구현하는 방법은 많은데 -객체를 미리 생성해두는 가장 단순하고 안전한 방법 - 아래 방법
    // 1. static 영역에 객체를 딱 1개만 생성해둔다.
    private static final SingletonService instance = new SingletonService();
    // 자기 자신을 인스턴스로 생성해서 하나만 씀.
    // 이렇게 선언하면 static 영역에 하나만 생성됨.

    //2. public 으로 열어서 객체 인스턴스가 필요하면 이 static 메서드를 통해서만 조회하도록 허용한다.
    public static SingletonService getInstance(){
        return instance;
    }

    //3. 생성자를 private 으로 선언해서 외부에서 new 키워드를 사용한 객체 생성을 못하게 막는다.
    private SingletonService(){
        
    }
    
    // 싱글톤 패턴 문제점
    // 코드에 위에 3개를 미리 넣어둬야한다.

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }
}
