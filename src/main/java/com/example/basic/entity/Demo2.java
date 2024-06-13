package com.example.basic.entity;

import java.time.LocalDateTime;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Demo2 {
  @Id
  long seq;
  String user3;
  int age;
  Date date1;
  LocalDateTime date2;
}
