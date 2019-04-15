/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.silabo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Optional;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.ConexionBD;
import modelo.carrera.CarreraMD;
import modelo.silabo.CarrerasBDS;

import modelo.silabo.SilaboMD;
import modelo.silabo.SilaboBD;
import modelo.usuario.UsuarioBD;
import vista.principal.VtnPrincipal;

import vista.silabos.frmSilabos;

/**
 *
 * @author Andres Ullauri
 */
public class ControladorCRUD {

    private SilaboBD silabo;

    private final UsuarioBD usuario;

    private frmSilabos crud;

    //private frmGestionSilabo gestion;
    //private frmConfiguracionSilabo configuracion;
    private ConexionBD conexion;

    private final VtnPrincipal principal;

    private List<SilaboMD> silabosDocente;

    public ControladorCRUD(UsuarioBD usuario, VtnPrincipal principal) {
        this.usuario = usuario;
        this.principal = principal;
        this.conexion = new ConexionBD();

    }

    public void iniciarControlador() {

        conexion.conectar();

        crud = new frmSilabos();

        principal.getDpnlPrincipal().add(crud);

        crud.setTitle("Silabos");

        crud.show();

        crud.setLocation((principal.getDpnlPrincipal().getSize().width - crud.getSize().width) / 2,
                (principal.getDpnlPrincipal().getSize().height - crud.getSize().height) / 2);

        opcionesImpresion(false);
        // Boton NUEVO Silabo
        crud.getBtnNuevo().addActionListener((ActionEvent ae) -> {
            crud.dispose();

            ControladorSilaboC csc = new ControladorSilaboC(principal, usuario, conexion);

            csc.iniciarControlador();
        });

        // Boton EDITAR Silabo
        crud.getBtnEditar().addActionListener((ActionEvent ae) -> {

            crud.dispose();

            ControladorSilaboU csu = new ControladorSilaboU(seleccionarSilabo(), principal, conexion);

            csu.iniciarControlador();
        });

        // Boton ELIMINAR Silabo
        crud.getBtnEliminar().addActionListener((ActionEvent ae) -> {
            
                eliminarSilabo(seleccionarSilabo().getIdSilabo());
       
        });

        crud.getBtnImprimir().addActionListener((ActionEvent ae) -> {
            opcionesImpresion(true);

            ControladorSilaboR csr = new ControladorSilaboR(crud, seleccionarSilabo(), conexion, principal);

            csr.iniciarControlador();

        });

       

        crud.getTxtBuscar().addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent ke) {

                cargarSilabosDocente();

            }

        });

        crud.getCmbCarrera().addActionListener(al -> cargarSilabosDocente());

        cargarComboCarreras();

        cargarSilabosDocente();

    }

    public List<CarreraMD> cargarComboCarreras() {

        List<CarreraMD> carrerasDocente = CarrerasBDS.consultar(conexion, usuario.getUsername());

        carrerasDocente.forEach((cmd) -> {
            crud.getCmbCarrera().addItem(cmd.getNombre());
        });

        return carrerasDocente;
    }

    public void cargarSilabosDocente() {
        DefaultTableModel modeloTabla;

        modeloTabla = (DefaultTableModel) crud.getTblSilabos().getModel();

        String[] parametros = {crud.getCmbCarrera().getSelectedItem().toString(), crud.getTxtBuscar().getText(), String.valueOf(usuario.getPersona().getIdPersona())};
        //

        silabosDocente = SilaboBD.consultar(conexion, parametros);

        for (int j = crud.getTblSilabos().getModel().getRowCount() - 1; j >= 0; j--) {

            modeloTabla.removeRow(j);
        }

        for (SilaboMD smd : silabosDocente) {

            String estado = null;
            if (smd.getEstadoSilabo() == 0) {
                estado = "Por aprobar";
            }

            modeloTabla.addRow(new Object[]{
                smd.getIdMateria().getNombre(),
                smd.getIdPeriodoLectivo().getFecha_Inicio() + " / " + smd.getIdPeriodoLectivo().getFecha_Fin(),
                estado});

        }

        crud.getTblSilabos().setModel(modeloTabla);
    }

    public SilaboMD seleccionarSilabo() {

        int seleccion = crud.getTblSilabos().getSelectedRow();

        Optional<SilaboMD> silaboSeleccionado = silabosDocente.stream().
                filter(s -> s.getIdMateria().getNombre().equals(crud.getTblSilabos().getValueAt(seleccion, 0))).
                findFirst();

        return silaboSeleccionado.get();
    }

    public void opcionesImpresion(boolean estado) {

        crud.getLblSeleccionDocumento().setVisible(estado);
        crud.getChbProgramaAnalitico().setVisible(estado);
        crud.getChbSilabo().setVisible(estado);
        crud.getBtnGenerar().setVisible(estado);

    }

    public void eliminarSilabo(int aguja) {

        int reply = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea eliminar este silabo?", "Eliminar", JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION) {
            new SilaboBD(conexion).eliminar(seleccionarSilabo());
            JOptionPane.showMessageDialog(null, "Silabo eliminado correctamente");
        }

    }

}