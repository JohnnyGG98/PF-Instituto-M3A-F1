package modelo.curso;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.ConectarDB;
import modelo.ResourceManager;
import modelo.jornada.JornadaBD;
import modelo.jornada.JornadaMD;
import modelo.materia.MateriaBD;
import modelo.materia.MateriaMD;
import modelo.periodolectivo.PeriodoLectivoBD;
import modelo.periodolectivo.PeriodoLectivoMD;
import modelo.persona.DocenteBD;
import modelo.persona.DocenteMD;

/**
 *
 * @author arman
 */
public class CursoBD extends CursoMD {

    private final MateriaBD mat;
    private final PeriodoLectivoBD prd;
    private final DocenteBD doc;
    private final JornadaBD jrd;
    private final ConectarDB conecta;

    public CursoBD(ConectarDB conecta) {
        this.conecta = conecta;
        this.mat = new MateriaBD(conecta);
        this.prd = new PeriodoLectivoBD(conecta);
        this.doc = new DocenteBD(conecta);
        this.jrd = new JornadaBD(conecta);
    }

    public void guardarCurso() {
        String nsql = "INSERT INTO public.\"Cursos\"(\n"
                + "	id_materia, id_prd_lectivo, id_docente, id_jornada, \n"
                + "	curso_nombre, curso_capacidad, curso_ciclo,\n"
                + "	curso_permiso_ingreso_nt, curso_paralelo)\n"
                + "	VALUES (" + getId_materia().getId() + ", " + getId_prd_lectivo().getId_PerioLectivo()
                + ", " + getId_docente().getIdDocente() + ", " + getCurso_jornada().getId()
                + ", '" + getCurso_nombre() + "', " + getCurso_capacidad() + ", " + getCurso_ciclo()
                + ", '" + isPermiso_ingreso_nt() + "', '" + getParalelo() + "');";
        if (conecta.nosql(nsql) == null) {
            System.out.println("Guardamos curso");
        }
    }

    public void editarCurso(int idCurso) {
        String nsql = "UPDATE public.\"Cursos\"\n"
                + "	SET id_materia=" + getId_materia().getId() + ", "
                + " id_prd_lectivo=" + getId_prd_lectivo().getId_PerioLectivo() + ", "
                + "id_docente= " + getId_docente().getIdDocente() + ", "
                + "id_jornada=" + getCurso_jornada().getId() + ", "
                + "curso_nombre='" + getCurso_nombre() + "', curso_capacidad=" + getCurso_capacidad() + ", "
                + "curso_ciclo=" + getCurso_ciclo() + ", curso_permiso_ingreso_nt=" + isPermiso_ingreso_nt() + ", "
                + "curso_paralelo= '" + getParalelo() + "'\n"
                + "	WHERE id_curso = " + idCurso + ";";
        if (conecta.nosql(nsql) == null) {
            System.out.println("Editamos curso");
        }
    }

    public ArrayList<CursoMD> cargarCursos() {
        String sql = "SELECT id_curso, materia_nombre, \n"
                + "persona_primer_nombre, persona_primer_apellido, \n"
                + "curso_nombre, curso_capacidad, curso_ciclo, \n"
                + "c.id_prd_lectivo, c.id_materia, c.id_docente\n"
                + "FROM public.\"Cursos\" c, public.\"Materias\" m, \n"
                + "public.\"Docentes\" d, public.\"Personas\" p\n"
                + "WHERE m.id_materia = c.id_materia AND \n"
                + "d.id_docente = c.id_docente AND \n"
                + "p.id_persona = d.id_persona;";
        return consultarCursos(sql);
    }

    public ArrayList<CursoMD> cargarCursosPorPeriodo(int idPrdLectivo) {
//        String sql = "SELECT id_curso, id_materia, id_prd_lectivo, id_docente, id_jornada, \n"
//                + "curso_nombre, curso_capacidad, curso_ciclo, curso_permiso_ingreso_nt, curso_paralelo\n"
//                + "	FROM public.\"Cursos\" "
//                + "WHERE id_prd_lectivo = " + idPrdLectivo + ";";
        String sql = "SELECT id_curso, materia_nombre, \n"
                + "persona_primer_nombre, persona_primer_apellido, \n"
                + "curso_nombre, curso_capacidad, curso_ciclo, \n"
                + "c.id_prd_lectivo, c.id_materia, c.id_docente\n"
                + "FROM public.\"Cursos\" c, public.\"Materias\" m, \n"
                + "public.\"Docentes\" d, public.\"Personas\" p\n"
                + "WHERE m.id_materia = c.id_materia AND \n"
                + "d.id_docente = c.id_docente AND \n"
                + "p.id_persona = d.id_persona \n"
                + "AND id_prd_lectivo = " + idPrdLectivo + ";";
        return consultarCursos(sql);
    }

    public ArrayList<CursoMD> cargarCursosPorNombre(String nombre) {
        String sql = "SELECT id_curso, materia_nombre, \n"
                + "persona_primer_nombre, persona_primer_apellido, \n"
                + "curso_nombre, curso_capacidad, curso_ciclo, \n"
                + "c.id_prd_lectivo, c.id_materia, c.id_docente\n"
                + "FROM public.\"Cursos\" c, public.\"Materias\" m, \n"
                + "public.\"Docentes\" d, public.\"Personas\" p\n"
                + "WHERE m.id_materia = c.id_materia AND \n"
                + "d.id_docente = c.id_docente AND \n"
                + "p.id_persona = d.id_persona \n"
                + "AND curso_nombre = '" + nombre + "';";
        return consultarCursos(sql);
    }

    public ArrayList<CursoMD> cargarCursosPorNombreYPrdLectivo(String nombre, int idPrdLectivo) {
        String sql = "SELECT id_curso, materia_nombre, \n"
                + "persona_primer_nombre, persona_primer_apellido, \n"
                + "curso_nombre, curso_capacidad, curso_ciclo, \n"
                + "c.id_prd_lectivo, c.id_materia, c.id_docente\n"
                + "FROM public.\"Cursos\" c, public.\"Materias\" m, \n"
                + "public.\"Docentes\" d, public.\"Personas\" p\n"
                + "WHERE m.id_materia = c.id_materia AND \n"
                + "d.id_docente = c.id_docente AND \n"
                + "p.id_persona = d.id_persona \n"
                + "AND curso_nombre = '" + nombre + "' AND id_prd_lectivo = " + idPrdLectivo + ";";
        return consultarCursos(sql);
    }

    public ArrayList<CursoMD> buscarCursos(String aguja) {
        String sql = "SELECT id_curso, materia_nombre, \n"
                + "persona_primer_nombre, persona_primer_apellido, \n"
                + "curso_nombre, curso_capacidad, curso_ciclo, \n"
                + "c.id_prd_lectivo, c.id_materia, c.id_docente\n"
                + "FROM public.\"Cursos\" c, public.\"Materias\" m, \n"
                + "public.\"Docentes\" d, public.\"Personas\" p\n"
                + "WHERE m.id_materia = c.id_materia AND \n"
                + "d.id_docente = c.id_docente AND \n"
                + "p.id_persona = d.id_persona AND\n"
                + "(materia_nombre ILIKE '%" + aguja + "%' OR \n"
                + "persona_primer_nombre || ' ' || persona_primer_apellido ILIKE '%" + aguja + "%'\n"
                + "OR persona_identificacion ILIKE '%" + aguja + "%');";
        return consultarCursos(sql);
    }

    public ArrayList<CursoMD> buscarCursosPorNombreYPrdLectivo(String nombre, int idPrdLectivo) {
        String sql = "SELECT id_curso, id_materia, \n"
                + "curso_capacidad, curso_ciclo\n"
                + "FROM public.\"Cursos\" "
                + "WHERE curso_nombre = '" + nombre + "' AND id_prd_lectivo = " + idPrdLectivo + ";";
        ArrayList<CursoMD> cursos = new ArrayList();
        ResultSet rs = conecta.sql(sql);
        try {
            if (rs != null) {
                while (rs.next()) {
                    CursoMD c = new CursoMD();
                    c.setId_curso(rs.getInt("id_curso"));
                    MateriaMD m = mat.buscarMateriaPorReferencia(rs.getInt("id_materia"));
                    c.setId_materia(m);
                    c.setCurso_capacidad(rs.getInt("curso_capacidad"));
                    c.setCurso_ciclo(rs.getInt("curso_ciclo"));

                    cursos.add(c);
                }
                return cursos;
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("No pudimos consultar cursos. ");
            System.out.println(e.getMessage());
            return null;
        }
    }

    public ArrayList<String> cargarNombreCursos() {
        String sql = "SELECT DISTINCT curso_nombre\n"
                + "FROM public.\"Cursos\";";
        return consultarNombreCursos(sql);
    }

    public ArrayList<String> cargarNombreCursosPorPeriodo(int idPrdLectivo) {
        String sql = "SELECT DISTINCT curso_nombre\n"
                + "FROM public.\"Cursos\" "
                + "WHERE id_prd_lectivo = " + idPrdLectivo + ";";
        return consultarNombreCursos(sql);
    }

    public ArrayList<String> cargarNombreCursosPorPeriodo(int idPrdLectivo, int cicloReprobado, int cicloCursado) {
        String sql = "SELECT DISTINCT curso_nombre, curso_ciclo\n"
                + "FROM public.\"Cursos\" "
                + "WHERE id_prd_lectivo = " + idPrdLectivo + " "
                + "AND curso_ciclo >= " + cicloReprobado + " AND curso_ciclo <= " + (cicloCursado + 1) + " "
                + "ORDER BY curso_ciclo;";
        //System.out.println("Consulta de los ciclos por perido lectivo\n"
        //        + sql);
        return consultarNombreCursos(sql);
    }

    public CursoMD buscarCurso(int idCurso) {
        String sql = "SELECT id_curso, id_materia, id_prd_lectivo, id_docente, id_jornada, \n"
                + "curso_nombre, curso_capacidad, curso_ciclo, curso_permiso_ingreso_nt, curso_paralelo\n"
                + "	FROM public.\"Cursos\" WHERE \"Cursos\".id_curso = " + idCurso + ";";
        return consultarCurso(sql);
    }

    public CursoMD existeMateriaCursoJornada(int idMateria, int ciclo, int idJornada, int idPrdLectivo, String paralelo) {
        String sql = "SELECT id_curso, id_materia, id_prd_lectivo, id_docente, id_jornada, \n"
                + "curso_nombre, curso_capacidad, curso_ciclo, curso_permiso_ingreso_nt, curso_paralelo\n"
                + "	FROM public.\"Cursos\"  WHERE id_materia = " + idMateria + " AND  "
                + "curso_ciclo = " + ciclo + " AND  id_jornada = " + idJornada + " AND "
                + "id_prd_lectivo = " + idPrdLectivo + " AND curso_paralelo = '" + paralelo + "';";
        return consultarCurso(sql);
    }

    public CursoMD existeDocenteMateria(int idMateria, int idDocente, int idJornada, int idPrdLectivo, int ciclo, String paralelo) {
        String sql = "SELECT id_curso, id_materia, id_prd_lectivo, id_docente, id_jornada, \n"
                + "curso_nombre, curso_capacidad, curso_ciclo, curso_permiso_ingreso_nt, curso_paralelo\n"
                + "FROM public.\"Cursos\" WHERE id_materia = " + idMateria + " AND  "
                + "id_docente = " + idDocente + " AND  id_jornada = " + idJornada + " AND "
                + "id_prd_lectivo = " + idPrdLectivo + " AND curso_ciclo = " + ciclo + " "
                + "AND curso_paralelo = '" + paralelo + "' ;";
        return consultarCurso(sql);
    }

    private ArrayList<CursoMD> consultarCursos(String sql) {
        ArrayList<CursoMD> cursos = new ArrayList();
        ResultSet rs = conecta.sql(sql);
        try {
            if (rs != null) {
                while (rs.next()) {
                    CursoMD c = obtenerCursoParaTbl(rs);
                    if (c != null) {
                        cursos.add(c);
                    }
                }
                return cursos;
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("No pudimos consultar cursos. ");
            System.out.println(e.getMessage());
            return null;
        }
    }

    private ArrayList<String> consultarNombreCursos(String sql) {
        ArrayList<String> nombres = new ArrayList();
        ResultSet rs = conecta.sql(sql);
        try {
            if (rs != null) {
                while (rs.next()) {
                    String nombre = rs.getString("curso_nombre");
                    nombres.add(nombre);
                }
                return nombres;
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("No se pudieron cargar los nombres de todos los cursos");
            System.out.println(e.getMessage());
            return null;
        }
    }

    private CursoMD consultarCurso(String sql) {
        CursoMD c = null;
        ResultSet rs = conecta.sql(sql);
        try {
            if (rs != null) {
                while (rs.next()) {
                    c = obtenerCurso(rs);
                }
                return c;
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("No se pudo consultar curso curso ");
            System.out.println(e.getMessage());
            return null;
        }
    }

    private CursoMD obtenerCurso(ResultSet rs) {
        CursoMD c = new CursoMD();
        try {
            c.setId_curso(rs.getInt("id_curso"));
            MateriaMD m = mat.buscarMateriaPorReferencia(rs.getInt("id_materia"));
            c.setId_materia(m);
            PeriodoLectivoMD p = prd.buscarPerido(rs.getInt("id_prd_lectivo"));
            c.setId_prd_lectivo(p);
            DocenteMD d = doc.buscarDocenteParaReferencia(rs.getInt("id_docente"));
            c.setId_docente(d);
            JornadaMD j = jrd.buscarJornada(rs.getInt("id_jornada"));
            c.setCurso_jornada(j);
            c.setCurso_nombre(rs.getString("curso_nombre"));
            c.setCurso_capacidad(rs.getInt("curso_capacidad"));
            c.setCurso_ciclo(rs.getInt("curso_ciclo"));
            c.setPermiso_ingreso_nt(rs.getBoolean("curso_permiso_ingreso_nt"));
            c.setParalelo(rs.getString("curso_paralelo"));
            return c;
        } catch (SQLException e) {
            System.out.println("No pudimos obtener curso");
            System.out.println(e.getMessage());
            return null;
        }
    }

    private CursoMD obtenerCursoParaTbl(ResultSet rs) {
        CursoMD c = new CursoMD();
        try {
            c.setId_curso(rs.getInt("id_curso"));
            MateriaMD m = new MateriaMD();
            m.setId(rs.getInt("id_materia"));
            m.setNombre(rs.getString("materia_nombre"));
            c.setId_materia(m);
            PeriodoLectivoMD p = new PeriodoLectivoMD();
            p.setId_PerioLectivo(rs.getInt("id_prd_lectivo"));
            c.setId_prd_lectivo(p);
            DocenteMD d = new DocenteMD();
            d.setIdDocente(rs.getInt("id_docente"));
            d.setPrimerNombre(rs.getString("persona_primer_nombre"));
            d.setPrimerApellido(rs.getString("persona_primer_apellido"));
            c.setId_docente(d);
            c.setCurso_nombre(rs.getString("curso_nombre"));
            c.setCurso_capacidad(rs.getInt("curso_capacidad"));
            c.setCurso_ciclo(rs.getInt("curso_ciclo"));
            return c;
        } catch (SQLException e) {
            System.out.println("No pudimos obtener curso");
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static List<String> selectParaleloWhere(int idDocente, int ciclo) {

        String SELECT = "SELECT DISTINCT\n"
                + "\"Cursos\".curso_paralelo\n"
                + "FROM\n"
                + "\"Cursos\"\n"
                + "INNER JOIN \"PeriodoLectivo\" ON \"Cursos\".id_prd_lectivo = \"PeriodoLectivo\".id_prd_lectivo\n"
                + "WHERE\n"
                + "\"Cursos\".id_docente = " + idDocente + " AND\n"
                + "\"PeriodoLectivo\".prd_lectivo_estado = FALSE AND\n"
                + "\"Cursos\".curso_ciclo = " + ciclo + "";

        List<String> lista = new ArrayList<>();

        ResultSet rs = ResourceManager.Query(SELECT);

        try {
            while (rs.next()) {

                String paralelo = rs.getString("curso_paralelo");

                lista.add(paralelo);

            }
            rs.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return lista;
    }

    public static List<Integer> selectCicloWhere(int idDocente) {

        String SELECT = "SELECT \n"
                + "DISTINCT\n"
                + "\"Cursos\".curso_ciclo\n"
                + "FROM\n"
                + "\"Cursos\"\n"
                + "INNER JOIN \"PeriodoLectivo\" ON \"Cursos\".id_prd_lectivo = \"PeriodoLectivo\".id_prd_lectivo\n"
                + "WHERE\n"
                + "\"Cursos\".id_docente = " + idDocente + "\n"
                + "AND\n"
                + "\"PeriodoLectivo\".prd_lectivo_estado = FALSE";

        List<Integer> lista = new ArrayList<>();

        ResultSet rs = ResourceManager.Query(SELECT);

        try {
            while (rs.next()) {

                lista.add(rs.getInt("curso_ciclo"));

            }
            rs.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return lista;
    }

}
