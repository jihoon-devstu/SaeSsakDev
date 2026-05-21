package ex05_constructor;

public class Car {

  //생성자 : 객체 생성할 때만 자동으로 호출되는 특별한 메서드
  //안 만들면 , 자바 컴파일러가 코드를 넣어줌.  -> 기본 생성자 (Default Constructor)

  //핵심 규칙 2가지
  //1. 반환은 없음 -> 반환타입이 없는것이 아니라 , 반환 개념 자체가 없음 2. 메서드명이 클래스명과 동일해야 함

  //필드 선언
  String model;

  Car() {
    this("3시리즈"); //생성자에서 다른 생성자 호출하기 -> 생성자 오버로딩
  }

  public Car(String model) {
    this.model = model;
  }



}
