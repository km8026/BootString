package com.example.basic.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.basic.entity.Emp;

public interface EmpRepository 
  extends JpaRepository<Emp, Integer>{
    public Emp findByENAME(String ename);
    public Emp findByENAMELike(String ename);
    public List<Emp> findBySALGreaterThan(Integer sal);
}
