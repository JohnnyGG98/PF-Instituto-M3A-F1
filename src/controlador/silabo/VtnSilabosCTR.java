package controlador.silabo;

import controlador.Libraries.Effects;
import controlador.Libraries.abstracts.AbstractVTN;
import controlador.Libraries.cellEditor.ComboBoxCellEditor;
import controlador.principal.VtnPrincipalCTR;
import controlador.silabo.frm.FRMSilaboCTR;
import java.awt.event.ActionEvent;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import javax.swing.JOptionPane;
import javax.swing.event.CaretEvent;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import utils.CONS;
import modelo.periodolectivo.PeriodoLectivoMD;
import modelo.silabo.NEWPeriodoLectivoBD;
import modelo.silabo.NEWSilaboBD;
import modelo.silabo.SilaboMD;
import modelo.validaciones.Validar;
import vista.silabos.VtnSilabos;

/**
 *
 * @author MrRainx
 */
public class VtnSilabosCTR extends AbstractVTN<VtnSilabos, SilaboMD> {

    private final NEWSilaboBD SILABO_CONN = NEWSilaboBD.single();
    private List<PeriodoLectivoMD> periodos;

    public VtnSilabosCTR(VtnPrincipalCTR desktop) {
        super(desktop);
        vista = new VtnSilabos();
        modelo = new SilaboMD();
    }

    @Override
    public void Init() {
        setTable(vista.getTbl());

        this.getPeriodos();

        if (CONS.USUARIO.isIsSuperUser()) {
            vista.getChxPeriodos().setVisible(true);
        }
        try {
            cargarCmbPeriodo();
            setLista();
            cargarTabla(cargador());

        } catch (NullPointerException e) {
        }

        InitEventos();
        super.Init();
    }

    private void InitEventos() {
        vista.getBtnNuevo().addActionListener(this::btnNuevo);
        vista.getBtnEditar().addActionListener(this::btnEditar);
        vista.getBtnEliminar().addActionListener(this::btnEliminar);
        vista.getCmbPeriodo().addActionListener(this::cmbPeriodo);
        vista.getBtnImprimir().addActionListener(this::btnImprimir);
        vista.getTxtBuscar().addCaretListener(this::txtBuscar);
        vista.getBtnInformacion().addActionListener(this::btnInformacion);
        vista.getBtnRefresh().addActionListener(this::btnRefresh);

        vista.getChxPeriodos().addActionListener(this::chxPeriodos);

        tableM.addTableModelListener(new TableModelListener() {
            boolean active = false;

            @Override
            public void tableChanged(TableModelEvent e) {

                if (!active && e.getType() == TableModelEvent.UPDATE) {
                    active = true;
                    cmbTblEstado();
                    active = false;
                }

            }

        });

        boolean estado = CONS.ROL.getNombre().equalsIgnoreCase("COORDINADOR")
                || CONS.ROL.getNombre().equalsIgnoreCase("DEV")
                || CONS.USUARIO.isIsSuperUser();

        vista.getTbl()
                .getColumnModel()
                .getColumn(5)
                .setCellEditor(new ComboBoxCellEditor(
                        estado,
                        Arrays.asList("APROBADO", "PENDIENTE", "REVISAR"))
                );
    }

    /*
        METODOS
     */
    private void cargarCmbPeriodo() {
        vista.getCmbPeriodo().removeAllItems();

        periodos.stream()
                .map(c -> c.getNombre())
                .forEach(vista.getCmbPeriodo()::addItem);

    }

    private PeriodoLectivoMD getPeriodoCmb() {
        return periodos.stream().filter(item -> item.getNombre().equalsIgnoreCase(vista.getCmbPeriodo().getSelectedItem().toString()))
                .findFirst()
                .get();
    }

    private void getPeriodos() {
        if (CONS.ROL.getNombre().equalsIgnoreCase("DOCENTE")) {
            periodos = NEWPeriodoLectivoBD.getMisPeriodosBy(
                    CONS.USUARIO.getPersona().getIdPersona()
            );
            vista.getBtnEliminar().setEnabled(false);

        } else if (CONS.ROL.getNombre().equalsIgnoreCase("COORDINADOR")) {

            periodos = NEWPeriodoLectivoBD.getPeriodosCoordinador(CONS.USUARIO.getPersona().getIdPersona());

        }
    }

    private Consumer<SilaboMD> cargador() {
        return obj -> {
            String fechaGeneracion = "SIN FECHA";
            if (obj.getFechaGeneracion() != null) {
                fechaGeneracion = obj.getFechaGeneracion().toString();
            }
            tableM.addRow(new Object[]{
                obj.getID(),
                tableM.getRowCount() + 1,
                obj.getMateria().getNombre(),
                obj.getPeriodo().getNombre(),
                fechaGeneracion,
                SilaboMD.getEstadoStr(obj.getEstado())
            });
        };
    }

    private SilaboMD getSilaboSeleccionadoTbl() {
        int row = getSelectedRow();
        if (row != -1) {
            int id = Integer.valueOf(table.getValueAt(row, 0).toString());
            return lista.stream()
                    .filter(item -> item.getID() == id)
                    .findFirst()
                    .get();
        }
        return null;
    }

    private void imprimirSilabosDuales(SilaboMD silabo) {
        Object[] opciones = new Object[]{
            "Silabo Dual",
            "Silabo Dual /semanas"
        };

        int opcion = JOptionPane.showOptionDialog(
                vista,
                "GENERAR SILABO",
                "QUE TIPO DE SILABO DESEA GENERAR?",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                opciones,
                "Cancelar"
        );

        switch (opcion) {

            case 0://IMPRIME SILABO DUAL
                NEWSilaboBD.imprimirProgramaAnalitico(silabo);
                break;

            case 1://IMPRIME SILABO DUAL CON UN NUMERO DE SEMANAS
                String semanas = JOptionPane.showInputDialog("Escriba el numero de semanas");

                if (semanas != null) {

                    if (Validar.esNumeros(semanas)) {
                        int numSemanas = Integer.parseInt(semanas);
                        if (numSemanas >= 6) {

                            NEWSilaboBD.imprimirProgramaAnaliticoConSemanas(silabo, numSemanas);

                        } else {
                            JOptionPane.showMessageDialog(vista, "Debe indicar mas de seis semanas de clases por periodo ");
                        }
                    } else {
                        JOptionPane.showMessageDialog(vista, "Solo puede ingresar numeros.");
                    }

                    break;

                }
        }
    }

    private void setLista() {
        try {

            PeriodoLectivoMD periodo = periodos.get(vista.getCmbPeriodo()
                    .getSelectedIndex());

            if (CONS.ROL.getNombre().equalsIgnoreCase("DOCENTE")) {
                lista = NEWSilaboBD.findBy(
                        user.getPersona().getIdentificacion(),
                        periodo.getID()
                );

            } else if (CONS.ROL.getNombre().equalsIgnoreCase("COORDINADOR")) {

                lista = NEWSilaboBD.getSilabosPeriodo(
                        getPeriodoCmb().getID()
                );

            } else if (CONS.USUARIO.isIsSuperUser()) {
                lista = NEWSilaboBD.getSilabosPeriodo(periodo.getID());
            }
        } catch (ArrayIndexOutOfBoundsException e) {
        }
    }

    private void mensajeEditando() {
        JOptionPane.showMessageDialog(
                vista,
                "EL SILABO NO ESTA DISPOBIBLE ACTUALMENTE\n\n"
                + "" + modelo.getEditadoPor().getIdentificacion() + " "
                + "" + modelo.getEditadoPor().getPrimerApellido() + " "
                + "" + modelo.getEditadoPor().getPrimerNombre() + " \n\n"
                + "ESTA TRABAJANDO EN EL SILABO"
                + ""
                + "",
                "ALERTA!!",
                JOptionPane.WARNING_MESSAGE
        );
    }

    private void validarEstadoParaEditar(SilaboMD silabo) {
        if (silabo.getEstado() == SilaboMD.APROBADO) {
            JOptionPane.showMessageDialog(
                    vista,
                    "NO PUEDE EDITAR UN SILABO APROBADO",
                    "ALERTA!!",
                    JOptionPane.INFORMATION_MESSAGE
            );
        } else {

            FRMSilaboCTR ctr = new FRMSilaboCTR(desktop, silabo);
            ctr.editar();
        }
    }

    /*
        EVENTOS
     */
    private void btnImprimir(ActionEvent e) {
        new Thread(() -> {

            Effects.setLoadCursor(vista);

            vista.getLblEstado().setVisible(true);
            vista.getLblEstado().setText("SE ESTA IMPRIMIENTO EL SILABO ESPERE POR FAVOR");
            vista.getBtnImprimir().setEnabled(false);
            int row = vista.getTbl().getSelectedRow();

            if (row == -1) {
                JOptionPane.showMessageDialog(vista, "DEBE SELECCIONAR UN SILABO PRIMERO!!", "Aviso", JOptionPane.ERROR_MESSAGE);
            } else {

                SilaboMD silabo = getSilaboSeleccionadoTbl();
                if (silabo != null) {
                    String modalidad = silabo.getPeriodo().getCarrera().getModalidad();

                    if (modalidad.equalsIgnoreCase("PRESENCIAL")
                            || modalidad.equalsIgnoreCase("TRADICIONAL")) {

                        NEWSilaboBD.imprimirSilabo(silabo);
                    } else {
                        imprimirSilabosDuales(silabo);
                    }

                }

            }

            vista.getBtnImprimir().setEnabled(true);
            vista.getLblEstado().setText("");
            Effects.setDefaultCursor(vista);

        }).start();

    }

    private void btnNuevo(ActionEvent e) {
        VtnConfigSilaboCTR vtn = new VtnConfigSilaboCTR(desktop);
        vtn.Init();
        vtn.setVtnSilabos(this);
    }

    private void btnEditar(ActionEvent e) {

        SilaboMD silabo = getSilaboSeleccionadoTbl();
        if (silabo != null) {

            //silabo = SILABO_CONN.getDisponibilidad(silabo);
            silabo = SILABO_CONN.getSilaboById(
                    Integer.valueOf(table.getValueAt(table.getSelectedRow(), 0).toString())
            );
            validarEstadoParaEditar(silabo);
            /*
            if (silabo.getEditadoPor().getIdentificacion() != null) {
                if (!silabo.getEditadoPor().getIdentificacion().equals(CONS.USUARIO.getPersona().getIdentificacion())
                        || silabo.isEditando()) {

                    //mensajeEditando();

                } else {
                    // Abrimos el formulario  
                    silabo = SILABO_CONN.getSilaboById(
                            Integer.valueOf(table.getValueAt(table.getSelectedRow(), 0).toString())
                    );
                    validarEstadoParaEditar(silabo);
                }

            } else {
                silabo = SILABO_CONN.getSilaboById(
                        Integer.valueOf(table.getValueAt(table.getSelectedRow(), 0).toString())
                );
                validarEstadoParaEditar(silabo);
            }*/

        }

    }

    private void btnEliminar(ActionEvent e) {

        SilaboMD silabo = getSilaboSeleccionadoTbl();
        if (silabo != null) {
            String MENSAJE_ELIMINAR = String.format(
                    "ESTA SEGURO DE ELIMINAR EL SILABO:\n"
                    + "PERIODO LECTIVO:\n"
                    + "MATERIA:%s\n"
                    + "RECUERDE QUE SI ELIMINA EL SILABO SE LE BORRARA:\n"
                    + "SUS AVANCES DE SILABO Y PLANES DE CLASE",
                    //PARAMETROS
                    silabo.getPeriodo().getNombre(),
                    silabo.getMateria().getNombre()
            );

            int opcionEliminado = JOptionPane.showConfirmDialog(
                    vista,
                    MENSAJE_ELIMINAR,
                    "ESTA SEGURO?",
                    JOptionPane.YES_NO_OPTION
            );

            if (opcionEliminado == JOptionPane.YES_OPTION) {
                boolean estado = NEWSilaboBD.eliminar(silabo);

                if (estado) {
                    JOptionPane.showMessageDialog(vista, "SE HA ELIMINADO CORRECTAMENTE");
                } else {
                    JOptionPane.showMessageDialog(vista, "HA HABIDO UN PROBLEMA");
                }
            }

        }

        btnRefresh(e);

    }

    private void cmbPeriodo(ActionEvent e) {
        setLista();
        cargarTabla(cargador());

    }

    private void txtBuscar(CaretEvent e) {
        tableM.setRowCount(0);
        String buscar = vista.getTxtBuscar().getText().toLowerCase();
        lista.stream()
                .filter(item -> item.getMateria().getNombre().toLowerCase().contains(buscar))
                .forEach(cargador());
    }

    private void cmbTblEstado() {
        int colum = table.getSelectedColumn();
        int row = getSelectedRow();
        SilaboMD silabo = getSilaboSeleccionadoTbl();

        if (silabo != null) {
            String estado = table.getValueAt(row, colum).toString();

            if (silabo.getEstado() != SilaboMD.getEstadoInt(estado)) {
                silabo.setEstado(SilaboMD.getEstadoInt(estado));
                cargarTabla(cargador());
                NEWSilaboBD.editarEstado(silabo);
                //TODO: AGREGAR EL METODO DE LA BASE DE DATOS PARA CAMBIAR EL ESTADO
            }
        }
    }

    private void btnInformacion(ActionEvent e) {

        SilaboMD silabo = getSilaboSeleccionadoTbl();
        if (silabo != null) {
            String informacion = NEWSilaboBD.getInformacion(silabo);
            JOptionPane.showMessageDialog(vista, informacion, "INFORMACION DEL SILABO", JOptionPane.PLAIN_MESSAGE);

        }
    }

    private void btnRefresh(ActionEvent e) {
        setLista();
        cargarTabla(cargador());
    }

    private void chxPeriodos(ActionEvent e) {
        tableM.setRowCount(0);
        vista.getCmbPeriodo().removeAllItems();

        if (vista.getChxPeriodos().isSelected()) {
            this.periodos = NEWPeriodoLectivoBD.selectAllDEV();
        } else {
            this.getPeriodos();
        }

        cargarCmbPeriodo();

    }

}
