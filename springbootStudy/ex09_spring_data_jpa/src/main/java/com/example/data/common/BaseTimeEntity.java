package com.example.data.common;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;

@MappedSuperclass // 자식 엔터티에 의해서 매핑되는 부모 클래스
@EntityListeners(AuditingEntityListener.class) //엔터티의 상태 변화(생성, 변경) 을 감지하여 날짜 자동 입력
@Getter
public abstract class BaseTimeEntity {

  @CreatedDate //엔터티 생성 시간 자동 저장
  @Column(updatable = false)
  private LocalDateTime createdAt;

  @LastModifiedDate
  private LocalDateTime updatedAt;

}
