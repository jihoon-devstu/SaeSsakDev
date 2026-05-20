package ex02_parameter;

public class Car {
  int oil;

  // 메서드 : 특정 기능을 수행하는 코드 블록

  // 결과 타입 (반환 타입) +  함수 이름 + 매개변수 + { 함수 몸체 }

  void goToGasStation(int fuel) {
    oil += fuel;
    System.out.println("현재 연료량 : "+ oil);
  }

  void drive(String city) {
    oil -= 10;
    System.out.println(city +"에서 운전하다.");
  }

}
