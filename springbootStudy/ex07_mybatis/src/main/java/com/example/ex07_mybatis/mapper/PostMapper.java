package com.example.ex07_mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.ex07_mybatis.domain.Post;

@Mapper
public interface PostMapper {
  long countAll();
  Post findById(Long id);
  List<Post> findAll(@Param("offset") long offset , @Param("size") int size);
  int save(Post post);
  int updateById(Post post);
  int deleteById(Long id);
}
