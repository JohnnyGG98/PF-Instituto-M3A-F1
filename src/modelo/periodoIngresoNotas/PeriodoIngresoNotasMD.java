/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.periodoIngresoNotas;

import java.time.LocalDate;

/**
 *
 * @author MrRainx
 */
public class PeriodoIngresoNotasMD {

    private int idPeriodoIngreso;
    private LocalDate fechaInicio;
    private LocalDate fechaCierre;
    private int idPeriodoLectivo;
    private int idTipoNota;

    public PeriodoIngresoNotasMD(int idPeriodoIngreso, LocalDate fechaInicio, LocalDate fechaCierre, int idPeriodoLectivo, int idTipoNota) {
        this.idPeriodoIngreso = idPeriodoIngreso;
        this.fechaInicio = fechaInicio;
        this.fechaCierre = fechaCierre;
        this.idPeriodoLectivo = idPeriodoLectivo;
        this.idTipoNota = idTipoNota;
    }

    public PeriodoIngresoNotasMD() {
    }

    public int getIdPeriodoIngreso() {
        return idPeriodoIngreso;
    }

    public void setIdPeriodoIngreso(int idPeriodoIngreso) {
        this.idPeriodoIngreso = idPeriodoIngreso;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaCierre() {
        return fechaCierre;
    }

    public void setFechaCierre(LocalDate fechaCierre) {
        this.fechaCierre = fechaCierre;
    }

    public int getIdPeriodoLectivo() {
        return idPeriodoLectivo;
    }

    public void setIdPeriodoLectivo(int idPeriodoLectivo) {
        this.idPeriodoLectivo = idPeriodoLectivo;
    }

    public int getIdTipoNota() {
        return idTipoNota;
    }

    public void setIdTipoNota(int idTipoNota) {
        this.idTipoNota = idTipoNota;
    }

    @Override
    public String toString() {
        return "PeriodoIngresoNotas{" + "idPeriodoIngreso=" + idPeriodoIngreso + ", fechaInicio=" + fechaInicio + ", fechaCierre=" + fechaCierre + ", idPeriodoLectivo=" + idPeriodoLectivo + ", idTipoNota=" + idTipoNota + '}';
    }

}