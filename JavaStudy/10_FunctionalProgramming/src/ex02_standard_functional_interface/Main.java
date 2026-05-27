package ex02_standard_functional_interface;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {

  public static void main(String[] args) {

    executeConsumer("권진아", name -> System.out.println("이름: "+name));
    executeSupplier(() -> "케이시");
    executeFunction("안녕하세요", s -> s.length());
    executePredicate(10, n -> n > 5);
  }

  /**
   * 
   * @param param 람다식에 전달할 매개변수
   * @param predicate 값(param)을 받아서 처리한 후 true 또는 false를 반환하는 함수 (람다식)
   */
  public static void executePredicate(Integer param, Predicate<Integer> predicate) {
    boolean result = predicate.test(param);
    System.out.println("결과: "+result);
  }


/**
 * 
 * @param param 람다식에 전달할 매개변수
 * @param function 값(param)을 받아서 처리한 후 결과를 반환하는 함수 (람다식)
 */
  public static void executeFunction(String param, Function<String, Integer> function) {
    Integer result = function.apply(param);
    System.out.println("결과: "+result);
  }

  /**
   * Supplier를 실행하는 메서드
   * @param supplier 값을 반환하는 함수 (람다식)
   */
  public static void executeSupplier(Supplier<String> supplier) {
    String value = supplier.get();
    System.out.println("value: "+value);
  }

  /**
   * 
   * @param param 람다식에 전달할 매개변수
   * @param consumer 값(param)을 받아서 사용하는 함수 (람다식)
   */
  public static void executeConsumer(String param, Consumer<String> consumer) {
    consumer.accept(param);
  }
}
