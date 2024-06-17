package com.example.basic.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Team {
  @Id
  int teamId;
  String teamName;

  @OneToMany(mappedBy = "team", fetch = FetchType.EAGER) // 변수명을 연결, 데이터를 다데리고 옴
  List<Player> players = new ArrayList<>();
}
