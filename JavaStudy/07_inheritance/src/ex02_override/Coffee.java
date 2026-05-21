package ex02_override;

public class Coffee {
  private String coffeeBean;

  public Coffee(String coffeeBean) {
    this.coffeeBean = coffeeBean;
  }

  void taste() {
    System.out.println("커피는 맛이 납니다.");
  }

  // 커피 정보 출력 메서드
  public void info(){
    System.out.println("커피 원두 원산지: " + coffeeBean);
  }

}
