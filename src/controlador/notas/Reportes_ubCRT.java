package controlador.notas;

import controlador.Libraries.Middlewares;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import vista.notas.VtnControlUB;

/**
 *
 * @author Alejandro
 */
public class Reportes_ubCRT {
    private final VtnControlUB vista;

    private final int idDocente;

    public  Reportes_ubCRT(VtnControlUB vista, int idDocente) {
        this.vista = vista;
        this.idDocente = idDocente;
    }
    
    
     public void generarReporteEstadoAlumnos() {

        String nombrePeriodo = vista.getCmbPeriodoLectivo().getSelectedItem().toString();
        String ciclo = vista.getCmbCiclo().getSelectedItem().toString();
        String materia = vista.getCmbAsignatura().getSelectedItem().toString();

        String path = "/vista/notas/reportesUB/ReporteEstadoPresencial.jasper";

        Map parametros = new HashMap();

        parametros.put("id_docente", idDocente);
        parametros.put("prd_lectivo_nombre", String.valueOf(nombrePeriodo));
        parametros.put("curso_nombre", ciclo);
        parametros.put("materia_nombre", materia);
        JOptionPane.showMessageDialog(null, getClass().getResource(path).toString());
          
        Middlewares.generarReporte(getClass().getResource(path), "Reporte Estado Estudiantil", parametros);

    }
     
      public void generarReporteRendimientoInterciclo() {

        String nombrePeriodo = vista.getCmbPeriodoLectivo().getSelectedItem().toString();
        String ciclo = vista.getCmbCiclo().getSelectedItem().toString();
        String materia = vista.getCmbAsignatura().getSelectedItem().toString();

        String path = "/vista/notas/reportesUB/ReporteRendimientoIntercicloPresencial.jasper";

        Map parametros = new HashMap();

        parametros.put("id_docente", idDocente);
        parametros.put("prd_lectivo_nombre", String.valueOf(nombrePeriodo));
        parametros.put("curso_nombre", ciclo);
        parametros.put("materia_nombre", materia);
         JOptionPane.showMessageDialog(null, getClass().getResource(path).toString());
        Middlewares.generarReporte(getClass().getResource(path), "Reporte Rendimiento Interciclo", parametros);

    }
      
     public void generarReporteRendimientoCiclo() {

        String nombrePeriodo = vista.getCmbPeriodoLectivo().getSelectedItem().toString();
        String ciclo = vista.getCmbCiclo().getSelectedItem().toString();
        String materia = vista.getCmbAsignatura().getSelectedItem().toString();

        String path = "/vista/notas/reportesUB/ReporteRendimientoCiclo.jasper";

        Map parametros = new HashMap();

        parametros.put("id_docente", idDocente);
        parametros.put("prd_lectivo_nombre", String.valueOf(nombrePeriodo));
        parametros.put("curso_nombre", ciclo);
        parametros.put("materia_nombre", materia);
         JOptionPane.showMessageDialog(null, getClass().getResource(path).toString());
        Middlewares.generarReporte(getClass().getResource(path), "Reporte Rendimiento Ciclo", parametros);

    }
}
