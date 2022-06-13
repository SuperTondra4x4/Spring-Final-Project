package com.promineotech.baseball.service;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.promineotech.baseball.dao.PlayerDao;
import com.promineotech.baseball.entity.Jeep;
import com.promineotech.baseball.entity.JeepModel;
import com.promineotech.baseball.entity.Player;
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

}
