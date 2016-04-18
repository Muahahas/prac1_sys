CREATE SCHEMA eAccessible;

CREATE TABLE eAccessible.tipoLocal
(
	codiTipoLocal bigint NOT NULL,
	nomTipoLocalCA character varying(100) NULL,
	nomTipoLocalES character varying(100) NULL,
	nomTipoLocalEN character varying(100) NULL,
	CONSTRAINT PK_tipoLocal PRIMARY KEY (codiTipoLocal)
 );
 
 
CREATE TABLE eAccessible.nivell(
	codiNivell bigint NOT NULL,
	nomNivellCA character varying(100) NULL,
	nomNivellES character varying(100) NULL,
	nomNivellEN character varying(100) NULL,
 CONSTRAINT PK_nivell PRIMARY KEY (codiNivell) );
 
CREATE TABLE eAccessible.local(
	codiLocal bigint NOT NULL,
	codiTipoLocal bigint NULL,
	codiCarrer bigint NULL,
	nomCarrer character varying(50) NULL,
	nomVia character varying(2) NULL,
	numero bigint NULL,
	nomLocal character varying(250) NULL,
	observacions character varying(300) NULL,
	verificat char(1) NULL,
 CONSTRAINT PK_local PRIMARY KEY (codiLocal) );

CREATE TABLE eAccessible.caracteristica(
	codiCaracteristica bigint NOT NULL,
	nomCaracteristicaCA character varying(250) NULL,
	nomCaracteristicaES character varying(250) NULL,
	nomCaracteristicaEN character varying(250) NULL,
	tipo int NULL,
	codiNivell bigint NULL,
 CONSTRAINT PK_caracteristica PRIMARY KEY (codiCaracteristica) );

CREATE TABLE eAccessible.accessibilitat(
	codiAccessibilitat bigint NOT NULL,
	codiLocal bigint NULL,
	codiCaracteristica bigint NULL,
	valor bigint NULL,
	verificat char(1) NULL,
 CONSTRAINT PK_accessibilitat PRIMARY KEY (codiAccessibilitat)
);

CREATE TABLE eAccessible.caracteristicaTipoLocal(
	codiCaracteristicaTipoLocal bigint NOT NULL,
	codiCaracteristica bigint NULL,
	codiTipoLocal bigint NULL,
 CONSTRAINT PK_caracteristicaTipoLocal PRIMARY KEY (codiCaracteristicaTipoLocal)
);


ALTER TABLE eAccessible.accessibilitat   ADD  CONSTRAINT FK_accessibilitat_caracteristica FOREIGN KEY(codiCaracteristica)
REFERENCES eAccessible.caracteristica (codiCaracteristica);


ALTER TABLE eAccessible.accessibilitat  ADD  CONSTRAINT FK_accessibilitat_local FOREIGN KEY(codiLocal)
REFERENCES eAccessible.local (codiLocal);


ALTER TABLE eAccessible.caracteristica   ADD  CONSTRAINT FK_caracteristica_nivell FOREIGN KEY(codiNivell)
REFERENCES eAccessible.nivell (codiNivell);


ALTER TABLE eAccessible.caracteristicaTipoLocal   ADD  CONSTRAINT FK_caracteristicaTipoLocal_caracteristica FOREIGN KEY(codiCaracteristica)
REFERENCES eAccessible.caracteristica (codiCaracteristica);


ALTER TABLE eAccessible.caracteristicaTipoLocal  ADD  CONSTRAINT FK_caracteristicaTipoLocal_tipoLocal FOREIGN KEY(codiTipoLocal)
REFERENCES eAccessible.tipoLocal (codiTipoLocal);


ALTER TABLE eAccessible.local   ADD  CONSTRAINT FK_local_tipoLocal FOREIGN KEY(codiTipoLocal)
REFERENCES eAccessible.tipoLocal (codiTipoLocal);