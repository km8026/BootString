package com.example.basic.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Entity
@Data
public class Emp {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Integer EMPNO;

  @Column(length = 10,nullable = false)
  String ENAME;
  
  @Column(length = 9, nullable = false)
  String JOB;

  Integer MGR;
  @Column(name = "HIREDATE", nullable = false)
  @Temporal(TemporalType.TIMESTAMP)
  LocalDateTime HIREDATE;

  Integer SAL;
  Integer COMM;

  // @Column(name = "DEPTNO", columnDefinition = "TINYINT", length = 4)
  // @Temporal(TemporalType.TIMESTAMP)
  // private Integer DEPTNO = null; 

  @ManyToOne
  @JoinColumn(name = "DEPTNO",nullable = false)
  Dept dept;
} 

