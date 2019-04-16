/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.unidadSilabo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.ConexionBD;
import modelo.evaluacionSilabo.EvaluacionSilabo;
import modelo.silabo.Silabo;
import modelo.silabo.SilaboMD;

/**
 *
 * @author Andres Ullauri
 */
public class UnidadSilaboBD extends UnidadSilaboMD {

    private ConexionBD conexion;

    public UnidadSilaboBD(ConexionBD conexion) {
        this.conexion = conexion;
    }

    public UnidadSilaboBD(ConexionBD conexion, int numeroUnidad, String tituloUnidad, LocalDate fechaInicioUnidad, LocalDate fechaFinUnidad, String objetivoEspecificoUnidad, String resultadosAprendizajeUnidad, String contenidosUnidad, int horasDocenciaUnidad, int horasPracticaUnidad, int horasAutonomoUnidad) {
        super(numeroUnidad, tituloUnidad, fechaInicioUnidad, fechaFinUnidad, objetivoEspecificoUnidad, resultadosAprendizajeUnidad, contenidosUnidad, horasDocenciaUnidad, horasPracticaUnidad, horasAutonomoUnidad);
        this.conexion = conexion;
    }

    public void insertar(UnidadSilaboMD u) {

        try {
            PreparedStatement st = conexion.getCon().prepareStatement("INSERT INTO public.\"UnidadSilabo\"(\n"
                    + "	 numero_unidad, objetivo_especifico_unidad, resultados_aprendizaje_unidad, contenidos_unidad, fecha_inicio_unidad, fecha_fin_unidad, horas_docencia_unidad, horas_practica_unidad, horas_autonomo_unidad, id_silabo, titulo_unidad)\n"
                    + "	VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, (SELECT MAX(id_silabo) FROM \"Silabo\"), ?)");

            st.setInt(1, u.getNumeroUnidad());
            st.setString(2, u.getObjetivoEspecificoUnidad());
            st.setString(3, u.getResultadosAprendizajeUnidad());
            st.setString(4, u.getContenidosUnidad());
            st.setDate(5, java.sql.Date.valueOf(u.getFechaInicioUnidad()));
            st.setDate(6, java.sql.Date.valueOf(u.getFechaFinUnidad()));
            st.setInt(7, u.getHorasDocenciaUnidad());
            st.setInt(8, u.getHorasPracticaUnidad());
            st.setInt(9, u.getHorasAutonomoUnidad());

            st.setString(10, u.getTituloUnidad());

            st.executeUpdate();
            System.out.println(st);
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(UnidadSilaboBD.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static List<UnidadSilaboMD> consultar(ConexionBD conexion, int clave) {

        List<UnidadSilaboMD> unidades = new ArrayList<>();
        try {

            PreparedStatement st = conexion.getCon().prepareStatement("SELECT id_unidad, numero_unidad, objetivo_especifico_unidad, resultados_aprendizaje_unidad, contenidos_unidad, fecha_inicio_unidad, fecha_fin_unidad, horas_docencia_unidad, horas_practica_unidad, horas_autonomo_unidad, titulo_unidad\n"
                    + "FROM public.\"UnidadSilabo\"\n"
                    + "WHERE id_silabo=?");

            st.setInt(1, clave);

            System.out.println(st);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {

                UnidadSilaboMD tmp = new UnidadSilaboMD();
                tmp.setIdUnidad(rs.getInt(1));
                tmp.setNumeroUnidad(rs.getInt(2));
                tmp.setObjetivoEspecificoUnidad(rs.getString(3));
                tmp.setResultadosAprendizajeUnidad(rs.getString(4));
                tmp.setContenidosUnidad(rs.getString(5));
                tmp.setFechaInicioUnidad(rs.getDate(6).toLocalDate());
                tmp.setFechaFinUnidad(rs.getDate(7).toLocalDate());
                tmp.setHorasDocenciaUnidad(rs.getInt(8));
                System.out.println(tmp.getHorasDocenciaUnidad());
                tmp.setHorasPracticaUnidad(rs.getInt(9));
                System.out.println(tmp.getHorasPracticaUnidad());
                tmp.setHorasAutonomoUnidad(rs.getInt(10));
                tmp.setTituloUnidad(rs.getString(11));

                unidades.add(tmp);
            }

        } catch (SQLException ex) {
            Logger.getLogger(UnidadSilaboBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return unidades;
    }

    public void actualizar(UnidadSilaboMD u) {

        try {
            PreparedStatement st = conexion.getCon().prepareStatement("UPDATE public.\"UnidadSilabo\"\n"
                    + "	SET objetivo_especifico_unidad=?, resultados_aprendizaje_unidad=?, contenidos_unidad=?, fecha_inicio_unidad=?, fecha_fin_unidad=?, horas_docencia_unidad=?, horas_practica_unidad=?, horas_autonomo_unidad=?, titulo_unidad=?\n"
                    + "	WHERE id_unidad=?");

            st.setString(1, u.getObjetivoEspecificoUnidad());
            st.setString(2, u.getResultadosAprendizajeUnidad());
            st.setString(3, u.getContenidosUnidad());
            st.setDate(4, java.sql.Date.valueOf(u.getFechaInicioUnidad()));
            st.setDate(5, java.sql.Date.valueOf(u.getFechaFinUnidad()));
            st.setInt(6, u.getHorasDocenciaUnidad());
            st.setInt(7, u.getHorasPracticaUnidad());
            st.setInt(8, u.getHorasAutonomoUnidad());
            st.setString(9, u.getTituloUnidad());
            st.setInt(10, u.getIdUnidad());
            st.executeUpdate();
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(UnidadSilaboBD.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public void eliminar(UnidadSilaboMD u) {

        try {
             PreparedStatement st = conexion.getCon().prepareStatement("DELETE FROM public.\"UnidadSilabo\"\n"
                    + "	WHERE id_unidad=?");

            st.setInt(1, u.getIdUnidad());
            
            st.executeUpdate();
            System.out.println(st);
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(UnidadSilaboBD.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
