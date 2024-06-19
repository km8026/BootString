package com.example.basic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.basic.entity.Board;
import com.example.basic.entity.User;
import com.example.basic.model.BoardModel;
import com.example.basic.model.UserModel;
import com.example.basic.repository.BoardRepository;
import com.example.basic.repository.UserRepository;
import com.example.basic.util.EcUtil;

import jakarta.servlet.http.HttpSession;

@Controller
public class SessionController {
  @Autowired
  BoardRepository boardRepository;
  @Autowired
  UserRepository userRepository;
  @Autowired
  EcUtil ecUtil;

  @GetMapping("/board")
  public String board(){
    return "board";
  }

  @PostMapping("/board")
  public String boardpost(BoardModel boardModel){
    Board b = new Board();
    b.setTitle(boardModel.getTitle());
    boardRepository.save(b);
    return "redirect:/main";
  }

  @GetMapping("/join")
  public String join() {
    return "join";
  }

  @PostMapping("/join") // 모델로 들고와서 UserEntity로 변형
  public String joinpost(UserModel user){
    User a = new User(); // 생성
    a.setUserId(user.getUserId()); // 빼서 넣는다 
    String encodedPw = ecUtil.encode(user.getUserPw());
    a.setUserPw(encodedPw);
    
    userRepository.save(a);
    return "redirect:/login";
  }
  
  // @PostMapping("/join2")
  // // 모델을 User.java에서 만들어서 만듬
  // public String joins2(UserModel user, HttpSession session){
  //   // user.java 작성시 생성가능
  //   User u = 
  //       new User(user.getUserId(), user.getUserPw());
  //   User dbUser =
  //   userRepository.save(u);

  //   return "join";
  // }
  
  

  @GetMapping("/login")
  public String login() {
    return "login";
  }

  @PostMapping("/login")
  public String loginPost(UserModel user, HttpSession session) {
    com.example.basic.entity.User dbUser = userRepository.findByUserIdAndUserPw(user.getUserId(), user.getUserPw());
    session.setAttribute("user", user);
    if (dbUser == null) {
      return "redirect:/login";
    }

    session.setAttribute("user", user);
    return "redirect:/main";
  }

  @GetMapping("/logout")
  public String logout(HttpSession session) {
    session.invalidate();
    session.removeAttribute("user");
    return "redirect:/login";
  }

  // main 로그인 상태여야 오류X
  @GetMapping("/main")
  public String main(HttpSession session) {
    // 형 변환
    UserModel u = (UserModel) session.getAttribute("user");
    if (u == null) {
      return "redirect:/login"; // 로그인 페이지로 리다이렉트
    }
    String id = u.getUserId();
    String pw = u.getUserPw();
    System.out.println(id + ", " + pw);
    return "main";
  }

}
