package modelo.carrera;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.ConectarDB;
import modelo.ResourceManager;
import modelo.persona.DocenteBD;
import modelo.persona.DocenteMD;

/**
 *
 * @author arman
 */
public class CarreraBD extends CarreraMD {

    private final ConectarDB conecta;
    private final DocenteBD doc;

    public CarreraBD(ConectarDB conecta) {
        this.conecta = conecta;
        this.doc = new DocenteBD(conecta);
    }

    public void editarCarrera(int idCarrera) {
        String nsql = "UPDATE public.\"Carreras\"\n"
                + "SET id_docente_coordinador=" + getCoordinador().getIdDocente() + ", "
                + "carrera_nombre='" + getNombre() + "', \n"
                + "carrera_codigo='" + getCodigo() + "', carrera_fecha_inicio='" + getFechaInicio() + "', \n"
                + "carrera_modalidad='" + getModalidad() + "'\n"
                + "WHERE id_carrera=" + idCarrera + ";";

        if (conecta.nosql(nsql) == null) {
            JOptionPane.showMessageDialog(null, "Editamos correctamente \n" + getNombre());
        }
    }

    public CarreraMD buscar(int idCarrera) {
        CarreraMD carrera = new CarreraMD();
        String sql = "SELECT id_carrera, id_docente_coordinador, carrera_nombre,"
                + " carrera_codigo, carrera_fecha_inicio, carrera_fecha_fin,"
                + " carrera_modalidad, carrera_activo\n"
                + "FROM public.\"Carreras\" WHERE id_carrera = '" + idCarrera + "';";

        ResultSet rs = conecta.sql(sql);

        try {
            if (rs != null) {
                while (rs.next()) {
                    carrera.setId(rs.getInt("id_carrera"));
                    DocenteMD docen = null;
                    if (!rs.wasNull()) {
                        docen = doc.buscarDocente(rs.getInt("id_docente_coordinador"));
                    }
                    carrera.setCoordinador(docen);
                    carrera.setNombre(rs.getString("carrera_nombre"));

                    carrera.setCodigo(rs.getString("carrera_codigo"));
                    carrera.setFechaInicio(rs.getDate("carrera_fecha_inicio").toLocalDate());

                    if (rs.wasNull()) {
                        carrera.setFechaFin(rs.getDate("carrera_fecha_fin").toLocalDate());
                    } else {
                        carrera.setFechaFin(null);
                    }

                    carrera.setModalidad(rs.getString("carrera_modalidad"));
                }
                return carrera;
            } else {
                System.out.println("No se pudo consultar una carreras");
                return null;
            }
        } catch (SQLException e) {
            System.out.println("No se pudo consultar carreras");
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    public CarreraMD buscarParaReferencia(int idCarrera) {
        CarreraMD carrera = new CarreraMD();
        String sql = "SELECT id_carrera, id_docente_coordinador, carrera_nombre,"
                + " carrera_codigo\n"
                + "FROM public.\"Carreras\" WHERE id_carrera = '" + idCarrera + "';";

        ResultSet rs = conecta.sql(sql);

        try {
            if (rs != null) {
                while (rs.next()) {
                    carrera.setId(rs.getInt("id_carrera"));
                    DocenteMD docen = null;
                    if (!rs.wasNull()) {
                        docen = doc.buscarDocenteParaReferencia(rs.getInt("id_docente_coordinador"));
                    }
                    carrera.setCoordinador(docen);
                    carrera.setNombre(rs.getString("carrera_nombre"));
                    carrera.setCodigo(rs.getString("carrera_codigo"));

                }
                return carrera;
            } else {
                System.out.println("No se pudo consultar una carreras");
                return null;
            }
        } catch (SQLException e) {
            System.out.println("No se pudo consultar carreras");
            System.out.println(e.getMessage());
            return null;
        }
    }

    public ArrayList<CarreraMD> cargarCarreras() {
        ArrayList<CarreraMD> carreras = new ArrayList();
        String sql = "SELECT id_carrera, id_docente_coordinador, carrera_nombre,"
                + " carrera_codigo, carrera_fecha_inicio, carrera_fecha_fin,"
                + " carrera_modalidad\n"
                + "FROM public.\"Carreras\""
                + "WHERE carrera_activo = 'true' order by id_carrera;";

        ResultSet rs = conecta.sql(sql);

        try {
            if (rs != null) {
                while (rs.next()) {
                    CarreraMD carrera = new CarreraMD();

                    carrera.setId(rs.getInt("id_carrera"));
                    DocenteMD docen = null;
                    if (!rs.wasNull()) {
                        docen = doc.buscarDocente(rs.getInt("id_docente_coordinador"));
                    }
                    carrera.setCoordinador(docen);
                    carrera.setNombre(rs.getString("carrera_nombre"));

                    carrera.setCodigo(rs.getString("carrera_codigo"));
                    carrera.setFechaInicio(rs.getDate("carrera_fecha_inicio").toLocalDate());

                    if (rs.wasNull()) {
                        carrera.setFechaFin(rs.getDate("carrera_fecha_fin").toLocalDate());
                    } else {
                        carrera.setFechaFin(null);
                    }

                    carrera.setModalidad(rs.getString("carrera_modalidad"));

                    carreras.add(carrera);
                }
                return carreras;
            } else {
                System.out.println("No se pudo consultar una carreras");
                return null;
            }
        } catch (SQLException e) {
            System.out.println("No se pudo consultar carreras");
            System.out.println(e.getMessage());
            return null;
        }
    }

    public List<String> selectCarreraWhereUsername(String username) {

        String SELECT = "SELECT\n"
                + "DISTINCT \"Carreras\".carrera_nombre\n"
                + "FROM\n"
                + "\"Usuarios\"\n"
                + "INNER JOIN \"Personas\" ON \"Usuarios\".id_persona = \"Personas\".id_persona\n"
                + "INNER JOIN \"Docentes\" ON \"Docentes\".id_persona = \"Personas\".id_persona\n"
                + "INNER JOIN \"DocentesMateria\" ON \"DocentesMateria\".id_docente = \"Docentes\".id_docente\n"
                + "INNER JOIN \"Materias\" ON \"DocentesMateria\".id_materia = \"Materias\".id_materia\n"
                + "INNER JOIN \"Carreras\" ON \"Materias\".id_carrera = \"Carreras\".id_carrera\n"
                + "WHERE\n"
                + "\"Usuarios\".usu_username = '" + username + "'";

        List<String> lista = new ArrayList<>();

        ResultSet rs = ResourceManager.Query(SELECT);

        try {
            while (rs.next()) {

                String paralelo = rs.getString("carrera_nombre");

                lista.add(paralelo);

            }
            rs.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return lista;
    }

}
