package com.promineotech.baseball.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.promineotech.baseball.entity.PAResult;
import com.promineotech.baseball.entity.PlateAppearance;
import com.promineotech.baseball.service.PlateAppearanceService;
import lombok.extern.slf4j.Slf4j;


@RestController
@Slf4j
public class DefaultPlateAppearanceController implements PlateAppearanceController {
  
  @Autowired
  private PlateAppearanceService plateAppearanceService;
  

  @Override
  public List<PlateAppearance> fetchPlateAppearances(int pa_pk) {
    log.info("fetching plate appearances");
    log.info("plate appearance_pk={}", pa_pk);
    return plateAppearanceService.fetchPlateAppearances(pa_pk);
  }
  
  @Override
  public int createPlateAppearance(int pa_pk, int pitcher_fk, int batter_fk, PAResult par, int game_fk,
      float inning, int runs, int team_runs_fk) {
    log.info("Creating plate appearances");
    log.info("pa_pk={}", pa_pk);
    return plateAppearanceService.createPlateAppearance(pa_pk, pitcher_fk, batter_fk, par, game_fk,
        inning, runs, team_runs_fk);
  }

  @Override
  public int updatePlateAppearance(int pa_pk, int game_fk) {
    log.info("Updating plate appearance with pa_pk {}", pa_pk);
    return plateAppearanceService.updatePlateAppearance(pa_pk, game_fk);
  }
  
  @Override
  public int deletePlateAppearance(int pa_pk) {
    log.info("Updating plate appearance with pa_pk {}", pa_pk);
    return plateAppearanceService.deletePlateAppearance(pa_pk);
  }

}
