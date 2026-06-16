package com.example.jpa_association.domain;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "orders")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Order {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String orderNumber;

  public Order(String orderNumber) {
    this.orderNumber = orderNumber;
  }

  // 양방향 연관 관계의 주인이 아니라고 명시합니다. mappedBy 속성 이용.
  // mappedBy 속성에는 반대편의 필드명 그대로 작성.
  @OneToMany(mappedBy = "order" , cascade = CascadeType.ALL)
  private List<OrderItem> orderItems = new ArrayList<>();

  public void addOrderItem(OrderItem orderItem){
    this.orderItems.add(orderItem);
  }

  @Override
  public String toString() {
    return "Order [id=" + id + ", orderNumber=" + orderNumber + ", orderItems=" + orderItems + "]";
  }

  
}
