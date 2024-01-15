DROP TABLE IF EXISTS gamelists;

CREATE TABLE gamelists (
  id int unsigned AUTO_INCREMENT,
  name VARCHAR(100) NOT NULL,
  PRIMARY KEY(id)
);

INSERT INTO gamelists (id, name) VALUES (1, "ファイナル　ファンタジー14");
INSERT INTO gamelists (id, name) VALUES (2, "テイルズ　オブ　ファンタジア");
INSERT INTO gamelists (id, name) VALUES (3, "ストリートファイター６");
INSERT INTO gamelists (id, name) VALUES (4, "ペルソナ５");
