package controlador.alumno;

import controlador.principal.DCTR;
import controlador.principal.VtnPrincipalCTR;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import modelo.accesos.AccesosBD;
import modelo.accesos.AccesosMD;
import modelo.alumno.AlumnoCarreraBD;
import modelo.alumno.AlumnoCarreraMD;
import modelo.carrera.CarreraBD;
import modelo.carrera.CarreraMD;
import modelo.estilo.TblEstilo;
import modelo.usuario.RolMD;
import modelo.validaciones.TxtVBuscador;
import modelo.validaciones.Validar;
import vista.alumno.VtnAlumnoCarrera;

/**
 *
 * @author Johnny
 */
public class VtnAlumnoCarreraCTR extends DCTR {

    private final VtnAlumnoCarrera vtnAlmCar;
    private final AlumnoCarreraBD almnCar;

    private ArrayList<AlumnoCarreraMD> almnsCarr;

    //Modelo de la tabla
    private DefaultTableModel mdTbl;

    private final CarreraBD carr;
    private ArrayList<CarreraMD> carreras;

    /**
     * Se visualizan todos los alumnos por carrera respectivamente.
     *
     * @param vtnAlmCar
     * @param ctrPrin
     */
    public VtnAlumnoCarreraCTR(VtnAlumnoCarrera vtnAlmCar, VtnPrincipalCTR ctrPrin) {
        super(ctrPrin);
        this.vtnAlmCar = vtnAlmCar;
        this.almnCar = new AlumnoCarreraBD(ctrPrin.getConecta());
        this.carr = new CarreraBD(ctrPrin.getConecta());
    }

    /**
     * Iniciamos las dependencias de la ventana. Eventos Formato de tabla
     * Llamamos metodos
     */
    public void iniciar() {
        cargarCmbCarreras();

        String[] titulo = {"Carrera", "Alumno", "Cédula", "Fecha inscripción"};
        String[][] datos = {};
        mdTbl = TblEstilo.modelTblSinEditar(datos, titulo);
        //Le damos unos toques a la tabla
        TblEstilo.formatoTbl(vtnAlmCar.getTblAlmnCarrera());
        TblEstilo.columnaMedida(vtnAlmCar.getTblAlmnCarrera(), 0, 70);
        TblEstilo.columnaMedida(vtnAlmCar.getTblAlmnCarrera(), 2, 120);
        vtnAlmCar.getTblAlmnCarrera().setModel(mdTbl);
        //Llenamos la tabla
        cargarAlmnsCarrera();
        //acciones
        vtnAlmCar.getCmbCarrera().addActionListener(e -> clickCmbCarreras());
        //Buscador
        vtnAlmCar.getTxtBuscar().addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                String b = vtnAlmCar.getTxtBuscar().getText().trim();
                if (e.getKeyCode() == 10) {
                    buscar(b);
                } else if (b.length() == 0) {
                    cargarAlmnsCarrera();
                }
            }
        });
        vtnAlmCar.getBtnBuscar().addActionListener(e -> buscar(vtnAlmCar.getTxtBuscar().getText().trim()));
        vtnAlmCar.getBtnIngresar().addActionListener(e -> abrirFrmAlumnoCarrera());
        vtnAlmCar.getCbxEliminados().addActionListener(e -> verEliminados());
        //Validacion buscar
        vtnAlmCar.getTxtBuscar().addKeyListener(new TxtVBuscador(vtnAlmCar.getTxtBuscar(),
                vtnAlmCar.getBtnBuscar()));
        ctrPrin.agregarVtn(vtnAlmCar);
    }

    /**
     * Abrimos el formulario de ingreso y cerramos esta ventana,
     */
    private void abrirFrmAlumnoCarrera() {
        ctrPrin.abrirFrmInscripcion();
        vtnAlmCar.dispose();
        ctrPrin.cerradoJIF();
    }

    /**
     * Buscamos y rellenamos la tabla, unicamente se buscara si ingreso letras o
     * numeros, no seran adminitods caracteres especiales.
     *
     * @param b
     */
    private void buscar(String b) {
        if (Validar.esLetrasYNumeros(b)) {
            almnsCarr = almnCar.buscar(b);
            llenarTblAlmnCarreras(almnsCarr);
        } else {
            System.out.println("No ingrese caracteres especiales");
        }
    }

    /**
     * Se cargan todos los alumnos por carrera por defecto. Y se llenaran en la
     * tabla.
     */
    private void cargarAlmnsCarrera() {
        almnsCarr = almnCar.cargarAlumnoCarrera();
        llenarTblAlmnCarreras(almnsCarr);
    }

    /**
     * Llenamos la tabla, con los alumnos que nos pasen.
     *
     * @param almns
     */
    private void llenarTblAlmnCarreras(ArrayList<AlumnoCarreraMD> almns) {
        mdTbl.setRowCount(0);
        if (almns != null) {
            almns.forEach(a -> {
                Object[] valores = {a.getCarrera().getCodigo(),
                    a.getAlumno().getPrimerApellido() + " "
                    + a.getAlumno().getSegundoApellido() + " "
                    + a.getAlumno().getPrimerNombre() + " "
                    + a.getAlumno().getSegundoNombre(),
                    a.getAlumno().getIdentificacion(),
                    a.getFechaRegistro().getDayOfMonth() + "/"
                    + a.getFechaRegistro().getMonth() + "/"
                    + a.getFechaRegistro().getYear()};
                mdTbl.addRow(valores);
            });
            vtnAlmCar.getLblResultados().setText(almns.size() + " Resultados obtenidos.");
        }
    }

    /**
     * Cargamos todas las carreras que esten abiertas en la institucion.
     */
    private void cargarCmbCarreras() {
        carreras = carr.cargarCarrerasCmb();
        if (carreras != null) {
            vtnAlmCar.getCmbCarrera().removeAllItems();
            vtnAlmCar.getCmbCarrera().addItem("Todos");
            carreras.forEach((c) -> {
                vtnAlmCar.getCmbCarrera().addItem(c.getCodigo());
            });
        }
    }

    /**
     * Evento al hacer click en el combo de carreras, si se selecciona una
     * carrera se consultaran los alumnos de esta carrera y se llenara la tabla.
     */
    private void clickCmbCarreras() {
        int posCar = vtnAlmCar.getCmbCarrera().getSelectedIndex();
        if (posCar > 0) {
            almnsCarr = almnCar.cargarAlumnoCarreraPorCarrera(carreras.get(posCar - 1).getId());
            llenarTblAlmnCarreras(almnsCarr);
        } else {
            cargarAlmnsCarrera();
        }
    }

    private void verEliminados() {
        if (vtnAlmCar.getCbxEliminados().isSelected()) {
            almnsCarr = almnCar.cargarAlumnoCarreraEliminados();
            llenarTblAlmnCarreras(almnsCarr);
            vtnAlmCar.getCmbCarrera().setEnabled(false);
        } else {
            almnsCarr = almnCar.cargarAlumnoCarrera();
            llenarTblAlmnCarreras(almnsCarr);
            vtnAlmCar.getCmbCarrera().setEnabled(true);
        }

    }

    private void InitPermisos() {
        for (AccesosMD obj : AccesosBD.SelectWhereACCESOROLidRol(ctrPrin.getRolSeleccionado().getId())) {
//            if (obj.getNombre().equals("USUARIOS-Agregar")) {
//                vtnCarrera.getBtnIngresar().setEnabled(true);
//            }
//            if (obj.getNombre().equals("USUARIOS-Editar")) {
//                vista.getBtnEditar().setEnabled(true);
//            }
//            if (obj.getNombre().equals("USUARIOS-Eliminar")) {
//                vista.getBtnEliminar().setEnabled(true);
//            }
//            if (obj.getNombre().equals("USUARIOS-AsignarRoles")) {
//                vista.getBtnAsignarRoles().setEnabled(true);
//            }
//            if (obj.getNombre().equals("USUARIOS-VerRoles")) {
//                vista.getBtnVerRoles().setEnabled(true);
//            }
        }
    }

}
