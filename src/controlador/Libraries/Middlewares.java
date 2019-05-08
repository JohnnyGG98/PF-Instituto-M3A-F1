package controlador.Libraries;

import java.io.File;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;
import modelo.ResourceManager;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author MrRainx
 */
public final class Middlewares {

    /**
     *
     * @param path direccion del reporte
     * @param QUERY Sentencia SQL con la que se generara el reporte
     * @param tituloVentana Titulo de la ventana del ReporViewer
     */
    public static void generarReporteDefault(String path, String QUERY, String tituloVentana) {
        try {

            Map parameter = new HashMap();

            parameter.put("consulta", QUERY);

            JasperReport jasper = (JasperReport) JRLoader.loadObjectFromFile(path);

            JasperPrint print = JasperFillManager.fillReport(jasper, parameter, ResourceManager.getConnection());

            JasperViewer view = new JasperViewer(print, false);

            view.setTitle(tituloVentana);

            view.setVisible(true);

        } catch (JRException | SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     *
     * @param path direccion del reporte
     * @param tituloVentana Titulo de la ventana del ReporViewer
     * @param parametros
     */
    public static void generarReporte(String path, String tituloVentana, Map parametros) {
        try {

            JasperReport jasper = (JasperReport) JRLoader.loadObjectFromFile(path);

            JasperPrint print = JasperFillManager.fillReport(jasper, parametros, ResourceManager.getConnection());

            JasperViewer view = new JasperViewer(print, false);

            view.setTitle(tituloVentana);

            view.setVisible(true);

        } catch (JRException | SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static String getProjectPath() {
        String path = new File(".").getAbsolutePath();
        return path.substring(0, path.length() - 1);
    }

    public static double conversor(String texto) {
        return Math.round(Double.valueOf(texto) * 10) / 10d;
    }

    public static String capitalize(String texto) {
        if (texto.length() > 1) {
            return texto.substring(0, 1).toUpperCase() + texto.substring(1).toLowerCase();
        } else {
            return texto.toUpperCase();
        }
    }
}
