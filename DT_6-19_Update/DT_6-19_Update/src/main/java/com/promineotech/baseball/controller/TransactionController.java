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
import com.promineotech.baseball.entity.Transaction;
import com.promineotech.baseball.entity.TransactionType;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;

@Validated
@RequestMapping("/transactions")
@OpenAPIDefinition(info = @Info(title = "Transaction Service"), servers = { @Server(url = "http://localhost:8080", description = "Local server.")})

public interface TransactionController {
  
  // @formatter:off
  @Operation(
      summary = "Returns a Transaction",
      description = "Returns a Transaction",
      responses = {
          @ApiResponse(
              responseCode = "200", 
              description = "A Transaction is returned", 
              content = @Content(mediaType = "application/json", 
              schema = @Schema(implementation = Transaction.class))),
          @ApiResponse(
              responseCode = "400", 
              description = "The request parameters are invalid", 
              content = @Content(mediaType = "application/json")),
          @ApiResponse(
              responseCode = "404", 
              description = "No Transactions were found with the input criteria", 
              content = @Content(mediaType = "application/json")),
          @ApiResponse(
              responseCode = "500", 
              description = "An unplanned error occured", 
              content = @Content(mediaType = "application/json"))
      },
      parameters = {
          @Parameter(name = "transaction_pk", allowEmptyValue = false, required = false, description = "The transaction ID (i.e. '1')"),
          
      }
    )
  //formatter:on
  
  @GetMapping
  @ResponseStatus(code = HttpStatus.OK)
  List<Transaction> fetchTransactions(
      @RequestParam(required = false) int transaction_pk);
  
  // @formatter:off
  @Operation(
      summary = "Creates a Transaction",
      description = "Creates a Transaction",
      responses = {
          @ApiResponse(
              responseCode = "200", 
              description = "A Transaction was created", 
              content = @Content(mediaType = "application/json", 
              schema = @Schema(implementation = Transaction.class))),
          @ApiResponse(
              responseCode = "400", 
              description = "The request parameters are invalid", 
              content = @Content(mediaType = "application/json")),
          @ApiResponse(
              responseCode = "404", 
              description = "A Transaction was not able to be created with those criteria", 
              content = @Content(mediaType = "application/json")),
          @ApiResponse(
              responseCode = "500", 
              description = "An unplanned error occured", 
              content = @Content(mediaType = "application/json"))
      },
      parameters = {
          @Parameter(name = "transaction_pk", allowEmptyValue = false, required = false, description = "The transaction ID (i.e. '1')"),
          
      }
    )
  //formatter:on

  @PostMapping
  @ResponseStatus(code = HttpStatus.OK)
  int createTransaction(int transaction_pk, int player_1_fk, int player_2_fk, int player_1_team_fk, int player_2_team_fk, TransactionType transaction_type);
  
  // @formatter:off
  @Operation(
      summary = "Modifies a Transaction",
      description = "Modifies a Transaction",
      responses = {
          @ApiResponse(
              responseCode = "200", 
              description = "The Transaction was modified", 
              content = @Content(mediaType = "application/json", 
              schema = @Schema(implementation = Transaction.class))),
          @ApiResponse(
              responseCode = "400", 
              description = "The request parameters are invalid", 
              content = @Content(mediaType = "application/json")),
          @ApiResponse(
              responseCode = "404", 
              description = "No Transactions were found with the input criteria", 
              content = @Content(mediaType = "application/json")),
          @ApiResponse(
              responseCode = "500", 
              description = "An unplanned error occured", 
              content = @Content(mediaType = "application/json"))
      },
      parameters = {
          @Parameter(name = "transaction_pk", allowEmptyValue = false, required = false, description = "The transaction ID (i.e. '1')"),
          
      }
    )
  //formatter:on
  
  @PutMapping
  @ResponseStatus(code = HttpStatus.OK)
  int updateTransaction(int transaction_pk, int player_1_fk, int player_2_fk);
  
  // @formatter:off
  @Operation(
      summary = "Deletes a Transaction",
      description = "Deletes a Transaction",
      responses = {
          @ApiResponse(
              responseCode = "200", 
              description = "The Transaction was deleted", 
              content = @Content(mediaType = "application/json", 
              schema = @Schema(implementation = Transaction.class))),
          @ApiResponse(
              responseCode = "400", 
              description = "The request parameters are invalid", 
              content = @Content(mediaType = "application/json")),
          @ApiResponse(
              responseCode = "404", 
              description = "No Transactions were found with the input criteria", 
              content = @Content(mediaType = "application/json")),
          @ApiResponse(
              responseCode = "500", 
              description = "An unplanned error occured", 
              content = @Content(mediaType = "application/json"))
      },
      parameters = {
          @Parameter(name = "transaction_pk", allowEmptyValue = false, required = false, description = "The transaction ID (i.e. '1')"),
          
      }
    )
  //formatter:on
  
  @DeleteMapping
  @ResponseStatus(code = HttpStatus.OK)
  int deleteTransaction(int transaction_pk);
//formatter:off


}

