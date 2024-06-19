package com.example.basic.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class User {
  // join2  방법
  // public User() {}
  // public User(String userId, String userPw) {
  //   this.userId = userId;
  //   this.userPw = userPw;
  // }

  @Id
  String userId;
  String userPw;
}
