package com.promineotech.baseball.service;

import java.util.List;
import com.promineotech.baseball.entity.Jeep;
import com.promineotech.baseball.entity.JeepModel;
import com.promineotech.baseball.entity.Player;

public interface PlayerService {

  List<Player> fetchPlayers(int player_pk);

  }
