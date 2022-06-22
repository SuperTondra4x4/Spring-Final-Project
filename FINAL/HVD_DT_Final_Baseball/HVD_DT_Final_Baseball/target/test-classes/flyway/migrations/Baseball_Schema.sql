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
  player_position enum('PITCHER','CATCHER','FIRST','SECOND','THIRD','SHORT','LEFT','CENTER','RIGHT','DESIGNATED') NOT NULL,
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
  transaction_type enum('SIGN', 'TRADE', 'RELEASE') not NULL,
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
  pa_result enum ('OUT', 'SINGLE', 'DOUBLE', 'TRIPLE', 'HOMER') NOT NULL,
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