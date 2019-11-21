/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.silabo.seguimiento;

import controlador.Libraries.abstracts.AbstractVTN;
import controlador.principal.VtnPrincipalCTR;
import java.awt.event.ItemEvent;
import java.util.List;
import modelo.curso.CursoMD;
import modelo.seguimientoSilabo.SeguimientoEvaluacionMD;
import modelo.silabo.NEWCursoBD;
import modelo.silabo.NEWSilaboBD;
import modelo.silabo.SilaboMD;
import modelo.unidadSilabo.UnidadSilaboMD;
import utils.CONS;
import vista.silabos.seguimiento.VtnConfigSeguimientoEval;

/**
 *
 * @author MrRainx
 */
public class VtnConfigSeguimientoEvalCTR extends AbstractVTN<VtnConfigSeguimientoEval, SeguimientoEvaluacionMD> {

    private final NEWSilaboBD SILABO_CONN = NEWSilaboBD.single();
    private final NEWCursoBD CURSO_CONN = NEWCursoBD.single();

    private List<SilaboMD> misSilabos = null;

    private List<CursoMD> misCursos = null;

    public VtnConfigSeguimientoEvalCTR(VtnPrincipalCTR desktop) {
        super(desktop);
        this.vista = new VtnConfigSeguimientoEval();
    }

    @Override
    public void Init() {
        super.Init(); //To change body of generated methods, choose Tools | Templates.

        misSilabos = SILABO_CONN.getMisSilabosConUnidadesBy(CONS.USUARIO.getPersona().getIdentificacion());
        cargarCmbSilabos();
        InitEventos();
    }

    private void InitEventos() {

        vista.getCmbSilabo().addItemListener(this::cmbUnidades);
        vista.getCmbUnidad().addItemListener(this::cmbCursos);

    }

    /*
        OPERACIONES
     */
    private void validar() {
    }

    private void cargarCmbSilabos() {
        misSilabos.stream()
                .map(c -> c.nombrePeriodoMateria())
                .forEach(vista.getCmbSilabo()::addItem);
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
    }

    private void cmbCursos(ItemEvent e) {
        try {

            vista.getCmbCurso().removeAllItems();
            misCursos = CURSO_CONN.getFaltantesSeguimientoEval(
                    getSilabo(),
                    getUnidad().getIdUnidad()
            );
            misCursos.stream()
                    .map(c -> c.getNombre())
                    .forEach(vista.getCmbCurso()::addItem);
        } catch (NullPointerException ex) {
        }

    }
}
