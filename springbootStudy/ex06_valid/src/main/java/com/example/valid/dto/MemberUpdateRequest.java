package com.example.valid.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

@Builder
public record MemberUpdateRequest(
    @NotBlank(message = "이메일은 필수 입력 항목 입니다") 
    @Email(message = "유효한 이메일 주소를 입력해야 합니다.") 
    String email) {
}
