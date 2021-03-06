/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.vistaReportes;

import controlador.Libraries.Effects;
import controlador.principal.VtnPrincipalCTR;
import java.awt.event.ActionEvent;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import utils.CONS;
import modelo.carrera.CarreraBD;
import modelo.periodolectivo.PeriodoLectivoBD;
import modelo.periodolectivo.PeriodoLectivoMD;
import modelo.querys.Querys;
import vista.vistaReportes.VtnEstadosR;

/**
 *
 * @author MrRainx
 */
public class VtnEstadosCTR {

    private final VtnPrincipalCTR desktop;
    private final VtnEstadosR vista;
    private final PeriodoLectivoBD modelo;
    private final CarreraBD carrera;
    private List<PeriodoLectivoMD> periodos;
    private DefaultTableModel tabla;

    public VtnEstadosCTR(VtnPrincipalCTR desktop) {
        this.desktop = desktop;
        this.vista = new VtnEstadosR();
        this.modelo = new PeriodoLectivoBD();
        this.carrera = new CarreraBD();
    }

    //Inits
    public void Init() {
        Effects.addInDesktopPane(vista, desktop.getVtnPrin().getDpnlPrincipal());
        tabla = (DefaultTableModel) vista.getTbl().getModel();
        cargarPeriodos();

        InitEventos();
        InitPermisos();
    }

    private void InitEventos() {
        vista.getBtnVer().addActionListener(e -> btnVer(e));
        vista.getCmbPeriodos().addItemListener(e -> setCarrera());
        vista.getBtnReporte().addActionListener(e -> btnImprimir(e));
    }

    private void InitPermisos() {
        vista.getBtnReporte().getAccessibleContext().setAccessibleName("Asistencia-Estado-Reportes");
        CONS.activarBtns(vista.getBtnReporte());
    }

    //Metodos de Apoyo
    private void cargarPeriodos() {
        periodos = modelo.selectIdNombreAll();

        periodos.stream()
                .map(c -> c.getNombre())
                .forEach(vista.getCmbPeriodos()::addItem);
        setCarrera();
    }

    private void setCarrera() {
        vista.getLblCarrera().setText(carrera.selectWhere(getIdPeriodo()));
    }

    private void cargarTabla() {
        tabla.setRowCount(0);
        new Querys().selectReporteEstado(getIdPeriodo(), vista.getCmbEstado().getSelectedItem().toString())
                .forEach(tabla::addRow);
        vista.getLblResultados().setText(tabla.getDataVector().size() + " Resultados");
    }

    private int getIdPeriodo() {
        return periodos.stream()
                .filter(item -> item.getNombre().equalsIgnoreCase(vista.getCmbPeriodos().getSelectedItem().toString()))
                .map(c -> c.getID())
                .findFirst()
                .orElse(-1);
    }

    //Eventos
    private void btnVer(ActionEvent e) {
        cargarTabla();
    }

    private void btnImprimir(ActionEvent e) {
        Effects.setLoadCursor(vista);

        ReporteEstadoAlumCTR reportes = new ReporteEstadoAlumCTR(vista, getIdPeriodo());

        reportes.generarReporteEstadoAlumno();
        Effects.setDefaultCursor(vista);
    }
}
