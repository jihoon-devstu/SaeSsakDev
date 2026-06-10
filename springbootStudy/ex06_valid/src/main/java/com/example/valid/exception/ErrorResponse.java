package com.example.valid.exception;

import java.time.LocalDateTime;

import lombok.Builder;


@Builder
public record ErrorResponse(
  int status,
  String code,
  String message,
  LocalDateTime timestamp
) {

    public static ErrorResponse of(ErrorCode errorCode) {
        return ErrorResponse.builder()
                .status(errorCode.getStatus().value())
                .code(errorCode.getCode())
                .message(errorCode.getMessage())
                .timestamp(LocalDateTime.now())
                .build();
    }

}
