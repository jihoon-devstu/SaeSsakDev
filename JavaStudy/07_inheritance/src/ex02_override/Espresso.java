package ex02_override;

public class Espresso extends Coffee {

  public Espresso(String coffeeBean) {
    super(coffeeBean);
  }
  public void taste(){
    System.out.println("에스프레소는 쓴맛이 납니다.");
  }
  
}
