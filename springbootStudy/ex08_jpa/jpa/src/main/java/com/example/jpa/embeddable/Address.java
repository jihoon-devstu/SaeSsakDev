package com.example.jpa.embeddable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

// 임베디드 타입
// 복합 타입 (여러 타입을 하나의 객체로 묶어서 관리하는 방법)

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Embeddable
@AllArgsConstructor
public class Address {

  private String city;
  private String street;

  @Column(name = "zip_code")
  private String zipCode;

  


}
