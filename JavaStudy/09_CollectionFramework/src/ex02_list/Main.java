package ex02_list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    // 배열 리스트 (ArrayList)
    List<String> list = new ArrayList();
    list.add("홍길동");
    list.add("김유신");
    list.add("강감찬");
    System.out.println(list);
    System.out.println(list.get(0));
    System.out.println(list.size());

    String removed = list.remove(1);
    System.out.println(removed);

    boolean removed2 = list.remove("강감찬");
    System.out.println(removed2);

    for (int i = 0 , length = list.size(); i < length; i++) {
      System.out.println(list.get(i));
    }

    for (String name : list) {
      System.out.println(name);
    }

    // 연결 리스트 (LinkedList)
    List<String> linkedList = new LinkedList();
    linkedList.add("홍길동");
    linkedList.add("김유신");
    linkedList.add("강감찬");
    System.out.println(linkedList);
  }
}
