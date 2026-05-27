package ex03_stream_api;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Main {

  public static void main(String[] args) {

    // 원본 리스트
    List<String> members = Arrays.asList("son", "naymar", "messi", "ronaldo", "iniesta");

    // 원본 리스트를 이용해 Stream 생성
    Stream<String> memberStream = members.stream();

    // 최종 연산
    //memberStream.forEach(member -> System.out.println(member)); // Stream의 요소를 하나씩 출력

    // 중간 연산 + 최종 연산
    memberStream.filter(member -> member.length() > 5) // 이름이 5글자 이상인 요소만 필터링
        .map(member -> member+"님")
        .forEach(member -> System.out.println(member)); // 필터링된 요소를 출력

  }
}
