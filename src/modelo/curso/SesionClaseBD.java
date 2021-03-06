package modelo.curso;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalTime;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.ConnDBPool;
import modelo.materia.MateriaMD;
import modelo.persona.DocenteMD;
import utils.CONBD;
import utils.M;

/**
 *
 * @author Johnny
 */
public class SesionClaseBD extends CONBD {

    private final ConnDBPool pool;
    private ResultSet rst;
    private Connection conn;
    private String sql, nsql;

    private static SesionClaseBD SCBD;

    public static SesionClaseBD single() {
        if (SCBD == null) {
            SCBD = new SesionClaseBD();
        }
        return SCBD;
    }

    {
        pool = new ConnDBPool();
    }

    public void ingresar(SesionClaseMD sc) {
        nsql = "INSERT INTO public.\"SesionClase\"(\n"
                + "id_curso, "
                + "dia_sesion, "
                + "hora_inicio_sesion, "
                + "hora_fin_sesion)\n"
                + "VALUES (" + sc.getCurso().getId() + ", "
                + "" + sc.getDia() + ", "
                + "'" + sc.getHoraIni() + "', "
                + "'" + sc.getHoraFin() + "');";
        if (CON.executeNoSQL(nsql)) {
            JOptionPane.showMessageDialog(null, "Se guardo correctamente el horario.");
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo guardar el horario correctamente.");
        }
    }

    public String obtenerInsert(SesionClaseMD sc) {
        nsql = "INSERT INTO public.\"SesionClase\"(\n"
                + "id_curso, "
                + "dia_sesion, "
                + "hora_inicio_sesion, "
                + "hora_fin_sesion)\n"
                + "VALUES (" + sc.getCurso().getId() + ", "
                + "" + sc.getDia() + ", "
                + "'" + sc.getHoraIni() + "', "
                + "'" + sc.getHoraFin() + "');";
        return nsql;
    }

    public void ingresarHorarios(String nsql) {
        if (CON.executeNoSQL(nsql)) {
            JOptionPane.showMessageDialog(null, "Se guardo correctamente el horario.");
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo guardar el horario correctamente.");
        }
    }

    public void editar(SesionClaseMD sc) {
        nsql = "UPDATE public.\"SesionClase\"\n"
                + "SET dia_sesion=" + sc.getDia() + ", "
                + "hora_inicio_sesion='" + sc.getHoraIni() + "', "
                + "hora_fin_sesion='" + sc.getHoraFin() + "' "
                + "WHERE id_sesion=" + sc.getId() + ";";
        if (CON.executeNoSQL(sql)) {
            JOptionPane.showMessageDialog(null, "Se edito correctamente el horario.");
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo editar correctamente el horario.");
        }
    }

    public void eliminar(int idSesion) {
        nsql = "DELETE FROM public.\"SesionClase\"\n"
                + "WHERE id_sesion= " + idSesion + ";";
        if (CON.executeNoSQL(nsql)) {
            JOptionPane.showMessageDialog(null, "Se elimino correctamente el horario.");
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo eliminar correctamente el horario.");
        }
    }

    public SesionClaseMD buscarSesion(int idSesion) {
        SesionClaseMD s = new SesionClaseMD();
        sql = "SELECT id_sesion, "
                + "id_curso, "
                + "dia_sesion, "
                + "hora_inicio_sesion, "
                + "hora_fin_sesion "
                + "FROM public.\"SesionClase\" "
                + "WHERE id_sesion = " + idSesion + ";";
        PreparedStatement ps = CON.getPSPOOL(sql);
        try {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                CursoMD c = new CursoMD();
                s.setId(rs.getInt("id_sesion"));
                c.setId(rs.getInt("id_curso"));
                s.setCurso(c);
                s.setDia(rs.getInt("dia_sesion"));
                s.setHoraFin(rs.getTime("hora_fin_sesion").toLocalTime());
                s.setHoraIni(rs.getTime("hora_inicio_sesion").toLocalTime());
            }
            return s;
        } catch (SQLException e) {
            M.errorMsg("No se pudo consultar sesion " + e.getMessage());
            return null;
        } finally {
            CON.cerrarCONPS(ps);
        }

    }

    public SesionClaseMD existeSesion(int idCurso, int dia, LocalTime horaIni, LocalTime horaFin) {
        SesionClaseMD s = new SesionClaseMD();
        sql = "SELECT id_sesion, "
                + "id_curso, "
                + "dia_sesion, "
                + "hora_inicio_sesion, "
                + "hora_fin_sesion "
                + "FROM public.\"SesionClase\" \n"
                + "WHERE dia_sesion = " + dia + " "
                + "AND id_curso = " + idCurso + " \n"
                + "AND hora_inicio_sesion = '" + horaIni.toString() + "' "
                + "AND hora_fin_sesion = '" + horaFin.toString() + "';";
        PreparedStatement ps = CON.getPSPOOL(sql);
        try {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                CursoMD c = new CursoMD();
                s.setId(rs.getInt("id_sesion"));
                c.setId(rs.getInt("id_curso"));
                s.setCurso(c);
                s.setDia(rs.getInt("dia_sesion"));
                s.setHoraFin(rs.getTime("hora_fin_sesion").toLocalTime());
                s.setHoraIni(rs.getTime("hora_inicio_sesion").toLocalTime());
            }
            return s;
        } catch (SQLException e) {
            M.errorMsg("No se pudo consultar sesion " + e.getMessage());
            return null;
        } finally {
            CON.cerrarCONPS(ps);
        }
    }

    /**
     * Cargamos el horario del curso por calse de ese dia
     *
     * @param idCurso
     * @param dia
     * @return
     */
    public ArrayList<SesionClaseMD> cargarHorarioCursoPorDia(int idCurso, int dia) {
        sql = "SELECT id_sesion, dia_sesion, hora_inicio_sesion, hora_fin_sesion \n"
                + "	FROM public.\"SesionClase\" \n"
                + "	WHERE id_curso = " + idCurso + " \n"
                + "	AND dia_sesion = " + dia + " ;";
        ArrayList<SesionClaseMD> sesiones = new ArrayList<>();
        PreparedStatement ps = CON.getPSPOOL(sql);
        try {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SesionClaseMD s = new SesionClaseMD();
                s.setDia(rs.getInt("dia_sesion"));
                s.setHoraFin(rs.getTime("hora_fin_sesion").toLocalTime());
                s.setHoraIni(rs.getTime("hora_inicio_sesion").toLocalTime());
                s.setId(rs.getInt("id_sesion"));

                sesiones.add(s);
            }
        } catch (SQLException e) {
            M.errorMsg("No se pudo consultar sesion " + e.getMessage());
        } finally {
            CON.cerrarCONPS(ps);
        }
        return sesiones;

    }

    /**
     * Cargamos el horario de un curso.
     *
     * @param curso
     * @return
     */
    public ArrayList<SesionClaseMD> cargarHorarioCurso(CursoMD curso) {
        sql = "SELECT id_sesion, "
                + "dia_sesion, "
                + "hora_inicio_sesion, "
                + "hora_fin_sesion "
                + "FROM public.\"SesionClase\"  "
                + "WHERE id_curso = " + curso.getId() + " "
                + "ORDER BY dia_sesion;";
        ArrayList<SesionClaseMD> sesiones = new ArrayList<>();
        PreparedStatement ps = CON.getPSPOOL(sql);
        try {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SesionClaseMD s = new SesionClaseMD();
                s.setCurso(curso);
                s.setDia(rs.getInt("dia_sesion"));
                s.setHoraFin(rs.getTime("hora_fin_sesion").toLocalTime());
                s.setHoraIni(rs.getTime("hora_inicio_sesion").toLocalTime());
                s.setId(rs.getInt("id_sesion"));

                sesiones.add(s);
            }
        } catch (SQLException e) {
            M.errorMsg("No se pudo consultar sesion " + e.getMessage());
        } finally {
            CON.cerrarCONPS(ps);
        }
        return sesiones;
    }

    /**
     * Cargamos todo el horario del curso por dia.
     *
     * @param nombreCurso
     * @param dia
     * @param idPrdLectivo
     * @return
     */
    public ArrayList<SesionClaseMD> cargarHorarioCursoPorDia(String nombreCurso, int dia, int idPrdLectivo) {
        sql = "SELECT id_sesion, sc.id_curso, \n"
                + "hora_inicio_sesion, hora_fin_sesion, \n"
                + "materia_nombre, materia_codigo, \n"
                + "persona_primer_nombre, persona_primer_apellido, \n"
                + "docente_abreviatura\n"
                + "FROM public.\"SesionClase\" sc, public.\"Cursos\" c,\n"
                + "public.\"Materias\" m, public.\"Docentes\" d, \n"
                + "public.\"Personas\" p\n"
                + "WHERE sc.id_curso IN (\n"
                + "	SELECT id_curso\n"
                + "	FROM public.\"Cursos\"\n"
                + "	WHERE id_prd_lectivo = " + idPrdLectivo + "  AND \n"
                + "	curso_nombre = '" + nombreCurso + "'\n"
                + ") AND dia_sesion = " + dia + " AND\n"
                + "c.id_curso = sc.id_curso AND \n"
                + "d.id_docente = c.id_docente AND\n"
                + "p.id_persona = d.id_persona AND \n"
                + "m.id_materia = c.id_materia\n"
                + "ORDER BY hora_inicio_sesion";
        ArrayList<SesionClaseMD> sesiones = new ArrayList<>();
        PreparedStatement ps = CON.getPSPOOL(sql);
        try {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SesionClaseMD s = new SesionClaseMD();
                s.setId(rs.getInt("id_sesion"));
                s.setHoraFin(rs.getTime("hora_fin_sesion").toLocalTime());
                s.setHoraIni(rs.getTime("hora_inicio_sesion").toLocalTime());
                CursoMD c = new CursoMD();
                c.setId(rs.getInt("id_curso"));
                MateriaMD m = new MateriaMD();
                m.setNombre(rs.getString("materia_nombre"));
                m.setCodigo(rs.getString("materia_codigo"));
                DocenteMD d = new DocenteMD();
                d.setPrimerNombre(rs.getString("persona_primer_nombre"));
                d.setPrimerApellido(rs.getString("persona_primer_apellido"));

                c.setDocente(d);
                c.setMateria(m);
                s.setCurso(c);

                sesiones.add(s);
            }
        } catch (SQLException e) {
            M.errorMsg("No se pudo consultar sesion " + e.getMessage());
        } finally {
            CON.cerrarCONPS(ps);
        }
        return sesiones;
    }

    public ArrayList<SesionClaseMD> cargarHorarioCurso(String nombreCurso, int idPrdLectivo) {
        sql = "SELECT id_sesion, "
                + "dia_sesion, "
                + "hora_inicio_sesion, "
                + "hora_fin_sesion,"
                + " id_curso \n"
                + "	FROM public.\"SesionClase\" \n"
                + "	WHERE id_curso IN (\n"
                + "	SELECT id_curso\n"
                + "	FROM public.\"Cursos\"\n"
                + "	WHERE id_prd_lectivo = " + idPrdLectivo + "  AND \n"
                + "	curso_nombre = '" + nombreCurso + "');";
        ArrayList<SesionClaseMD> sesiones = new ArrayList<>();
        PreparedStatement ps = CON.getPSPOOL(sql);
        try {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SesionClaseMD s = new SesionClaseMD();
                CursoMD c = new CursoMD();
                c.setId(rs.getInt("id_curso"));
                s.setCurso(c);
                s.setDia(rs.getInt("dia_sesion"));
                s.setHoraFin(rs.getTime("hora_fin_sesion").toLocalTime());
                s.setHoraIni(rs.getTime("hora_inicio_sesion").toLocalTime());
                s.setId(rs.getInt("id_sesion"));

                sesiones.add(s);
            }
        } catch (SQLException e) {
            M.errorMsg("No se pudo consultar sesion " + e.getMessage());
        } finally {
            CON.cerrarCONPS(ps);
        }
        return sesiones;

    }

    public ArrayList<SesionClaseMD> cargarDiasClase(String nombreCurso, int idPrdLectivo, int idDocente, String materiaNombre) {
        sql = "SELECT\n"
                + "	\"SesionClase\".dia_sesion \n"
                + "FROM\n"
                + "	public.\"SesionClase\"\n"
                + "	INNER JOIN public.\"Cursos\" ON public.\"Cursos\".id_curso = public.\"SesionClase\".id_curso\n"
                + "	INNER JOIN public.\"Docentes\" ON public.\"Docentes\".id_docente = public.\"Cursos\".id_docente\n"
                + "	INNER JOIN public.\"PeriodoLectivo\" ON public.\"Cursos\".id_prd_lectivo = public.\"PeriodoLectivo\".id_prd_lectivo\n"
                + "	INNER JOIN public.\"Carreras\" ON public.\"Carreras\".id_carrera = public.\"PeriodoLectivo\".id_carrera\n"
                + "	INNER JOIN public.\"Materias\" ON public.\"Materias\".id_carrera = public.\"Carreras\".id_carrera \n"
                + "WHERE\n"
                + "	public.\"Cursos\".id_docente = " + idDocente + " \n"
                + "	AND public.\"Cursos\".curso_nombre = '" + nombreCurso + "' \n"
                + "	AND public.\"PeriodoLectivo\".id_prd_lectivo = " + idPrdLectivo + " \n"
                + "	AND public.\"Materias\".materia_nombre = '" + materiaNombre + "' \n"
                + "GROUP BY\n"
                + "	\"SesionClase\".dia_sesion;";

        ArrayList<SesionClaseMD> diasClase = new ArrayList<>();
        conn = pool.getConnection();
        rst = pool.ejecutarQuery(sql, conn, null);

        try {
            while (rst.next()) {
                SesionClaseMD s = new SesionClaseMD();
                s.setDia(rst.getInt("dia_sesion"));
                s.setNumeroDias(rst.getInt(1));
                diasClase.add(s);
            }

            return diasClase;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            pool.close(conn);
        }
        return diasClase;

    }
}
