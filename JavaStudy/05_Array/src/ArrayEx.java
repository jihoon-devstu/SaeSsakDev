public class ArrayEx {
  public static void main(String[] args) {
    // 배열 선언
    String[] blackPink;
    // 배열 생성
    blackPink = new String[4];

    // 배열 요소 (Element : 각 변수를 의미)
    blackPink[0] = "지수";
    blackPink[1] = "제니";
    blackPink[2] = "로제";
    blackPink[3] = "리사";

    // 배열 요소 출력
    System.out.println(blackPink[0]);
    System.out.println(blackPink[1]);
    System.out.println(blackPink[2]);
    System.out.println(blackPink[3]);

    // 배열 for문 출력
    for (int i = 0; i < blackPink.length; i++) {
      System.out.println(blackPink[i]);
    }
  }
}
