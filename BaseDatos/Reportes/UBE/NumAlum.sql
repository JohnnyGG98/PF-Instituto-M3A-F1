--NUmero de alumnos
SELECT
pl.id_prd_lectivo,
carrera_codigo,
prd_lectivo_nombre, (
  SELECT COUNT(*)
  FROM public."Matricula" m
  JOIN public."Alumnos" a ON
  a.id_alumno = m.id_alumno
  JOIN public."Personas" p ON
  a.id_persona = p.id_persona
  WHERE persona_activa = true AND
  persona_sexo ILIKE '%H%' AND
  m.id_prd_lectivo = pl.id_prd_lectivo
) AS hombres, (
  SELECT COUNT(*)
  FROM public."Matricula" m
  JOIN public."Alumnos" a ON
  a.id_alumno = m.id_alumno
  JOIN public."Personas" p ON
  a.id_persona = p.id_persona
  WHERE persona_activa = true AND
  persona_sexo ILIKE '%M%' AND
  m.id_prd_lectivo = pl.id_prd_lectivo
) AS mujeres, (
  SELECT COUNT(*)
  FROM public."Matricula" m
  WHERE  m.id_prd_lectivo = pl.id_prd_lectivo
) AS total
FROM public."Carreras" c
JOIN public."PeriodoLectivo" pl ON
pl.id_carrera = c.id_carrera
GROUP BY
pl.id_prd_lectivo,
carrera_codigo,
prd_lectivo_nombre
ORDER BY
prd_lectivo_fecha_inicio DESC;



--- Numero de materias por jornada
SELECT
pl.id_prd_lectivo,
carrera_codigo,
prd_lectivo_nombre, (
  SELECT
  COUNT(*)
  FROM public."Cursos" cr
  WHERE
  cr.id_prd_lectivo = pl.id_prd_lectivo AND
  curso_nombre ILIKE '%M%'
) AS num_matutina, (
  SELECT
  COUNT(*)
  FROM public."Cursos" cr
  WHERE
  cr.id_prd_lectivo = pl.id_prd_lectivo AND
  curso_nombre ILIKE '%V%'
) AS num_vespertina, (
  SELECT
  COUNT(*)
  FROM public."Cursos" cr
  WHERE
  cr.id_prd_lectivo = pl.id_prd_lectivo AND
  curso_nombre ILIKE '%N%'
) AS num_nocturna
FROM public."Carreras" c
JOIN public."PeriodoLectivo" pl ON
pl.id_carrera = c.id_carrera
GROUP BY
pl.id_prd_lectivo,
carrera_codigo,
prd_lectivo_nombre
ORDER BY
prd_lectivo_fecha_inicio DESC;


--Numero de aulas en las tres jornadas

SELECT
pl.id_prd_lectivo,
carrera_codigo,
prd_lectivo_nombre, (
  SELECT
  COUNT(DISTINCT curso_nombre)
  FROM public."Cursos" cr
  WHERE
  cr.id_prd_lectivo = pl.id_prd_lectivo AND
  cr.id_jornada = 1
) AS num_matutina, (
  SELECT
  COUNT(DISTINCT curso_nombre)
  FROM public."Cursos" cr
  WHERE
  cr.id_prd_lectivo = pl.id_prd_lectivo AND
  cr.id_jornada = 2
) AS num_vespertina, (
  SELECT
  COUNT(DISTINCT curso_nombre)
  FROM public."Cursos" cr
  WHERE
  cr.id_prd_lectivo = pl.id_prd_lectivo AND
  cr.id_jornada = 3
) AS num_nocturna
FROM public."Carreras" c
JOIN public."PeriodoLectivo" pl ON
pl.id_carrera = c.id_carrera
GROUP BY
pl.id_prd_lectivo,
carrera_codigo,
prd_lectivo_nombre
ORDER BY
prd_lectivo_fecha_inicio DESC;


--Numero de aulas solo los que tienen las tres jornadas
SELECT
pl.id_prd_lectivo,
carrera_codigo,
prd_lectivo_nombre,
COUNT(DISTINCT crm.curso_nombre),
COUNT(DISTINCT crv.curso_nombre),
COUNT(DISTINCT crn.curso_nombre)
FROM public."Carreras" c
JOIN public."PeriodoLectivo" pl ON
pl.id_carrera = c.id_carrera
JOIN public."Cursos" crm ON
crm.id_prd_lectivo = pl.id_prd_lectivo
JOIN public."Cursos" crv ON
crv.id_prd_lectivo = pl.id_prd_lectivo
JOIN public."Cursos" crn ON
crn.id_prd_lectivo = pl.id_prd_lectivo
WHERE
crm.id_jornada = 1 AND
crv.id_jornada = 2 AND
crn.id_jornada = 3
GROUP BY
pl.id_prd_lectivo,
carrera_codigo,
prd_lectivo_nombre
ORDER BY
prd_lectivo_fecha_inicio DESC;


---Numero de cursos y numero de alumnos por jornada

SELECT
pl.id_prd_lectivo,
carrera_codigo,
prd_lectivo_nombre, (
  SELECT
  COUNT(DISTINCT curso_nombre)
  FROM public."Cursos" cr
  WHERE
  cr.id_prd_lectivo = pl.id_prd_lectivo AND
  cr.id_jornada = 1
) AS num_matutina, (
  SELECT
  count(DISTINCT id_alumno)
  FROM public."AlumnoCurso" ac
  WHERE id_curso IN (
    SELECT id_curso
    FROM public."Cursos" cr
    WHERE
    cr.id_prd_lectivo = pl.id_prd_lectivo AND
    cr.id_jornada = 1
  )
) AS alum_matu,(
  SELECT
  COUNT(DISTINCT curso_nombre)
  FROM public."Cursos" cr
  WHERE
  cr.id_prd_lectivo = pl.id_prd_lectivo AND
  cr.id_jornada = 2
) AS num_vespertina, (
  SELECT
  count(DISTINCT id_alumno)
  FROM public."AlumnoCurso" ac
  WHERE id_curso IN (
    SELECT id_curso
    FROM public."Cursos" cr
    WHERE
    cr.id_prd_lectivo = pl.id_prd_lectivo AND
    cr.id_jornada = 2
  )
) AS alum_vesp, (
  SELECT
  COUNT(DISTINCT curso_nombre)
  FROM public."Cursos" cr
  WHERE
  cr.id_prd_lectivo = pl.id_prd_lectivo AND
  cr.id_jornada = 3
) AS num_nocturna, (
  SELECT
  count(DISTINCT id_alumno)
  FROM public."AlumnoCurso" ac
  WHERE id_curso IN (
    SELECT id_curso
    FROM public."Cursos" cr
    WHERE
    cr.id_prd_lectivo = pl.id_prd_lectivo AND
    cr.id_jornada = 3
  )
) AS alum_noct
FROM public."Carreras" c
JOIN public."PeriodoLectivo" pl ON
pl.id_carrera = c.id_carrera
GROUP BY
pl.id_prd_lectivo,
carrera_codigo,
prd_lectivo_nombre
ORDER BY
prd_lectivo_fecha_inicio DESC;

-- Numero de alumnos hombres y mujeres por curso 
SELECT
c.id_prd_lectivo,
prd_lectivo_nombre,
curso_nombre, (
  SELECT COUNT(DISTINCT ac.id_alumno)
  FROM public."AlumnoCurso" ac
  JOIN public."Alumnos" a ON
  a.id_alumno = ac.id_alumno
  JOIN public."Personas" p ON
  a.id_persona = p.id_persona
  WHERE persona_activa = true
  AND persona_sexo ILIKE '%M%'
  AND id_curso IN (
    SELECT id_curso
    FROM public."Cursos"
    WHERE id_prd_lectivo = c.id_prd_lectivo
    AND curso_nombre = c.curso_nombre
  )
) AS num_mujeres, (
  SELECT COUNT(DISTINCT ac.id_alumno)
  FROM public."AlumnoCurso" ac
  JOIN public."Alumnos" a ON
  a.id_alumno = ac.id_alumno
  JOIN public."Personas" p ON
  a.id_persona = p.id_persona
  WHERE persona_activa = true
  AND persona_sexo ILIKE '%H%'
  AND id_curso IN (
    SELECT id_curso
    FROM public."Cursos"
    WHERE id_prd_lectivo = c.id_prd_lectivo
    AND curso_nombre = c.curso_nombre
  )
) AS num_hombres, (
  SELECT COUNT(DISTINCT id_alumno)
  FROM public."AlumnoCurso"
  WHERE id_curso IN (
    SELECT id_curso
    FROM public."Cursos"
    WHERE id_prd_lectivo = c.id_prd_lectivo
    AND curso_nombre = c.curso_nombre
  )
) AS total_alumnos

FROM public."Cursos" c
JOIN public."PeriodoLectivo" pl
ON pl.id_prd_lectivo = c.id_prd_lectivo
WHERE c.id_prd_lectivo = 31
GROUP BY
c.id_prd_lectivo,
prd_lectivo_nombre,
curso_nombre
ORDER BY
prd_lectivo_nombre,
curso_nombre;
