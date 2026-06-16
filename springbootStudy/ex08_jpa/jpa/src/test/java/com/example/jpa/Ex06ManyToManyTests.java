package com.example.jpa;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.jpa.util.JpaUtil;
import com.example.jpa_association.domain.Post;
import com.example.jpa_association.domain.PostComment;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

@SpringBootTest
public class Ex06ManyToManyTests {
// 엔티티 매니저 (영속성 컨텍스트 관리자)
  private EntityManager em;

	//엔티티 트랜잭션
	private EntityTransaction tx;


  // 테스트 시작 전 엔티티 매니저를 만들기 위해 팩토리(공장)부터 지어둠
  @BeforeAll
  static void setUpBeforeClass() {
    JpaUtil.initFactory();
  }

  // 각 테스트 시작 전 엔티티 매니저를 생성
  @BeforeEach
  void setUp() {
    em = JpaUtil.getEntityManager();
		tx = em.getTransaction(); //jpa 모든 데이터 변경은 트랜잭션 내부에서 실행되어야 반영.
		tx.begin();
  }

  // 각 테스트 종료 후 엔티티 메니저를 닫아줌
  @AfterEach
  void tearDown() {
		if(tx != null && tx.isActive()){
			tx.rollback();
		}
	
    if (em != null && em.isOpen()) {
      em.close();
    }
  }

  @Test
  @DisplayName("일대다 단방향 저장 및 조회 테스트")
  void oneToManyTest(){

    //저장 (부모 엔터티 먼저 생성)
    Post post = new Post("JPA 연관관계");

    PostComment comment1 = new PostComment("댓글 테스트 첫번째");
    PostComment comment2 = new PostComment("댓글 테스트 두번째");
    PostComment comment3 = new PostComment("댓글 테스트 세번째");

    post.addComment(comment1);
    post.addComment(comment2);
    post.addComment(comment3);
    

    em.persist(post);
    em.persist(comment1);
    em.persist(comment2);
    em.persist(comment3);

    em.flush();
    em.clear();

    //조회
    Post findPost = em.find(Post.class, post.getId());
    System.out.println(findPost.getTitle());
    System.out.println(findPost.getComments());
  }

}
