package com.sesac.ex02_request.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.sesac.ex02_request.dto.UserRequest;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/api/v1/users")
public class RequestController {

  @GetMapping("legacy")
  public void legacy(HttpServletRequest request) {
    String name = request.getParameter("name");
    String strAge = request.getParameter("age");

    int age = 0;
    if (strAge != null && !strAge.isBlank()) {
      age = Integer.parseInt(strAge);
    }
    System.out.println("name: " + name);
    System.out.println("age: " + age);
  }

  @GetMapping("modern")
  public void modern(@RequestParam String name, @RequestParam(required = false, defaultValue = "0") int age) {
    System.out.println("name: " + name);
    System.out.println("age: " + age);
  }

  @GetMapping("ddto")
  public void dto(UserRequest userRequest) {
    System.out.println(userRequest);
    System.out.println(userRequest.toString());
    System.out.println("name: " + userRequest.getName());
    System.out.println("age: " + userRequest.getAge());
  }

  @PostMapping("full")
  public void postMethodName(@RequestBody UserRequest userRequest) {

    System.out.println(userRequest);

  }

  @PostMapping("file")
  public void fileAttach(
      @RequestPart("profile") MultipartFile profile,
      @RequestPart("request") UserRequest userRequest) {
    if (profile.isEmpty()) {
      System.out.println("파일이 첨부되지 않았습니다.");
      return;
    }

    System.out.println("파일명 :" + profile.getOriginalFilename());
    System.out.println("파일 크기 :" + profile.getSize() / 1024 + "KB");
    System.out.println("콘텐츠 타입 :" + profile.getContentType());
    System.out.println("텍스트 데이터 :" + userRequest);

  }
}
