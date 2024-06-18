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
import com.example.basic.repository.EmpRepository;

@Controller
public class ThymeleafController {
  @Autowired
  EmpRepository empRepository;

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
  public String welcome(Model model){
    

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
