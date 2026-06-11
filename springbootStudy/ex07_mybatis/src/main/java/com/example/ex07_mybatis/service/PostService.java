package com.example.ex07_mybatis.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.ex07_mybatis.domain.Post;
import com.example.ex07_mybatis.dto.PageResponse;
import com.example.ex07_mybatis.dto.PostCreateRequest;
import com.example.ex07_mybatis.dto.PostResponse;
import com.example.ex07_mybatis.exception.CustomException;
import com.example.ex07_mybatis.exception.ErrorCode;
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
    
    Post post = postMapper.findById(id)
                .orElseThrow(()-> new CustomException(ErrorCode.POST_NOT_FOUND));

    return PostResponse.from(post);
  }

  public PageResponse<PostResponse> findAll(int page, int size, String sort) {
    long offset = (page - 1) * size;
    long totalElements = postMapper.countAll();
    int totalPages = (int) Math.ceil((double) totalElements / size);

    List<Post> posts = postMapper.findAll(offset, size, sort);

    List<PostResponse> contents = posts.stream()
      .map(PostResponse::from)
      .toList();

      PageResponse<PostResponse> response = PageResponse.<PostResponse>builder()
        .contents(contents)
        .page(page)
        .size(size)
        .totalElements(totalElements)
        .totalPages(totalPages)
        .build();

    return response;
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
