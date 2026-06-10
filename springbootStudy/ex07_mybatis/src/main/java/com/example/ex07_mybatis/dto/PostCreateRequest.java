package com.example.ex07_mybatis.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

@Builder
public record PostCreateRequest(
  @NotBlank(message = "작성자 ID는 필수 항목입니다.")
  Long userId,
  
  @NotBlank(message = "제목은 필수 항목입니다.")
  String title,

  String content
) {

}
