CREATE TABLE test.ess_game_info(
	id INT NOT NULL AUTO_INCREMENT,
	game_name varchar(100) NULL,
	game_desc varchar(100) NULL,
	game_time TIMESTAMP NULL,
	primary key(id)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8
COLLATE=utf8_general_ci;


CREATE TABLE test.ess_news_info(
	id INT NOT NULL AUTO_INCREMENT,
	news_name varchar(100) NULL,
	news_desc varchar(100) NULL,
	primary key(id)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8
COLLATE=utf8_general_ci;



CREATE TABLE test.ess_team_info(
	id INT NOT NULL AUTO_INCREMENT,
	team_name varchar(100) NULL,
	team_desc varchar(100) NULL,
	primary key(id)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8
COLLATE=utf8_general_ci;



CREATE TABLE test.ess_user_info(
	id INT NOT NULL AUTO_INCREMENT,
	user_name varchar(100) NULL,
	password varchar(100) NULL,
	user_role INT NULL,
	primary key(id)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8
COLLATE=utf8_general_ci;