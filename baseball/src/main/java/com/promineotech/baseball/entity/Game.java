package com.promineotech.baseball.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Game {
  private int game_pk;
  private int team_1_fk;
  private GameResult team_1_result;
  private int team_2_fk;
  private GameResult team_2_result;
}
