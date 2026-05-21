package ex04_this;

public class Main {

  public static void main(String[] args) {
    Car myCar = new Car();
    myCar.addOil(-20);
    myCar.addOil(30);
    System.out.println("현재 기름양 : " + myCar.oil);
  }
}
