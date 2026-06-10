package com.example.ex07_mybatis.dto;

import java.time.LocalDateTime;

import com.example.ex07_mybatis.domain.User;

import lombok.Builder;

@Builder
public record PostResponse (
  Long id,
  String title,
  String content,
  LocalDateTime createdAt,
  Author Author
){
  @Builder
  public record Author(
    Long id,
    String nickname,
    String email
  ){}

}
