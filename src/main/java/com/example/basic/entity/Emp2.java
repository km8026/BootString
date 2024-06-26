package com.example.basic.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Emp2 {
  @Id
  int EMPNO;
  String ENAME;
  String JOB;
  int MGR;
  LocalDateTime HIREDATE;
  int SAL;
  int COMM;
  byte DEPTNO;
}
