package com.promineotech.baseball.service;

import java.util.List;
import com.promineotech.baseball.entity.PAResult;
import com.promineotech.baseball.entity.PlateAppearance;
import com.promineotech.baseball.entity.Player;
import com.promineotech.baseball.entity.PlayerPosition;

public interface PlateAppearanceService {

  List<PlateAppearance> fetchPlateAppearances(int pa_pk);

  int createPlateAppearance(int pa_pk, int pitcher_fk, int batter_fk, PAResult par, int game_fk, float inning, int runs, int team_runs_fk);

  int updatePlateAppearance(int pa_pk, int team_fk);
  
  int deletePlateAppearance(int pa_pk);
  
  }
