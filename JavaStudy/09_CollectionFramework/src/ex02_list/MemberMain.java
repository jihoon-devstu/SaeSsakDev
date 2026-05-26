package ex02_list;

import java.util.ArrayList;
import java.util.List;

public class MemberMain {

  public static void main(String[] args) {
    
    //1. ArrayList  생성
    List<Member> members = new ArrayList();

    //2. 요소 추가
    members.add(new Member("홍길동", 20));
    members.add(new Member("김유신", 30));
    members.add(new Member("강감찬", 40));
    members.add(new Member("이순신", 50));

    //3. 요소 출력
    System.out.println(members.get(0));
    System.out.println(members.get(1));
    System.out.println(members.get(2));
    System.out.println(members.get(3));

    //4. 요소 삭제
    boolean isRemoved = members.remove(new Member("김유신", 30));
    System.out.println(isRemoved ? "삭제 성공" : "삭제 실패");
    
    //5. 요소 존재 여부 확인
    Member target = new Member("이순신", 50);
    if(members.contains(target)) {
      System.out.println("이순신이 존재합니다.");
    } else {
      System.out.println("이순신이 존재하지 않습니다.");
    }

    //6. for 문 순회
    for (int i = 0, length = members.size(); i < length; i++) {
      Member foundMember = members.get(i);
      System.out.println("이름 : "+ foundMember.getName() + ", 나이 : " + foundMember.getAge());
    }

  }
}
