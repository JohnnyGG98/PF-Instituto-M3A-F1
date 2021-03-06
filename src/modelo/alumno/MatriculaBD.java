package modelo.alumno;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.periodolectivo.PeriodoLectivoMD;
import modelo.persona.AlumnoMD;
import utils.CONBD;
import utils.M;

/**
 *
 * @author Johnny
 */
public class MatriculaBD extends CONBD {

    private String sql = "";
    private static MatriculaBD MBD;

    public static MatriculaBD single() {
        if (MBD == null) {
            MBD = new MatriculaBD();
        }
        return MBD;
    }

    public void ingresar(MatriculaMD m) {
        String nsql = "INSERT INTO public.\"Matricula\"(\n"
                + "id_alumno, "
                + "id_prd_lectivo, "
                + "matricula_tipo)\n"
                + "VALUES (" + m.getAlumno().getId_Alumno() + ", "
                + "" + m.getPeriodo().getID() + ", "
                + "'" + m.getTipo() + "');";

        if (!CON.executeNoSQL(nsql)) {
            JOptionPane.showMessageDialog(null, "No se pudo realizar la matricula, \n"
                    + "compruebe su conexion a internet.");
        }
    }

    public ArrayList<MatriculaMD> cargarMatriculas() {
        sql = "SELECT id_matricula, "
                + "m.id_alumno, "
                + "m.id_prd_lectivo, "
                + "matricula_fecha, "
                + "persona_identificacion, "
                + "persona_primer_nombre, "
                + "persona_segundo_nombre, "
                + "persona_primer_apellido, "
                + "persona_segundo_apellido, "
                + "prd_lectivo_nombre "
                + "FROM public.\"Matricula\" m, "
                + "public.\"PeriodoLectivo\" pl, "
                + "public.\"Alumnos\" a, "
                + "public.\"Personas\" p "
                + "WHERE pl.id_prd_lectivo = m.id_prd_lectivo AND \n"
                + "a.id_alumno = m.id_alumno AND \n"
                + "p.id_persona = a.id_persona; ";
        return consultarParaTbl(sql);
    }

    public ArrayList<MatriculaMD> cargarMatriculasPorPrd(int idPrd) {
        sql = "SELECT id_matricula, "
                + "m.id_alumno, "
                + "m.id_prd_lectivo, "
                + "matricula_fecha, "
                + "persona_identificacion, "
                + "persona_primer_nombre, "
                + "persona_segundo_nombre, "
                + "persona_primer_apellido, "
                + "persona_segundo_apellido, "
                + "prd_lectivo_nombre "
                + "FROM public.\"Matricula\" m, "
                + "public.\"PeriodoLectivo\" pl, "
                + "public.\"Alumnos\" a, "
                + "public.\"Personas\" p "
                + "WHERE pl.id_prd_lectivo = m.id_prd_lectivo AND "
                + "a.id_alumno = m.id_alumno AND  "
                + "p.id_persona = a.id_persona AND  "
                + "m.id_prd_lectivo = " + idPrd + "; ";
        return consultarParaTbl(sql);
    }

    /**
     * Buscamos si el alumno ya fue matriculado
     *
     * @param idAlm
     * @param idPrd
     * @return
     */
    public MatriculaMD buscarMatriculaAlmnPrd(int idAlm, int idPrd) {
        MatriculaMD m = null;
        sql = "SELECT id_matricula, id_alumno, id_prd_lectivo, matricula_fecha \n"
                + "FROM public.\"Matricula\" \n "
                + "WHERE id_prd_lectivo = " + idPrd + " AND id_alumno = " + idAlm + ";";
        PreparedStatement ps = CON.getPSPOOL(sql);

        try {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                m = new MatriculaMD();
                m.setId(rs.getInt("id_matricula"));
                m.setFecha(rs.getTimestamp("matricula_fecha").toLocalDateTime());
            }
            ps.getConnection().close();
            return m;
        } catch (SQLException e) {
            M.errorMsg("No se pudieron consultar matriculas. " + e.getMessage());
            return null;
        } finally {
            CON.cerrarCONPS(ps);
        }
    }

    /**
     * Se podran buscar por cedula, nombres completos y nombre del periodo, o
     * siglas de la carrera
     *
     * @param aguja
     * @return
     */
    public ArrayList<MatriculaMD> buscarMatriculas(String aguja) {
        sql = "SELECT id_matricula, "
                + "m.id_alumno, "
                + "m.id_prd_lectivo, "
                + "matricula_fecha, "
                + "persona_identificacion, "
                + "persona_primer_nombre, "
                + "persona_segundo_nombre, "
                + "persona_primer_apellido, "
                + "persona_segundo_apellido, "
                + "prd_lectivo_nombre "
                + "FROM public.\"Matricula\" m, "
                + "public.\"PeriodoLectivo\" pl, "
                + "public.\"Alumnos\" a, "
                + "public.\"Personas\" p "
                + "WHERE pl.id_prd_lectivo = m.id_prd_lectivo AND "
                + "a.id_alumno = m.id_alumno AND  "
                + "p.id_persona = a.id_persona AND( "
                + "persona_identificacion ILIKE '%" + aguja + "%' OR \n"
                + "persona_primer_nombre || ' ' || persona_segundo_nombre || ' ' ||\n"
                + "persona_primer_apellido ||' '|| persona_segundo_apellido ILIKE '%" + aguja + "%'\n"
                + "OR prd_lectivo_nombre ILIKE '%" + aguja + "%'); ";
        return consultarParaTbl(sql);
    }

    private ArrayList<MatriculaMD> consultarParaTbl(String sql) {
        ArrayList<MatriculaMD> matriculas = new ArrayList();
        PreparedStatement ps = CON.getPSPOOL(sql);
        try {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                MatriculaMD m = new MatriculaMD();
                AlumnoMD a = new AlumnoMD();
                PeriodoLectivoMD p = new PeriodoLectivoMD();
                m.setId(rs.getInt("id_matricula"));
                a.setId_Alumno(rs.getInt("id_alumno"));
                p.setID(rs.getInt("id_prd_lectivo"));
                m.setFecha(rs.getTimestamp("matricula_fecha").toLocalDateTime());
                a.setIdentificacion(rs.getString("persona_identificacion"));
                a.setPrimerNombre(rs.getString("persona_primer_nombre"));
                a.setSegundoNombre(rs.getString("persona_segundo_nombre"));
                a.setPrimerApellido(rs.getString("persona_primer_apellido"));
                a.setSegundoApellido(rs.getString("persona_segundo_apellido"));
                p.setNombre(rs.getString("prd_lectivo_nombre"));
                a.setIdentificacion(rs.getString("persona_identificacion"));
                m.setAlumno(a);
                m.setPeriodo(p);

                matriculas.add(m);
            }
        } catch (SQLException e) {
            M.errorMsg("No se pudieron consultar matriculas. " + e.getMessage());
        } finally {
            CON.cerrarCONPS(ps);
        }
        return matriculas;
    }

    /**
     * Numero de matriculas hechas en un periodo lectivo
     *
     * @param idPrd
     * @return
     */
    public int numMaticuladosClases(int idPrd) {
        int num = 0;
        sql = "SELECT count(*) FROM public.\"AlumnoCurso\"\n"
                + "WHERE id_curso IN(\n"
                + "  SELECT id_curso\n"
                + "  FROM public.\"Cursos\"\n"
                + "  WHERE id_prd_lectivo = " + idPrd + ");";
        PreparedStatement ps = CON.getPSPOOL(sql);
        try {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                num = rs.getInt(1);
            }
            return num;
        } catch (SQLException e) {
            M.errorMsg("No podemos obetener el numero de matriculados en un periodo \n"
                    + e.getMessage());
            return 0;
        } finally {
            CON.cerrarCONPS(ps);
        }
    }

    public int numMaticulados(int idPrd) {
        int num = 0;
        sql = "SELECT count(*) FROM public.\"Matricula\" "
                + "WHERE id_prd_lectivo = " + idPrd + ";";
        PreparedStatement ps = CON.getPSPOOL(sql);
        try {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                num = rs.getInt(1);
            }
        } catch (SQLException e) {
            M.errorMsg("No podemos obetener el numero de matriculados en un periodo \n"
                    + e.getMessage());
        } finally {
            CON.cerrarCONPS(ps);
        }
        return num;
    }

    public ArrayList<String> cursosMatriculado(int idAlumno, int idPeriodo) {
        ArrayList<String> nombres = null;
        sql = "SELECT DISTINCT curso_nombre\n"
                + "FROM public.\"Cursos\"\n"
                + "WHERE id_curso IN (SELECT id_curso\n"
                + "	FROM public.\"AlumnoCurso\"\n"
                + "	WHERE id_alumno = " + idAlumno + "\n"
                + "	AND id_prd_lectivo = " + idPeriodo + ")";
        PreparedStatement ps = CON.getPSPOOL(sql);
        try {
            ResultSet rs = ps.executeQuery();
            nombres = new ArrayList<>();
            while (rs.next()) {
                String n = rs.getString(1);
                nombres.add(n);
            }
            ps.getConnection().close();
        } catch (SQLException e) {
            M.errorMsg("No se pudo realizar la consulta: " + e.getMessage());
        } finally {
            CON.cerrarCONPS(ps);
        }

        return nombres;
    }

    public String getMatriculasAPagar(int idAlmnCarrera) {
        String msg = "";
        String query = "SELECT  \n"
                + "prd_lectivo_nombre,\n"
                + "matricula_fecha, \n"
                + "matricula_tipo\n"
                + "FROM public.\"Matricula\" m\n"
                + "JOIN public.\"PeriodoLectivo\" pl \n"
                + "ON m.id_prd_lectivo = pl.id_prd_lectivo \n"
                + "WHERE matricula_tipo <> 'ORDINARIA' \n"
                + "AND id_alumno = (\n"
                + " SELECT id_alumno \n"
                + " FROM public.\"AlumnosCarrera\" \n"
                + " WHERE id_almn_carrera = ?\n"
                + ");";
        PreparedStatement ps = CON.getPSPOOL(query);
        try {
            ps.setInt(1, idAlmnCarrera);
            ResultSet res = ps.executeQuery();
            while (res.next()) {
                LocalDateTime lct = res.getTimestamp("matricula_fecha").toLocalDateTime();
                msg += "Periodo: " + res.getString("prd_lectivo_nombre")
                        + "  Fecha: " + lct.getDayOfMonth() + "/"
                        + lct.getMonthValue() + "/"
                        + lct.getYear() + " "
                        + " Tipo matricula: " + res.getString("matricula_tipo") + "\n";
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(
                    null,
                    "No pudimos mapear la respuesta "
                    + "de  matriculas a pagar."
            );
        }
        return msg;
    }

}
