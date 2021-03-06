package controlador.notas;

import controlador.Libraries.Middlewares;
import java.util.HashMap;
import java.util.Map;

import vista.notas.VtnNotas;

public class ReportesCTR {

    private final VtnNotas vista;

    private final int idDocente;

    private String modalidad;

    public ReportesCTR(VtnNotas vista, int idDocente, String modalidad) {
        this.vista = vista;
        this.idDocente = idDocente;
        this.modalidad = modalidad;
    }

    public String getModalidad() {
        return modalidad;
    }

    public void setModalidad(String modalidad) {
        this.modalidad = modalidad;
    }

    public void generarReporteCompleto() {

        String nombrePeriodo = vista.getCmbPeriodoLectivo().getSelectedItem().toString();
        String ciclo = vista.getCmbCiclo().getSelectedItem().toString();
        String materia = vista.getCmbAsignatura().getSelectedItem().toString();
        if (getModalidad().equalsIgnoreCase("DUAL")) {

            String path = "/vista/notas/reporteDual/ReporteCompletoDual.jasper";

            Map parametros = new HashMap();

            parametros.put("id_docente", idDocente);
            parametros.put("prd_lectivo_nombre", String.valueOf(nombrePeriodo));
            parametros.put("curso_nombre", ciclo);
            parametros.put("materia_nombre", materia);
            Middlewares.generarReporte(getClass().getResource(path), "Reporte Completo Dual", parametros);

        } else {
            String path = "/vista/notas/reportesPresencial/ReporteCompletoPresencial.jasper";

            Map parametros = new HashMap();

            parametros.put("id_docente", idDocente);
            parametros.put("prd_lectivo_nombre", String.valueOf(nombrePeriodo));
            parametros.put("curso_nombre", ciclo);
            parametros.put("materia_nombre", materia);

            Middlewares.generarReporte(getClass().getResource(path), "Reporte Completo", parametros);

        }

    }

    public void generarReporteMenos70() {
        String nombrePeriodo = vista.getCmbPeriodoLectivo().getSelectedItem().toString();
        String ciclo = vista.getCmbCiclo().getSelectedItem().toString();
        String materia = vista.getCmbAsignatura().getSelectedItem().toString();

        String path = "/vista/notas/reportesPresencial/ReporteMenor70_Presencial.jasper";

        Map parametros = new HashMap();

        parametros.put("id_docente", idDocente);
        parametros.put("prd_lectivo_nombre", String.valueOf(nombrePeriodo));
        parametros.put("curso_nombre", ciclo);
        parametros.put("materia_nombre", materia);

        Middlewares.generarReporte(getClass().getResource(path), "Reporte Menor 70", parametros);
    }

    public void generarReporteEntre70_80() {

        String nombrePeriodo = vista.getCmbPeriodoLectivo().getSelectedItem().toString();
        String ciclo = vista.getCmbCiclo().getSelectedItem().toString();
        String materia = vista.getCmbAsignatura().getSelectedItem().toString();

        String path = "/vista/notas/reportesPresencial/ReporteEntre70y80_Presencial.jasper";

        Map parametros = new HashMap();

        parametros.put("id_docente", idDocente);
        parametros.put("prd_lectivo_nombre", String.valueOf(nombrePeriodo));
        parametros.put("curso_nombre", ciclo);
        parametros.put("materia_nombre", materia);
        Middlewares.generarReporte(getClass().getResource(path), "Reporte Entre 70 y 80", parametros);

    }

    public void generarReporteEntre80_90() {

        String nombrePeriodo = vista.getCmbPeriodoLectivo().getSelectedItem().toString();
        String ciclo = vista.getCmbCiclo().getSelectedItem().toString();
        String materia = vista.getCmbAsignatura().getSelectedItem().toString();

        String path = "/vista/notas/reportesPresencial/ReporteEntre80y90_Presencial.jasper";

        Map parametros = new HashMap();

        parametros.put("id_docente", idDocente);
        parametros.put("prd_lectivo_nombre", String.valueOf(nombrePeriodo));
        parametros.put("curso_nombre", ciclo);
        parametros.put("materia_nombre", materia);

        Middlewares.generarReporte(getClass().getResource(path), "Reporte Entre 80 y 90", parametros);

    }

    public void generarReporteEntre90_100() {

        String nombrePeriodo = vista.getCmbPeriodoLectivo().getSelectedItem().toString();
        String ciclo = vista.getCmbCiclo().getSelectedItem().toString();
        String materia = vista.getCmbAsignatura().getSelectedItem().toString();

        String path = "/vista/notas/reportesPresencial/ReporteEntre90y100_Presencial.jasper";

        Map parametros = new HashMap();

        parametros.put("id_docente", idDocente);
        parametros.put("prd_lectivo_nombre", String.valueOf(nombrePeriodo));
        parametros.put("curso_nombre", ciclo);
        parametros.put("materia_nombre", materia);

        Middlewares.generarReporte(getClass().getResource(path), "Reporte Entre 90 y 100", parametros);

    }

    public void generarReporteInformeFinalTabla() {

        String nombrePeriodo = vista.getCmbPeriodoLectivo().getSelectedItem().toString();
        String ciclo = vista.getCmbCiclo().getSelectedItem().toString();
        String materia = vista.getCmbAsignatura().getSelectedItem().toString();

        String path = "/vista/notas/reporteInformeFinalTablaDT/ReporteInformeFinalTablaDT.jasper";

        Map parametros = new HashMap();

        parametros.put("id_docente", idDocente);
        parametros.put("prd_lectivo_nombre", String.valueOf(nombrePeriodo));
        parametros.put("curso_nombre", ciclo);
        parametros.put("materia_nombre", materia);

        Middlewares.generarReporte(getClass().getResource(path), "Reporte Tabla Final", parametros);

    }

    public void generarReporteInterciclo() {
        String nombrePeriodo = vista.getCmbPeriodoLectivo().getSelectedItem().toString();
        String ciclo = vista.getCmbCiclo().getSelectedItem().toString();
        String materia = vista.getCmbAsignatura().getSelectedItem().toString();

         if (getModalidad().equalsIgnoreCase("DUAL")) {

            String path = "/vista/notas/reporteDual/ReporteIntercicloDual.jasper";

            Map parametros = new HashMap();

            parametros.put("id_docente", idDocente);
            parametros.put("prd_lectivo_nombre", String.valueOf(nombrePeriodo));
            parametros.put("curso_nombre", ciclo);
            parametros.put("materia_nombre", materia);
            Middlewares.generarReporte(getClass().getResource(path), "Reporte Interciclo Dual", parametros);

        } else {
            String path = "/vista/notas/reportesPresencial/ReporteInterciclo.jasper";

            Map parametros = new HashMap();

            parametros.put("id_docente", idDocente);
            parametros.put("prd_lectivo_nombre", String.valueOf(nombrePeriodo));
            parametros.put("curso_nombre", ciclo);
            parametros.put("materia_nombre", materia);

            Middlewares.generarReporte(getClass().getResource(path), "Reporte Interciclo", parametros);

        }
    }

    /* public void ReportePrueba2(){
         String nombrePeriodo = vista.getCmbPeriodoLectivo().getSelectedItem().toString();
        String ciclo = vista.getCmbCiclo().getSelectedItem().toString();
        String materia = vista.getCmbAsignatura().getSelectedItem().toString();

        String path = "/vista/notas/reportesPresencial/Prueba2.jasper";

        Map parametros = new HashMap();

        parametros.put("id_docente", idDocente);
        parametros.put("prd_lectivo_nombre", String.valueOf(nombrePeriodo));
        parametros.put("curso_nombre", ciclo);
        parametros.put("materia_nombre", materia);

        Middlewares.generarReporte(path, "Reporte Prueba 2", parametros);

    }*/
}
