use baseball;

-- Teams --
INSERT INTO teams (team_location, team_name, wins, losses) VALUES('Minnesota', 'Twins', 2, 0);
INSERT INTO teams (team_location, team_name, wins, losses) VALUES('Detroit', 'Tigers', 1, 1);
INSERT INTO teams (team_location, team_name, wins, losses) VALUES('Chicago', 'White Sox', 0, 2);

-- Players --
INSERT INTO players (first_name, last_name, team_fk, player_position) VALUES('Sonny', 'Gray', 1, 'PITCHER');
INSERT INTO players (first_name, last_name, team_fk, player_position) VALUES('Ryan', 'Jeffers', 1, 'CATCHER');
INSERT INTO players (first_name, last_name, team_fk, player_position) VALUES('Luis', 'Arraez', 1, 'FIRST');
INSERT INTO players (first_name, last_name, team_fk, player_position) VALUES('Jorge', 'Polanco', 1, 'SECOND');
INSERT INTO players (first_name, last_name, team_fk, player_position) VALUES('Gio', 'Urshela', 1, 'THIRD');
INSERT INTO players (first_name, last_name, team_fk, player_position) VALUES('Carlos', 'Correa', 1, 'SHORT');
INSERT INTO players (first_name, last_name, team_fk, player_position) VALUES('Trevor', 'Larnach', 1, 'LEFT');
INSERT INTO players (first_name, last_name, team_fk, player_position) VALUES('Byron', 'Buxton', 1, 'CENTER');
INSERT INTO players (first_name, last_name, team_fk, player_position) VALUES('Max', 'Kepler', 1, 'RIGHT');
INSERT INTO players (first_name, last_name, team_fk, player_position) VALUES('Tarik', 'Skubal', 2, 'PITCHER');
INSERT INTO players (first_name, last_name, team_fk, player_position) VALUES('Tucker', 'Barnhard', 2, 'CATCHER');
INSERT INTO players (first_name, last_name, team_fk, player_position) VALUES('Spencer', 'Torkelson', 2, 'FIRST');
INSERT INTO players (first_name, last_name, team_fk, player_position) VALUES('Jonathan', 'Schoop', 2, 'SECOND');
INSERT INTO players (first_name, last_name, team_fk, player_position) VALUES('Jeimer', 'Candelario', 2, 'THIRD');
INSERT INTO players (first_name, last_name, team_fk, player_position) VALUES('Javier', 'Baez', 2, 'SHORT');
INSERT INTO players (first_name, last_name, team_fk, player_position) VALUES('Robbie', 'Grossman', 2, 'LEFT');
INSERT INTO players (first_name, last_name, team_fk, player_position) VALUES('Willi', 'Castro', 2, 'CENTER');
INSERT INTO players (first_name, last_name, team_fk, player_position) VALUES('Austin', 'Meadows', 2, 'RIGHT');
INSERT INTO players (first_name, last_name, team_fk, player_position) VALUES('Lucas', 'Giolito', 3, 'PITCHER');
INSERT INTO players (first_name, last_name, team_fk, player_position) VALUES('Yasmani', 'Grandal', 3, 'CATCHER');
INSERT INTO players (first_name, last_name, team_fk, player_position) VALUES('Jose', 'Abreu', 3, 'FIRST');
INSERT INTO players (first_name, last_name, team_fk, player_position) VALUES('Josh', 'Harrison', 3, 'SECOND');
INSERT INTO players (first_name, last_name, team_fk, player_position) VALUES('Yoan', 'Moncada', 3, 'THIRD');
INSERT INTO players (first_name, last_name, team_fk, player_position) VALUES('Tim', 'Anderson', 3, 'SHORT');
INSERT INTO players (first_name, last_name, team_fk, player_position) VALUES('Andrew', 'Vaughn', 3, 'LEFT');
INSERT INTO players (first_name, last_name, team_fk, player_position) VALUES('Luis', 'Robert', 3, 'CENTER');
INSERT INTO players (first_name, last_name, team_fk, player_position) VALUES('AJ', 'Pollock', 3, 'RIGHT');

-- Transactions --
INSERT INTO transactions (transaction_type, player_1_fk, player_2_fk, player_1_team_fk, player_2_team_fk) VALUES('Sign', 1, NULL, 1, NULL);
INSERT INTO transactions (transaction_type, player_1_fk, player_2_fk, player_1_team_fk, player_2_team_fk) VALUES('Sign', 2, NULL, 1, NULL);
INSERT INTO transactions (transaction_type, player_1_fk, player_2_fk, player_1_team_fk, player_2_team_fk) VALUES('Sign', 3, NULL, 1, NULL);
INSERT INTO transactions (transaction_type, player_1_fk, player_2_fk, player_1_team_fk, player_2_team_fk) VALUES('Sign', 4, NULL, 1, NULL);
INSERT INTO transactions (transaction_type, player_1_fk, player_2_fk, player_1_team_fk, player_2_team_fk) VALUES('Sign', 5, NULL, 1, NULL);
INSERT INTO transactions (transaction_type, player_1_fk, player_2_fk, player_1_team_fk, player_2_team_fk) VALUES('Sign', 6, NULL, 1, NULL);
INSERT INTO transactions (transaction_type, player_1_fk, player_2_fk, player_1_team_fk, player_2_team_fk) VALUES('Sign', 7, NULL, 1, NULL);
INSERT INTO transactions (transaction_type, player_1_fk, player_2_fk, player_1_team_fk, player_2_team_fk) VALUES('Sign', 8, NULL, 1, NULL);
INSERT INTO transactions (transaction_type, player_1_fk, player_2_fk, player_1_team_fk, player_2_team_fk) VALUES('Sign', 9, NULL, 1, NULL);
INSERT INTO transactions (transaction_type, player_1_fk, player_2_fk, player_1_team_fk, player_2_team_fk) VALUES('Sign', 10, NULL, 2, NULL);
INSERT INTO transactions (transaction_type, player_1_fk, player_2_fk, player_1_team_fk, player_2_team_fk) VALUES('Sign', 11, NULL, 2, NULL);
INSERT INTO transactions (transaction_type, player_1_fk, player_2_fk, player_1_team_fk, player_2_team_fk) VALUES('Sign', 12, NULL, 2, NULL);
INSERT INTO transactions (transaction_type, player_1_fk, player_2_fk, player_1_team_fk, player_2_team_fk) VALUES('Sign', 13, NULL, 2, NULL);
INSERT INTO transactions (transaction_type, player_1_fk, player_2_fk, player_1_team_fk, player_2_team_fk) VALUES('Sign', 14, NULL, 2, NULL);
INSERT INTO transactions (transaction_type, player_1_fk, player_2_fk, player_1_team_fk, player_2_team_fk) VALUES('Sign', 15, NULL, 2, NULL);
INSERT INTO transactions (transaction_type, player_1_fk, player_2_fk, player_1_team_fk, player_2_team_fk) VALUES('Sign', 16, NULL, 2, NULL);
INSERT INTO transactions (transaction_type, player_1_fk, player_2_fk, player_1_team_fk, player_2_team_fk) VALUES('Sign', 17, NULL, 2, NULL);
INSERT INTO transactions (transaction_type, player_1_fk, player_2_fk, player_1_team_fk, player_2_team_fk) VALUES('Sign', 18, NULL, 2, NULL);
INSERT INTO transactions (transaction_type, player_1_fk, player_2_fk, player_1_team_fk, player_2_team_fk) VALUES('Sign', 19, NULL, 3, NULL);
INSERT INTO transactions (transaction_type, player_1_fk, player_2_fk, player_1_team_fk, player_2_team_fk) VALUES('Sign', 20, NULL, 3, NULL);
INSERT INTO transactions (transaction_type, player_1_fk, player_2_fk, player_1_team_fk, player_2_team_fk) VALUES('Sign', 21, NULL, 3, NULL);
INSERT INTO transactions (transaction_type, player_1_fk, player_2_fk, player_1_team_fk, player_2_team_fk) VALUES('Sign', 22, NULL, 3, NULL);
INSERT INTO transactions (transaction_type, player_1_fk, player_2_fk, player_1_team_fk, player_2_team_fk) VALUES('Sign', 23, NULL, 3, NULL);
INSERT INTO transactions (transaction_type, player_1_fk, player_2_fk, player_1_team_fk, player_2_team_fk) VALUES('Sign', 24, NULL, 3, NULL);
INSERT INTO transactions (transaction_type, player_1_fk, player_2_fk, player_1_team_fk, player_2_team_fk) VALUES('Sign', 25, NULL, 3, NULL);
INSERT INTO transactions (transaction_type, player_1_fk, player_2_fk, player_1_team_fk, player_2_team_fk) VALUES('Sign', 26, NULL, 3, NULL);
INSERT INTO transactions (transaction_type, player_1_fk, player_2_fk, player_1_team_fk, player_2_team_fk) VALUES('Sign', 27, NULL, 3, NULL);

-- Games --
INSERT INTO games (team_1_fk, team_2_fk, team_1_result, team_2_result) VALUES(1, 2, 'W', 'L');
INSERT INTO games (team_1_fk, team_2_fk, team_1_result, team_2_result) VALUES(1, 3, 'W', 'L');
INSERT INTO games (team_1_fk, team_2_fk, team_1_result, team_2_result) VALUES(2, 3, 'W', 'L');

-- Plate Appearances --
INSERT INTO plate_appearances (pitcher_fk, batter_fk, pa_result, game_fk, inning, runs, team_runs_fk) VALUES(1, 10, 'OUT', 1, 1, NULL, NULL);
INSERT INTO plate_appearances (pitcher_fk, batter_fk, pa_result, game_fk, inning, runs, team_runs_fk) VALUES(1, 11, 'SINGLE', 1, 1.1, NULL, NULL);
INSERT INTO plate_appearances (pitcher_fk, batter_fk, pa_result, game_fk, inning, runs, team_runs_fk) VALUES(1, 12, 'OUT', 1, 1.1, NULL, NULL);
INSERT INTO plate_appearances (pitcher_fk, batter_fk, pa_result, game_fk, inning, runs, team_runs_fk) VALUES(1, 13, 'OUT', 1, 1.2, NULL, NULL);
INSERT INTO plate_appearances (pitcher_fk, batter_fk, pa_result, game_fk, inning, runs, team_runs_fk) VALUES(10, 1, 'SINGLE', 1, 1.3, NULL, NULL);
INSERT INTO plate_appearances (pitcher_fk, batter_fk, pa_result, game_fk, inning, runs, team_runs_fk) VALUES(10, 2, 'OUT', 1, 1.3, NULL, NULL);
INSERT INTO plate_appearances (pitcher_fk, batter_fk, pa_result, game_fk, inning, runs, team_runs_fk) VALUES(10, 3, 'DOUBLE', 1, 1.4, NULL, NULL);
INSERT INTO plate_appearances (pitcher_fk, batter_fk, pa_result, game_fk, inning, runs, team_runs_fk) VALUES(10, 4, 'HOMER', 1, 1.4, 3, 1);
INSERT INTO plate_appearances (pitcher_fk, batter_fk, pa_result, game_fk, inning, runs, team_runs_fk) VALUES(10, 5, 'OUT', 1, 1.4, NULL, NULL);
INSERT INTO plate_appearances (pitcher_fk, batter_fk, pa_result, game_fk, inning, runs, team_runs_fk) VALUES(10, 6, 'OUT', 1, 1.5, NULL, NULL);
INSERT INTO plate_appearances (pitcher_fk, batter_fk, pa_result, game_fk, inning, runs, team_runs_fk) VALUES(1, 14, 'HOMER', 1, 2, 1, 2);
INSERT INTO plate_appearances (pitcher_fk, batter_fk, pa_result, game_fk, inning, runs, team_runs_fk) VALUES(1, 15, 'SINGLE', 1, 2, NULL, NULL);
INSERT INTO plate_appearances (pitcher_fk, batter_fk, pa_result, game_fk, inning, runs, team_runs_fk) VALUES(1, 16, 'OUT', 1, 2, NULL, NULL);
INSERT INTO plate_appearances (pitcher_fk, batter_fk, pa_result, game_fk, inning, runs, team_runs_fk) VALUES(1, 17, 'OUT', 1, 2.1, NULL, NULL);
INSERT INTO plate_appearances (pitcher_fk, batter_fk, pa_result, game_fk, inning, runs, team_runs_fk) VALUES(1, 18, 'OUT', 1, 2.2, NULL, NULL);
INSERT INTO plate_appearances (pitcher_fk, batter_fk, pa_result, game_fk, inning, runs, team_runs_fk) VALUES(10, 7, 'SINGLE', 1, 2.3, NULL, NULL);
INSERT INTO plate_appearances (pitcher_fk, batter_fk, pa_result, game_fk, inning, runs, team_runs_fk) VALUES(10, 8, 'SINGLE', 1, 2.3, NULL, NULL);
INSERT INTO plate_appearances (pitcher_fk, batter_fk, pa_result, game_fk, inning, runs, team_runs_fk) VALUES(10, 9, 'SINGLE', 1, 2.3, NULL, NULL);
INSERT INTO plate_appearances (pitcher_fk, batter_fk, pa_result, game_fk, inning, runs, team_runs_fk) VALUES(10, 1, 'OUT', 1, 2.3, NULL, NULL);
INSERT INTO plate_appearances (pitcher_fk, batter_fk, pa_result, game_fk, inning, runs, team_runs_fk) VALUES(10, 2, 'OUT', 1, 2.4, NULL, NULL);
INSERT INTO plate_appearances (pitcher_fk, batter_fk, pa_result, game_fk, inning, runs, team_runs_fk) VALUES(10, 3, 'OUT', 1, 2.5, NULL, NULL);
INSERT INTO plate_appearances (pitcher_fk, batter_fk, pa_result, game_fk, inning, runs, team_runs_fk) VALUES(1, 10, 'OUT', 1, 3, NULL, NULL);
INSERT INTO plate_appearances (pitcher_fk, batter_fk, pa_result, game_fk, inning, runs, team_runs_fk) VALUES(1, 11, 'OUT', 1, 3.1, NULL, NULL);
INSERT INTO plate_appearances (pitcher_fk, batter_fk, pa_result, game_fk, inning, runs, team_runs_fk) VALUES(1, 12, 'OUT', 1, 3.2, NULL, NULL);
INSERT INTO plate_appearances (pitcher_fk, batter_fk, pa_result, game_fk, inning, runs, team_runs_fk) VALUES(10, 4, 'OUT', 1, 3.3, NULL, NULL);
INSERT INTO plate_appearances (pitcher_fk, batter_fk, pa_result, game_fk, inning, runs, team_runs_fk) VALUES(10, 5, 'OUT', 1, 3.4, NULL, NULL);
INSERT INTO plate_appearances (pitcher_fk, batter_fk, pa_result, game_fk, inning, runs, team_runs_fk) VALUES(10, 6, 'OUT', 1, 3.5, NULL, NULL);
INSERT INTO plate_appearances (pitcher_fk, batter_fk, pa_result, game_fk, inning, runs, team_runs_fk) VALUES(19, 1, 'SINGLE', 2, 1, NULL, NULL);
INSERT INTO plate_appearances (pitcher_fk, batter_fk, pa_result, game_fk, inning, runs, team_runs_fk) VALUES(19, 2, 'SINGLE', 2, 1, NULL, NULL);
INSERT INTO plate_appearances (pitcher_fk, batter_fk, pa_result, game_fk, inning, runs, team_runs_fk) VALUES(19, 3, 'OUT', 2, 1, NULL, NULL);
INSERT INTO plate_appearances (pitcher_fk, batter_fk, pa_result, game_fk, inning, runs, team_runs_fk) VALUES(19, 4, 'DOUBLE', 2, 1.1, 1, 1);
INSERT INTO plate_appearances (pitcher_fk, batter_fk, pa_result, game_fk, inning, runs, team_runs_fk) VALUES(19, 5, 'OUT', 2, 1.1, NULL, NULL);
INSERT INTO plate_appearances (pitcher_fk, batter_fk, pa_result, game_fk, inning, runs, team_runs_fk) VALUES(19, 6, 'OUT', 2, 1.2, NULL, NULL);
INSERT INTO plate_appearances (pitcher_fk, batter_fk, pa_result, game_fk, inning, runs, team_runs_fk) VALUES(1, 19, 'OUT', 2, 1.3, NULL, NULL);
INSERT INTO plate_appearances (pitcher_fk, batter_fk, pa_result, game_fk, inning, runs, team_runs_fk) VALUES(1, 20, 'HOMER', 2, 1.3, 1, 3);
INSERT INTO plate_appearances (pitcher_fk, batter_fk, pa_result, game_fk, inning, runs, team_runs_fk) VALUES(1, 21, 'OUT', 2, 1.4, NULL, NULL);
INSERT INTO plate_appearances (pitcher_fk, batter_fk, pa_result, game_fk, inning, runs, team_runs_fk) VALUES(1, 22, 'OUT', 2, 1.5, NULL, NULL);
INSERT INTO plate_appearances (pitcher_fk, batter_fk, pa_result, game_fk, inning, runs, team_runs_fk) VALUES(19, 7, 'SINGLE', 2, 2, NULL, NULL);
INSERT INTO plate_appearances (pitcher_fk, batter_fk, pa_result, game_fk, inning, runs, team_runs_fk) VALUES(19, 8, 'SINGLE', 2, 2, NULL, NULL);
INSERT INTO plate_appearances (pitcher_fk, batter_fk, pa_result, game_fk, inning, runs, team_runs_fk) VALUES(19, 9, 'OUT', 2, 2, NULL, NULL);
INSERT INTO plate_appearances (pitcher_fk, batter_fk, pa_result, game_fk, inning, runs, team_runs_fk) VALUES(19, 1, 'HOMER', 2, 2.1, 3, 1);
INSERT INTO plate_appearances (pitcher_fk, batter_fk, pa_result, game_fk, inning, runs, team_runs_fk) VALUES(19, 2, 'OUT', 2, 2.1, NULL, NULL);
INSERT INTO plate_appearances (pitcher_fk, batter_fk, pa_result, game_fk, inning, runs, team_runs_fk) VALUES(19, 3, 'OUT', 2, 2.2, NULL, NULL);
INSERT INTO plate_appearances (pitcher_fk, batter_fk, pa_result, game_fk, inning, runs, team_runs_fk) VALUES(1, 23, 'OUT', 2, 2.3, NULL, NULL);
INSERT INTO plate_appearances (pitcher_fk, batter_fk, pa_result, game_fk, inning, runs, team_runs_fk) VALUES(1, 24, 'OUT', 2, 2.4, NULL, NULL);
INSERT INTO plate_appearances (pitcher_fk, batter_fk, pa_result, game_fk, inning, runs, team_runs_fk) VALUES(1, 25, 'HOMER', 2, 2.4, 1, 3);
INSERT INTO plate_appearances (pitcher_fk, batter_fk, pa_result, game_fk, inning, runs, team_runs_fk) VALUES(1, 26, 'OUT', 2, 2.5, NULL, NULL);
INSERT INTO plate_appearances (pitcher_fk, batter_fk, pa_result, game_fk, inning, runs, team_runs_fk) VALUES(19, 4, 'DOUBLE', 2, 3, NULL, NULL);
INSERT INTO plate_appearances (pitcher_fk, batter_fk, pa_result, game_fk, inning, runs, team_runs_fk) VALUES(19, 5, 'SINGLE', 2, 3, NULL, NULL);
INSERT INTO plate_appearances (pitcher_fk, batter_fk, pa_result, game_fk, inning, runs, team_runs_fk) VALUES(19, 6, 'OUT', 2, 3, NULL, NULL);
INSERT INTO plate_appearances (pitcher_fk, batter_fk, pa_result, game_fk, inning, runs, team_runs_fk) VALUES(19, 7, 'HOMER', 2, 3.1, 3, 1);
INSERT INTO plate_appearances (pitcher_fk, batter_fk, pa_result, game_fk, inning, runs, team_runs_fk) VALUES(19, 8, 'OUT', 2, 3.1, NULL, NULL);
INSERT INTO plate_appearances (pitcher_fk, batter_fk, pa_result, game_fk, inning, runs, team_runs_fk) VALUES(19, 9, 'OUT', 2, 3.2, NULL, NULL);
INSERT INTO plate_appearances (pitcher_fk, batter_fk, pa_result, game_fk, inning, runs, team_runs_fk) VALUES(1, 27, 'OUT', 2, 3.3, NULL, NULL);
INSERT INTO plate_appearances (pitcher_fk, batter_fk, pa_result, game_fk, inning, runs, team_runs_fk) VALUES(1, 19, 'HOMER', 2, 3.4, 1, 3);
INSERT INTO plate_appearances (pitcher_fk, batter_fk, pa_result, game_fk, inning, runs, team_runs_fk) VALUES(1, 20, 'OUT', 2, 3.4, NULL, NULL);
INSERT INTO plate_appearances (pitcher_fk, batter_fk, pa_result, game_fk, inning, runs, team_runs_fk) VALUES(1, 21, 'OUT', 2, 3.5, NULL, NULL);
INSERT INTO plate_appearances (pitcher_fk, batter_fk, pa_result, game_fk, inning, runs, team_runs_fk) VALUES(19, 10, 'OUT', 3, 1, NULL, NULL);
INSERT INTO plate_appearances (pitcher_fk, batter_fk, pa_result, game_fk, inning, runs, team_runs_fk) VALUES(19, 11, 'HOMER', 3, 1.1, 1, 2);
INSERT INTO plate_appearances (pitcher_fk, batter_fk, pa_result, game_fk, inning, runs, team_runs_fk) VALUES(19, 12, 'OUT', 3, 1.1, NULL, NULL);
INSERT INTO plate_appearances (pitcher_fk, batter_fk, pa_result, game_fk, inning, runs, team_runs_fk) VALUES(19, 13, 'OUT', 3, 1.2, NULL, NULL);
INSERT INTO plate_appearances (pitcher_fk, batter_fk, pa_result, game_fk, inning, runs, team_runs_fk) VALUES(10, 19, 'SINGLE', 3, 1.3, NULL, NULL);
INSERT INTO plate_appearances (pitcher_fk, batter_fk, pa_result, game_fk, inning, runs, team_runs_fk) VALUES(10, 20, 'OUT', 3, 1.3, NULL, NULL);
INSERT INTO plate_appearances (pitcher_fk, batter_fk, pa_result, game_fk, inning, runs, team_runs_fk) VALUES(10, 21, 'DOUBLE', 3, 1.4, NULL, NULL);
INSERT INTO plate_appearances (pitcher_fk, batter_fk, pa_result, game_fk, inning, runs, team_runs_fk) VALUES(10, 22, 'HOMER', 3, 1.4, 3, 3);
INSERT INTO plate_appearances (pitcher_fk, batter_fk, pa_result, game_fk, inning, runs, team_runs_fk) VALUES(10, 23, 'OUT', 3, 1.4, NULL, NULL);
INSERT INTO plate_appearances (pitcher_fk, batter_fk, pa_result, game_fk, inning, runs, team_runs_fk) VALUES(10, 24, 'OUT', 3, 1.5, NULL, NULL);
INSERT INTO plate_appearances (pitcher_fk, batter_fk, pa_result, game_fk, inning, runs, team_runs_fk) VALUES(19, 14, 'HOMER', 3, 2, 1, 2);
INSERT INTO plate_appearances (pitcher_fk, batter_fk, pa_result, game_fk, inning, runs, team_runs_fk) VALUES(19, 15, 'SINGLE', 3, 2, NULL, NULL);
INSERT INTO plate_appearances (pitcher_fk, batter_fk, pa_result, game_fk, inning, runs, team_runs_fk) VALUES(19, 16, 'OUT', 3, 2, NULL, NULL);
INSERT INTO plate_appearances (pitcher_fk, batter_fk, pa_result, game_fk, inning, runs, team_runs_fk) VALUES(19, 17, 'OUT', 3, 2.1, NULL, NULL);
INSERT INTO plate_appearances (pitcher_fk, batter_fk, pa_result, game_fk, inning, runs, team_runs_fk) VALUES(19, 18, 'OUT', 3, 2.2, NULL, NULL);
INSERT INTO plate_appearances (pitcher_fk, batter_fk, pa_result, game_fk, inning, runs, team_runs_fk) VALUES(10, 24, 'HOMER', 3, 2.3, 1, 3);
INSERT INTO plate_appearances (pitcher_fk, batter_fk, pa_result, game_fk, inning, runs, team_runs_fk) VALUES(10, 26, 'SINGLE', 3, 2.3, NULL, NULL);
INSERT INTO plate_appearances (pitcher_fk, batter_fk, pa_result, game_fk, inning, runs, team_runs_fk) VALUES(10, 27, 'SINGLE', 3, 2.3, NULL, NULL);
INSERT INTO plate_appearances (pitcher_fk, batter_fk, pa_result, game_fk, inning, runs, team_runs_fk) VALUES(10, 19, 'OUT', 3, 2.3, NULL, NULL);
INSERT INTO plate_appearances (pitcher_fk, batter_fk, pa_result, game_fk, inning, runs, team_runs_fk) VALUES(10, 20, 'OUT', 3, 2.4, NULL, NULL);
INSERT INTO plate_appearances (pitcher_fk, batter_fk, pa_result, game_fk, inning, runs, team_runs_fk) VALUES(10, 21, 'OUT', 3, 2.5, NULL, NULL);
INSERT INTO plate_appearances (pitcher_fk, batter_fk, pa_result, game_fk, inning, runs, team_runs_fk) VALUES(19, 10, 'OUT', 3, 3, NULL, NULL);
INSERT INTO plate_appearances (pitcher_fk, batter_fk, pa_result, game_fk, inning, runs, team_runs_fk) VALUES(19, 11, 'OUT', 3, 3.1, NULL, NULL);
INSERT INTO plate_appearances (pitcher_fk, batter_fk, pa_result, game_fk, inning, runs, team_runs_fk) VALUES(19, 12, 'OUT', 3, 3.2, NULL, NULL);
INSERT INTO plate_appearances (pitcher_fk, batter_fk, pa_result, game_fk, inning, runs, team_runs_fk) VALUES(10, 22, 'OUT', 3, 3.3, NULL, NULL);
INSERT INTO plate_appearances (pitcher_fk, batter_fk, pa_result, game_fk, inning, runs, team_runs_fk) VALUES(10, 23, 'OUT', 3, 3.4, NULL, NULL);
INSERT INTO plate_appearances (pitcher_fk, batter_fk, pa_result, game_fk, inning, runs, team_runs_fk) VALUES(10, 24, 'OUT', 3, 3.5, NULL, NULL);