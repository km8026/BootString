package com.example.basic.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.basic.entity.Emp;
import com.example.basic.entity.Hospital;
import com.example.basic.repository.EmpRepository;
import com.example.basic.repository.HospitalRepository;
import com.example.basic.service.HospitalService;

@Controller
public class ThymeleafController {
  @Autowired
  HospitalService hospitalService;
  
  @GetMapping("/shospital") // 이름이 중복되면 안됨
  public String hospital(Model model, @RequestParam(defaultValue = "1") int page) {
    int startPage = (page - 1) / 10 * 10 + 1;
    int endPage = startPage + 9;

    Page<Hospital> p = hospitalService.getList(page);
    
    int totalPage = p.getTotalPages();
    if (endPage > totalPage) endPage = totalPage;

    model.addAttribute("hospitals", p.getContent());
    
    model.addAttribute("startPage", startPage);
    model.addAttribute("endPage", endPage);
    model.addAttribute("totalPage", totalPage);
    // hospital.html -> ${hospitals} 변수명과 같음
    return "hospital";

  }

  @GetMapping("insert1")
  public String insert1() {
    return "insert1";
  }

  @GetMapping("layout1")
  public String layout1() {
    return "layout1";
  }

  @GetMapping("layout2")
  public String layout2() {
    return "layout2";
  }

  @GetMapping("pagination")
  public String pagination(
      Model model, @RequestParam(defaultValue = "1") int page) {
    int startPage = (page - 1) / 10 * 10 + 1;
    int endPage = startPage + 9;
    model.addAttribute("startPage", startPage);
    model.addAttribute("endPage", endPage);
    model.addAttribute("page", page);
    return "pagination";
  }

  @GetMapping("mode")
  public String mode(
      Model model, @RequestParam Map<String, Object> map) {
    model.addAttribute("now", map.get("now") == null ? "am" : map.get("now"));
    model.addAttribute("name", map.get("name"));
    model.addAttribute("auth", map.get("auth"));
    model.addAttribute("category", map.get("category"));
    return "mode";
  }

  @Autowired
  HospitalRepository hospitalRepository;

  @GetMapping("/hospitallist")
  public String hospi(Model model) {
    List<Hospital> hospitals = hospitalRepository.findAll();
    model.addAttribute("hospitals", hospitals);
    // hospitals 와 html안에 변수명 동일
    return "hospital";
  }

  @Autowired
  EmpRepository empRepository;

  @GetMapping("/emplist")
  public String empList(Model model) {
    List<Emp> empList = empRepository.findAll();
    model.addAttribute("empList", empList);
    return "emp";
  }

  @GetMapping("userList")
  public String userList(Model model) {

    List<Map<String, Object>> userList = new ArrayList<>();
    Map<String, Object> user = null;
    user = new HashMap<>();
    user.put("userId", "a");
    user.put("userName", "apple");
    user.put("userAge", 21);
    userList.add(user);
    user = new HashMap<>();
    user.put("userId", "b");
    user.put("userName", "banana");
    user.put("userAge", 22);
    userList.add(user);
    user = new HashMap<>();
    user.put("userId", "c");
    user.put("userName", "carrot");
    user.put("userAge", 23);
    userList.add(user);
    model.addAttribute("userList", userList);
    return "userList";
  }

  @GetMapping("/user")
  public String user(Model model) {
    Map<String, Object> user = null;
    user = new HashMap<>();
    user.put("userId", "z");
    user.put("userName", "zoo");
    user.put("userAge", 25);
    model.addAttribute("user", user);
    return "user";
  }

  @GetMapping("/welcome")
  public String welcome(Model model) {

    List<Emp> elist = empRepository.findAll();
    model.addAttribute("elist", elist);

    List<String> list = new ArrayList<>();
    list.add("A");
    list.add("B");

    Map<String, Object> map = new HashMap<>();
    map.put("k1", "값1");
    map.put("k2", "값2");

    model.addAttribute("list", list);
    model.addAttribute("map", map);

    return "welcome";
  }
}
