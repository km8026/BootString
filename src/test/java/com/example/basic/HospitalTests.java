package com.example.basic;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.basic.entity.Hospital;
import com.example.basic.repository.HospitalRepository;

@SpringBootTest
public class HospitalTests {
  @Autowired
  HospitalRepository hospitalRepository;

  @Test 
  void Hospital조회(){
    List<Hospital> e = hospitalRepository.findBySidoContainingOrNameContaining("서울", "서울");
    System.out.println(e);
}
}
