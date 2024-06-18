package com.example.basic.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.basic.entity.Emp;

public interface EmpRepository 
  extends JpaRepository<Emp, Integer>{

    // 추상 메소드
    public Emp findByENAME(String ename);
                // 필수           변수명
    public Emp findByENAMELike(String ename);
              // 이름안에 포함된 문자찾기
    public List<Emp> findBySALGreaterThan(Integer sal);
}
