package com.example.basic.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.basic.entity.Course;

@Repository
public interface CourseRepository
extends JpaRepository<Course, Integer> {
}