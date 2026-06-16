package com.example.data.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.data.domain.Comment;
import com.example.data.domain.Post;
import com.example.data.repository.PostRepository;

import lombok.RequiredArgsConstructor;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PostService {

  private final PostRepository postRepository;

  /**
   * 게시글 저장
   */
  @Transactional
  public Long createPost(String title, String content) {
    Post post = new Post(title, content);
    return postRepository.save(post).getId();
  }

  /**
   * 게시글 단건 조회
   */
  public Post findOne(Long postId) {
    return postRepository.findByIdWithComments(postId);
        
  }

  /**
   * 게시글 검색 조회
   */
  public Page<Post> getPosts(String keyword, Pageable pageable) {
    if(keyword != null && !keyword.isEmpty()) {
      return postRepository.findByTitleContaining(keyword, pageable);
    }else{
      return postRepository.findAll(pageable);
    }

  }
    

  /**
   * 게시글 수정 (조회해야 영속화 되므로 , 조회 후 변경 감지 이용)
   */
  @Transactional
  public void updatePost(Long id, String title, String content) {
    Post post = postRepository.findById(id)
        .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 존재하지 않습니다. id=" + id));
    post.updatePost(title, content);
  }

  /**
   * 게시글 삭제
   */
  @Transactional
  public void deletePost(Long id) {
    Post post = postRepository.findById(id)
        .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 존재하지 않습니다. id=" + id));
    postRepository.deleteById(id);
  }


  //댓글 등록
  @Transactional
  public void addComment(Long postId, String content) {
    Post post = postRepository.findById(postId)
      .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 존재하지 않습니다. id=" + postId));
    post.addComment(new Comment(content));
  }


}
