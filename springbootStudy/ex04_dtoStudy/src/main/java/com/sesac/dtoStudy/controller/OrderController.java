package com.sesac.dtoStudy.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sesac.dtoStudy.service.OrderService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class OrderController {

  private final OrderService orderService;
  
  @GetMapping("/aop-test")
  public String aopTest(){
    System.out.println("OrderService 클래스 : " + orderService.getClass());
    System.out.println("====");
    String result = orderService.createOder("item-001");
    System.out.println("====");
    return result;
  }

}
