package com.example.basic.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity(name = "table_exam_1")
@Data
public class TableExam1 {
  @Id @GeneratedValue
  Integer id;
  @Column(length = 100, nullable = false)
  String title;
  @Column(name = "description", length = 1000, nullable = true)
  String content;
  Long price;
  String brand;
}
