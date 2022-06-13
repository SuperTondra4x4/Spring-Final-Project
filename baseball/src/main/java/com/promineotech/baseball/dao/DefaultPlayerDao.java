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
import com.promineotech.baseball.entity.Jeep;
import com.promineotech.baseball.entity.JeepModel;
import com.promineotech.baseball.entity.Player;
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
    
    return jdbcTemplate.query(sql,  params, 
        new RowMapper<>() {
      
      @Override
      public Player mapRow(ResultSet rs, int rowNum) throws SQLException {
        // @formatter:off
        return Player.builder()
            .player_pk (rs.getInt("player_pk"))
            .first_name(rs.getString("first_name"))
            .last_name(rs.getString("last_name"))
            .team_fk (rs.getInt("team_fk"))
            .build();
        // @formatter:on
      }});
  }

}

