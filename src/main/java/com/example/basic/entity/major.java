package com.example.basic.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;



@Entity
@Data
public class Major {
  @Id @GeneratedValue
  Integer id;
  @Column (length = 255, nullable = true)
  String name;
  @Column(name = "max_prsn", nullable = false)
  Integer max_prsn;
  
  @Column(name = "ebtb_date", nullable = true)
  @Temporal(TemporalType.TIMESTAMP)
  Date ebtbDate;
}
