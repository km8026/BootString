package com.example.basic.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.ToString;

@Entity
@Data
@ToString(exclude = "emp_list")
public class Dept {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Integer DEPTNO;

  @Column(length = 14,nullable = true)
  String DNAME;
  
  @Column(length = 13,nullable = true)
  String LOC;

  @OneToMany(mappedBy = "dept")
  @JsonIgnore
  List<Emp> emp_list = new ArrayList<>();
}
