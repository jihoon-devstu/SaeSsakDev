package com.sesac.ex05_restapi.service;

import java.util.List;

import com.sesac.ex05_restapi.dto.MemberRequest;
import com.sesac.ex05_restapi.dto.MemberResponse;

public interface MemberService {
  //회원 등록
  MemberResponse save(MemberRequest request); 

  //회원 전체 조회
  List<MemberResponse> findAll();

  //회원 단건 조회
  MemberResponse findById(Long id);

  //회원 정보 수정
  MemberResponse update(Long id, MemberRequest request);

  //회원 삭제
  void deleteById(Long id);
}
