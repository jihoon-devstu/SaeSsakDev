package com.sesac.dtoStudy.service;

import org.springframework.stereotype.Service;

@Service
public class OrderService {

  //실제 업무 처리 (비즈니스 메서드 : 포인트 컷이 될 타겟 메서드)
  public String createOder(String itemId) {
    // 주문 생성 로직 (예: 데이터베이스에 주문 저장)
    System.out.println("주문 생성 메서드 시작 , 주문아이템:"+ itemId);
    try {
      Thread.sleep(1000); //1초 지연
    } catch (Exception e) {
      Thread.currentThread().interrupt();
    }

    System.out.println("주문 생성 메서드 종료");
    return "Order- " + itemId;
  }

}
