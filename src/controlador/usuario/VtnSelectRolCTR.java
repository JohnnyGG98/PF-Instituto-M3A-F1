package controlador.usuario;

import controlador.principal.VtnPrincipalCTR;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import modelo.ConectarDB;
import modelo.ConnDBPool;
import modelo.usuario.RolBD;
import modelo.usuario.RolMD;
import modelo.usuario.UsuarioBD;
import vista.principal.VtnPrincipal;
import vista.usuario.VtnSelectRol;

/**
 *
 * @author MrRainx
 */
public class VtnSelectRolCTR {

    private final VtnSelectRol vista;
    private final RolBD modelo;
    private final UsuarioBD usuario;

    private final ConectarDB conexion;

    List<RolMD> rolesDelUsuario;
    //Icono de la aplicacion  
    private final ImageIcon icono;
    private final Image ista;

    /**
     *
     * @param vista
     * @param modelo
     * @param usuario
     * @param conexion
     * @param icono
     * @param ista
     */
    public VtnSelectRolCTR(VtnSelectRol vista, RolBD modelo, UsuarioBD usuario, ConectarDB conexion, ImageIcon icono, Image ista, boolean b) {
        this.vista = vista;
        this.modelo = modelo;
        this.usuario = usuario;
        this.conexion = conexion;
        this.icono = icono;
        this.ista = ista;
        vista.setIconImage(ista);

        registroIngreso(vista);
    }

    private void registroIngreso(JFrame vtn) {
        vtn.addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                inicioSesion();
            }

            @Override
            public void windowClosing(WindowEvent e) {
                cierreSesion();
            }

        });
    }

    public void inicioSesion() {
        String nsql = "INSERT INTO public.\"HistorialUsuarios\"(\n"
                + "	usu_username, historial_fecha, historial_tipo_accion, historial_nombre_tabla, historial_pk_tabla)\n"
                + "	VALUES ('" + usuario.getUsername() + "', now(), 'INICIO SESION', 'SISTEMA', 0);";
        if (conexion.nosql(nsql) == null) {
            System.out.println("Iniciamos como: " + usuario.getUsername());
        }
    }

    public void cierreSesion() {
        String nsql = " INSERT INTO public.\"HistorialUsuarios\"(\n"
                + "  	usu_username, historial_fecha, historial_tipo_accion, historial_nombre_tabla, historial_pk_tabla)\n"
                + "  	VALUES ('" + usuario.getUsername() + "', now(), 'CIERRE SESION', 'SISTEMA', 0);";
        if (conexion.nosql(nsql) == null) {
            System.out.println("Salimos del sistema como: " + usuario.getUsername());
        }
        conexion.cerrarConexion();
        ConnDBPool pool = new ConnDBPool();
        pool.closePool();
    }

    //Inits
    public void Init() {
        rolesDelUsuario = RolBD.SelectWhereUSUARIOusername(usuario.getUsername());
        vista.getLblUsuario().setText(usuario.getUsername());
        System.out.println("Llamamos al rol una vez");

        rellenarCombo();
        InitEventos();

        vista.setVisible(true);
        vista.setLocationRelativeTo(null);
    }

    private void InitEventos() {
        vista.getBtnSeleccionar().addActionListener(e -> ingresar());
        vista.getBtnCancelar().addActionListener(e -> {
            cierreSesion();
            System.exit(0);
        });
        vista.getCmbRoles().addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == 10) {
                    ingresar();
                }
            }
        });
    }

    //Metodos de Apoyo
    private void rellenarCombo() {
        vista.getCmbRoles().removeAllItems();
        rolesDelUsuario.forEach(obj -> {
            vista.getCmbRoles().addItem(obj.getNombre());
        });

    }

    private void setObjFromCombo() {

        String nombreRol = (String) vista.getCmbRoles().getSelectedItem();

        rolesDelUsuario
                .stream()
                .filter(item -> item.getNombre().equals(nombreRol))
                .collect(Collectors.toList())
                .forEach(obj -> {

                    modelo.setId(obj.getId());
                    modelo.setNombre(obj.getNombre());

                });

    }

    private void ingresar() {

        setObjFromCombo();

        VtnPrincipalCTR vtn = new VtnPrincipalCTR(new VtnPrincipal(), modelo, usuario, conexion, icono, ista, this);
        vtn.iniciar();
        vista.dispose();
    }

}
