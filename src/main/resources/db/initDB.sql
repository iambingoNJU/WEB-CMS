
DROP DATABASE test;
CREATE DATABASE IF NOT EXISTS test;

ALTER DATABASE test
DEFAULT CHARACTER SET utf8
DEFAULT COLLATE utf8_general_ci;

GRANT ALL PRIVILEGES ON test.* TO pc@localhost IDENTIFIED BY 'pc';

USE test;

CREATE TABLE IF NOT EXISTS  student (
  id     BIGINT NOT NULL AUTO_INCREMENT PRIMARY  KEY,
  name   VARCHAR(80),
  major  VARCHAR(80),
  grade_usual  DOUBLE ,
  grade_homework DOUBLE,
  grade_exam   DOUBLE
)