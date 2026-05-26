package ex01_generic_class;

public class Main {

  public static void main(String[] args) {

    // 타입을 결정한 뒤 객체 생성
    Box<String> box1 = new Box<>();
    // 타입이 결정된 이후에는 문법적으로 String만 지원함.
    box1.setContent("Hello");
    System.out.println(box1.getContent());

    //제네릭 타입은 오직 참조타입만 가능하다. (기본 값이 필요한 경우엔 Wrapper 클래스를 사용한다.)
    Box<Integer> box2 = new Box<>();
    box2.setContent(100);
    System.out.println(box2.getContent());

  }

}
