package com.sesac.ex05_restapi.dto;

import java.time.LocalDateTime;

import lombok.Builder;

@Builder
public record MemberRequest(
    Long id,
    String email,
    LocalDateTime createdAt
) {

}
