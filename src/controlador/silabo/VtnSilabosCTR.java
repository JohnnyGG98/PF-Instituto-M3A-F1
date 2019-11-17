package controlador.silabo;

import controlador.Libraries.abstracts.AbstractVTN;
import controlador.Libraries.cellEditor.ComboBoxCellEditor;
import controlador.principal.VtnPrincipalCTR;
import controlador.silabo.frm.FRMSilaboCTR;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import javax.swing.JOptionPane;
import javax.swing.event.CaretEvent;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import modelo.CONS;
import modelo.carrera.CarreraBD;
import modelo.carrera.CarreraMD;
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

    private List<CarreraMD> carreras;

    public VtnSilabosCTR(VtnPrincipalCTR desktop) {
        super(desktop);
        vista = new VtnSilabos();

        modelo = new SilaboMD();
    }

    public VtnSilabos getVista() {
        return vista;
    }

    @Override
    public void Init() {
        setTable(vista.getTbl());
        cargarCmbCarreras();
        InitEventos();
        super.Init();
        setLista();
        cargarTabla(cargador());
    }

    private void InitEventos() {
        vista.getBtnNuevo().addActionListener(this::btnNuevo);
        vista.getBtnEditar().addActionListener(this::btnEditar);
        vista.getBtnEliminar().addActionListener(this::btnEliminar);
        vista.getCmbCarrera().addItemListener(this::cmbCarrera);
        vista.getBtnImprimir().addActionListener(this::btnImprimir);
        vista.getTxtBuscar().addCaretListener(this::txtBuscar);
        vista.getBtnInformacion().addActionListener(this::btnInformacion);

        tableM.addTableModelListener(new TableModelListener() {
            boolean active = false;

            @Override
            public void tableChanged(TableModelEvent e) {

                if (!active && e.getType() == TableModelEvent.UPDATE) {
                    active = true;
                    cambiarEstado();
                    active = false;
                }

            }

        });

        List<String> estados = new ArrayList<>();
        estados.add("APROBADO");
        estados.add("PENDIENTE");
        estados.add("REVISAR");
        vista.getTbl()
                .getColumnModel()
                .getColumn(5)
                .setCellEditor(new ComboBoxCellEditor(true, estados));
    }

    /*
        METODOS
     */
    private void cargarCmbCarreras() {
        carreras = CarreraBD.findBy(
                CONS.USUARIO.getPersona().getIdentificacion()
        );

        carreras.stream()
                .map(c -> c.getNombre())
                .forEach(vista.getCmbCarrera()::addItem);
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
                SILABO_CONN.imprimirProgramaAnalitico(silabo);
                break;

            case 1://IMPRIME SILABO DUAL CON UN NUMERO DE SEMANAS
                String semanas = JOptionPane.showInputDialog("Escriba el numero de semanas");

                if (semanas != null) {

                    if (Validar.esNumeros(semanas)) {
                        int numSemanas = Integer.parseInt(semanas);
                        if (numSemanas >= 6) {

                            SILABO_CONN.imprimirProgramaAnaliticoConSemanas(silabo, numSemanas);

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
        CarreraMD carrera = carreras.get(vista.getCmbCarrera().getSelectedIndex());

        lista = SILABO_CONN.findBy(
                user.getPersona().getIdentificacion(), carrera.getId()
        );
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

    /*
        EVENTOS
     */
    private void btnImprimir(ActionEvent e) {
        new Thread(() -> {

            int row = vista.getTbl().getSelectedRow();

            if (row == -1) {
                JOptionPane.showMessageDialog(vista, "DEBE SELECCIONAR UN SILABO PRIMERO!!", "Aviso", JOptionPane.ERROR_MESSAGE);
            } else {

                SilaboMD silabo = getSilaboSeleccionadoTbl();
                if (silabo != null) {
                    String modalidad = silabo.getPeriodo().getCarrera().getModalidad();

                    if (modalidad.equalsIgnoreCase("PRESENCIAL")
                            || modalidad.equalsIgnoreCase("TRADICIONAL")) {

                        SILABO_CONN.imprimirSilabo(silabo);
                    } else {
                        imprimirSilabosDuales(silabo);
                    }

                }

            }

        }).start();

    }

    private void btnNuevo(ActionEvent e) {
        VtnConfigSilaboCTR vtn = new VtnConfigSilaboCTR(desktop);
        vtn.Init();
        vtn.setVtnSilabos(this);
    }

    private void btnEditar(ActionEvent e) {
        try {

            modelo = getSilaboSeleccionadoTbl();
            if (modelo != null) {

                modelo = SILABO_CONN.getDisponibilidad(modelo);

                if (!modelo.getEditadoPor()
                        .getIdentificacion()
                        .equals(CONS.USUARIO.getPersona()
                                .getIdentificacion()
                        )
                        || modelo.isEditando()) {
                    mensajeEditando();
                } else {
                    // Abrimos el formulario  
                    modelo = SILABO_CONN.getSilaboById(
                            Integer.valueOf(table.getValueAt(
                                    table.getSelectedRow(), 0
                            ).toString())
                    );
                    FRMSilaboCTR ctr = new FRMSilaboCTR(desktop, modelo);
                    ctr.editar();
                }

            }

        } catch (NullPointerException ex) {
            //SI ENTRA AQUI ES PORQUE NO HAY NADIE EDITANDO
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
                boolean estado = SILABO_CONN.eliminar(silabo);

                if (estado) {
                    JOptionPane.showMessageDialog(vista, "SE HA ELIMINADO CORRECTAMENTE");
                } else {
                    JOptionPane.showMessageDialog(vista, "HA HABIDO UN PROBLEMA");
                }
            }

        }

    }

    private void cmbCarrera(ItemEvent e) {
        setLista();
        cargarTabla(cargador());

    }

    private void txtBuscar(CaretEvent e) {
        tableM.setRowCount(0);
        String buscar = vista.getTxtBuscar().getText().toLowerCase();
        lista.stream()
                .filter(item -> item.getPeriodo().getNombre().toLowerCase().contains(buscar)
                || item.getMateria().getNombre().toLowerCase().contains(buscar)
                ).forEach(cargador());
    }

    private void cambiarEstado() {
        int colum = table.getSelectedColumn();
        int row = getSelectedRow();
        SilaboMD silabo = getSilaboSeleccionadoTbl();

        if (silabo != null) {
            String estado = table.getValueAt(row, colum).toString();

            if (silabo.getEstado() != SilaboMD.getEstadoInt(estado)) {
                silabo.setEstado(SilaboMD.getEstadoInt(estado));
                cargarTabla(cargador());
                //TODO: AGREGAR EL METODO DE LA BASE DE DATOS PARA CAMBIAR EL ESTADO
            }
        }
    }

    private void btnInformacion(ActionEvent e) {

        SilaboMD silabo = getSilaboSeleccionadoTbl();
        if (silabo != null) {
            String informacion = SILABO_CONN.getInformacion(silabo);
            JOptionPane.showMessageDialog(vista, informacion, "INFORMACION DEL SILABO", JOptionPane.PLAIN_MESSAGE);

        }
    }

}
