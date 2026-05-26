package ex04_abstract;

public abstract class Coffee {
  private String coffeeBean;

  public Coffee(String coffeeBean) {
    this.coffeeBean = coffeeBean;
  }

  public abstract void taste();

  // 커피 정보 출력 메서드
  public void info(){
    System.out.println("커피 원두 원산지: " + coffeeBean);
  }

}
