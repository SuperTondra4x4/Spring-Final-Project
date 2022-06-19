package com.promineotech.baseball.entity;

import java.math.BigDecimal;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Team {
  private int team_pk;
  private String team_location;
  private String team_name;
  private int wins;
  private int losses;
}
