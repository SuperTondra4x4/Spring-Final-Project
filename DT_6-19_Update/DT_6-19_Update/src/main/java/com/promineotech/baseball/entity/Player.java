package com.promineotech.baseball.entity;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Player implements Comparable<Player> {
  private int player_pk;
  private PlayerPosition player_position;
  private String first_name;
  private String last_name;
  private int team_fk;

  @JsonIgnore
  public int getPlayerPK() {
    return player_pk;
  }
  
  @JsonIgnore
  public String getPlayerName() {
    return first_name;
  }
  @JsonIgnore
  public PlayerPosition getPlayerPosition() {
    return player_position;
  }
  public int compareTo(Player that) {

    return Comparator
        .comparing(Player::getPlayer_pk)
        .thenComparing(Player::getPlayerName)
        .thenComparing(Player::getPlayerPosition)
        .compare(this, that);
  }
}
