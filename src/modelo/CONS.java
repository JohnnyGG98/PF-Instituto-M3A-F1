package modelo;

import java.awt.Image;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import modelo.accesosDelRol.AccesosDelRolBD;
import modelo.usuario.RolBD;
import modelo.usuario.UsuarioBD;

/**
 *
 * @author JOHNNY, MrRainx
 */
public class CONS {

    //Modo del proyecto 
    public static final boolean M_DESARROLLO = true;
    //Nombre de las propiedadesde la base de matos
    public static final String BD_DATABASE = "database", BD_IP = "ip", BD_PUERTO = "port";
    //Direccion de las propiedades de base de datos
    public static final String BD_DIR = "configuracion.properties";
    //Nombre de las propiedades la version
    public static final String V_AUTOR = "Autor", V_NOMBRE = "Nombre", V_VERSION = "Version",
            V_NOTAS = "Notas", V_FECHA = "Fecha";
    //Direccion de las propiedades de version  
    public static final String V_DIR = "version.properties";

    //Obtenemos la direccion 
    public static String getDir() {
        File dir = new File("./");
        return dir.getAbsolutePath();
    }

    public static UsuarioBD USUARIO;

    public static void setUsuario(UsuarioBD USUARIO) {
        CONS.USUARIO = USUARIO;
    }

    public static RolBD ROL;

    public static void setRol(RolBD ROL) {
        CONS.ROL = ROL;
    }

    public static ForkJoinPool THREAD_POOL;

    public static ForkJoinPool getPool(Integer threads) {
        if (threads == null) {
            if (THREAD_POOL == null) {
                THREAD_POOL = new ForkJoinPool(4);
            } else {
                if (THREAD_POOL.isShutdown()) {
                }
            }
        } else {
            THREAD_POOL = new ForkJoinPool(threads);
        }
        return THREAD_POOL;
    }

    private static ImageIcon ICONO;

    public static ImageIcon getICONO() {
        if (ICONO == null) {
            ICONO = new ImageIcon(ClassLoader.getSystemResource("vista/img/logo.png"));
        }
        return ICONO;
    }

    public static Image getImage() {
        if (ICONO == null) {
            ICONO = getICONO();
        }
        return ICONO.getImage();
    }

    public static List<String> permisos;

    public static List<String> getPermisos() {
        if (permisos == null) {
            refreshPermisos();
        }
        return permisos;
    }

    public static void refreshPermisos() {
        permisos = new AccesosDelRolBD().selectWhere(CONS.ROL.getId(), true);
    }

    public static void activarBtns(JComponent... components) {
        if (!ROL.getNombre().equalsIgnoreCase("ROOT") && !ROL.getNombre().equalsIgnoreCase("DEV")) {
            Arrays.stream(components)
                    .forEach(obj -> {
                        obj.setEnabled(CONS.getPermisos().contains(obj.getAccessibleContext().getAccessibleName()));
                    });
        }
    }

    public static String getDia(int dia) {
        String d;
        switch (dia) {
            case 1:
                d = "Lunes";
                break;
            case 2:
                d = "Martes";
                break;
            case 3:
                d = "Miercoles";
                break;
            case 4:
                d = "Jueves";
                break;
            case 5:
                d = "Viernes";
                break;
            case 6:
                d = "Sabado";
                break;
            case 7:
                d = "Domingo";
                break;
            default:
                d = "";
                break;
        }
        return d;

    }

    public static int getDia(String dia) {
        int d;
        switch (dia) {
            case "Lunes":
                d = 1;
                break;
            case "Martes":
                d = 2;
                break;
            case "Miercoles":
                d = 3;
                break;
            case "Jueves":
                d = 4;
                break;
            case "Viernes":
                d = 5;
                break;
            case "Sabado":
                d = 6;
                break;
            case "Domingo":
                d = 7;
                break;
            default:
                d = 0;
                break;
        }
        return d;

    }

}
