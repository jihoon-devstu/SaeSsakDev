package com.example.jpa;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.jpa.persistenceContext.Book;
import com.example.jpa.util.JpaUtil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

@SpringBootTest
public class Ex02PersistenceTests {
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

  // 전체 테스트 종료 후 엔티티 매니저 팩토리를 닫아줌
  @AfterAll
  static void tearDownAfterClass() {
    JpaUtil.closeFactory();
  }

  @Test
  @DisplayName("1차 캐시 테스트")
  void identityAndCacheTest() {
    // 엔터티 생성
    Book book = new Book("HarryPotter","JKRowling");

    // 엔터티 관리 시작 (영속 상태의 엔터티는 1차 캐시에 저장된다.)
    em.persist(book);

    // 엔터티 조회 
    // find() 메서드 : 오직 ID를 이용해서만 조회 , 1차 캐시에 없으면 DB 조회.
    Book findBook1 = em.find(Book.class, book.getId());
    Book findBook2 = em.find(Book.class, book.getId());

    // 주소 비교를 통해 동일한 엔티티인지 확인.
    assertTrue(findBook1 == findBook2);

  }

  @Test
  @DisplayName("변경감지 (dirdy check) 테스트")
  void dirtyCheckTest() {
    // 엔터티 생성
    Book book = new Book("HarryPotter","JKRowling");

    // 엔터티 관리 시작 (영속 상태의 엔터티는 1차 캐시에 저장된다.)
    em.persist(book);

    // DB 반영 후 준영속 상태로 전환 (관리 안 되는 상태)
    em.flush(); // 쓰기 지연 SQL 저장소에 있는 모든 쿼리문 DB로 날림.
    em.clear(); // 준영속 상태로 전환

    //DB로 부터 조회 (조회 결과는 영속 상태로 됨)
    Book findBook = em.find(Book.class, book.getId());
    
    // 영속상태의 엔터티의 값 변경 (변경 감지에 의해 UPDATE 문 자동 생성 -> 쓰기 지연 SQL 저장소에 보관) 
    findBook.changeTitle("PotterHarry");

    // 트랜잭션 커밋(tx.commit()) 또는 저장소 비우기(em.flush()) 를 통해 DB로 쓰기지연 SQL 저장소의 모든 쿼리 날림
    em.flush();

    // 엔터티 조회 
    Book findBook2 = em.find(Book.class, book.getId());
    System.out.println(findBook2);
  }
}
