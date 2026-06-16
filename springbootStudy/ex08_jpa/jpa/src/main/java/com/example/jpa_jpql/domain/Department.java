package com.example.jpa_jpql.domain;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "departments")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Department {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String deptName;

  public Department(String deptName) {
    this.deptName = deptName;
  }

  @OneToMany(mappedBy = "department" , cascade = CascadeType.ALL)
  private List<Employee> employees = new ArrayList<>();


  
  public void addEmployee(Employee employee){
    this.employees.add(employee);
    employee.setDepartment(this); 
  }

  @Override
  public String toString() {
    return "Department [id=" + id + ", deptName=" + deptName + ", employees=" + employees + "]";
  }

  
}
