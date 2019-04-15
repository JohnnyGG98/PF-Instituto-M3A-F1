/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.silabo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.ConexionBD;
import modelo.materia.MateriaMD;
import modelo.periodolectivo.PeriodoLectivoMD;

/**
 *
 * @author Andres Ullauri
 */
public class SilaboBD extends SilaboMD {

    private ConexionBD conexion;

    public SilaboBD(ConexionBD conexion) {
        this.conexion = conexion;
    }

    public SilaboBD(ConexionBD conexion, MateriaMD idMateria, PeriodoLectivoMD idPeriodoLectivo) {
        super(idMateria, idPeriodoLectivo);
        this.conexion = conexion;
    }

    public void insertar() {

        try {
            PreparedStatement st = conexion.getCon().prepareStatement("INSERT INTO public.\"Silabo\"(\n"
                    + "	 id_materia, id_prd_lectivo)\n"
                    + "	VALUES (?, ?)");

            st.setInt(1, getIdMateria().getId());
            st.setInt(2, getIdPeriodoLectivo().getId_PerioLectivo());
            st.executeUpdate();
            System.out.println(st);
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(SilaboBD.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    

    public static List<SilaboMD> consultar(ConexionBD conexion, String[] clave) {

        List<SilaboMD> silabos = new ArrayList<>();
        try {

            PreparedStatement st = conexion.getCon().prepareStatement("SELECT DISTINCT id_silabo,\n"
                    + "s.id_materia, m.materia_nombre, m.materia_horas_docencia,m.materia_horas_practicas,m.materia_horas_auto_estudio, estado_silabo,\n"
                    + "pr.id_prd_lectivo, pr.prd_lectivo_fecha_inicio, pr.prd_lectivo_fecha_fin\n"
                    + "FROM \"Silabo\" AS s\n"
                    + "JOIN \"Materias\" AS m ON s.id_materia=m.id_materia\n"
                    + "JOIN \"PeriodoLectivo\" AS pr ON pr.id_prd_lectivo=s.id_prd_lectivo\n"
                    + "JOIN \"Carreras\" AS crr ON crr.id_carrera = m.id_carrera\n"
                    + "JOIN \"Cursos\" AS cr ON cr.id_materia=m.id_materia\n"
                    + "JOIN \"Docentes\" AS d ON d.id_docente= cr.id_docente\n"
                    + "JOIN \"Personas\" AS p ON d.id_persona=p.id_persona\n"
                    + "WHERE crr.carrera_nombre=?\n"
                    + "AND m.materia_nombre ILIKE '%"+clave[1]+"%'\n"
                    + "AND p.id_persona=?");

            st.setString(1, clave[0]);
            st.setInt(2, Integer.parseInt(clave[2]));

            System.out.println(st);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {

                SilaboMD tmp = new SilaboMD();
                tmp.setIdSilabo(rs.getInt(1));
                tmp.getIdMateria().setId(rs.getInt(2));
                tmp.getIdMateria().setNombre(rs.getString(3));
                tmp.getIdMateria().setHorasDocencia(rs.getInt(4));
                tmp.getIdMateria().setHorasPracticas(rs.getInt(5));
                tmp.getIdMateria().setHorasAutoEstudio(rs.getInt(6));
                tmp.setEstadoSilabo(rs.getInt(7));
                tmp.getIdPeriodoLectivo().setId_PerioLectivo(rs.getInt(8));
                tmp.getIdPeriodoLectivo().setFecha_Inicio(rs.getDate(9).toLocalDate());
                tmp.getIdPeriodoLectivo().setFecha_Fin(rs.getDate(10).toLocalDate());

                silabos.add(tmp);
            }

        } catch (SQLException ex) {
            Logger.getLogger(SilaboBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return silabos;
    }

    /*public void eliminar() {

        try {
            PreparedStatement st = conexion.getCon().prepareStatement("DELETE FROM public.\"Silabo\"\n"
                    + "	WHERE id_silabo=?");

            st.setInt(1, getIdSilabo());
            st.executeUpdate();
            System.out.println(st);
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(SilaboBD.class.getName()).log(Level.SEVERE, null, ex);
        }

    }*/

    public void actualizar() {

        try {
            PreparedStatement st = conexion.getCon().prepareStatement("UPDATE public.\"Silabo\"\n"
                    + "	SET id_materia=?, estado_silabo=?, id_prd_lectivo=?\n"
                    + "	WHERE id_silabo=?");

            st.setInt(1, getIdMateria().getId());
            st.setInt(2, getEstadoSilabo());
            st.setInt(3, getIdPeriodoLectivo().getId_PerioLectivo());
            st.setInt(4, getIdSilabo());
            st.executeUpdate();
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(SilaboBD.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public SilaboMD retornaSilabo(int id) {
        SilaboMD silabo = null;
        try {

            PreparedStatement st = conexion.getCon().prepareStatement("SELECT id_silabo, id_materia, id_prd_lectivo, estado_silabo\n"
                    + "FROM public.\"Silabo\"\n"
                    + "WHERE id_silabo =?");
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                silabo = new SilaboMD();

                silabo.setIdSilabo(rs.getInt(1));
            }

        } catch (SQLException ex) {
            Logger.getLogger(dbSilabo.class.getName()).log(Level.SEVERE, null, ex);

        }

        return silabo;
    }
    
   
    
    public void eliminar(SilaboMD s) {

        try {
             PreparedStatement st = conexion.getCon().prepareStatement("DELETE FROM public.\"Silabo\"\n"
                    + "	WHERE id_silabo=?");

            st.setInt(1, s.getIdSilabo());
            
            st.executeUpdate();
            System.out.println(st);
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(SilaboBD.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}