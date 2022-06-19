package com.promineotech.baseball.service;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.promineotech.baseball.dao.TransactionDao;
import com.promineotech.baseball.entity.Transaction;
import com.promineotech.baseball.entity.TransactionType;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service


public class DefaultTransactionService implements TransactionService {
  
  @Autowired
  private TransactionDao transactionDao;

  @Override
  @Transactional (readOnly = true)
  public List<Transaction> fetchTransactions(int transaction_pk){
    log.info("The fetchTransactions method was called with transaction_pk={}",
    transaction_pk);
    
    List<Transaction> transactions = transactionDao.fetchTransactions(transaction_pk);
    
    if(transactions.isEmpty()) {
      String msg = String.format("No transactions were found with transaction_pk=%s", transaction_pk);
      throw new NoSuchElementException(msg);
    }
    
    
    return transactions;
    
  }
  
  @Override
  @Transactional (readOnly = false)
  public int createTransaction(int transaction_pk, int player_1_fk, int player_2_fk, int player_1_team_fk, int player_2_team_fk, TransactionType transaction_type) {
    log.info("The createTransactions method was called with transaction_pk={}",
    transaction_pk);
    
    int transactions = transactionDao.createTransaction(transaction_pk, player_1_fk, player_2_fk, player_1_team_fk, player_2_team_fk, transaction_type	);
    
    if(transactions < 1) {
      String msg = String.format("No transactions were created with transaction_pk=%s", transaction_pk);
      throw new NoSuchElementException(msg);
    }
    fetchTransactions(transaction_pk);
    return transactions;
    
  }
  
  @Override
  @Transactional (readOnly = false)
  public int updateTransaction(int transaction_pk, int player_1_fk, int player_2_fk) {
    log.info("The createTransactions method was called with transaction_pk={}",
    transaction_pk);
    
    int transactions = transactionDao.updateTransaction(transaction_pk, player_1_fk, player_2_fk);
    
    if(transactions < 1) {
      String msg = String.format("No transactions were updated with transaction_pk=%s", transaction_pk);
      throw new NoSuchElementException(msg);
    }
    fetchTransactions(transaction_pk);
    return transactions;
    
  }

  @Override
  public int deleteTransaction(int transaction_pk) {
    log.info("The deleteTransactions method was called with transaction_pk={}",
    transaction_pk);
    
    int transactions = transactionDao.deleteTransaction(transaction_pk);
    
    if(transactions < 1) {
      String msg = String.format("No transactions were updated with transaction_pk=%s", transaction_pk);
      throw new NoSuchElementException(msg);
    }
    
    try {
      fetchTransactions(transaction_pk);
    }
    
    catch(Exception e) {
      log.info("Transaction with transaction_pk={} was not found", transaction_pk);
    }
    
    return transactions;
    
  }

}
