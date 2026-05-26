package ex03_set;

import java.util.HashSet;
import java.util.Set;

public class MemberMain {
  public static void main(String[] args) {
    //확인할 사항.
    //1. 중복해서 저장 해 보기 (중복 저장이 안 되어야 정상)
    //2. Contains 메소드로 존재 여부 확인 (동작해야 정상)
    //3. 저장된 객체 정보 출력 확인

    Set<Member> members = new HashSet<>();

    members.add(new Member("홍길동", 20));
    members.add(new Member("홍길동", 20));
    members.add(new Member("홍길동", 20));
    members.add(new Member("홍길동", 20));
    members.add(new Member("김유신", 30));

    Member target = new Member("홍길동", 20);
    if(members.contains(target)) {
      System.out.println("홍길동이 존재합니다.");
    } else {
      System.out.println("홍길동이 존재하지 않습니다.");
    }

    for (Member member : members) {
      System.out.println(member);
    }
  }


}
