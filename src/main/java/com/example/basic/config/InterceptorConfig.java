package com.example.basic.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.basic.intercepter.IPCheckInterceptor;
import com.example.basic.intercepter.SignInCheckInterceptor;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
  @Autowired
  private SignInCheckInterceptor signInCheckInterceptor;
  @Autowired
  private IPCheckInterceptor ipCheckInterceptor;

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(signInCheckInterceptor).addPathPatterns("/main");
    registry.addInterceptor(ipCheckInterceptor).addPathPatterns("/visitor");

    WebMvcConfigurer.super.addInterceptors(registry);
  }
}