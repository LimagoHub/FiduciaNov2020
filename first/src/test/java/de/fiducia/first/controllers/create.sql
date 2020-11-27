DROP TABLE IF EXISTS tblschweine;



CREATE TABLE tblschweine (
  id varchar(36) NOT NULL,
  gewicht int(11) NOT NULL,
  name varchar(30) DEFAULT NULL,
  PRIMARY KEY (id)
);
