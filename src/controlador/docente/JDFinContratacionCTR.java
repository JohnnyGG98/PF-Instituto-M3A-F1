package controlador.docente;

import controlador.principal.DVtnCTR;
import controlador.principal.VtnPrincipalCTR;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import modelo.curso.CursoMD;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.periodolectivo.PeriodoLectivoBD;
import modelo.periodolectivo.PeriodoLectivoMD;
import modelo.persona.DocenteBD;
import modelo.persona.DocenteMD;
import modelo.validaciones.Validar;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import vista.docente.JDFinContratacion;

/**
 *
 * @author Lina
 */
public class JDFinContratacionCTR extends DVtnCTR {

    private PeriodoLectivoBD periodoBD;
    private final DocenteBD dc;
    private DocenteMD docenteMD;
    private final String cedula;
    private final JDFinContratacion frmFinContrato;
    private static LocalDate fechaInicio;
    //private DefaultTableModel mdTbl;
    private boolean guardar = false;

    public JDFinContratacionCTR(VtnPrincipalCTR ctrPrin,
            String cedula) {
        super(ctrPrin);
        this.dc = new DocenteBD(ctrPrin.getConecta());
        this.cedula = cedula;
        this.frmFinContrato = new JDFinContratacion(ctrPrin.getVtnPrin(), false);
        this.frmFinContrato.setLocationRelativeTo(ctrPrin.getVtnPrin());
        this.frmFinContrato.setVisible(true);
        this.frmFinContrato.setTitle("Fin de Contrato");
    }

    public void iniciar() {
        docenteMD = dc.buscarDocente(cedula);
        frmFinContrato.getBtnReasignarMateria().setEnabled(false);
        frmFinContrato.getBtnGuardar().setText("Siguiente");
        frmFinContrato.getBtnAnterior().setEnabled(false);
        frmFinContrato.getbtninforme_fin_docente().addActionListener(e -> botoninformeDocente());
        frmFinContrato.getBtnReasignarMateria().addActionListener(e -> reasignarMateria());
        frmFinContrato.getTpFrm().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int pos = frmFinContrato.getTpFrm().getSelectedIndex();
                if (pos > 0) {
                    frmFinContrato.getBtnAnterior().setEnabled(true);
                    habilitarGuardar();
                } else {
                    frmFinContrato.getBtnAnterior().setEnabled(false);
                    habilitarGuardar();
                }
            }
        });

        iniciarFinContrato();
        iniciarPeriodosDocente();
    }

    public void iniciarPeriodosDocente() {

        frmFinContrato.getLbl_ErrPeriodos().setVisible(false);
        frmFinContrato.getBtnAnterior().addActionListener(e -> pnlAnterior());
        frmFinContrato.getJcbPeriodos().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int pos = frmFinContrato.getJcbPeriodos().getSelectedIndex();
                if (pos > 0) {
                    frmFinContrato.getJcbPeriodos().setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
                    if (frmFinContrato.getLbl_ErrPeriodos() != null) {
                        frmFinContrato.getLbl_ErrPeriodos().setVisible(false);
                        String periodo = frmFinContrato.getJcbPeriodos().getSelectedItem().toString();
                        llenarTabla(periodo);
                    }
                } else {
                    frmFinContrato.getJcbPeriodos().setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
                    if (frmFinContrato.getLbl_ErrPeriodos() != null) {
                        frmFinContrato.getLbl_ErrPeriodos().setVisible(true);
                        DefaultTableModel modelo_Tabla;
                        modelo_Tabla = (DefaultTableModel) frmFinContrato.getTblMateriasCursos().getModel();
                        for (int i = frmFinContrato.getTblMateriasCursos().getRowCount() - 1; i >= 0; i--) {
                            modelo_Tabla.removeRow(i);
                        }
                    }
                }
            }

        });

        listaPeriodos();
    }

    public void listaPeriodos() {
        periodoBD = new PeriodoLectivoBD(ctrPrin.getConecta());
        List<PeriodoLectivoMD> listaPeriodos = periodoBD.periodoDocente(cedula);
        for (int i = 0; i < listaPeriodos.size(); i++) {
            frmFinContrato.getJcbPeriodos().addItem(listaPeriodos.get(i).getNombre_PerLectivo());

        }

    }

    public void llenarTabla(String periodo) {
        System.out.println("Periodo " + periodo);
        DocenteBD d = new DocenteBD(ctrPrin.getConecta());
        PeriodoLectivoBD p = new PeriodoLectivoBD(ctrPrin.getConecta());
        DefaultTableModel modelo_Tabla;
        modelo_Tabla = (DefaultTableModel) frmFinContrato.getTblMateriasCursos().getModel();
        for (int i = frmFinContrato.getTblMateriasCursos().getRowCount() - 1; i >= 0; i--) {
            modelo_Tabla.removeRow(i);
        }
        List<CursoMD> lista = d.capturarMaterias(p.buscarPeriodo(periodo).getId_PerioLectivo(), docenteMD.getIdDocente());
        int columnas = modelo_Tabla.getColumnCount();
        for (int i = 0; i < lista.size(); i++) {
            modelo_Tabla.addRow(new Object[columnas]);
            frmFinContrato.getTblMateriasCursos().setValueAt(lista.get(i).getMateria().getNombre(), i, 0);
            frmFinContrato.getTblMateriasCursos().setValueAt(lista.get(i).getNombre(), i, 1);
        }
    }

    private void aceptar() {
        frmFinContrato.getJcbPeriodos().getSelectedItem();

    }

    private void pnlAnterior() {
        frmFinContrato.getTpFrm().setSelectedIndex(0);
        frmFinContrato.getBtnAnterior().setEnabled(false);
        frmFinContrato.getBtnGuardar().setEnabled(true);
        frmFinContrato.getBtnGuardar().setText("Siguiente");
        habilitarGuardar();
    }

    public void iniciarFinContrato() {
        frmFinContrato.getLblErrorFechaFinContratacion().setVisible(false);
        frmFinContrato.getLblErrorObservacion().setVisible(false);
        //frmFinContrato.getBtnGuardar().setEnabled(false);
        frmFinContrato.getBtnGuardar().addActionListener(e -> guardarFinContratacion());

        frmFinContrato.getTxtObservacion().addKeyListener(new KeyAdapter() {

            public void keyReleased(KeyEvent e) {
                String Observacion = frmFinContrato.getTxtObservacion().getText();
                if (!Validar.esObservacion(Observacion)) {

                    frmFinContrato.getLblErrorObservacion().setVisible(true);

                } else {
                    frmFinContrato.getLblErrorObservacion().setVisible(false);
                }
                habilitarGuardar();
            }
        });

        frmFinContrato.getJdcFinContratacion().addMouseListener(new MouseAdapter() {
            public void mouseClicked() {
                if (validarFecha() == true) {
                    frmFinContrato.getLblErrorFechaFinContratacion().setVisible(false);
                } else {
                    frmFinContrato.getLblErrorFechaFinContratacion().setText("El inicio de contrato no puede ser \n mayor al de finalizacion");
                    frmFinContrato.getLblErrorFechaFinContratacion().setVisible(true);
                }
                habilitarGuardar();
            }
        });

        frmFinContrato.getCbx_Periodos().addActionListener(e -> habilitarGuardar());

        docenteMD = dc.buscarDocente(cedula);
    }

    public void habilitarGuardar() {
        String observacion;
        observacion = frmFinContrato.getTxtObservacion().getText();
        Date fecha = frmFinContrato.getJdcFinContratacion().getDate();
        int posPrd = frmFinContrato.getCbx_Periodos().getSelectedIndex();
        int pos = frmFinContrato.getTpFrm().getSelectedIndex();

        if (pos == 0) {
            if (observacion.equals("") == false && fecha != null) {
                if (frmFinContrato.getLblErrorFechaFinContratacion().isVisible() == true
                        || frmFinContrato.getLblErrorObservacion().isVisible() == true) {
                    frmFinContrato.getBtnGuardar().setEnabled(false);
                    guardar = false;
                } else {
                    frmFinContrato.getBtnGuardar().setEnabled(true);
                    frmFinContrato.getBtnGuardar().setText("Siguiente");
                    guardar = false;
                }
            } else {
                frmFinContrato.getBtnGuardar().setEnabled(true);
                frmFinContrato.getBtnGuardar().setText("Siguiente");
                guardar = false;
            }
        } else if (pos == 1) {
            if (observacion.equals("") == true && fecha == null && frmFinContrato.getLbl_ErrPeriodos().isVisible() == true) {
                frmFinContrato.getBtnGuardar().setText("Guardar");
                frmFinContrato.getBtnGuardar().setEnabled(false);
                guardar = false;
            } else if (observacion.equals("") == true && fecha == null && frmFinContrato.getLbl_ErrPeriodos().isVisible() == false) {
                frmFinContrato.getBtnGuardar().setText("Guardar");
                frmFinContrato.getBtnGuardar().setEnabled(false);
                guardar = false;
            }

            if (observacion.equals("") == false && fecha != null && posPrd == 0) {

                if (frmFinContrato.getLbl_ErrPeriodos().isVisible() == true) {
                    frmFinContrato.getBtnGuardar().setText("Guardar");
                    frmFinContrato.getBtnGuardar().setEnabled(false);
                    guardar = false;
                } else {
                    frmFinContrato.getBtnGuardar().setText("Siguiente");
                    frmFinContrato.getBtnGuardar().setEnabled(true);
                    guardar = false;
                }

            } else if (observacion.equals("") == false && fecha != null && posPrd > 0) {
                if (frmFinContrato.getLbl_ErrPeriodos().isVisible() == true) {
                    frmFinContrato.getBtnGuardar().setText("Guardar");
                    frmFinContrato.getBtnGuardar().setEnabled(false);
                    guardar = false;
                } else {
                    frmFinContrato.getBtnGuardar().setText("Guardar");
                    frmFinContrato.getBtnGuardar().setEnabled(true);
                    guardar = true;
                }

            }
        }
    }

    private void guardarFinContratacion() {

        String Observacion = "", fechaFinContra = "";
        Date fecha;

        Observacion = frmFinContrato.getTxtObservacion().getText().trim().toUpperCase();
        fecha = frmFinContrato.getJdcFinContratacion().getDate();

        if (!fechaFinContra.equals("")) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            fechaFinContra = sdf.format(fecha);
            validarFecha();
            System.out.println("DIA " + fechaFinContra);
        } else {
            guardar = false;
        }

        if (docenteMD.getFechaInicioContratacion().isAfter(convertirDate(fecha)) == false
                && docenteMD.getFechaInicioContratacion().isEqual(convertirDate(fecha)) == false) {
            guardar = true;
            frmFinContrato.getLblErrorFechaFinContratacion().setVisible(false);
        } else {
            guardar = false;
            frmFinContrato.getLblErrorFechaFinContratacion().setText("La fecha de inicio de contrato no puede ser mayor a la de finalizacion");
            frmFinContrato.getLblErrorFechaFinContratacion().setVisible(true);
        }
        
        if (guardar == true) {
//            DocenteMD docente = new DocenteMD();
//            docente.setObservacion(Observacion);
//            docente.setFechaFinContratacion(convertirDate(fecha));

            System.out.println("Se guarda en base de datos");
            frmFinContrato.getBtnGuardar().setEnabled(false);
            frmFinContrato.getBtnReasignarMateria().setEnabled(true);

        } else {
            frmFinContrato.getTpFrm().setSelectedIndex(1);
            frmFinContrato.getBtnAnterior().setEnabled(true);
            habilitarGuardar();

        }

    }

    public boolean validarFecha() {
        Date fecha;
        fecha = frmFinContrato.getJdcFinContratacion().getDate();

        if (docenteMD.getFechaInicioContratacion().isAfter(convertirDate(fecha)) == false
                && docenteMD.getFechaInicioContratacion().isEqual(convertirDate(fecha)) == false) {

            return true;
        } else {

            return false;
        }

    }

    public LocalDate convertirDate(Date fecha) {
        return Instant.ofEpochMilli(fecha.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
    }

    //llamada al informe de fin de contratacion
    public void llamainformeDocente() {
        JasperReport jr;
        String path = "/vista/reportes/INFORME_DOCENTE_RETIRADO.jasper";
        //int posfila = vtnDocente.getTblDocente().getSelectedRow();

        try {
            Map parametro = new HashMap();
            parametro.put("iddocente", docenteMD.getIdDocente());

            parametro.put("periodolectivo", frmFinContrato.getJcbPeriodos());
            parametro.put("periodolectivo", frmFinContrato.getCbx_Periodos().getSelectedItem().toString());
            jr = (JasperReport) JRLoader.loadObject(getClass().getResource(path));
            ctrPrin.getConecta().mostrarReporte(jr, parametro, "Informe de Retiro");

        } catch (JRException ex) {
            JOptionPane.showMessageDialog(null, "error" + ex);
        }
    }

    public void botoninformeDocente() {
        int s = JOptionPane.showOptionDialog(ctrPrin.getVtnPrin(),
                "Registro de persona \n"
                + "¿Dessea Imprimir el Registro realizado ?", "Informe de Retiro",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                new Object[]{"SI", "NO"}, "NO");
        switch (s) {
            case 0:
                llamainformeDocente();
                break;
            case 1:

                break;
            default:
                break;
        }
    }

    private void reasignarMateria() {
        posFila = frmFinContrato.getTblMateriasCursos().getSelectedRow();
        if (posFila >= 0) {
            JDReasignarMateriasCTR ctr = new JDReasignarMateriasCTR(ctrPrin, frmFinContrato.getTblMateriasCursos().getValueAt(posFila, 0).toString());
            ctr.iniciar();
        } else {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una fila ");
        }

    }

}
