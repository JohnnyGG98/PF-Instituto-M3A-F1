package modelo.usuario;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import utils.CONBD;
import utils.M;

/**
 *
 * @author arman
 */
public class HistorialUsuarioBD extends CONBD {

    private String sql;

    private static HistorialUsuarioBD HUBD;

    public static HistorialUsuarioBD single() {
        if (HUBD == null) {
            HUBD = new HistorialUsuarioBD();
        }
        return HUBD;
    }

    public String getSql() {
        return sql;
    }

    public ArrayList<HistorialUsuarioMD> buscar(String aguja) {
        sql = "SELECT id_historial_user, usu_username, historial_fecha, \n"
                + "historial_tipo_accion, historial_nombre_tabla, historial_pk_tabla\n"
                + "FROM public.\"HistorialUsuarios\"\n"
                + "WHERE usu_username ILIKE '%" + aguja + "%' OR\n"
                + "historial_tipo_accion ILIKE '%" + aguja + "%' OR\n"
                + "historial_nombre_tabla ILIKE '%" + aguja + "%' OR \n"
                + "usu_username || ' ' || historial_tipo_accion ILIKE '%" + aguja + "%' OR\n"
                + "usu_username || ' ' || historial_nombre_tabla ILIKE '%" + aguja + "%';;													;";
        return consultarTbl(sql);
    }

    public ArrayList<HistorialUsuarioMD> cargarHistorialHoy() {
        sql = "SELECT id_historial_user, usu_username, historial_fecha, "
                + "historial_tipo_accion, historial_nombre_tabla, historial_pk_tabla\n"
                + "FROM public.\"HistorialUsuarios\"\n"
                + "WHERE date_part('year', historial_fecha) = date_part('year', now())\n"
                + "AND date_part('month', historial_fecha) = date_part('month', now())\n"
                + "AND date_part('day', historial_fecha) = date_part('day', now());													;";
        return consultarTbl(sql);
    }

    /**
     * Consultamos unicamente por usuario.
     *
     * @param username
     * @return
     */
    public ArrayList<HistorialUsuarioMD> cargarHistorialUser(String username) {
        sql = "SELECT id_historial_user, usu_username, historial_fecha, "
                + "historial_tipo_accion, historial_nombre_tabla, historial_pk_tabla\n"
                + "FROM public.\"HistorialUsuarios\"\n"
                + "WHERE usu_username = '" + username + "';";
        return consultarTbl(sql);
    }

    /**
     * Consultamos el historial unicamente por tabla.
     *
     * @param tabla
     * @return
     */
    public ArrayList<HistorialUsuarioMD> cargarHistorialTbl(String tabla) {
        sql = "SELECT id_historial_user, usu_username, historial_fecha, "
                + "historial_tipo_accion, historial_nombre_tabla, historial_pk_tabla\n"
                + "FROM public.\"HistorialUsuarios\"\n"
                + "WHERE historial_nombre_tabla = '" + tabla + "';";
        return consultarTbl(sql);
    }

    /**
     * Consultamos el historial por tabla y accion;
     *
     * @param tabla String
     * @param accion String
     * @return
     */
    public ArrayList<HistorialUsuarioMD> cargarHistorialTblAccion(String tabla, String accion) {
        sql = "SELECT id_historial_user, usu_username, historial_fecha, "
                + "historial_tipo_accion, historial_nombre_tabla, historial_pk_tabla\n"
                + "FROM public.\"HistorialUsuarios\"\n"
                + "WHERE historial_nombre_tabla = '" + tabla + "' AND \n"
                + "historial_tipo_accion = '" + accion + "';";
        return consultarTbl(sql);
    }

    /**
     * Consultamos el historial de una tabla por accion y fecha
     *
     * @param tabla
     * @param accion
     * @param fecha
     * @return
     */
    public ArrayList<HistorialUsuarioMD> cargarHistorialTblAccionPoFecha(String tabla,
            String accion, String fecha) {
        sql = "SELECT id_historial_user, usu_username, historial_fecha, "
                + "historial_tipo_accion, historial_nombre_tabla, historial_pk_tabla\n"
                + "FROM public.\"HistorialUsuarios\"\n"
                + "WHERE historial_nombre_tabla = '" + tabla + "' AND \n"
                + "historial_tipo_accion = '" + accion + "' AND \n"
                + "historial_fecha::date = TO_DATE('" + fecha + "', 'DD/MM/YYYY');";
        return consultarTbl(sql);
    }

    /**
     * Consultamos el historial de una tabla y accion entre fechas entre fechas
     *
     * @param tabla
     * @param accion
     * @param fecha
     * @param fechaFin
     * @return
     */
    public ArrayList<HistorialUsuarioMD> cargarHistorialTblAccionEntreFecha(String tabla,
            String accion, String fecha, String fechaFin) {
        sql = "SELECT id_historial_user, usu_username, historial_fecha, "
                + "historial_tipo_accion, historial_nombre_tabla, historial_pk_tabla\n"
                + "FROM public.\"HistorialUsuarios\"\n"
                + "WHERE historial_nombre_tabla = '" + tabla + "' AND \n"
                + "historial_tipo_accion = '" + accion + "' AND \n"
                + "historial_fecha::date >= TO_DATE('" + fecha + "', 'DD/MM/YYYY') AND \n"
                + "historial_fecha::date <= TO_DATE('" + fechaFin + "', 'DD/MM/YYYY');";
        return consultarTbl(sql);
    }

    /**
     * Consultamos el historial unicamente por accion.
     *
     * @param accion
     * @return
     */
    public ArrayList<HistorialUsuarioMD> cargarHistorialAccion(String accion) {
        sql = "SELECT id_historial_user, usu_username, historial_fecha, "
                + "historial_tipo_accion, historial_nombre_tabla, historial_pk_tabla\n"
                + "FROM public.\"HistorialUsuarios\"\n"
                + "WHERE historial_tipo_accion = '" + accion + "';";
        return consultarTbl(sql);
    }

    /**
     * Consultamos las acciones por fecha
     *
     * @param accion
     * @param fecha
     * @return
     */
    public ArrayList<HistorialUsuarioMD> cargarHistorialAccionPorFecha(String accion, String fecha) {
        sql = "SELECT id_historial_user, usu_username, historial_fecha, "
                + "historial_tipo_accion, historial_nombre_tabla, historial_pk_tabla\n"
                + "FROM public.\"HistorialUsuarios\"\n"
                + "WHERE historial_tipo_accion = '" + accion + "' AND \n"
                + "historial_fecha::date = TO_DATE('" + fecha + "', 'DD/MM/YYYY');";
        return consultarTbl(sql);
    }

    /**
     * Consultamos acciones entre fechas
     *
     * @param accion
     * @param fechaIni
     * @param fechaFin
     * @return
     */
    public ArrayList<HistorialUsuarioMD> cargarHistorialAccionEntreFechas(String accion,
            String fechaIni, String fechaFin) {
        sql = "SELECT id_historial_user, usu_username, historial_fecha, "
                + "historial_tipo_accion, historial_nombre_tabla, historial_pk_tabla\n"
                + "FROM public.\"HistorialUsuarios\"\n"
                + "WHERE historial_tipo_accion = '" + accion + "' AND \n"
                + "historial_fecha::date >= TO_DATE('" + fechaIni + "', 'DD/MM/YYYY') AND \n"
                + "historial_fecha::date <= TO_DATE('" + fechaFin + "', 'DD/MM/YYYY');";
        return consultarTbl(sql);
    }

    public ArrayList<HistorialUsuarioMD> cargarHistorialFecha(String fecha) {
        sql = "SELECT id_historial_user, usu_username, historial_fecha, "
                + "historial_tipo_accion, historial_nombre_tabla, historial_pk_tabla\n"
                + "FROM public.\"HistorialUsuarios\"\n"
                + "WHERE historial_fecha::date = TO_DATE('" + fecha + "', 'DD/MM/YYYY');";
        return consultarTbl(sql);
    }

    public ArrayList<HistorialUsuarioMD> cargarHistorialEntreFechas(String fechaIni, String fechaFin) {
        sql = "SELECT id_historial_user, usu_username, historial_fecha, "
                + "historial_tipo_accion, historial_nombre_tabla, historial_pk_tabla\n"
                + "FROM public.\"HistorialUsuarios\"\n"
                + "WHERE historial_fecha::date >= TO_DATE('" + fechaIni + "', 'DD/MM/YYYY') AND\n"
                + "historial_fecha::date <= TO_DATE('" + fechaFin + "', 'DD/MM/YYYY');";
        return consultarTbl(sql);
    }

    public ArrayList<HistorialUsuarioMD> cargarHistorialUserPorFecha(String username, String fecha) {
        sql = "SELECT id_historial_user, usu_username, historial_fecha, "
                + "historial_tipo_accion, historial_nombre_tabla, historial_pk_tabla\n"
                + "FROM public.\"HistorialUsuarios\"\n"
                + "WHERE historial_fecha::date = TO_DATE('" + fecha + "', 'DD/MM/YYYY') AND \n"
                + "usu_username = '" + username + "' ;";
        return consultarTbl(sql);
    }

    public ArrayList<HistorialUsuarioMD> cargarHistorialUserTabla(String username, String tabla) {
        sql = "SELECT id_historial_user, usu_username, historial_fecha, "
                + "historial_tipo_accion, historial_nombre_tabla, historial_pk_tabla\n"
                + "FROM public.\"HistorialUsuarios\"\n"
                + "WHERE usu_username = '" + username + "' AND \n"
                + "historial_nombre_tabla = '" + tabla + "';";
        return consultarTbl(sql);
    }

    /**
     * Consultamos el historial de un usuario en una tabla por fecha
     *
     * @param username
     * @param tabla
     * @param fecha
     * @return
     */
    public ArrayList<HistorialUsuarioMD> cargarHistorialUserTablaPorFecha(String username, String tabla, String fecha) {
        sql = "SELECT id_historial_user, usu_username, historial_fecha, "
                + "historial_tipo_accion, historial_nombre_tabla, historial_pk_tabla\n"
                + "FROM public.\"HistorialUsuarios\"\n"
                + "WHERE usu_username = '" + username + "' AND \n"
                + "historial_nombre_tabla = '" + tabla + "' AND \n"
                + "historial_fecha::date = TO_DATE('" + fecha + "', 'DD/MM/YYYY');";
        return consultarTbl(sql);
    }

    /**
     * Consultamos el historial de un usuario en una tabla entre fechas
     *
     * @param username
     * @param tabla
     * @param fechaIni
     * @param fechaFin
     * @return
     */
    public ArrayList<HistorialUsuarioMD> cargarHistorialUserTablaEntreFechas(String username,
            String tabla, String fechaIni, String fechaFin) {
        sql = "SELECT id_historial_user, usu_username, historial_fecha, "
                + "historial_tipo_accion, historial_nombre_tabla, historial_pk_tabla\n"
                + "FROM public.\"HistorialUsuarios\"\n"
                + "WHERE usu_username = '" + username + "' AND \n"
                + "historial_nombre_tabla = '" + tabla + "' AND \n"
                + "historial_fecha::date >= TO_DATE('" + fechaIni + "', 'DD/MM/YYYY') AND \n"
                + "historial_fecha::date <= TO_DATE('" + fechaFin + "', 'DD/MM/YYYY');";
        return consultarTbl(sql);
    }

    /**
     * Consultamos el historial de un usuario por accion.
     *
     * @param username
     * @param accion
     * @return
     */
    public ArrayList<HistorialUsuarioMD> cargarHistorialUserAccion(String username, String accion) {
        sql = "SELECT id_historial_user, usu_username, historial_fecha, "
                + "historial_tipo_accion, historial_nombre_tabla, historial_pk_tabla\n"
                + "FROM public.\"HistorialUsuarios\"\n"
                + "WHERE usu_username = '" + username + "' AND \n"
                + "historial_tipo_accion = '" + accion + "';";
        return consultarTbl(sql);
    }

    /**
     * Consultamos el historial de un usuario por accion y fecha
     *
     * @param username
     * @param accion
     * @param fecha
     * @return
     */
    public ArrayList<HistorialUsuarioMD> cargarHistorialUserAccionPorFecha(String username, String accion,
            String fecha) {
        sql = "SELECT id_historial_user, usu_username, historial_fecha, "
                + "historial_tipo_accion, historial_nombre_tabla, historial_pk_tabla\n"
                + "FROM public.\"HistorialUsuarios\"\n"
                + "WHERE usu_username = '" + username + "' AND \n"
                + "historial_tipo_accion = '" + accion + "' AND \n"
                + "historial_fecha::date = TO_DATE('" + fecha + "', 'DD/MM/YYYY');";
        return consultarTbl(sql);
    }

    public ArrayList<HistorialUsuarioMD> cargarHistorialUserAccionEntreFechas(String username, String accion,
            String fechaIni, String fechaFin) {
        sql = "SELECT id_historial_user, usu_username, historial_fecha, "
                + "historial_tipo_accion, historial_nombre_tabla, historial_pk_tabla\n"
                + "FROM public.\"HistorialUsuarios\"\n"
                + "WHERE usu_username = '" + username + "' AND \n"
                + "historial_tipo_accion = '" + accion + "' AND \n"
                + "historial_fecha::date >= TO_DATE('" + fechaIni + "', 'DD/MM/YYYY') AND \n"
                + "historial_fecha::date <= TO_DATE('" + fechaFin + "', 'DD/MM/YYYY');";
        return consultarTbl(sql);
    }

    public ArrayList<HistorialUsuarioMD> cargarHistorialUserEntreFechas(String username, String fechaIni, String fechaFin) {
        sql = "SELECT id_historial_user, usu_username, historial_fecha, "
                + "historial_tipo_accion, historial_nombre_tabla, historial_pk_tabla\n"
                + "FROM public.\"HistorialUsuarios\"\n"
                + "WHERE historial_fecha::date >= TO_DATE('" + fechaIni + "', 'DD/MM/YYYY') AND\n"
                + "historial_fecha::date <= TO_DATE('" + fechaFin + "', 'DD/MM/YYYY') AND \n"
                + "usu_username = '" + username + "' ;";
        return consultarTbl(sql);
    }

    public ArrayList<HistorialUsuarioMD> cargarHistorialUserTablaAccion(String username, String tabla, String accion) {
        sql = "SELECT id_historial_user, usu_username, historial_fecha, "
                + "historial_tipo_accion, historial_nombre_tabla, historial_pk_tabla\n"
                + "FROM public.\"HistorialUsuarios\"\n"
                + "WHERE usu_username = '" + username + "' AND \n"
                + "historial_nombre_tabla = '" + tabla + "' AND \n"
                + "historial_tipo_accion = '" + accion + "' ;";
        return consultarTbl(sql);
    }

    /**
     * Consultamos el historial de usuarios de una tabla una accion y entre
     * fechas
     *
     * @param username
     * @param tabla
     * @param accion
     * @param fecha
     * @return
     */
    public ArrayList<HistorialUsuarioMD> cargarHistorialUserTablaAccionPorFecha(String username,
            String tabla, String accion, String fecha) {
        sql = "SELECT id_historial_user, usu_username, historial_fecha, "
                + "historial_tipo_accion, historial_nombre_tabla, historial_pk_tabla\n"
                + "FROM public.\"HistorialUsuarios\"\n"
                + "WHERE usu_username = '" + username + "' AND \n"
                + "historial_nombre_tabla = '" + tabla + "' AND \n"
                + "historial_tipo_accion = '" + accion + "' AND \n"
                + "historial_fecha::date = TO_DATE('" + fecha + "', 'DD/MM/YYYY');";
        return consultarTbl(sql);
    }

    /**
     * Cargamos el historial de un usuario en una tabla con una accion y entre
     * fechas.
     *
     * @param username
     * @param tabla
     * @param accion
     * @param fechaIni
     * @param fechaFin
     * @return
     */
    public ArrayList<HistorialUsuarioMD> cargarHistorialUserTablaAccionEntreFechas(String username,
            String tabla, String accion, String fechaIni, String fechaFin) {
        sql = "SELECT id_historial_user, usu_username, historial_fecha, "
                + "historial_tipo_accion, historial_nombre_tabla, historial_pk_tabla\n"
                + "FROM public.\"HistorialUsuarios\"\n"
                + "WHERE usu_username = '" + username + "' AND \n"
                + "historial_nombre_tabla = '" + tabla + "' AND \n"
                + "historial_tipo_accion = '" + accion + "' AND \n"
                + "historial_fecha::date >= TO_DATE('" + fechaIni + "', 'DD/MM/YYYY') AND \n"
                + "historial_fecha::date <= TO_DATE('" + fechaFin + "', 'DD/MM/YYYY');";
        return consultarTbl(sql);
    }

    private ArrayList<HistorialUsuarioMD> consultarTbl(String sql) {
        ArrayList<HistorialUsuarioMD> historial = new ArrayList();
        PreparedStatement ps = CON.getPSPOOL(sql);

        try {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HistorialUsuarioMD h = new HistorialUsuarioMD();
                h.setId(rs.getInt("id_historial_user"));
                h.setNombreTbl(rs.getString("historial_nombre_tabla"));
                h.setFechaAccion(rs.getTimestamp("historial_fecha").toLocalDateTime());
                h.setPkTbl(rs.getInt("historial_pk_tabla"));
                h.setTipoAccion(rs.getString("historial_tipo_accion"));
                h.setUsername(rs.getString("usu_username"));

                historial.add(h);
            }

        } catch (SQLException e) {
            M.errorMsg("No se pudo consultar historial. " + e.getMessage());
        } finally {
            CON.cerrarCONPS(ps);
        }
        return historial;

    }

    public ArrayList<String> cargarAcciones() {
        sql = "SELECT DISTINCT historial_tipo_accion\n"
                + "FROM public.\"HistorialUsuarios\";";
        return cargarClm(sql);
    }

    public ArrayList<String> cargarTablas() {
        sql = "SELECT DISTINCT historial_nombre_tabla\n"
                + "FROM public.\"HistorialUsuarios\";";
        return cargarClm(sql);
    }

    public ArrayList<String> cargarUsuarios() {
        sql = "SELECT DISTINCT usu_username\n"
                + "FROM public.\"HistorialUsuarios\";";
        return cargarClm(sql);
    }

    public ArrayList<String> cargarFechas() {
        sql = "SELECT DISTINCT \n"
                + "date_part('day', historial_fecha) || '/' ||\n"
                + "date_part('month', historial_fecha) || '/' ||\n"
                + "date_part('year', historial_fecha)\n"
                + "FROM public.\"HistorialUsuarios\"\n"
                + "ORDER BY 1 DESC;";
        return cargarClm(sql);
    }

    private ArrayList<String> cargarClm(String sql) {
        ArrayList<String> acciones = new ArrayList();
        PreparedStatement ps = CON.getPSPOOL(sql);
        try {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                //Nos devuelve la primera columna 
                String a = rs.getString(1);
                acciones.add(a);
            }
        } catch (SQLException e) {
            M.errorMsg("No se pudo consultar historial. " + e.getMessage());
        } finally {
            CON.cerrarCONPS(ps);
        }
        return acciones;
    }

    public String buscarObservacion(int idHistorial) {
        sql = "SELECT hitorial_observacion\n"
                + "FROM public.\"HistorialUsuarios\" \n"
                + "WHERE id_historial_user = " + idHistorial + ";";
        String a = "";
        PreparedStatement ps = CON.getPSPOOL(sql);
        try {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                a = rs.getString("hitorial_observacion");
            }
        } catch (SQLException e) {
            M.errorMsg("No se pudo consultar historial. " + e.getMessage());
        } finally {
            CON.cerrarCONPS(ps);
        }
        return a;
    }
}
