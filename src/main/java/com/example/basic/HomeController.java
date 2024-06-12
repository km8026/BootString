package com.example.basic;

import org.springframework.stereotype.Controller;

@Controller
public class HomeController {
  public String home(){
    return "home";
  }
  
}
