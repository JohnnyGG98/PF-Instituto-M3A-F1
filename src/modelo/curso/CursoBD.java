package modelo.curso;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.ConectarDB;
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

    MateriaBD mat = new MateriaBD();
    PeriodoLectivoBD prd = new PeriodoLectivoBD();
    DocenteBD doc = new DocenteBD();
    JornadaBD jrd = new JornadaBD();

    ConectarDB conecta = new ConectarDB("Curso");

    private final String INSERT = "INSERT INTO public.\"Cursos\"(\n"
            + "	 id_materia, id_prd_lectivo, id_docente, curso_nombre, "
            + "curso_jornada, curso_capacidad, curso_ciclo, "
            + "curso_permiso_ingreso_nt)\n"
            + "	VALUES (?, ?, ?, ?, ?, ?, ?, ?);";

    private final String SELECT_ALL = "SELECT id_curso, id_materia, id_prd_lectivo, id_docente, curso_nombre, curso_jornada, curso_capacidad, curso_ciclo, curso_permiso_ingreso_nt\n"
            + "	FROM public.\"Cursos\";";

    private final String UPDATE = "SELECT id_curso, id_materia, id_prd_lectivo, id_docente, curso_nombre, curso_jornada, curso_capacidad, curso_ciclo, curso_permiso_ingreso_nt\n"
            + "	FROM public.\"Cursos\";";

    private final String DELETE = "DELETE FROM public.\"Cursos\"\n"
            + "	WHERE <condition>;";

    private String SELECT_ONE(String aguja) {
        return "SELECT * FROM Cursos "
                + "WHERE \"curso_nombre\" LIKE '%" + aguja + "%'"
                + "OR \"curso_jornada\" LIKE '%" + aguja + "%'"
                + "OR \"id_docente\" LIKE '%" + aguja + "%'";
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
        ArrayList<CursoMD> cursos = new ArrayList();
        String sql = "SELECT id_curso, id_materia, id_prd_lectivo, id_docente, id_jornada, \n"
                + "curso_nombre, curso_capacidad, curso_ciclo, curso_permiso_ingreso_nt, curso_paralelo\n"
                + "	FROM public.\"Cursos\";";
        ResultSet rs = conecta.sql(sql);
        try {
            if (rs != null) {
                while (rs.next()) {
                    CursoMD c = obtenerCurso(rs);
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

    public CursoMD buscarCurso(int idCurso) {
        String sql = "SELECT id_curso, id_materia, id_prd_lectivo, id_docente, id_jornada, \n"
                + "curso_nombre, curso_capacidad, curso_ciclo, curso_permiso_ingreso_nt, curso_paralelo\n"
                + "	FROM public.\"Cursos\" id_curso = " + idCurso + ";";
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

    public CursoMD obtenerCurso(ResultSet rs) {
        CursoMD c = new CursoMD();
        try {
            c.setId_curso(rs.getInt("id_curso"));
            MateriaMD m = mat.buscarMateria(rs.getInt("id_materia"));
            c.setId_materia(m);
            PeriodoLectivoMD p = prd.buscarPerido(rs.getInt("id_prd_lectivo"));
            c.setId_prd_lectivo(p);
            DocenteMD d = doc.buscarDocente(rs.getInt("id_docente"));
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

}