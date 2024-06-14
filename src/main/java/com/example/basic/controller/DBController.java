package com.example.basic.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.basic.dao.DemoDao;
import com.example.basic.entity.TableExam1;
import com.example.basic.mapper.DemoMapper;
import com.example.basic.mapper.EmpMapper;
import com.example.basic.repository.TableExam1Repository;






@RestController
public class DBController {
  @Autowired
  TableExam1Repository tableExam1Repository;

  @GetMapping("/table1/add")
  public String table1Add(@RequestParam String title){
    TableExam1 t1 = new TableExam1();
    // t1.setId(1);
    t1.setTitle(title);
    tableExam1Repository.save(t1);
    return "입력 완료";
  }

  @Autowired
  DemoDao demoDao;

  @GetMapping("/jdbc/demo")
  public List<Map<String, Object>> jdbcDemo() {

    return demoDao.select();
  }

  @Autowired
  DemoMapper demoMapper;
  @Autowired
  EmpMapper empMapper;

  @GetMapping("/mybatis/emp")
  public List<Map<String, Object>> mybatisEmp
  (@RequestParam("ename") String ename) {
    return empMapper.select(ename);
  }

  @GetMapping("/mybatis/demo/add")
  public String mybatisDemoAdd
  (@RequestParam Map<String, Object> map)  {

    try {
      demoMapper.insert(map);
      } catch(Exception e){
        return "데이터 추가 실패";
      }

  //  int result = demoMapper.insert(map);
  //  if (result == 0) {
  //   return "데이터 추가 실패";
  //   } 
    return "데이터 추가 성공";
  }

  @GetMapping("/mybatis/demo")
  public List<Map<String, Object>> mybatisDemo() {
    return demoMapper.select();
  }

}
