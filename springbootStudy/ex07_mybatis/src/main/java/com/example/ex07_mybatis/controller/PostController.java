package com.example.ex07_mybatis.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.ex07_mybatis.dto.PageResponse;
import com.example.ex07_mybatis.dto.PostCreateRequest;
import com.example.ex07_mybatis.dto.PostResponse;
import com.example.ex07_mybatis.service.PostService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/posts")
public class PostController {

  private final PostService postService;

  //게시글 1건 등록
  @PostMapping
  public ResponseEntity<PostResponse> save(@Valid @RequestBody PostCreateRequest request) {
    return ResponseEntity.ok(postService.save(request));
  }

  // 게시글 갯수 반환
  @GetMapping("/count")
  public ResponseEntity<Long> countAll() {
    return ResponseEntity.ok(postService.countAll());
  }

  //모든 게시글 반환 + 페이징 처리 정보 반환
  @GetMapping
  public ResponseEntity<PageResponse<PostResponse>> findAll(
    @RequestParam(defaultValue = "1") int page,
    @RequestParam(defaultValue = "2") int size,
    @RequestParam(defaultValue = "DESC") String sort
    ) {
    
    return ResponseEntity.ok(postService.findAll(page, size, sort));
  }

  //게시글 ID 로 게시글 1건 조회
  @GetMapping("/{id}")
  public ResponseEntity<PostResponse> findById(@PathVariable Long id) {
    return ResponseEntity.ok(postService.findById(id));
  }
  
}
