/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.silabo.seguimiento;

import controlador.Libraries.abstracts.AbstractVTN;
import controlador.principal.VtnPrincipalCTR;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import modelo.curso.CursoMD;
import modelo.seguimientoSilabo.SeguimientoEvaluacionBD;
import modelo.seguimientoSilabo.SeguimientoEvaluacionMD;
import modelo.silabo.NEWCursoBD;
import modelo.silabo.NEWSilaboBD;
import modelo.silabo.SilaboMD;
import modelo.unidadSilabo.UnidadSilaboMD;
import utils.CONS;
import vista.silabos.seguimiento.VtnSeguimientoEvaluacion;

/**
 *
 * @author MrRainx
 */
public class VtnSeguimientoEvaluacionCTR extends AbstractVTN<VtnSeguimientoEvaluacion, SeguimientoEvaluacionMD> {

    private final NEWSilaboBD SILABO_CONN = NEWSilaboBD.single();
    private final NEWCursoBD CURSO_CONN = NEWCursoBD.single();
    private final SeguimientoEvaluacionBD CONN = SeguimientoEvaluacionBD.sigle();

    private List<SilaboMD> misSilabos = null;
    private List<CursoMD> misCursos = new ArrayList<>();

    public VtnSeguimientoEvaluacionCTR(VtnPrincipalCTR desktop) {
        super(desktop);
        vista = new VtnSeguimientoEvaluacion();
    }

    @Override
    public void Init() {

        // Gestion de Actividades de la Unidad
        setTable(vista.getTbl());
        new Thread(() -> {
            misSilabos = SILABO_CONN.getMisSilabosConUnidadesBy(CONS.USUARIO.getPersona().getIdentificacion());
            cargarCmbSilabos();
            super.Init(); //To change body of generated methods, choose Tools | Templates.
        }).start();

        InitEventos();

    }

    private void InitEventos() {

        vista.getCmbSilabo().addItemListener(this::cmbUnidades);
        vista.getBtnAgregar().addActionListener(this::btnNuevo);
        vista.getCmbUnidad().addActionListener(e -> buscarSeguimientosBd());
        vista.getCmbCursos().addActionListener(e -> buscarSeguimientosBd());

        vista.getBtnEditar().addActionListener(this::btnEditar);

        vista.getTbl().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                System.out.println(getSelectedRow());

            }
        });
    }

    /*
            OPERACIONES
     */
    private void buscarSeguimientosBd() {
        try {
            lista = CONN.getSeguimientosBy(
                    getCurso().getId(),
                    getUnidad().getIdUnidad()
            );
            cargarTabla(cargador());

        } catch (NullPointerException e) {
        }
    }

    private SeguimientoEvaluacionMD getSeguimiento() {
        return lista.get(getSelectedRow());
    }

    private SilaboMD getSilabo() {
        return misSilabos.stream()
                .filter(item -> item.nombrePeriodoMateria().equals(vista.getCmbSilabo().getSelectedItem().toString()))
                .findFirst()
                .orElse(null);
    }

    private UnidadSilaboMD getUnidad() throws NullPointerException {
        return getSilabo()
                .getUnidades()
                .stream()
                .filter(item -> item.getNumeroUnidad() == Integer.valueOf(vista.getCmbUnidad().getSelectedItem().toString()))
                .findFirst()
                .orElse(null);
    }

    private CursoMD getCurso() throws NullPointerException {
        return misCursos.stream()
                .filter(item -> item.getNombre().equals(vista.getCmbCursos().getSelectedItem().toString()))
                .findFirst()
                .orElse(null);
    }

    private Consumer<SeguimientoEvaluacionMD> cargador() {

        return obj -> {
            tableM.addRow(new Object[]{
                obj.getID(),
                obj.getEvaluacion().getIdUnidad().getNumeroUnidad(),
                obj.getEvaluacion().getInstrumento(),
                obj.getEvaluacion().getIdTipoActividad().getNombreTipoActividad(),
                obj.getEvaluacion().getValoracion(),
                SeguimientoEvaluacionMD.formatoToString(obj.getFormato())
            });
        };
    }

    private void cargarCmbSilabos() {
        misSilabos.stream()
                .map(c -> c.nombrePeriodoMateria())
                .forEach(vista.getCmbSilabo()::addItem);
    }

    private void cargarCursos() {
        vista.getCmbCursos().removeAllItems();
        misCursos = CURSO_CONN.getMisCursosBy(
                CONS.USUARIO.getPersona().getIdentificacion(),
                getSilabo().getPeriodo().getID(),
                getSilabo().getMateria().getId()
        );

        misCursos.stream()
                .map(c -> c.getNombre())
                .forEach(vista.getCmbCursos()::addItem);

    }

    private void setTxtDescripcion() {

    }

    /*
            EVENTOS
     */
    private void cmbUnidades(ItemEvent e) {

        vista.getCmbUnidad().removeAllItems();

        misSilabos.stream()
                .filter(item -> item.nombrePeriodoMateria().equals(vista.getCmbSilabo().getSelectedItem().toString()))
                .flatMap(c -> c.getUnidades().stream())
                .map(c -> c.getNumeroUnidad() + "")
                .forEach(vista.getCmbUnidad()::addItem);

        cargarCursos();
    }

    private void btnNuevo(ActionEvent e) {
        VtnConfigSeguimientoEvalCTR vtn = new VtnConfigSeguimientoEvalCTR(desktop);
        vtn.Init();

    }

    private void btnEditar(ActionEvent e) {

        FrmSeguimientoEvalCTR form = new FrmSeguimientoEvalCTR(desktop, getSilabo(), getUnidad(), getCurso());
        form.Init();

    }
}