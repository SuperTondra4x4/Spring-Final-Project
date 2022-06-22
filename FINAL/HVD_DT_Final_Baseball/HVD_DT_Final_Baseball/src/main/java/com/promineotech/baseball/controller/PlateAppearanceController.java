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
import com.promineotech.baseball.entity.PAResult;
import com.promineotech.baseball.entity.PlateAppearance;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;

@Validated
@RequestMapping("/plate appearances")
@OpenAPIDefinition(info = @Info(title = "plate appearance Service"), servers = { @Server(url = "http://localhost:8080", description = "Local server.")})

public interface PlateAppearanceController {
  
  // @formatter:off
  @Operation(
      summary = "Returns a Plate Appearance",
      description = "Returns a Plate Appearance",
      responses = {
          @ApiResponse(
              responseCode = "200", 
              description = "A Plate Appearances is returned", 
              content = @Content(mediaType = "application/json", 
              schema = @Schema(implementation = PlateAppearance.class))),
          @ApiResponse(
              responseCode = "400", 
              description = "The request parameters are invalid", 
              content = @Content(mediaType = "application/json")),
          @ApiResponse(
              responseCode = "404", 
              description = "No Plate Appearances were found with the input criteria", 
              content = @Content(mediaType = "application/json")),
          @ApiResponse(
              responseCode = "500", 
              description = "An unplanned error occured", 
              content = @Content(mediaType = "application/json"))
      },
      parameters = {
          @Parameter(name = "pa_pk", allowEmptyValue = false, required = false, description = "The plate appearance ID (i.e. '1')"),
          
      }
    )
  //formatter:on
  
  @GetMapping
  @ResponseStatus(code = HttpStatus.OK)
  List<PlateAppearance> fetchPlateAppearances(
      @RequestParam(required = false) int pa_pk);
  
  // @formatter:off
  @Operation(
      summary = "Creates a Plate Appearances",
      description = "Creates a Plate Appearances",
      responses = {
          @ApiResponse(
              responseCode = "200", 
              description = "A Plate Appearances was created", 
              content = @Content(mediaType = "application/json", 
              schema = @Schema(implementation = PlateAppearance.class))),
          @ApiResponse(
              responseCode = "400", 
              description = "The request parameters are invalid", 
              content = @Content(mediaType = "application/json")),
          @ApiResponse(
              responseCode = "404", 
              description = "No Plate Appearances were able to be created with the input criteria", 
              content = @Content(mediaType = "application/json")),
          @ApiResponse(
              responseCode = "500", 
              description = "An unplanned error occured", 
              content = @Content(mediaType = "application/json"))
      },
      parameters = {
          @Parameter(name = "pa_pk", allowEmptyValue = false, required = false, description = "The plate appearance ID (i.e. '1')"),
          
      }
    )
  //formatter:on

  @PostMapping
  @ResponseStatus(code = HttpStatus.OK)
  int createPlateAppearance(int pa_pk, int pitcher_fk, int batter_fk, PAResult par, int game_fk,
      float inning, int runs, int team_runs_fk);
  
  // @formatter:off
  @Operation(
      summary = "Modifies a Plate Appearances",
      description = "Modifies a Plate Appearances",
      responses = {
          @ApiResponse(
              responseCode = "200", 
              description = "A Plate Appearances was modified", 
              content = @Content(mediaType = "application/json", 
              schema = @Schema(implementation = PlateAppearance.class))),
          @ApiResponse(
              responseCode = "400", 
              description = "The request parameters are invalid", 
              content = @Content(mediaType = "application/json")),
          @ApiResponse(
              responseCode = "404", 
              description = "No Plate Appearances were able to be modified with the input criteria", 
              content = @Content(mediaType = "application/json")),
          @ApiResponse(
              responseCode = "500", 
              description = "An unplanned error occured", 
              content = @Content(mediaType = "application/json"))
      },
      parameters = {
          @Parameter(name = "pa_pk", allowEmptyValue = false, required = false, description = "The plate appearance ID (i.e. '1')"),
          
      }
    )
  //formatter:on
  
  @PutMapping
  @ResponseStatus(code = HttpStatus.OK)
  int updatePlateAppearance(int pa_pk, int game_fk);

  // @formatter:off
  @Operation(
      summary = "Deletes a Plate Appearances",
      description = "Deletes a Plate Appearances",
      responses = {
          @ApiResponse(
              responseCode = "200", 
              description = "A Plate Appearances was deleted", 
              content = @Content(mediaType = "application/json", 
              schema = @Schema(implementation = PlateAppearance.class))),
          @ApiResponse(
              responseCode = "400", 
              description = "The request parameters are invalid", 
              content = @Content(mediaType = "application/json")),
          @ApiResponse(
              responseCode = "404", 
              description = "No Plate Appearances were able to be deleted with the input criteria", 
              content = @Content(mediaType = "application/json")),
          @ApiResponse(
              responseCode = "500", 
              description = "An unplanned error occured", 
              content = @Content(mediaType = "application/json"))
      },
      parameters = {
          @Parameter(name = "pa_pk", allowEmptyValue = false, required = false, description = "The plate appearance ID (i.e. '1')"),
          
      }
    )
  //formatter:on
  
  @DeleteMapping
  @ResponseStatus(code = HttpStatus.OK)
  int deletePlateAppearance(int pa_pk);










}

