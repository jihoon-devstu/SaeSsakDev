package ex02_override;

public class Main {
  public static void main(String[] args) {
    Coffee coffee1 = new Espresso("브라질");
    Coffee coffee2 = new Americano("콜롬비아");

    
    coffee1.taste();
    coffee2.taste();

  }

}
