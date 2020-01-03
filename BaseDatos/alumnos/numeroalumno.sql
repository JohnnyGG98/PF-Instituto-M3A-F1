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
WHERE pl.id_prd_lectivo IN (

) GROUP BY
pl.id_prd_lectivo,
carrera_codigo,
prd_lectivo_nombre
ORDER BY
prd_lectivo_fecha_inicio DESC;
