package com.promineotech.baseball.service;

import java.util.List;
import com.promineotech.baseball.entity.Team;

public interface TeamService {

  List<Team> fetchTeams(int team_pk);

  int createTeam(int team_pk, String team_location, String team_name, int wins,
      int losses);

  int updateTeam(int team_pk, String team_location);

  int deleteTeam(int team_pk);

  }
