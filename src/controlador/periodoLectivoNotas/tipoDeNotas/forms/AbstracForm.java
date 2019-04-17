package controlador.periodoLectivoNotas.tipoDeNotas.forms;

import controlador.Libraries.Middlewares;
import controlador.Libraries.Validaciones;
import controlador.periodoLectivoNotas.tipoDeNotas.VtnTipoNotasCTR;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.beans.PropertyVetoException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;
import modelo.carrera.CarreraBD;
import modelo.carrera.CarreraMD;
import modelo.tipoDeNota.TipoDeNotaBD;
import vista.periodoLectivoNotas.FrmTipoNota;
import vista.principal.VtnPrincipal;

/**
 *
 * @author MrRainx
 */
public abstract class AbstracForm {

    protected VtnPrincipal desktop;
    protected FrmTipoNota vista;
    protected TipoDeNotaBD modelo;
    //Ventana Padre
    protected VtnTipoNotasCTR vtnPadre;
    //(Agregar o Editar)
    protected String Funcion;
    //listas
    protected List<CarreraMD> listaCarreras;

    protected Integer PK = null;

    //Combo
    protected String[] carrerasTradicionales = {
        "APORTE 1",
        "APORTE 2",
        "EXAMEN FINAL",
        "EXAMEN SUPLETORIO"
    };

    protected boolean COMPLETED = false;

    public AbstracForm(VtnPrincipal desktop, FrmTipoNota vista, TipoDeNotaBD modelo, VtnTipoNotasCTR vtnPadre, String Funcion) {
        this.desktop = desktop;
        this.vista = vista;
        this.modelo = modelo;
        this.vtnPadre = vtnPadre;
        this.Funcion = Funcion;
    }

    //INITS
    public void Init() {
        activarFormulario(false);
        new Thread(() -> {
            try {
                Middlewares.centerFrame(vista, desktop.getDpnlPrincipal());
                desktop.getDpnlPrincipal().add(vista);
                vista.setSelected(true);
                vista.show();
            } catch (PropertyVetoException e) {
                System.out.println(e.getMessage());
            }
        }).start();
        listaCarreras = CarreraBD.selectIdNombreAll();
        cargarComboCarreras();
        cargarCmbNombreNota(carrerasTradicionales);
        InitEventos();
        COMPLETED = true;
    }

    private void InitEventos() {
        vista.getBtnCancelar().addActionListener(e -> btnCancelar(e));
        String errorMessage = "ERROR INGRESE UN NUMERO EN ESTE FORMATO (15 o 15.66)";
        Validaciones.validarDecimalJtextField(vista.getTxtNotaMax(), errorMessage, vista, 0, 2);
        Validaciones.validarDecimalJtextField(vista.getTxtNotaMin(), errorMessage, vista, 0, 2);
        vista.getTxtNotaMin().addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                validarValorMenor(e);
            }
        });
        vista.getTxtNotaMax().addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                validarValorMenor(e);
            }
        });

        vista.getBtnGuardar().addActionListener(e -> btnGuardar(e));
    }

    //METODOS DE APOYO
    protected void cargarCmbNombreNota(String[] lista) {
        vista.getCmbTipoDeNota().removeAllItems();
        for (String obj : lista) {
            vista.getCmbTipoDeNota().addItem(obj);
        }
    }

    protected void activarFormulario(boolean estado) {
        vista.getCmbTipoDeNota().setEnabled(estado);
        vista.getTxtNotaMax().setEnabled(estado);
        vista.getTxtNotaMin().setEnabled(estado);
        vista.getCmbCarrera().setEnabled(estado);
    }

    protected void cargarComboCarreras() {

        listaCarreras.stream().forEach(obj -> {
            vista.getCmbCarrera().addItem(obj.getNombre());
        });
    }

    protected void validarValorMenor(FocusEvent e) {
        if (!vista.getTxtNotaMax().getText().isEmpty() && !vista.getTxtNotaMin().getText().isEmpty()) {

            double minimo = Double.valueOf(vista.getTxtNotaMin().getText());
            double maximo = Double.valueOf(vista.getTxtNotaMax().getText());
            if (minimo > maximo) {
                JOptionPane.showMessageDialog(vista, "EL VALOR MINIMO NO PUEDE SER MAYOR AL VALOR MAXIMO!!");
                vista.getTxtNotaMin().setText("");
                vista.getTxtNotaMin().requestFocus();
            } else if (minimo == maximo) {
                JOptionPane.showMessageDialog(vista, "LOS VALORES NO PUEDEN SER IGUALES!!");
                vista.getTxtNotaMin().setText("");
                vista.getTxtNotaMin().requestFocus();
            }

        }
    }

    protected boolean validarFormulario() {
        if (!vista.getTxtNotaMax().getText().isEmpty()) {
            if (!vista.getTxtNotaMin().getText().isEmpty()) {
                return true;
            } else {
                JOptionPane.showMessageDialog(vista, "RELLENE EL CAMPO DE NOTA MINIMA!!");
            }
        } else {
            JOptionPane.showMessageDialog(vista, "RELLENE EL CAMPO DE NOTA MAXIMA!!");
        }

        return false;
    }

    protected TipoDeNotaBD setObj() {
        modelo = new TipoDeNotaBD();

        modelo.setNombre(vista.getCmbTipoDeNota().getSelectedItem().toString());
        modelo.setValorMaximo(Double.valueOf(vista.getTxtNotaMax().getText()));
        modelo.setValorMinimo(Double.valueOf(vista.getTxtNotaMin().getText()));

        listaCarreras
                .stream()
                .filter(item -> item.getNombre().equals(vista.getCmbCarrera().getSelectedItem().toString()))
                .collect(Collectors.toList())
                .forEach(obj -> {
                    modelo.setCarrera(obj);
                });

        return modelo;
    }

    //PROCESADORES DE EVENTOS
    private void btnCancelar(ActionEvent e) {
        vista.dispose();
    }

    protected abstract void btnGuardar(ActionEvent e);
}