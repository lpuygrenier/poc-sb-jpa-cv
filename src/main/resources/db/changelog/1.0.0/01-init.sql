--liquibase formatted sql
--changeset lpuygrenier:1
CREATE TABLE cv (
    id INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE language (
    id INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    name VARCHAR(100) NOT NULL
);

CREATE TABLE language_level (
    id INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    level VARCHAR(10) NOT NULL
);

CREATE TABLE cv_language (
    cv_id INT NOT NULL,
    language_id INT NOT NULL,
    level_id INT NOT NULL,
    PRIMARY KEY (cv_id, language_id, level_id),
    CONSTRAINT fk_cv FOREIGN KEY (cv_id) REFERENCES cv(id),
    CONSTRAINT fk_language FOREIGN KEY (language_id) REFERENCES language(id),
    CONSTRAINT fk_level FOREIGN KEY (level_id) REFERENCES language_level(id)
);

INSERT INTO language_level (level) VALUES
  ('a1'),
  ('a2'),
  ('b1'),
  ('b2');

INSERT INTO language (name) VALUES
  ('french'),
  ('english'),
  ('german');

INSERT INTO cv (name) VALUES
  ('Armand'),
  ('Emie'),
  ('Leo');

INSERT INTO cv_language (cv_id, language_id, level_id) VALUES
  (1, 1, 1),
  (1, 2, 2),
  (1, 3, 3);

INSERT INTO cv_language (cv_id, language_id, level_id) VALUES
  (2, 1, 3),
  (2, 2, 4);

INSERT INTO cv_language (cv_id, language_id, level_id) VALUES
  (3, 1, 1),
  (3, 2, 2);


--changeset lpuygrenier:2
DELETE FROM cv_language;
DELETE FROM cv;

ALTER TABLE cv DROP COLUMN name;

CREATE TABLE app_user (
    id INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    name VARCHAR(255) NOT NULL
);

INSERT INTO app_user (name) VALUES
  ('Armand'),
  ('Emie'),
  ('Leo');

ALTER TABLE cv ADD COLUMN user_id INT NOT NULL;
ALTER TABLE cv ADD CONSTRAINT fk_user FOREIGN KEY (user_id) REFERENCES app_user(id);