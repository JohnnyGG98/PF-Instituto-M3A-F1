package controlador.usuario;

import controlador.usuario.forms.FrmUsuarioAdd;
import controlador.usuario.Roles.forms.FrmAsignarRolCTR;
import controlador.Libraries.Effects;
import controlador.usuario.forms.FrmUsuarioUpdt;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import utils.CONS;
import modelo.usuario.RolesDelUsuarioBD;
import modelo.usuario.UsuarioBD;
import modelo.usuario.UsuarioMD;
import vista.principal.VtnPrincipal;
import vista.usuario.FrmAsignarRoles;
import vista.usuario.VtnUsuario;

/**
 *
 * @author MrRainx
 */
public class VtnUsuarioCTR {

    private final VtnPrincipal desktop;
    private final VtnUsuario vista;
    private UsuarioBD modelo;

    //Listas
    private static List<UsuarioMD> listaUsuarios;
    private static DefaultTableModel tablaUsuarios;
    private boolean cargar = true;

    public VtnUsuarioCTR(VtnPrincipal desktop) {
        this.desktop = desktop;
        this.vista = new VtnUsuario();
    }

    public VtnUsuario getVista() {
        return vista;
    }

    //Inits
    public synchronized void Init() {
        Effects.addInDesktopPane(vista, desktop.getDpnlPrincipal());

        tablaUsuarios = (DefaultTableModel) vista.getTblUsuario().getModel();

        cargarTabla(listaUsuarios = CONS.USUARIO.selectAll());
        //InitPermisos();
        InitEventos();
        InitPermisos();

    }

    //METODOS DE APOYO
    private void InitEventos() {

        vista.getBtnIngresar().addActionListener(e -> {
            FrmUsuarioAdd form = new FrmUsuarioAdd(desktop, this);
            form.Init();
            form.setUsuarios(listaUsuarios);

        });
        vista.getBtnEliminar().addActionListener(e -> btnEliminar(e));
        vista.getBtnEditar().addActionListener(e -> btnEditar(e));
        vista.getBtnActualizar().addActionListener(e -> {
            cargarTabla(listaUsuarios = CONS.USUARIO.selectAll());
        });
        vista.getBtnAsignarRoles().addActionListener(e -> btnAsignarRoles(e));
        vista.getBtnVerRoles().addActionListener(e -> btnVerRoles(e));
        vista.getTxtBuscar().addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                cargarTablaFilter(vista.getTxtBuscar().getText());
            }
        });

    }

    /*
    
        METODOS DE APOYO
    
     */
    public void cargarTabla(List<UsuarioMD> lista) {

        if (cargar) {
            new Thread(() -> {

                tablaUsuarios.setRowCount(0);

                vista.getTxtBuscar().setEnabled(false);

                cargar = false;

                Effects.setLoadCursor(vista);

                lista.stream().forEach(VtnUsuarioCTR::agregarFila);

                vista.getLblResultados().setText(lista.size() + " Registros");

                Effects.setDefaultCursor(vista);

                vista.getTxtBuscar().setEnabled(true);

                cargar = true;
            }).start();

        } else {
            JOptionPane.showMessageDialog(vista, "YA HAY UNA CARGA DE UNA TABLA PENDIENTE");
        }

    }

    private void cargarTablaFilter(String Aguja) {
        tablaUsuarios.setRowCount(0);

        List<UsuarioMD> listaTemporal = listaUsuarios
                .stream()
                .filter(
                        item -> item.getUsername().toUpperCase().contains(Aguja.toUpperCase())
                        || item.getPersona().getIdentificacion().toUpperCase().contains(Aguja.toUpperCase())
                        || item.getPersona().getPrimerApellido().toUpperCase().contains(Aguja.toUpperCase())
                        || item.getPersona().getSegundoApellido().toUpperCase().contains(Aguja.toUpperCase())
                        || item.getPersona().getPrimerNombre().toUpperCase().contains(Aguja.toUpperCase())
                        || item.getPersona().getSegundoNombre().toUpperCase().contains(Aguja.toUpperCase())
                )
                .collect(Collectors.toList());

        listaTemporal.forEach(VtnUsuarioCTR::agregarFila);
        vista.getLblResultados().setText(listaTemporal.size() + " Registros");

    }

    private static void agregarFila(UsuarioMD obj) {
        tablaUsuarios.addRow(new Object[]{
            tablaUsuarios.getDataVector().size() + 1,
            obj.getUsername(),
            obj.getPersona().getIdentificacion(),
            obj.getPersona().getPrimerApellido(),
            obj.getPersona().getSegundoApellido(),
            obj.getPersona().getPrimerNombre(),
            obj.getPersona().getSegundoNombre()

        });

    }

    public UsuarioBD getModelo() {
        return modelo;
    }

    public void setModelo(int fila) {
        modelo = null;
        String username = (String) vista.getTblUsuario().getValueAt(fila, 1);
        modelo = new UsuarioBD(listaUsuarios.stream()
                .filter(item -> item.getUsername().equals(username))
                .findAny()
                .get());
    }

    //EVENTOS 
    private void btnEliminar(ActionEvent e) {

        int fila = vista.getTblUsuario().getSelectedRow();

        if (fila != -1) {

            String Username = (String) vista.getTblUsuario().getValueAt(fila, 1);

            if (Username.equals("ROOT")) {
                JOptionPane.showMessageDialog(vista, "NO SE PUEDE ELIMINAR AL USUARIO ROOT!!!");
            } else {

                int opcion = JOptionPane.showConfirmDialog(vista, "ESTA SEGURO DE BORRAR AL USUARIO\n" + Username);

                if (opcion == 0) {
                    if (modelo == null) {
                        modelo = new UsuarioBD();
                    }

                    modelo.cambiarEstado(Username, false);
                    
                    cargarTabla(listaUsuarios = modelo.selectAll());

                } else {
                    JOptionPane.showMessageDialog(vista, "HA DECIDIDO NO BORRAR AL USUARIO!!");
                }
            }

        } else {

            JOptionPane.showMessageDialog(vista, "SELECCIONE UNA FILA!!!");
        }

    }

    private void btnEditar(ActionEvent e) {

        int fila = vista.getTblUsuario().getSelectedRow();

        if (fila != -1) {

            setModelo(fila);

            FrmUsuarioUpdt form = new FrmUsuarioUpdt(desktop, this);
            form.Init();
            form.setModelo(getModelo());
            form.setUsuarios(listaUsuarios);

        } else {
            JOptionPane.showMessageDialog(vista, "SELECCIONE UNA FILA!!");
        }

    }

    private void btnAsignarRoles(ActionEvent e) {

        int fila = vista.getTblUsuario().getSelectedRow();

        if (fila == -1) {
            JOptionPane.showMessageDialog(vista, "SELECCIONE UNA FILA!!");
        } else {
            setModelo(fila);
            if (getModelo().getUsername().equals("ROOT")) {
                JOptionPane.showMessageDialog(vista, "NO SE PUEDE EDITAR LOS PERMISOS DEL USUARIO ROOT!");
            } else {
                FrmAsignarRolCTR form = new FrmAsignarRolCTR(desktop, new FrmAsignarRoles(), new RolesDelUsuarioBD(), modelo, "Asignar");
                form.Init();
            }

        }

    }

    private void btnVerRoles(ActionEvent e) {

        int fila = vista.getTblUsuario().getSelectedRow();

        if (fila == -1) {
            JOptionPane.showMessageDialog(vista, "SELECCIONE UNA FILA!!");
        } else {
            setModelo(fila);
            FrmAsignarRolCTR form = new FrmAsignarRolCTR(desktop, new FrmAsignarRoles(), new RolesDelUsuarioBD(), getModelo(), "Consultar");
            form.Init();

        }

    }

    private void InitPermisos() {
        vista.getBtnIngresar().getAccessibleContext().setAccessibleName("Usuarios-Ingresar");
        vista.getBtnActualizar().getAccessibleContext().setAccessibleName("Usuarios-Actualizar");
        vista.getBtnEditar().getAccessibleContext().setAccessibleName("Usuarios-Editar");
        vista.getBtnAsignarRoles().getAccessibleContext().setAccessibleName("Usuarios-Asignar Roles");
        vista.getBtnEliminar().getAccessibleContext().setAccessibleName("Usuarios-Eliminar");
        vista.getBtnVerRoles().getAccessibleContext().setAccessibleName("Usuarios-Ver Roles");

        CONS.activarBtns(vista.getBtnIngresar(), vista.getBtnActualizar(),
                vista.getBtnEditar(), vista.getBtnAsignarRoles(),
                vista.getBtnEliminar(), vista.getBtnVerRoles());
    }

}
