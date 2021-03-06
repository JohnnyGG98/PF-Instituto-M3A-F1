package controlador.alumno;

import controlador.principal.DVtnCTR;
import controlador.principal.VtnPrincipalCTR;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JDialog;
import javax.swing.JTextField;
import modelo.alumno.MallaAlumnoBD;
import modelo.alumno.MallaAlumnoMD;
import modelo.validaciones.TxtVNota;
import modelo.validaciones.Validar;
import vista.alumno.FrmMallaActualizar;

/**
 *
 * @author Johnny
 */
public class FrmMallaActualizarCTR extends DVtnCTR {

    //Formulario 
    private final FrmMallaActualizar frmMalla;
    //Malla alumno 
    private final MallaAlumnoMD malla;
    private final MallaAlumnoBD bd;
    private final VtnMallaAlumnoCTR ctrMalla;
    //Numero de notas
    private final int[] numMatriculas = {1, 2, 3};
    private int posMatricula = 0, numMatricula, posEstado;
    private double nota1, nota2, nota3;
    private String notaAux;
    private final String[] estados = {"Matriculado", "Cursado", "Reprobado", "Pendiente", "Anulado"};
    
    /**
     * Para poder actualizar la malla del alumno 
     * @param ctrPrin
     * @param malla
     * @param bd
     * @param ctrMalla 
     */
    public FrmMallaActualizarCTR(VtnPrincipalCTR ctrPrin,
            MallaAlumnoMD malla, MallaAlumnoBD bd, VtnMallaAlumnoCTR ctrMalla) {
        super(ctrPrin);
        this.malla = malla;
        this.ctrMalla = ctrMalla;
        this.bd = bd;
        this.frmMalla = new FrmMallaActualizar(ctrPrin.getVtnPrin(), false);
        this.frmMalla.setLocationRelativeTo(ctrPrin.getVtnPrin());
        this.frmMalla.setVisible(true);
    }
    
    /**
     * Iniciamos todas las dependencias de esta ventana
     */
    public void iniciar() {
        frmMalla.getTxtNota().setEnabled(false);
        llenarComboNumMatriculas();
        llenarCmb();

        cargarDatos();
        eventoActualizar(frmMalla.getTxtNota());
        iniciarAtajosTeclado();
        //Validacion 
        frmMalla.getTxtNota().addKeyListener(new TxtVNota(frmMalla.getTxtNota()));
        //Eventos
        frmMalla.getCmbNumMatricula().addActionListener(e -> clickCmbNumMatricula());
        frmMalla.getCmbEstado().addActionListener(e -> clickEstados());
        frmMalla.getBtnGuardar().addActionListener(e -> guardar());
        
        //Iniciamos el evento 
        ctrPrin.eventoJDCerrar(frmMalla);
        mostrarVtnMalla(frmMalla);
    }
    
    
    private void iniciarAtajosTeclado(){
        frmMalla.getTxtNota().addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == 10) {
                        guardar();
                }            
            } 
        });
    }
    
    /**
     * Guardamos en la base de datos, 
     * Se receteara el numero de matricula automaticamente evaluando
     * hasta que nota tiene ingresado
     */
    private void guardar() {
        //verificamos el numero de matricula que esta
        if (nota3 > 0) {
            numMatricula = 3;
        } else if (nota1 > 0 && nota2 > 0) {
            numMatricula = 2;
        } else if (nota1 > 0) {
            numMatricula = 1;
        } else {
            numMatricula = 0;
        }

        boolean guardar = true;

        if (!Validar.esNota(nota1 + "") && !Validar.esNota(nota2 + "") && !Validar.esNota(nota3 + "")) {
            guardar = false;
        }
        if (guardar) {
            if (bd.actualizarNota(malla.getId(), nota1, nota2, nota3, numMatricula, frmMalla.getLblEstado().getText())) {
                ctrPrin.getVtnPrin().setEnabled(true);
                ctrMalla.actualizarVtn(malla);
                frmMalla.dispose();
            }
        }
    }
    
    /**
     * Actualizamos el lbl de estaco obteniendo el estado ingresado
     */
    private void clickEstados() {
        posEstado = frmMalla.getCmbEstado().getSelectedIndex();
        if (posEstado > 0) {
            frmMalla.getLblEstado().setText(frmMalla.getCmbEstado().getItemAt(posEstado).charAt(0) + "");
        }
    }
    
    /**
     * Llenamos el combo con los estados, disponibles
     */
    private void llenarCmb() {
        frmMalla.getCmbEstado().removeAllItems();
        frmMalla.getCmbEstado().addItem("Seleccione");
        for (String e : estados) {
            frmMalla.getCmbEstado().addItem(e);
        }
    }
    
    /**
     * Al hacer click en un numero de nota se activa el campo,
     * caso contrario se bloquea el campo.
     */
    private void clickCmbNumMatricula() {
        posMatricula = frmMalla.getCmbNumMatricula().getSelectedIndex();
        if (posMatricula > 0) {
            frmMalla.getTxtNota().setEnabled(true);
        } else {
            frmMalla.getTxtNota().setEnabled(false);
        }
    }
    
    /**
     * Actualizamos los lbl con las notas, indicando que nota se 
     * ingreso.
     * @param txt 
     */
    private void eventoActualizar(JTextField txt) {
        txt.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                notaAux = txt.getText().trim();
                if (notaAux.length() == 0) {
                    notaAux = "0.0";
                }
                switch (posMatricula) {
                    case 1:
                        frmMalla.getLblNota1().setText(notaAux);
                        break;
                    case 2:
                        frmMalla.getLblNota2().setText(notaAux);
                        break;
                    case 3:
                        frmMalla.getLblNota3().setText(notaAux);
                        break;
                    default:
                        break;
                }
                estado(frmMalla.getLblNota1().getText(),
                        frmMalla.getLblNota2().getText(),
                        frmMalla.getLblNota3().getText());
            }
        });
    }
    
    /**
     * Evaluamos el estado dependiendo de todas las notas 
     * que ingresaron
     * @param n1
     * @param n2
     * @param n3 
     */
    private void estado(String n1, String n2, String n3) {
        if (Validar.esNota(n1) && Validar.esNota(n2) && Validar.esNota(n3)) {
            nota1 = Double.parseDouble(n1);
            nota2 = Double.parseDouble(n2);
            nota3 = Double.parseDouble(n3);
            if (nota1 >= 70 || nota2 >= 70 || nota3 >= 70) {
                frmMalla.getLblEstado().setText("C");
                numMatricula = 3;
            } else {
                frmMalla.getLblEstado().setText("R");
            }
            if (nota1 == 0 && nota2 == 0 && nota3 == 0) {
                frmMalla.getLblEstado().setText("P");
            }

        }
    }
    
    /**
     * Cargamos todos los datos que tiene en la malla alumno, 
     * obteniendo desde el malla alumno que se pasa
     */
    private void cargarDatos() {
        nota1 = malla.getNota1();
        nota2 = malla.getNota2();
        nota3 = malla.getNota3();
        numMatricula = malla.getMallaNumMatricula();

        frmMalla.getLblNota1().setText(malla.getNota1() + "");
        frmMalla.getLblNota2().setText(malla.getNota2() + "");
        frmMalla.getLblNota3().setText(malla.getNota3() + "");
        frmMalla.getLblMateria().setText(malla.getMateria().getNombre());
        frmMalla.getLblNombre().setText(malla.getAlumnoCarrera().getAlumno().getNombreCompleto());
        frmMalla.getLblEstado().setText(malla.getEstado());
    }
    
    /**
     * LLenamos el combo con el numero de 
     * matriculas que se pueden hacer
     */
    private void llenarComboNumMatriculas() {
        frmMalla.getCmbNumMatricula().removeAllItems();
        frmMalla.getCmbNumMatricula().addItem("--");
        for (int n : numMatriculas) {
            frmMalla.getCmbNumMatricula().addItem(n + "");
        }
    }
    
    /**
     * Al cerrar la venta se vuelve a mostrar la ventana e malla
     * @param vtn 
     */
    private void mostrarVtnMalla(JDialog vtn) {
        vtn.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                ctrMalla.actualizarVtn(malla);
                frmMalla.dispose();
            }

        });
    }

}
