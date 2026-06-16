package com.example.jpa;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.jpa.util.JpaUtil;
import com.example.jpa_jpql.domain.Department;
import com.example.jpa_jpql.domain.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

@SpringBootTest
public class Ex07ManyToManyTestsStu {
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

   Department dev = new Department("devlopment");
   Department marketing = new Department("marketing");

   Employee kim = new Employee("kim",5000);
   Employee lee = new Employee("lee",6000);
   Employee jung = new Employee("jung",5000);
   Employee choi = new Employee("choi",6000);

   dev.addEmployee(lee);
   dev.addEmployee(kim);
   marketing.addEmployee(jung);
   marketing.addEmployee(choi);

   em.persist(dev);
   em.persist(marketing);
   em.persist(kim);
   em.persist(lee);
   em.persist(jung);
   em.persist(choi);

   em.flush();
   em.clear();

   Department findDev = em.find(Department.class, dev.getId());
   System.out.println(findDev.getEmployees());

   Department findMarketing = em.find(Department.class, marketing.getId());
   System.out.println(findMarketing.getEmployees());

  }

  @Test
  @DisplayName("반환타입이 Query인 테스트")
  void queryTest(){
    Department dev = new Department("devlopment");
    Department marketing = new Department("marketing");

    Employee kim = new Employee("kim",5000);
    Employee lee = new Employee("lee",6000);
    Employee jung = new Employee("jung",5000);
    Employee choi = new Employee("choi",6000);

    dev.addEmployee(lee);
    dev.addEmployee(kim);
    marketing.addEmployee(jung);
    marketing.addEmployee(choi);

    kim.setDepartment(dev);
    lee.setDepartment(dev);
    jung.setDepartment(marketing);
    choi.setDepartment(marketing);

    
    em.persist(dev);
    em.persist(marketing);
    em.persist(kim);
    em.persist(lee);
    em.persist(jung);
    em.persist(choi);

    em.flush();

    Query query = em.createQuery("select e.name, e.salary from Employee e");
    List<Object[]> results = query.getResultList();
    for(Object[] result : results){
      System.out.println(result[0] + " : " + result[1]);
    }

  }

  @Test
  @DisplayName("반환타입이 TypeQuery인 테스트")
  void typedQueryTest(){
    Department dev = new Department("devlopment");
    Department marketing = new Department("marketing");

    Employee kim = new Employee("kim",5000);
    Employee lee = new Employee("lee",6000);
    Employee jung = new Employee("jung",5000);
    Employee choi = new Employee("choi",6000);

    dev.addEmployee(lee);
    dev.addEmployee(kim);
    marketing.addEmployee(jung);
    marketing.addEmployee(choi);

    kim.setDepartment(dev);
    lee.setDepartment(dev);
    jung.setDepartment(marketing);
    choi.setDepartment(marketing);

    
    em.persist(dev);
    em.persist(marketing);
    em.persist(kim);
    em.persist(lee);
    em.persist(jung);
    em.persist(choi);

    em.flush();

    TypedQuery<Employee> query = em.createQuery("select e from Employee e", Employee.class);
    List<Employee> employees = query.getResultList();

    for(Employee employee : employees){
      System.out.println(employee.getName() + " : " + employee.getSalary());
    }

  }

  @Test
  @DisplayName("N + 1 문제 JPQL")
  void nPlusOneTest(){

    Department dev = new Department("devlopment");
    Department marketing = new Department("marketing");

    Employee kim = new Employee("kim",5000);
    Employee lee = new Employee("lee",6000);
    Employee jung = new Employee("jung",5000);
    Employee choi = new Employee("choi",6000);

    dev.addEmployee(lee);
    dev.addEmployee(kim);
    marketing.addEmployee(jung);
    marketing.addEmployee(choi);

    kim.setDepartment(dev);
    lee.setDepartment(dev);
    jung.setDepartment(marketing);
    choi.setDepartment(marketing);

    
    em.persist(dev);
    em.persist(marketing);
    em.persist(kim);
    em.persist(lee);
    em.persist(jung);
    em.persist(choi);

    em.flush();

    TypedQuery<Employee> query = em.createQuery("select e from Employee e", Employee.class);
    List<Employee> employees = query.getResultList();

    for(Employee employee : employees){
      System.out.println(employee.getDepartment().getDeptName());
    }

  }

  @Test
  @DisplayName("Fetch Join 테스트")
  void FetchJoinTest(){

    Department dev = new Department("devlopment");
    Department marketing = new Department("marketing");

    Employee kim = new Employee("kim",5000);
    Employee lee = new Employee("lee",6000);
    Employee jung = new Employee("jung",5000);
    Employee choi = new Employee("choi",6000);

    dev.addEmployee(lee);
    dev.addEmployee(kim);
    marketing.addEmployee(jung);
    marketing.addEmployee(choi);

    kim.setDepartment(dev);
    lee.setDepartment(dev);
    jung.setDepartment(marketing);
    choi.setDepartment(marketing);

    
    em.persist(dev);
    em.persist(marketing);
    em.persist(kim);
    em.persist(lee);
    em.persist(jung);
    em.persist(choi);

    em.flush();
    em.clear();

    String jpql = "select e from Employee e join fetch e.department";
    TypedQuery<Employee> query = em.createQuery(jpql, Employee.class);
    List<Employee> employees = query.getResultList();

    for(Employee employee : employees){
      System.out.println(employee.getDepartment().getDeptName());
    }
    


  }

  
}
