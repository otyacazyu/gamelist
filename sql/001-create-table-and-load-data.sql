DROP TABLE IF EXISTS gamelists;

CREATE TABLE gamelists (
  id int unsigned AUTO_INCREMENT,
  gamelist VARCHAR(100) NOT NULL,
  PRIMARY KEY(id)
);

INSERT INTO gamelists (id, gamelist) VALUES (1, "ファイナル　ファンタジー14");
INSERT INTO gamelists (id, gamelist) VALUES (2, "テイルズ　オブ　ファンタジア");
INSERT INTO gamelists (id, gamelist) VALUES (3, "ストリートファイター６");
INSERT INTO gamelists (id, gamelist) VALUES (4, "ペルソナ５");
docker images