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
import com.promineotech.baseball.entity.Game;
import com.promineotech.baseball.entity.GameResult;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;

@Validated
@RequestMapping("/games")
@OpenAPIDefinition(info = @Info(title = "Game Service"), servers = { @Server(url = "http://localhost:8080", description = "Local server.")})

public interface GameController {
  


  // @formatter:off
  @Operation(
      summary = "Returns a Game",
      description = "Returns a Game",
      responses = {
          @ApiResponse(
              responseCode = "200", 
              description = "A Games is returned", 
              content = @Content(mediaType = "application/json", 
              schema = @Schema(implementation = Game.class))),
          @ApiResponse(
              responseCode = "400", 
              description = "The request parameters are invalid", 
              content = @Content(mediaType = "application/json")),
          @ApiResponse(
              responseCode = "404", 
              description = "No Games were found with the input criteria", 
              content = @Content(mediaType = "application/json")),
          @ApiResponse(
              responseCode = "500", 
              description = "An unplanned error occured", 
              content = @Content(mediaType = "application/json"))
      },
      parameters = {
          @Parameter(name = "game_pk", allowEmptyValue = false, required = false, description = "The game ID (i.e. '1')"),
          
      }
    )
  //formatter:on
  @GetMapping
  @ResponseStatus(code = HttpStatus.OK)
  List<Game> fetchGames(
      @RequestParam(required = false) int game_pk);

  @Operation(
      summary = "Creates a Game",
      description = "Creates a Game",
      responses = {
          @ApiResponse(
              responseCode = "200", 
              description = "A Game was created", 
              content = @Content(mediaType = "application/json", 
              schema = @Schema(implementation = Game.class))),
          @ApiResponse(
              responseCode = "400", 
              description = "The request parameters are invalid", 
              content = @Content(mediaType = "application/json")),
          @ApiResponse(
              responseCode = "404", 
              description = "No Games were able to be created with the input criteria", 
              content = @Content(mediaType = "application/json")),
          @ApiResponse(
              responseCode = "500", 
              description = "An unplanned error occured", 
              content = @Content(mediaType = "application/json"))
      },
      parameters = {
          @Parameter(name = "game_pk", allowEmptyValue = false, required = false, description = "The game ID (i.e. '1')"),
          
      }
    )
  
  @PostMapping
  @ResponseStatus(code = HttpStatus.OK)
  int createGame(int game_pk, int team_1_fk, int team_2_fk, GameResult team_1_result, GameResult team_2_result);
  
  @Operation(
      summary = "Modifies a Game",
      description = "Modifies a Game",
      responses = {
          @ApiResponse(
              responseCode = "200", 
              description = "A Game was modified", 
              content = @Content(mediaType = "application/json", 
              schema = @Schema(implementation = Game.class))),
          @ApiResponse(
              responseCode = "400", 
              description = "The request parameters are invalid", 
              content = @Content(mediaType = "application/json")),
          @ApiResponse(
              responseCode = "404", 
              description = "No Games were able to be modified with the input criteria", 
              content = @Content(mediaType = "application/json")),
          @ApiResponse(
              responseCode = "500", 
              description = "An unplanned error occured", 
              content = @Content(mediaType = "application/json"))
      },
      parameters = {
          @Parameter(name = "game_pk", allowEmptyValue = false, required = false, description = "The game ID (i.e. '1')"),
          
      }
    )
  
  @PutMapping
  @ResponseStatus(code = HttpStatus.OK) 
  int updateGame(int game_pk, GameResult team_1_result, GameResult team_2_result);
  
  @Operation(
      summary = "Deletes a Game",
      description = "Deletes a Game",
      responses = {
          @ApiResponse(
              responseCode = "200", 
              description = "A Game was deleted", 
              content = @Content(mediaType = "application/json", 
              schema = @Schema(implementation = Game.class))),
          @ApiResponse(
              responseCode = "400", 
              description = "The request parameters are invalid", 
              content = @Content(mediaType = "application/json")),
          @ApiResponse(
              responseCode = "404", 
              description = "No Games were able to be deleted with the input criteria", 
              content = @Content(mediaType = "application/json")),
          @ApiResponse(
              responseCode = "500", 
              description = "An unplanned error occured", 
              content = @Content(mediaType = "application/json"))
      },
      parameters = {
          @Parameter(name = "game_pk", allowEmptyValue = false, required = false, description = "The game ID (i.e. '1')"),
          
      }
    )
  
  @DeleteMapping
  @ResponseStatus(code = HttpStatus.OK)
  int deleteGame(int game_pk);
//formatter:off


}

