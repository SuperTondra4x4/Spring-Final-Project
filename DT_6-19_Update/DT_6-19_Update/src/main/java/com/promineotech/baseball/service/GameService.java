package com.promineotech.baseball.service;

import java.util.List;
import com.promineotech.baseball.entity.Game;
import com.promineotech.baseball.entity.GameResult;

public interface GameService {

  List<Game> fetchGames(int game_pk);

  int createGame(int game_pk, int team_1_fk, int team_2_fk, GameResult team_1_result,
		  GameResult team_2_result);

  int updateGame(int game_pk, GameResult team_1_result,
		  GameResult team_2_result);

  int deleteGame(int game_pk);

  }
