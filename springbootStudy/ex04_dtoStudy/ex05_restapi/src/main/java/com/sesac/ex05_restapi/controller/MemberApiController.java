package com.sesac.ex05_restapi.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sesac.ex05_restapi.dto.MemberRequest;
import com.sesac.ex05_restapi.dto.MemberResponse;
import com.sesac.ex05_restapi.service.MemberService;

import lombok.RequiredArgsConstructor;

@RequestMapping("/api/members")
@RestController
@RequiredArgsConstructor
public class MemberApiController {

  private final MemberService memberService;

  // 회원 등록
  @PostMapping
  public ResponseEntity<MemberResponse> save(@RequestBody MemberRequest request) {

    MemberResponse savedMember = memberService.save(request);

    return ResponseEntity.status(HttpStatus.CREATED).body(savedMember);
  }

  // 회원 전체 조회
  @GetMapping
  public ResponseEntity<List<MemberResponse>> findAll() {
    List<MemberResponse> members = memberService.findAll();
    return ResponseEntity.ok(members);
  }

  // 회원 단건 조회
  @GetMapping("/{id}")
  public ResponseEntity<MemberResponse> findById(@PathVariable Long id) {
    try {
      MemberResponse foundMember = memberService.findById(id);
      return ResponseEntity.ok(foundMember);
    } catch (RuntimeException e) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
  }

  // 회원 정보 수정
  @PutMapping("/{id}")
  public ResponseEntity<MemberResponse> update(@PathVariable Long id, @RequestBody MemberRequest request) {
    try {
      MemberResponse updatedMember = memberService.update(id, request);
      return ResponseEntity.ok(updatedMember);
    } catch (RuntimeException e) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
  }

  // 회원 삭제
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable Long id) {
    try {
      memberService.deleteById(id);
      return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    } catch (RuntimeException e) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
  }
}
