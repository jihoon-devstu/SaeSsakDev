package com.example.ex07_mybatis.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
  long countAll(); // XML Mapper 에서 id = "countAll"인 쿼리 실행하기.
  
}
