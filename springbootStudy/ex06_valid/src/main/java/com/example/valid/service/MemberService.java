package com.example.valid.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import com.example.valid.dto.MemberCreateRequest;
import com.example.valid.dto.MemberDto;
import com.example.valid.dto.MemberUpdateRequest;
import com.example.valid.exception.CustomException;
import com.example.valid.exception.ErrorCode;

@Service
public class MemberService {
  private final Map<Long, MemberDto> store = new ConcurrentHashMap<>();
  private final AtomicLong sequence = new AtomicLong(0);

  public MemberService() {
    // 초기 데이터 추가
    save(MemberCreateRequest.builder()
        .username("아이언맨")
        .email("ironman@avengers.com")
        .build());

    save(MemberCreateRequest.builder()
        .username("캡틴아메리카")
        .email("captainamerica@avengers.com")
        .build());

    save(MemberCreateRequest.builder()
        .username("헐크")
        .email("hulk@avengers.com")
        .build());

    save(MemberCreateRequest.builder()
        .username("토르")
        .email("thor@avengers.com")
        .build());

  }

  // save
  public MemberDto save(MemberCreateRequest request) {
    //이메일 중복 검증
    boolean isExistEmail = store.values().stream()
        .anyMatch(member -> member.email().equals(request.email()));
        
    if (isExistEmail) {
      throw new CustomException(ErrorCode.DUPLICATE_EMAIL);
    }
    
    Long id = sequence.incrementAndGet();

    MemberDto member = MemberDto.builder()
        .id(id)
        .username(request.username())
        .email(request.email())
        .createdAt(LocalDateTime.now())
        .build();

    store.put(id, member);
    return member;
  }

  // Read All
  public List<MemberDto> findAll() {
    return new ArrayList<>(store.values());
  }

  // Read one
  public MemberDto findById(Long id) {
    MemberDto foundMember = store.get(id);

    //없는 회원 예외처리
    if(foundMember == null) {
      throw new CustomException(ErrorCode.MEMBER_NOT_FOUND);
    }
    return foundMember;
  }

  // update
  public MemberDto updateMember(Long id, MemberUpdateRequest request) {
    MemberDto foundMember = findById(id);

    MemberDto updatedMember = MemberDto.builder()
        .id(foundMember.id())
        .username(foundMember.username())
        .email(request.email())
        .createdAt(foundMember.createdAt())
        .build();

    store.put(id, updatedMember);
    return updatedMember;
  }

  // delete
  public void deleteById(Long id) {
    findById(id); // 존재 여부 확인
    
    store.remove(id);
  }

}
