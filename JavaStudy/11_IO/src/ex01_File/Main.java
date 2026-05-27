package ex01_File;

import java.io.File;
import java.util.Arrays;
import java.util.Date;
import java.util.stream.Stream;

public class Main {

  public static void main(String[] args) {

    // 자바 홈 File 객체로 생성하기
    File javaHome = new File("C:\\Program Files\\Java\\jdk-21.0.10");

    // 기본 정보 확인
    System.out.println("이름: " + javaHome.getName());
    System.out.println("경로: " + javaHome.getPath());
    System.out.println("절대 경로: " + javaHome.getAbsolutePath());
    System.out.println(javaHome.isDirectory() ? "디렉토리입니다." : "파일입니다.");
    System.out.println("파일 크기: " + javaHome.length() + " bytes");
    System.out.println("최종 수정 일: " + javaHome.lastModified());

    // 최종수정일의 날짜 파싱
    Date lastModifiedDate = new Date(javaHome.lastModified());
    System.out.println("최종 수정 날짜: " + lastModifiedDate);

    // 하위 폴더 및 파일 배열로 가져오기
    File[] files = javaHome.listFiles();

    // files 배열을 Stream으로 변환해보기.
    Stream<File> fileStream = Arrays.stream(files);
    //fileStream.forEach(file -> System.out.println("파일 이름: " + file.getName()+", 파일 크기: "+file.length()+" bytes"));
    fileStream.filter(file -> file.isFile())
              .forEach(file -> System.out.println("파일 이름: " + file.getName() + ", 파일 크기: " + file.length() + " bytes"));


    // 디렉터리 조작 (생성 / 삭제)
    File newDir = new File("D:\\saessak\\JavaStudy\\io_test");

    //폴더 생성
    if(newDir.exists()){
      System.out.println(newDir.getAbsolutePath()+" 존재 합니다."); 
    }else{
      newDir.mkdirs(); // 폴더 생성 (mkdirs는 하위 폴더까지 만듬. mkdir는 하위 폴더가 있으면 생성 못함.)
      System.out.println(newDir.getAbsolutePath()+" 폴더가 생성되었습니다.");
    }

    //폴더 삭제
    if(newDir.exists()){
      newDir.delete(); //비어있는 폴더만 지울 수 있음 ! 폴더 안에 파일이나 폴더가 있으면 삭제 안됨.
      System.out.println(newDir.getAbsolutePath()+" 폴더가 삭제되었습니다.");
    }else{
      System.out.println(newDir.getAbsolutePath()+" 존재하지 않습니다.");
    }

  }

}
