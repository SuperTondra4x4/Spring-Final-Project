package com.promineotech.baseball.dao;

import java.util.List;
import com.promineotech.baseball.entity.Transaction;
import com.promineotech.baseball.entity.TransactionType;

public interface TransactionDao {

  List<Transaction> fetchTransactions(int transaction_pk);

  int createTransaction(int transaction_pk, int player_1_fk, int player_2_fk, int player_1_team_fk, int player_2_team_fk, TransactionType transaction_type);
  
  int updateTransaction(int transaction_pk, int player_1_fk, int player_2_fk);

  
  int deleteTransaction(int transaction_pk);
}
