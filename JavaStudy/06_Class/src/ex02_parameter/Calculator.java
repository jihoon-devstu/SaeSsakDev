package ex02_parameter;

class Main2 {
  public static void main(String[] args) {
    Calculator calculator = new Calculator();

    int result = calculator.add(10, 20);
    System.out.println("결과 : " + result);

    double result2 = calculator.add(10.5, 20.5);
    System.out.println("결과2 : " + result2);

    int result3 = calculator.multiply(2, 3, 4);
    System.out.println("결과3 : " + result3);
  }
}

public class Calculator {
  // 메서드 : 특정 기능을 수행하는 코드 블록

  // 결과 타입 (반환 타입) + 함수 이름 + 매개변수 + { 함수 몸체 }

  int add(int a, int b) {
    return a + b;
  }

  double add(double a, double b) {
    return a + b;
  }

  int multiply(int a, int b, int... numbers) {
    // 가변 인자는 실제로는 배열로 처리 된다.

    int result = a * b;
    for (int number : numbers) {
      result *= number;
    }
    return result;
  }
}
