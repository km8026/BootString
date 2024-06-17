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
  void dept_조회() {
    List<Dept> list = deptRepository.findAll();
    System.out.println(list);
  }

}
