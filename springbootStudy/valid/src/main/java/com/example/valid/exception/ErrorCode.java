package com.example.valid.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public enum ErrorCode {

  // 400 BAD_REQUEST
  INVALID_INPUT_VALUE(HttpStatus.BAD_REQUEST, "C001", "올바르지 않은 입력값입니다."),

  // 404 NOT_FOUND
  MEMBER_NOT_FOUND(HttpStatus.NOT_FOUND, "M001", "회원을 찾을 수 없습니다."),

  // 409 CONFLICT
  DUPLICATE_EMAIL(HttpStatus.CONFLICT, "M002", "이미 존재하는 이메일입니다."),

  // 500 INTERNAL_SERVER_ERROR
  INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "S001", "서버 내부 오류입니다.");

  private HttpStatus status;
  private String code;
  private String message;

  ErrorCode(HttpStatus status, String code, String message) {
    this.status = status;
    this.code = code;
    this.message = message;
  }
}
