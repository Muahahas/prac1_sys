CREATE SCHEMA log;

CREATE TABLE log."tipusIncidencia"
(
  "codiTipusIncidencia" integer NOT NULL,
  descripcio character varying(250),
  CONSTRAINT "pk_tipusIncidencia" PRIMARY KEY ("codiTipusIncidencia")
);

CREATE TABLE log.incidencia
(
  "idIncidencia" bigint NOT NULL,
  data date,
  "dataHora" timestamp without time zone,
  "codiTipusIncidencia" integer,
  CONSTRAINT "pk_Incidencia" PRIMARY KEY ("idIncidencia"),
  CONSTRAINT "fk_Incidencia_TipusIncidencia" FOREIGN KEY ("codiTipusIncidencia")
      REFERENCES log."tipusIncidencia" ("codiTipusIncidencia") MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);