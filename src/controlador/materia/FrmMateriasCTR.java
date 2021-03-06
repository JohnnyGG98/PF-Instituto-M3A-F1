package controlador.materia;

import controlador.principal.DCTR;
import controlador.principal.VtnPrincipalCTR;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import modelo.carrera.CarreraMD;
import modelo.materia.EjeFormacionMD;
import modelo.materia.MateriaBD;
import modelo.validaciones.CmbValidar;
import modelo.validaciones.Validar;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.carrera.CarreraBD;
import modelo.materia.EjeFormacionBD;
import modelo.materia.MateriaMD;
import modelo.validaciones.TxtVNumeros_2;
import vista.materia.FrmMaterias;

/**
 *
 * @author Lina
 */
public class FrmMateriasCTR extends DCTR {

    private final FrmMaterias frmMaterias;
    private final MateriaBD MTBD = MateriaBD.single();
    private boolean guardar = false;
    private int acceso = 0;
    private boolean editar = false;
    private String nombre_Materia;
    private ArrayList<CarreraMD> listaCarrera;
    private ArrayList<EjeFormacionMD> listaEje;
    private final CarreraBD carBD = null;
    private final EjeFormacionBD ejeBD = null;
    private int idEditar = 0;

    //Para actualizar la tabla  
    private final VtnMateriaCTR ctrVtnMat;

    public FrmMateriasCTR(FrmMaterias frmMaterias, VtnPrincipalCTR ctrPrin) {
        super(ctrPrin);
        this.frmMaterias = frmMaterias;
        this.ctrVtnMat = null;
    }

    public FrmMateriasCTR(FrmMaterias frmMaterias, VtnPrincipalCTR ctrPrin, VtnMateriaCTR ctrVtnMat) {
        super(ctrPrin);
        this.frmMaterias = frmMaterias;
        this.ctrVtnMat = ctrVtnMat;
    }

    public void iniciar() {

        ctrPrin.agregarVtn(frmMaterias);

        frmMaterias.getCbCarrera().addActionListener((ActionEvent e) -> {
            acceso = 0;
            String nombre = frmMaterias.getCbCarrera().getSelectedItem().toString();
            List<EjeFormacionMD> ejes = MTBD.cargarEjes(MTBD.filtrarIdCarrera(nombre, 0).getId());
            frmMaterias.getCbEjeFormacion().removeAllItems();
            frmMaterias.getCbEjeFormacion().addItem("SELECCIONE");

            frmMaterias.getCbx_OrgCurricular().removeAllItems();
            frmMaterias.getCbx_OrgCurricular().addItem("SELECCIONE");

            if (nombre.equals("SELECCIONE") == false) {
                frmMaterias.getCbEjeFormacion().setEnabled(true);
                for (int i = 0; i < ejes.size(); i++) {
                    frmMaterias.getCbEjeFormacion().addItem(ejes.get(i).getNombre());

                    frmMaterias.getCbx_OrgCurricular().addItem(ejes.get(i).getNombre());
                }
                habilitarGuardar();
            }

            int pos = frmMaterias.getCbCarrera().getSelectedIndex();
            if (pos > 0) {
                frmMaterias.getCbCarrera().setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
                if (frmMaterias.getLblErrorCarrera() != null) {
                    frmMaterias.getLblErrorCarrera().setVisible(false);
                }

            } else {
                frmMaterias.getCbCarrera().setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
                if (frmMaterias.getLblErrorCarrera() != null) {
                    frmMaterias.getLblErrorCarrera().setVisible(true);
                }
            }
        });

        frmMaterias.getCbEjeFormacion().addActionListener((ActionEvent e) -> {
            acceso++;
            if (acceso > 1) {
                String nombre = frmMaterias.getCbEjeFormacion().getSelectedItem().toString();
                switch (nombre) {
                    case "BÁSICA":
                    case "FORMACIÓN BÁSICA":
                    case "UNIDAD BÁSICA":
                        frmMaterias.getCbx_OrgCurricular().setSelectedIndex(1);
                        break;
                    case "PROFESIONAL":
                    case "FORMACIÓN PROFESIONAL":
                    case "UNIDAD PROFESIONAL":
                        frmMaterias.getCbx_OrgCurricular().setSelectedIndex(2);
                        break;
                    case "TITULACIÓN":
                        frmMaterias.getCbx_OrgCurricular().setSelectedIndex(3);
                        break;
                    default:
                        break;
                }
                habilitarGuardar();
            }

            int pos = frmMaterias.getCbCarrera().getSelectedIndex();
            if (pos > 0) {
                frmMaterias.getCbCarrera().setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
                if (frmMaterias.getLblErrorCarrera() != null) {
                    frmMaterias.getLblErrorCarrera().setVisible(false);
                }

            } else {
                frmMaterias.getCbCarrera().setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
                if (frmMaterias.getLblErrorCarrera() != null) {
                    frmMaterias.getLblErrorCarrera().setVisible(true);
                }
            }
        });

        frmMaterias.getBtnGuardar().addActionListener((ActionEvent e) -> {
            if (guardar == true) {
                guardarMateria();
            }
        });
        frmMaterias.getBtnCancelar().addActionListener(e -> cancelar());
        iniciarValidaciones();
        iniciarComponentes();
        iniciarCarreras();

    }

    public void iniciarCarreras() {
        List<CarreraMD> carreras = MTBD.cargarCarreras();
        for (int i = 0; i < carreras.size(); i++) {
            frmMaterias.getCbCarrera().addItem(carreras.get(i).getNombre());
        }
    }

    public void habilitarGuardar() {
        String materiaCarrera, materiaCodigo, materiaNombre,
                ejeFormacion, tipoAcreditacion, organizacionCurri, campoFormacion,
                objetivoGeneral, objetivoEspecifico, descripcionMateria, Carrera = "SELECCIONE", Eje = "SELECCIONE", materiaCiclo, creditos,
                horasDocencia, horasPracticas, horasPresenciales, horasAutoEstudio,
                totalHoras;
        Carrera = frmMaterias.getCbCarrera().getSelectedItem().toString();
        Eje = frmMaterias.getCbEjeFormacion().getSelectedItem().toString();
        materiaCodigo = frmMaterias.getTxt_CodMateria().getText();
        materiaNombre = frmMaterias.getTxtNombreMateria().getText();
        materiaCiclo = frmMaterias.getCbx_Ciclo().getSelectedItem().toString();
        tipoAcreditacion = frmMaterias.getCbTipoAcreditacion().getSelectedItem().toString();
        creditos = frmMaterias.getTxtCreditos().getText();
        horasDocencia = frmMaterias.getTxtHorasDocencia().getText();
        horasPracticas = frmMaterias.getTxtHorasPracticas().getText();
        horasPresenciales = frmMaterias.getTxtHorasPresenciales().getText();
        horasAutoEstudio = frmMaterias.getTxtHorasAutoEstudio().getText();
        totalHoras = frmMaterias.getTxtTotalHoras().getText();
        objetivoGeneral = frmMaterias.getTxtObjetivoGeneral().getText();
        objetivoEspecifico = frmMaterias.getTxtObjetivoEspecifico().getText();
        descripcionMateria = frmMaterias.getTxtDescripcionMateria().getText();
        if (Carrera.equals("SELECCIONE") == false && Eje.equals("SELECCIONE") == false
                && materiaCodigo.equals("") == false && materiaNombre.equals("") == false
                && materiaCiclo.equals("SELECCIONE") == false && tipoAcreditacion.equals("SELECCIONE") == false
                && creditos.equals("") == false && horasDocencia.equals("") == false && horasPracticas.equals("") == false
                && horasPresenciales.equals("") == false && horasAutoEstudio.equals("") == false
                && totalHoras.equals("") == false && objetivoGeneral.equals("") == false && objetivoEspecifico.equals("") == false
                && descripcionMateria.equals("") == false) {
            if (frmMaterias.getLblErrorCarrera().isVisible() == false && frmMaterias.getLblErrorEjeFormacion().isVisible() == false
                    && frmMaterias.getLblErrorCodigoMateria().isVisible() == false && frmMaterias.getLblErrorNombreMateria().isVisible() == false
                    && frmMaterias.getLblErrorTipoAcreditacion().isVisible() == false && frmMaterias.getLblErrorMateriaCiclo().isVisible() == false
                    && frmMaterias.getLblErrorCreditos().isVisible() == false && frmMaterias.getLblErrorCampoFormacion().isVisible() == false
                    && frmMaterias.getLblErrorOrganizacionCurricular().isVisible() == false) {
                frmMaterias.getBtnGuardar().setEnabled(true);
                guardar = true;

            } else {
                frmMaterias.getBtnGuardar().setEnabled(false);
            }
        } else {
            frmMaterias.getBtnGuardar().setEnabled(false);
        }

    }

    public void iniciarComponentes() {

        frmMaterias.getCbCarrera().setToolTipText("Seleccione un Carrera");
        frmMaterias.getCbEjeFormacion().setToolTipText("Seleccione un Eje de Formación");
        frmMaterias.getTxt_CodMateria().setToolTipText("Escriba el Código perteneciente a la Materia, este Código debe ser único");
        frmMaterias.getTxtNombreMateria().setToolTipText("Escriba el Nombre de la Materia");
        frmMaterias.getCbMateriaTipo().setToolTipText("Seleccione el Tipo de la Materia de la siguiente lista");
        frmMaterias.getCbTipoAcreditacion().setToolTipText("Seleccione un Tipo de Acreditación de la siguiente lista");
        frmMaterias.getCbx_Ciclo().setToolTipText("Seleccione el Ciclo al que pertenece esta materia");
        frmMaterias.getTxtCreditos().setToolTipText("Escriba el total de horas o créditos de la Materia");
        frmMaterias.getTxtHorasDocencia().setToolTipText("Escriba el número de horas de Docencia de la materia");
        frmMaterias.getTxtHorasAutoEstudio().setToolTipText("Escriba el número de horas Autoestudio de la materia");
        frmMaterias.getTxtHorasPracticas().setToolTipText("Escriba el número de horas Prácticas de la materia");
        frmMaterias.getTxtObjetivoGeneral().setToolTipText("Escriba el Objetivo General de la materia");
        frmMaterias.getTxtObjetivoEspecifico().setToolTipText("Escriba el Objetivo Específico de la materia");
        frmMaterias.getCbx_OrgCurricular().setToolTipText("Seleccione la Unidad de Organización Curricular de la materia");
        frmMaterias.getTxtDescripcionMateria().setToolTipText("Escriba la Descripción de la materia");
        frmMaterias.getCbTipoAcreditacion().setToolTipText("Seleccione la Organización Curricular de la materia");

        frmMaterias.getLblErrorCarrera().setVisible(false);
        frmMaterias.getLblErrorEjeFormacion().setVisible(false);
        frmMaterias.getLblErrorCodigoMateria().setVisible(false);
        frmMaterias.getLblErrorMateriaTipo().setVisible(false);
        frmMaterias.getLblErrorNombreMateria().setVisible(false);
        frmMaterias.getLblErrorMateriaCiclo().setVisible(false);
        frmMaterias.getLblErrorTipoAcreditacion().setVisible(false);
        frmMaterias.getLblErrorCreditos().setVisible(false);
        frmMaterias.getLblErrorHorasDocencia().setVisible(false);
        frmMaterias.getLblErrorHorasPracticas().setVisible(false);
        frmMaterias.getLblErrorHorasPresenciales().setVisible(false);
        frmMaterias.getLblErrorHorasAutoEstudio().setVisible(false);
        frmMaterias.getLblErrorTotalHoras().setVisible(false);
        frmMaterias.getLblErrorObjetivoGeneral().setVisible(false);
        frmMaterias.getLblErrorObjetivoEspecifico().setVisible(false);
        frmMaterias.getLblErrorDescripcionMateria().setVisible(false);
        frmMaterias.getLblErrorOrganizacionCurricular().setVisible(false);
        frmMaterias.getLblErrorCampoFormacion().setVisible(false);
        frmMaterias.getBtnGuardar().setText("Guardar");
        frmMaterias.getCbEjeFormacion().setEnabled(false);
        frmMaterias.getBtnGuardar().setEnabled(false);
        frmMaterias.getTxtObjetivoGeneral().setLineWrap(true);
        frmMaterias.getTxtObjetivoGeneral().setWrapStyleWord(true);
        frmMaterias.getTxtObjetivoEspecifico().setLineWrap(true);
        frmMaterias.getTxtObjetivoEspecifico().setWrapStyleWord(true);
        frmMaterias.getTxtDescripcionMateria().setLineWrap(true);
        frmMaterias.getTxtDescripcionMateria().setWrapStyleWord(true);
    }

    public void borrarCampos() {

        frmMaterias.getTxt_CodMateria().setText("");
        frmMaterias.getTxtCreditos().setText("");
        frmMaterias.getTxtDescripcionMateria().setText("");
        frmMaterias.getTxtHorasAutoEstudio().setText("");
        frmMaterias.getTxtHorasDocencia().setText("");
        frmMaterias.getTxtHorasPracticas().setText("");
        frmMaterias.getTxtHorasPresenciales().setText("");
        frmMaterias.getTxtNombreMateria().setText("");
        frmMaterias.getTxtObjetivoEspecifico().setText("");
        frmMaterias.getTxtObjetivoGeneral().setText("");
        frmMaterias.getTxtTotalHoras().setText("");
        frmMaterias.getCbCarrera().setSelectedIndex(0);
        frmMaterias.getCbEjeFormacion().setSelectedIndex(0);
        frmMaterias.getCbMateriaTipo().setSelectedIndex(0);
        frmMaterias.getCbTipoAcreditacion().setSelectedIndex(0);
        frmMaterias.getCbx_CamFormacion().setSelectedIndex(0);
        frmMaterias.getCbx_Ciclo().setSelectedIndex(0);
        frmMaterias.getCbx_OrgCurricular().setSelectedIndex(0);
        frmMaterias.getChBNucleo().setSelected(false);

    }

    private void guardarMateria() {

        String materiaCodigo, materiaNombre,
                materiaTipo, tipoAcreditacion,
                objetivoGeneral, objetivoEspecifico, descripcionMateria,
                organizacionCurricular, campoFormacion, carrera, eje;

        int materiaCarrera, creditos,
                horasDocencia, horasPracticas, horasPresenciales, horasAutoEstudio,
                totalHoras, materiaCiclo = 0;
        boolean materiaNucleo;
        CarreraMD carreraMD = new CarreraMD();
        EjeFormacionMD ejeMD = new EjeFormacionMD();

        carrera = frmMaterias.getCbCarrera().getSelectedItem().toString();
        eje = frmMaterias.getCbEjeFormacion().getSelectedItem().toString();
        materiaCodigo = frmMaterias.getTxt_CodMateria().getText().trim().toUpperCase();
        materiaNombre = frmMaterias.getTxtNombreMateria().getText().trim().toUpperCase();

        switch (frmMaterias.getCbx_Ciclo().getSelectedItem().toString()) {
            case "SELECCIONE":
                materiaCiclo = 0;
                break;
            case "Ciclo 1":
                materiaCiclo = 1;
                break;
            case "Ciclo 2":
                materiaCiclo = 2;
                break;
            case "Ciclo 3":
                materiaCiclo = 3;
                break;
            case "Ciclo 4":
                materiaCiclo = 4;
                break;
            case "Ciclo 5":
                materiaCiclo = 5;
                break;
            case "Ciclo 6":
                materiaCiclo = 6;
                break;
        }

        materiaTipo = frmMaterias.getCbMateriaTipo().getSelectedItem().toString();
        tipoAcreditacion = frmMaterias.getCbTipoAcreditacion().getSelectedItem().toString();
        creditos = Integer.parseInt(frmMaterias.getTxtCreditos().getText());
        materiaNucleo = frmMaterias.getChBNucleo().isSelected();
        horasDocencia = Integer.parseInt(frmMaterias.getTxtHorasDocencia().getText().trim());
        horasPracticas = Integer.parseInt(frmMaterias.getTxtHorasPracticas().getText().trim());
        horasPresenciales = Integer.parseInt(frmMaterias.getTxtHorasPresenciales().getText().trim());
        horasAutoEstudio = Integer.parseInt(frmMaterias.getTxtHorasAutoEstudio().getText().trim());
        totalHoras = Integer.parseInt(frmMaterias.getTxtTotalHoras().getText().trim());
        objetivoGeneral = frmMaterias.getTxtObjetivoGeneral().getText().trim();
        objetivoEspecifico = frmMaterias.getTxtObjetivoEspecifico().getText().trim();
        descripcionMateria = frmMaterias.getTxtDescripcionMateria().getText().trim();
        organizacionCurricular = frmMaterias.getCbx_OrgCurricular().getSelectedItem().toString();
        campoFormacion = frmMaterias.getCbx_CamFormacion().getSelectedItem().toString();

        if (guardar) {

            MateriaMD materia = new MateriaMD();
            carreraMD.setId(MTBD.filtrarIdCarrera(carrera, 0).getId());
            ejeMD.setId(MTBD.filtrarIdEje(eje, 0).getId());
            materia.setCarrera(carreraMD);
            materia.setEje(ejeMD);
            materia.setCodigo(materiaCodigo);
            materia.setNombre(materiaNombre);
            materia.setCiclo(materiaCiclo);
            materia.setCreditos(creditos);

            if (materiaTipo.equals("SELECCIONE")) {
                materia.setTipo(' ');
            } else {
                materia.setTipo(materiaTipo.charAt(0));
            }

            materia.setTipoAcreditacion(tipoAcreditacion.charAt(0));
            materia.setHorasDocencia(horasDocencia);
            materia.setHorasPracticas(horasPracticas);
            materia.setHorasPresenciales(horasPresenciales);
            materia.setHorasAutoEstudio(horasAutoEstudio);
            materia.setTotalHoras(totalHoras);
            materia.setObjetivo(objetivoGeneral);
            materia.setObjetivoespecifico(objetivoEspecifico);
            materia.setDescripcion(descripcionMateria);
            materia.setOrganizacioncurricular(organizacionCurricular);
            materia.setMateriacampoformacion(campoFormacion);
            materia.setMateriaNucleo(materiaNucleo);

            if (editar) {
                materia.setId(idEditar);
                if (MTBD.editarMateria(materia)) {
                    JOptionPane.showMessageDialog(ctrPrin.getVtnPrin(), "Datos Editados Correctamente");
                    actualizarVtnMaterias();
                    frmMaterias.dispose();
                } else {
                    JOptionPane.showMessageDialog(ctrPrin.getVtnPrin(), "Los no se pudieron Editar Correctamente");
                }
                idEditar = 0;
                editar = false;

            } else {
                if (MTBD.insertarMateria(materia)) {
                    JOptionPane.showMessageDialog(ctrPrin.getVtnPrin(), "Datos Guardados Correctamente");
                    actualizarVtnMaterias();
                    frmMaterias.dispose();
                } else {
                    JOptionPane.showMessageDialog(ctrPrin.getVtnPrin(), "Los datos no se pudieron Guardar Correctamente");
                }
            }
            ctrPrin.cerradoJIF();
        } else {
            JOptionPane.showMessageDialog(null, "Existen errores en los campos\nRevise su información!!");
        }
    }

    public void cancelar() {
        frmMaterias.dispose();
    }

    public void buscarMateria() {
        String codigo = frmMaterias.getTxt_CodMateria().getText().trim();
        if (!codigo.equals("")) {
            MateriaMD materia;
            materia = MTBD.buscarMateriaxCodigo(codigo);
            editar = true;
            if (materia == null) {
                editar = false;
                iniciarComponentes();
                borrarCampos();
                iniciarValidaciones();
                JOptionPane.showMessageDialog(null, "No se encuentra a la Materia");
            } else {
                editarMaterias(materia);
                iniciarValidaciones();
                habilitarGuardar();
            }
        }
    }

    public void iniciarValidaciones() {

        PropertyChangeListener habilitar = (PropertyChangeEvent evt) -> {
            habilitarGuardar();
        };

        KeyListener validarPalabras = new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char car = e.getKeyChar();
                if (!Validar.esLetrasYNumeros2(car + "")) {
                    e.consume();
                }
                habilitarGuardar();
            }
        };

        FocusListener horas = new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                String docencia = frmMaterias.getTxtHorasDocencia().getText();
                String auto = frmMaterias.getTxtHorasAutoEstudio().getText();
                String practicas = frmMaterias.getTxtHorasPracticas().getText();
                if (docencia.equals("") == false && practicas.equals("") == false) {
                    int horas_Docencia = Integer.valueOf(frmMaterias.getTxtHorasDocencia().getText());
                    int horas_Practicas = Integer.valueOf(frmMaterias.getTxtHorasPracticas().getText());
                    int horasPresenciales = horas_Docencia + horas_Practicas;
                    frmMaterias.getTxtHorasPresenciales().setText(String.valueOf(horasPresenciales));
                }
                if (docencia.equals("") == false && practicas.equals("") == false && auto.equals("") == false) {
                    int horas_Docencia = Integer.valueOf(frmMaterias.getTxtHorasDocencia().getText());
                    int horas_Auto = Integer.valueOf(frmMaterias.getTxtHorasAutoEstudio().getText());
                    int horas_Practicas = Integer.valueOf(frmMaterias.getTxtHorasPracticas().getText());
                    int horasTotales = horas_Docencia + horas_Practicas + horas_Auto;
                    frmMaterias.getTxtTotalHoras().setText(String.valueOf(horasTotales));
                }
            }
        };

        KeyListener validarNombre = new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char car = e.getKeyChar();
                if (!Validar.esLetras2(car + "")) {
                    e.consume();
                }
                habilitarGuardar();
            }
        };

        KeyListener validarHorasDoc = new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                String palabra = frmMaterias.getTxtHorasDocencia().getText().trim();
                char car = e.getKeyChar();
                if (!Validar.esNumeros(car + "")) {
                    e.consume();
                }
                if (palabra != null) {
                    if (palabra.length() >= 3) {
                        e.consume();
                    }
                }
                habilitarGuardar();
            }
        };

        frmMaterias.getCbEjeFormacion()
                .addPropertyChangeListener(habilitar);
        frmMaterias.getCbMateriaTipo()
                .addActionListener(new CmbValidar(
                        frmMaterias.getCbMateriaTipo(), frmMaterias.getLblErrorMateriaTipo()));
        frmMaterias.getCbMateriaTipo()
                .addPropertyChangeListener(habilitar);
        frmMaterias.getCbTipoAcreditacion()
                .addActionListener(new CmbValidar(
                        frmMaterias.getCbTipoAcreditacion(), frmMaterias.getLblErrorTipoAcreditacion()));
        frmMaterias.getCbTipoAcreditacion()
                .addPropertyChangeListener(habilitar);
        frmMaterias.getCbx_Ciclo()
                .addActionListener(new CmbValidar(
                        frmMaterias.getCbx_Ciclo(), frmMaterias.getLblErrorMateriaCiclo()));
        frmMaterias.getCbx_Ciclo()
                .addPropertyChangeListener(habilitar);
        frmMaterias.getCbx_OrgCurricular()
                .addActionListener(new CmbValidar(
                        frmMaterias.getCbx_OrgCurricular(), frmMaterias.getLblErrorOrganizacionCurricular()));
        frmMaterias.getCbx_OrgCurricular()
                .addPropertyChangeListener(habilitar);
        frmMaterias.getCbx_CamFormacion()
                .addActionListener(new CmbValidar(
                        frmMaterias.getCbx_CamFormacion(), frmMaterias.getLblErrorCampoFormacion()));
        frmMaterias.getCbx_CamFormacion()
                .addPropertyChangeListener(habilitar);

        //Validar el codigo de materias con letras, numeros y _ - 
        frmMaterias.getTxt_CodMateria()
                .addKeyListener(validarPalabras);
        frmMaterias.getTxtNombreMateria()
                .addKeyListener(validarNombre);
        frmMaterias.getTxtCreditos()
                .addKeyListener(new TxtVNumeros_2(frmMaterias.getTxtCreditos()));
        frmMaterias.getTxtCreditos()
                .addPropertyChangeListener(habilitar);
        frmMaterias.getTxtHorasDocencia()
                .addKeyListener(new TxtVNumeros_2(frmMaterias.getTxtHorasDocencia()));
        frmMaterias.getTxtHorasDocencia()
                .addPropertyChangeListener(habilitar);
        frmMaterias.getTxtHorasPracticas()
                .addKeyListener(new TxtVNumeros_2(frmMaterias.getTxtHorasPracticas()));
        frmMaterias.getTxtHorasPracticas()
                .addPropertyChangeListener(habilitar);
        frmMaterias.getTxtHorasPresenciales()
                .addKeyListener(new TxtVNumeros_2(frmMaterias.getTxtHorasPresenciales()));
        frmMaterias.getTxtHorasPresenciales()
                .addPropertyChangeListener(habilitar);
        frmMaterias.getTxtHorasAutoEstudio()
                .addKeyListener(new TxtVNumeros_2(frmMaterias.getTxtHorasAutoEstudio()));
        frmMaterias.getTxtHorasAutoEstudio()
                .addPropertyChangeListener(habilitar);
        frmMaterias.getTxtTotalHoras()
                .addKeyListener(new TxtVNumeros_2(frmMaterias.getTxtTotalHoras()));
        frmMaterias.getTxtTotalHoras()
                .addPropertyChangeListener(habilitar);
        frmMaterias.getTxtHorasDocencia().addFocusListener(horas);
        frmMaterias.getTxtHorasAutoEstudio().addFocusListener(horas);
        frmMaterias.getTxtHorasPracticas().addFocusListener(horas);
        frmMaterias.getTxtHorasPresenciales().setEnabled(false);
        frmMaterias.getTxtTotalHoras().setEnabled(false);
        Font negrita = new Font("Tahoma", Font.BOLD, 13);
        frmMaterias.getTxtHorasPresenciales().setFont(negrita);
        frmMaterias.getTxtTotalHoras().setFont(negrita);
        //Permitir insertar comas y puntos

        KeyListener validar = new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char car = e.getKeyChar();
                if (!Validar.esObservacion(car + "")) {
                    e.consume();
                }
                habilitarGuardar();
            }
        };

        frmMaterias.getTxtObjetivoGeneral()
                .addKeyListener(validar);
        frmMaterias.getTxtObjetivoEspecifico()
                .addKeyListener(validar);
        frmMaterias.getTxtDescripcionMateria()
                .addKeyListener(validar);

    }

    public void editarMaterias(MateriaMD matEditar) {

        editar = true;
        idEditar = matEditar.getId();
        nombre_Materia = matEditar.getNombre();
        frmMaterias.getTxt_CodMateria().setText(matEditar.getCodigo());
        frmMaterias.getTxtNombreMateria().setText(matEditar.getNombre());

        frmMaterias.getTxtCreditos().setText(matEditar.getCreditos() + "");
        frmMaterias.getTxtDescripcionMateria().setText(matEditar.getDescripcion());
        frmMaterias.getTxtHorasAutoEstudio().setText(matEditar.getHorasAutoEstudio() + "");

        frmMaterias.getTxtHorasDocencia().setText(matEditar.getHorasDocencia() + "");
        frmMaterias.getTxtHorasPracticas().setText(matEditar.getHorasPracticas() + "");
        frmMaterias.getTxtHorasPresenciales().setText(matEditar.getHorasPresenciales() + "");
        frmMaterias.getTxtObjetivoEspecifico().setText(matEditar.getObjetivoespecifico());
        frmMaterias.getTxtObjetivoGeneral().setText(matEditar.getObjetivo());

        frmMaterias.getTxtTotalHoras().setText(matEditar.getTotalHoras() + "");
        frmMaterias.getChBNucleo().setSelected(matEditar.isMateriaNucleo());

        if (matEditar.getCarrera() == null) {
            frmMaterias.getCbCarrera().setSelectedItem("SELECCIONE");
        } else {
            frmMaterias.getCbCarrera().setSelectedItem(
                    MTBD.filtrarIdCarrera("", matEditar.getCarrera().getId()).getNombre()
            );
            frmMaterias.getCbCarrera().setEnabled(false);
        }
        //

        if (matEditar.getEje().getId() > 40) {
            frmMaterias.getCbEjeFormacion().setSelectedItem(MTBD.filtrarIdEje("", matEditar.getEje().getId()).getNombre());
        } else {
            frmMaterias.getCbEjeFormacion().setSelectedItem("SELECCIONE");
        }
        //
        int ciclo = matEditar.getCiclo();
        switch (ciclo) {

            case 1:
                frmMaterias.getCbx_Ciclo().setSelectedItem("Ciclo 1");
                break;
            case 2:
                frmMaterias.getCbx_Ciclo().setSelectedItem("Ciclo 2");
                break;
            case 3:
                frmMaterias.getCbx_Ciclo().setSelectedItem("Ciclo 3");
                break;
            case 4:
                frmMaterias.getCbx_Ciclo().setSelectedItem("Ciclo 4");
                break;
            case 5:
                frmMaterias.getCbx_Ciclo().setSelectedItem("Ciclo 5");
                break;

        }

        String materiaTipo = matEditar.getTipo() + "";
        if (null == materiaTipo) {
            materiaTipo = "H";
        } else {
            switch (materiaTipo) {
                case "M":
                    materiaTipo = "M";
                    break;
                case "C":
                    materiaTipo = "C";
                    break;
                case "H":
                    materiaTipo = "H";
                    break;
                default:
                    materiaTipo = "SELECCIONE";
                    break;
            }
        }
        frmMaterias.getCbMateriaTipo().setSelectedItem(materiaTipo);

        String tipoAcreditacion = matEditar.getTipoAcreditacion() + "";
        if (null == tipoAcreditacion) {
            tipoAcreditacion = "T";
        } else {
            switch (tipoAcreditacion) {
                case "H":
                    tipoAcreditacion = "H";
                    break;
                case "C":
                    tipoAcreditacion = "C";
                    break;
                case "T":
                    tipoAcreditacion = "T";
                    break;
                default:
                    tipoAcreditacion = "SELECCIONE";
                    break;
            }
        }
        frmMaterias.getCbTipoAcreditacion().setSelectedItem(tipoAcreditacion);
        frmMaterias.getCbx_OrgCurricular().setSelectedItem(matEditar.getOrganizacioncurricular());
        frmMaterias.getCbx_CamFormacion().setSelectedItem(matEditar.getMateriacampoformacion());

        iniciarValidaciones();
    }

    private void actualizarVtnMaterias() {
        if (ctrVtnMat != null) {
            ctrVtnMat.actualizarVtn();
        }
    }

}
