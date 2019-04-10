package controlador.notas;

import controlador.Libraries.Effects;
import java.awt.event.ActionEvent;
import static java.lang.Thread.sleep;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.ResourceManager;
import modelo.alumno.AlumnoCursoBD;
import modelo.persona.DocenteBD;
import modelo.persona.DocenteMD;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
import vista.notas.VtnNotasAlumnoCurso;
import vista.principal.VtnPrincipal;

public class ReportesCTR {

    private final VtnPrincipal desktop;
    private final VtnNotasAlumnoCurso vista;

    Thread thread = null;

    public ReportesCTR(VtnPrincipal desktop, VtnNotasAlumnoCurso vista) {
        this.desktop = desktop;
        this.vista = vista;
    }



    public void generarReporteCompleto(int idDocente,String nombrePeriodo, int ciclo,String paralelo, String nombreJornada ) {
        try {
//            String nombrePeriodo = vista.getCmbPeriodoLectivo().getSelectedItem().toString();
//            String ciclo = vista.getCmbCiclo().getSelectedItem().toString();
//            String paralelo = vista.getCmbParalelo().getSelectedItem().toString();
//            String nombreJornada = vista.getCmbJornada().getSelectedItem().toString();

            String path = Effects.getProjectPath() + "src\\vista\\notas\\Reportes\\ReporteCompleto.jrxml";
            String QUERY = "SELECT\n"
                    + "	\"Alumnos\".id_alumno,\n"
                    + "	p_alu.persona_identificacion,\n"
                    + "	p_alu.persona_primer_apellido || ' ' ||p_alu.persona_segundo_apellido as \"APELLIDOS\",\n"
                    + "	p_alu.persona_primer_nombre || ' ' || p_alu.persona_segundo_nombre AS \"NOMBRES\",\n"
                    + "	ROUND(\"AlumnoCurso\".almn_curso_nt_1_parcial, 1) AS \"APORTE 1\",\n"
                    + "	ROUND(\"AlumnoCurso\".almn_curso_nt_examen_interciclo, 1) AS \"INTERCICLO\",\n"
                    + "	ROUND(\"AlumnoCurso\".almn_curso_nt_2_parcial, 1) AS \"APORTE 2\",\n"
                    + "	ROUND(\"AlumnoCurso\".almn_curso_nt_examen_final, 1) AS \"EXAMEN FINAL\",\n"
                    + "	ROUND(\"AlumnoCurso\".almn_curso_nt_examen_supletorio, 1) AS \"SUPLETORIO\",\n"
                    + "	\"AlumnoCurso\".almn_curso_asistencia,\n"
                    + "	ROUND(\"AlumnoCurso\".almn_curso_nota_final, 0) AS \"NOTA FINAL\",\n"
                    + "	\"AlumnoCurso\".almn_curso_estado,\n"
                    + "	\"AlumnoCurso\".almn_curso_num_faltas,\n"
                    + "	\"Materias\".materia_nombre, \n"
                    + "	\"Jornadas\".nombre_jornada,\n"
                    + "	\"Materias\".materia_ciclo,\n"
                    + "	\"Cursos\".curso_paralelo,\n"
                    + "	\"Carreras\".carrera_nombre,\n"
                    + "	\"PeriodoLectivo\".prd_lectivo_nombre,\n"
                    + "	\"Personas\".persona_primer_nombre || ' ' ||\"Personas\".persona_segundo_nombre as \"NOMBRE_PROF\",\n"
                    + "	\"Personas\".persona_primer_apellido || ' ' ||\"Personas\".persona_segundo_apellido as \"APELLIDO_PROF\",\n"
                    + "	(\"AlumnoCurso\".almn_curso_num_faltas * 100)/\"Materias\".materia_total_horas as \"% Faltas\",\n"
                    + "  per_coor.persona_primer_apellido || ' ' || per_coor.persona_segundo_apellido as \"APELLIDOS_COORDINADOR\",\n"
                    + "  per_coor.persona_primer_nombre || ' ' ||per_coor.persona_segundo_nombre AS \"NOMBRES_COORDINADOR\"\n"
                    + "	\n"
                    + "FROM\n"
                    + "	\"AlumnoCurso\"\n"
                    + "	INNER JOIN \"Cursos\" ON \"AlumnoCurso\".id_curso = \"Cursos\".id_curso\n"
                    + "	INNER JOIN \"Jornadas\" ON \"Cursos\".id_jornada = \"Jornadas\".id_jornada\n"
                    + "	INNER JOIN \"Materias\" ON \"Cursos\".id_materia = \"Materias\".id_materia\n"
                    + "	INNER JOIN \"PeriodoLectivo\" ON \"Cursos\".id_prd_lectivo = \"PeriodoLectivo\".id_prd_lectivo\n"
                    + "	INNER JOIN \"Alumnos\" ON \"AlumnoCurso\".id_alumno = \"Alumnos\".id_alumno\n"
                    + "	INNER JOIN \"Personas\" p_alu ON \"Alumnos\".id_persona = p_alu.id_persona\n"
                    + "	INNER JOIN \"Docentes\" ON \"public\".\"Cursos\".id_docente = \"public\".\"Docentes\".id_docente\n"
                    + "	INNER JOIN \"Carreras\" ON \"public\".\"Carreras\".id_carrera = \"public\".\"Materias\".id_carrera\n"
                    + "	INNER JOIN \"Personas\" ON \"public\".\"Personas\".id_persona= \"public\".\"Docentes\".id_persona\n"
                    + "  INNER JOIN \"Docentes\" doc_coor ON doc_coor.id_docente = \"public\".\"Carreras\".id_docente_coordinador\n"
                    + "  INNER JOIN \"Personas\" per_coor ON per_coor.id_persona = doc_coor.id_persona"
                    + "	WHERE\n"
                    + "	\"PeriodoLectivo\".prd_lectivo_estado = TRUE \n"
                    + "	AND \"Cursos\".id_docente = " + idDocente + "\n"
                    + "	AND \"PeriodoLectivo\".prd_lectivo_nombre = '" + nombrePeriodo + "' \n"
                    + "	AND \"Cursos\".curso_ciclo = " + ciclo + " \n"
                    + "	AND \"Cursos\".curso_paralelo = '" + paralelo + "' \n"
                    + "	AND \"Jornadas\".nombre_jornada = '" + nombreJornada + "' \n"
                    + "ORDER BY\n"
                    + "	p_alu.persona_primer_apellido ASC;";

            System.out.println(QUERY);

            JasperDesign jd = JRXmlLoader.load(path);

            JRDesignQuery newQuery = new JRDesignQuery();

            newQuery.setText(QUERY);

            jd.setQuery(newQuery);

            JasperReport jr = (JasperReport) JRLoader.loadObject(getClass().getResource("/vista/notas/Reportes/ReporteCompleto.jasper"));

            JasperPrint jp = JasperFillManager.fillReport(jr, null, ResourceManager.getConnection());

            JasperViewer.viewReport(jp, false);

        } catch (JRException | NullPointerException q) {
            Logger.getLogger(VtnNotasAlumnoCurso.class.getName()).log(Level.SEVERE, null, q);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void generarReporteMenos70(int idDocente,String nombrePeriodo, int ciclo,String paralelo, String nombreJornada) {
        try {
//            String nombrePeriodo = vista.getCmbPeriodoLectivo().getSelectedItem().toString();
//            String ciclo = vista.getCmbCiclo().getSelectedItem().toString();
//            String paralelo = vista.getCmbParalelo().getSelectedItem().toString();
//            String nombreJornada = vista.getCmbJornada().getSelectedItem().toString();

            String path = Effects.getProjectPath() + "src\\vista\\notas\\Reportes\\ReporteNotasMenor70.jrxml";
            String QUERY = "SELECT\n"
                    + "	\"Alumnos\".id_alumno,\n"
                    + "	p_alu.persona_identificacion,\n"
                    + "	p_alu.persona_primer_apellido || ' ' ||p_alu.persona_segundo_apellido as \"APELLIDOS\",\n"
                    + "	p_alu.persona_primer_nombre || ' ' || p_alu.persona_segundo_nombre AS \"NOMBRES\",\n"
                    + "	ROUND(\"AlumnoCurso\".almn_curso_nt_1_parcial, 1) AS \"APORTE 1\",\n"
                    + "	ROUND(\"AlumnoCurso\".almn_curso_nt_examen_interciclo, 1) AS \"INTERCICLO\",\n"
                    + "	ROUND(\"AlumnoCurso\".almn_curso_nt_2_parcial, 1) AS \"APORTE 2\",\n"
                    + "	ROUND(\"AlumnoCurso\".almn_curso_nt_examen_final, 1) AS \"EXAMEN FINAL\",\n"
                    + "	ROUND(\"AlumnoCurso\".almn_curso_nt_examen_supletorio, 1) AS \"SUPLETORIO\",\n"
                    + "	\"AlumnoCurso\".almn_curso_asistencia,\n"
                    + "	ROUND(\"AlumnoCurso\".almn_curso_nota_final, 0) AS \"NOTA FINAL\",\n"
                    + "	\"AlumnoCurso\".almn_curso_estado,\n"
                    + "	\"AlumnoCurso\".almn_curso_num_faltas,\n"
                    + "	\"Materias\".materia_nombre, \n"
                    + "	\"Jornadas\".nombre_jornada,\n"
                    + "	\"Materias\".materia_ciclo,\n"
                    + "	\"Cursos\".curso_paralelo,\n"
                    + "	\"Carreras\".carrera_nombre,\n"
                    + "	\"PeriodoLectivo\".prd_lectivo_nombre,\n"
                    + "	\"Personas\".persona_primer_nombre || ' ' ||\"Personas\".persona_segundo_nombre as \"NOMBRE_PROF\",\n"
                    + "	\"Personas\".persona_primer_apellido || ' ' ||\"Personas\".persona_segundo_apellido as \"APELLIDO_PROF\",\n"
                    + "	(\"AlumnoCurso\".almn_curso_num_faltas * \"Materias\".materia_total_horas)/100 as \"% Faltas\",\n"
                    + "  per_coor.persona_primer_apellido || ' ' || per_coor.persona_segundo_apellido as \"APELLIDOS_COORDINADOR\",\n"
                    + "  per_coor.persona_primer_nombre || ' ' ||per_coor.persona_segundo_nombre AS \"NOMBRES_COORDINADOR\"\n"
                    + "	\n"
                    + "FROM\n"
                    + "	\"AlumnoCurso\"\n"
                    + "	INNER JOIN \"Cursos\" ON \"AlumnoCurso\".id_curso = \"Cursos\".id_curso\n"
                    + "	INNER JOIN \"Jornadas\" ON \"Cursos\".id_jornada = \"Jornadas\".id_jornada\n"
                    + "	INNER JOIN \"Materias\" ON \"Cursos\".id_materia = \"Materias\".id_materia\n"
                    + "	INNER JOIN \"PeriodoLectivo\" ON \"Cursos\".id_prd_lectivo = \"PeriodoLectivo\".id_prd_lectivo\n"
                    + "	INNER JOIN \"Alumnos\" ON \"AlumnoCurso\".id_alumno = \"Alumnos\".id_alumno\n"
                    + "	INNER JOIN \"Personas\" p_alu ON \"Alumnos\".id_persona = p_alu.id_persona\n"
                    + "	INNER JOIN \"Docentes\" ON \"public\".\"Cursos\".id_docente = \"public\".\"Docentes\".id_docente\n"
                    + "	INNER JOIN \"Carreras\" ON \"public\".\"Carreras\".id_carrera = \"public\".\"Materias\".id_carrera\n"
                    + "	INNER JOIN \"Personas\" ON \"public\".\"Personas\".id_persona= \"public\".\"Docentes\".id_persona\n"
                    + "  INNER JOIN \"Docentes\" doc_coor ON doc_coor.id_docente = \"public\".\"Carreras\".id_docente_coordinador\n"
                    + "  INNER JOIN \"Personas\" per_coor ON per_coor.id_persona = doc_coor.id_persona\n"
                    + "	\n"
                    + "\n"
                    + "	WHERE\n"
                    + "	\"PeriodoLectivo\".prd_lectivo_estado = TRUE \n"
                    + "	AND \"Cursos\".id_docente = " + idDocente + "\n"
                    + "	AND \"PeriodoLectivo\".prd_lectivo_nombre = '" + nombrePeriodo + "' \n"
                    + "	AND \"Cursos\".curso_ciclo = " + ciclo + " \n"
                    + "	AND \"Cursos\".curso_paralelo = '" + paralelo + "' \n"
                    + "	AND \"Jornadas\".nombre_jornada = '" + nombreJornada + "' \n"
                    + "	AND \"AlumnoCurso\".almn_curso_nota_final < 70\n"
                    + "ORDER BY\n"
                    + "	p_alu.persona_primer_apellido ASC;";

            System.out.println(QUERY);

            JasperDesign jd = JRXmlLoader.load(path);

            JRDesignQuery newQuery = new JRDesignQuery();

            newQuery.setText(QUERY);

            jd.setQuery(newQuery);

            JasperReport jr = (JasperReport) JRLoader.loadObject(getClass().getResource("/vista/notas/Reportes/ReporteNotasMenor70.jasper"));

            JasperPrint jp = JasperFillManager.fillReport(jr, null, ResourceManager.getConnection());

            JasperViewer.viewReport(jp, false);

        } catch (JRException | NullPointerException q) {
            Logger.getLogger(VtnNotasAlumnoCurso.class.getName()).log(Level.SEVERE, null, q);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void generarReporteEntre70_80(int idDocente,String nombrePeriodo, int ciclo,String paralelo, String nombreJornada) {
        try {
//            String nombrePeriodo = vista.getCmbPeriodoLectivo().getSelectedItem().toString();
//            String ciclo = vista.getCmbCiclo().getSelectedItem().toString();
//            String paralelo = vista.getCmbParalelo().getSelectedItem().toString();
//            String nombreJornada = vista.getCmbJornada().getSelectedItem().toString();

            String path = Effects.getProjectPath() + "src\\vista\\notas\\Reportes\\ReporteNotasEntre70y80.jrxml";
            String QUERY = "SELECT\n"
                    + "	\"Alumnos\".id_alumno,\n"
                    + "	p_alu.persona_identificacion,\n"
                    + "	p_alu.persona_primer_apellido || ' ' ||p_alu.persona_segundo_apellido as \"APELLIDOS\",\n"
                    + "	p_alu.persona_primer_nombre || ' ' || p_alu.persona_segundo_nombre AS \"NOMBRES\",\n"
                    + "	ROUND(\"AlumnoCurso\".almn_curso_nt_1_parcial, 1) AS \"APORTE 1\",\n"
                    + "	ROUND(\"AlumnoCurso\".almn_curso_nt_examen_interciclo, 1) AS \"INTERCICLO\",\n"
                    + "	ROUND(\"AlumnoCurso\".almn_curso_nt_2_parcial, 1) AS \"APORTE 2\",\n"
                    + "	ROUND(\"AlumnoCurso\".almn_curso_nt_examen_final, 1) AS \"EXAMEN FINAL\",\n"
                    + "	ROUND(\"AlumnoCurso\".almn_curso_nt_examen_supletorio, 1) AS \"SUPLETORIO\",\n"
                    + "	\"AlumnoCurso\".almn_curso_asistencia,\n"
                    + "	ROUND(\"AlumnoCurso\".almn_curso_nota_final, 0) AS \"NOTA FINAL\",\n"
                    + "	\"AlumnoCurso\".almn_curso_estado,\n"
                    + "	\"AlumnoCurso\".almn_curso_num_faltas,\n"
                    + "	\"Materias\".materia_nombre, \n"
                    + "	\"Jornadas\".nombre_jornada,\n"
                    + "	\"Materias\".materia_ciclo,\n"
                    + "	\"Cursos\".curso_paralelo,\n"
                    + "	\"Carreras\".carrera_nombre,\n"
                    + "	\"PeriodoLectivo\".prd_lectivo_nombre,\n"
                    + "	\"Personas\".persona_primer_nombre || ' ' ||\"Personas\".persona_segundo_nombre as \"NOMBRE_PROF\",\n"
                    + "	\"Personas\".persona_primer_apellido || ' ' ||\"Personas\".persona_segundo_apellido as \"APELLIDO_PROF\",\n"
                    + "	(\"AlumnoCurso\".almn_curso_num_faltas * \"Materias\".materia_total_horas)/100 as \"% Faltas\",\n"
                    + "  per_coor.persona_primer_apellido || ' ' || per_coor.persona_segundo_apellido as \"APELLIDOS_COORDINADOR\",\n"
                    + "  per_coor.persona_primer_nombre || ' ' ||per_coor.persona_segundo_nombre AS \"NOMBRES_COORDINADOR\"\n"
                    + "	\n"
                    + "FROM\n"
                    + "	\"AlumnoCurso\"\n"
                    + "	INNER JOIN \"Cursos\" ON \"AlumnoCurso\".id_curso = \"Cursos\".id_curso\n"
                    + "	INNER JOIN \"Jornadas\" ON \"Cursos\".id_jornada = \"Jornadas\".id_jornada\n"
                    + "	INNER JOIN \"Materias\" ON \"Cursos\".id_materia = \"Materias\".id_materia\n"
                    + "	INNER JOIN \"PeriodoLectivo\" ON \"Cursos\".id_prd_lectivo = \"PeriodoLectivo\".id_prd_lectivo\n"
                    + "	INNER JOIN \"Alumnos\" ON \"AlumnoCurso\".id_alumno = \"Alumnos\".id_alumno\n"
                    + "	INNER JOIN \"Personas\" p_alu ON \"Alumnos\".id_persona = p_alu.id_persona\n"
                    + "	INNER JOIN \"Docentes\" ON \"public\".\"Cursos\".id_docente = \"public\".\"Docentes\".id_docente\n"
                    + "	INNER JOIN \"Carreras\" ON \"public\".\"Carreras\".id_carrera = \"public\".\"Materias\".id_carrera\n"
                    + "	INNER JOIN \"Personas\" ON \"public\".\"Personas\".id_persona= \"public\".\"Docentes\".id_persona\n"
                    + "  INNER JOIN \"Docentes\" doc_coor ON doc_coor.id_docente = \"public\".\"Carreras\".id_docente_coordinador\n"
                    + "  INNER JOIN \"Personas\" per_coor ON per_coor.id_persona = doc_coor.id_persona\n"
                    + "	\n"
                    + "\n"
                    + "	WHERE\n"
                    + "	\"PeriodoLectivo\".prd_lectivo_estado = TRUE \n"
                    + "	AND \"Cursos\".id_docente = " + idDocente + "\n"
                    + "	AND \"PeriodoLectivo\".prd_lectivo_nombre = '" + nombrePeriodo + "' \n"
                    + "	AND \"Cursos\".curso_ciclo = " + ciclo + " \n"
                    + "	AND \"Cursos\".curso_paralelo = '" + paralelo + "' \n"
                    + "	AND \"Jornadas\".nombre_jornada = '" + nombreJornada + "' \n"
                    + "	AND \"AlumnoCurso\".almn_curso_nota_final >=70 \n"
                    + "	AND \"AlumnoCurso\".almn_curso_nota_final <81 \n"
                    + "ORDER BY\n"
                    + "	p_alu.persona_primer_apellido ASC;";

            System.out.println(QUERY);

            JasperDesign jd = JRXmlLoader.load(path);

            JRDesignQuery newQuery = new JRDesignQuery();

            newQuery.setText(QUERY);

            jd.setQuery(newQuery);

            JasperReport jr = (JasperReport) JRLoader.loadObject(getClass().getResource("/vista/notas/Reportes/ReporteNotasEntre70y80.jasper"));

            JasperPrint jp = JasperFillManager.fillReport(jr, null, ResourceManager.getConnection());

            JasperViewer.viewReport(jp, false);

        } catch (JRException | NullPointerException q) {
            Logger.getLogger(VtnNotasAlumnoCurso.class.getName()).log(Level.SEVERE, null, q);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void generarReporteEntre80_90(int idDocente,String nombrePeriodo, int ciclo,String paralelo, String nombreJornada) {
        try {
//            String nombrePeriodo = vista.getCmbPeriodoLectivo().getSelectedItem().toString();
//            String ciclo = vista.getCmbCiclo().getSelectedItem().toString();
//            String paralelo = vista.getCmbParalelo().getSelectedItem().toString();
//            String nombreJornada = vista.getCmbJornada().getSelectedItem().toString();

            String path = Effects.getProjectPath() + "src\\vista\\notas\\Reportes\\ReporteNotasEntre80y90.jrxml";
            String QUERY = "SELECT\n"
                    + "	\"Alumnos\".id_alumno,\n"
                    + "	p_alu.persona_identificacion,\n"
                    + "	p_alu.persona_primer_apellido || ' ' ||p_alu.persona_segundo_apellido as \"APELLIDOS\",\n"
                    + "	p_alu.persona_primer_nombre || ' ' || p_alu.persona_segundo_nombre AS \"NOMBRES\",\n"
                    + "	ROUND(\"AlumnoCurso\".almn_curso_nt_1_parcial, 1) AS \"APORTE 1\",\n"
                    + "	ROUND(\"AlumnoCurso\".almn_curso_nt_examen_interciclo, 1) AS \"INTERCICLO\",\n"
                    + "	ROUND(\"AlumnoCurso\".almn_curso_nt_2_parcial, 1) AS \"APORTE 2\",\n"
                    + "	ROUND(\"AlumnoCurso\".almn_curso_nt_examen_final, 1) AS \"EXAMEN FINAL\",\n"
                    + "	ROUND(\"AlumnoCurso\".almn_curso_nt_examen_supletorio, 1) AS \"SUPLETORIO\",\n"
                    + "	\"AlumnoCurso\".almn_curso_asistencia,\n"
                    + "	ROUND(\"AlumnoCurso\".almn_curso_nota_final, 0) AS \"NOTA FINAL\",\n"
                    + "	\"AlumnoCurso\".almn_curso_estado,\n"
                    + "	\"AlumnoCurso\".almn_curso_num_faltas,\n"
                    + "	\"Materias\".materia_nombre, \n"
                    + "	\"Jornadas\".nombre_jornada,\n"
                    + "	\"Materias\".materia_ciclo,\n"
                    + "	\"Cursos\".curso_paralelo,\n"
                    + "	\"Carreras\".carrera_nombre,\n"
                    + "	\"PeriodoLectivo\".prd_lectivo_nombre,\n"
                    + "	\"Personas\".persona_primer_nombre || ' ' ||\"Personas\".persona_segundo_nombre as \"NOMBRE_PROF\",\n"
                    + "	\"Personas\".persona_primer_apellido || ' ' ||\"Personas\".persona_segundo_apellido as \"APELLIDO_PROF\",\n"
                    + "	(\"AlumnoCurso\".almn_curso_num_faltas * \"Materias\".materia_total_horas)/100 as \"% Faltas\",\n"
                    + "  per_coor.persona_primer_apellido || ' ' || per_coor.persona_segundo_apellido as \"APELLIDOS_COORDINADOR\",\n"
                    + "  per_coor.persona_primer_nombre || ' ' ||per_coor.persona_segundo_nombre AS \"NOMBRES_COORDINADOR\"\n"
                    + "	\n"
                    + "FROM\n"
                    + "	\"AlumnoCurso\"\n"
                    + "	INNER JOIN \"Cursos\" ON \"AlumnoCurso\".id_curso = \"Cursos\".id_curso\n"
                    + "	INNER JOIN \"Jornadas\" ON \"Cursos\".id_jornada = \"Jornadas\".id_jornada\n"
                    + "	INNER JOIN \"Materias\" ON \"Cursos\".id_materia = \"Materias\".id_materia\n"
                    + "	INNER JOIN \"PeriodoLectivo\" ON \"Cursos\".id_prd_lectivo = \"PeriodoLectivo\".id_prd_lectivo\n"
                    + "	INNER JOIN \"Alumnos\" ON \"AlumnoCurso\".id_alumno = \"Alumnos\".id_alumno\n"
                    + "	INNER JOIN \"Personas\" p_alu ON \"Alumnos\".id_persona = p_alu.id_persona\n"
                    + "	INNER JOIN \"Docentes\" ON \"public\".\"Cursos\".id_docente = \"public\".\"Docentes\".id_docente\n"
                    + "	INNER JOIN \"Carreras\" ON \"public\".\"Carreras\".id_carrera = \"public\".\"Materias\".id_carrera\n"
                    + "	INNER JOIN \"Personas\" ON \"public\".\"Personas\".id_persona= \"public\".\"Docentes\".id_persona\n"
                    + "  INNER JOIN \"Docentes\" doc_coor ON doc_coor.id_docente = \"public\".\"Carreras\".id_docente_coordinador\n"
                    + "  INNER JOIN \"Personas\" per_coor ON per_coor.id_persona = doc_coor.id_persona\n"
                    + "	\n"
                    + "\n"
                    + "	WHERE\n"
                    + "	\"PeriodoLectivo\".prd_lectivo_estado = TRUE \n"
                    + "	AND \"Cursos\".id_docente = " + idDocente + "\n"
                    + "	AND \"PeriodoLectivo\".prd_lectivo_nombre = '" + nombrePeriodo + "' \n"
                    + "	AND \"Cursos\".curso_ciclo = " + ciclo + " \n"
                    + "	AND \"Cursos\".curso_paralelo = '" + paralelo + "' \n"
                    + "	AND \"Jornadas\".nombre_jornada = '" + nombreJornada + "' \n"
                    + "	AND \"AlumnoCurso\".almn_curso_nota_final >=80 \n"
                    + "	AND \"AlumnoCurso\".almn_curso_nota_final <91 \n"
                    + "ORDER BY\n"
                    + "	p_alu.persona_primer_apellido ASC;";

            System.out.println(QUERY);

            JasperDesign jd = JRXmlLoader.load(path);

            JRDesignQuery newQuery = new JRDesignQuery();

            newQuery.setText(QUERY);

            jd.setQuery(newQuery);

            JasperReport jr = (JasperReport) JRLoader.loadObject(getClass().getResource("/vista/notas/Reportes/ReporteNotasEntre80y90.jasper"));

            JasperPrint jp = JasperFillManager.fillReport(jr, null, ResourceManager.getConnection());

            JasperViewer.viewReport(jp, false);

        } catch (JRException | NullPointerException q) {
            Logger.getLogger(VtnNotasAlumnoCurso.class.getName()).log(Level.SEVERE, null, q);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void generarReporteEntre90_100(int idDocente,String nombrePeriodo, int ciclo,String paralelo, String nombreJornada) {
        try {
//            String nombrePeriodo = vista.getCmbPeriodoLectivo().getSelectedItem().toString();
//            String ciclo = vista.getCmbCiclo().getSelectedItem().toString();
//            String paralelo = vista.getCmbParalelo().getSelectedItem().toString();
//            String nombreJornada = vista.getCmbJornada().getSelectedItem().toString();

            String path = Effects.getProjectPath() + "src\\vista\\notas\\Reportes\\ReporteNotasEntre90y100.jrxml";
            String QUERY = "SELECT\n"
                    + "	\"Alumnos\".id_alumno,\n"
                    + "	p_alu.persona_identificacion,\n"
                    + "	p_alu.persona_primer_apellido || ' ' ||p_alu.persona_segundo_apellido as \"APELLIDOS\",\n"
                    + "	p_alu.persona_primer_nombre || ' ' || p_alu.persona_segundo_nombre AS \"NOMBRES\",\n"
                    + "	ROUND(\"AlumnoCurso\".almn_curso_nt_1_parcial, 1) AS \"APORTE 1\",\n"
                    + "	ROUND(\"AlumnoCurso\".almn_curso_nt_examen_interciclo, 1) AS \"INTERCICLO\",\n"
                    + "	ROUND(\"AlumnoCurso\".almn_curso_nt_2_parcial, 1) AS \"APORTE 2\",\n"
                    + "	ROUND(\"AlumnoCurso\".almn_curso_nt_examen_final, 1) AS \"EXAMEN FINAL\",\n"
                    + "	ROUND(\"AlumnoCurso\".almn_curso_nt_examen_supletorio, 1) AS \"SUPLETORIO\",\n"
                    + "	\"AlumnoCurso\".almn_curso_asistencia,\n"
                    + "	ROUND(\"AlumnoCurso\".almn_curso_nota_final, 0) AS \"NOTA FINAL\",\n"
                    + "	\"AlumnoCurso\".almn_curso_estado,\n"
                    + "	\"AlumnoCurso\".almn_curso_num_faltas,\n"
                    + "	\"Materias\".materia_nombre, \n"
                    + "	\"Jornadas\".nombre_jornada,\n"
                    + "	\"Materias\".materia_ciclo,\n"
                    + "	\"Cursos\".curso_paralelo,\n"
                    + "	\"Carreras\".carrera_nombre,\n"
                    + "	\"PeriodoLectivo\".prd_lectivo_nombre,\n"
                    + "	\"Personas\".persona_primer_nombre || ' ' ||\"Personas\".persona_segundo_nombre as \"NOMBRE_PROF\",\n"
                    + "	\"Personas\".persona_primer_apellido || ' ' ||\"Personas\".persona_segundo_apellido as \"APELLIDO_PROF\",\n"
                    + "	(\"AlumnoCurso\".almn_curso_num_faltas * \"Materias\".materia_total_horas)/100 as \"% Faltas\",\n"
                    + "  per_coor.persona_primer_apellido || ' ' || per_coor.persona_segundo_apellido as \"APELLIDOS_COORDINADOR\",\n"
                    + "  per_coor.persona_primer_nombre || ' ' ||per_coor.persona_segundo_nombre AS \"NOMBRES_COORDINADOR\"\n"
                    + "	\n"
                    + "FROM\n"
                    + "	\"AlumnoCurso\"\n"
                    + "	INNER JOIN \"Cursos\" ON \"AlumnoCurso\".id_curso = \"Cursos\".id_curso\n"
                    + "	INNER JOIN \"Jornadas\" ON \"Cursos\".id_jornada = \"Jornadas\".id_jornada\n"
                    + "	INNER JOIN \"Materias\" ON \"Cursos\".id_materia = \"Materias\".id_materia\n"
                    + "	INNER JOIN \"PeriodoLectivo\" ON \"Cursos\".id_prd_lectivo = \"PeriodoLectivo\".id_prd_lectivo\n"
                    + "	INNER JOIN \"Alumnos\" ON \"AlumnoCurso\".id_alumno = \"Alumnos\".id_alumno\n"
                    + "	INNER JOIN \"Personas\" p_alu ON \"Alumnos\".id_persona = p_alu.id_persona\n"
                    + "	INNER JOIN \"Docentes\" ON \"public\".\"Cursos\".id_docente = \"public\".\"Docentes\".id_docente\n"
                    + "	INNER JOIN \"Carreras\" ON \"public\".\"Carreras\".id_carrera = \"public\".\"Materias\".id_carrera\n"
                    + "	INNER JOIN \"Personas\" ON \"public\".\"Personas\".id_persona= \"public\".\"Docentes\".id_persona\n"
                    + "  INNER JOIN \"Docentes\" doc_coor ON doc_coor.id_docente = \"public\".\"Carreras\".id_docente_coordinador\n"
                    + "  INNER JOIN \"Personas\" per_coor ON per_coor.id_persona = doc_coor.id_persona\n"
                    + "	\n"
                    + "\n"
                    + "	WHERE\n"
                    + "	\"PeriodoLectivo\".prd_lectivo_estado = TRUE \n"
                    + "	AND \"Cursos\".id_docente = " + idDocente + "\n"
                    + "	AND \"PeriodoLectivo\".prd_lectivo_nombre = '" + nombrePeriodo + "' \n"
                    + "	AND \"Cursos\".curso_ciclo = " + ciclo + " \n"
                    + "	AND \"Cursos\".curso_paralelo = '" + paralelo + "' \n"
                    + "	AND \"Jornadas\".nombre_jornada = '" + nombreJornada + "' \n"
                    + "	AND \"AlumnoCurso\".almn_curso_nota_final >=90 \n"
                    + "	AND \"AlumnoCurso\".almn_curso_nota_final <101\n"
                    + "ORDER BY\n"
                    + "	p_alu.persona_primer_apellido ASC;";

            System.out.println(QUERY);

            JasperDesign jd = JRXmlLoader.load(path);

            JRDesignQuery newQuery = new JRDesignQuery();

            newQuery.setText(QUERY);

            jd.setQuery(newQuery);

            JasperReport jr = (JasperReport) JRLoader.loadObject(getClass().getResource("/vista/notas/Reportes/ReporteNotasEntre90y100.jasper"));

            JasperPrint jp = JasperFillManager.fillReport(jr, null, ResourceManager.getConnection());

            JasperViewer.viewReport(jp, false);

        } catch (JRException | NullPointerException q) {
            Logger.getLogger(VtnNotasAlumnoCurso.class.getName()).log(Level.SEVERE, null, q);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }
    
  
}
