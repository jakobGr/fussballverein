CREATE SEQUENCE seq_incr_two INCREMENT BY 2 START WITH 10000;
CREATE SEQUENCE seq_auto_incr INCREMENT BY 1 START WITH 1;


CREATE TABLE Person (
 persnr INT NOT NULL DEFAULT nextval('seq_incr_two'),
 vname VARCHAR(255) NOT NULL,
 nname VARCHAR(255) NOT NULL,
 geschlecht CHAR(1) NOT NULL,
 gebdat DATE NOT NULL
);

ALTER TABLE Person ADD CONSTRAINT PK_Person PRIMARY KEY (persnr);


CREATE TABLE Spieler (
 persnr INT NOT NULL,
 position VARCHAR(255) NOT NULL,
 gehalt FLOAT(10) NOT NULL,
 von DATE NOT NULL,
 bis DATE NOT NULL
);

ALTER TABLE Spieler ADD CONSTRAINT PK_Spieler PRIMARY KEY (persnr);


CREATE TABLE Standort (
 sid INT NOT NULL DEFAULT nextval('seq_auto_incr'),
 land VARCHAR(255) NOT NULL,
 plz INT NOT NULL,
 ort VARCHAR(255) NOT NULL
);

ALTER TABLE Standort ADD CONSTRAINT PK_Standort PRIMARY KEY (sid);


CREATE TABLE Trainer (
 persnr INT NOT NULL,
 gehalt FLOAT(10) NOT NULL,
 von DATE NOT NULL,
 bis DATE NOT NULL
);

ALTER TABLE Trainer ADD CONSTRAINT PK_Trainer PRIMARY KEY (persnr);


CREATE TABLE Angestellter (
 persnr INT NOT NULL,
 gehalt FLOAT(10) NOT NULL,
 ueberstunden INT NOT NULL,
 e_mail VARCHAR(255) NOT NULL
);

ALTER TABLE Angestellter ADD CONSTRAINT PK_Angestellter PRIMARY KEY (persnr);


CREATE TABLE Mannschaft (
 bezeichnung VARCHAR(255) NOT NULL,
 klasse VARCHAR(255) NOT NULL,
 naechstes_spiel DATE NOT NULL,
 chef_trainer INT NOT NULL,
 ast_trainer INT NOT NULL,
 kapitaen INT NOT NULL
);

ALTER TABLE Mannschaft ADD CONSTRAINT PK_Mannschaft PRIMARY KEY (bezeichnung);


CREATE TABLE Mitglied (
 persnr INT NOT NULL,
 beitrag FLOAT(10) NOT NULL
);

ALTER TABLE Mitglied ADD CONSTRAINT PK_Mitglied PRIMARY KEY (persnr);


CREATE TABLE Spiel (
 datum DATE NOT NULL,
 mannschaft VARCHAR(255) NOT NULL,
 ergebnis VARCHAR(14),
 gegner VARCHAR(255) NOT NULL
);

ALTER TABLE Spiel ADD CONSTRAINT PK_Spiel PRIMARY KEY (datum,mannschaft);
ALTER TABLE Spiel ADD CONSTRAINT U_Spiel UNIQUE (gegner);


CREATE TABLE Spieler_Mannschaft (
 spielernummer INT NOT NULL,
 mannschaft VARCHAR(255) NOT NULL,
 nummer CHAR(10)
);

ALTER TABLE Spieler_Mannschaft ADD CONSTRAINT PK_Spieler_Mannschaft PRIMARY KEY (spielernummer,mannschaft);


CREATE TABLE Spieler_Spiel (
 spielernummer INT NOT NULL,
 datum DATE NOT NULL,
 mannschaft VARCHAR(255) NOT NULL
);

ALTER TABLE Spieler_Spiel ADD CONSTRAINT PK_Spieler_Spiel PRIMARY KEY (spielernummer,datum,mannschaft);


CREATE TABLE FanClub (
 name VARCHAR(255) NOT NULL,
 sid INT NOT NULL,
 gegruendet DATE NOT NULL,
 obmann INT NOT NULL
);

ALTER TABLE FanClub ADD CONSTRAINT PK_FanClub PRIMARY KEY (name,sid);


CREATE TABLE Angestellter_FanClub (
 persnr INT NOT NULL,
 name VARCHAR(255) NOT NULL,
 sid INT NOT NULL,
 anfang DATE,
 ende DATE
);

ALTER TABLE Angestellter_FanClub ADD CONSTRAINT PK_Angestellter_FanClub PRIMARY KEY (persnr,name,sid);


ALTER TABLE Spieler ADD CONSTRAINT FK_Spieler_0 FOREIGN KEY (persnr) REFERENCES Person (persnr);


ALTER TABLE Trainer ADD CONSTRAINT FK_Trainer_0 FOREIGN KEY (persnr) REFERENCES Person (persnr);


ALTER TABLE Angestellter ADD CONSTRAINT FK_Angestellter_0 FOREIGN KEY (persnr) REFERENCES Person (persnr);


ALTER TABLE Mannschaft ADD CONSTRAINT FK_Mannschaft_0 FOREIGN KEY (chef_trainer) REFERENCES Trainer (persnr);
ALTER TABLE Mannschaft ADD CONSTRAINT FK_Mannschaft_1 FOREIGN KEY (ast_trainer) REFERENCES Trainer (persnr);
ALTER TABLE Mannschaft ADD CONSTRAINT FK_Mannschaft_2 FOREIGN KEY (kapitaen) REFERENCES Spieler (persnr);


ALTER TABLE Mitglied ADD CONSTRAINT FK_Mitglied_0 FOREIGN KEY (persnr) REFERENCES Person (persnr);


ALTER TABLE Spiel ADD CONSTRAINT FK_Spiel_0 FOREIGN KEY (mannschaft) REFERENCES Mannschaft (bezeichnung);
ALTER TABLE Spiel ADD CONSTRAINT FK_Spiel_1 FOREIGN KEY (gegner) REFERENCES Mannschaft (bezeichnung);


ALTER TABLE Spieler_Mannschaft ADD CONSTRAINT FK_Spieler_Mannschaft_0 FOREIGN KEY (spielernummer) REFERENCES Spieler (persnr);
ALTER TABLE Spieler_Mannschaft ADD CONSTRAINT FK_Spieler_Mannschaft_1 FOREIGN KEY (mannschaft) REFERENCES Mannschaft (bezeichnung);


ALTER TABLE Spieler_Spiel ADD CONSTRAINT FK_Spieler_Spiel_0 FOREIGN KEY (spielernummer) REFERENCES Spieler (persnr);
ALTER TABLE Spieler_Spiel ADD CONSTRAINT FK_Spieler_Spiel_1 FOREIGN KEY (datum,mannschaft) REFERENCES Spiel (datum,mannschaft);


ALTER TABLE FanClub ADD CONSTRAINT FK_FanClub_0 FOREIGN KEY (sid) REFERENCES Standort (sid);
ALTER TABLE FanClub ADD CONSTRAINT FK_FanClub_1 FOREIGN KEY (obmann) REFERENCES Mitglied (persnr);


ALTER TABLE Angestellter_FanClub ADD CONSTRAINT FK_Angestellter_FanClub_0 FOREIGN KEY (persnr) REFERENCES Angestellter (persnr);
ALTER TABLE Angestellter_FanClub ADD CONSTRAINT FK_Angestellter_FanClub_1 FOREIGN KEY (name,sid) REFERENCES FanClub (name,sid);


