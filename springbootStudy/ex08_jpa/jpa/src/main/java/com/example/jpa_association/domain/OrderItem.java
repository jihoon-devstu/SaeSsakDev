package com.example.jpa_association.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "orderitem")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class OrderItem {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String itemName;

  private Integer quantity;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "order_id")
  //외래키를 가진 자식이 항상 양방향 연관 관계의 주인이 된다.
  private Order order;

public OrderItem(String itemName, Integer quantity) {
  this.itemName = itemName;
  this.quantity = quantity;
}

@Override
public String toString() {
  return "OrderItem [id=" + id + ", itemName=" + itemName + ", quantity=" + quantity + ", order=" + order + "]";
}

  
}
