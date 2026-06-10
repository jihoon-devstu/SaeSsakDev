package com.sesac.response.controller;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class ResponseController {

  // JSON 문자열 응답
  @GetMapping("/v26")
  public String responseString() {
    String jsonString = "{\"name\":\"홍길동\",\"age\":\"50\"}";
    return jsonString;

  }

  @GetMapping("/v6")
  public ResponseEntity<Map<String, String>> responseEntity() {

    // return ResponseEntity.ok(new UserResponse("제시카", 20));

    return ResponseEntity.badRequest().body(Map.of("message", "잘못된 요청입니다."));
  }

}
