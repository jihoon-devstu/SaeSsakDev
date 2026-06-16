package com.example.data.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.data.domain.Post;

//이미 완성된 메서드들
// 1. 저장 : save(T entity)
// 2. 수정 : save(T entity) - JpaRepository 가 지원하지 않는다. (변경 감지를 이용함)
// 3. 삭제 : deleteById(Id id), delete(T entity)
// 4. 조회 : findById(Id id), findAll(), findAll(Pageable pageable), count() , existsById(Id id) 등


public interface PostRepository extends JpaRepository<Post, Long>{ // <엔터티 타입 , ID 타입>

  @Query("select p from Post p left join fetch p.comments where p.id = :id")
  Post findByIdWithComments(@Param("id")Long id);

  //제목에 특정 키워드가 포함된 게시글 목록 조회
  Page<Post> findByTitleContaining(String keyword, Pageable pageable);



}
