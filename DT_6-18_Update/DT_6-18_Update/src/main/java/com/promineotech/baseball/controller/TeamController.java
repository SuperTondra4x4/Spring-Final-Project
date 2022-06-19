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
import com.promineotech.baseball.entity.Team;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;

@Validated
@RequestMapping("/teams")
@OpenAPIDefinition(info = @Info(title = "Team Service"), servers = { @Server(url = "http://localhost:8080", description = "Local server.")})

public interface TeamController {
  


  // @formatter:off
  @Operation(
      summary = "Returns a list of Teams",
      description = "Returns a list of Teams",
      responses = {
          @ApiResponse(
              responseCode = "200", 
              description = "A list of Teams is returned", 
              content = @Content(mediaType = "application/json", 
              schema = @Schema(implementation = Team.class))),
          @ApiResponse(
              responseCode = "400", 
              description = "The request parameters are invalid", 
              content = @Content(mediaType = "application/json")),
          @ApiResponse(
              responseCode = "404", 
              description = "No Teams were found with the input criteria", 
              content = @Content(mediaType = "application/json")),
          @ApiResponse(
              responseCode = "500", 
              description = "An unplanned error occured", 
              content = @Content(mediaType = "application/json"))
      },
      parameters = {
          @Parameter(name = "team_pk", allowEmptyValue = false, required = false, description = "The team ID (i.e. '1')"),
          
      }
    )
  //formatter:on
  @GetMapping
  @ResponseStatus(code = HttpStatus.OK)
  List<Team> fetchTeams(
      @RequestParam(required = false) int team_pk);

  @PostMapping
  @ResponseStatus(code = HttpStatus.OK)
  int createTeam(int team_pk, String team_location, String team_name, int wins,
      int losses);
  
  @PutMapping
  @ResponseStatus(code = HttpStatus.OK)
  int updateTeam(int team_pk, String team_location);

  @DeleteMapping
  @ResponseStatus(code = HttpStatus.OK)
  int deleteTeam(int team_pk);
}

