package com.example.basic.controller;

import java.io.IOException;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;

import com.example.basic.entity.BoardFileTest;
import com.example.basic.entity.BoardTest;
import com.example.basic.repository.BoardFileTestRepository;
import com.example.basic.repository.BoardTestRepository;


@RestController
public class BoardTestController {
 @Autowired BoardTestRepository boardTestRepository;
 @Autowired BoardFileTestRepository boardFileTestRepository;
//AOP를 기반으로 동작 트랜잭션을 시작하고, 커밋하거나 롤백하는 코드를 작성할 필요 없이
// 스프링이 자동으로 트랜잭션 경계를 관리
 @Transactional(
  rollbackFor = {Exception.class, IOException.class} // 속성은 특정 예외가 발생했을 때 트랜잭션을 롤백
  //Exception이나 IOException 같은 체크 예외는 기본적으로 롤백되지 않기 때문에 
  //rollbackFor 속성으로 롤백을 지정
 )
 @GetMapping("/board_test")
 public String boardTest(@ModelAttribute BoardTest board) throws Exception {
   BoardTest dbBoard = boardTestRepository.save(board);

   BoardFileTest file = new BoardFileTest();
   file.setFileName("A");
   file.setBoard(dbBoard);
   
   if (true) {
     throw new Exception(); // 그냥 Exception으로 나뉨 체크예외/ Runtime은 언체크예외
      //RuntimeException과 Error는 항상 롤백
    }

   boardFileTestRepository.save(file);

   return "완료";
 }
}
