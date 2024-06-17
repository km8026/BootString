package com.example.basic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.basic.entity.Dept;

@Repository
public interface DeptRepository 
  extends JpaRepository<Dept, Integer>{ 
}
