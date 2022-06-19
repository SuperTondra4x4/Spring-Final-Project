package com.promineotech.baseball.controller.support;

import static org.assertj.core.api.Assertions.assertThat;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.springframework.http.HttpStatus;
import com.promineotech.baseball.entity.Player;

public class FetchPlayerTestSupport extends BaseTest {
  
  protected List<Player> buildExpected() {
    List<Player> list = new LinkedList<>();
    
    list.add(Player.builder()
        .player_pk(1)
        .first_name("Sonny")
        .last_name("Gray")
        .team_fk(1)
        .build());
    
    
     Collections.sort(list);  
     
    return list;
  }
  protected void assertErrorMessageValid(Map<String, Object> error, HttpStatus status) {
    assertThat(error)
    .containsKey("message")
    .containsEntry("status code", status.value())
    .containsEntry("uri", "/players")
    .containsKey("timestamp")
    .containsEntry("reason", status.getReasonPhrase());
    
  }
}

