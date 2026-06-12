package com.example.jpa.persistenceContext;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "books")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Book {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String title;


  private String author;


  @Override
  public String toString() {
    return "Book [id=" + id + ", title=" + title + ", author=" + author + "]";
  }

  public Book(String title, String author) {
    this.title = title;
    this.author = author;
  }

  //책 이름을 바꿔주는 비즈니스 메서드 (Setter 대신 사용하는 리치도메인 개념)
  public void changeTitle(String title){
    this.title = title;
  }

}
