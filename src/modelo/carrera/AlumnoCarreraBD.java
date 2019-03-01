package modelo.carrera;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.ConectarDB;
import modelo.persona.AlumnoBD;
import modelo.persona.AlumnoMD;

/**
 *
 * @author Johnny
 */
public class AlumnoCarreraBD extends AlumnoCarreraMD {

    ConectarDB conecta = new ConectarDB("Alumno carrera");
    //Para consulta alumno 
    AlumnoBD alm = new AlumnoBD();
    //Para consultar carreras  
    CarreraBD car = new CarreraBD();

    public void guardar() {
        String nsql = "INSERT INTO public.\"AlumnosCarrera\"(\n"
                + "	id_alumno, id_carrera)\n"
                + "	VALUES (" + getAlumno().getId_Alumno() + ", " + getCarrera().getId() + ");";
        if (conecta.nosql(nsql) == null) {
            System.out.println("Guardamos correctamente el alumno en la carrera");
        }
    }

    public AlumnoCarreraMD buscarAlumnoCarrera(int idAlmCarrera) {
        AlumnoCarreraMD ac = null;
        String sql = "SELECT id_almn_carrera, id_alumno, id_carrera\n"
                + "	FROM public.\"AlumnosCarrera\" WHERE almn_carrera_activo = 'true' "
                + "AND id_almn_carrera = " + idAlmCarrera + ";";
        ResultSet rs = conecta.sql(sql);
        try {
            if (rs != null) {
                while (rs.next()) {
                    ac = obtenerAlumnoCarrera(rs);
                }
                return ac;
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("No pudimos consultar un alumno");
            System.out.println(e.getMessage());
            return null;
        }
    }

    public ArrayList<AlumnoCarreraMD> cargarAlumnoCarrera() {
        ArrayList<AlumnoCarreraMD> alms = new ArrayList();
        String sql = "SELECT id_almn_carrera, id_alumno, id_carrera\n"
                + "	FROM public.\"AlumnosCarrera\" WHERE almn_carrera_activo = 'true';";
        ResultSet rs = conecta.sql(sql);
        try {
            if (rs != null) {
                while (rs.next()) {
                    AlumnoCarreraMD ac = obtenerAlumnoCarrera(rs);
                    if (ac != null) {
                        alms.add(ac);
                    }
                }
                return alms;
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("No pudimos consultar alumnos");
            System.out.println(e.getMessage());
            return null;
        }
    }

    private AlumnoCarreraMD obtenerAlumnoCarrera(ResultSet rs) {
        AlumnoCarreraMD ac = new AlumnoCarreraMD();
        try {
            ac.setId(rs.getInt("id_almn_carrera"));
            AlumnoMD a = alm.buscarAlumno(rs.getInt("id_alumno"));
            ac.setAlumno(a);
            CarreraMD c = car.buscar(rs.getInt("id_carrera"));
            ac.setCarrera(c);
            return ac;
        } catch (SQLException e) {
            System.out.println("No pudimos obtener un alumno");
            return null;
        }
    }
}
