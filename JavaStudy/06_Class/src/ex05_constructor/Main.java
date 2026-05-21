package ex05_constructor;

public class Main {

  public static void main(String[] args) {
    // Car 객체 생성 시 "생성자" 가 호출됨.
    Car myCar = new Car("그랜저");
    Car momCar = new Car("벤츠");
    System.out.println("myCar의 모델: " + myCar.model);
    System.out.println("momCar의 모델: " + momCar.model);
  }
}
