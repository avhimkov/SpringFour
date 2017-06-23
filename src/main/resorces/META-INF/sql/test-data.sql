DROP TABLE IF EXISTS CONTACT;
CREATE TABLE CONTACT (
  ID         INT         NOT NULL AUTO_INCREMENT
  ,
  FIRST_NAМE VARCHAR(60) NOT NULL
  ,
  LAST_NAМE  VARCHAR(40) NOT NULL
  ,
  BIRTH_DATE DATE
  ,
  VERSION    INT         NOT NULL DEFAULT 0
  ,
  UNIQUE UQ_CONTACT_1 (FIRST_NAМE, LAST_NAМE)
  ,
  PRIMARY KEY (ID)
);

insert into contact (first_name, last_name, birth_date)
values ('Chris', 'Schaefer', '1981-05-03');
insert into contact (first_name, last_name, birth_date)
values ('Scott', 'Tiger', '1990-11-02');
insert into contact (first_name, last_name, birth_date)
values ('John', 'Smith', '1964-02-28');