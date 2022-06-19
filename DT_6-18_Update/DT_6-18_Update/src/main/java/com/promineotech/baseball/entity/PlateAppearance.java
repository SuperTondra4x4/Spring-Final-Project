package com.promineotech.baseball.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PlateAppearance {
  private int pa_pk;
  private int pitcher_fk;
  private int batter_fk;
  private PAResult pa_result;
  private int game_fk;
  private float inning;
  private int runs;
  private int team_runs_fk;
}
