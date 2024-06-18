package com.example.basic.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.basic.entity.Emp;
import com.example.basic.entity.Hospital;
import com.example.basic.repository.EmpRepository;
import com.example.basic.repository.HospitalRepository;

@Controller
public class ThymeleafController {
  @Autowired
  HospitalRepository hospitalRepository;

  @GetMapping("/hospitallist")
  public String hospi(Model model){
    List<Hospital> hospitals= hospitalRepository.findAll();
    model.addAttribute("hospitals", hospitals);
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
