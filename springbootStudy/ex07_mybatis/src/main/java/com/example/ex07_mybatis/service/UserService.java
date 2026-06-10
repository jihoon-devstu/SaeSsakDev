package com.example.ex07_mybatis.service;

import org.springframework.stereotype.Service;

import com.example.ex07_mybatis.mapper.UserMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

  private final UserMapper userMapper;
 

  
}
