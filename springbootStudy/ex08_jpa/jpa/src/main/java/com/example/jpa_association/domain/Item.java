package com.example.jpa_association.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

//자식 엔터티.
@Entity
@Table(name = "items")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Item {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false , length = 100)
  private String itemName;

  //연관 관계 핵심 부분 (Item 여러개 , Category 1개)
  //다대일 연관 관계 - 단방향 (!중요!)
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "category_id", foreignKey = @ForeignKey(name = "fk_item_to_category"))
  private Category category;  

  public Item(String itemName , Category category){
    this.itemName = itemName;
    this.category = category;
  }

  @Override
  public String toString() {
    return "Item [id=" + id + ", itemName=" + itemName + ", category=" + category + "]";
  }

}
