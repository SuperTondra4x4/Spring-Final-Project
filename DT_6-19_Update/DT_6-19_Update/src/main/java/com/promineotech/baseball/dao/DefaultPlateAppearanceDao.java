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
import com.promineotech.baseball.entity.PAResult;
import com.promineotech.baseball.entity.PlateAppearance;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j

public class DefaultPlateAppearanceDao implements PlateAppearanceDao {
  
  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;

  @Override
  public List<PlateAppearance> fetchPlateAppearances(int pa_pk) {
    log.debug("DAO: plate_appearance_id {}", pa_pk);
    
    String sql = ""
        + "SELECT * "
        + "FROM plate_appearances "
        + "WHERE pa_pk = :pa_pk";
    
    Map<String, Object> params = new HashMap<>();
    params.put("pa_pk", pa_pk);
    
    System.out.println(params);
    System.out.println(sql);
    
    return jdbcTemplate.query(sql, params, 
        new RowMapper<>() {
      
      @Override
      public PlateAppearance mapRow(ResultSet rs, int rowNum) throws SQLException {
        // @formatter:off
        return PlateAppearance.builder()
            .pa_pk(rs.getInt("pa_pk"))
            .pitcher_fk(rs.getInt("pitcher_fk"))
            .batter_fk(rs.getInt("batter_fk"))
            .game_fk(rs.getInt("game_fk"))
            .pa_result(PAResult.valueOf(rs.getString("pa_result")))
            .inning(rs.getFloat("inning"))
            .runs(rs.getInt("runs"))
            .team_runs_fk(rs.getInt("team_runs_fk"))
            .build();
        // @formatter:on
      }});
  }
  
  @Override
  public int createPlateAppearance(int pa_pk, int pitcher_fk, int batter_fk, PAResult par, int game_fk, float inning, int runs, int team_runs_fk) {
    log.debug("Creating plate appearance...");
    log.debug("DAO: plate_appearance_id {}", pa_pk);
    
    String sql = ""
        + "INSERT INTO "
        + "plate_appearances "
        + "(pa_pk, pitcher_fk, batter_fk, pa_result, game_fk, inning, runs, team_runs_fk) "
        + "VALUES ( :pa_pk, :pitcher_fk, :batter_fk, :pa_result, :game_fk, :inning, :runs, :team_runs_fk )";
    
    Map<String, Object> parameters = new HashMap<>();
    parameters.put("pa_pk", pa_pk);
    parameters.put("pitcher_fk", pitcher_fk);
    parameters.put("batter_fk", batter_fk);
    parameters.put("game_fk", game_fk);
    parameters.put("pa_result", par.toString());
    parameters.put("inning", inning);
    parameters.put("runs", runs);
    parameters.put("team_runs_fk", team_runs_fk);
    System.out.println(parameters);

    return jdbcTemplate.update(sql, parameters);  

  }
  
  public int updatePlateAppearance(int pa_pk, int game_fk) {
    log.debug("Updating plate appearance...");
    log.debug("DAO: pa_pk {}", pa_pk);
    log.debug("DAO: game_fk {}", game_fk);
    
    String sql = ""
        + "UPDATE "
        + "plate_appearances "
        + "SET game_fk = :game_fk "
        + "WHERE pa_pk = :pa_pk";
    
    Map<String, Object> parameters = new HashMap<>();
    parameters.put("pa_pk", pa_pk);
    parameters.put("game_fk", game_fk);
    
    System.out.println(parameters);

    return jdbcTemplate.update(sql, parameters);  

  }
  
  public int deletePlateAppearance(int pa_pk) {
    log.debug("Deleting plate appearance...");
    log.debug("DAO: pa_pk {}", pa_pk);
    
    String sql = ""
        + "DELETE FROM "
        + "plate_appearances "
        + "WHERE pa_pk = :pa_pk";
    
    Map<String, Object> parameters = new HashMap<>();
    parameters.put("pa_pk", pa_pk);
    
    System.out.println(parameters);

    return jdbcTemplate.update(sql, parameters);  

  }

}

