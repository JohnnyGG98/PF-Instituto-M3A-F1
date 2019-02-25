
package modelo.periodolectivo;

import java.time.LocalDate;
import modelo.carrera.CarreraMD;
import modelo.persona.DocenteMD;

public class PeriodoLectivoMD extends CarreraMD{
    
    private int id_PerioLectivo;
    private String nombre_PerLectivo, observacion_PerLectivo;
    private boolean activo_PerLectivo;
    private LocalDate fecha_Inicio, fecha_Fin;

    public PeriodoLectivoMD() {
    }

    public PeriodoLectivoMD(int id_PerioLectivo, String nombre_PerLectivo, String observacion_PerLectivo, boolean activo_PerLectivo, LocalDate fecha_Inicio, LocalDate fecha_Fin, int id, String codigo, String nombre, LocalDate fechaInicio, LocalDate fechaFin, String modalidad, DocenteMD coordinador) {
        super(id, codigo, nombre, fechaInicio, fechaFin, modalidad, coordinador);
        this.id_PerioLectivo = id_PerioLectivo;
        this.nombre_PerLectivo = nombre_PerLectivo;
        this.observacion_PerLectivo = observacion_PerLectivo;
        this.activo_PerLectivo = activo_PerLectivo;
        this.fecha_Inicio = fecha_Inicio;
        this.fecha_Fin = fecha_Fin;
    }

    public int getId_PerioLectivo() {
        return id_PerioLectivo;
    }

    public void setId_PerioLectivo(int id_PerioLectivo) {
        this.id_PerioLectivo = id_PerioLectivo;
    }

    public String getNombre_PerLectivo() {
        return nombre_PerLectivo;
    }

    public void setNombre_PerLectivo(String nombre_PerLectivo) {
        this.nombre_PerLectivo = nombre_PerLectivo;
    }

    public String getObservacion_PerLectivo() {
        return observacion_PerLectivo;
    }

    public void setObservacion_PerLectivo(String observacion_PerLectivo) {
        this.observacion_PerLectivo = observacion_PerLectivo;
    }

    public boolean isActivo_PerLectivo() {
        return activo_PerLectivo;
    }

    public void setActivo_PerLectivo(boolean activo_PerLectivo) {
        this.activo_PerLectivo = activo_PerLectivo;
    }

    public LocalDate getFecha_Inicio() {
        return fecha_Inicio;
    }

    public void setFecha_Inicio(LocalDate fecha_Inicio) {
        this.fecha_Inicio = fecha_Inicio;
    }

    public LocalDate getFecha_Fin() {
        return fecha_Fin;
    }

    public void setFecha_Fin(LocalDate fecha_Fin) {
        this.fecha_Fin = fecha_Fin;
    }

    
    
    
}