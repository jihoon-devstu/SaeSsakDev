package ex01_try_catch;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    // 정수 저장할 변수
    int a, b;

    // 무한 루프
    while (true) {
      try {
        System.out.println("첫 번째 숫자 입력");
        a = sc.nextInt();
        System.out.println("두 번째 숫자 입력");
        b = sc.nextInt();

        System.out.println("몫: " + (a / b) + ", 나머지: " + (a % b));

      } catch (ArithmeticException e) {
        // 예외 처리하는 부분
        // 주요 메서드 : getMessage() - 예외 메시지 반환
        // printStackTrace() - 예외 발생 당시의 호출 스택을 출력
        //System.err.println("예외 사유: " + e.getMessage());
        //System.err.println("0으로 나눌 수 없습니다. 다시 입력해주세요.");
        e.printStackTrace();
      } catch (InputMismatchException e) {
        // 모든 예외를 처리하는 catch 블록
        System.err.println("예외 사유: " + e.getMessage());
        System.err.println("정수만 입력할 수 있습니다.");
      }finally {
        // 예외 발생 여부와 상관없이 항상 실행되는 블록
        // 주로 자원 해제하는 코드 작성
        sc.close();
      }

    }
  }
}
