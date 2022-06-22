package com.promineotech.baseball.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.promineotech.baseball.entity.Game;
import com.promineotech.baseball.entity.GameResult;
import com.promineotech.baseball.service.GameService;
import lombok.extern.slf4j.Slf4j;


@RestController
@Slf4j
public class DefaultGameController implements GameController {
  
  @Autowired
  private GameService gameService;
  

  @Override
  public List<Game> fetchGames(int game_pk) {
    log.info("fetching games");
    log.info("game_pk={}", game_pk);
    return gameService.fetchGames(game_pk);
  }
  
  @Override
  public int createGame(int game_pk, int team_1_fk, int team_2_fk, GameResult team_1_result, GameResult team_2_result) {
    log.info("Creating games");
    log.info("game_pk={}", game_pk);
    return gameService.createGame(game_pk, team_1_fk, team_2_fk, team_1_result, team_2_result);
  }
  
  @Override
  public int updateGame(int game_pk, GameResult team_1_result, GameResult team_2_result) {
    log.info("Updating game with game_pk {}", game_pk);
    return gameService.updateGame(game_pk, team_1_result, team_2_result);
  }
  
  @Override
  public int deleteGame(int game_pk) {
    log.info("Updating player with game_pk {}", game_pk);
    return gameService.deleteGame(game_pk);
  }

}
