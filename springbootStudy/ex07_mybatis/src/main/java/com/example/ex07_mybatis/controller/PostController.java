package com.example.ex07_mybatis.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.ex07_mybatis.service.PostService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/posts")
public class PostController {

  private final PostService postService;

  @GetMapping("/count")
  public ResponseEntity<Long> countAll() {
    return ResponseEntity.ok(postService.countAll());
  }

  @GetMapping
  public ResponseEntity<Object> findAll(
    @RequestParam(defaultValue = "0") Long offset, 
    @RequestParam(defaultValue = "10") int size) {
    return ResponseEntity.ok(postService.findAll(offset, size));
  }

  @GetMapping("/{id}")
  public ResponseEntity<Object> findById(@PathVariable Long id) {
    return ResponseEntity.ok(postService.findById(id));
  }


}
