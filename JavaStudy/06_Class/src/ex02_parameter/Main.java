package ex02_parameter;

public class Main {

  public static void main(String[] args) {
    Car myCar = new Car();
    myCar.goToGasStation(50);

    myCar.drive("서울");

    System.out.println("현재 연료량 : "+ myCar.oil);
  }
}
