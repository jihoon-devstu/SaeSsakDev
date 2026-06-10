package com.example.ex07_mybatis.domain;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class Post {

  private Long id;
  private Long userId;
  private String title;
  private String content;
  private LocalDateTime createdAt;

  //조인 관계에서 
  private User user;
}
