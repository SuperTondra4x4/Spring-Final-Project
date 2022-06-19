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
import com.promineotech.baseball.entity.Game;
import com.promineotech.baseball.entity.GameResult;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j

public class DefaultGameDao implements GameDao {
  
  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;

  @Override
  public List<Game> fetchGames(int game_pk) {
    log.debug("DAO: game_id {}", game_pk);
    
    String sql = ""
        + "SELECT * "
        + "FROM games "
        + "WHERE game_pk = :game_pk";
    
    Map<String, Object> params = new HashMap<>();
    params.put("game_pk", game_pk);
    
    System.out.println(params);
    System.out.println(sql);
    
    return jdbcTemplate.query(sql, params, 
        new RowMapper<>() {
      
      @Override
      public Game mapRow(ResultSet rs, int rowNum) throws SQLException {
        // @formatter:off
        return Game.builder()
            .game_pk(rs.getInt("game_pk"))
            .team_1_fk(rs.getInt("team_1_fk"))
            .team_2_fk(rs.getInt("team_2_fk"))
            .team_1_result(GameResult.valueOf(rs.getString("team_1_result")))
            .team_2_result(GameResult.valueOf(rs.getString("team_2_result")))
            .build();
        // @formatter:on
      }});
  }
  
  @Override
  public int createGame(int game_pk, int team_1_fk, int team_2_fk, GameResult team_1_result, GameResult team_2_result) {
    log.debug("Creating game...");
    log.debug("DAO: game_id {}", game_pk);
    
    String sql = ""
        + "INSERT INTO "
        + "games "
        + "(game_pk, team_1_fk, team_2_fk, team_1_result, team_2_result) "
        + "VALUES ( :game_pk, :team_1_fk, :team_2_fk, :team_1_result, :team_2_result )";
    
    Map<String, Object> parameters = new HashMap<>();
    parameters.put("game_pk", game_pk);
    parameters.put("team_1_fk", team_1_fk);
    parameters.put("team_2_fk", team_2_fk);
    parameters.put("team_1_result", team_1_result.toString());
    parameters.put("team_2_result", team_2_result.toString());
    
    System.out.println(parameters);

    return jdbcTemplate.update(sql, parameters);  

  }
  
  public int updateGame(int game_pk, GameResult team_1_result,GameResult team_2_result) {
    log.debug("Updating game...");
    log.debug("DAO: game_pk {}", game_pk);
    log.debug("DAO: team_1_result {}", team_1_result);
    log.debug("DAO: team_2_result {}", team_2_result);
    
    String sql = ""
        + "UPDATE "
        + "games "
        + "SET team_1_result = :team_1_result, team_2_result = :team_2_result "
        + "WHERE game_pk = :game_pk";
    
    Map<String, Object> parameters = new HashMap<>();
    parameters.put("game_pk", game_pk);
    parameters.put("team_1_result", team_1_result.toString());
    parameters.put("team_2_result", team_2_result.toString());
    
    System.out.println(parameters);

    return jdbcTemplate.update(sql, parameters);  

  }
  
  public int deleteGame(int game_pk) {
    log.debug("Deleting game...");
    log.debug("DAO: game_pk {}", game_pk);
    
    String sql = ""
        + "DELETE FROM "
        + "games "
        + "WHERE game_pk = :game_pk";
    
    Map<String, Object> parameters = new HashMap<>();
    parameters.put("game_pk", game_pk);
    
    System.out.println(parameters);

    return jdbcTemplate.update(sql, parameters);  

  }

}

