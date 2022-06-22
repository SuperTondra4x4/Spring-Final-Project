package com.promineotech.baseball.dao;

import java.util.List;
import com.promineotech.baseball.entity.Player;
import com.promineotech.baseball.entity.PlayerPosition;

public interface PlayerDao {

  List<Player> fetchPlayers(int player_pk);

  int createPlayer(int player_pk, String first_name, String last_name, PlayerPosition pos,
      int team_fk);
  
  int updatePlayer(int player_pk, int team_fk);

  
  int deletePlayer(int player_pk);
}
