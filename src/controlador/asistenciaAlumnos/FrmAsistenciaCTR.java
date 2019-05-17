package controlador.asistenciaAlumnos;

import controlador.Libraries.Effects;
import controlador.Libraries.Middlewares;
import controlador.Libraries.Validaciones;
import controlador.Libraries.cellEditor.TextFieldCellEditor;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import modelo.alumno.AlumnoCursoBD;
import modelo.curso.CursoBD;
import modelo.curso.CursoMD;
import modelo.materia.MateriaBD;
import modelo.materia.MateriaMD;
import modelo.periodolectivo.PeriodoLectivoBD;
import modelo.periodolectivo.PeriodoLectivoMD;
import modelo.persona.DocenteBD;
import modelo.persona.DocenteMD;
import modelo.tipoDeNota.TipoDeNotaBD;
import modelo.tipoDeNota.TipoDeNotaMD;
import modelo.usuario.RolBD;
import modelo.usuario.UsuarioBD;
import vista.asistenciaAlumnos.FrmAsistencia;
import vista.principal.VtnPrincipal;

/**
 *
 * @author Lushito
 */
public class FrmAsistenciaCTR {

    private final VtnPrincipal desktop;
    private final FrmAsistencia vista;
    private final UsuarioBD usuario;
    private final RolBD rolSeleccionado;

    //LISTAS
    private Map<String, DocenteMD> listaDocentes;
    private List<PeriodoLectivoMD> listaPeriodos;
    private List<AlumnoCursoBD> listaNotas;
    private List<MateriaMD> listaMaterias;
    private List<TipoDeNotaMD> listaValidaciones;

    //TABLA
    private DefaultTableModel tablaTrad;

    //JTables
    private JTable jTbl;

    //ACTIVACION DE HILOS
    private boolean cargarTabla = true;

    public FrmAsistenciaCTR(VtnPrincipal desktop, FrmAsistencia vista, UsuarioBD usuario, RolBD rolSeleccionado) {
        this.desktop = desktop;
        this.vista = vista;
        this.usuario = usuario;
        this.rolSeleccionado = rolSeleccionado;
    }

    //Inits
    public void Init() {
        tablaTrad = (DefaultTableModel) vista.getTblAsistencia().getModel();

        jTbl = vista.getTblAsistencia();

        if (rolSeleccionado.getNombre().toLowerCase().contains("docente")) {
            listaDocentes = DocenteBD.selectAll(usuario.getUsername());
        } else {
            listaDocentes = DocenteBD.selectAll();
        }

        Effects.addInDesktopPane(vista, desktop.getDpnlPrincipal());

        activarForm(false);

        cargarComboDocente();
        cargarComboPeriodos();
        setLblCarrera();
        cargarComboCiclo();
        cargarComboMaterias();
        InitEventos();
        InitTablas();
        activarForm(true);
        cargarComboSemanas();
    }

    private void InitEventos() {
        vista.getCmbDocenteAsis().addActionListener(e -> cargarComboPeriodos());
        vista.getCmbPeriodoLectivoAsis().addActionListener(e -> cargarComboCiclo());
        vista.getCmbPeriodoLectivoAsis().addItemListener(e -> setLblCarrera());
        vista.getCmbCicloAsis().addActionListener(e -> cargarComboMaterias());
        vista.getBtnVerAsistencia().addActionListener(e -> btnVerAsistencia(e));
        vista.getBtnBuscarAsis().addActionListener(e -> buscarDocentes());
        CargarCombo(FrmAsistencia.tblAsistencia, FrmAsistencia.tblAsistencia.getColumnModel().getColumn(7));
        CargarCombo(FrmAsistencia.tblAsistencia, FrmAsistencia.tblAsistencia.getColumnModel().getColumn(8));
        CargarCombo(FrmAsistencia.tblAsistencia, FrmAsistencia.tblAsistencia.getColumnModel().getColumn(9));
        CargarCombo(FrmAsistencia.tblAsistencia, FrmAsistencia.tblAsistencia.getColumnModel().getColumn(10));
        CargarCombo(FrmAsistencia.tblAsistencia, FrmAsistencia.tblAsistencia.getColumnModel().getColumn(11));
        CargarCombo(FrmAsistencia.tblAsistencia, FrmAsistencia.tblAsistencia.getColumnModel().getColumn(12));

        vista.getTxtBuscarAsis().addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == 10) {
                    String texto = vista.getTxtBuscarAsis().getText();
                    if (texto.length() >= 10) {
                        buscarDocentes();
                    }
                }
            }
        });

        vista.getTxtBuscarAsis().addKeyListener(Validaciones.validarNumeros());

    }

    private void InitTablas() {
        jTbl.getColumnModel().getColumn(6).setCellEditor(new TextFieldCellEditor(true));
    }

    //Metodos de apoyo
    //Encabezado
    private void cargarComboDocente() {
        listaDocentes.entrySet().forEach((entry) -> {
            String key = entry.getKey();
            DocenteMD value = entry.getValue();

            vista.getCmbDocenteAsis().addItem(key);

        });
        tablaTrad.setRowCount(0);
    }

    private void cargarComboPeriodos() {
        vista.getCmbPeriodoLectivoAsis().removeAllItems();
        vista.getLblCarreraAsistencia().setText("");

        listaPeriodos = PeriodoLectivoBD.selectPeriodoWhere(getIdDocente());
        listaPeriodos
                .stream()
                .forEach(obj -> {
                    vista.getCmbPeriodoLectivoAsis().addItem(obj.getNombre_PerLectivo());
                    ;
                });
        tablaTrad.setRowCount(0);

    }

    private void setLblCarrera() {

        vista.getLblCarreraAsistencia().setText(listaPeriodos
                .stream()
                .filter(item -> item.getId_PerioLectivo() == getIdPeriodoLectivo())
                .map(c -> c.getCarrera().getNombre())
                .findFirst()
                .orElse("")
        );
    }

    private void cargarComboCiclo() {
        try {
            vista.getCmbCicloAsis().removeAllItems();

            CursoBD.selectCicloWhere(getIdDocente(), getIdPeriodoLectivo())
                    .stream()
                    .forEach(obj -> {
                        vista.getCmbCicloAsis().addItem(obj + "");
                    });
        } catch (NullPointerException e) {
        }
        tablaTrad.setRowCount(0);
    }

    private void cargarComboMaterias() {
        try {
            vista.getCmbAsignaturaAsis().removeAllItems();

            CursoMD curso = new CursoMD();
            DocenteMD docente = new DocenteMD();
            docente.setIdDocente(getIdDocente());
            curso.setDocente(docente);
            PeriodoLectivoMD periodo = new PeriodoLectivoMD();
            periodo.setId_PerioLectivo(getIdPeriodoLectivo());
            curso.setPeriodo(periodo);
            curso.setNombre(vista.getCmbCicloAsis().getSelectedItem().toString());

            listaMaterias = MateriaBD.selectWhere(curso);

            listaMaterias.stream()
                    .forEach(obj -> {
                        vista.getCmbAsignaturaAsis().addItem(obj.getNombre());
                        vista.getLblHorasAsis().setText("" + obj.getHorasPresenciales());
                    });

            //listaValidaciones = TipoDeNotaBD.selectWhere(getIdPeriodoLectivo());
            validarCombos();
        } catch (NullPointerException e) {
            vista.getCmbAsignaturaAsis().removeAllItems();
        }
        tablaTrad.setRowCount(0);
    }

    // Varios
    private int getIdDocente() {
        return listaDocentes.entrySet().stream()
                .filter((entry) -> (entry.getKey().equals(vista.getCmbDocenteAsis().getSelectedItem().toString())))
                .map(c -> c.getValue().getIdDocente()).findAny().get();
    }

    private int getIdPeriodoLectivo() {
        try {
            String periodo = vista.getCmbPeriodoLectivoAsis().getSelectedItem().toString();
            return listaPeriodos
                    .stream()
                    .filter(item -> item.getNombre_PerLectivo().equals(periodo))
                    .map(c -> c.getId_PerioLectivo())
                    .findAny()
                    .orElse(-1);
        } catch (NullPointerException e) {
        }
        return -1;
    }

    private void validarCombos() {

        if (vista.getCmbAsignaturaAsis().getItemCount() > 0) {
            vista.getBtnVerAsistencia().setEnabled(true);
        } else {
            vista.getBtnVerAsistencia().setEnabled(false);
        }
    }

    private int getHoras() {
        return listaMaterias.stream()
                .filter(item -> item.getNombre().equals(vista.getCmbAsignaturaAsis().getSelectedItem().toString()))
                .map(c -> c.getHorasPresenciales()).findFirst().orElse(1);
    }

//    private int calcularPorcentaje(int faltas, int horas) {
//        if (horas == 0) {
//            horas = 1;
//        }
//        return (faltas * 100) / horas;
//    }
    private int getSelectedRowTrad() {
        return vista.getTblAsistencia().getSelectedRow();
    }

    private int getSelectedColumTrad() {
        return vista.getTblAsistencia().getSelectedColumn();
    }

    private void activarForm(boolean estado) {

        if (rolSeleccionado.getNombre().toLowerCase().contains("docente")) {
            vista.getTxtBuscarAsis().setVisible(false);
            vista.getBtnBuscarAsis().setVisible(false);
            vista.getCmbDocenteAsis().setEnabled(false);
        } else {
            vista.getTxtBuscarAsis().setEnabled(estado);
            vista.getBtnBuscarAsis().setEnabled(estado);
            vista.getCmbDocenteAsis().setEnabled(estado);
        }

        vista.getCmbPeriodoLectivoAsis().setEnabled(estado);
        vista.getCmbCicloAsis().setEnabled(estado);
        vista.getCmbAsignaturaAsis().setEnabled(estado);
        vista.getTblAsistencia().setEnabled(estado);
    }

    private void cargarTabla(DefaultTableModel tabla, BiFunction<AlumnoCursoBD, DefaultTableModel, Void> funcionCarga) {
        new Thread(() -> {
            cargarTabla = false;
            String cursoNombre = vista.getCmbCicloAsis().getSelectedItem().toString();
            String nombreMateria = vista.getCmbAsignaturaAsis().getSelectedItem().toString();
            listaNotas = AlumnoCursoBD.selectWhere(cursoNombre, nombreMateria, getIdDocente(), getIdPeriodoLectivo());

            listaNotas.stream().forEach(obj -> {
                funcionCarga.apply(obj, tabla);
            });

            cargarTabla = true;
            vista.getLblResultados().setText(listaNotas.size() + " Resultados");
        }).start();
    }

    private void cargarComboSemanas() {
        try {

            System.out.println("-------------------------------------->  metodo carga de semanas");
            vista.getCmbSemana().removeAllItems();

            listaPeriodos = PeriodoLectivoBD.buscarNumSemanas(getIdDocente(), getIdPeriodoLectivo());
            if (listaPeriodos.size() > 0) {
                PeriodoLectivoMD periodo = listaPeriodos.get(0);
                System.out.println(periodo.getNumSemanas());
                for (int i = 1; i <= periodo.getNumSemanas(); i++) {
                   
                    vista.getCmbSemana().addItem("Semana " + String.valueOf(i));
                }
            }

//        listaPeriodos.forEach(p -> {
//            System.out.println("Semana: "+p.getNumSemanas());
//        
//        });
        } catch (Exception e) {
        }
    }

    //Agregar Filas
    private BiFunction<AlumnoCursoBD, DefaultTableModel, Void> agregarFilasTrad() {
        return (obj, tabla) -> {

            //System.out.println(obj);
            tabla.addRow(new Object[]{
                tabla.getDataVector().size() + 1,
                obj.getAlumno().getIdentificacion(),
                obj.getAlumno().getPrimerApellido(),
                obj.getAlumno().getSegundoApellido(),
                obj.getAlumno().getPrimerNombre(),
                obj.getAlumno().getSegundoNombre(),
                (int) Middlewares.conversor("" + obj.getNumFalta()),
                obj.getNumFalta(),});
            return null;
        };
    }

    //Eventos
    private void btnImprimir(ActionEvent e) {

    }

    private void btnVerAsistencia(ActionEvent e) {
        if (cargarTabla) {
            String modalidad = listaPeriodos.stream()
                    .filter(item -> item.getId_PerioLectivo() == getIdPeriodoLectivo())
                    .map(c -> c.getCarrera().getModalidad()).findFirst().orElse("");
            jTbl.removeAll();
            tablaTrad.setRowCount(0);
            cargarTabla(tablaTrad, agregarFilasTrad());

        } else {
            JOptionPane.showMessageDialog(vista, "YA HAY UNA CARGA PENDIENTE!");
        }

        vista.setTitle("Asistencia Alumnos " + vista.getCmbCicloAsis().getSelectedItem().toString());
    }

    private void buscarDocentes() {
        activarForm(false);
        vista.getCmbDocenteAsis().setSelectedItem(listaDocentes
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue().getIdentificacion().equals(vista.getTxtBuscarAsis().getText()))
                .map(c -> c.getKey())
                .findFirst()
                .orElse("")
        );
        activarForm(true);
    }

    public void CargarCombo(JTable tabla, TableColumn columna) {
        JComboBox c = new JComboBox();
        c.addItem("Aprobado");
        c.addItem("Reprobado");

        columna.setCellEditor(new DefaultCellEditor(c));
        DefaultTableCellRenderer r = new DefaultTableCellRenderer();
        r.setToolTipText("Seleccionar");
        columna.setCellRenderer(r);
    }

}
