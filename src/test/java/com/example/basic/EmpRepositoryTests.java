package com.example.basic;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.basic.entity.Dept;
import com.example.basic.entity.Emp;
import com.example.basic.repository.DeptRepository;
import com.example.basic.repository.EmpRepository;

@SpringBootTest
public class EmpRepositoryTests {
  @Autowired
  EmpRepository empRepository;

  @Autowired
  DeptRepository deptRepository;

  @Test 
  void EmpRepository조회Test(){
    List<Emp> list = empRepository.findAll();
    System.out.println(list);
  }
  @Test 
  void Emp조회2(){
    Emp e = empRepository.findByENAME("scott");
    System.out.println(e);  
  }
  @Test 
  void Emp조회3(){
    String ename = "tt";
    Emp e = empRepository.findByENAMELike("%" + ename + "%");
    System.out.println(e);
  }
  @Test 
  void Emp조회4(){
    List<Emp> e = empRepository.findBySALGreaterThan(2000);
    System.out.println(e);
  }
  
  @Test
  void dept_조회() {
    List<Dept> list = deptRepository.findAll();
    System.out.println(list);
  }

}
