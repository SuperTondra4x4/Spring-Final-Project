package com.promineotech.baseball.dao;

import java.util.List;
import com.promineotech.baseball.entity.Jeep;
import com.promineotech.baseball.entity.JeepModel;
import com.promineotech.baseball.entity.Player;

public interface PlayerDao {

  List<Player> fetchPlayers(int player_pk);

}
