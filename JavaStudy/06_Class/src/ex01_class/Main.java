package ex01_class;

public class Main {
  public static void main(String[] args) {
    // 클래스를 타입으로 가지는 변수는 "객체" 이다.
    /*
     * 객체 사용 순서
     * 1. 객체 선언
     * 2. 객체 생성 (동적 할당)
     * 3. 객체 사용
     */

    /*
     * 패키지 명시를 안 해도 되는 3가지 경우
     * 1. 같은 패키지에 있는 클래스
     * 2. java.lang 패키지에 있는 클래스
     * 3. import 문으로 명시한 클래스
     */

    Car myCar; // 객체 선언
    myCar = new Car(); // 객체 생성 (동적 할당)
    myCar.model = "페라리";
    myCar.price = 100000000;

    System.out.println(myCar.model);
    System.out.println(myCar.price);

  }
}
