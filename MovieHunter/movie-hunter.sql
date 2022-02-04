DROP DATABASE IF EXISTS `movie-hunter`;

CREATE DATABASE IF NOT EXISTS `movie-hunter`;

USE `movie-hunter`;

CREATE TABLE CITY (
	CITY_ID INT(4) NOT NULL AUTO_INCREMENT,
	CITY_NAME VARCHAR(20) NOT NULL,
	CITY_STATE VARCHAR(20) NOT NULL,
	CITY_PIN INT(6) NOT NULL,
	CONSTRAINT PK_CITY_ID PRIMARY KEY (CITY_ID)
) ENGINE=InnoDB;

ALTER TABLE CITY AUTO_INCREMENT = 1;

CREATE TABLE THEATRE (
	THEATRE_ID INT(4) NOT NULL AUTO_INCREMENT,
	THEATRE_NAME VARCHAR(64) NOT NULL,
	THEATRE_SCREENS INT(2) NOT NULL,
    THEATRE_CITY_ID INT(4) NOT NULL,
	CONSTRAINT PK_THEATRE_ID PRIMARY KEY (THEATRE_ID),
  	CONSTRAINT FK_THEATRE_CITY_ID FOREIGN KEY (THEATRE_CITY_ID) REFERENCES CITY (CITY_ID)
) ENGINE=InnoDB;

ALTER TABLE THEATRE AUTO_INCREMENT = 1;

CREATE TABLE MOVIE (
	MOVIE_ID INT(4) NOT NULL AUTO_INCREMENT,
	MOVIE_TITLE VARCHAR(100) NOT NULL,
	MOVIE_DESCRIPTION VARCHAR(400) NOT NULL,
	DURATION VARCHAR(10) NOT NULL,
    LANG VARCHAR(16) NOT NULL,
    RELEASE_DATE DATETIME,
    COUNTRY VARCHAR(64) NOT NULL,
    GENERE VARCHAR(20) NOT NULL,
	CONSTRAINT PK_MOVIE_ID PRIMARY KEY (MOVIE_ID)
) ENGINE=InnoDB;

ALTER TABLE MOVIE AUTO_INCREMENT = 1;

CREATE TABLE SCREEN (
	SCREEN_ID INT(4) NOT NULL AUTO_INCREMENT,
    SCREEN_NAME VARCHAR(64) NOT NULL,
    TOTAL_SEATS INT(4) NULL NULL,
    SCREEN_THEATRE_ID INT(4) NOT NULL,
    CONSTRAINT PK_SCREEN_ID PRIMARY KEY (SCREEN_ID),
    CONSTRAINT FK_SCREEN_THEATRE_ID FOREIGN KEY (SCREEN_THEATRE_ID) REFERENCES THEATRE (THEATRE_ID)
) ENGINE=InnoDB;

ALTER TABLE SCREEN AUTO_INCREMENT = 1;


CREATE TABLE SCREEN_SEAT (
	SCREEN_SEAT_ID INT(4) NOT NULL AUTO_INCREMENT,
    SEAT_NUMBER VARCHAR(64) NOT NULL,
    SEAT_TYPE VARCHAR(1) NULL NULL,
    SCREEN_THEATRE_SEAT_ID INT(4) NOT NULL,
    PRICE VARCHAR(10) NOT NULL,
    CONSTRAINT PK_SCREEN_SEAT_ID PRIMARY KEY (SCREEN_SEAT_ID),
    CONSTRAINT FK_SCREEN_THEATRE_SEAT_ID FOREIGN KEY (SCREEN_THEATRE_SEAT_ID) REFERENCES SCREEN (SCREEN_ID)
) ENGINE=InnoDB;

ALTER TABLE SCREEN_SEAT AUTO_INCREMENT = 1;


CREATE TABLE MOVIE_SHOW (
	MOVIE_SHOW_ID INT(4) NOT NULL AUTO_INCREMENT,
    MOVIE_SHOW_DATE DATETIME NOT NULL,
    MOVIE_SHOW_STARTTIME VARCHAR(10) NULL NULL,
    MOVIE_SHOW_ENDTIME VARCHAR(10) NOT NULL,
    MOVIE_SHOW_SCREEN_ID INT(4) NOT NULL,
    MOVIE_SHOW_MOVIE_ID INT(4) NOT NULL,
    CONSTRAINT PK_MOVIE_SHOW_ID PRIMARY KEY (MOVIE_SHOW_ID),
    CONSTRAINT FK_MOVIE_SHOW_SCREEN_ID FOREIGN KEY (MOVIE_SHOW_SCREEN_ID) REFERENCES SCREEN (SCREEN_ID)/*,
    CONSTRAINT FK_MOVIE_SHOW_MOVIE_ID FOREIGN KEY (MOVIE_SHOW_MOVIE_ID) REFERENCES MOVIE (MOVIE_ID)*/
) ENGINE=InnoDB;

ALTER TABLE MOVIE_SHOW AUTO_INCREMENT = 1;


CREATE TABLE USERS (
	USERS_ID INT(4) NOT NULL AUTO_INCREMENT,
    USERS_NAME VARCHAR(64) NOT NULL,
    USERS_PASSWORD VARCHAR(64) NULL NULL,
    USERS_EMAIL VARCHAR(64) NOT NULL,
    USERS_PHONE INT(10) NOT NULL,
    CONSTRAINT PK_USERS_ID PRIMARY KEY (USERS_ID)
) ENGINE=InnoDB;

ALTER TABLE USERS AUTO_INCREMENT = 1;


CREATE TABLE BOOKING (
	BOOKING_ID INT(4) NOT NULL AUTO_INCREMENT,
    NO_OF_SEATS INT(2) NOT NULL,
    TIME_OF_BOOKING DATETIME NULL NULL,
    BOOKING_STATUS VARCHAR(2) NOT NULL,
   /* BOOKING_USER_ID INT(4) NOT NULL,*/
    BOOKING_MOVIE_SHOW_ID INT(4) NOT NULL,
    CONSTRAINT PK_BOOKING_ID PRIMARY KEY (BOOKING_ID),
 /*   CONSTRAINT FK_BOOKING_USER_ID FOREIGN KEY (BOOKING_USER_ID) REFERENCES USERS (USERS_ID),*/
    CONSTRAINT FK_BOOKING_MOVIE_SHOW_ID FOREIGN KEY (BOOKING_MOVIE_SHOW_ID) REFERENCES MOVIE_SHOW (MOVIE_SHOW_ID)
) ENGINE=InnoDB;

ALTER TABLE BOOKING AUTO_INCREMENT = 1;


CREATE TABLE SHOW_SEAT (
	SHOW_SEAT_ID INT(4) NOT NULL AUTO_INCREMENT,
    SHOW_SEAT_STATUS VARCHAR(1) NOT NULL,
    SCREEN_SEAT_ID INT(4) NOT NULL,
    MOVIE_SHOW_ID INT(4) NOT NULL,
    BOOKING_ID INT(4) NOT NULL,
    CONSTRAINT PK_SHOW_SEAT_ID PRIMARY KEY (SHOW_SEAT_ID),
    CONSTRAINT FK_SCREEN_SEAT_ID FOREIGN KEY (SCREEN_SEAT_ID) REFERENCES SCREEN_SEAT (SCREEN_SEAT_ID),
    CONSTRAINT FK_MOVIE_SHOW_ID FOREIGN KEY (MOVIE_SHOW_ID) REFERENCES MOVIE_SHOW (MOVIE_SHOW_ID),
    CONSTRAINT FK_BOOKING_ID FOREIGN KEY (BOOKING_ID) REFERENCES BOOKING (BOOKING_ID)
) ENGINE=InnoDB;

ALTER TABLE SHOW_SEAT AUTO_INCREMENT = 1;

CREATE TABLE PAYMENT (
	PAYMENT_ID INT(4) NOT NULL AUTO_INCREMENT,
    AMOUNT DECIMAL(4,2) NOT NULL,
    PAYMENT_TIME DATETIME NULL NULL,
    DISCOUNT_COUPON_ID INT(4) NOT NULL,
    TRANSACTION_ID INT(4) NOT NULL,
    PAYMENT_METHOD INT(4) NOT NULL,
    PAYMENT_BOOKING_ID INT(4) NOT NULL,
    CONSTRAINT PK_PAYMENT_ID PRIMARY KEY (PAYMENT_ID),
    CONSTRAINT FK_PAYMENT_BOOKING_ID FOREIGN KEY (PAYMENT_BOOKING_ID) REFERENCES BOOKING (BOOKING_ID)
) ENGINE=InnoDB;

ALTER TABLE PAYMENT AUTO_INCREMENT = 1;


CREATE TABLE SEAT_TYPE (
	SEAT_TYPE_ID INT(4) NOT NULL AUTO_INCREMENT,
    SEAT_TYPE_NAME VARCHAR(1) NOT NULL,
    SEAT_TYPE_DESC VARCHAR(50) NOT NULL,
    CONSTRAINT PK_SEAT_TYPE_ID PRIMARY KEY (SEAT_TYPE_ID)
) ENGINE=InnoDB;

ALTER TABLE SEAT_TYPE AUTO_INCREMENT = 1;

CREATE TABLE BOOKING_STATUS (
	BOOKING_STATUS_ID INT(4) NOT NULL AUTO_INCREMENT,
    BOOKING_STATUS_NAME VARCHAR(1) NOT NULL,
    BOOKING_STATUS_DESC VARCHAR(50) NOT NULL,
    CONSTRAINT PK_BOOKING_STATUS_ID PRIMARY KEY (BOOKING_STATUS_ID)
) ENGINE=InnoDB;

ALTER TABLE BOOKING_STATUS AUTO_INCREMENT = 1;

/* Insert */
INSERT INTO `SEAT_TYPE` (`SEAT_TYPE_NAME`,`SEAT_TYPE_DESC`) VALUES ('P','Preminum');
INSERT INTO `SEAT_TYPE` (`SEAT_TYPE_NAME`,`SEAT_TYPE_DESC`) VALUES ('R','Regular');
INSERT INTO `SEAT_TYPE` (`SEAT_TYPE_NAME`,`SEAT_TYPE_DESC`) VALUES ('E','Executive');

INSERT INTO `BOOKING_STATUS` (`BOOKING_STATUS_NAME`,`BOOKING_STATUS_DESC`) VALUES ('F','FAILED');
INSERT INTO `BOOKING_STATUS` (`BOOKING_STATUS_NAME`,`BOOKING_STATUS_DESC`) VALUES ('B','BOOKED');
INSERT INTO `BOOKING_STATUS` (`BOOKING_STATUS_NAME`,`BOOKING_STATUS_DESC`) VALUES ('C','CANCEL');

INSERT INTO `city` (`CITY_NAME`,`CITY_STATE`,`CITY_PIN`) VALUES ('KOLKATA','WEST BENGAL',700150);
INSERT INTO `city` (`CITY_NAME`,`CITY_STATE`,`CITY_PIN`) VALUES ('MUMBAI','MAHARASTRA',400150);
INSERT INTO `city` (`CITY_NAME`,`CITY_STATE`,`CITY_PIN`) VALUES ('DELHI','DELHI',400150);
INSERT INTO `city` (`CITY_NAME`,`CITY_STATE`,`CITY_PIN`) VALUES ('BARUIPUR','WEST BENGAL',700150);
INSERT INTO `city` (`CITY_NAME`,`CITY_STATE`,`CITY_PIN`) VALUES ('SONARPUR','WEST BENGAL',700150);

INSERT INTO `THEATRE` (`THEATRE_NAME`,`THEATRE_SCREENS`,`THEATRE_CITY_ID`) VALUES ('SVF Cinemas',4,1);
INSERT INTO `THEATRE` (`THEATRE_NAME`,`THEATRE_SCREENS`,`THEATRE_CITY_ID`) VALUES ('Big Cinemas',2,1);
INSERT INTO `THEATRE` (`THEATRE_NAME`,`THEATRE_SCREENS`,`THEATRE_CITY_ID`) VALUES ('Huma Cinema',1,2);

INSERT INTO `MOVIE`  (MOVIE_TITLE, MOVIE_DESCRIPTION, DURATION, LANG, RELEASE_DATE, COUNTRY, GENERE) VALUES ("YE KALI KALI ANKHE", "NETFLIX MOVIE", "2.30 HRS", "HINDI", "2022-01-03", "INDIA", "SUSPENSE"); 
INSERT INTO `MOVIE`  (MOVIE_TITLE, MOVIE_DESCRIPTION, DURATION, LANG, RELEASE_DATE, COUNTRY, GENERE) VALUES ("RANG DE BASANTI", "AMRIR KHAN MOVIE", "2.30 HRS", "HINDI", "2016-01-03", "INDIA", "SUSPENSE"); 

INSERT INTO `SCREEN`  (SCREEN_NAME, TOTAL_SEATS, SCREEN_THEATRE_ID) VALUES ("Screen 1", 60, 1); 
INSERT INTO `SCREEN`  (SCREEN_NAME, TOTAL_SEATS, SCREEN_THEATRE_ID) VALUES ("Screen 2", 48, 1); 
INSERT INTO `SCREEN`  (SCREEN_NAME, TOTAL_SEATS, SCREEN_THEATRE_ID) VALUES ("Screen 3", 58, 1); 
INSERT INTO `SCREEN`  (SCREEN_NAME, TOTAL_SEATS, SCREEN_THEATRE_ID) VALUES ("Screen 4", 64, 1); 

INSERT INTO `SCREEN`  (SCREEN_NAME, TOTAL_SEATS, SCREEN_THEATRE_ID) VALUES ("Screen 1", 60, 2); 
INSERT INTO `SCREEN`  (SCREEN_NAME, TOTAL_SEATS, SCREEN_THEATRE_ID) VALUES ("Screen 2", 48, 2); 


INSERT INTO `MOVIE_SHOW`  (MOVIE_SHOW_DATE, MOVIE_SHOW_STARTTIME, MOVIE_SHOW_ENDTIME, MOVIE_SHOW_SCREEN_ID, MOVIE_SHOW_MOVIE_ID) VALUES("2022-02-03", "10AM", "12.30PM", 1, 1);
INSERT INTO `MOVIE_SHOW`  (MOVIE_SHOW_DATE, MOVIE_SHOW_STARTTIME, MOVIE_SHOW_ENDTIME, MOVIE_SHOW_SCREEN_ID, MOVIE_SHOW_MOVIE_ID) VALUES("2022-02-03", "9AM", "12.00PM", 1, 1);
INSERT INTO `MOVIE_SHOW`  (MOVIE_SHOW_DATE, MOVIE_SHOW_STARTTIME, MOVIE_SHOW_ENDTIME, MOVIE_SHOW_SCREEN_ID, MOVIE_SHOW_MOVIE_ID) VALUES("2022-02-03", "11AM", "12.30PM", 2, 2);

INSERT INTO `SCREEN_SEAT`  (SEAT_NUMBER, SEAT_TYPE, PRICE, SCREEN_THEATRE_SEAT_ID) VALUES("A1", "R", "100", 1);
INSERT INTO `SCREEN_SEAT`  (SEAT_NUMBER, SEAT_TYPE, PRICE, SCREEN_THEATRE_SEAT_ID) VALUES("A2", "R", "100", 1);
INSERT INTO `SCREEN_SEAT`  (SEAT_NUMBER, SEAT_TYPE, PRICE, SCREEN_THEATRE_SEAT_ID) VALUES("A3", "R", "100", 1);
INSERT INTO `SCREEN_SEAT`  (SEAT_NUMBER, SEAT_TYPE, PRICE, SCREEN_THEATRE_SEAT_ID) VALUES("A4", "R", "100", 1);
INSERT INTO `SCREEN_SEAT`  (SEAT_NUMBER, SEAT_TYPE, PRICE, SCREEN_THEATRE_SEAT_ID) VALUES("A5", "R", "100", 1);
INSERT INTO `SCREEN_SEAT`  (SEAT_NUMBER, SEAT_TYPE, PRICE, SCREEN_THEATRE_SEAT_ID) VALUES("A6", "R", "100", 1);
INSERT INTO `SCREEN_SEAT`  (SEAT_NUMBER, SEAT_TYPE, PRICE, SCREEN_THEATRE_SEAT_ID) VALUES("A7", "R", "100", 1);
INSERT INTO `SCREEN_SEAT`  (SEAT_NUMBER, SEAT_TYPE, PRICE, SCREEN_THEATRE_SEAT_ID) VALUES("B1", "P", "200", 1);
INSERT INTO `SCREEN_SEAT`  (SEAT_NUMBER, SEAT_TYPE, PRICE, SCREEN_THEATRE_SEAT_ID) VALUES("B2", "P", "200", 1);
INSERT INTO `SCREEN_SEAT`  (SEAT_NUMBER, SEAT_TYPE, PRICE, SCREEN_THEATRE_SEAT_ID) VALUES("B3", "P", "200", 1);
INSERT INTO `SCREEN_SEAT`  (SEAT_NUMBER, SEAT_TYPE, PRICE, SCREEN_THEATRE_SEAT_ID) VALUES("B4", "P", "200", 1);
INSERT INTO `SCREEN_SEAT`  (SEAT_NUMBER, SEAT_TYPE, PRICE, SCREEN_THEATRE_SEAT_ID) VALUES("C1", "E", "300", 1);
INSERT INTO `SCREEN_SEAT`  (SEAT_NUMBER, SEAT_TYPE, PRICE, SCREEN_THEATRE_SEAT_ID) VALUES("C2", "E", "300", 1);

INSERT INTO `SCREEN_SEAT`  (SEAT_NUMBER, SEAT_TYPE, PRICE, SCREEN_THEATRE_SEAT_ID) VALUES("A2", "R", "100", 2);
INSERT INTO `SCREEN_SEAT`  (SEAT_NUMBER, SEAT_TYPE, PRICE, SCREEN_THEATRE_SEAT_ID) VALUES("A2", "R", "100",2);
INSERT INTO `SCREEN_SEAT`  (SEAT_NUMBER, SEAT_TYPE, PRICE, SCREEN_THEATRE_SEAT_ID) VALUES("A3", "R", "100", 2);
INSERT INTO `SCREEN_SEAT`  (SEAT_NUMBER, SEAT_TYPE, PRICE, SCREEN_THEATRE_SEAT_ID) VALUES("A4", "R", "100", 2);
INSERT INTO `SCREEN_SEAT`  (SEAT_NUMBER, SEAT_TYPE, PRICE, SCREEN_THEATRE_SEAT_ID) VALUES("A5", "R", "100", 2);
INSERT INTO `SCREEN_SEAT`  (SEAT_NUMBER, SEAT_TYPE, PRICE, SCREEN_THEATRE_SEAT_ID) VALUES("A6", "R", "100", 2);
INSERT INTO `SCREEN_SEAT`  (SEAT_NUMBER, SEAT_TYPE, PRICE, SCREEN_THEATRE_SEAT_ID) VALUES("A7", "R", "100", 2);
INSERT INTO `SCREEN_SEAT`  (SEAT_NUMBER, SEAT_TYPE, PRICE, SCREEN_THEATRE_SEAT_ID) VALUES("B2", "P", "200", 2);
INSERT INTO `SCREEN_SEAT`  (SEAT_NUMBER, SEAT_TYPE, PRICE, SCREEN_THEATRE_SEAT_ID) VALUES("B2", "P", "200", 2);
INSERT INTO `SCREEN_SEAT`  (SEAT_NUMBER, SEAT_TYPE, PRICE, SCREEN_THEATRE_SEAT_ID) VALUES("B3", "P", "200", 2);
INSERT INTO `SCREEN_SEAT`  (SEAT_NUMBER, SEAT_TYPE, PRICE, SCREEN_THEATRE_SEAT_ID) VALUES("B4", "P", "200", 2);
INSERT INTO `SCREEN_SEAT`  (SEAT_NUMBER, SEAT_TYPE, PRICE, SCREEN_THEATRE_SEAT_ID) VALUES("C2", "E", "300", 2);
INSERT INTO `SCREEN_SEAT`  (SEAT_NUMBER, SEAT_TYPE, PRICE, SCREEN_THEATRE_SEAT_ID) VALUES("C2", "E", "300", 2);

INSERT INTO `BOOKING` (NO_OF_SEATS, TIME_OF_BOOKING, BOOKING_STATUS, BOOKING_MOVIE_SHOW_ID) VALUES(3, "2022-02-01", "B", 1);

INSERT INTO `SHOW_SEAT` (SHOW_SEAT_STATUS, SCREEN_SEAT_ID, MOVIE_SHOW_ID, BOOKING_ID) VALUES("B", 1, 1, 1);
INSERT INTO `SHOW_SEAT` (SHOW_SEAT_STATUS, SCREEN_SEAT_ID, MOVIE_SHOW_ID, BOOKING_ID) VALUES("B", 2, 1, 1);
INSERT INTO `SHOW_SEAT` (SHOW_SEAT_STATUS, SCREEN_SEAT_ID, MOVIE_SHOW_ID, BOOKING_ID) VALUES("B", 3, 1, 1);

