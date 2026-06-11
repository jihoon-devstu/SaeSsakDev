package com.example.ex07_mybatis.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
 // @Valid 예외 발생 시
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<ErrorResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
    ErrorResponse response = ErrorResponse.of(ErrorCode.INVALID_INPUT_VALUE);
    return new ResponseEntity<>(response, ErrorCode.INVALID_INPUT_VALUE.getStatus());
  }

  // @커스텀 예외 발생 시
  @ExceptionHandler(CustomException.class)
  public ResponseEntity<ErrorResponse> handleCustomException(CustomException ex) {
    ErrorResponse response = ErrorResponse.of(ex.getErrorCode());
    return new ResponseEntity<>(response, ex.getErrorCode().getStatus());
  }

  // 그 외 모든 예외 발생 시
  @ExceptionHandler(Exception.class)
  public ResponseEntity<ErrorResponse> handleException(Exception ex) {
    ErrorResponse response = ErrorResponse.of(ErrorCode.INTERNAL_SERVER_ERROR);
    return new ResponseEntity<>(response, ErrorCode.INTERNAL_SERVER_ERROR.getStatus());
  }
}
