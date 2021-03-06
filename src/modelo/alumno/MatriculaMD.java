package modelo.alumno;

import java.time.LocalDateTime;
import modelo.periodolectivo.PeriodoLectivoMD;
import modelo.persona.AlumnoMD;

/**
 *
 * @author Johnny
 */
public class MatriculaMD {
    
    private int id;
    private AlumnoMD alumno; 
    private PeriodoLectivoMD periodo; 
    private LocalDateTime fecha; 
    private boolean activo; 
    private String tipo; 

    public MatriculaMD() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public AlumnoMD getAlumno() {
        return alumno;
    }

    public void setAlumno(AlumnoMD alumno) {
        this.alumno = alumno;
    }

    public PeriodoLectivoMD getPeriodo() {
        return periodo;
    }

    public void setPeriodo(PeriodoLectivoMD periodo) {
        this.periodo = periodo;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    
    public String getSoloFecha(){
        return fecha.getDayOfMonth()+"/"+fecha.getMonth()+"/"+fecha.getYear(); 
    }
    
    public String getSoloHora(){
        return fecha.getHour()+":"+fecha.getMinute(); 
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
}
