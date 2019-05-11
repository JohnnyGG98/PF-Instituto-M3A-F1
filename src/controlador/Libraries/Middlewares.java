package controlador.Libraries;

import java.io.File;
import java.net.URL;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
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
    static JasperReport prueba;

    public static void generarReporte(URL path, String tituloVentana, Map parametros) {
        try {
//            (JasperReport) JRLoader.loadObject();

            JasperReport jasper = (JasperReport) JRLoader.loadObject(path);

            System.out.println("PATH ---------->" + path);

            JasperPrint print = JasperFillManager.fillReport(jasper, parametros, ResourceManager.getConnection());

            JasperViewer view = new JasperViewer(print, false);

            view.setTitle(tituloVentana);

            view.setVisible(true);

        } catch (JRException | SQLException ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage());
            JOptionPane.showMessageDialog(null, "PATH\n" + path);
            JOptionPane.showMessageDialog(null, "PATH PROYECTO" + getProjectPath());
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
}
