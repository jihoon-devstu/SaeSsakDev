package com.sesac.ex05_restapi.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import com.sesac.ex05_restapi.dto.MemberRequest;
import com.sesac.ex05_restapi.dto.MemberResponse;

@Service
public class MemberServiceImpl implements MemberService {

  // 인메모리 데이터베이스
  private final Map<Long, MemberResponse> members = new ConcurrentHashMap<>();
  private final AtomicLong sequence = new AtomicLong();

  // Mock 데이터 생성
  public MemberServiceImpl() {
    for (int i = 0; i < 10; i++) {
      save(MemberRequest.builder()
          .email("member" + (i + 1) + "@example.com")
          .build());
    }
  }

  @Override
  public MemberResponse save(MemberRequest request) {
    Long id = sequence.incrementAndGet();
    String email = request.email();
    LocalDateTime createdAt = LocalDateTime.now();
    MemberResponse response = MemberResponse.builder()
        .id(id)
        .email(email)
        .createdAt(createdAt)
        .build();

    members.put(id, response);

    return response;
  }

  @Override
  public List<MemberResponse> findAll() {
    return new ArrayList<>(members.values());
  }

  @Override
  public MemberResponse findById(Long id) {
    MemberResponse foundMember = members.get(id);
    if (foundMember == null) {
      throw new RuntimeException("Member not found with id: " + id);
    }
    return foundMember;
  }

  @Override
  public MemberResponse update(Long id, MemberRequest request) {

    MemberResponse foundMember = members.get(id);
    if (foundMember == null) {
      throw new RuntimeException("Member not found with id: " + id);
    }
    MemberResponse updatedMember = MemberResponse.builder()
        .id(id)
        .email(request.email())
        .createdAt(foundMember.createdAt())
        .build();

    members.put(id, updatedMember);

    return updatedMember;
  }

  @Override
  public void deleteById(Long id) {
    MemberResponse foundMember = members.get(id);
    if (foundMember == null) {
      throw new RuntimeException("Member not found with id: " + id);
    }
    members.remove(id);
  }

}
