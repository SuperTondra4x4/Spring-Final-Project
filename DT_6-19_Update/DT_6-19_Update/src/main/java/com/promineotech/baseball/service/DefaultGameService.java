package com.promineotech.baseball.service;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.promineotech.baseball.dao.GameDao;
import com.promineotech.baseball.entity.Game;
import com.promineotech.baseball.entity.GameResult;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service


public class DefaultGameService implements GameService {
  
  @Autowired
  private GameDao gameDao;

  @Override
  @Transactional (readOnly = true)
  public List<Game> fetchGames(int game_pk){
    log.info("The fetchGames method was called with game_pk={}",
    game_pk);
    
    List<Game> games = gameDao.fetchGames(game_pk);
    
    if(games.isEmpty()) {
      String msg = String.format("No games were found with game_pk=%s", game_pk);
      throw new NoSuchElementException(msg);
    }
    
    
    return games;
    
  }
  
  @Override
  @Transactional (readOnly = false)
  public int createGame(int game_pk, int team_1_fk, int team_2_fk, GameResult team_1_result, GameResult team_2_result) {
    log.info("The createGames method was called with game_pk={}",
    game_pk);
    
    int games = gameDao.createGame(game_pk, team_1_fk, team_2_fk, team_1_result, team_2_result	);
    
    if(games < 1) {
      String msg = String.format("No games were created with game_pk=%s", game_pk);
      throw new NoSuchElementException(msg);
    }
    fetchGames(game_pk);
    return games;
    
  }
  
  @Override
  @Transactional (readOnly = false)
  public int updateGame(int game_pk, GameResult team_1_result, GameResult team_2_result) {
    log.info("The createGames method was called with game_pk={}",
    game_pk);
    
    int games = gameDao.updateGame(game_pk, team_1_result, team_2_result);
    
    if(games < 1) {
      String msg = String.format("No games were updated with game_pk=%s", game_pk);
      throw new NoSuchElementException(msg);
    }
    fetchGames(game_pk);
    return games;
    
  }

  @Override
  public int deleteGame(int game_pk) {
    log.info("The deleteGames method was called with game_pk={}",
    game_pk);
    
    int games = gameDao.deleteGame(game_pk);
    
    if(games < 1) {
      String msg = String.format("No games were updated with game_pk=%s", game_pk);
      throw new NoSuchElementException(msg);
    }
    
    try {
      fetchGames(game_pk);
    }
    
    catch(Exception e) {
      log.info("Game with game_pk={} was not found", game_pk);
    }
    
    return games;
    
  }

}
