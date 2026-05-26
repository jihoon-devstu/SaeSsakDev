package ex02_throw;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    try {
      System.out.println("점수(0~100)를 입력하세요");
      int score = sc.nextInt();
      if (score < 0 || score > 100) {
        throw new RuntimeException(score + "점은 잘못된 입력 입니다. 입력은 0~100 사이여야 합니다.");
      }
      boolean isPass;

      isPass = (score >= 60) ? true : false;

      System.out.println("합격 여부: " + isPass);

    } catch (Exception e) {
      System.out.println(e.getMessage());
    } finally {
      sc.close();
    }

  }

}
