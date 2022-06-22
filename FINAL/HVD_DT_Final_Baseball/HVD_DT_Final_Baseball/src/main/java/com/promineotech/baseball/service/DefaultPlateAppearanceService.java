package com.promineotech.baseball.service;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.promineotech.baseball.dao.PlateAppearanceDao;
import com.promineotech.baseball.dao.PlayerDao;
import com.promineotech.baseball.entity.PAResult;
import com.promineotech.baseball.entity.PlateAppearance;
import com.promineotech.baseball.entity.Player;
import com.promineotech.baseball.entity.PlayerPosition;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service


public class DefaultPlateAppearanceService implements PlateAppearanceService {
  
  @Autowired
  private PlateAppearanceDao plateAppearanceDao;

  @Override
  @Transactional (readOnly = true)
  public List<PlateAppearance> fetchPlateAppearances(int pa_pk){
    log.info("The fetchPlateAppearances method was called with pa_pk={}",
    pa_pk);
    
    List<PlateAppearance> plateAppearances = plateAppearanceDao.fetchPlateAppearances(pa_pk);
    
    if(plateAppearances.isEmpty()) {
      String msg = String.format("No plate appearances were found with pa_pk=%s", pa_pk);
      throw new NoSuchElementException(msg);
    }
    
    return plateAppearances;
    
  }
  
//  @Override
  @Transactional (readOnly = false)
  public int createPlateAppearance(int pa_pk, int pitcher_fk, int batter_fk, PAResult par, int game_fk, float inning, int runs, int team_runs_fk) {
    log.info("The createPlateAppearances method was called with pa_pk={}",
    pa_pk);
    
    int plateAppearances = plateAppearanceDao.createPlateAppearance(pa_pk, pitcher_fk, batter_fk, par, game_fk, inning, runs, team_runs_fk);
    
    if(plateAppearances < 1) {
      String msg = String.format("No plate appearances were created with pa_pk=%s", pa_pk);
      throw new NoSuchElementException(msg);
    }
    fetchPlateAppearances(pa_pk);
    return plateAppearances;
    
  }
  
  @Override
  @Transactional (readOnly = false)
  public int updatePlateAppearance(int pa_pk, int team_fk) {
    log.info("The createPlateAppearances method was called with pa_pk={}",
    pa_pk);
    
    int plateAppearance = plateAppearanceDao.updatePlateAppearance(pa_pk, team_fk);
    
    if(plateAppearance < 1) {
      String msg = String.format("No plate appearances were updated with pa_pk=%s", pa_pk);
      throw new NoSuchElementException(msg);
    }
    fetchPlateAppearances(pa_pk);
    return plateAppearance;
    
  }

//  @Override
  public int deletePlateAppearance(int pa_pk) {
    log.info("The deletePlateAppearances method was called with pa_pk={}",
    pa_pk);
    
    int plateAppearance = plateAppearanceDao.deletePlateAppearance(pa_pk);
    
    if(plateAppearance < 1) {
      String msg = String.format("No plate appearances were updated with pa_pk=%s", pa_pk);
      throw new NoSuchElementException(msg);
    }
    
    try {
      fetchPlateAppearances(pa_pk);
    }
    
    catch(Exception e) {
      log.info("Plate Appearance with pa_pk={} was not found", pa_pk);
    }
    
    return plateAppearance;
    
  }

}
