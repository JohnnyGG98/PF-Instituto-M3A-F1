package controlador.silabo.frm;

import controlador.principal.DCTR;
import controlador.principal.VtnPrincipalCTR;
import java.awt.Cursor;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import javax.swing.table.DefaultTableModel;
import modelo.estilo.TblEstilo;
import modelo.estrategiasAprendizaje.EstrategiasAprendizajeMD;
import modelo.estrategiasAprendizaje.NEWEstrategiaAprendizajeBD;
import modelo.estrategiasUnidad.EstrategiasUnidadMD;
import modelo.evaluacionSilabo.EvaluacionSilaboMD;
import modelo.evaluacionSilabo.NEWEvaluacionSilaboBD;
import modelo.referencias.ReferenciasMD;
import modelo.referenciasSilabo.ReferenciaSilaboMD;
import modelo.silabo.NEWEstrategiaUnidadBD;
import modelo.silabo.NEWPeriodoLectivoBD;
import modelo.silabo.NEWReferenciaSilaboBD;
import modelo.silabo.NEWSilaboBD;
import modelo.silabo.NEWTipoActividadBD;
import modelo.silabo.NEWUnidadSilaboBD;
import modelo.silabo.SilaboMD;
import modelo.tipoActividad.TipoActividadMD;
import modelo.unidadSilabo.UnidadSilaboMD;
import modelo.validaciones.Validar;
import vista.silabos.NEWFrmAcciones;
import vista.silabos.NEWFrmSilabo;

/**
 *
 * @author gus
 */
public class FRMSilaboCTR extends DCTR {

    // Formulario principal 
    private final NEWFrmSilabo FRM_GESTION = new NEWFrmSilabo();
    // Formulario de acciones  
    private final NEWFrmAcciones FRM_ACCIONES;
    // Conexiones a base de datos
    private final NEWSilaboBD SBD = NEWSilaboBD.single();
    private final NEWUnidadSilaboBD USBD = NEWUnidadSilaboBD.single();
    private final NEWEstrategiaUnidadBD EUBD = NEWEstrategiaUnidadBD.single();
    private final NEWReferenciaSilaboBD RSBD = NEWReferenciaSilaboBD.single();
    private final NEWTipoActividadBD TABD = NEWTipoActividadBD.single();
    private final NEWEvaluacionSilaboBD EVBD = NEWEvaluacionSilaboBD.single();
    private final NEWEstrategiaAprendizajeBD EABD = NEWEstrategiaAprendizajeBD.single();

    // Utilidades en este formulario 
    private final UtilsFRMSilaboCTR UFRMSCTR = UtilsFRMSilaboCTR.single();

    // Listas para guardar los contenidos del formulario 
    private List<UnidadSilaboMD> unidades;
    protected List<EstrategiasUnidadMD> estrategias;
    protected List<EvaluacionSilaboMD> evaluaciones;
    protected List<TipoActividadMD> tiposActividad;
    protected List<ReferenciasMD> biblioteca;
    protected List<ReferenciaSilaboMD> referenciasSilabo;
    // Listas para el buscador del combo 
    protected List<EstrategiasAprendizajeMD> todasEstrategias;
    // Lista para la tabla
    protected List<EstrategiasAprendizajeMD> filterEstrategias;
    // Para validar si ya fue ingresada esta estrategia 
    private boolean existeEstrategia;

    // Titulo de las tablas  
    private static final String[] TITULO_GESTION = {
        "IDL", "Indicador", "Instrumento",
        "Valoración", "Fecha Envío",
        "Fecha Presentación"
    };
    private static final String[] TITULO_ESTRATEGIAS = {
        "X", "Titulo"
    };
    // Todos los modelos de las tablas de gestion
    private final DefaultTableModel mdTblAD = TblEstilo.modelTblSinEditar(TITULO_GESTION);
    private final DefaultTableModel mdTblAC = TblEstilo.modelTblSinEditar(TITULO_GESTION);
    private final DefaultTableModel mdTblGP = TblEstilo.modelTblSinEditar(TITULO_GESTION);
    private final DefaultTableModel mdTblGA = TblEstilo.modelTblSinEditar(TITULO_GESTION);
    private final DefaultTableModel mdTblES = TblEstilo.modelTblSinEditar(TITULO_ESTRATEGIAS);

    // Para tener referencia de un silabo 
    private final SilaboMD silabo;
    // Para guardar la unidad  
    private UnidadSilaboMD unidadSelec;
    // El numero de horas docencia, practica y autonomas 
    private double numHD = 0;
    private double numHP = 0;
    private double numHA = 0;
    // Para saber si estamos cambiando de unidad y controlar los change listeners 
    private boolean cambioUnidad = false;
    // Bandera para saber en que panel de actividades estamos  
    private String actividadActual = "AD";
    // Total de las gestion 
    private double totalGestion = 0;
    // Actividad seleccionada al dar click en editar o eliminar 
    private EvaluacionSilaboMD evaluacionSelec;
    // Banderas 
    boolean eliminandoUnidad = false;// Para saber cuando se esta eliminando una unidad
    // Error mensaje en silabo
    private String msgErrorSilabo;

    public FRMSilaboCTR(
            VtnPrincipalCTR ctrPrin,
            SilaboMD silabo
    ) {
        super(ctrPrin);
        if (silabo.getPeriodo().getFechaFinClases() == null) {
            silabo.getPeriodo().setFechaFinClases(
                    silabo.getPeriodo().getFechaFin()
            );
        }
        this.silabo = silabo;
        FRM_ACCIONES = new NEWFrmAcciones(ctrPrin.getVtnPrin(), false);
        FRM_ACCIONES.setLocationRelativeTo(FRM_GESTION);
    }

    public void nuevo(int num) {
        crearSilaboNuevo(num);
        iniciarSilabo();
        iniciarVentana();
    }

    public void referenciado(boolean conEvaluaciones) {
        NEWPeriodoLectivoBD PBD = NEWPeriodoLectivoBD.single();
        silabo.setPeriodo(PBD.getUltimoPorPeriodo(silabo.getPeriodo().getID()));
        // Buscamos sin el id de las unidades
        unidades = USBD.getBySilaboParaReferencia(silabo.getID());
        if (conEvaluaciones) {
            evaluaciones = EVBD.getBySilaboReferencia(silabo.getID());
        }
        estrategias = EUBD.getBySilaboReferencia(silabo.getID());

        iniciarSilabo();
        iniciarVentana();
        // Guardamos el silabo al ingresar.
        int idSilaboGen = SBD.guardar(silabo);
        if (idSilaboGen > 0) {
            silabo.setID(idSilaboGen);
            guardar();
        } else {
            silabo.setID(0);
            UFRMSCTR.errorGuardarSilabo();
        }
    }

    public void editar() {
        // Buscamos con el id de unidades
        unidades = USBD.getBySilabo(silabo.getID());
        evaluaciones = EVBD.getBySilabo(silabo.getID());
        estrategias = EUBD.getBySilabo(silabo.getID());
        iniciarSilabo();
        iniciarVentana();
    }

    private void estiloTablas() {
        TblEstilo.columnaMedida(FRM_GESTION.getTblEstrategias(), 0, 20);
        TblEstilo.ColumnaCentrar(FRM_GESTION.getTblEstrategias(), 0);
    }

    /**
     * Comprobamos si existe o no un silabo anterior para iniciar el formulario
     */
    private void iniciarVentana() {
        // Evento para detectar cuando se cierre la ventana  
        FRM_GESTION.addInternalFrameListener(new InternalFrameAdapter() {
            @Override
            public void internalFrameClosing(InternalFrameEvent e) {
                cambioUnidad = true;
            }
        });
        // Acciones
        FRM_GESTION.getBtnGuardar().addActionListener(e -> guardar());
        FRM_GESTION.getBtnSiguiente().addActionListener(e -> agregarBibliografia());
        // Tablas
        estiloTablas();
        // Cargamos todas las estrategias  
        todasEstrategias = EABD.getAll();
        // Siempre iniciamos el estado del boton en falso para que 
        // no pueda guardar hasta realizar cambios
        // estadoBtnGuardar(false);
        // Titulo de la unidad  
        FRM_GESTION.setTitle(
                silabo.getPeriodo().getNombre()
                + " | "
                + silabo.getMateria().getNombre()
        );
        actualizarHoras();
        // Iniciamos el cmb de las estrategias 
        iniciarCmbEstrategiasConBuscador();
        // Mostramos la ventana 
        ctrPrin.agregarVtn(FRM_GESTION);
        cargarCmbUnidad();
        mostrarUnidad();
        // Iniciamos todas las acciones 
        iniciarAccionesActividades();
        iniciarEventoSPNHoras();
        iniciarEventosFecha();
        iniciarEventosFormulario();
        iniciarEventosUnidad();
        iniciarTblEstrategia();
        // Con esto detectamos en que panel se encuentra actualmente
        detectarPanel();
    }

    /**
     * Eventos de todos los txt de nuestro formulario, al escribir reescribimos
     * igual en el modelo
     */
    private void iniciarEventosFormulario() {
        FRM_GESTION.getTxtTitulo().addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                unidadSelec.setTituloUnidad(
                        UFRMSCTR.getTextFromTxt(FRM_GESTION.getTxtTitulo())
                );
            }
        });
        FRM_GESTION.getTxrContenidos().addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                unidadSelec.setContenidosUnidad(
                        UFRMSCTR.getTextFromTxa(FRM_GESTION.getTxrContenidos())
                );
            }
        });
        FRM_GESTION.getTxrObjetivos().addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                unidadSelec.setObjetivoEspecificoUnidad(
                        UFRMSCTR.getTextFromTxa(FRM_GESTION.getTxrObjetivos())
                );
            }
        });
        FRM_GESTION.getTxrResultados().addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                unidadSelec.setResultadosAprendizajeUnidad(
                        UFRMSCTR.getTextFromTxa(FRM_GESTION.getTxrResultados())
                );
            }
        });
    }

    private void iniciarEventosUnidad() {
        FRM_GESTION.getLblEliminarUnidad().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int r = JOptionPane.showConfirmDialog(
                        FRM_ACCIONES,
                        "Esta seguro de eliminar la Unidad "
                        + unidadSelec.getNumeroUnidad()
                        + " no tendra opcion de recuperarla."
                );
                if (r == JOptionPane.YES_OPTION) {
                    eliminarUnidad();
                }
            }
        });
        FRM_GESTION.getLblAgregarUnidad().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                agregarUnidad();
            }
        });
        FRM_GESTION.getCmbUnidad().addActionListener(e -> mostrarUnidad());
    }

    /**
     * Eventos de todas las acciones de las actividades
     */
    private void iniciarAccionesActividades() {
        FRM_GESTION.getBtnAgregar().addActionListener(e -> nuevaActividad());
        FRM_GESTION.getBtnEditar().addActionListener(e -> editarActividad());
        FRM_GESTION.getBtnQuitar().addActionListener(e -> eliminarActividad());
        FRM_ACCIONES.getBtnGuardar().addActionListener(e -> guardarEvaluacion());
    }

    private void guardarEvaluacion() {
        if (frmEvaluacionValido()) {
            boolean guardando = false;
            // Si no tenemos seleccionada ninguna evaluacion creamos una nueva 
            if (evaluacionSelec == null) {
                guardando = true;
                evaluacionSelec = new EvaluacionSilaboMD();
            }
            evaluacionSelec.setIndicador(
                    FRM_ACCIONES.getTxtIndicador().getText()
            );
            evaluacionSelec.setInstrumento(
                    FRM_ACCIONES.getTxtInstrumento().getText()
            );
            evaluacionSelec.setValoracion(Double.parseDouble(
                    FRM_ACCIONES.getSpnValoracion().getValue().toString()
            ));
            evaluacionSelec.setFechaEnvio(
                    UFRMSCTR.getFechaJDC(FRM_ACCIONES.getDchFechaEnvio())
            );
            evaluacionSelec.setFechaPresentacion(
                    UFRMSCTR.getFechaJDC(FRM_ACCIONES.getDchFechaPresentacion())
            );

            if (guardando) {
                evaluacionSelec.setIdUnidad(unidadSelec);
                evaluacionSelec.getIdTipoActividad().setIdTipoActividad(getIdTipoActividad());
                evaluaciones.add(evaluacionSelec);
            }

            cargarEvaluaciones();
            FRM_ACCIONES.setVisible(false);
            recetearFrmActividad();
        }
    }

    private boolean frmEvaluacionValido() {
        boolean valido = true;
        if (FRM_ACCIONES.getTxtIndicador().getText().equals("")
                || FRM_ACCIONES.getTxtInstrumento().getText().equals("")
                || FRM_ACCIONES.getSpnValoracion().getValue() == null
                || FRM_ACCIONES.getDchFechaEnvio().getDate() == null
                || FRM_ACCIONES.getDchFechaPresentacion().getDate() == null) {
            valido = false;
            UFRMSCTR.errorFrmEvaluacion("Debe ingresar todos los campos");
        }

        String msg = "";

        if (valido) {
            String valor = FRM_ACCIONES.getSpnValoracion().getValue().toString();
            valido = Validar.esNumerosDecimales(valor);
            if (!valido) {
                UFRMSCTR.errorFrmEvaluacion("La valoracion de la actividad es incorrecta.");
            }
        }

        if (valido) {
            LocalDate fe = UFRMSCTR.getFechaJDC(FRM_ACCIONES.getDchFechaEnvio());
            LocalDate fp = UFRMSCTR.getFechaJDC(FRM_ACCIONES.getDchFechaPresentacion());
            if (fp.isBefore(fe)) {
                msg += "La fecha de presentación debe ser despues de la de envio.\n";
                valido = false;
            }
            if (valido) {
                if (unidadSelec.getFechaFinUnidad() != null) {
                    if (fe.isAfter(unidadSelec.getFechaFinUnidad())) {
                        msg += "La fecha de envio debe ser "
                                + "antes del fin de la unidad.\n";
                        valido = false;
                    }
                    if (fp.isAfter(unidadSelec.getFechaFinUnidad())) {
                        msg += "La fecha de presentacion no debe ser superior "
                                + "a la fecha de fin de unidad";
                        valido = false;
                    }
                }
                if (unidadSelec.getFechaInicioUnidad() != null) {
                    if (fe.isBefore(unidadSelec.getFechaInicioUnidad())) {
                        msg += "La fecha de envio no puede ser anterior a "
                                + "la fecha de inicio de la unidad.\n";
                        valido = false;
                    }
                    if (fp.isBefore(unidadSelec.getFechaInicioUnidad())) {
                        msg += "La fecha de presentacion no debe ser anterior "
                                + "a la fecha de inicio del periodo.\n";
                        valido = false;
                    }
                }
            }
        }
        if (!valido) {
            UFRMSCTR.errorFrmEvaluacion(msg);
        }
        return valido;
    }

    private void nuevaActividad() {
        if (totalGestion < 60) {
            recetearFrmActividad();
            mostrarFrmActividades("Nuevo " + actividadActual);
        } else {
            JOptionPane.showMessageDialog(
                    FRM_ACCIONES,
                    "Ya cumple las 60 puntos necesarios en sus actividades.",
                    "Información Atividades",
                    JOptionPane.INFORMATION_MESSAGE
            );
        }
    }

    private void editarActividad() {
        String code = getActividadSeleccionada();
        if (!"".equals(code)) {
            seleccionPorIdLocal(code);
            if (evaluacionSelec != null) {
                System.out.println("Evaluacion: " + evaluacionSelec.toString());
                setearCamposActividad();
            }
        } else {
            JOptionPane.showMessageDialog(
                    FRM_ACCIONES,
                    "No selecciono ninguna actividad "
                    + actividadActual + " para editarla, "
                    + "selecciona de la tabla correspondiente",
                    "Editar Atividades",
                    JOptionPane.WARNING_MESSAGE
            );
        }
    }

    private void setearCamposActividad() {
        FRM_ACCIONES.getTxtIndicador().setText(evaluacionSelec.getIndicador());
        FRM_ACCIONES.getTxtInstrumento().setText(evaluacionSelec.getInstrumento());
        FRM_ACCIONES.getSpnValoracion().setValue(evaluacionSelec.getValoracion());
        FRM_ACCIONES.getDchFechaEnvio().setDate(
                Date.from(evaluacionSelec
                        .getFechaEnvio()
                        .atStartOfDay(ZoneId.systemDefault()).toInstant())
        );
        FRM_ACCIONES.getDchFechaPresentacion().setDate(
                Date.from(evaluacionSelec
                        .getFechaPresentacion()
                        .atStartOfDay(ZoneId.systemDefault()).toInstant())
        );
        mostrarFrmActividades("Nuevo " + actividadActual + " ID: " + evaluacionSelec.getIdLocal());
    }

    private void eliminarActividad() {
        String code = getActividadSeleccionada();
        if (!"".equals(code)) {
            int r = JOptionPane.showConfirmDialog(
                    FRM_ACCIONES,
                    "Esta seguro de quitar la actividad."
            );
            if (r == JOptionPane.YES_OPTION) {
                seleccionPorIdLocal(code);
                if (evaluacionSelec != null) {
                    System.out.println("Evaluacion: " + evaluacionSelec.toString());
                    if (evaluacionSelec.getIdEvaluacion() > 0) {
                        EVBD.eliminar(evaluacionSelec.getIdEvaluacion());
                    }
                    evaluaciones.remove(evaluacionSelec);
                    cargarEvaluaciones();
                }
            }
        } else {
            JOptionPane.showMessageDialog(
                    FRM_ACCIONES,
                    "No selecciono ninguna actividad para quitarla",
                    "Eliminar Atividades",
                    JOptionPane.WARNING_MESSAGE
            );
        }
    }

    private String getActividadSeleccionada() {
        String code;
        switch (actividadActual) {
            case "AD":
                code = UFRMSCTR.getIdLocalActividad(FRM_GESTION.getTblAsistidaDocente());
                break;
            case "AC":
                code = UFRMSCTR.getIdLocalActividad(FRM_GESTION.getTblAprendizajeColaborativo());
                break;
            case "GP":
                code = UFRMSCTR.getIdLocalActividad(FRM_GESTION.getTblPractica());
                break;
            case "GA":
                code = UFRMSCTR.getIdLocalActividad(FRM_GESTION.getTblAutonoma());
                break;
            default:
                code = "";
                break;
        }
        return code;
    }

    private void recetearFrmActividad() {
        FRM_ACCIONES.getTxtIndicador().setText("");
        FRM_ACCIONES.getTxtInstrumento().setText("");
        FRM_ACCIONES.getSpnValoracion().setValue(0.1);
        FRM_ACCIONES.getDchFechaEnvio().setDate(null);
        FRM_ACCIONES.getDchFechaPresentacion().setDate(null);
    }

    private void mostrarFrmActividades(String titulo) {
        FRM_ACCIONES.getLblAccionActividades().setText(titulo);
        FRM_ACCIONES.setVisible(true);
    }

    private void seleccionPorIdLocal(String code) {
        for (EvaluacionSilaboMD e : evaluaciones) {
            if (e.getIdLocal() == Integer.parseInt(code)) {
                evaluacionSelec = e;
                break;
            } else {
                evaluacionSelec = null;
            }
        }
    }

    private void cargarCmbUnidad() {
        FRM_GESTION.getCmbUnidad().removeAllItems();
        unidades.forEach(u -> {
            FRM_GESTION.getCmbUnidad()
                    .addItem("Unidad " + u.getNumeroUnidad());
        });
        if (unidades.size() > 0) {
            FRM_GESTION.getCmbUnidad().setSelectedIndex(0);
        }
    }

    private void iniciarCmbEstrategiasConBuscador() {
        iniciarCmbEstrategias();
        FRM_GESTION.getCmbEstrategias().getEditor().getEditorComponent().addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                int i = FRM_GESTION.getCmbEstrategias().getSelectedIndex();
                String a = FRM_GESTION.getCmbEstrategias().getEditor().getItem().toString().trim();
                if (e.getKeyCode() == 10) {
                    if (i > 0) {
                        agregarEstrategia(i);
                    } else {
                        if (a.length() >= 1) {
                            buscarEstrategias(a);
                        }
                    }
                }
            }
        });
        // SI le damos click para que se agrege una estrategia  
        FRM_GESTION.getCmbEstrategias().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int i = FRM_GESTION.getCmbEstrategias().getSelectedIndex();
                if (i > 0) {
                    agregarEstrategia(i);
                }
            }
        });
        // Si le damos a mas y esta seleccionado uno se agrega, 
        // si no existe se guarda en la base de datos
        FRM_GESTION.getLblAgregarEstrategia().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int i = FRM_GESTION.getCmbEstrategias().getSelectedIndex();
                if (i > 0) {
                    agregarEstrategia(i);
                } else {
                    String estrategia = FRM_GESTION.getCmbEstrategias()
                            .getEditor().getItem().toString().trim();
                    EstrategiasAprendizajeMD ea = new EstrategiasAprendizajeMD();
                    ea.setDescripcionEstrategia(estrategia);
                    int idGenerado = EABD.guardar(ea);
                    if (idGenerado > 0) {
                        ea.setIdEstrategia(idGenerado);
                        agregarEstrategia(ea);
                    } else {
                        JOptionPane.showMessageDialog(
                                FRM_ACCIONES,
                                "Error al crear una nueva estrategia vuelva "
                                + "a intentarlo mas tarde."
                        );
                    }
                }
            }
        });
    }

    private void iniciarCmbEstrategias() {
        FRM_GESTION.getCmbEstrategias().removeAllItems();
        FRM_GESTION.getCmbEstrategias().addItem("");
        FRM_GESTION.getCmbEstrategias().setEditable(true);
        todasEstrategias.forEach(e -> {
            FRM_GESTION.getCmbEstrategias().addItem(e.getDescripcionEstrategia());
        });
    }

    private void buscarEstrategias(String aguja) {
        filterEstrategias = null;
        filterEstrategias = new ArrayList<>();
        FRM_GESTION.getCmbEstrategias().removeAllItems();
        FRM_GESTION.getCmbEstrategias().addItem(aguja);
        todasEstrategias.forEach(e -> {
            if (e.getDescripcionEstrategia().toLowerCase().contains(aguja.toLowerCase())) {
                FRM_GESTION.getCmbEstrategias().addItem(e.getDescripcionEstrategia());
                filterEstrategias.add(e);
            }
        });
        FRM_GESTION.getCmbEstrategias().showPopup();
    }

    private void agregarEstrategia(int index) {
        EstrategiasUnidadMD ne = new EstrategiasUnidadMD();
        ne.setUnidad(unidadSelec);
        ne.setEstrategia(filterEstrategias.get(index - 1));
        llenarTblEstrategiasUnidad(ne);
    }

    private void agregarEstrategia(EstrategiasAprendizajeMD estrategia) {
        EstrategiasUnidadMD ne = new EstrategiasUnidadMD();
        ne.setUnidad(unidadSelec);
        ne.setEstrategia(estrategia);
        llenarTblEstrategiasUnidad(ne);
    }

    private void iniciarSilabo() {
        // Todos los modelos de las tablas  
        FRM_GESTION.getTblAprendizajeColaborativo()
                .setModel(mdTblAC);
        FRM_GESTION.getTblAsistidaDocente()
                .setModel(mdTblAD);
        FRM_GESTION.getTblAutonoma()
                .setModel(mdTblGA);
        FRM_GESTION.getTblPractica()
                .setModel(mdTblGP);
        FRM_GESTION.getTblEstrategias()
                .setModel(mdTblES);
        // Iniciamo los arrays para guardar las diferentes cosas
        if (evaluaciones == null) {
            evaluaciones = new ArrayList<>();
        }
        biblioteca = new ArrayList<>();
        tiposActividad = TABD.getAll();
    }

    private void crearSilaboNuevo(int numUnidades) {
        unidades = new ArrayList<>();
        estrategias = new ArrayList<>();
        // Agregamos el numero de unidades que indico 
        // en el formulario de configuracion
        for (int i = 1; i <= numUnidades; i++) {
            UnidadSilaboMD us = new UnidadSilaboMD();
            us.setNumeroUnidad(i);
            unidades.add(us);
        }
    }

    /**
     * Agregamos la bibliografia base
     */
    private void agregarBibliografia() {
        if (validarSilabo()) {
            if (silabo.getID() > 0) {
                // Aqui antes de guardar se debe validar que todo este correcto bro 
                guardar();
                FRMReferenciaSilaboCTR ctrReferencias = new FRMReferenciaSilaboCTR(
                        ctrPrin,
                        silabo,
                        FRM_GESTION,
                        cambioUnidad
                );
                ctrReferencias.iniciar();
            } else {
                // Guardamos el silabo al ingresar.
                silabo.setID(SBD.guardar(silabo));
                UFRMSCTR.errorGuardarSilabo();
            }
        }
    }

    /**
     *
     * @return
     */
    private boolean validarSilabo() {
        msgErrorSilabo = "";
        if (totalGestion < 60 || totalGestion > 60) {
            msgErrorSilabo += "Debe cumplir 60 puntos en su total de gestion.\n";
        }

        if (numHD < silabo.getMateria().getHorasDocencia()) {
            msgErrorSilabo += "Debe cumplir las horas establecidas en "
                    + "horas docencia en materia "
                    + silabo.getMateria().getHorasDocencia() + "\n";
        }

        if (numHA < silabo.getMateria().getHorasAutoEstudio()) {
            msgErrorSilabo += "Debe cumplir las horas establecidas en "
                    + "horas de autoestudio en materia "
                    + silabo.getMateria().getHorasAutoEstudio() + "\n";
        }

        if (numHP < silabo.getMateria().getHorasPracticas()) {
            msgErrorSilabo += "Debe cumplir las horas establecidas en "
                    + "horas practicas en materia "
                    + silabo.getMateria().getHorasPracticas() + "\n";
        }

        unidades.forEach(u -> {
            if (u.getFechaInicioUnidad() == null) {
                msgErrorSilabo += "Debe ingresar la fecha  de inicio "
                        + "de la unidad " + u.getNumeroUnidad() + "\n";
            }
            if (u.getFechaFinUnidad() == null) {
                msgErrorSilabo += "Debe ingresar la fecha  de fin "
                        + "de la unidad " + u.getNumeroUnidad() + "\n";
            }
            if (u.getContenidosUnidad().trim().length() == 0) {
                msgErrorSilabo += "Debe ingresar  el contenido "
                        + "de la unidad " + u.getNumeroUnidad() + "\n";
            }
            if (u.getObjetivoEspecificoUnidad().trim().length() == 0) {
                msgErrorSilabo += "Debe ingresar  el objetivo "
                        + "de la unidad " + u.getNumeroUnidad() + "\n";
            }
            if (u.getResultadosAprendizajeUnidad().trim().length() == 0) {
                msgErrorSilabo += "Debe ingresar  el resultado "
                        + "de aprendizaje de la unidad "
                        + u.getNumeroUnidad() + "\n";
            }
            if (u.getTituloUnidad().trim().length() == 0) {
                msgErrorSilabo += "Debe ingresar  el titulo "
                        + "de la unidad " + u.getNumeroUnidad() + "\n";
            }
        });
        return msgErrorSilabo.trim().length() == 0;
    }

    /**
     * Guardamos todo la informacion sin validar
     */
    private void guardar() {
        new Thread(() -> {
            FRM_GESTION.getBtnGuardar().setEnabled(false);
            ctrPrin.getVtnPrin().setCursor(new Cursor(3));

            // SI no se guardo el silabo previamente se guarda aqui 
            if (silabo.getID() == 0) {
                int idSilaboGen = SBD.guardar(silabo);
                silabo.setID(idSilaboGen);
            } else {
                SBD.setFechaEdicion(silabo.getID());
            }

            // Necesitamos que el silabo este guardado para continuar. 
            if (silabo.getID() > 0) {
                System.out.println("Guardamos silabo con ID: " + silabo.getID());
                ctrPrin.getVtnPrin().getLblEstado().setText("Guardamos silabo con ID: " + silabo.getID());
                silabo.setID(silabo.getID());
                unidades.forEach(u -> {
                    int idUnidadGenerado = u.getID();
                    if (u.getID() == 0) {
                        idUnidadGenerado = USBD.guardar(u, silabo.getID());
                    } else {
                        USBD.editar(u);
                    }
                    System.out.println("Guardamos unidad con ID: " + idUnidadGenerado);
                    ctrPrin.getVtnPrin().getLblEstado().setText("Guardamos unidad con ID: " + idUnidadGenerado);
                    // Si se guardo la unidad guardamos
                    // estrategias y evaluaciones
                    if (idUnidadGenerado > 0) {
                        u.setId(idUnidadGenerado);
                        guardarEstrategias(idUnidadGenerado, u.getNumeroUnidad());
                        guardarEvaluaciones(idUnidadGenerado, u.getNumeroUnidad());
                    } else {
                        UFRMSCTR.errorGuardar("Algo salio mal. \n"
                                + "No se pudo guardo la unidad " + u.getNumeroUnidad());
                    }
                });
            } else {
                UFRMSCTR.errorGuardarSilabo();
            }

            FRM_GESTION.getBtnGuardar().setEnabled(true);
            ctrPrin.getVtnPrin().setCursor(new Cursor(0));
        }).start();
    }

    private void guardarEstrategias(int idUnidadGenerado, int numeroUnidad) {
        estrategias.forEach(e -> {
            if (e.getUnidad().getNumeroUnidad() == numeroUnidad) {
                if (e.getIdEstrategiaUnidad() == 0) {
                    int idEstrategiaGen = EUBD.guardar(e, idUnidadGenerado);
                    e.setIdEstrategiaUnidad(idEstrategiaGen);
                } else {
                    EUBD.editar(e);
                }
                System.out.println("Guardamos estrategia con ID: " + e.getIdEstrategiaUnidad());
            }
        });
    }

    private void guardarEvaluaciones(int idUnidadGenerado, int numeroUnidad) {
        evaluaciones.forEach(e -> {
            if (e.getIdUnidad().getNumeroUnidad() == numeroUnidad) {
                if (e.getIdEvaluacion() == 0) {
                    int idEvaluacionGen = EVBD.guardar(e, idUnidadGenerado);
                    e.setIdEvaluacion(idEvaluacionGen);
                } else {
                    EVBD.editar(e);
                }
                System.out.println("Guardamos evaluaciones con ID: " + e.getIdEvaluacion());
            }
        });
    }

    /**
     * Detectamos el panel en el que estamos actualmente
     */
    private void detectarPanel() {
        FRM_GESTION.getTbpEvaluacion().addChangeListener(e -> {
            int selec = FRM_GESTION.getTbpEvaluacion().getSelectedIndex();
            switch (selec) {
                case 0:
                    actividadActual = "AD";
                    break;
                case 1:
                    actividadActual = "AC";
                    break;
                case 2:
                    actividadActual = "GP";
                    break;
                case 3:
                    actividadActual = "GA";
                    break;
                default:
                    actividadActual = "";
                    break;
            }
        });
    }

    /**
     * Para obtener la unidad seleccionada
     */
    private void actualizarUnidadSeleccionada() {
        if (unidades.size() > 0) {
            unidadSelec = unidades.get(
                    FRM_GESTION.getCmbUnidad().getSelectedIndex()
            );
        }
    }

    /**
     * Al seleccionar una unidad del combo realizamos todas las siguientes
     * acciones.
     */
    private void mostrarUnidad() {
        // Bandera para saber que estamos cambiando de unidad 
        cambioUnidad = true;
        if (unidades.size() > 0 && !eliminandoUnidad) {
            // Actualizamos la unidad seleccionada
            actualizarUnidadSeleccionada();

            // Actualizamos los txt del formulario 
            FRM_GESTION.getTxtTitulo().setText(
                    unidadSelec.getTituloUnidad()
            );
            FRM_GESTION.getTxrContenidos().setText(
                    unidadSelec.getContenidosUnidad()
            );
            FRM_GESTION.getTxrObjetivos().setText(
                    unidadSelec.getObjetivoEspecificoUnidad()
            );
            FRM_GESTION.getTxrResultados().setText(
                    unidadSelec.getResultadosAprendizajeUnidad()
            );

            // Actualizamos las fechas  
            if (unidadSelec.getFechaInicioUnidad() != null) {
                FRM_GESTION.getDchFechaInicio().setDate(
                        Date.from(unidadSelec.getFechaInicioUnidad()
                                .atStartOfDay(ZoneId.systemDefault())
                                .toInstant()
                        )
                );
            } else {
                FRM_GESTION.getDchFechaInicio().setDate(null);
            }

            if (unidadSelec.getFechaFinUnidad() != null) {
                FRM_GESTION.getDchFechaFin().setDate(
                        Date.from(unidadSelec.getFechaFinUnidad()
                                .atStartOfDay(ZoneId.systemDefault())
                                .toInstant()
                        )
                );
            } else {
                FRM_GESTION.getDchFechaFin().setDate(null);
            }

            // Actualizamos las horas de docencia  
            FRM_GESTION.getSpnHdocencia().setValue(
                    unidadSelec.getHorasDocenciaUnidad()
            );
            FRM_GESTION.getSpnHpracticas().setValue(
                    unidadSelec.getHorasPracticaUnidad()
            );
            FRM_GESTION.getSpnHautonomas().setValue(
                    unidadSelec.getHorasAutonomoUnidad()
            );

            // Actualizamos las estrategias 
            // Debemos revisar  lo de estrategias 
            // Actualizamos las evaluaciones 
            cargarEvaluaciones();
            // Cargamos todas las estrategias nuevamente  
            iniciarCmbEstrategias();
        }
        // Al terminar de cambiar de unidad 
        cambioUnidad = false;
    }

    /**
     * Cargamos las evaluaciones
     */
    private void cargarEvaluaciones() {
        // Seteamos el evaluacion seleccionada en nada cada vez que recargamos esta ventana 
        evaluacionSelec = null;
        mdTblAC.setRowCount(0);
        mdTblAD.setRowCount(0);
        mdTblES.setRowCount(0);
        mdTblGA.setRowCount(0);
        mdTblGP.setRowCount(0);
        // Actualizamos el valor total de la evaluaciones  
        totalGestion = 0;

        evaluaciones.forEach(e -> {
            // Sumamos la valoracion de nuestras evaluaciones
            totalGestion += e.getValoracion();

            if (e.getIdUnidad().getNumeroUnidad() == unidadSelec.getNumeroUnidad()) {
                Object[] row = {
                    e.getIdLocal(),
                    e.getIndicador(),
                    e.getInstrumento(),
                    e.getValoracion(),
                    e.getFechaEnvio(),
                    e.getFechaPresentacion(),
                    e.getIdEvaluacion()
                };

                switch (e.getIdTipoActividad().getIdTipoActividad()) {
                    // "Asistido por el Docente"
                    case 1:
                        mdTblAD.addRow(row);
                        break;
                    // "Aprendizaje Colaborativo"
                    case 2:
                        mdTblAC.addRow(row);
                        break;
                    // "Gestión de la Práctica"
                    case 3:
                        mdTblGP.addRow(row);
                        break;
                    // "Gestión de Trabajo Autónomo"
                    case 4:
                        mdTblGA.addRow(row);
                        break;
                    default:
                        break;
                }
            }

            // Mostramos solo las estrategias 
        });
        llenarTblEstrategiasUnidad();
        // Seteamos en el lbl  
        FRM_GESTION.getLblAcumuladoGestion().setText(totalGestion + "/60.0");
    }

    private void iniciarTblEstrategia() {
        FRM_GESTION.getTblEstrategias().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int s = FRM_GESTION.getTblEstrategias().getSelectedRow();
                if (s >= 0) {
                    String estrategia = FRM_GESTION.getTblEstrategias()
                            .getValueAt(s, 1).toString();
                    if (estrategia.length() > 0) {
                        if (estrategia.length() > 23) {
                            FRM_GESTION.getLblEstrategiaSelec().setText(
                                    estrategia.substring(0, 23) + "..."
                            );
                        } else {
                            FRM_GESTION.getLblEstrategiaSelec().setText(estrategia);
                        }

                        FRM_GESTION.getLblEstrategiaSelec().setToolTipText(
                                estrategia
                        );
                    }
                }
            }
        });
        FRM_GESTION.getLblQuitarEstrategia().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                eliminarEstrategias();
            }
        });
    }

    private void eliminarEstrategias() {
        int[] ss = FRM_GESTION.getTblEstrategias().getSelectedRows();
        if (ss.length > 0) {
            int r = JOptionPane.showConfirmDialog(
                    FRM_ACCIONES,
                    "¿Esta seguro de eliminar " + ss.length
                    + " estrategias de la unidad actual?"
            );
            if (r == JOptionPane.YES_OPTION) {
                for (int s : ss) {
                    System.out.println("Eliminamos estrategias : "
                            + FRM_GESTION.getTblEstrategias()
                                    .getValueAt(s, 0).toString()
                    );
                    eliminarEstrategia(
                            FRM_GESTION.getTblEstrategias()
                                    .getValueAt(s, 0).toString()
                    );
                }
                llenarTblEstrategiasUnidad();
            }
        }
    }

    private void eliminarEstrategia(String idLocal) {
        estrategias.removeIf(e -> {
            if (e.getIdLocal() == Integer.parseInt(idLocal)) {
                EUBD.eliminar(e.getIdEstrategiaUnidad());
            }
            return e.getIdLocal() == Integer.parseInt(idLocal);
        });
    }

    private void llenarTblEstrategiasUnidad() {
        mdTblES.setRowCount(0);
        estrategias.forEach(e -> {
            if (e.getUnidad().getNumeroUnidad() == unidadSelec.getNumeroUnidad()) {
                mdTblES.addRow(new Object[]{
                    e.getIdLocal(),
                    e.getEstrategia().getDescripcionEstrategia()
                });
            }
        });
    }

    private void llenarTblEstrategiasUnidad(EstrategiasUnidadMD estrategiaNueva) {
        mdTblES.setRowCount(0);
        existeEstrategia = false;
        estrategias.forEach(e -> {
            if (e.getUnidad().getNumeroUnidad() == unidadSelec.getNumeroUnidad()) {
                // Vemos que no se repita la estrategia 
                if (!e.getEstrategia()
                        .getDescripcionEstrategia()
                        .equals(estrategiaNueva
                                .getEstrategia()
                                .getDescripcionEstrategia()
                        )) {
                    mdTblES.addRow(new Object[]{
                        e.getIdLocal(),
                        e.getEstrategia().getDescripcionEstrategia()
                    });
                } else {
                    existeEstrategia = true;
                }
            }
        });
        if (!existeEstrategia) {
            estrategias.add(estrategiaNueva);
            mdTblES.addRow(new Object[]{
                estrategiaNueva.getIdLocal(),
                estrategiaNueva.getEstrategia().getDescripcionEstrategia()
            });
        } else {
            UFRMSCTR.errorEstrategia("Ya agrego esta estrategia en esta unidad.");
        }
    }

    private void agregarUnidad() {
        UnidadSilaboMD u = new UnidadSilaboMD();
        u.setNumeroUnidad(unidades.size() + 1);
        unidades.add(u);
        FRM_GESTION.getCmbUnidad().addItem("Unidad " + u.getNumeroUnidad());
        FRM_GESTION.getCmbUnidad().setSelectedIndex(unidades.size() - 1);
    }

    private void eliminarUnidad() {
        eliminandoUnidad = true;
        // Eliminamos de la base 
        boolean eliminado = true;
        if (unidadSelec.getID() > 0) {
            eliminado = USBD.eliminar(unidadSelec.getID());
        }

        if (eliminado) {
            // Eliminamos localmente 
            estrategias.removeIf(e -> {
                return e.getUnidad().getNumeroUnidad() == unidadSelec.getNumeroUnidad();
            });
            evaluaciones.removeIf(e -> {
                return e.getIdUnidad().getNumeroUnidad() == unidadSelec.getNumeroUnidad();
            });
            estrategias.forEach(e -> {
                if (e.getUnidad().getNumeroUnidad() > unidadSelec.getNumeroUnidad()) {
                    e.getUnidad().setNumeroUnidad(e.getUnidad().getNumeroUnidad() - 1);
                }
            });
            evaluaciones.forEach(e -> {
                if (e.getIdUnidad().getNumeroUnidad() > unidadSelec.getNumeroUnidad()) {
                    e.getIdUnidad().setNumeroUnidad(e.getIdUnidad().getNumeroUnidad() - 1);
                }
            });

            int numUnidad = unidadSelec.getNumeroUnidad();

            unidades.removeIf(u -> {
                return u.getNumeroUnidad() == unidadSelec.getNumeroUnidad();
            });

            unidades.forEach(u -> {
                if (u.getNumeroUnidad() > numUnidad) {
                    u.setNumeroUnidad(u.getNumeroUnidad() - 1);
                }
            });
            // Guardamos luego de eliminar  
            guardar();
            cargarCmbUnidad();
            mostrarUnidad();
            llenarTblEstrategiasUnidad();
        }
        eliminandoUnidad = false;
    }

    /**
     * Obtenemos el tipo de actividad que se esta guardando.
     *
     * @return
     */
    private int getIdTipoActividad() {
        int id;
        switch (actividadActual) {
            case "AD":
                id = 1;
                break;
            case "AC":
                id = 2;
                break;
            case "GP":
                id = 3;
                break;
            case "GA":
                id = 4;
                break;
            default:
                id = 0;
                break;
        }
        return id;
    }

    /**
     * Validamos las fechas que ingresamos
     */
    private void iniciarEventosFecha() {
        FRM_GESTION.getDchFechaInicio().addPropertyChangeListener(e -> {
            if (!cambioUnidad) {
                validarFechaInicio();
            }
        });
        FRM_GESTION.getDchFechaFin().addPropertyChangeListener(e -> {
            if (!cambioUnidad) {
                validarFechaFin();
            }
        });
    }

    private void validarFechaInicio() {

        LocalDate fecha = UFRMSCTR.getFechaJDC(FRM_GESTION.getDchFechaInicio());
        if (fecha != null) {
            if (unidadSelec.getFechaFinUnidad() == null) {
                unidadSelec.setFechaInicioUnidad(fecha);
            } else {
                boolean valido = true;
                String msg = "";
                // La fecha de inicio debe ser menor a la fecha fin  
                if (fecha.isBefore(silabo.getPeriodo().getFechaInicio())) {
                    msg = "La fecha de inicio debe ser mayor a la "
                            + "fecha de inicio del periodo. \n"
                            + "Fecha inicio: " + fecha
                            + "  Fecha periodo: "
                            + silabo.getPeriodo().getFechaInicio() + "\n";
                    valido = false;
                }
                // La fecha de inicio ser anterior a la fecha de fin de periodo.
                if (!fecha.isBefore(silabo.getPeriodo().getFechaFin())) {
                    msg += "La fecha de fin inicio ser anterior a la "
                            + "fecha de fin de periodo. \n";
                }
                // La fecha inicio debe ser anterior a la fecha fin de la unidad
                if (!fecha.isBefore(unidadSelec.getFechaFinUnidad())) {
                    msg += "La fecha de inicio de la unidad debe ser anterior a "
                            + "la fecha de fin de la unidad.\n";
                    valido = false;
                }

                if (!valido) {
                    UFRMSCTR.errorFecha("Debe indicar una fecha de inicio correcta.\n"
                            + msg);
                    FRM_GESTION.getDchFechaInicio().setDate(Date
                            .from(unidadSelec.getFechaFinUnidad()
                                    .atStartOfDay(ZoneId.systemDefault())
                                    .toInstant().minus(1, ChronoUnit.DAYS)
                            )
                    );
                } else {
                    unidadSelec.setFechaInicioUnidad(fecha);
                }
            }
        }
    }

    private void validarFechaFin() {
        LocalDate fecha = UFRMSCTR.getFechaJDC(FRM_GESTION.getDchFechaFin());
        if (fecha != null) {
            if (unidadSelec.getFechaInicioUnidad() == null) {
                unidadSelec.setFechaFinUnidad(fecha);
            } else {
                boolean valido = true;
                // Aqui agregaremos los mensajes de error  
                String msg = "";
                // La fecha de fin debe ser mayor a la fecha de inicio del periodo
                if (!fecha.isAfter(silabo.getPeriodo().getFechaInicio())) {
                    msg = "La fecha de fin debe ser mayor a la fecha de inicio del periodo.\n";
                    valido = false;
                }
                // La fecha de fin debe ser anterior a la fecha de fin de periodo.
                if (!fecha.isBefore(silabo.getPeriodo().getFechaFin())) {
                    msg += "La fecha de fin debe ser anterior a la fecha de fin de periodo. \\n";
                }
                // La fecha de fin de la unidad debe ser posterior a la fecha de inicio.
                if (!fecha.isAfter(unidadSelec.getFechaInicioUnidad())) {
                    msg += "La fecha de fin de la unidad debe ser posterior a la fecha de inicio.\n";
                    valido = false;
                }

                // La fecha de fin de la unidad debe ser anterior a la fecha de fin del periodo 
                if (silabo.getPeriodo().getFechaFinClases().isBefore(fecha)
                        && !silabo.getPeriodo().getFechaFinClases().equals(fecha)) {
                    msg += "La fecha de fin de la unidad no debe ser superior a la "
                            + "fecha de fin de clases.\n";
                    valido = false;
                }

                if (!valido) {
                    UFRMSCTR.errorFecha(
                            "Debe indicar una fecha de fin correcta. \n"
                            + msg
                    );
                    FRM_GESTION.getDchFechaFin().setDate(Date
                            .from(unidadSelec.getFechaInicioUnidad()
                                    .atStartOfDay(ZoneId.systemDefault())
                                    .toInstant().plus(1, ChronoUnit.DAYS)
                            )
                    );
                } else {
                    unidadSelec.setFechaFinUnidad(fecha);
                }
            }
        }
    }

    // ***
    // De aqui para abajo comienza todo lo que es spiners de hora 
    // **
    /**
     * Este evento se usa para todos los SPN de horas al momento de actualizar
     * la hora se actualiza en su modelo y en el lbl que nos muestra las horas
     * totales
     */
    private void iniciarEventoSPNHoras() {
        // Al actualizar horas autonomas 
        FRM_GESTION.getSpnHautonomas().addChangeListener(e -> validarHA());
        // Al actualizar horas docencia  
        FRM_GESTION.getSpnHdocencia().addChangeListener(e -> validarHD());
        // Al actualizar horas practicas  
        FRM_GESTION.getSpnHpracticas().addChangeListener(e -> validarHP());
    }

    private void validarHA() {
        double h = UFRMSCTR.getHoraSPN(FRM_GESTION.getSpnHautonomas());
        if (h >= 0 && h != unidadSelec.getHorasAutonomoUnidad()) {
            double nh = h + numHA - unidadSelec.getHorasAutonomoUnidad();
            if (nh <= silabo.getMateria().getHorasAutoEstudio()) {
                numHA = nh;
                unidadSelec.setHorasAutonomoUnidad(h);
                reescribirHoras();
            } else {
                FRM_GESTION.getSpnHautonomas().setValue(unidadSelec.getHorasAutonomoUnidad());
                UFRMSCTR.errorHoras("Las horas autonomas superan la hora total indicada en materia.");
            }
        }
    }

    private void validarHD() {
        double h = UFRMSCTR.getHoraSPN(FRM_GESTION.getSpnHdocencia());
        if (h >= 0 && h != unidadSelec.getHorasDocenciaUnidad()) {
            double nh = h + numHD - unidadSelec.getHorasDocenciaUnidad();
            if (nh <= silabo.getMateria().getHorasDocencia()) {
                numHD = nh;
                unidadSelec.setHorasDocenciaUnidad(h);
                reescribirHoras();
            } else {
                FRM_GESTION.getSpnHdocencia().setValue(unidadSelec.getHorasDocenciaUnidad());
                UFRMSCTR.errorHoras("Las horas de docencia superan la hora total indicada en materia.");
            }
        }
    }

    private void validarHP() {
        double h = UFRMSCTR.getHoraSPN(FRM_GESTION.getSpnHpracticas());
        if (h >= 0 && h != unidadSelec.getHorasPracticaUnidad()) {
            double nh = h + numHP - unidadSelec.getHorasPracticaUnidad();
            if (nh <= silabo.getMateria().getHorasPracticas()) {
                numHP = nh;
                unidadSelec.setHorasPracticaUnidad(h);
                reescribirHoras();
            } else {
                FRM_GESTION.getSpnHpracticas().setValue(unidadSelec.getHorasPracticaUnidad());
                UFRMSCTR.errorHoras("Las horas practicas superan la hora total indicada en materia.");
            }
        }
    }

    /**
     * Actualizamos las horas de materia que se muestra en el formulario
     * consultando de todas las unidades que tenemos
     */
    private void actualizarHoras() {
        unidades.forEach(u -> {
            numHD += u.getHorasDocenciaUnidad();
            numHA += u.getHorasAutonomoUnidad();
            numHP += u.getHorasPracticaUnidad();
        });
        reescribirHoras();
    }

    /**
     * Reescribimos los lbls con el numero de horas que tenemos en total
     */
    private void reescribirHoras() {
        // Numero de horas de la materia 
        FRM_GESTION.getLblTotalHdocencia().setText(numHD + "/" + silabo.getMateria().getHorasDocencia());
        FRM_GESTION.getLblTotalHmateria().setText(numHA + "/" + silabo.getMateria().getHorasAutoEstudio());
        FRM_GESTION.getLblTotalHpracticas().setText(numHP + "/" + silabo.getMateria().getHorasPracticas());
    }

    // ***
    // Termina spinners de horas //
    // **
}
