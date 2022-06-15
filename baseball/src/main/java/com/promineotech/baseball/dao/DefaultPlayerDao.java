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
import com.promineotech.baseball.entity.Player;
import com.promineotech.baseball.entity.PlayerPosition;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j

public class DefaultPlayerDao implements PlayerDao {
  
  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;

  @Override
  public List<Player> fetchPlayers(int player_pk) {
    log.debug("DAO: player_id {}", player_pk);
    
    String sql = ""
        + "SELECT * "
        + "FROM players "
        + "WHERE player_pk = :player_pk";
    
    Map<String, Object> params = new HashMap<>();
    params.put("player_pk", player_pk);
    
    System.out.println(params);
    System.out.println(sql);
    
    return jdbcTemplate.query(sql, params, 
        new RowMapper<>() {
      
      @Override
      public Player mapRow(ResultSet rs, int rowNum) throws SQLException {
        // @formatter:off
        return Player.builder()
            .player_pk(rs.getInt("player_pk"))
            .first_name(rs.getString("first_name"))
            .last_name(rs.getString("last_name"))
            .team_fk(rs.getInt("team_fk"))
            .player_position(PlayerPosition.valueOf(rs.getString("player_position")))
            .build();
        // @formatter:on
      }});
  }
  
  @Override
  public List<Player> createPlayer(int player_pk, String first_name, String last_name, PlayerPosition pos, int team_fk) {
    log.debug("DAO: player_id {}", player_pk);
    
    String sql = ""
        + "INSERT INTO "
        + "players "
        + "(player_pk, first_name, last_name, team_fk, player_position) "
        + "VALUES ( :player_pk, :first_name, :last_name, :team_fk, :player_position )";
//        + "VALUES (" + player_pk + ", '" + first_name + "', '" + last_name + "', " + team_fk + ", '" + pos.toString() + "')";
    
    Map<String, Object> parameters = new HashMap<>();
    parameters.put("player_pk", player_pk);
    parameters.put("first_name", first_name);
    parameters.put("last_name", last_name);
    parameters.put("team_fk", team_fk);
    parameters.put("player_position", pos.toString());
    
    System.out.println(parameters);

    return jdbcTemplate.query(sql, parameters,  
        new RowMapper<>() {
      
      @Override
      public Player mapRow(ResultSet rs, int rowNum) throws SQLException {
        
        System.out.println("in mapRow");
        // @formatter:off
        return Player.builder()
            .player_pk(rs.getInt("player_pk"))
            .first_name(rs.getString("first_name"))
            .last_name(rs.getString("last_name"))
            .team_fk(rs.getInt("team_fk"))
            .player_position(PlayerPosition.valueOf(rs.getString("player_position")))
            .build();
        // @formatter:on
      }});
  }

}

