package ex01_generic_class;

// 제네릭 클래스
// 정해지지 않은 타입 T 를 사용 <- 객체 생성 시점에 타입이 결정됨 (구체화)
public class Box<T> {
  private T content;

  public T getContent() {
    return content;
  }

  public void setContent(T content) {
    this.content = content;
  }
  
}
