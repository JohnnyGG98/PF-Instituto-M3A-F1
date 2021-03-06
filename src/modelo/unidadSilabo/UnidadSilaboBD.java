package modelo.unidadSilabo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.ConnDBPool;

/**
 *
 * @author Andres Ullauri
 */
public class UnidadSilaboBD extends UnidadSilaboMD {

    private static final ConnDBPool CON = ConnDBPool.single();

    public static List<UnidadSilaboMD> consultar(int clave, int tipo) {
        List<UnidadSilaboMD> unidades = new ArrayList<>();

        PreparedStatement st = CON.prepareStatement("SELECT id_unidad, numero_unidad, objetivo_especifico_unidad, resultados_aprendizaje_unidad, contenidos_unidad, fecha_inicio_unidad, fecha_fin_unidad, horas_docencia_unidad, horas_practica_unidad, horas_autonomo_unidad, titulo_unidad\n"
                + "FROM public.\"UnidadSilabo\"\n"
                + "WHERE id_silabo=? ORDER BY numero_unidad");
        try {
            st.setInt(1, clave);
            ResultSet res = st.executeQuery();

            while (res.next()) {

                UnidadSilaboMD u = new UnidadSilaboMD();
                u.setId(res.getInt(1));
                u.setNumeroUnidad(res.getInt(2));
                u.setObjetivoEspecificoUnidad(res.getString(3));
                u.setResultadosAprendizajeUnidad(res.getString(4));
                u.setContenidosUnidad(res.getString(5));
                if (res.getDate(6) != null && tipo == 1) {
                    u.setFechaInicioUnidad(res.getDate(6).toLocalDate());
                }

                if (res.getDate(7) != null && tipo == 1) {
                    u.setFechaFinUnidad(res.getDate(7).toLocalDate());
                }

                u.setHorasDocenciaUnidad(res.getInt(8));
                System.out.println(u.getHorasDocenciaUnidad());
                u.setHorasPracticaUnidad(res.getInt(9));
                System.out.println(u.getHorasPracticaUnidad());
                u.setHorasAutonomoUnidad(res.getInt(10));
                u.setTituloUnidad(res.getString(11));

                unidades.add(u);
            }

        } catch (SQLException ex) {
            Logger.getLogger(UnidadSilaboBD.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            CON.close(st);
        }
        return unidades;
    }

    public static List<UnidadSilaboMD> consultarUnidadesPlanClase(int clave) {

        PreparedStatement st = CON.prepareStatement("SELECT id_unidad, numero_unidad,titulo_unidad,contenidos_unidad\n"
                + "FROM public.\"UnidadSilabo\"\n"
                + "WHERE id_silabo=? ORDER BY numero_unidad");

        List<UnidadSilaboMD> unidades = new ArrayList<>();

        try {

            st.setInt(1, clave);

            System.out.println(st);
            ResultSet res = st.executeQuery();

            while (res.next()) {

                UnidadSilaboMD u = new UnidadSilaboMD();
                u.setId(res.getInt(1));
                u.setNumeroUnidad(res.getInt(2));
                u.setTituloUnidad(res.getString(3));
                u.setContenidosUnidad(res.getString(4));
                unidades.add(u);
            }

        } catch (SQLException ex) {
            Logger.getLogger(UnidadSilaboBD.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            CON.close(st);
        }
        return unidades;
    }

    public static List<UnidadSilaboMD> consultarSilaboUnidades(int silabo, int unidad) {

        List<UnidadSilaboMD> unidades = new ArrayList<>();
        PreparedStatement st = CON.prepareStatement("select u.numero_unidad,u.titulo_unidad,u.fecha_inicio_unidad,u.fecha_fin_unidad,u.horas_docencia_unidad,u.horas_practica_unidad,\n"
                + "u.objetivo_especifico_unidad,u.resultados_aprendizaje_unidad,u.contenidos_unidad\n"
                + "from \"UnidadSilabo\" u join \"Silabo\" s on u.id_silabo=s.id_silabo where s.id_silabo=? and u.numero_unidad=?");

        try {

            st.setInt(1, silabo);
            st.setInt(2, unidad);

            System.out.println(st);
            ResultSet res = st.executeQuery();

            while (res.next()) {

                UnidadSilaboMD tmp = new UnidadSilaboMD();
                tmp.setNumeroUnidad(res.getInt(1));
                tmp.setTituloUnidad(res.getString(2));
                tmp.setFechaInicioUnidad(res.getDate(3).toLocalDate());
                tmp.setFechaFinUnidad(res.getDate(4).toLocalDate());
                tmp.setHorasDocenciaUnidad(res.getInt(5));
                tmp.setHorasPracticaUnidad(res.getInt(6));
                tmp.setObjetivoEspecificoUnidad(res.getString(7));
                tmp.setResultadosAprendizajeUnidad(res.getString(8));
                tmp.setContenidosUnidad(res.getString(9));
                unidades.add(tmp);
            }

        } catch (SQLException ex) {
            Logger.getLogger(UnidadSilaboBD.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            CON.close(st);
        }
        return unidades;
    }

}
