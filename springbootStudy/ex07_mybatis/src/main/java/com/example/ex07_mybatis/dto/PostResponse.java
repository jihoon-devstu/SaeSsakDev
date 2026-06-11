package com.example.ex07_mybatis.dto;

import java.time.LocalDateTime;

import com.example.ex07_mybatis.domain.Post;
import com.example.ex07_mybatis.domain.User;

import lombok.Builder;

@Builder
public record PostResponse (
  Long id,
  String title,
  String content,
  LocalDateTime createdAt,
  Author author
){
// PostResponse.from 메서드
  public static PostResponse from(Post post) {
    return PostResponse.builder()
      .id(post.getId())
      .title(post.getTitle())
      .content(post.getContent())
      .createdAt(post.getCreatedAt())
      .author(post.getUser() != null ? Author.from(post.getUser()) : null)
      .build();
    }
// 중첩 record인 Author
  @Builder
  public record Author(
    Long id,
    String nickname,
    String email
  ) {
    // Author.from 메서드
    public static Author from(User user) {
      return Author.builder()
        .id(user.getId())
        .nickname(user.getNickname())
        .email(user.getEmail())
        .build();
    }

  }

}


