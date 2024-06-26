package com.example.basic.controller;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.basic.dao.DemoDao;
import com.example.basic.entity.ServiceCenter;
import com.example.basic.entity.TableExam1;
import com.example.basic.entity.Team;
import com.example.basic.entity.Dept;
import com.example.basic.entity.Emp;
import com.example.basic.entity.Hospital;
import com.example.basic.entity.Major;
import com.example.basic.entity.Player;
import com.example.basic.mapper.DemoMapper;
import com.example.basic.mapper.EmpMapper;
import com.example.basic.repository.ServiceCenterRepository;
import com.example.basic.repository.TableExam1Repository;
import com.example.basic.repository.TeamRepository;
import com.example.basic.service.HospitalService;
import com.example.basic.repository.DeptRepository;
import com.example.basic.repository.EmpRepository;
import com.example.basic.repository.HospitalRepository;
import com.example.basic.repository.MajorRepository;
import com.example.basic.repository.PlayerRepository;



@RestController
public class DBController {
  @Autowired
  EmpRepository empRepository;

  @Autowired
  DeptRepository deptRepository;

  @GetMapping("/emp")
  public Map<String, Object> emp(
    @RequestParam(defaultValue = "1") int page
  ) {
    Map<String, Object> map = new HashMap<>();
    //데이터 3개만 + 정렬
    Sort sort = Sort.by("SAL"); // 급여순
    Pageable pageable = PageRequest.of(page - 1, 3, sort);
    
    // Page<Emp> p = empRepository.findAll(pageable);
    // List<Emp> list = p.getContent();
    
    List<Emp> list = empRepository.findByENAMELikeOrderByENAMEAsc("%a%", pageable);
    
    map.put("emp_list",list);
    // map.put("total_page",p.getTotalPages());
    // map.put("total_count",p.getTotalElements());
    map.put("page",page);
    return map;
  }

  @GetMapping("/dept")
  public List<Dept> dept() {
    List<Dept> list = deptRepository.findAll();
    return list;
  }

  @Autowired
  TeamRepository teamRepository;

  @Autowired
  PlayerRepository playerRepository;

  @GetMapping("/team")
  public List<Team> team() {
    return teamRepository.findAll();
  }
  
  @GetMapping("/player")
  public List<Player> player() {
    return playerRepository.findAll();
  }

  @Autowired
  HospitalRepository hospitalRepository;
  
  @Autowired
  HospitalService hospitalService;

  @GetMapping("/hospital")
  public List<Hospital> hospitalList(){
    List<Hospital> list = hospitalService.getJson();
    // System.out.println(2/0); // 오류 발생 Aspect
    return list;
  }

  @Autowired
  MajorRepository majorRepository;
  
  @GetMapping("/major/add")
  public Major majorAdd(@ModelAttribute Major major) {
    major.setEbtbDate(new Date());
    return majorRepository.save(major);
  }

  @GetMapping("/major/list")
  public List<Major> majorList() {
    return majorRepository.findAll();
  }

  
  @Autowired
  ServiceCenterRepository serviceCenterRepository;

  @GetMapping("/sc/add")
  @ResponseBody
  public ServiceCenter scAdd(@ModelAttribute ServiceCenter sc) {
    // 입력 추가/날짜 정보
    LocalDateTime localDateTime = LocalDateTime.now();
    sc.setPurDate(localDateTime);
    Date date = new Date();
    sc.setVstDate(date);
    
    
    ServiceCenter result = serviceCenterRepository.save(sc);
    return result;
  }
  // 데이터 전체 조회
  @GetMapping("/sc/list")
  @ResponseBody
  public List<ServiceCenter> scList() {
    List<ServiceCenter> result = serviceCenterRepository.findAll();
    return result;
  }
  // 데이터 수정 
  @GetMapping("/sc/modify")
  @ResponseBody
  public ServiceCenter scModify(@ModelAttribute ServiceCenter sc) {
    sc.setId(2);
    ServiceCenter result = serviceCenterRepository.save(sc);
    return result;
  }

  @GetMapping("/sc/delete")
  @ResponseBody
  public String scRemove(@ModelAttribute ServiceCenter sc) {
  serviceCenterRepository.delete(sc);
  return "삭제 완료";
  }

  // @GetMapping("/sc/delete")
  // @ResponseBody
  // public String scRemove(@RequestParam Integer id) {
  //   serviceCenterRepository.deleteById(id);
  //   return "삭제 완료";
  // }
  

  @Autowired
  TableExam1Repository tableExam1Repository;

  @GetMapping("/table1/remove")
  public String table1Remove(@RequestParam int id){
    Optional<TableExam1> t = tableExam1Repository.findById(id);

    tableExam1Repository.delete(t.get());
    return "삭제 완료";
  }
  @GetMapping("/table1/add")
  public String table1Add(@RequestParam String title){
    TableExam1 t1 = new TableExam1();
    // t1.setId(1);
    t1.setTitle(title);
    tableExam1Repository.save(t1);
    return "입력 완료";
  }
  @GetMapping("/table1/add2")
  public String table1Add2(@RequestParam String title){
    TableExam1 t1 = new TableExam1();
    t1.setId(2);
    t1.setTitle(title);
    tableExam1Repository.save(t1);
    return "수정 완료";
  }
  @GetMapping("/table1/{id}")
  public TableExam1 table1Id(
    @PathVariable int id
  ){
    Optional<TableExam1> exam1 = tableExam1Repository.findById(id);
    return exam1.get();
  }
  @GetMapping("/table1/list")
  public List<TableExam1> table1Find(){
    List<TableExam1> list = tableExam1Repository.findAll();
    return list;
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
