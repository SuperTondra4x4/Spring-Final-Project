package com.promineotech.baseball.service;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.promineotech.baseball.dao.TeamDao;
import com.promineotech.baseball.entity.Team;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service


public class DefaultTeamService implements TeamService {
  
  @Autowired
  private TeamDao teamDao;

  @Override
  @Transactional (readOnly = true)
  public List<Team> fetchTeams(int team_pk){
    log.info("The fetchTeams method was called with team_pk={}",
    team_pk);
    
    List<Team> teams = teamDao.fetchTeams(team_pk);
    
    if(teams.isEmpty()) {
      String msg = String.format("No teams were found with team_pk=%s", team_pk);
      throw new NoSuchElementException(msg);
    }
    
   
    return teams;
    
  }
  
  @Override
  @Transactional (readOnly = false)
  public int createTeam(int team_pk, String team_location, String team_name, int wins, int losses) {
    log.info("The createTeams method was called with team_pk={}",
    team_pk);
    
    int teams = teamDao.createTeam(team_pk, team_location, team_name, wins, losses);
    
    if(teams < 1) {
      String msg = String.format("No teams were created with team_pk=%s", team_pk);
      throw new NoSuchElementException(msg);
    }
    fetchTeams(team_pk);
    return teams;
    
  }
  
  @Override
  @Transactional (readOnly = false)
  public int updateTeam(int team_pk, String team_location) {
    log.info("The createTeams method was called with team_pk={}",
    team_pk);
    
    int teams = teamDao.updateTeam(team_pk, team_location);
    
    if(teams < 1) {
      String msg = String.format("No teams were updated with team_pk=%s", team_pk);
      throw new NoSuchElementException(msg);
    }
    fetchTeams(team_pk);
    return teams;
    
  }

  @Override
  public int deleteTeam(int team_pk) {
    log.info("The deleteTeams method was called with team_pk={}",
    team_pk);
    
    int teams = teamDao.deleteTeam(team_pk);
    
    if(teams < 1) {
      String msg = String.format("No teams were updated with team_pk=%s", team_pk);
      throw new NoSuchElementException(msg);
    }
    
    try {
      fetchTeams(team_pk);
    }
    
    catch(Exception e) {
      log.info("Team with team_pk={} was not found", team_pk);
    }
    
    return teams;
    
  }

}
