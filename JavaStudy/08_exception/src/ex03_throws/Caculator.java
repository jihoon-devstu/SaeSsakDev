package ex03_throws;

public class Caculator {
  /**
   * 
   * @param a
   * @param b
   * @throws ArithmeticException
   */
  public static void divide(String a , String b) throws ArithmeticException {
    int x = Integer.parseInt(a);
    int y = Integer.parseInt(b);
    if (y == 0) {
      throw new ArithmeticException("0으로 나눌 수 없습니다.");
    }
    System.out.println("몫: " + (x / y));
  }

  public static void mod(String a, String b) throws ArithmeticException {
    int x = Integer.parseInt(a);
    int y = Integer.parseInt(b);
    if (y == 0) {
      throw new ArithmeticException("0으로 나눌 수 없습니다.");
    }
    System.out.println("나머지: " + (x % y));
  }

  public int plus(int a, int b) {
    return a + b;
  }

  public int minus(int a, int b) {
    return a - b;
  }
}
