package com.promineotech.baseball.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.promineotech.baseball.entity.Player;
import com.promineotech.baseball.entity.PlayerPosition;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;

@Validated
@RequestMapping("/players")
@OpenAPIDefinition(info = @Info(title = "Player Service"), servers = { @Server(url = "http://localhost:8080", description = "Local server.")})

public interface PlayerController {
  


  // @formatter:off
  @Operation(
      summary = "Returns a list of Players",
      description = "Returns a list of Players given an optional model and/or trim",
      responses = {
          @ApiResponse(
              responseCode = "200", 
              description = "A list of Players is returned", 
              content = @Content(mediaType = "application/json", 
              schema = @Schema(implementation = Player.class))),
          @ApiResponse(
              responseCode = "400", 
              description = "The request parameters are invalid", 
              content = @Content(mediaType = "application/json")),
          @ApiResponse(
              responseCode = "404", 
              description = "No Players were found with the input criteria", 
              content = @Content(mediaType = "application/json")),
          @ApiResponse(
              responseCode = "500", 
              description = "An unplanned error occured", 
              content = @Content(mediaType = "application/json"))
      },
      parameters = {
          @Parameter(name = "player_pk", allowEmptyValue = false, required = false, description = "The player ID (i.e. '1')"),
          
      }
    )
  //formatter:on
  @GetMapping
  @ResponseStatus(code = HttpStatus.OK)
  List<Player> fetchPlayers(
      @RequestParam(required = false) int player_pk);

  @PostMapping
  @ResponseStatus(code = HttpStatus.OK)
  int createPlayer(int player_pk, String first_name, String last_name, PlayerPosition pos,
      int team_fk);
  
  @PutMapping
  @ResponseStatus(code = HttpStatus.OK)
  int updatePlayer(int player_pk, int team_fk);

  @DeleteMapping
  @ResponseStatus(code = HttpStatus.OK)
  int deletePlayer(int player_pk);
}

