package com.example.basic.intercepter;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.example.basic.model.UserModel;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class RefererInterceptor implements HandlerInterceptor {
  @Override
  public boolean preHandle(
      HttpServletRequest request, HttpServletResponse response,
      Object handler) throws Exception {

        String referer = request.getHeader("referer");

   if (referer == null
        || referer.indexOf("localhost")== -1 
        || referer.indexOf("127.0.0.1")== -1) {
     response.sendRedirect("/login");
     return false;
   }
    return true;
  }
  
}
