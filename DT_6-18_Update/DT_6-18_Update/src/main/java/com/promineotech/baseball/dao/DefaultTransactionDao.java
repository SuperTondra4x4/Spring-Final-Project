package com.promineotech.baseball.dao;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import com.promineotech.baseball.entity.Transaction;
import com.promineotech.baseball.entity.TransactionType;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j

public class DefaultTransactionDao implements TransactionDao {
  
  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;

  @Override
  public List<Transaction> fetchTransactions(int transaction_pk) {
    log.debug("DAO: transaction_id {}", transaction_pk);
    
    String sql = ""
        + "SELECT * "
        + "FROM transactions "
        + "WHERE transaction_pk = :transaction_pk";
    
    Map<String, Object> params = new HashMap<>();
    params.put("transaction_pk", transaction_pk);
    
    System.out.println(params);
    System.out.println(sql);
    
    return jdbcTemplate.query(sql, params, 
        new RowMapper<>() {
      
      @Override
      public Transaction mapRow(ResultSet rs, int rowNum) throws SQLException {
        
        log.info(TransactionType.valueOf(rs.getString("transaction_type")).toString() + " is the transaction type.");
        // @formatter:off
        return Transaction.builder()
            .transaction_pk(rs.getInt("transaction_pk"))
            .player_1_fk(rs.getInt("player_1_fk"))
            .player_2_fk(rs.getInt("player_2_fk"))
            .player_1_team_fk(rs.getInt("player_1_team_fk"))
            .player_2_team_fk(rs.getInt("player_2_team_fk"))
            .transaction_type(TransactionType.valueOf(rs.getString("transaction_type")))
            .build();
        // @formatter:on
      }});
  }
  
  @Override
  public int createTransaction(int transaction_pk, int player_1_fk, int player_2_fk, int player_1_team_fk, int player_2_team_fk, TransactionType transaction_type) {
    log.debug("Creating transaction...");
    log.debug("DAO: transaction_id {}", transaction_pk);
    
    String sql = ""
        + "INSERT INTO "
        + "transactions "
        + "(transaction_pk, player_1_fk, player_2_fk, player_1_team_fk, player_2_team_fk, transaction_type) "
        + "VALUES ( :transaction_pk, :player_1_fk, :player_2_fk, :player_1_team_fk, :player_2_team_fk, :transaction_type )";
    
    Map<String, Object> parameters = new HashMap<>();
    parameters.put("transaction_pk", transaction_pk);
    parameters.put("player_1_fk", player_1_fk);
    parameters.put("player_2_fk", player_2_fk);
    parameters.put("player_1_team_fk", player_1_team_fk);
    parameters.put("player_2_team_fk", player_2_team_fk);
    parameters.put("transaction_type", transaction_type.toString());
    
    System.out.println(parameters);

    return jdbcTemplate.update(sql, parameters);  

  }
  
  public int updateTransaction(int transaction_pk, int player_1_fk, int player_2_fk) {
    log.debug("Updating transaction...");
    log.debug("DAO: transaction_pk {}", transaction_pk);
    log.debug("DAO: player_1_fk {}", player_1_fk);
    log.debug("DAO: player_2_fk {}", player_2_fk);

    
    String sql = ""
        + "UPDATE "
        + "transactions "
        + "SET player_1_fk = :player_1_fk, player_2_fk = :player_2_fk "
        + "WHERE transaction_pk = :transaction_pk";
    
    Map<String, Object> parameters = new HashMap<>();
    parameters.put("player_1_fk", player_1_fk);
    parameters.put("player_2_fk", player_2_fk);
    parameters.put("transaction_pk", transaction_pk);
    
    System.out.println(parameters);

    return jdbcTemplate.update(sql, parameters);  

  }
  
  public int deleteTransaction(int transaction_pk) {
    log.debug("Deleting transaction...");
    log.debug("DAO: transaction_pk {}", transaction_pk);
    
    String sql = ""
        + "DELETE FROM "
        + "transactions "
        + "WHERE transaction_pk = :transaction_pk";
    
    Map<String, Object> parameters = new HashMap<>();
    parameters.put("transaction_pk", transaction_pk);
    
    System.out.println(parameters);

    return jdbcTemplate.update(sql, parameters);  

  }

}

