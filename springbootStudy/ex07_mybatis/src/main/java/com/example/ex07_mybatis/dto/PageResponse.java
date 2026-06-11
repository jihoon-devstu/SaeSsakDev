package com.example.ex07_mybatis.dto;

import java.util.List;

import lombok.Builder;

@Builder
public record PageResponse<T>(
  List<T> contents,
  int page,
  int size,
  long totalElements,
  int totalPages
) {

}
