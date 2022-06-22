USE baseball;

SET FOREIGN_KEY_CHECKS=0; DROP table if exists teams; SET FOREIGN_KEY_CHECKS=1;
SET FOREIGN_KEY_CHECKS=0; DROP TABLE if exists players; SET FOREIGN_KEY_CHECKS=1;
SET FOREIGN_KEY_CHECKS=0; DROP TABLE if exists transactions; SET FOREIGN_KEY_CHECKS=1;
SET FOREIGN_KEY_CHECKS=0; DROP TABLE if exists games; SET FOREIGN_KEY_CHECKS=1;
SET FOREIGN_KEY_CHECKS=0; DROP TABLE if exists plate_appearances; SET FOREIGN_KEY_CHECKS=1;



CREATE TABLE teams (
  team_pk int NOT NULL AUTO_INCREMENT,
  team_location varchar(40) not null, 
  team_name varchar(40) NOT NULL, 
  wins int,
  losses int,
  PRIMARY KEY (team_pk)
);

CREATE TABLE players (
  player_pk int NOT NULL AUTO_INCREMENT,
  player_position enum('P','C','1B','2B','3B','SS','LF','CF','RF','DH') NOT NULL,
  first_name varchar(40) NOT NULL,
  last_name varchar(40) NOT NULL,
  team_fk int not null,
  PRIMARY KEY (player_pk),
  FOREIGN KEY (team_fk) REFERENCES teams (team_pk)
);

CREATE TABLE transactions (
  transaction_pk int NOT NULL AUTO_INCREMENT,
  player_1_fk int NOT NULL,
  player_2_fk int,
  player_1_team_fk int NOT NULL,
  player_2_team_fk int,
  transaction_type enum('Sign', 'Trade', 'Release') not NULL,
  PRIMARY KEY (transaction_pk),
  FOREIGN KEY (player_1_team_fk) REFERENCES teams (team_pk),
  FOREIGN KEY (player_1_fk) REFERENCES players (player_pk),
  FOREIGN KEY (player_2_team_fk) REFERENCES teams (team_pk),
  FOREIGN KEY (player_2_fk) REFERENCES players (player_pk)

);

CREATE TABLE games (
  game_pk int NOT NULL AUTO_INCREMENT,
  team_1_fk int NOT NULL,
  team_2_fk int not NULL,
  team_1_result enum('W', 'L') not NULL,
  team_2_result enum('W', 'L') not NULL,
  PRIMARY KEY (game_pk),
  FOREIGN KEY (team_1_fk) REFERENCES teams (team_pk),
  FOREIGN KEY (team_2_fk) REFERENCES teams (team_pk)
);

CREATE TABLE plate_appearances (
  pa_pk int NOT NULL AUTO_INCREMENT,
  pitcher_fk int NOT NULL,
  batter_fk int NOT NULL,
  pa_result enum ('O', '1B', '2B', '3B', 'HR') NOT NULL,
  game_fk int not null,
  inning decimal(2,1) not null,
  runs int,
  team_runs_fk int,
  PRIMARY KEY (pa_pk),
  FOREIGN KEY (pitcher_fk) REFERENCES players (player_pk),
  FOREIGN KEY (batter_fk) REFERENCES players (player_pk),
  FOREIGN KEY (game_fk) REFERENCES games (game_pk),
  FOREIGN KEY (team_runs_fk) REFERENCES teams (team_pk)
);

-- Teams --
INSERT INTO teams (team_location, team_name, wins, losses) VALUES('Minnesota', 'Twins', 2, 0);
INSERT INTO teams (team_location, team_name, wins, losses) VALUES('Detroit', 'Tigers', 1, 1);
INSERT INTO teams (team_location, team_name, wins, losses) VALUES('Chicago', 'White Sox', 0, 2);

-- Players --
INSERT INTO players (first_name, last_name, team_fk, player_position) VALUES('Sonny', 'Gray', 1, 'P');
INSERT INTO players (first_name, last_name, team_fk, player_position) VALUES('Ryan', 'Jeffers', 1, 'C');
INSERT INTO players (first_name, last_name, team_fk, player_position) VALUES('Luis', 'Arraez', 1, '1B');
INSERT INTO players (first_name, last_name, team_fk, player_position) VALUES('Jorge', 'Polanco', 1, '2B');
INSERT INTO players (first_name, last_name, team_fk, player_position) VALUES('Gio', 'Urshela', 1, '3B');
INSERT INTO players (first_name, last_name, team_fk, player_position) VALUES('Carlos', 'Correa', 1, 'SS');
INSERT INTO players (first_name, last_name, team_fk, player_position) VALUES('Trevor', 'Larnach', 1, 'LF');
INSERT INTO players (first_name, last_name, team_fk, player_position) VALUES('Byron', 'Buxton', 1, 'CF');
INSERT INTO players (first_name, last_name, team_fk, player_position) VALUES('Max', 'Kepler', 1, 'RF');
INSERT INTO players (first_name, last_name, team_fk, player_position) VALUES('Tarik', 'Skubal', 2, 'P');
INSERT INTO players (first_name, last_name, team_fk, player_position) VALUES('Tucker', 'Barnhard', 2, 'C');
INSERT INTO players (first_name, last_name, team_fk, player_position) VALUES('Spencer', 'Torkelson', 2, '1B');
INSERT INTO players (first_name, last_name, team_fk, player_position) VALUES('Jonathan', 'Schoop', 2, '2B');
INSERT INTO players (first_name, last_name, team_fk, player_position) VALUES('Jeimer', 'Candelario', 2, '3B');
INSERT INTO players (first_name, last_name, team_fk, player_position) VALUES('Javier', 'Baez', 2, 'SS');
INSERT INTO players (first_name, last_name, team_fk, player_position) VALUES('Robbie', 'Grossman', 2, 'LF');
INSERT INTO players (first_name, last_name, team_fk, player_position) VALUES('Willi', 'Castro', 2, 'CF');
INSERT INTO players (first_name, last_name, team_fk, player_position) VALUES('Austin', 'Meadows', 2, 'RF');
INSERT INTO players (first_name, last_name, team_fk, player_position) VALUES('Lucas', 'Giolito', 3, 'P');
INSERT INTO players (first_name, last_name, team_fk, player_position) VALUES('Yasmani', 'Grandal', 3, 'C');
INSERT INTO players (first_name, last_name, team_fk, player_position) VALUES('Jose', 'Abreu', 3, '1B');
INSERT INTO players (first_name, last_name, team_fk, player_position) VALUES('Josh', 'Harrison', 3, '2B');
INSERT INTO players (first_name, last_name, team_fk, player_position) VALUES('Yoan', 'Moncada', 3, '3B');
INSERT INTO players (first_name, last_name, team_fk, player_position) VALUES('Tim', 'Anderson', 3, 'SS');
INSERT INTO players (first_name, last_name, team_fk, player_position) VALUES('Andrew', 'Vaughn', 3, 'LF');
INSERT INTO players (first_name, last_name, team_fk, player_position) VALUES('Luis', 'Robert', 3, 'CF');
INSERT INTO players (first_name, last_name, team_fk, player_position) VALUES('AJ', 'Pollock', 3, 'RF');

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
INSERT INTO plate_appearances (pitcher_fk, batter_fk, pa_result, game_fk, inning, runs, team_runs_fk) VALUES(1, 10, 'O', 1, 1, NULL, NULL);
INSERT INTO plate_appearances (pitcher_fk, batter_fk, pa_result, game_fk, inning, runs, team_runs_fk) VALUES(1, 11, '1B', 1, 1.1, NULL, NULL);
INSERT INTO plate_appearances (pitcher_fk, batter_fk, pa_result, game_fk, inning, runs, team_runs_fk) VALUES(1, 12, 'O', 1, 1.1, NULL, NULL);
INSERT INTO plate_appearances (pitcher_fk, batter_fk, pa_result, game_fk, inning, runs, team_runs_fk) VALUES(1, 13, 'O', 1, 1.2, NULL, NULL);
INSERT INTO plate_appearances (pitcher_fk, batter_fk, pa_result, game_fk, inning, runs, team_runs_fk) VALUES(10, 1, '1B', 1, 1.3, NULL, NULL);
INSERT INTO plate_appearances (pitcher_fk, batter_fk, pa_result, game_fk, inning, runs, team_runs_fk) VALUES(10, 2, 'O', 1, 1.3, NULL, NULL);
INSERT INTO plate_appearances (pitcher_fk, batter_fk, pa_result, game_fk, inning, runs, team_runs_fk) VALUES(10, 3, '2B', 1, 1.4, NULL, NULL);
INSERT INTO plate_appearances (pitcher_fk, batter_fk, pa_result, game_fk, inning, runs, team_runs_fk) VALUES(10, 4, 'HR', 1, 1.4, 3, 1);
INSERT INTO plate_appearances (pitcher_fk, batter_fk, pa_result, game_fk, inning, runs, team_runs_fk) VALUES(10, 5, 'O', 1, 1.4, NULL, NULL);
INSERT INTO plate_appearances (pitcher_fk, batter_fk, pa_result, game_fk, inning, runs, team_runs_fk) VALUES(10, 6, 'O', 1, 1.5, NULL, NULL);
INSERT INTO plate_appearances (pitcher_fk, batter_fk, pa_result, game_fk, inning, runs, team_runs_fk) VALUES(1, 14, 'HR', 1, 2, 1, 2);
INSERT INTO plate_appearances (pitcher_fk, batter_fk, pa_result, game_fk, inning, runs, team_runs_fk) VALUES(1, 15, '1B', 1, 2, NULL, NULL);
INSERT INTO plate_appearances (pitcher_fk, batter_fk, pa_result, game_fk, inning, runs, team_runs_fk) VALUES(1, 16, 'O', 1, 2, NULL, NULL);
INSERT INTO plate_appearances (pitcher_fk, batter_fk, pa_result, game_fk, inning, runs, team_runs_fk) VALUES(1, 17, 'O', 1, 2.1, NULL, NULL);
INSERT INTO plate_appearances (pitcher_fk, batter_fk, pa_result, game_fk, inning, runs, team_runs_fk) VALUES(1, 18, 'O', 1, 2.2, NULL, NULL);
INSERT INTO plate_appearances (pitcher_fk, batter_fk, pa_result, game_fk, inning, runs, team_runs_fk) VALUES(10, 7, '1B', 1, 2.3, NULL, NULL);
INSERT INTO plate_appearances (pitcher_fk, batter_fk, pa_result, game_fk, inning, runs, team_runs_fk) VALUES(10, 8, '1B', 1, 2.3, NULL, NULL);
INSERT INTO plate_appearances (pitcher_fk, batter_fk, pa_result, game_fk, inning, runs, team_runs_fk) VALUES(10, 9, '1B', 1, 2.3, NULL, NULL);
INSERT INTO plate_appearances (pitcher_fk, batter_fk, pa_result, game_fk, inning, runs, team_runs_fk) VALUES(10, 1, 'O', 1, 2.3, NULL, NULL);
INSERT INTO plate_appearances (pitcher_fk, batter_fk, pa_result, game_fk, inning, runs, team_runs_fk) VALUES(10, 2, 'O', 1, 2.4, NULL, NULL);
INSERT INTO plate_appearances (pitcher_fk, batter_fk, pa_result, game_fk, inning, runs, team_runs_fk) VALUES(10, 3, 'O', 1, 2.5, NULL, NULL);
INSERT INTO plate_appearances (pitcher_fk, batter_fk, pa_result, game_fk, inning, runs, team_runs_fk) VALUES(1, 10, 'O', 1, 3, NULL, NULL);
INSERT INTO plate_appearances (pitcher_fk, batter_fk, pa_result, game_fk, inning, runs, team_runs_fk) VALUES(1, 11, 'O', 1, 3.1, NULL, NULL);
INSERT INTO plate_appearances (pitcher_fk, batter_fk, pa_result, game_fk, inning, runs, team_runs_fk) VALUES(1, 12, 'O', 1, 3.2, NULL, NULL);
INSERT INTO plate_appearances (pitcher_fk, batter_fk, pa_result, game_fk, inning, runs, team_runs_fk) VALUES(10, 4, 'O', 1, 3.3, NULL, NULL);
INSERT INTO plate_appearances (pitcher_fk, batter_fk, pa_result, game_fk, inning, runs, team_runs_fk) VALUES(10, 5, 'O', 1, 3.4, NULL, NULL);
INSERT INTO plate_appearances (pitcher_fk, batter_fk, pa_result, game_fk, inning, runs, team_runs_fk) VALUES(10, 6, 'O', 1, 3.5, NULL, NULL);
INSERT INTO plate_appearances (pitcher_fk, batter_fk, pa_result, game_fk, inning, runs, team_runs_fk) VALUES(19, 1, '1B', 2, 1, NULL, NULL);
INSERT INTO plate_appearances (pitcher_fk, batter_fk, pa_result, game_fk, inning, runs, team_runs_fk) VALUES(19, 2, '1B', 2, 1, NULL, NULL);
INSERT INTO plate_appearances (pitcher_fk, batter_fk, pa_result, game_fk, inning, runs, team_runs_fk) VALUES(19, 3, 'O', 2, 1, NULL, NULL);
INSERT INTO plate_appearances (pitcher_fk, batter_fk, pa_result, game_fk, inning, runs, team_runs_fk) VALUES(19, 4, '2B', 2, 1.1, 1, 1);
INSERT INTO plate_appearances (pitcher_fk, batter_fk, pa_result, game_fk, inning, runs, team_runs_fk) VALUES(19, 5, 'O', 2, 1.1, NULL, NULL);
INSERT INTO plate_appearances (pitcher_fk, batter_fk, pa_result, game_fk, inning, runs, team_runs_fk) VALUES(19, 6, 'O', 2, 1.2, NULL, NULL);
INSERT INTO plate_appearances (pitcher_fk, batter_fk, pa_result, game_fk, inning, runs, team_runs_fk) VALUES(1, 19, 'O', 2, 1.3, NULL, NULL);
INSERT INTO plate_appearances (pitcher_fk, batter_fk, pa_result, game_fk, inning, runs, team_runs_fk) VALUES(1, 20, 'HR', 2, 1.3, 1, 3);
INSERT INTO plate_appearances (pitcher_fk, batter_fk, pa_result, game_fk, inning, runs, team_runs_fk) VALUES(1, 21, 'O', 2, 1.4, NULL, NULL);
INSERT INTO plate_appearances (pitcher_fk, batter_fk, pa_result, game_fk, inning, runs, team_runs_fk) VALUES(1, 22, 'O', 2, 1.5, NULL, NULL);
INSERT INTO plate_appearances (pitcher_fk, batter_fk, pa_result, game_fk, inning, runs, team_runs_fk) VALUES(19, 7, '1B', 2, 2, NULL, NULL);
INSERT INTO plate_appearances (pitcher_fk, batter_fk, pa_result, game_fk, inning, runs, team_runs_fk) VALUES(19, 8, '1B', 2, 2, NULL, NULL);
INSERT INTO plate_appearances (pitcher_fk, batter_fk, pa_result, game_fk, inning, runs, team_runs_fk) VALUES(19, 9, 'O', 2, 2, NULL, NULL);
INSERT INTO plate_appearances (pitcher_fk, batter_fk, pa_result, game_fk, inning, runs, team_runs_fk) VALUES(19, 1, 'HR', 2, 2.1, 3, 1);
INSERT INTO plate_appearances (pitcher_fk, batter_fk, pa_result, game_fk, inning, runs, team_runs_fk) VALUES(19, 2, 'O', 2, 2.1, NULL, NULL);
INSERT INTO plate_appearances (pitcher_fk, batter_fk, pa_result, game_fk, inning, runs, team_runs_fk) VALUES(19, 3, 'O', 2, 2.2, NULL, NULL);
INSERT INTO plate_appearances (pitcher_fk, batter_fk, pa_result, game_fk, inning, runs, team_runs_fk) VALUES(1, 23, 'O', 2, 2.3, NULL, NULL);
INSERT INTO plate_appearances (pitcher_fk, batter_fk, pa_result, game_fk, inning, runs, team_runs_fk) VALUES(1, 24, 'O', 2, 2.4, NULL, NULL);
INSERT INTO plate_appearances (pitcher_fk, batter_fk, pa_result, game_fk, inning, runs, team_runs_fk) VALUES(1, 25, 'HR', 2, 2.4, 1, 3);
INSERT INTO plate_appearances (pitcher_fk, batter_fk, pa_result, game_fk, inning, runs, team_runs_fk) VALUES(1, 26, 'O', 2, 2.5, NULL, NULL);
INSERT INTO plate_appearances (pitcher_fk, batter_fk, pa_result, game_fk, inning, runs, team_runs_fk) VALUES(19, 4, '2B', 2, 3, NULL, NULL);
INSERT INTO plate_appearances (pitcher_fk, batter_fk, pa_result, game_fk, inning, runs, team_runs_fk) VALUES(19, 5, '1B', 2, 3, NULL, NULL);
INSERT INTO plate_appearances (pitcher_fk, batter_fk, pa_result, game_fk, inning, runs, team_runs_fk) VALUES(19, 6, 'O', 2, 3, NULL, NULL);
INSERT INTO plate_appearances (pitcher_fk, batter_fk, pa_result, game_fk, inning, runs, team_runs_fk) VALUES(19, 7, 'HR', 2, 3.1, 3, 1);
INSERT INTO plate_appearances (pitcher_fk, batter_fk, pa_result, game_fk, inning, runs, team_runs_fk) VALUES(19, 8, 'O', 2, 3.1, NULL, NULL);
INSERT INTO plate_appearances (pitcher_fk, batter_fk, pa_result, game_fk, inning, runs, team_runs_fk) VALUES(19, 9, 'O', 2, 3.2, NULL, NULL);
INSERT INTO plate_appearances (pitcher_fk, batter_fk, pa_result, game_fk, inning, runs, team_runs_fk) VALUES(1, 27, 'O', 2, 3.3, NULL, NULL);
INSERT INTO plate_appearances (pitcher_fk, batter_fk, pa_result, game_fk, inning, runs, team_runs_fk) VALUES(1, 19, 'HR', 2, 3.4, 1, 3);
INSERT INTO plate_appearances (pitcher_fk, batter_fk, pa_result, game_fk, inning, runs, team_runs_fk) VALUES(1, 20, 'O', 2, 3.4, NULL, NULL);
INSERT INTO plate_appearances (pitcher_fk, batter_fk, pa_result, game_fk, inning, runs, team_runs_fk) VALUES(1, 21, 'O', 2, 3.5, NULL, NULL);
INSERT INTO plate_appearances (pitcher_fk, batter_fk, pa_result, game_fk, inning, runs, team_runs_fk) VALUES(19, 10, 'O', 3, 1, NULL, NULL);
INSERT INTO plate_appearances (pitcher_fk, batter_fk, pa_result, game_fk, inning, runs, team_runs_fk) VALUES(19, 11, 'HR', 3, 1.1, 1, 2);
INSERT INTO plate_appearances (pitcher_fk, batter_fk, pa_result, game_fk, inning, runs, team_runs_fk) VALUES(19, 12, 'O', 3, 1.1, NULL, NULL);
INSERT INTO plate_appearances (pitcher_fk, batter_fk, pa_result, game_fk, inning, runs, team_runs_fk) VALUES(19, 13, 'O', 3, 1.2, NULL, NULL);
INSERT INTO plate_appearances (pitcher_fk, batter_fk, pa_result, game_fk, inning, runs, team_runs_fk) VALUES(10, 19, '1B', 3, 1.3, NULL, NULL);
INSERT INTO plate_appearances (pitcher_fk, batter_fk, pa_result, game_fk, inning, runs, team_runs_fk) VALUES(10, 20, 'O', 3, 1.3, NULL, NULL);
INSERT INTO plate_appearances (pitcher_fk, batter_fk, pa_result, game_fk, inning, runs, team_runs_fk) VALUES(10, 21, '2B', 3, 1.4, NULL, NULL);
INSERT INTO plate_appearances (pitcher_fk, batter_fk, pa_result, game_fk, inning, runs, team_runs_fk) VALUES(10, 22, 'HR', 3, 1.4, 3, 3);
INSERT INTO plate_appearances (pitcher_fk, batter_fk, pa_result, game_fk, inning, runs, team_runs_fk) VALUES(10, 23, 'O', 3, 1.4, NULL, NULL);
INSERT INTO plate_appearances (pitcher_fk, batter_fk, pa_result, game_fk, inning, runs, team_runs_fk) VALUES(10, 24, 'O', 3, 1.5, NULL, NULL);
INSERT INTO plate_appearances (pitcher_fk, batter_fk, pa_result, game_fk, inning, runs, team_runs_fk) VALUES(19, 14, 'HR', 3, 2, 1, 2);
INSERT INTO plate_appearances (pitcher_fk, batter_fk, pa_result, game_fk, inning, runs, team_runs_fk) VALUES(19, 15, '1B', 3, 2, NULL, NULL);
INSERT INTO plate_appearances (pitcher_fk, batter_fk, pa_result, game_fk, inning, runs, team_runs_fk) VALUES(19, 16, 'O', 3, 2, NULL, NULL);
INSERT INTO plate_appearances (pitcher_fk, batter_fk, pa_result, game_fk, inning, runs, team_runs_fk) VALUES(19, 17, 'O', 3, 2.1, NULL, NULL);
INSERT INTO plate_appearances (pitcher_fk, batter_fk, pa_result, game_fk, inning, runs, team_runs_fk) VALUES(19, 18, 'O', 3, 2.2, NULL, NULL);
INSERT INTO plate_appearances (pitcher_fk, batter_fk, pa_result, game_fk, inning, runs, team_runs_fk) VALUES(10, 24, 'HR', 3, 2.3, 1, 3);
INSERT INTO plate_appearances (pitcher_fk, batter_fk, pa_result, game_fk, inning, runs, team_runs_fk) VALUES(10, 26, '1B', 3, 2.3, NULL, NULL);
INSERT INTO plate_appearances (pitcher_fk, batter_fk, pa_result, game_fk, inning, runs, team_runs_fk) VALUES(10, 27, '1B', 3, 2.3, NULL, NULL);
INSERT INTO plate_appearances (pitcher_fk, batter_fk, pa_result, game_fk, inning, runs, team_runs_fk) VALUES(10, 19, 'O', 3, 2.3, NULL, NULL);
INSERT INTO plate_appearances (pitcher_fk, batter_fk, pa_result, game_fk, inning, runs, team_runs_fk) VALUES(10, 20, 'O', 3, 2.4, NULL, NULL);
INSERT INTO plate_appearances (pitcher_fk, batter_fk, pa_result, game_fk, inning, runs, team_runs_fk) VALUES(10, 21, 'O', 3, 2.5, NULL, NULL);
INSERT INTO plate_appearances (pitcher_fk, batter_fk, pa_result, game_fk, inning, runs, team_runs_fk) VALUES(19, 10, 'O', 3, 3, NULL, NULL);
INSERT INTO plate_appearances (pitcher_fk, batter_fk, pa_result, game_fk, inning, runs, team_runs_fk) VALUES(19, 11, 'O', 3, 3.1, NULL, NULL);
INSERT INTO plate_appearances (pitcher_fk, batter_fk, pa_result, game_fk, inning, runs, team_runs_fk) VALUES(19, 12, 'O', 3, 3.2, NULL, NULL);
INSERT INTO plate_appearances (pitcher_fk, batter_fk, pa_result, game_fk, inning, runs, team_runs_fk) VALUES(10, 22, 'O', 3, 3.3, NULL, NULL);
INSERT INTO plate_appearances (pitcher_fk, batter_fk, pa_result, game_fk, inning, runs, team_runs_fk) VALUES(10, 23, 'O', 3, 3.4, NULL, NULL);
INSERT INTO plate_appearances (pitcher_fk, batter_fk, pa_result, game_fk, inning, runs, team_runs_fk) VALUES(10, 24, 'O', 3, 3.5, NULL, NULL);
