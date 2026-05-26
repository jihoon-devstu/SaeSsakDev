package ex03_throws;

public class Main {
  public static void main(String[] args) {
    
    try {
      String a = "10.5";
      String b = "3";     
      Caculator.divide(a, b);
      Caculator.mod(a, b);
    } catch (Exception e) {
      System.out.println("예외 처리: " + e.getMessage());
    }
  }
}
