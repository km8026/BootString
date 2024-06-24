package com.example.basic.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
@Component
public class ControllerAspect {
  @Before(value = "execution (* com.example.basic.repository.*.*(..))")
                                // 내 상황에 맞춰서 적음
  public void onBeforeHandler(JoinPoint joinPoint) {
    log.debug("@Before run");
  }

  @Pointcut(value = "execution(* com.example.basic.repository.*.*(..))")
  private void pointCut() {
  }

  @Around(value = "pointCut()")
  public Object aroundAdvice(ProceedingJoinPoint jp) throws Throwable {
    // System.out.println("before around");
    Object returnData =null;
    try {
      returnData = jp.proceed();
      // return jp.proceed();
    // } catch(Exception e){
    //   log.debug("error!!!!!!!!");      
    //   log.debug(e.getMessage());      
    } finally {
      if(returnData != null) log.debug(returnData.toString());
    }
    return returnData;
    // System.out.println("after around");
  }
}

  // @After(value = "execution (* com.example.basic.controller.*.*(..))")
  // public void onAfterHandler(JoinPoint joinPoint) {
  //   log.debug("@After run");
  // }

  // @AfterReturning(value = "execution (* com.example.basic.controller.*.*(..))", returning = "data")
  // public void onAfterReturningHandler(JoinPoint joinPoint, Object data) {
  //   if (data != null) {
  //     log.debug(data.toString());
  //   }
  //   log.debug("@AfterReturning run");
  // }
