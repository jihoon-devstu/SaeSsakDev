package ex04_map;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
  public static void main(String[] args) {

    // 1. HashMap 객체 생성
    Map<String, Object> map = new HashMap<>();

    // 2. Entry 저장 (Key + Value => Entry)
    map.put("name", "카리나");
    map.put("age", 20);
    map.put("hobbies", new String[] { "축구", "농구", "야구" });

    // 3. Entry 수정 (기존에 사용하던 키를 다시 사용하면 기존에 저장된 값이 수정됨)
    map.put("name", "오해원");

    // 4. 정보 확인 (Value 확인)
    System.out.println(map.get("name"));
    System.out.println(map.get("age"));
    System.out.println(Arrays.toString((String[]) map.get("hobbies")));
    System.out.println(map.getOrDefault("birthday", "생일 정보 없음."));

    // 5. Entry 순회 1 (Key를 이용한 순회 방식)
    for (String key : map.keySet()) {
      System.out.println(key + " : " + map.get(key));
    }

    // 6. Entry 순회 2 (Entry 객체를 이용한 순회 방식 - 추천)
    for (Map.Entry<String, Object> entry : map.entrySet()) {
      System.out.println(entry.getKey() + " : " + entry.getValue());
    }

    // 7. Map.of()
    // 정적 팩토리 메서드 of() : new 대신 사용하는 간편한 객체 생성 메서드
    // 이렇게 만든 Map 객체는 수정 불가능 (Immutable: put() , remove() 등 호출 시 오류 발생 -
    // UnsupportedOperationException)
    Map<String, Object> map2 = Map.of(
        "name", "윈터",
        "age", 30,
        "hobbies", new String[] { "배구", "탁구", "당구" });

    System.out.println(map2);

  }
}
