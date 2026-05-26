package ex04_abstract;

public class Americano extends Espresso {

  public Americano(String coffeeBean) {
    super(coffeeBean);
  }

  @Override
  public void taste() {
    System.out.println("아메리카노는 쓴맛과 신맛이 납니다.");
  }

}
