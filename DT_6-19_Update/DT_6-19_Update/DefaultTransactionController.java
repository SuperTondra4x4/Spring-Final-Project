package com.promineotech.baseball.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.promineotech.baseball.entity.Transaction;
import com.promineotech.baseball.entity.TransactionType;
import com.promineotech.baseball.service.TransactionService;
import lombok.extern.slf4j.Slf4j;


@RestController
@Slf4j
public class DefaultTransactionController implements TransactionController {
  
  @Autowired
  private TransactionService transactionService;
  

  @Override
  public List<Transaction> fetchTransactions(int transaction_pk) {
    log.info("fetching transactions");
    log.info("transaction_pk={}", transaction_pk);
    return transactionService.fetchTransactions(transaction_pk);
  }
  
  @Override
  public int createTransaction(int transaction_pk, int player_1_fk, int player_2_fk, int player_1_team_fk, int player_2_team_fk, TransactionType transaction_type) {
    log.info("Creating transactions");
    log.info("transaction_pk={}", transaction_pk);
    return transactionService.createTransaction(transaction_pk, player_1_fk, player_2_fk, player_1_team_fk, player_2_team_fk, transaction_type);
  }
  
  @Override
  public int updateTransaction(int transaction_pk, int player_1_fk, int player_2_fk) {
    log.info("Updating transaction with transaction_pk {}", transaction_pk);
    return transactionService.updateTransaction(transaction_pk, player_1_fk, player_2_fk);
  }
  
  @Override
  public int deleteTransaction(int transaction_pk) {
    log.info("Updating player with transaction_pk {}", transaction_pk);
    return transactionService.deleteTransaction(transaction_pk);
  }

}
