package modelo.alumno;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.carrera.CarreraMD;
import modelo.persona.AlumnoMD;
import utils.CONBD;
import utils.M;

/**
 *
 * @author Johnny
 */
public class AlumnoCarreraBD extends CONBD {

    private static AlumnoCarreraBD ACBD;

    public static AlumnoCarreraBD single() {
        if (ACBD == null) {
            ACBD = new AlumnoCarreraBD();
        }
        return ACBD;
    }

    private static final String BASEQUERY_ALMNCARRERA = "SELECT "
            + "id_almn_carrera, "
            + "ac.id_alumno, "
            + "ac.id_carrera, "
            + "almn_carrera_fecha_registro, "
            + "persona_primer_nombre, "
            + "persona_segundo_nombre, "
            + "persona_primer_apellido, "
            + "persona_segundo_apellido, "
            + "persona_identificacion, "
            + "carrera_codigo, "
            + "p.id_persona  "
            + "FROM public.\"AlumnosCarrera\" ac, "
            + "public.\"Alumnos\" a, "
            + "public.\"Personas\" p, "
            + "public.\"Carreras\" c "
            + "WHERE  a.id_alumno = ac.id_alumno AND "
            + "p.id_persona = a.id_persona AND "
            + "c.id_carrera = ac.id_carrera AND "
            + "carrera_activo = true  ";

    private static final String ENQUERY_ALMNCARRERA = " AND id_almn_carrera NOT IN ("
            + " SELECT id_almn_carrera FROM alumno.\"Retirados\" "
            + ") AND id_almn_carrera NOT IN ("
            + " SELECT id_almn_carrera FROM alumno.\"Egresados\");";

    public boolean guardar(AlumnoCarreraMD ac) {
        String nsql = "INSERT INTO public.\"AlumnosCarrera\"( "
                + "id_alumno, "
                + "id_carrera, "
                + "almn_carrera_fecha_registro"
                + ") VALUES ( "
                + ac.getAlumno().getId_Alumno() + ", "
                + ac.getCarrera().getId() + ", "
                + " now() );";
        return CON.executeNoSQL(nsql);
    }

    public String estaMatriculadoEn(int idAlm) {
        String carrera = "";
        String sql = "SELECT DISTINCT carrera_nombre "
                + "FROM public.\"MallaAlumno\" ma, public.\"AlumnosCarrera\" ac, \n"
                + "public.\"Carreras\" c\n"
                + "WHERE ma.id_almn_carrera = ac.id_almn_carrera\n"
                + "AND ac.id_alumno = " + idAlm + " \n"
                + "AND c.id_carrera = ac.id_carrera\n"
                + "AND malla_almn_estado <> 'C' "
                + "AND malla_almn_estado <> 'X';";
        PreparedStatement ps = CON.getPSPOOL(sql);
        try {
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    carrera = carrera + rs.getString("carrera_nombre") + "\n";
                }
            }
        } catch (SQLException e) {
            M.errorMsg("No consultamos alumnos. " + e.getMessage());
        } finally {
            CON.cerrarCONPS(ps);
        }
        return carrera;
    }

    public String estaMatriculadoEn(int idAlm, int idCarrera) {
        String carrera = "";
        String sql = "SELECT DISTINCT carrera_nombre "
                + "FROM public.\"AlumnosCarrera\" ac, \n"
                + "public.\"Carreras\" c\n"
                + "WHERE c.id_carrera = ac.id_carrera \n"
                + "AND ac.id_alumno = " + idAlm + " \n"
                + "AND c.id_carrera = " + idCarrera + ";";
        PreparedStatement ps = CON.getPSPOOL(sql);
        try {
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    carrera = carrera + rs.getString("carrera_nombre") + "\n";
                }
            }
        } catch (SQLException e) {
            M.errorMsg("No pudimos consultar si esta matriculado. " + e.getMessage());

        } finally {
            CON.cerrarCONPS(ps);
        }
        return carrera;
    }

    public ArrayList<AlumnoCarreraMD> cargarAlumnoCarrera() {
        String sql = BASEQUERY_ALMNCARRERA
                + " AND almn_carrera_activo = true "
                + ENQUERY_ALMNCARRERA;
        return consultarAlumnoCarrera(sql);
    }

    public ArrayList<AlumnoCarreraMD> cargarAlumnoCarreraEliminados() {
        String sql = BASEQUERY_ALMNCARRERA
                + " AND almn_carrera_activo = false "
                + ENQUERY_ALMNCARRERA;
        return consultarAlumnoCarrera(sql);
    }

    /**
     * Consultamos todos los alumnos filtrandolos por una carrera.
     *
     * @param idCarrera
     * @return
     */
    public ArrayList<AlumnoCarreraMD> cargarAlumnoCarreraPorCarrera(int idCarrera) {
        String sql = BASEQUERY_ALMNCARRERA + " AND almn_carrera_activo = true "
                + "AND ac.id_carrera = " + idCarrera + " "
                + ENQUERY_ALMNCARRERA;
        return consultarAlumnoCarrera(sql);
    }

    public ArrayList<AlumnoCarreraMD> buscar(String aguja) {
        String sql = BASEQUERY_ALMNCARRERA + " AND almn_carrera_activo = true  "
                + "AND ( "
                + "	carrera_codigo ILIKE '%" + aguja + "%' OR \n"
                + "	persona_primer_nombre || ' ' || persona_segundo_nombre || ' ' ||\n"
                + "	persona_primer_apellido || ' ' || persona_segundo_apellido\n"
                + "	ILIKE '%" + aguja + "%'\n"
                + "	OR persona_identificacion ILIKE '%" + aguja + "%'\n"
                + ") AND persona_activa = true AND carrera_activo = true "
                + ENQUERY_ALMNCARRERA;
        return consultarAlumnoCarrera(sql);
    }

    public ArrayList<AlumnoCarreraMD> buscarAlumnoCarrera(int idCarrera, String aguja) {
        String sql = BASEQUERY_ALMNCARRERA + " AND almn_carrera_activo = true AND "
                + "ac.id_carrera = " + idCarrera + " AND "
                + "c.id_carrera = ac.id_carrera AND (\n"
                + "	persona_primer_nombre || ' ' || persona_segundo_nombre || ' ' || "
                + "	persona_primer_apellido || ' ' || persona_segundo_apellido ILIKE '%" + aguja + "%' OR\n"
                + "	persona_identificacion ILIKE '%" + aguja + "%') "
                + "AND persona_activa = true AND carrera_activo = true "
                + ENQUERY_ALMNCARRERA;
        return consultarAlumnoCarreraTbl(sql);
    }

    public ArrayList<AlumnoCarreraMD> buscarAlumnoCarreraParaFrm(int idCarrera, String aguja) {
        String sql = "SELECT "
                + "id_almn_carrera, "
                + "ac.id_carrera, "
                + "ac.id_alumno, "
                + "a.id_persona, "
                + "persona_primer_nombre, "
                + "persona_segundo_nombre, "
                + "persona_primer_apellido, "
                + "persona_segundo_apellido, "
                + "persona_identificacion "
                + "FROM public.\"AlumnosCarrera\" ac, "
                + "public.\"Alumnos\" a, "
                + "public.\"Personas\" p "
                + "WHERE a.id_alumno = ac.id_alumno AND\n"
                + "p.id_persona = a.id_persona AND\n"
                + "ac.id_carrera = " + idCarrera + " AND (\n"
                + "	persona_primer_nombre || ' ' || persona_segundo_nombre || ' ' ||\n"
                + "	persona_primer_apellido || ' ' || persona_segundo_apellido ILIKE '%" + aguja + "%' OR "
                + "     persona_primer_nombre || ' ' || persona_primer_apellido ILIKE '%" + aguja + "%' OR \n"
                + "	persona_identificacion ILIKE '%" + aguja + "%') "
                + "AND persona_activa = true "
                + ENQUERY_ALMNCARRERA;
        ArrayList<AlumnoCarreraMD> alms = new ArrayList();
        PreparedStatement ps = CON.getPSPOOL(sql);

        try {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                AlumnoCarreraMD ac = new AlumnoCarreraMD();
                ac.setId(rs.getInt("id_almn_carrera"));
                AlumnoMD al = new AlumnoMD();
                CarreraMD c = new CarreraMD();
                c.setId(rs.getInt("id_carrera"));
                al.setId_Alumno(rs.getInt("id_alumno"));
                al.setIdPersona(rs.getInt("id_persona"));
                al.setPrimerNombre(rs.getString("persona_primer_nombre"));
                al.setSegundoNombre(rs.getString("persona_segundo_nombre"));
                al.setPrimerApellido(rs.getString("persona_primer_apellido"));
                al.setSegundoApellido(rs.getString("persona_segundo_apellido"));
                al.setIdentificacion(rs.getString("persona_identificacion"));
                ac.setCarrera(c);
                ac.setAlumno(al);

                alms.add(ac);
            }
        } catch (SQLException e) {
            M.errorMsg("No pudimos consultar para tabla. " + e.getMessage());
        } finally {
            CON.cerrarCONPS(ps);
        }
        return alms;
    }

    private ArrayList<AlumnoCarreraMD> consultarAlumnoCarrera(String sql) {
        ArrayList<AlumnoCarreraMD> alms = new ArrayList();
        PreparedStatement ps = CON.getPSPOOL(sql);
        try {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                AlumnoCarreraMD ac = obtenerAlumnoCarreraTbl(rs);
                if (ac != null) {
                    alms.add(ac);
                }
            }
        } catch (SQLException e) {
            M.errorMsg("No consultamos alumnos carrera. " + e.getMessage());
        } finally {
            CON.cerrarCONPS(ps);
        }
        return alms;
    }

    private ArrayList<AlumnoCarreraMD> consultarAlumnoCarreraTbl(String sql) {
        ArrayList<AlumnoCarreraMD> alms = new ArrayList();
        PreparedStatement ps = CON.getPSPOOL(sql);

        try {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                AlumnoCarreraMD ac = new AlumnoCarreraMD();
                ac.setId(rs.getInt("id_almn_carrera"));
                AlumnoMD al = new AlumnoMD();
                CarreraMD c = new CarreraMD();
                c.setId(rs.getInt("id_carrera"));
                al.setId_Alumno(rs.getInt("id_alumno"));
                al.setIdPersona(rs.getInt("id_persona"));
                al.setPrimerNombre(rs.getString("persona_primer_nombre"));
                al.setSegundoNombre(rs.getString("persona_segundo_nombre"));
                al.setPrimerApellido(rs.getString("persona_primer_apellido"));
                al.setSegundoApellido(rs.getString("persona_segundo_apellido"));
                al.setIdentificacion(rs.getString("persona_identificacion"));

                ac.setCarrera(c);
                ac.setAlumno(al);

                alms.add(ac);
            }
        } catch (SQLException e) {
            M.errorMsg("No pudimos consultar para tabla. " + e.getMessage());
        } finally {
            CON.cerrarCONPS(ps);
        }
        return alms;
    }

    /**
     * Obtenemos el alumno consultado para cargarlo en una arraylist
     *
     * @param rs
     * @return
     */
    private AlumnoCarreraMD obtenerAlumnoCarreraTbl(ResultSet rs) {
        AlumnoCarreraMD ac = new AlumnoCarreraMD();
        try {
            ac.setId(rs.getInt("id_almn_carrera"));
            AlumnoMD a = new AlumnoMD();
            a.setId_Alumno(rs.getInt("id_alumno"));
            a.setPrimerApellido(rs.getString("persona_primer_apellido"));
            a.setPrimerNombre(rs.getString("persona_primer_nombre"));
            a.setSegundoApellido(rs.getString("persona_segundo_apellido"));
            a.setSegundoNombre(rs.getString("persona_segundo_nombre"));
            a.setIdentificacion(rs.getString("persona_identificacion"));
            ac.setAlumno(a);
            CarreraMD c = new CarreraMD();
            c.setId(rs.getInt("id_carrera"));
            c.setCodigo(rs.getString("carrera_codigo"));
            ac.setCarrera(c);
            ac.setFechaRegistro(rs.getTimestamp("almn_carrera_fecha_registro").toLocalDateTime());
            return ac;
        } catch (SQLException e) {
            System.out.println("No pudimos obtener un alumno");
            return null;
        }
    }

}
