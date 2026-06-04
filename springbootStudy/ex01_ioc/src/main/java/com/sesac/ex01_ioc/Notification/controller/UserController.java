package com.sesac.ex01_ioc.Notification.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sesac.ex01_ioc.Notification.service.EmailNotificationService;
import com.sesac.ex01_ioc.Notification.service.SmsNotificationService;
import com.sesac.ex01_ioc.dto.UserDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class UserController {

  @Qualifier("EmailNotificationService")
  private final EmailNotificationService emailNotificationService;
  @Qualifier("SmsNotificationService")
  private final SmsNotificationService smsNotificationService;
  private final ObjectMapper objectMapper;

  @RequestMapping("/join")
  public void createUser() {
    emailNotificationService.sendNotification("반갑습니다!");
  }

  @RequestMapping("/modify")
  public void modifyUser() {
    emailNotificationService.sendNotification("회원 정보가 수정되었습니다.");
  }

  // ObjectMapper 동작 테스트
  @RequestMapping("/json-test")
  public void jsonTest() {
    try {
      UserDto userDto = new UserDto("홍길동", 30);
      String jsonString = objectMapper.writeValueAsString(userDto);
      System.out.println("JSON String: " + jsonString);

      String inputJson = "{\"name\":\"김철수\",\"age\":25}";
      UserDto deserializedUser = objectMapper.readValue(inputJson, UserDto.class);
      System.out.println("Deserialized User: " + deserializedUser);

    } catch (Exception e) {
      e.printStackTrace();
      System.err.println("[예외 발생 사유] : " + e.getMessage());
    }
  }
}
