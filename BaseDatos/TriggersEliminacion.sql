--No se realizaron triggers de 
--	UnidadSilabo
--	EvaluacionSilabo
--	TipoActividad
-- 	RolesDelUsuario
--	Roles
--	AccesosDelRol
-- 	Accesos

--Materias 
--Cuando se edita el valor de activo se guarda en historial como eliminado. 
CREATE OR REPLACE FUNCTION materia_elim()
RETURNS TRIGGER AS $materia_elim$
BEGIN
	IF new.materia_activa = FALSE THEN 
		INSERT INTO public."HistorialUsuarios"(
		usu_username, historial_fecha, historial_tipo_accion,
		historial_nombre_tabla, historial_pk_tabla)
		VALUES(USER, now(), 'DELETE', TG_TABLE_NAME, old.id_materia);
	END IF; 
	RETURN NEW;
END;
$materia_elim$ LANGUAGE plpgsql;

CREATE TRIGGER auditoria_materia_elim
BEFORE UPDATE OF materia_activa
ON public."Materias" FOR EACH ROW
EXECUTE PROCEDURE materia_elim();

--Cursos 
--Si se elimina cursos se guardan los datos en observacion
CREATE OR REPLACE FUNCTION curso_elim()
RETURNS TRIGGER AS $curso_elim$
BEGIN
	INSERT INTO public."HistorialUsuarios"(
		usu_username, historial_fecha, historial_tipo_accion,
		historial_nombre_tabla, historial_pk_tabla, historial_observacion)
		VALUES(USER, now(), 'DELETE', TG_TABLE_NAME, old.id_curso, 
			old.id_materia || '%' || old.id_prd_lectivo || '%' || 
			old.id_docente || '%' || old.id_jornada || '%' || 
			old.curso_nombre || '%' || old.curso_capacidad || '%' || 
			old._curso_permiso_ingreso_nt);
		RETURN NEW;
END;
$curso_elim$ LANGUAGE plpgsql;

CREATE TRIGGER auditoria_curso_elim
BEFORE DELETE 
ON public."Cursos" FOR EACH ROW
EXECUTE PROCEDURE curso_elim();

--Docentes 
--Si se elimina un docente se deben eliminar muchas otras cosas mas 
CREATE OR REPLACE FUNCTION docente_elim()
RETURNS TRIGGER AS $docente_elim$
BEGIN
	IF new.docente_activo = FALSE THEN 
		INSERT INTO public."HistorialUsuarios"(
		usu_username, historial_fecha, historial_tipo_accion,
		historial_nombre_tabla, historial_pk_tabla)
		VALUES(USER, now(), 'DELETE', TG_TABLE_NAME, old.id_docente);
	END IF; 
		RETURN NEW;
END;
$docente_elim$ LANGUAGE plpgsql;

CREATE TRIGGER auditoria_docente_elim
BEFORE UPDATE OF docente_activo
ON public."Docentes" FOR EACH ROW
EXECUTE PROCEDURE docente_elim();

--Jornada docente 
--Si se elimina se guardara en la base de datos en observacion 
CREATE OR REPLACE FUNCTION jornada_docente_elim()
RETURNS TRIGGER AS $jornada_docente_elim$
BEGIN
	INSERT INTO public."HistorialUsuarios"(
		usu_username, historial_fecha, historial_tipo_accion,
		historial_nombre_tabla, historial_pk_tabla, historial_observacion)
		VALUES(USER, now(), 'DELETE', TG_TABLE_NAME, old.id_jornada_docente, 
			old.id_jornada || '%' || old.id_docente || '%' || old.id_prd_lectivo);
		RETURN NEW;
END;
$jornada_docente_elim$ LANGUAGE plpgsql;

CREATE TRIGGER auditoria_jornada_docente_elim
BEFORE DELETE 
ON public."JornadaDocente" FOR EACH ROW
EXECUTE PROCEDURE jornada_docente_elim();

--MateriaRequisitos
--Si se elimina una materia requsito se guardara 
--En historial observaciones
CREATE OR REPLACE FUNCTION materia_requisito_elim()
RETURNS TRIGGER AS $materia_requisito_elim$
BEGIN
	INSERT INTO public."HistorialUsuarios"(
		usu_username, historial_fecha, historial_tipo_accion,
		historial_nombre_tabla, historial_pk_tabla, historial_observacion)
		VALUES(USER, now(), 'DELETE', TG_TABLE_NAME, old.id_requisito, 
			old.id_materia || '%' || old.id_materia_requisito || '%' || 
			old.tipo_requisito);
		RETURN NEW;
END;
$materia_requisito_elim$ LANGUAGE plpgsql;

CREATE TRIGGER auditoria_mt_requisito_elim
BEFORE DELETE 
ON public."MateriaRequisitos" FOR EACH ROW
EXECUTE PROCEDURE materia_requisito_elim();

--SesionClase
--Si se elimina una sesion de clase se  guardara en observaciones
CREATE OR REPLACE FUNCTION sesion_clase_elim()
RETURNS TRIGGER AS $sesion_clase_elim$
BEGIN
	INSERT INTO public."HistorialUsuarios"(
		usu_username, historial_fecha, historial_tipo_accion,
		historial_nombre_tabla, historial_pk_tabla, historial_observacion)
		VALUES(USER, now(), 'DELETE', TG_TABLE_NAME, old.id_sesion, 
			old.id_curso || '%' || old.dia_sesion || '%' || 
			old.hora_inicio_sesion || '%' || old.hora_fin_sesion);
		RETURN NEW;
END;
$sesion_clase_elim$ LANGUAGE plpgsql;

CREATE TRIGGER auditoria_sesion_clase_elim
BEFORE DELETE 
ON public."SesionClase" FOR EACH ROW
EXECUTE PROCEDURE sesion_clase_elim();

--DetalleJornada 
--Cuando se elimine una jornada se le guardara en el campo observacion
CREATE OR REPLACE FUNCTION detalle_jrd_elim()
RETURNS TRIGGER AS $detalle_jrd_elim$
BEGIN
	INSERT INTO public."HistorialUsuarios"(
		usu_username, historial_fecha, historial_tipo_accion,
		historial_nombre_tabla, historial_pk_tabla, historial_observacion)
		VALUES(USER, now(), 'DELETE', TG_TABLE_NAME, old.id_detalle_jornada, 
			old.id_jornada || '%' || old.hora_inicio_jornada || '%' || 
			old.hora_fin_jornada || '%' || old.dia_inicio_jornada|| '%' || 
			old.dia_fin_jornada);
		RETURN NEW;
END;
$detalle_jrd_elim$ LANGUAGE plpgsql;

CREATE TRIGGER auditoria_detalle_jornada_elim
BEFORE DELETE 
ON public."DetalleJornada" FOR EACH ROW
EXECUTE PROCEDURE detalle_jrd_elim();

--DocentesMateria
CREATE OR REPLACE FUNCTION docentes_materia_elim()
RETURNS TRIGGER AS $docentes_materia_elim$
BEGIN
	IF new.docente_mat_activo = FALSE THEN
		INSERT INTO public."HistorialUsuarios"(
		usu_username, historial_fecha, historial_tipo_accion,
		historial_nombre_tabla, historial_pk_tabla)
		VALUES(USER, now(), 'DELETE', TG_TABLE_NAME, old.id_docente_mat);
	END IF; 	
	RETURN NEW;
END;
$docentes_materia_elim$ LANGUAGE plpgsql;

CREATE TRIGGER auditoria_docentes_mt_elim
BEFORE UPDATE OF docente_mat_activo
ON public."DocentesMateria" FOR EACH ROW
EXECUTE PROCEDURE docentes_materia_elim();

--Silabo 
CREATE OR REPLACE FUNCTION silabo_elim()
RETURNS TRIGGER AS $silabo_elim$
BEGIN
	INSERT INTO public."HistorialUsuarios"(
		usu_username, historial_fecha, historial_tipo_accion,
		historial_nombre_tabla, historial_pk_tabla, historial_observacion)
		VALUES(USER, now(), 'DELETE', TG_TABLE_NAME, old.id_silabo, 
			old.id_materia);
		RETURN NEW;
END;
$silabo_elim$ LANGUAGE plpgsql;

CREATE TRIGGER auditoria_silabo_elim
BEFORE DELETE 
ON public."Silabo" FOR EACH ROW
EXECUTE PROCEDURE silabo_elim();

--ReferenciaSilabo
CREATE OR REPLACE FUNCTION referencia_silabo_elim()
RETURNS TRIGGER AS $referencia_silabo_elim$
BEGIN
	INSERT INTO public."HistorialUsuarios"(
		usu_username, historial_fecha, historial_tipo_accion,
		historial_nombre_tabla, historial_pk_tabla, historial_observacion)
		VALUES(USER, now(), 'DELETE', TG_TABLE_NAME, old.id_referencia_silabo, 
			old.id_referencia || '%' || old.id_referencia);
		RETURN NEW;
END;
$referencia_silabo_elim$ LANGUAGE plpgsql;

CREATE TRIGGER auditoria_referencia_silabo_elim
BEFORE DELETE 
ON public."ReferenciaSilabo" FOR EACH ROW
EXECUTE PROCEDURE referencia_silabo_elim();

--Carreras 
CREATE OR REPLACE FUNCTION carrera_elim()
RETURNS TRIGGER AS $carrera_elim$
BEGIN
	IF new.carrera_activo = FALSE THEN
		INSERT INTO public."HistorialUsuarios"(
		usu_username, historial_fecha, historial_tipo_accion,
		historial_nombre_tabla, historial_pk_tabla)
		VALUES(USER, now(), 'DELETE', TG_TABLE_NAME, old.id_carrera);
	END IF; 	
	RETURN NEW;
END;
$carrera_elim$ LANGUAGE plpgsql;

CREATE TRIGGER auditoria_carrera_elim
BEFORE UPDATE OF carrera_activo
ON public."Carreras" FOR EACH ROW
EXECUTE PROCEDURE carrera_elim();

--PeriodoLectivo
CREATE OR REPLACE FUNCTION prd_lectivo_elim()
RETURNS TRIGGER AS $prd_lectivo_elim$
BEGIN
	IF new.prd_lectivo_activo = FALSE THEN
		INSERT INTO public."HistorialUsuarios"(
		usu_username, historial_fecha, historial_tipo_accion,
		historial_nombre_tabla, historial_pk_tabla)
		VALUES(USER, now(), 'DELETE', TG_TABLE_NAME, old.id_prd_lectivo);
	END IF; 	
	RETURN NEW;
END;
$prd_lectivo_elim$ LANGUAGE plpgsql;

CREATE TRIGGER auditoria_prd_lectivo_elim
BEFORE UPDATE OF prd_lectivo_activo
ON public."PeriodoLectivo" FOR EACH ROW
EXECUTE PROCEDURE prd_lectivo_elim();

--PeriodoIngresoNotas
CREATE OR REPLACE FUNCTION prd_ingreso_nt_elim()
RETURNS TRIGGER AS $prd_ingreso_nt_elim$
BEGIN
	INSERT INTO public."HistorialUsuarios"(
		usu_username, historial_fecha, historial_tipo_accion,
		historial_nombre_tabla, historial_pk_tabla, historial_observacion)
		VALUES(USER, now(), 'DELETE', TG_TABLE_NAME, old.id_prd_ingr_notas, 
			old.perd_notas_fecha_inicio || '%' || old.perd_notas_fecha_cierre
			|| '%' || old.perd_notas_estado || '%' || old.id_prd_lectivo 
			|| '%' || old.id_tipo_nota);
		RETURN NEW;
END;
$prd_ingreso_nt_elim$ LANGUAGE plpgsql;

CREATE TRIGGER auditoria_prd_ingreso_nt_elim
BEFORE DELETE 
ON public."PeriodoIngresoNotas" FOR EACH ROW
EXECUTE PROCEDURE prd_ingreso_nt_elim();

--TipoDeNota
CREATE OR REPLACE FUNCTION tipo_nota_elim()
RETURNS TRIGGER AS $tipo_nota_elim$
BEGIN
	IF new.tipo_nota_estado = FALSE THEN
		INSERT INTO public."HistorialUsuarios"(
		usu_username, historial_fecha, historial_tipo_accion,
		historial_nombre_tabla, historial_pk_tabla)
		VALUES(USER, now(), 'DELETE', TG_TABLE_NAME, old.id_tipo_nota);
	END IF; 	
	RETURN NEW;
END;
$tipo_nota_elim$ LANGUAGE plpgsql;

CREATE TRIGGER auditoria_tipo_nota_elim
BEFORE UPDATE OF tipo_nota_estado
ON public."TipoDeNota" FOR EACH ROW
EXECUTE PROCEDURE tipo_nota_elim();

--EjesFormacion
CREATE OR REPLACE FUNCTION eje_formacion_elim()
RETURNS TRIGGER AS $eje_formacion_elim$
BEGIN
	INSERT INTO public."HistorialUsuarios"(
		usu_username, historial_fecha, historial_tipo_accion,
		historial_nombre_tabla, historial_pk_tabla, historial_observacion)
		VALUES(USER, now(), 'DELETE', TG_TABLE_NAME, old.id_eje, 
			old.id_carrera || '%' || old.eje_codigo
			|| '%' || old.eje_nombre);
		RETURN NEW;
END;
$eje_formacion_elim$ LANGUAGE plpgsql;

CREATE TRIGGER auditoria_eje_formacion_elim
BEFORE DELETE 
ON public."EjesFormacion" FOR EACH ROW
EXECUTE PROCEDURE eje_formacion_elim();

--Personas
--Si se elimina una persona se eliminan docente o estudiante con ellos 
--Unicamente el campo de activo 
CREATE OR REPLACE FUNCTION persona_elim()
RETURNS TRIGGER AS $persona_elim$
BEGIN
	IF new.persona_activa = FALSE THEN
		INSERT INTO public."HistorialUsuarios"(
		usu_username, historial_fecha, historial_tipo_accion,
		historial_nombre_tabla, historial_pk_tabla)
		VALUES(USER, now(), 'DELETE', TG_TABLE_NAME, old.id_persona);
		--Eliminalos el docente o alumno que este registrado como esta persona  
		UPDATE public."Docentes"
		SET docente_activo = 'False'
		WHERE id_persona = old.id_persona;

		UPDATE public."Alumnos"
		SET alumno_activo = 'False'
		WHERE id_persona = old.id_persona;
		
		UPDATE public."Usuarios"
		SET usu_estado = 'False'
		WHERE id_persona = old.id_persona;
	END IF; 	
	RETURN NEW;
END;
$persona_elim$ LANGUAGE plpgsql;

CREATE TRIGGER auditoria_persona_elim
BEFORE UPDATE OF persona_activa
ON public."Personas" FOR EACH ROW
EXECUTE PROCEDURE persona_elim();

--Alumnos
CREATE OR REPLACE FUNCTION alumno_elim()
RETURNS TRIGGER AS $alumno_elim$
BEGIN
	IF new.alumno_activo = FALSE THEN
		INSERT INTO public."HistorialUsuarios"(
		usu_username, historial_fecha, historial_tipo_accion,
		historial_nombre_tabla, historial_pk_tabla)
		VALUES(USER, now(), 'DELETE', TG_TABLE_NAME, old.id_alumno);
		--Eliminamos tambien el alumno carrera
		UPDATE public."AlumnosCarrera"
		SET almn_carrera_activo = 'False'
		WHERE id_alumno = old.id_alumno;
	END IF; 	
	RETURN NEW;
END;
$alumno_elim$ LANGUAGE plpgsql;

CREATE TRIGGER auditoria_alumno_elim
BEFORE UPDATE OF alumno_activo
ON public."Alumnos" FOR EACH ROW
EXECUTE PROCEDURE alumno_elim();

--AlumnosCarrera 
CREATE OR REPLACE FUNCTION almn_carrera_elim()
RETURNS TRIGGER AS $almn_carrera_elim$
BEGIN
	IF new.almn_carrera_activo = FALSE THEN
		INSERT INTO public."HistorialUsuarios"(
		usu_username, historial_fecha, historial_tipo_accion,
		historial_nombre_tabla, historial_pk_tabla)
		VALUES(USER, now(), 'DELETE', TG_TABLE_NAME, old.id_almn_carrera);
	END IF; 	
	RETURN NEW;
END;
$almn_carrera_elim$ LANGUAGE plpgsql;

CREATE TRIGGER auditoria_almn_carrera_elim
BEFORE UPDATE OF almn_carrera_activo
ON public."AlumnosCarrera" FOR EACH ROW
EXECUTE PROCEDURE almn_carrera_elim();

--AlumnoCurso

CREATE OR REPLACE FUNCTION almn_curso_elim()
RETURNS TRIGGER AS $almn_curso_elim$
BEGIN
	INSERT INTO public."HistorialUsuarios"(
		usu_username, historial_fecha, historial_tipo_accion,
		historial_nombre_tabla, historial_pk_tabla, historial_observacion)
		VALUES(USER, now(), 'DELETE', TG_TABLE_NAME, old.id_almn_curso, 
			old.id_alumno || '%' || old.id_curso
			|| '%' || old.almn_curso_nt_1_parcial || '%' || 
			old.almn_curso_nt_examen_interciclo || '%' || 
			old.almn_curso_nt_2_parcial || '%' ||
			old.almn_curso_nt_examen_final || '%' || 
			old.almn_curso_nt_examen_supletorio || '%' || 
			old.almn_curso_asistencia || '%' ||
			old.almn_curso_nota_final || '%' ||
			old.almn_curso_estado || '%' ||
			old.almn_curso_num_faltas);
		RETURN NEW;
END;
$almn_curso_elim$ LANGUAGE plpgsql;

CREATE TRIGGER auditoria_almn_curso_elim
BEFORE DELETE 
ON public."AlumnoCurso" FOR EACH ROW
EXECUTE PROCEDURE almn_curso_elim();

--MallaAlumno
CREATE OR REPLACE FUNCTION malla_almn_elim()
RETURNS TRIGGER AS $malla_almn_elim$
BEGIN
	INSERT INTO public."HistorialUsuarios"(
		usu_username, historial_fecha, historial_tipo_accion,
		historial_nombre_tabla, historial_pk_tabla, historial_observacion)
		VALUES(USER, now(), 'DELETE', TG_TABLE_NAME, old.id_malla_alumno, 
			old.id_materia || '%' || old.almn_carrera
			|| '%' || old.malla_almn_ciclo || '%' || 
			old.malla_almn_num_matricula || '%' || 
			old.malla_almn_nota1 || '%' ||
			old.malla_almn_nota2 || '%' || 
			old.malla_almn_nota3 || '%' || 
			old.malla_almn_estado || '%' ||
			old.malla_almn_observacion);
		RETURN NEW;
END;
$malla_almn_elim$ LANGUAGE plpgsql;

CREATE TRIGGER auditoria_malla_almn_elim
BEFORE DELETE 
ON public."MallaAlumno" FOR EACH ROW
EXECUTE PROCEDURE malla_almn_elim();

--Usuarios
CREATE OR REPLACE FUNCTION usuario_elim()
RETURNS TRIGGER AS $usuario_elim$
BEGIN
	IF new.usu_estado = FALSE THEN
		INSERT INTO public."HistorialUsuarios"(
		usu_username, historial_fecha, historial_tipo_accion,
		historial_nombre_tabla, historial_pk_tabla)
		VALUES(USER, now(), 'DELETE', TG_TABLE_NAME, old.id_usuario);
	END IF; 	
	RETURN NEW;
END;
$usuario_elim$ LANGUAGE plpgsql;

CREATE TRIGGER auditoria_usuario_elim
BEFORE UPDATE OF usu_estado
ON public."Usuarios" FOR EACH ROW
EXECUTE PROCEDURE usuario_elim();