package ex02_output;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

public class Main {
  public static void main(String[] args) {
    
    // File 객체 (우리가 만드려는 대상)
    File dir = new File("/storage");

    if(!dir.exists()){
      dir.mkdir(); // 디렉토리 생성
      System.out.println("디렉토리가 생성되었습니다.");
    }

    File file = new File(dir, "test.txt"); // 디렉토리 안에 test.txt 파일 객체 생성
    
    // 파일로 데이터를 보내는 스트림 : 통로 (출력 스트림)
    try(BufferedOutputStream fos = new BufferedOutputStream(new FileOutputStream(file, true))) { 
      // true는 이어쓰기 옵션 (파일이 이미 존재할 때 기존 내용 뒤에 새 내용 추가)

      //실제로 데이터 내보내기
      int c = 'A'; // 문자 A의 유니코드 값 (65)
      byte[] b = "pple".getBytes(); // 문자열을 바이트 배열로 변환

      fos.write(c); // A 문자 하나를 파일에 기록
      fos.write(b); // "pple" 문자열을 파일에 기록

    } catch (Exception e) {
      e.printStackTrace();
    }

  }


}
