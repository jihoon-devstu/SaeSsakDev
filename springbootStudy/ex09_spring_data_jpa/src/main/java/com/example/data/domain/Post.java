package com.example.data.domain;

import java.util.ArrayList;
import java.util.List;

import com.example.data.common.BaseTimeEntity;

import jakarta.persistence.Column;
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
@Table(name= "post")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Post extends BaseTimeEntity {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(length = 500, nullable = false)
  private String title;

  @Column(nullable = false, columnDefinition = "TEXT")
  private String content;

  @OneToMany(mappedBy = "post")
  private List<Comment> comments = new ArrayList<>();

  public Post(String title, String content) {
    this.title = title;
    this.content = content;
  }

  public void addComment(Comment comment){
    comments.add(comment); // 현재 게시글의 댓글 목록에 등록
    comment.setPost(this); // 댓글이 달린 게시글이 현재 게시글임을 등록
  }

  //변경 감지를 위한 비즈니스 메서드
  public void updatePost(String title, String content){
    this.title = title;
    this.content = content;
  }

}
