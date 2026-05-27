package ex03_input;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

public class Main {
  public static void main(String[] args) {

    // File 객체 (우리가 읽으려는 대상)
    File dir = new File("/storage");
    File file = new File(dir, "test.txt"); // 디렉토리 안에 test.txt 파일 객체 생성

    // 파일로 데이터를 읽는 스트림 : 통로 (입력 스트림)
    try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file))) {

      // 어떤 단위로 읽어들일 것인지 결정. (int : 1 byte 단위로 읽기 , byte[] : 여러 byte 단위로 읽기)

      byte[] buffer = new byte[3]; // 3 byte 단위로 읽기 위한 버퍼 (임시 저장소)

      // 실제로 읽은 바이트 수
      int readBytes = 0;
      // 파일이 끝날 때 까지 읽어오기 파일이 끝나면 -1 반환
      while ((readBytes = bis.read(buffer)) != -1) { // 버퍼에 3 byte 읽어서 저장, 읽은 바이트 수 반환
        // 실제로 읽은 바이트 수 만큼 처리
        System.out.println("읽은 바이트 수: " + new String(buffer, 0, readBytes));

      }

    } catch (Exception e) {
      e.printStackTrace();
    }

  }

}
