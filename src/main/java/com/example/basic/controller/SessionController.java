package com.example.basic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.basic.model.User;

import jakarta.servlet.http.HttpSession;

@Controller
public class SessionController {
  @GetMapping("/login")
  public String login() {
    return "login";
  }

  @PostMapping("/login")
  public String loginPost(User user, HttpSession session) {
    session.setAttribute("user", user);
    return "redirect:/main";
  }

  @GetMapping("/logout")
  public String logout(HttpSession session){
    session.invalidate();
    session.removeAttribute("user");
    return "redirect:/login";
  }
  
// main 로그인 상태여야 오류X
  @GetMapping("/main")
  public String main(HttpSession session) {
         // 형 변환
   User u = (User) session.getAttribute("user");
   if(u == null){
    return "redirect:/login"; // 로그인 페이지로 리다이렉트
   }
   String id = u.getUserId(); 
   String pw = u.getUserPw();
   System.out.println(id + ", " + pw); 
   return "main";
  }

}
