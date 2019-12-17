package controlador.silabo.planesDeClase;

import com.placeholder.PlaceHolder;
import java.awt.event.ActionEvent;
import vista.silabos.planesDeClase.frmPlanClase;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import modelo.EstrategiasMetodologicas.EstrategiasMetodologicasBD;
import modelo.EstrategiasMetodologicas.EstrategiasMetodologicasMD;
import modelo.PlanClases.PlandeClasesBD;
import modelo.PlanClases.PlandeClasesMD;
import modelo.PlanClases.RecursosBD;
import modelo.PlanClases.RecursosMD;
import modelo.PlanClases.RecursosPlanClasesBD;
import modelo.PlanClases.RecursosPlanClasesMD;
import modelo.curso.CursoMD;
import modelo.estrategiasUnidad.EstrategiasUnidadBD;
import modelo.estrategiasUnidad.EstrategiasUnidadMD;
import modelo.evaluacionSilabo.EvaluacionSilaboMD;
import modelo.silabo.CursoMDS;
import modelo.silabo.CursosBDS;
import modelo.silabo.SilaboMD;
import modelo.unidadSilabo.UnidadSilaboBD;
import modelo.unidadSilabo.UnidadSilaboMD;
import modelo.usuario.UsuarioBD;
import vista.principal.VtnPrincipal;
import vista.silabos.planesDeClase.frmPlanClase.CheckListItem;
import vista.silabos.planesDeClase.frmPlanClase.CheckListRenderer;

public class Controlador_plan_clases {

    private PlandeClasesBD plan_clase;
    private final UsuarioBD usuario;
    private PlandeClasesMD plan_claseMD;
    private final VtnPrincipal vtnPrincipal;
    private frmPlanClase fPlanClase;
    private SilaboMD silabo;
    private CursoMD curso;
    private RecursosPlanClasesMD recursos_planMD;
    private EstrategiasMetodologicasMD estrate_metoMD;
    private List<EvaluacionSilaboMD> lista_evualacion_unidad;
    private List<EstrategiasMetodologicasMD> lista_estrategias_metodologicas_antici;
    private List<RecursosPlanClasesMD> lista_recursoMD;
    private List<RecursosPlanClasesMD> lista_recursoMD1;
    private UnidadSilaboMD unidadsilabo;
    private List<CursoMDS> lista_curso;
    private List<UnidadSilaboMD> lista_unidadsilabo;
    private List<EstrategiasUnidadMD> lista_estrategiasSilabo;
    private List<EvaluacionSilaboMD> lista_evaluacionesSilabo;
    private DefaultListModel modelo;

    ArrayList array_Anticipacion = new ArrayList();
    ArrayList array_Construccion = new ArrayList();
    ArrayList array_Consolidacion = new ArrayList();
    DefaultListModel modelo_anticipacion;
    DefaultListModel modelo_Construccion;
    DefaultListModel modelo_Consolidacion;

    public Controlador_plan_clases(SilaboMD silabo, CursoMD curso, UnidadSilaboMD unidadsilabo,
            UsuarioBD usuario, VtnPrincipal vtnPrincipal) {
        this.silabo = silabo;
        this.curso = curso;
        this.unidadsilabo = unidadsilabo;
        this.usuario = usuario;
        this.vtnPrincipal = vtnPrincipal;
    }

    public void iniciaControlador() {
        System.out.println("-------------------------->>>>>>>>>>>>>>>IDDD_SILABO" + silabo.getID() + " -------------- ID_UNIDAD" + unidadsilabo.getIdUnidad());
        fPlanClase = new frmPlanClase();
        vtnPrincipal.getDpnlPrincipal().add(fPlanClase);
        fPlanClase.setTitle(silabo.getMateria().getNombre());
        fPlanClase.show();
        fPlanClase.setLocation((vtnPrincipal.getDpnlPrincipal().getSize().width - fPlanClase.getSize().width) / 2,
                (vtnPrincipal.getDpnlPrincipal().getSize().height - fPlanClase.getSize().height) / 2);
        fPlanClase.getBtnCancelarPC().addActionListener(a1 -> {
            fPlanClase.dispose();
            ControladorConfiguracion_plan_clases cp = new ControladorConfiguracion_plan_clases(usuario, vtnPrincipal);
            cp.iniciarControlaador();

        });
        PlaceHolder holder = new PlaceHolder(fPlanClase.getTxt_estrategias(), "Escriba su descripción.......");
        IniciaPlanClase(silabo, curso, unidadsilabo);

        fPlanClase.getBtnAgregarPC().addActionListener(ba -> {
            int limite = 120;
            if (fPlanClase.getTxt_estrategias().getText().length() >= limite) {
                JOptionPane.showMessageDialog(null, "EL TEXTO EXCEDE EL NÚMERO MÁXIMO DE CARACTERES", "Aviso", JOptionPane.ERROR_MESSAGE);
            } else {
                agregarEstrategiasMetologicas();
            }
        });
        fPlanClase.getBtnQuitarPC().addActionListener(qp -> {
            eliminarEstrategiasMto();
        });
        fPlanClase.getBtnEditar().addActionListener(be -> {
            editarEstrategiasMTO();
        });
        fPlanClase.getJlisRecursos().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent event) {
                lista_recursoMD1 = new ArrayList();
                int index = fPlanClase.getJlisRecursos().locationToIndex(event.getPoint());
                CheckListItem item = (CheckListItem) fPlanClase.getJlisRecursos().getModel().getElementAt(index);
                item.setSelected(!item.isSelected());
                fPlanClase.getJlisRecursos().repaint(fPlanClase.getJlisRecursos().getCellBounds(index, index));
                lista_recursoMD = RecursosPlanClasesBD.consultarRecursos();

                for (int i = 0; i < fPlanClase.getJlisRecursos().getModel().getSize(); i++) {
                    CheckListItem item2 = (CheckListItem) fPlanClase.getJlisRecursos().getModel().getElementAt(i);
                    if (item2.isSelected()) {
                        String recurso = fPlanClase.getJlisRecursos().getModel().getElementAt(i).toString();
                        Optional<RecursosMD> recursoSeleccionado = RecursosBD.consultarRecursos().stream().
                                filter(r -> r.getNombre_recursos().equals(recurso)).findFirst();

                        lista_recursoMD1.add(new RecursosPlanClasesMD(recursoSeleccionado.get()));

                        System.out.println(recursoSeleccionado.get().getNombre_recursos() + "-<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
                    }
                }

            }
        });

        fPlanClase.getTxt_estrategias().addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                int limite = 120;
                if (fPlanClase.getTxt_estrategias().getText().length() == limite) {
                    e.consume();
                    JOptionPane.showMessageDialog(null, "NO PUEDE INGRESAR MAS CARACTERES", "Aviso", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

//
        fPlanClase.getBtmnGuardarPc().addActionListener(e -> ejecutar(e));

        lista_estrategias_metodologicas_antici = new ArrayList<>();

    }

    private void IniciaPlanClase(SilaboMD silabo, CursoMD curso, UnidadSilaboMD unidadsilabo) {
        lista_curso = CursosBDS.ConsultarCursoCarreraDocente(curso.getId());
        cargarCamposCursoCarreraDocente(lista_curso);

        lista_unidadsilabo = UnidadSilaboBD.consultarSilaboUnidades(silabo.getID(), unidadsilabo.getNumeroUnidad());
        cargarCamposUnidades(lista_unidadsilabo);

        lista_estrategiasSilabo = EstrategiasUnidadBD.cargarEstrategiasPlanClae(silabo.getID(), unidadsilabo.getNumeroUnidad());
        CargarEvaluacionesInstrumento(lista_estrategiasSilabo);

        lista_recursoMD = RecursosPlanClasesBD.consultarRecursos();
        CargarRecursos(lista_recursoMD);

    }

    public void cargarCamposCursoCarreraDocente(List<CursoMDS> lista) {
        for (CursoMDS cursoMDS : lista) {
            fPlanClase.getTxtCarrera().setText(cursoMDS.getId_carrera().getNombre());
            fPlanClase.getTxtCarrera().setEnabled(false);
            fPlanClase.getTxtDocente().setText(cursoMDS.getId_persona().getPrimerNombre() + " " + cursoMDS.getId_persona().getPrimerApellido());
            fPlanClase.getTxtDocente().setEnabled(false);
            fPlanClase.getTxtAsignatura().setText(cursoMDS.getId_materia().getNombre());
            fPlanClase.getTxtAsignatura().setEnabled(false);
            fPlanClase.getTxtCod_Asignatura().setText(cursoMDS.getId_materia().getCodigo());
            fPlanClase.getTxtCod_Asignatura().setEnabled(false);
            fPlanClase.getTxtCicloParalelo().setText(cursoMDS.getCurso_nombre());
            fPlanClase.getTxtCicloParalelo().setEnabled(false);
        }
    }

    public void cargarCamposUnidades(List<UnidadSilaboMD> lista_unidades) {
        for (UnidadSilaboMD lista_unidad : lista_unidades) {
            fPlanClase.getTxrObjetivoPC().setText(lista_unidad.getObjetivoEspecificoUnidad());
            fPlanClase.getTxrObjetivoPC().setEnabled(false);

            fPlanClase.getTxrContenidosPC().setText(lista_unidad.getContenidosUnidad());
            fPlanClase.getTxrContenidosPC().setEnabled(false);

            fPlanClase.getTxtTituloUnidad().setText(lista_unidad.getTituloUnidad());
            fPlanClase.getTxtTituloUnidad().setEnabled(false);

            fPlanClase.getTxtDuracion().setText(String.valueOf(lista_unidad.getHorasDocenciaUnidad() + lista_unidad.getHorasPracticaUnidad() + " horas"));
            fPlanClase.getTxtDuracion().setEnabled(false);

            fPlanClase.getjDateChooserFechaInicioPC().setDate(Date.from(lista_unidad.getFechaInicioUnidad().atStartOfDay(ZoneId.systemDefault()).toInstant()));
            fPlanClase.getjDateChooserFechaInicioPC().setEnabled(false);

            fPlanClase.getjDateChooserFechaFinPC().setDate(Date.from(lista_unidad.getFechaFinUnidad().atStartOfDay(ZoneId.systemDefault()).toInstant()));
            fPlanClase.getjDateChooserFechaFinPC().setEnabled(false);

            fPlanClase.getTxrResultadosAprendizaje().setText(lista_unidad.getResultadosAprendizajeUnidad());
            fPlanClase.getTxrResultadosAprendizaje().setEnabled(false);

            fPlanClase.getTxtUnidad().setText(String.valueOf(lista_unidad.getNumeroUnidad()));
            fPlanClase.getTxtUnidad().setEnabled(false);

            fPlanClase.getLbNumeroPlandeClase().setText("Unidad N°" + lista_unidad.getNumeroUnidad());

        }
    }

    private void CargarEvaluacionesInstrumento(List<EstrategiasUnidadMD> lista) {
        fPlanClase.getJlistInstrumentoEvaluacion().removeAll();
        modelo = new DefaultListModel();
        for (EstrategiasUnidadMD eu : lista) {
            modelo.addElement(eu.getEstrategia().getDescripcionEstrategia());
        }
        fPlanClase.getJlistInstrumentoEvaluacion().setModel(modelo);
    }

    private void CargarRecursos(List<RecursosPlanClasesMD> lista_recursoMD) {
        fPlanClase.getJlisRecursos().removeAll();
        DefaultListModel modeloRecursos = new DefaultListModel();
        fPlanClase.getJlisRecursos().setCellRenderer(new CheckListRenderer());
        fPlanClase.getJlisRecursos().setModel(modeloRecursos);
        for (RecursosPlanClasesMD lista_recurso_md : lista_recursoMD) {
            modeloRecursos.addElement(new CheckListItem(lista_recurso_md.getId_recursos().getNombre_recursos()));
        }
        fPlanClase.getJlisRecursos().setModel(modeloRecursos);

    }

    public boolean guardar_plan_de_clase() {
        try {
            plan_claseMD = new PlandeClasesMD(curso, unidadsilabo);
            plan_claseMD.getId_curso().setId(curso.getId());
            plan_claseMD.getId_unidad().setIdUnidad(unidadsilabo.getIdUnidad());
            plan_claseMD.setObservaciones(fPlanClase.getTxrObservacionesPc().getText());
            plan_claseMD.setTrabajo_autonomo(fPlanClase.getTxrTrabajoAutonomo().getText());
            if (new PlandeClasesBD().insertarPlanClases(plan_claseMD) == true) {
                insertarRecursosPlanClases();
                insertarEstrategiasMetodologicas();
                return true;
            }
        } catch (Exception e) {
            System.out.println("Fallo al guardar");
        }
        return false;
    }

    private void insertarRecursosPlanClases() {
        plan_claseMD = PlandeClasesBD.consultarUltimoPlanClase(curso.getId(), unidadsilabo.getIdUnidad());
        plan_claseMD.setId_plan_clases(plan_claseMD.getID());
        for (RecursosPlanClasesMD recursoPlam : lista_recursoMD1) {
            recursoPlam.getId_plan_clases().setId_plan_clases(plan_claseMD.getID());
            RecursosPlanClasesBD rcp = new RecursosPlanClasesBD();
            rcp.insertarRecursosPlanClases2(recursoPlam, recursoPlam.getId_plan_clases().getID());
        }

    }

    private void agregarEstrategiasMetologicas() {

        modelo_anticipacion = new DefaultListModel();
        modelo_Construccion = new DefaultListModel();
        modelo_Consolidacion = new DefaultListModel();
        if (fPlanClase.getListConsolidacionPC().isShowing()) {
            if (fPlanClase.getTxt_estrategias().getText().equals("")
                    || fPlanClase.getTxt_estrategias().getText().equals("Escriba su estrategia.......")) {
                JOptionPane.showMessageDialog(fPlanClase, "Ingrese una estrategia", "ERROR", JOptionPane.ERROR_MESSAGE);
            } else {
                if (array_Anticipacion.contains(fPlanClase.getTxt_estrategias().getText())
                        || array_Construccion.contains(fPlanClase.getTxt_estrategias().getText())
                        || array_Consolidacion.contains(fPlanClase.getTxt_estrategias().getText())) {
                    JOptionPane.showMessageDialog(fPlanClase, "Estrategia ya añadida", "ERROR", JOptionPane.ERROR_MESSAGE);
                } else {
                    array_Consolidacion.add(fPlanClase.getTxt_estrategias().getText());
                    for (int i = 0; i < array_Consolidacion.size(); i++) {
                        modelo_Consolidacion.addElement(array_Consolidacion.get(i));
                    }
                    fPlanClase.getListConsolidacionPC().setModel(modelo_Consolidacion);
                    fPlanClase.getTxt_estrategias().setText("");
                }
            }

        } else if (fPlanClase.getListAnticipacionPC().isShowing()) {
            if (fPlanClase.getTxt_estrategias().getText().equals("")
                    || fPlanClase.getTxt_estrategias().getText().equals("Escriba su estrategia.......")) {
                JOptionPane.showMessageDialog(fPlanClase, "Ingrese una estrategia", "ERROR", JOptionPane.ERROR_MESSAGE);
            } else {
                if (array_Anticipacion.contains(fPlanClase.getTxt_estrategias().getText())
                        || array_Construccion.contains(fPlanClase.getTxt_estrategias().getText())
                        || array_Consolidacion.contains(fPlanClase.getTxt_estrategias().getText())) {
                    JOptionPane.showMessageDialog(fPlanClase, "Estrategia ya añadida", "ERROR", JOptionPane.ERROR_MESSAGE);
                } else {
                    array_Anticipacion.add(fPlanClase.getTxt_estrategias().getText());
                    for (int i = 0; i < array_Anticipacion.size(); i++) {
                        modelo_anticipacion.addElement(array_Anticipacion.get(i));
                    }
                    fPlanClase.getListAnticipacionPC().setModel(modelo_anticipacion);
                    fPlanClase.getTxt_estrategias().setText("");
                }
            }
        } else if (fPlanClase.getListConstruccionPC().isShowing()) {
            if (fPlanClase.getTxt_estrategias().getText().equals("")
                    || fPlanClase.getTxt_estrategias().getText().equals("Escriba su estrategia.......")) {
                JOptionPane.showMessageDialog(fPlanClase, "Ingrese una estrategia", "ERROR", JOptionPane.ERROR_MESSAGE);
            } else {
                if (array_Anticipacion.contains(fPlanClase.getTxt_estrategias().getText())
                        || array_Construccion.contains(fPlanClase.getTxt_estrategias().getText())
                        || array_Consolidacion.contains(fPlanClase.getTxt_estrategias().getText())) {
                    JOptionPane.showMessageDialog(fPlanClase, "Estrategia ya añadida", "ERROR", JOptionPane.ERROR_MESSAGE);
                } else {
                    array_Construccion.add(fPlanClase.getTxt_estrategias().getText());
                    for (int i = 0; i < array_Construccion.size(); i++) {
                        modelo_Construccion.addElement(array_Construccion.get(i));
                    }
                    fPlanClase.getListConstruccionPC().setModel(modelo_Construccion);
                    fPlanClase.getTxt_estrategias().setText("");
                }
            }
        }
    }

    private void eliminarEstrategiasMto() {
        try {
            String indice;
            String indice2;
            String indice3;

            if (fPlanClase.getListAnticipacionPC().isShowing()) {
                if (fPlanClase.getListAnticipacionPC().getSelectedIndex() == -1) {
                    JOptionPane.showMessageDialog(fPlanClase, "Seleccione el elemneto a quitar", "ERROR", JOptionPane.ERROR_MESSAGE);
                } else {
                    indice = fPlanClase.getListAnticipacionPC().getSelectedValue();
                    modelo_anticipacion.removeElement(indice);
                    array_Anticipacion.remove(indice);
                    fPlanClase.getListAnticipacionPC().setModel(modelo_anticipacion);

                    recargarElemwentos();
                }
            } else if (fPlanClase.getListConstruccionPC().isShowing()) {
                if (fPlanClase.getListConstruccionPC().getSelectedIndex() == -1) {
                    JOptionPane.showMessageDialog(fPlanClase, "Seleccione el elemneto a quitar", "ERROR", JOptionPane.ERROR_MESSAGE);
                } else {
                    indice2 = fPlanClase.getListConstruccionPC().getSelectedValue();
                    modelo_Construccion.removeElement(indice2);
                    array_Construccion.remove(indice2);
                    fPlanClase.getListConstruccionPC().setModel(modelo_Construccion);
                    recargarElemwentos2();
                }
            } else if (fPlanClase.getListConsolidacionPC().isShowing()) {
                if (fPlanClase.getListConsolidacionPC().getSelectedIndex() == -1) {
                    JOptionPane.showMessageDialog(fPlanClase, "Seleccione el elemneto a quitar", "ERROR", JOptionPane.ERROR_MESSAGE);
                } else {
                    indice3 = fPlanClase.getListConsolidacionPC().getSelectedValue();
                    modelo_Consolidacion.removeElement(indice3);
                    array_Consolidacion.remove(indice3);
                    fPlanClase.getListConsolidacionPC().setModel(modelo_Consolidacion);

                    recargarElemwentos3();
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(fPlanClase, "No se puede realizar esta acción!!", "ERROR", JOptionPane.ERROR_MESSAGE);
        }

    }

    public void editarEstrategiasMTO() {
        String inx;
        if (fPlanClase.getListAnticipacionPC().isShowing()) {
            if (fPlanClase.getListAnticipacionPC().getSelectedIndex() == -1) {
                JOptionPane.showMessageDialog(fPlanClase, "Seleccione el elemneto a editar", "ERROR", JOptionPane.ERROR_MESSAGE);
            } else {
                inx = fPlanClase.getListAnticipacionPC().getSelectedValue();
                fPlanClase.getTxt_estrategias().setText(inx);
                modelo_anticipacion.removeElement(inx);
                for (int i = 0; i < array_Anticipacion.size(); i++) {
                    if (array_Anticipacion.get(i).toString().equals(inx)) {
                        array_Anticipacion.remove(i);
                    }
                }
                fPlanClase.getListAnticipacionPC().setModel(modelo_anticipacion);
                recargarElemwentos();
            }
        } else if (fPlanClase.getListConsolidacionPC().isShowing()) {
            if (fPlanClase.getListConsolidacionPC().getSelectedIndex() == -1) {
                JOptionPane.showMessageDialog(fPlanClase, "Seleccione el elemneto a editar", "ERROR", JOptionPane.ERROR_MESSAGE);
            } else {
                inx = fPlanClase.getListConsolidacionPC().getSelectedValue();
                fPlanClase.getTxt_estrategias().setText(inx);
                modelo_Consolidacion.removeElement(inx);
                for (int i = 0; i < array_Consolidacion.size(); i++) {
                    if (array_Consolidacion.get(i).toString().equals(inx)) {
                        array_Consolidacion.remove(i);
                    }
                }
                fPlanClase.getListConsolidacionPC().setModel(modelo_Consolidacion);
                recargarElemwentos3();
            }
        } else if (fPlanClase.getListConstruccionPC().isShowing()) {
            if (fPlanClase.getListConstruccionPC().getSelectedIndex() == -1) {
                JOptionPane.showMessageDialog(fPlanClase, "Seleccione el elemneto a editar", "ERROR", JOptionPane.ERROR_MESSAGE);
            } else {
                inx = fPlanClase.getListConstruccionPC().getSelectedValue();
                fPlanClase.getTxt_estrategias().setText(inx);
                modelo_Construccion.removeElement(inx);
                for (int i = 0; i < array_Construccion.size(); i++) {
                    if (array_Construccion.get(i).toString().equals(inx)) {
                        array_Construccion.remove(i);
                    }
                }
                fPlanClase.getListConstruccionPC().setModel(modelo_Construccion);
                recargarElemwentos2();
            }
        }
    }

    public void recargarElemwentos() {
        modelo_anticipacion.removeAllElements();
        for (int i = 0; i < array_Anticipacion.size(); i++) {
            modelo_anticipacion.addElement(array_Anticipacion.get(i));

        }
    }

    public void recargarElemwentos2() {
        modelo_Construccion.removeAllElements();
        for (int i = 0; i < array_Construccion.size(); i++) {
            modelo_Construccion.addElement(array_Construccion.get(i));
        }
    }

    public void recargarElemwentos3() {
        modelo_Consolidacion.removeAllElements();
        for (int i = 0; i < array_Consolidacion.size(); i++) {
            modelo_Consolidacion.addElement(array_Consolidacion.get(i));
        }
    }

    private boolean validarCampos() {
        boolean valid = true;
        if (fPlanClase.getTxrTrabajoAutonomo().getText().length() == 0) {

            valid = false;
        }
        if (lista_recursoMD1 == null) {
            valid = false;
        }
        if (fPlanClase.getListAnticipacionPC().getModel().getSize() <= 0 && fPlanClase.getListConstruccionPC().getModel().getSize() <= 0
                && fPlanClase.getListConsolidacionPC().getModel()
                        .getSize() <= 0) {
            valid = false;
        }

        return valid;

    }

    private void insertarEstrategiasMetodologicas() {

        for (int j = 0; j < fPlanClase.getListAnticipacionPC().getModel().getSize(); j++) {
            if (fPlanClase.getListAnticipacionPC().getModel().getSize() > 0) {
                String nombre = fPlanClase.getListAnticipacionPC().getModel().getElementAt(j).toString();
                lista_estrategias_metodologicas_antici.add(new EstrategiasMetodologicasMD("Anticipacion", nombre));
//         

                System.out.println(lista_estrategias_metodologicas_antici.size() + "---------------><<<<<<<TAMAÑO ARRAY LIST-------------------ANTICIPACION");
            }
        }
        for (int j = 0; j < fPlanClase.getListConstruccionPC().getModel().getSize(); j++) {
            if (fPlanClase.getListConstruccionPC().getModel().getSize() > 0) {
                String nombre = fPlanClase.getListConstruccionPC().getModel().getElementAt(j).toString();
                lista_estrategias_metodologicas_antici.add(new EstrategiasMetodologicasMD("Construccion", nombre));
//                           

                System.out.println(lista_estrategias_metodologicas_antici.size() + "---------------><<<<<<<TAMAÑO ARRAY --------CONSTRUCCIOM");
            }

        }
        for (int j = 0; j < fPlanClase.getListConsolidacionPC().getModel().getSize(); j++) {
            if (fPlanClase.getListConsolidacionPC().getModel().getSize() > 0) {
                String nombre = fPlanClase.getListConsolidacionPC().getModel().getElementAt(j).toString();
                lista_estrategias_metodologicas_antici.add(new EstrategiasMetodologicasMD("Consolidacion", nombre));
//                            

                System.out.println(lista_estrategias_metodologicas_antici.size() + "---------------><<<<<<<TAMAÑO ARRAY---------CONSOLIDACION");
            }
        }

        plan_claseMD = PlandeClasesBD.consultarUltimoPlanClase(curso.getId(), unidadsilabo.getIdUnidad());
        plan_claseMD.setId_plan_clases(plan_claseMD.getID());
        for (EstrategiasMetodologicasMD em : lista_estrategias_metodologicas_antici) {
            em.getId_plan_clases().setId_plan_clases(plan_claseMD.getID());
            EstrategiasMetodologicasBD embd = new EstrategiasMetodologicasBD();
            embd.insertarEstrategiasMetodologicas2(em, em.getId_plan_clases().getID());
        }

    }

    private boolean accion = true;

    private void ejecutar(ActionEvent e) {

        if (accion) {
            new Thread(() -> {
                accion = false;
                if (validarCampos() == true) {
                    boolean aux = false;
                    fPlanClase.getBtmnGuardarPc().setEnabled(false);
                    fPlanClase.getBtnCancelarPC().setEnabled(false);
                    vtnPrincipal.getLblEstado().setText("                                  Guardando su plan de clase! Espere por favor...........");

                    try {
                        Thread.sleep(400);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Controlador_plan_clases.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    aux = guardar_plan_de_clase();

                    if (aux == true) {
                        JOptionPane.showMessageDialog(fPlanClase, "Se guardó correctamente!");
                        fPlanClase.dispose();
                        vtnPrincipal.getMnCtPlandeClase().doClick();
                    } else {
                        JOptionPane.showMessageDialog(null, "Falló al guardar! Intente de nuevo! ", "Aviso", JOptionPane.ERROR_MESSAGE);
                        fPlanClase.getBtmnGuardarPc().setEnabled(true);
                        fPlanClase.getBtnCancelarPC().setEnabled(true);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "REVISE INFORMACION INCOMPLETA", "Aviso", JOptionPane.ERROR_MESSAGE);
                }

                vtnPrincipal.getLblEstado().setText("");
                accion = true;

            }).start();
        }

    }
}
