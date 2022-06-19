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
import com.promineotech.baseball.entity.Team;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j

public class DefaultTeamDao implements TeamDao {
  
  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;

  @Override
  public List<Team> fetchTeams(int team_pk) {
    log.debug("DAO: team_id {}", team_pk);
    
    String sql = ""
        + "SELECT * "
        + "FROM teams "
        + "WHERE team_pk = :team_pk";
    
    Map<String, Object> params = new HashMap<>();
    params.put("team_pk", team_pk);
    
    System.out.println(params);
    System.out.println(sql);
    
    return jdbcTemplate.query(sql, params, 
        new RowMapper<>() {
      
      @Override
      public Team mapRow(ResultSet rs, int rowNum) throws SQLException {
        // @formatter:off
        return Team.builder()
            .team_pk(rs.getInt("team_pk"))
            .team_location(rs.getString("team_location"))
            .team_name(rs.getString("team_name"))
            .wins(rs.getInt("wins"))
            .losses(rs.getInt("losses"))
            .build();
        // @formatter:on
      }});
  }
  
  @Override
  public int createTeam(int team_pk, String team_location, String team_name, int wins, int losses) {
    log.debug("Creating team...");
    log.debug("DAO: team_id {}", team_pk);
    
    String sql = ""
        + "INSERT INTO "
        + "teams "
        + "(team_pk, team_location, team_name, wins, losses) "
        + "VALUES ( :team_pk, :team_location, :team_name, :wins, :losses )";
    
    Map<String, Object> parameters = new HashMap<>();
    parameters.put("team_pk", team_pk);
    parameters.put("team_location", team_location);
    parameters.put("team_name", team_name);
    parameters.put("wins", wins);
    parameters.put("losses", losses);
    
    System.out.println(parameters);

    return jdbcTemplate.update(sql, parameters);  

  }
  
  public int updateTeam(int team_pk, String team_location) {
    log.debug("Updating team...");
    log.debug("DAO: team_pk {}", team_pk);
    log.debug("DAO: team_location {}", team_location);
    
    String sql = ""
        + "UPDATE "
        + "teams "
        + "SET team_location = :team_location "
        + "WHERE team_pk = :team_pk";
    
    Map<String, Object> parameters = new HashMap<>();
    parameters.put("team_pk", team_pk);
    parameters.put("team_location", team_location);
    
    System.out.println(parameters);

    return jdbcTemplate.update(sql, parameters);  

  }
  
  public int deleteTeam(int team_pk) {
    log.debug("Deleting team...");
    log.debug("DAO: team_pk {}", team_pk);
    
    String sql = ""
        + "DELETE FROM "
        + "teams "
        + "WHERE team_pk = :team_pk";
    
    Map<String, Object> parameters = new HashMap<>();
    parameters.put("team_pk", team_pk);
    
    System.out.println(parameters);

    return jdbcTemplate.update(sql, parameters);  

  }

}

