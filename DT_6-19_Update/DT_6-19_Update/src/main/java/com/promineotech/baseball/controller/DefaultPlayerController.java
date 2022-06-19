package com.promineotech.baseball.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.promineotech.baseball.entity.Player;
import com.promineotech.baseball.entity.PlayerPosition;
import com.promineotech.baseball.service.PlayerService;
import lombok.extern.slf4j.Slf4j;


@RestController
@Slf4j
public class DefaultPlayerController implements PlayerController {
  
  @Autowired
  private PlayerService playerService;
  

  @Override
  public List<Player> fetchPlayers(int player_pk) {
    log.info("fetching players");
    log.info("player_pk={}", player_pk);
    return playerService.fetchPlayers(player_pk);
  }
  
  @Override
  public int createPlayer(int player_pk, String first_name, String last_name, PlayerPosition pos, int team_fk) {
    log.info("Creating players");
    log.info("player_pk={}", player_pk);
    return playerService.createPlayer(player_pk, first_name, last_name, pos, team_fk);
  }

  @Override
  public int updatePlayer(int player_pk, int team_fk) {
    log.info("Updating player with player_pk {}", player_pk);
    return playerService.updatePlayer(player_pk, team_fk);
  }
  
  @Override
  public int deletePlayer(int player_pk) {
    log.info("Updating player with player_pk {}", player_pk);
    return playerService.deletePlayer(player_pk);
  }

}
