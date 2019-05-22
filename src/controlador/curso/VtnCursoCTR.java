package controlador.curso;

import controlador.principal.DVtnCTR;
import controlador.principal.VtnPrincipalCTR;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import modelo.accesos.AccesosMD;
import modelo.curso.CursoBD;
import modelo.curso.CursoMD;
import modelo.estilo.TblEstilo;
import modelo.periodolectivo.PeriodoLectivoBD;
import modelo.periodolectivo.PeriodoLectivoMD;
import modelo.validaciones.TxtVBuscador;
import modelo.validaciones.Validar;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import vista.curso.FrmCurso;
import vista.curso.VtnCurso;

/**
 *
 * @author arman
 */
public class VtnCursoCTR extends DVtnCTR {

    private final VtnCurso vtnCurso;

    private final CursoBD curso;
    private ArrayList<CursoMD> cursos;
    //Para cargar el combo periodos  
    private final PeriodoLectivoBD prd;
    private ArrayList<PeriodoLectivoMD> periodos;
    //Para guardanos los nombres de los cursos  
    private ArrayList<String> nombresC;
    private String b;

    public VtnCursoCTR(VtnCurso vtnCurso,
            VtnPrincipalCTR ctrPrin) {
        super(ctrPrin);
        this.vtnCurso = vtnCurso;
        this.prd = new PeriodoLectivoBD(ctrPrin.getConecta());
        //Inicializamos el curso  
        curso = new CursoBD(ctrPrin.getConecta());
    }

    public void iniciar() {
        vtnCurso.getBtnListaAlumnos().setEnabled(false);
        cargarCmbPrdLectio();
        cargarNombreCursos();
        //Iniciamos la tabla  
        String titulo[] = {"id", "Periodo", "Materia", "Cedula", "Docente", "Ciclo", "Curso", "Capacidad"};
        String datos[][] = {};
        mdTbl = TblEstilo.modelTblSinEditar(datos, titulo);
        vtnCurso.getTblCurso().setModel(mdTbl);
        //Formato de la tabla
        TblEstilo.formatoTbl(vtnCurso.getTblCurso());
        TblEstilo.ocualtarID(vtnCurso.getTblCurso());
        //le pasamos un tamaño a las columnas
        TblEstilo.columnaMedida(vtnCurso.getTblCurso(), 5, 60);
        TblEstilo.columnaMedida(vtnCurso.getTblCurso(), 6, 60);
        TblEstilo.columnaMedida(vtnCurso.getTblCurso(), 7, 70);
        cargarCursos();
        vtnCurso.getBtnIngresar().addActionListener(e -> abrirFrmCurso());
        vtnCurso.getBtnEditar().addActionListener(e -> editarCurso());
        vtnCurso.getBtnEliminar().addActionListener(e -> eliminarCurso());
        vtnCurso.getBtnHorario().addActionListener(e -> horario());
        vtnCurso.getCbxEliminados().addActionListener(e -> verCursosEliminados());
        //Le damos una accion al combo de periodos lectivos 
        vtnCurso.getCmbPeriodoLectivo().addActionListener(e -> cargarCursosPorPeriodo());
        //Le damos una accion al combo de cursos  
        vtnCurso.getCmbCurso().addActionListener(e -> cargarCursosPorNombre());

        vtnCurso.getBtnBuscar().addActionListener(e -> buscar(vtnCurso.getTxtBuscar().getText().trim()));
        //Validacion del buscador 
        vtnCurso.getBtnBuscar().addKeyListener(new TxtVBuscador(vtnCurso.getTxtBuscar(),
                vtnCurso.getBtnBuscar()));
        vtnCurso.getTblCurso().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                validarBotonesReportes();
            }
        });
        vtnCurso.getBtnListaAlumnos().addActionListener(e -> reporteListaAlumnos());
        iniciarBuscador();

        ctrPrin.agregarVtn(vtnCurso);
    }

    /**
     * Iniciamos el buscador de esta ventana
     */
    private void iniciarBuscador() {
        vtnCurso.getTxtBuscar().addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                b = vtnCurso.getTxtBuscar().getText().trim();
                //10 ENter - 32 Espacio - 8 Borrar
                if (e.getKeyCode() == 10) {
                    buscar(b);
                } else if (b.length() == 0) {
                    cargarCursos();
                }
            }
        });
    }

    /**
     * T
     * Abrimos el formulario para ingresar un curso
     */
    public void abrirFrmCurso() {
        FrmCurso frmCurso = new FrmCurso();
        ctrPrin.eventoInternal(frmCurso);
        FrmCursoCTR ctrFrmCurso = new FrmCursoCTR(frmCurso, ctrPrin, this);
        ctrFrmCurso.iniciar();
        vtnCurso.setVisible(false);
    }

    /**
     * Al seleccionar un curso se puede editar.
     */
    private void editarCurso() {
        posFila = vtnCurso.getTblCurso().getSelectedRow();
        if (posFila >= 0) {
            FrmCurso frmCurso = new FrmCurso();
            FrmCursoCTR ctrFrmCurso = new FrmCursoCTR(frmCurso, ctrPrin, this);
            ctrFrmCurso.iniciar();
            ctrPrin.eventoInternal(frmCurso);
            ctrFrmCurso.editar(cursos.get(posFila));
            vtnCurso.setVisible(false);
        }
    }

    /**
     * Actualizamos la ventana luego de hacer una accion, eliminar editar etc.
     */
    public void actualizarVtn() {
        int posPrd = vtnCurso.getCmbPeriodoLectivo().getSelectedIndex();
        int posCur = vtnCurso.getCmbCurso().getSelectedIndex();
        if (vtnCurso.getTxtBuscar().getText().length() > 0) {
            buscar(vtnCurso.getTxtBuscar().getText().trim());
        } else {
            if (posPrd > 0 && posCur > 0) {
                cargarCursosPorNombre();
            } else if (posPrd > 0) {
                cargarCursosPorPeriodo();
            } else {
                cargarCursos();
            }
        }
        vtnCurso.setVisible(true);
    }

    /**
     * Buscamos unicamente por nombre y cedula
     *
     * @param b
     */
    private void buscar(String b) {
        if (Validar.esLetrasYNumeros(b)) {
            cursos = curso.buscarCursos(b);
            llenarTbl(cursos);
        } else {
            System.out.println("No ingrese caracteres especiales");
        }
    }

    /**
     * Cargamos todos los cursos que existen en el isntituto, incluyendo el
     * periodo lectivo en el que se abrieron
     */
    public void cargarCursos() {
        cursos = curso.cargarCursos();
        llenarTbl(cursos);
        System.out.println("Se cargaron cursos");
    }

    /**
     * Cargamos los nombres de todos los cursos
     */
    public void cargarNombreCursos() {
        nombresC = curso.cargarNombreCursos();
        cargarCmbCursos(nombresC);
    }

    /**
     * Cargamos todos los cursos por el periodo
     */
    private void cargarCursosPorPeriodo() {
        vtnCurso.getTxtBuscar().setText("");
        int posPrd = vtnCurso.getCmbPeriodoLectivo().getSelectedIndex();
        if (posPrd > 0) {
            //Cargamos el combo de cursos por el periodo  
            nombresC = curso.cargarNombreCursosPorPeriodo(periodos.get(posPrd - 1).getId_PerioLectivo());
            cargarCmbCursos(nombresC);
            //Cargamos los cursos por periodo
            cursos = curso.cargarCursosPorPeriodo(periodos.get(posPrd - 1).getId_PerioLectivo());
            llenarTbl(cursos);
        } else {
            cargarCursos();
        }
    }

    /**
     * Cargamos los cursos por nombre
     */
    private void cargarCursosPorNombre() {
        vtnCurso.getTxtBuscar().setText("");
        int posNom = vtnCurso.getCmbCurso().getSelectedIndex();
        int posPrd = vtnCurso.getCmbPeriodoLectivo().getSelectedIndex();
        if (posNom == 0) {
            cargarCursosPorPeriodo();
        } else if (posNom > 0 && posPrd == 0) {
            cursos = curso.cargarCursosPorNombre(vtnCurso.getCmbCurso().getSelectedItem().toString());
            llenarTbl(cursos);
        } else if (posNom > 0 && posPrd > 0) {
            cursos = curso.cargarCursosPorNombreYPrdLectivo(vtnCurso.getCmbCurso().getSelectedItem().toString(),
                    periodos.get(posPrd - 1).getId_PerioLectivo());
            llenarTbl(cursos);
        }
    }

    /**
     * Llenamos la tabla con los cursos
     *
     * @param cursos
     */
    private void llenarTbl(ArrayList<CursoMD> cursos) {
        mdTbl.setRowCount(0);
        if (cursos != null) {
            cursos.forEach((c) -> {
                Object valores[] = {
                    c.getId(),
                    c.getPeriodo().getNombre_PerLectivo(),
                    c.getMateria().getNombre(),
                    c.getDocente().getIdentificacion(),
                    c.getDocente().getPrimerNombre() + " "
                    + c.getDocente().getPrimerApellido(),
                    c.getCiclo(),
                    c.getNombre(),
                    c.getCapacidad()
                };
                mdTbl.addRow(valores);
            });
            vtnCurso.getLblResultados().setText(cursos.size() + " Resultados obtenidos.");
        } else {
            vtnCurso.getLblResultados().setText("0 Resultados obtenidos.");
        }
    }

    /**
     * Cargamos el combo de periodo lectivo
     */
    private void cargarCmbPrdLectio() {
        periodos = prd.cargarPrdParaCmbVtn();
        vtnCurso.getCmbPeriodoLectivo().removeAllItems();
        if (periodos != null) {
            vtnCurso.getCmbPeriodoLectivo().addItem("Todos");
            periodos.forEach((p) -> {
                vtnCurso.getCmbPeriodoLectivo().addItem(p.getNombre_PerLectivo());
            });
        }
    }

    /**
     * Reporte de la lista de alumnos por curso
     */
    public void reporteListaAlumnos() {
        JasperReport jr;
        String path = "/vista/reportes/repListaAlumno.jasper";
        try {
            posFila = vtnCurso.getTblCurso().getSelectedRow();
            Map parametro = new HashMap();
            parametro.put("curso", cursos.get(posFila).getId());
            jr = (JasperReport) JRLoader.loadObject(getClass().getResource(path));
            ctrPrin.getConecta().mostrarReporte(jr, parametro, "Lista de estudiantes");
        } catch (JRException ex) {
            JOptionPane.showMessageDialog(null, "error" + ex);
        }
    }

    /**
     * Cargamos los cursos
     *
     * @param nombresC
     */
    private void cargarCmbCursos(ArrayList<String> nombresC) {
        vtnCurso.getCmbCurso().removeAllItems();
        if (nombresC != null) {
            vtnCurso.getCmbCurso().addItem("Todos");
            nombresC.forEach(n -> {
                vtnCurso.getCmbCurso().addItem(n);
            });
            vtnCurso.getCmbCurso().setSelectedIndex(0);
        }
    }

    private void eliminarCurso() {
        int posCur = vtnCurso.getTblCurso().getSelectedRow();

        if (posCur >= 0) {
            String nom = vtnCurso.getTblCurso().getValueAt(posCur, 5).toString();
            int num = curso.numAlumnos(cursos.get(posCur).getId());
            int r = JOptionPane.showConfirmDialog(vtnCurso, "Seguro quiere "
                    + vtnCurso.getBtnEliminar().getText().toLowerCase() + " el curso " + nom + "\n"
                    + "Se " + vtnCurso.getBtnEliminar().getText().toLowerCase()
                    + "an todos los alumnos de este curso: " + num);
            if (r == JOptionPane.YES_OPTION) {
                if (vtnCurso.getCbxEliminados().isSelected()) {
                    curso.activarCurso(cursos.get(posCur).getId());
                } else {
                    curso.eliminarCurso(cursos.get(posCur).getId());
                }
                verCursosEliminados();
            }

        } else {
            JOptionPane.showMessageDialog(vtnCurso, "Debe seleccionar una final antes.");
        }
    }

    /**
     * Cargamos los cursos que se eliminaron en la base
     */
    private void verCursosEliminados() {
        if (vtnCurso.getCbxEliminados().isSelected()) {
            cursos = curso.cargarCursosEliminados();
            llenarTbl(cursos);
            vtnCurso.getBtnEliminar().setText("Activar");
        } else {
            cursos = curso.cargarCursos();
            llenarTbl(cursos);
            vtnCurso.getBtnEliminar().setText("Eliminar");
        }
    }

    private void InitPermisos() {

    }

    public void validarBotonesReportes() {
        int selecTabl = vtnCurso.getTblCurso().getSelectedRow();
        if (selecTabl >= 0) {
            vtnCurso.getBtnListaAlumnos().setEnabled(true);
        } else {
            vtnCurso.getBtnListaAlumnos().setEnabled(false);
        }
    }

    /**
     * Este es el horario de las materias
     */
    private void horario() {
        posFila = vtnCurso.getTblCurso().getSelectedRow();
        if (posFila >= 0) {
            JDHorarioCTR ctr = new JDHorarioCTR(ctrPrin, cursos.get(posFila));
            ctr.iniciar();
        } else {
            JOptionPane.showMessageDialog(vtnCurso, "Antes debe seleccionar un curso.");
        }
    }
}
