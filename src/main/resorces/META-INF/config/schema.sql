USE TEST;
DROP TABLE IF EXISTS CONTACT;
CREATE TABLE CAR (
ID INT NOT NULL AUTO_INCREMENT
, LICENSE_PLATE VARCHAR(20) NOT NULL
, МANUFACTURER VARCHAR(20) NOT NULL
, МANUFACTURE_DATE DATE NOT NULL
, AGE INT NOT NULL DEFAULT 0
, VERSION INT NOT NULL DEFAULT 0
, UNIQUE UQ_CAR_l (LICENSE_PLATE)
, PRIMARY KEY (ID)
) ;