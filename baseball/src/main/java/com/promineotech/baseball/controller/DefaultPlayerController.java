package com.promineotech.baseball.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.promineotech.baseball.entity.Jeep;
import com.promineotech.baseball.entity.JeepModel;
import com.promineotech.baseball.entity.Player;
import com.promineotech.baseball.service.PlayerService;
import lombok.extern.slf4j.Slf4j;


@RestController
@Slf4j
public class DefaultPlayerController implements PlayerController {
  
  @Autowired
  private PlayerService jeepSalesService;
  

  @Override
  public List<Player> fetchPlayers(int player_pk) {
    log.info("player_pk={}", player_pk);
    return jeepSalesService.fetchPlayers(player_pk);
  }

}
