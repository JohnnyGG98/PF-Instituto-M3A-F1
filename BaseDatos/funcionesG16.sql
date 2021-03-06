CREATE 
	OR REPLACE FUNCTION actualiza_ingrPeriodoNotas ( id_ingreso IN NUMERIC, campo IN VARCHAR, id_curso IN NUMERIC, estado BOOLEAN ) RETURNS SETOF RECORD AS $BODY$ DECLARE
BEGIN
	IF
		( campo = 'nota_primer_inteciclo' ) THEN
			UPDATE "IngresoNotas" 
			SET nota_primer_inteciclo = estado 
		WHERE
			id_ingreso_notas = id_ingreso;
		ELSE
		IF
			( campo = 'nota_examen_intecilo' ) THEN
				UPDATE "IngresoNotas" 
				SET nota_examen_intecilo = estado 
			WHERE
				id_ingreso_notas = id_ingreso;
			ELSE
			IF
				( campo = 'nota_segundo_inteciclo' ) THEN
					UPDATE "IngresoNotas" 
					SET nota_segundo_inteciclo = estado 
				WHERE
					id_ingreso_notas = id_ingreso;
				ELSE
				IF
					( campo = 'nota_examen_final' ) THEN
						UPDATE "IngresoNotas" 
						SET nota_examen_final = estado 
					WHERE
						id_ingreso_notas = id_ingreso;
					ELSE
					IF
						( campo = 'nota_examen_de_recuperacion' ) THEN
							UPDATE "IngresoNotas" 
							SET nota_examen_de_recuperacion = estado 
						WHERE
							id_ingreso_notas = id_ingreso;
						
					END IF;
					
				END IF;
				
			END IF;
			
		END IF;
		
	END IF;
	
END;
$BODY$ LANGUAGE plpgsql;


--funcion actualizar vista

CREATE OR REPLACE FUNCTION actualizar_vistas()
RETURNS TRIGGER AS $actualizar_vistas$
BEGIN
 REFRESH MATERIALIZED VIEW "Usuarios_Persona";
 REFRESH MATERIALIZED VIEW "ViewAlumnoCurso";
 REFRESH MATERIALIZED VIEW "ViewCursosPermisosNotas";
 REFRESH MATERIALIZED VIEW "ViewPeriodoIngresoNotas";
 REFRESH MATERIALIZED VIEW "ViewDocentes";
 
 RETURN NEW;
END;
$actualizar_vistas$ LANGUAGE plpgsql;

--funcion eliminar roles


CREATE OR REPLACE FUNCTION roles_elim()
RETURNS TRIGGER AS $roles_elim$
BEGIN
	IF new.rol_estado = FALSE THEN
		INSERT INTO public."HistorialUsuarios"(
		usu_username, historial_fecha, historial_tipo_accion,
		historial_nombre_tabla, historial_pk_tabla,historial_ip )
		VALUES(USER, now(), 'DELETE', TG_TABLE_NAME, old.id_rol,inet_client_addr());
	ELSE 
		INSERT INTO public."HistorialUsuarios"(
		usu_username, historial_fecha, historial_tipo_accion,
		historial_nombre_tabla, historial_pk_tabla,historial_ip )
		VALUES(USER, now(), 'ACTIVACION', TG_TABLE_NAME, old.id_rol,inet_client_addr());
	END IF;
	RETURN NEW;
END;
$roles_elim$ LANGUAGE plpgsql;


--funciones para guardar en la tabla historial

CREATE OR REPLACE FUNCTION actualiza_usuarios()
RETURNS TRIGGER AS $actualiza_usuarios$
BEGIN
	IF new.usu_estado = FALSE THEN
		INSERT INTO public."HistorialUsuarios"(
		usu_username, historial_fecha, historial_tipo_accion,
		historial_nombre_tabla, historial_pk_tabla,historial_ip )
		VALUES(USER, now(), 'DESACTIVACION', TG_TABLE_NAME, old.id_usuario,inet_client_addr());
	ELSE 
		INSERT INTO public."HistorialUsuarios"(
		usu_username, historial_fecha, historial_tipo_accion,
		historial_nombre_tabla, historial_pk_tabla,historial_ip )
		VALUES(USER, now(), 'ACTIVACION', TG_TABLE_NAME, old.id_usuario,inet_client_addr());
	END IF;
	RETURN NEW;
END;
$actualiza_usuarios$ LANGUAGE plpgsql;



CREATE OR REPLACE FUNCTION actualiza_alumnocurso()
RETURNS TRIGGER AS $actualiza_alumnocurso$
BEGIN
	IF new.almn_curso_activo = FALSE THEN
		INSERT INTO public."HistorialUsuarios"(
		usu_username, historial_fecha, historial_tipo_accion,
		historial_nombre_tabla, historial_pk_tabla,historial_ip )
		VALUES(USER, now(), 'DESACTIVACION', TG_TABLE_NAME, old.id_almn_curso,inet_client_addr());
	ELSE 
		INSERT INTO public."HistorialUsuarios"(
		usu_username, historial_fecha, historial_tipo_accion,
		historial_nombre_tabla, historial_pk_tabla,historial_ip )
		VALUES(USER, now(), 'ACTIVACION', TG_TABLE_NAME, old.id_almn_curso,inet_client_addr());
	END IF;
	RETURN NEW;
END;
$actualiza_alumnocurso$ LANGUAGE plpgsql;

CREATE OR REPLACE FUNCTION actualiza_ingresonotas()
RETURNS TRIGGER AS $actualiza_ingresonotas$
BEGIN
	IF new.nota_primer_inteciclo = FALSE THEN
		INSERT INTO public."HistorialUsuarios"(
		usu_username, historial_fecha, historial_tipo_accion,
		historial_nombre_tabla, historial_pk_tabla,historial_ip )
		VALUES(USER, now(), 'DESACTIVACION', TG_TABLE_NAME, old.id_ingreso_notas,inet_client_addr());
	ELSE 
		INSERT INTO public."HistorialUsuarios"(
		usu_username, historial_fecha, historial_tipo_accion,
		historial_nombre_tabla, historial_pk_tabla,historial_ip )
		VALUES(USER, now(), 'ACTIVACION', TG_TABLE_NAME, old.id_ingreso_notas,inet_client_addr());
	END IF;
	
	IF new.nota_examen_intecilo = FALSE THEN
		INSERT INTO public."HistorialUsuarios"(
		usu_username, historial_fecha, historial_tipo_accion,
		historial_nombre_tabla, historial_pk_tabla,historial_ip )
		VALUES(USER, now(), 'DESACTIVACION', TG_TABLE_NAME, old.id_ingreso_notas,inet_client_addr());
	ELSE 
		INSERT INTO public."HistorialUsuarios"(
		usu_username, historial_fecha, historial_tipo_accion,
		historial_nombre_tabla, historial_pk_tabla,historial_ip )
		VALUES(USER, now(), 'ACTIVACION', TG_TABLE_NAME, old.id_ingreso_notas,inet_client_addr());
	END IF;
	
	IF new.nota_segundo_inteciclo = FALSE THEN
		INSERT INTO public."HistorialUsuarios"(
		usu_username, historial_fecha, historial_tipo_accion,
		historial_nombre_tabla, historial_pk_tabla,historial_ip )
		VALUES(USER, now(), 'DESACTIVACION', TG_TABLE_NAME, old.id_ingreso_notas,inet_client_addr());
	ELSE 
		INSERT INTO public."HistorialUsuarios"(
		usu_username, historial_fecha, historial_tipo_accion,
		historial_nombre_tabla, historial_pk_tabla,historial_ip )
		VALUES(USER, now(), 'ACTIVACION', TG_TABLE_NAME, old.id_ingreso_notas,inet_client_addr());
	END IF;
	
	IF new.nota_examen_final = FALSE THEN
		INSERT INTO public."HistorialUsuarios"(
		usu_username, historial_fecha, historial_tipo_accion,
		historial_nombre_tabla, historial_pk_tabla,historial_ip )
		VALUES(USER, now(), 'DESACTIVACION', TG_TABLE_NAME, old.id_ingreso_notas,inet_client_addr());
	ELSE 
		INSERT INTO public."HistorialUsuarios"(
		usu_username, historial_fecha, historial_tipo_accion,
		historial_nombre_tabla, historial_pk_tabla,historial_ip )
		VALUES(USER, now(), 'ACTIVACION', TG_TABLE_NAME, old.id_ingreso_notas,inet_client_addr());
	END IF;
	
	IF new.nota_examen_de_recuperacion = FALSE THEN
		INSERT INTO public."HistorialUsuarios"(
		usu_username, historial_fecha, historial_tipo_accion,
		historial_nombre_tabla, historial_pk_tabla,historial_ip )
		VALUES(USER, now(), 'DESACTIVACION', TG_TABLE_NAME, old.id_ingreso_notas,inet_client_addr());
	ELSE 
		INSERT INTO public."HistorialUsuarios"(
		usu_username, historial_fecha, historial_tipo_accion,
		historial_nombre_tabla, historial_pk_tabla,historial_ip )
		VALUES(USER, now(), 'ACTIVACION', TG_TABLE_NAME, old.id_ingreso_notas,inet_client_addr());
	END IF;
	
	RETURN NEW;
END;
$actualiza_ingresonotas$ LANGUAGE plpgsql;

CREATE OR REPLACE FUNCTION actualiza_periodoingresonotas()
RETURNS TRIGGER AS $actualiza_periodoingresonotas$
BEGIN
	IF new.perd_notas_estado = FALSE THEN
		INSERT INTO public."HistorialUsuarios"(
		usu_username, historial_fecha, historial_tipo_accion,
		historial_nombre_tabla, historial_pk_tabla,historial_ip )
		VALUES(USER, now(), 'DESACTIVACION', TG_TABLE_NAME, old.id_perd_ingr_notas,inet_client_addr());
	ELSE 
		INSERT INTO public."HistorialUsuarios"(
		usu_username, historial_fecha, historial_tipo_accion,
		historial_nombre_tabla, historial_pk_tabla,historial_ip )
		VALUES(USER, now(), 'ACTIVACION', TG_TABLE_NAME, old.id_perd_ingr_notas,inet_client_addr());
	END IF;
	RETURN NEW;
END;
$actualiza_periodoingresonotas$ LANGUAGE plpgsql;

CREATE OR REPLACE FUNCTION actualiza_tipodenota()
RETURNS TRIGGER AS $actualiza_tipodenota$
BEGIN
	IF new.tipo_nota_estado = FALSE THEN
		INSERT INTO public."HistorialUsuarios"(
		usu_username, historial_fecha, historial_tipo_accion,
		historial_nombre_tabla, historial_pk_tabla,historial_ip )
		VALUES(USER, now(), 'DESACTIVACION', TG_TABLE_NAME, old.id_tipo_nota,inet_client_addr());
	ELSE 
		INSERT INTO public."HistorialUsuarios"(
		usu_username, historial_fecha, historial_tipo_accion,
		historial_nombre_tabla, historial_pk_tabla,historial_ip )
		VALUES(USER, now(), 'ACTIVACION', TG_TABLE_NAME, old.id_tipo_nota,inet_client_addr());
	END IF;
	RETURN NEW;
END;
$actualiza_tipodenota$ LANGUAGE plpgsql;




AQUI TIO DIEGO JAJAJAJA :v
------------------------------------------------------------------------

CREATE TRIGGER ActualizaEstado
AFTER UPDATE OF almn_curso_estado
ON public."AlumnoCurso" FOR EACH ROW
EXECUTE PROCEDURE Actualiza_estado_alumno();

CREATE OR REPLACE FUNCTION Actualiza_estado_alumno()
RETURN TRIGGER AS $Actualiza_estado_alumno$

DECLARE 
modalidad VARCHAR := '';
nombre_curso VARCHAR := '';

reg RECORD;

SELECT
	"public"."Carreras".carrera_modalidad,
	"public"."Cursos".curso_nombre
	 INTO modalidad, nombre_curso 
FROM
	"public"."Cursos"
	INNER JOIN "public"."PeriodoLectivo" ON "public"."Cursos".id_prd_lectivo = "public"."PeriodoLectivo".id_prd_lectivo
	INNER JOIN "public"."Carreras" ON "public"."PeriodoLectivo".id_carrera = "public"."Carreras".id_carrera 
WHERE
	"public"."Cursos".id_curso = NEW.id_curso;
BEGIN
	IF
		modalidad = 'DUAL' THEN
		IF
			NEW.almn_curso_estado = 'RETIRADO' 
			OR NEW.almn_curso_estado = 'REPROBADO' THEN
				registros_almn_materias_nucleo CURSOR FOR SELECT
				"public"."Materias".materia_nucleo,
				"public"."AlumnoCurso".id_almn_curso,
				"public"."Cursos".id_curso 
			FROM
				"public"."AlumnoCurso"
				INNER JOIN "public"."Cursos" ON "public"."AlumnoCurso".id_curso = "public"."Cursos".id_curso
				INNER JOIN "public"."Materias" ON "public"."Cursos".id_materia = "public"."Materias".id_materia 
			WHERE
				"public"."AlumnoCurso".id_alumno = NEW.id_alumno 
				AND "public"."Cursos".curso_nombre = nombre_curso 
				AND "Materias".materia_nucleo IS TRUE;

			OPEN registros_almn_materias_nucleo;

			FETCH registros_almn_materias_nucleo INTO reg;

			WHILE (FOUND) LOOP
				UPDATE public."AlumnoCurso"
					
				SET;
			END LOOP;
		END IF;
		
	END IF;
END;
