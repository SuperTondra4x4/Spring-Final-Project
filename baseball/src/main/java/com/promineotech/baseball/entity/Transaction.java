package com.promineotech.baseball.entity;

import java.math.BigDecimal;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Transaction {
  private int transaction_pk;
  private int player_1_fk;
  private int player_1_team_fk;
  private int player_2_fk;
  private int player_2_team_fk;
  private TransactionType transaction_type;
}
