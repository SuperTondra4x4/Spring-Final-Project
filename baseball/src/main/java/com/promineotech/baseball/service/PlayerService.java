package com.promineotech.baseball.service;

import java.util.List;
import com.promineotech.baseball.entity.Player;
import com.promineotech.baseball.entity.PlayerPosition;

public interface PlayerService {

  List<Player> fetchPlayers(int player_pk);

  List<Player> createPlayer(int player_pk, String first_name, String last_name, PlayerPosition pos,
      int team_fk);

  }
