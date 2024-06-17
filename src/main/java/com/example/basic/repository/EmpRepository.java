package com.example.basic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.basic.entity.Emp;

@Repository
public interface EmpRepository 
  extends JpaRepository<Emp, Integer>{
}
