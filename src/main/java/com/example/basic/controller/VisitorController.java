package com.example.basic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import com.example.basic.intercepter.IPCheckInterceptor;

@RestControlleroller
public class VisitorController {
  @Autowired IPCheckInterceptor ipCheckInterceptor;
  @GetMapping("/visitor")
  public String visitor(
      @RequestHeader("user-agent") String userAgent) {
    return userAgent;
  }
  
}
