package ex04_abstract;

public class Main {
  public static void main(String[] args) {
    Coffee coffee1 = new Espresso("브라질");
    Coffee coffee2 = new Americano("콜롬비아");

    coffee1.taste();
    coffee2.taste();

    //추상 클래스는 객체를 생성할 수 없다. 미완성 상태이기 때문에.
    //Coffee coffee3 = new Coffee("과테말라");

    Coffee coffee3 = new Coffee("과테말라") {
      @Override
      public void taste() {
        System.out.println("커피콩 맛이 납니다.");
      }
    };
    coffee3.taste();

  }

}
