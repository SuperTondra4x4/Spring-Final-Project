package com.promineotech.baseball.controller.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import lombok.Getter;

abstract class BaseTest {
  @LocalServerPort
  private int serverPort;
  
  @Autowired
  @Getter
  protected TestRestTemplate restTemplate;
  
  protected String getBaseUriForPlayers() {
    return String.format("http://localhost:%d/players", serverPort);
    
  }
}
