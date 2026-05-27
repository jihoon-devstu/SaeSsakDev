package ex03_stream_api;

import java.util.Arrays;
import java.util.List;

public class ArticleMain {
  public static void main(String[] args) {
    List<Article> articles = Arrays.asList(
      new Article("오늘 날씨" , 15),
      new Article("이란전쟁" , 150),
      new Article("GTX-A 철근" , 200),
      new Article("스타벅스" , 50),
      new Article("메가커피" , 300)
    );

    //Stream Api를 이용해서 조회수가 100 이상인 기사의 제목을 리스트에 저장.
    List<String> titles = articles.stream() // Stream<Article> 생성
        .filter(article -> article.getViews() >= 100) // 조회수가 100 이상인 기사만 필터링
        .map(article -> article.getTitle()) // Article에서 제목만 추출하여 Stream<String> 생성
        .toList(); // Stream<String>을 List<String>으로 변환
    System.out.println(titles);
  }

}
