package modelo;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import com.zaxxer.hikari.pool.HikariPool.PoolInitializationException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Map;
import modelo.propiedades.Propiedades;

/**
 *
 * @author diego
 */
public class ConnDBPool {

    private static HikariConfig config;
    private static HikariDataSource ds;

    private Connection conn;
    private PreparedStatement stmt;
    private ResultSet rs;

    public ConnDBPool() {
    }

    public ConnDBPool(String username, String password) {
        try {

            config = new HikariConfig();
            config.setJdbcUrl(generarURL());

            config.setUsername(username);

            config.setPassword(password);

            config.setMaximumPoolSize(2);
            config.addDataSourceProperty("cachePrepStmts", "true");
            config.addDataSourceProperty("prepStmtCacheSize", "250");
            config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");

            /*
                CONFIG A PROBAR
             */
//            config.addDataSourceProperty("allowMultiQueries", "true");
//            config.addDataSourceProperty("useServerPrepStmts", "true");
            ds = new HikariDataSource(config);
        } catch (PoolInitializationException e) {
        }
    }

    public Connection getConnection() {
        try {
            return ds.getConnection();
        } catch (SQLException e) {
            return null;
        }
    }

    // <editor-fold defaultstate="collapsed" desc="METODOS DE MANEJO DE DATOS"> 
    /*
        Este metodo lee el archivo "configuracion.properties" de la raiz del proyecto
        y genera una URL con los valores que toma del archivo
     */
    private String generarURL() {

        String ip = Propiedades.getPropertie("ip");
        String port = Propiedades.getPropertie("port");
        String database = Propiedades.getPropertie("database");
        return "jdbc:postgresql://" + ip + ":" + port + "/" + database;
    }

    public SQLException ejecutar(String sql, Connection conn, Map<Integer, Object> parametros) {
        //this.conn = conn;
        try {
            if (parametros == null) {
                stmt = conn.prepareStatement(sql);
            } else {
                stmt = prepararStatement(sql, conn, parametros);
            }

            stmt.executeUpdate();

            parametros = null;
//            System.out.println("*******************************************");
//            System.out.println("*PreparedStatement ejecutado correctamente*");
//            System.out.println("*******************************************");
            return null;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            close(conn);
            return e;
        } finally {
            close(conn);
            closeStmt();
        }
    }

    private PreparedStatement prepararStatement(String sql, Connection conn, Map<Integer, Object> parametros) throws SQLException {

        stmt = conn.prepareStatement(sql);

        for (Map.Entry<Integer, Object> entry : parametros.entrySet()) {

            int posicion = entry.getKey();

            if (entry.getValue() instanceof Integer) {
                stmt.setInt(posicion, (int) entry.getValue());
            }

            if (entry.getValue() instanceof String) {
                stmt.setString(posicion, entry.getValue().toString());
            }

            if (entry.getValue() instanceof Double) {
                stmt.setDouble(posicion, (double) entry.getValue());
            }

            if (entry.getValue() instanceof LocalTime) {
                stmt.setTime(posicion, java.sql.Time.valueOf((LocalTime) entry.getValue()));
            }

            if (entry.getValue() instanceof LocalDate) {
                stmt.setDate(posicion, java.sql.Date.valueOf((LocalDate) entry.getValue()));
            }
            if (entry.getValue() instanceof Boolean) {
                stmt.setBoolean(posicion, (boolean) entry.getValue());
            }
            if (entry.getValue() instanceof Boolean) {
                stmt.setBoolean(posicion, (boolean) entry.getValue());
            }

        }

        return stmt;
    }

    public ResultSet ejecutarQuery(String sql, Connection conn, Map<Integer, Object> parametros) {
        try {
            if (parametros == null) {
                stmt = conn.prepareStatement(sql);
            } else {
                stmt = prepararStatement(sql, conn, parametros);
            }
            rs = stmt.executeQuery();

            parametros = null;
//            System.out.println("*******************************");
//            System.out.println("*QUERY Ejecutado Correctamente*");
//            System.out.println("*******************************");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
        return rs;
    }

    public void close(Connection conn) {
        try {
            if (conn != null) {
//                System.out.println("*******************************");
//                System.out.println("*EJECUTANDO CIERRE DE CONEXION*");
//                System.out.println("*******************************");
                conn.close();
//                System.out.println("*******************************");
//                System.out.println("*Conexion cerrada? " + conn.isClosed() + "*");
//                System.out.println("*******************************");

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void close(ResultSet rs) {
        try {
            rs.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void closeStmt() {
        try {
            stmt.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    // </editor-fold>  
    public void closePool() {
        if (ConnDBPool.ds != null && !ConnDBPool.ds.isClosed()) {
            ConnDBPool.ds.close();
        }
    }
}
