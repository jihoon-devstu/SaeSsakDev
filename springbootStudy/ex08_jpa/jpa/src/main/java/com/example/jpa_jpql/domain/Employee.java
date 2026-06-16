package com.example.jpa_jpql.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "employees")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Employee {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  private int salary;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "dept_id")
  private Department department;

  public Employee(String name,int salary) {
    this.name = name;
    this.salary = salary;
  }

  // Employee.java에 추가
  public void setDepartment(Department department) {
    this.department = department;
  }

  @Override
  public String toString() {
    
    String deptName = (department != null) ? department.getDeptName() : "null";
    return "Employee [id=" + id + ", name=" + name + ", department=" + deptName + "]";
}

  

}
