package com.promineotech.baseball.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.promineotech.baseball.entity.Team;
import com.promineotech.baseball.service.TeamService;

import lombok.extern.slf4j.Slf4j;


@RestController
@Slf4j
public class DefaultTeamController implements TeamController {
  
  @Autowired
  private TeamService teamService;
  

  @Override
  public List<Team> fetchTeams(int team_pk) {
    log.info("fetching team");
    log.info("team_pk={}", team_pk);
    return teamService.fetchTeams(team_pk);
  }
  
  @Override
  public int createTeam(int team_pk, String team_location, String team_name, int wins, int losses) {
    log.info("Creating team");
    log.info("team_pk={}", team_pk);
    return teamService.createTeam(team_pk, team_location, team_name, wins, losses);
  }

  @Override
  public int updateTeam(int team_pk, String team_location) {
    log.info("Updating team with team_pk {}", team_pk);
    return teamService.updateTeam(team_pk, team_location);
  }
  
  @Override
  public int deleteTeam(int team_pk) {
    log.info("Updating team with team_pk {}", team_pk);
    return teamService.deleteTeam(team_pk);
  }

}
