-- Tablas en alumnos

CREATE SCHEMA alumno;

CREATE TABLE alumno."Egresados" (
  id_egresado SERIAL NOT NULL,
  id_almn_carrera INTEGER NOT NULL,
  id_prd_lectivo INTEGER NOT NULL,
  fecha_egreso DATE NOT NULL DEFAULT now(),
  graduado BOOLEAN NOT NULL DEFAULT 'false',
  fecha_graduacion DATE,
  egresado_activo BOOLEAN NOT NULL DEFAULT 'true'
) WITH (OIDS = FALSE);

CREATE TABLE alumno."Retirados" (
  id_retiro SERIAL NOT NULL,
  id_almn_carrera INTEGER NOT NULL UNIQUE,
  id_prd_lectivo INTEGER NOT NULL,
  fecha_retiro DATE NOT NULL DEFAULT now(),
  motivo_retiro TEXT NOT NULL DEFAULT '',
  retiro_activo BOOLEAN NOT NULL DEFAULT 'true'
) WITH (OIDS = FALSE);


-- Agregamos a malla dos nuevos estados
-- Retirados X

ALTER TABLE alumno."Egresados" ADD COLUMN trabajo_titulacion BOOLEAN DEFAULT 'false';
