package modelo.alumno;

import modelo.materia.MateriaMD;

/**
 *
 * @author Johnny
 */
public class MallaAlumnoMD {
    private int id;  
    private MateriaMD materia;  
    private AlumnoCarreraMD alumnoCarrera;
    private int mallaCiclo; 
    private int mallaNumMatricula;  
    private double nota1, nota2, nota3;
    private String estado;

    public MallaAlumnoMD() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public MateriaMD getMateria() {
        return materia;
    }

    public void setMateria(MateriaMD materia) {
        this.materia = materia;
    }

    public AlumnoCarreraMD getAlumnoCarrera() {
        return alumnoCarrera;
    }

    public void setAlumnoCarrera(AlumnoCarreraMD alumnoCarrera) {
        this.alumnoCarrera = alumnoCarrera;
    }


    public int getMallaCiclo() {
        return mallaCiclo;
    }

    public void setMallaCiclo(int mallaCiclo) {
        this.mallaCiclo = mallaCiclo;
    }

    public int getMallaNumMatricula() {
        return mallaNumMatricula;
    }

    public void setMallaNumMatricula(int mallaNumMatricula) {
        this.mallaNumMatricula = mallaNumMatricula;
    }

    public double getNota1() {
        return nota1;
    }

    public void setNota1(double nota1) {
        this.nota1 = nota1;
    }

    public double getNota2() {
        return nota2;
    }

    public void setNota2(double nota2) {
        this.nota2 = nota2;
    }

    public double getNota3() {
        return nota3;
    }

    public void setNota3(double nota3) {
        this.nota3 = nota3;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
