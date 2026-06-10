package com.example.ex07_mybatis.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.ex07_mybatis.domain.Post;
import com.example.ex07_mybatis.dto.PostCreateRequest;
import com.example.ex07_mybatis.dto.PostResponse;
import com.example.ex07_mybatis.mapper.PostMapper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class PostService {

  private final PostMapper postMapper;

  public long countAll() {
    return postMapper.countAll();
  }

  public PostResponse findById(Long id) {
    Post post = postMapper.findById(id);
    PostResponse response = PostResponse.builder()
      .id(post.getId())
      .title(post.getTitle())
      .content(post.getContent())
      .createdAt(post.getCreatedAt())
      .Author(PostResponse.Author.builder()
        .id(post.getUser().getId())
        .nickname(post.getUser().getNickname())
        .email(post.getUser().getEmail())
        .build())
      .build();
    return response;
  }

  public List<Post> findAll(long offset, int size) {
    return postMapper.findAll(offset, size);
  }

  public PostResponse save(PostCreateRequest request) {

    Post post = Post.builder()
      .userId(request.userId())
      .title(request.title())
      .content(request.content())
      .build();

    postMapper.save(post);

    PostResponse response = findById(post.getId());

    return response;
  }

  public int update(Post post) {
    return postMapper.updateById(post);
  }

  public int delete(long id) {
    return postMapper.deleteById(id);
  }

}
