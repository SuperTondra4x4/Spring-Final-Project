package com.promineotech.baseball.service;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.promineotech.baseball.dao.PlayerDao;
import com.promineotech.baseball.entity.Player;
import com.promineotech.baseball.entity.PlayerPosition;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service


public class DefaultPlayerService implements PlayerService {
  
  @Autowired
  private PlayerDao playerDao;

  @Override
  @Transactional (readOnly = true)
  public List<Player> fetchPlayers(int player_pk){
    log.info("The fetchPlayers method was called with player_pk={}",
    player_pk);
    
    List<Player> players = playerDao.fetchPlayers(player_pk);
    
    if(players.isEmpty()) {
      String msg = String.format("No players were found with player_pk=%s", player_pk);
      throw new NoSuchElementException(msg);
    }
    
    Collections.sort(players);
    return players;
    
  }
  
  @Override
  @Transactional (readOnly = false)
  public int createPlayer(int player_pk, String first_name, String last_name, PlayerPosition pos, int team_fk) {
    log.info("The createPlayers method was called with player_pk={}",
    player_pk);
    
    int players = playerDao.createPlayer(player_pk, first_name, last_name, pos, team_fk);
    
    if(players < 1) {
      String msg = String.format("No players were created with player_pk=%s", player_pk);
      throw new NoSuchElementException(msg);
    }
    fetchPlayers(player_pk);
    return players;
    
  }
  
  @Override
  @Transactional (readOnly = false)
  public int updatePlayer(int player_pk, int team_fk) {
    log.info("The createPlayers method was called with player_pk={}",
    player_pk);
    
    int players = playerDao.updatePlayer(player_pk, team_fk);
    
    if(players < 1) {
      String msg = String.format("No players were updated with player_pk=%s", player_pk);
      throw new NoSuchElementException(msg);
    }
    fetchPlayers(player_pk);
    return players;
    
  }

  @Override
  public int deletePlayer(int player_pk) {
    log.info("The deletePlayers method was called with player_pk={}",
    player_pk);
    
    int players = playerDao.deletePlayer(player_pk);
    
    if(players < 1) {
      String msg = String.format("No players were updated with player_pk=%s", player_pk);
      throw new NoSuchElementException(msg);
    }
    
    try {
      fetchPlayers(player_pk);
    }
    
    catch(Exception e) {
      log.info("Player with player_pk={} was not found", player_pk);
    }
    
    return players;
    
  }

}
