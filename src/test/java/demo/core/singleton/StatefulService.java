package demo.core.singleton;

public class StatefulService {
//    private int price; // 상태를 유지하는 필드

    // 공유 필드는 무상태로(stateless) 로 설계해야한다!

    public int order(String name, int price){
        System.out.println("name = " + name + " price = " + price);
//        this.price = price;//여기가 문제 !
        return price;
    }

//    public void order(String name, int price){
//        System.out.println("name = " + name + " price = " + price);
//        this.price = price;//여기가 문제 !
//    }

//    public int getPrice(){
//        return price;
//    }
}
