package com.example.basic.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.ToString;

@Entity
@Data
@ToString(exclude = "team")//exclude(team)을 제외 출력안함
public class Player {
  @Id
  int playerId;
  String playerName;

  @ManyToOne(fetch = FetchType.LAZY)// 원하는 부분
  @JoinColumn(name="team_id")
  @JsonIgnore // Json으로 만들어 질때 Team은 출력하지 않음
  Team team;
}
