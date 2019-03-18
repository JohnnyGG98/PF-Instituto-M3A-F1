package vista.principal;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;

/**
 *
 * @author Johnny
 */
public class VtnPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form VtnPrincipal
     */
    public VtnPrincipal() {
        initComponents();
    }

    public JButton getBtnCarrera() {
        return btnCarrera;
    }

    public JButton getBtnCurso() {
        return btnCurso;
    }

    public JButton getBtnDocente() {
        return btnDocente;
    }

    public JButton getBtnAlumno() {
        return btnAlumno;
    }

    public JButton getBtnMateria() {
        return btnMateria;
    }

    public JButton getBtnPrdLectivo() {
        return btnPrdLectivo;
    }

    public ButtonGroup getBtngEstilo() {
        return btngEstilo;
    }

    public JDesktopPane getDpnlPrincipal() {
        return dpnlPrincipal;
    }

    public JMenuBar getMenuCrud() {
        return menuCrud;
    }

    public JMenu getMnConsultar() {
        return mnTipoNotas;
    }

    public JMenuItem getMnCtAlumno() {
        return mnCtAlumno;
    }

    public JMenuItem getMnCtCarrera() {
        return mnCtCarrera;
    }

    public JMenuItem getMnCtCurso() {
        return mnCtCurso;
    }

    public JMenuItem getMnCtDocente() {
        return mnCtDocente;
    }

    public JMenuItem getMnCtMateria() {
        return mnCtMateria;
    }

    public JMenuItem getMnCtPrdLectivo() {
        return mnCtPrdLectivo;
    }

    public JMenu getMnEstilo() {
        return mnEstilo;
    }

    public JMenuItem getMnIgAlumno() {
        return mnIgAlumno;
    }

    public JMenuItem getMnIgCarrera() {
        return mnIgCarrera;
    }

    public JMenuItem getMnIgCurso() {
        return mnIgCurso;
    }

    public JMenuItem getMnIgDocente() {
        return mnIgDocente;
    }

    public JMenuItem getMnIgPrdLectivo() {
        return mnIgPrdLectivo;
    }

    public JMenu getMnOpciones() {
        return mnOpciones;
    }

    public JRadioButtonMenuItem getMnRbtnMetal() {
        return mnRbtnMetal;
    }

    public JRadioButtonMenuItem getMnRbtnNimbus() {
        return mnRbtnNimbus;
    }

    public JRadioButtonMenuItem getMnRbtnWindows() {
        return mnRbtnWindows;
    }

    public JPanel getPnlMenu() {
        return pnlMenu;
    }

    public JButton getBtnPersona() {
        return btnPersona;
    }

    public JMenuItem getMnCtPersona() {
        return mnCtPersona;
    }

    public JMenuItem getMnIgPersona() {
        return mnIgPersona;
    }

    public JButton getBtnInscripcion() {
        return btnInscripcion;
    }

    public JMenuItem getMnCtInscripcion() {
        return mnCtInscripcion;
    }

    public JMenuItem getMnIgInscripcion() {
        return mnIgInscripcion;
    }

    public JMenu getMnIngresar() {
        return mnIngresar;
    }

    public JMenuItem getMnCtMallaAlumno() {
        return mnCtMallaAlumno;
    }

    public JButton getBtnMatricula() {
        return btnMatricula;
    }

    public JMenuItem getMnCtMatricula() {
        return mnCtMatricula;
    }

    public JMenuItem getMnIgMatricula() {
        return mnIgMatricula;
    }

    public JButton getBtnCerrarSesion() {
        return btnCerrarSesion;
    }

    public JMenuItem getMnCtRoles() {
        return mnCtRoles;
    }

    public JMenuItem getMnCtUsuarios() {
        return mnCtUsuarios;
    }

    public JMenuItem getMnCtNotas() {
        return mnCtNotas;
    }

    public void setMnCtNotas(JMenuItem mnCtNotas) {
        this.mnCtNotas = mnCtNotas;
    }

    public JMenuItem getMnCtTipoNotas() {
        return mnCtTipoNotas;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btngEstilo = new javax.swing.ButtonGroup();
        pnlMenu = new javax.swing.JPanel();
        btnDocente = new javax.swing.JButton();
        btnAlumno = new javax.swing.JButton();
        btnCarrera = new javax.swing.JButton();
        btnCurso = new javax.swing.JButton();
        btnPrdLectivo = new javax.swing.JButton();
        btnMateria = new javax.swing.JButton();
        btnPersona = new javax.swing.JButton();
        btnInscripcion = new javax.swing.JButton();
        btnMatricula = new javax.swing.JButton();
        btnCerrarSesion = new javax.swing.JButton();
        dpnlPrincipal = new javax.swing.JDesktopPane();
        menuCrud = new javax.swing.JMenuBar();
        mnTipoNotas = new javax.swing.JMenu();
        mnCtPersona = new javax.swing.JMenuItem();
        mnCtDocente = new javax.swing.JMenuItem();
        mnCtAlumno = new javax.swing.JMenuItem();
        mnCtCarrera = new javax.swing.JMenuItem();
        mnCtCurso = new javax.swing.JMenuItem();
        mnCtPrdLectivo = new javax.swing.JMenuItem();
        mnCtMateria = new javax.swing.JMenuItem();
        mnCtInscripcion = new javax.swing.JMenuItem();
        mnCtMatricula = new javax.swing.JMenuItem();
        mnCtMallaAlumno = new javax.swing.JMenuItem();
        mnCtUsuarios = new javax.swing.JMenuItem();
        mnCtRoles = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        mnCtTipoNotas = new javax.swing.JMenuItem();
        mnCtNotas = new javax.swing.JMenuItem();
        mnIngresar = new javax.swing.JMenu();
        mnIgPersona = new javax.swing.JMenuItem();
        mnIgDocente = new javax.swing.JMenuItem();
        mnIgAlumno = new javax.swing.JMenuItem();
        mnIgCarrera = new javax.swing.JMenuItem();
        mnIgCurso = new javax.swing.JMenuItem();
        mnIgPrdLectivo = new javax.swing.JMenuItem();
        mnIgInscripcion = new javax.swing.JMenuItem();
        mnIgMatricula = new javax.swing.JMenuItem();
        mnOpciones = new javax.swing.JMenu();
        mnEstilo = new javax.swing.JMenu();
        mnRbtnWindows = new javax.swing.JRadioButtonMenuItem();
        mnRbtnNimbus = new javax.swing.JRadioButtonMenuItem();
        mnRbtnMetal = new javax.swing.JRadioButtonMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 500));

        pnlMenu.setBackground(new java.awt.Color(47, 76, 113));

        btnDocente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/img/icons8_School_Director_25px.png"))); // NOI18N
        btnDocente.setToolTipText("Ingresar docente");
        btnDocente.setFocusPainted(false);

        btnAlumno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/img/icons8_User_25px.png"))); // NOI18N
        btnAlumno.setToolTipText("Ingresar alumno");
        btnAlumno.setFocusPainted(false);

        btnCarrera.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/img/icons8_Graduation_Cap_25px.png"))); // NOI18N
        btnCarrera.setToolTipText("Ingresar carrera");
        btnCarrera.setFocusPainted(false);

        btnCurso.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/img/icons8_Class_25px.png"))); // NOI18N
        btnCurso.setToolTipText("Ingresar curso");
        btnCurso.setFocusPainted(false);

        btnPrdLectivo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/img/icons8_Calendar_25px.png"))); // NOI18N
        btnPrdLectivo.setToolTipText("Ingresar periodo lectivo");
        btnPrdLectivo.setFocusPainted(false);

        btnMateria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/img/icons8_Course_25px.png"))); // NOI18N
        btnMateria.setToolTipText("Ver materias");
        btnMateria.setFocusPainted(false);

        btnPersona.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/img/icons8_Team_25px_1.png"))); // NOI18N
        btnPersona.setToolTipText("Ingresar docente");
        btnPersona.setFocusPainted(false);

        btnInscripcion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/img/icons8_Resume_25px.png"))); // NOI18N
        btnInscripcion.setToolTipText("Ingresar inscripcion");
        btnInscripcion.setFocusPainted(false);

        btnMatricula.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/img/icons8_Documents_25px.png"))); // NOI18N
        btnMatricula.setToolTipText("Ingresar matricula");
        btnMatricula.setFocusPainted(false);

        btnCerrarSesion.setText("Cerrar Sesion");
        btnCerrarSesion.setToolTipText("Ver materias");
        btnCerrarSesion.setFocusPainted(false);

        javax.swing.GroupLayout pnlMenuLayout = new javax.swing.GroupLayout(pnlMenu);
        pnlMenu.setLayout(pnlMenuLayout);
        pnlMenuLayout.setHorizontalGroup(
            pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnPersona, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDocente, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPrdLectivo, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnInscripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnMateria, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 264, Short.MAX_VALUE)
                .addComponent(btnCerrarSesion))
        );
        pnlMenuLayout.setVerticalGroup(
            pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMenuLayout.createSequentialGroup()
                .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnAlumno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDocente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCarrera, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCurso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnPrdLectivo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnMateria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnPersona, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnInscripcion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnMatricula, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCerrarSesion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        dpnlPrincipal.setBackground(new java.awt.Color(244, 244, 244));

        javax.swing.GroupLayout dpnlPrincipalLayout = new javax.swing.GroupLayout(dpnlPrincipal);
        dpnlPrincipal.setLayout(dpnlPrincipalLayout);
        dpnlPrincipalLayout.setHorizontalGroup(
            dpnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        dpnlPrincipalLayout.setVerticalGroup(
            dpnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 408, Short.MAX_VALUE)
        );

        mnTipoNotas.setText("Consultar");

        mnCtPersona.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/img/icons8_Team_20px.png"))); // NOI18N
        mnCtPersona.setText("Persona");
        mnTipoNotas.add(mnCtPersona);

        mnCtDocente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/img/icons8_School_Director_20px.png"))); // NOI18N
        mnCtDocente.setText("Docente");
        mnTipoNotas.add(mnCtDocente);

        mnCtAlumno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/img/icons8_User_20px.png"))); // NOI18N
        mnCtAlumno.setText("Alumno");
        mnTipoNotas.add(mnCtAlumno);

        mnCtCarrera.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/img/icons8_Graduation_Cap_20px.png"))); // NOI18N
        mnCtCarrera.setText("Carrera");
        mnTipoNotas.add(mnCtCarrera);

        mnCtCurso.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/img/icons8_Class_20px.png"))); // NOI18N
        mnCtCurso.setText("Curso");
        mnTipoNotas.add(mnCtCurso);

        mnCtPrdLectivo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/img/icons8_Calendar_20px.png"))); // NOI18N
        mnCtPrdLectivo.setText("Periodo Lectivo");
        mnTipoNotas.add(mnCtPrdLectivo);

        mnCtMateria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/img/icons8_Course_20px.png"))); // NOI18N
        mnCtMateria.setText("Materia");
        mnTipoNotas.add(mnCtMateria);

        mnCtInscripcion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/img/icons8_Resume_20px.png"))); // NOI18N
        mnCtInscripcion.setText("Inscripcion");
        mnTipoNotas.add(mnCtInscripcion);

        mnCtMatricula.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/img/icons8_Documents_20px.png"))); // NOI18N
        mnCtMatricula.setText("Matricula");
        mnTipoNotas.add(mnCtMatricula);

        mnCtMallaAlumno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/img/icons8_Report_Card_20px.png"))); // NOI18N
        mnCtMallaAlumno.setText("Malla alumnos");
        mnTipoNotas.add(mnCtMallaAlumno);

        mnCtUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/img/icons8_User_Groups_20px.png"))); // NOI18N
        mnCtUsuarios.setText("Usuarios");
        mnTipoNotas.add(mnCtUsuarios);

        mnCtRoles.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/img/icons8_Protect_20px.png"))); // NOI18N
        mnCtRoles.setText("Roles Usuarios");
        mnTipoNotas.add(mnCtRoles);

        jMenu1.setText("Notas");

        mnCtTipoNotas.setText("Tipos de Notas");
        jMenu1.add(mnCtTipoNotas);

        mnCtNotas.setText("Ingreso Notas");
        jMenu1.add(mnCtNotas);

        mnTipoNotas.add(jMenu1);

        menuCrud.add(mnTipoNotas);

        mnIngresar.setText("Ingresar");

        mnIgPersona.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/img/icons8_Team_20px.png"))); // NOI18N
        mnIgPersona.setText("Persona");
        mnIngresar.add(mnIgPersona);

        mnIgDocente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/img/icons8_School_Director_20px.png"))); // NOI18N
        mnIgDocente.setText("Docente");
        mnIngresar.add(mnIgDocente);

        mnIgAlumno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/img/icons8_User_20px.png"))); // NOI18N
        mnIgAlumno.setText("Alumno");
        mnIngresar.add(mnIgAlumno);

        mnIgCarrera.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/img/icons8_Graduation_Cap_20px.png"))); // NOI18N
        mnIgCarrera.setText("Carrera");
        mnIngresar.add(mnIgCarrera);

        mnIgCurso.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/img/icons8_Class_20px.png"))); // NOI18N
        mnIgCurso.setText("Curso");
        mnIngresar.add(mnIgCurso);

        mnIgPrdLectivo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/img/icons8_Calendar_20px.png"))); // NOI18N
        mnIgPrdLectivo.setText("Periodo Lectivo");
        mnIngresar.add(mnIgPrdLectivo);

        mnIgInscripcion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/img/icons8_Resume_20px.png"))); // NOI18N
        mnIgInscripcion.setText("Inscripcion");
        mnIngresar.add(mnIgInscripcion);

        mnIgMatricula.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/img/icons8_Documents_20px.png"))); // NOI18N
        mnIgMatricula.setText("Matricula");
        mnIngresar.add(mnIgMatricula);

        menuCrud.add(mnIngresar);

        mnOpciones.setText("Opciones");

        mnEstilo.setText("Estilo");

        btngEstilo.add(mnRbtnWindows);
        mnRbtnWindows.setSelected(true);
        mnRbtnWindows.setText("Windows");
        mnEstilo.add(mnRbtnWindows);

        btngEstilo.add(mnRbtnNimbus);
        mnRbtnNimbus.setText("Nimbus");
        mnEstilo.add(mnRbtnNimbus);

        btngEstilo.add(mnRbtnMetal);
        mnRbtnMetal.setText("Metal");
        mnEstilo.add(mnRbtnMetal);

        mnOpciones.add(mnEstilo);

        menuCrud.add(mnOpciones);

        setJMenuBar(menuCrud);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(dpnlPrincipal)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(dpnlPrincipal))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlumno;
    private javax.swing.JButton btnCarrera;
    private javax.swing.JButton btnCerrarSesion;
    private javax.swing.JButton btnCurso;
    private javax.swing.JButton btnDocente;
    private javax.swing.JButton btnInscripcion;
    private javax.swing.JButton btnMateria;
    private javax.swing.JButton btnMatricula;
    private javax.swing.JButton btnPersona;
    private javax.swing.JButton btnPrdLectivo;
    private javax.swing.ButtonGroup btngEstilo;
    private javax.swing.JDesktopPane dpnlPrincipal;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar menuCrud;
    private javax.swing.JMenuItem mnCtAlumno;
    private javax.swing.JMenuItem mnCtCarrera;
    private javax.swing.JMenuItem mnCtCurso;
    private javax.swing.JMenuItem mnCtDocente;
    private javax.swing.JMenuItem mnCtInscripcion;
    private javax.swing.JMenuItem mnCtMallaAlumno;
    private javax.swing.JMenuItem mnCtMateria;
    private javax.swing.JMenuItem mnCtMatricula;
    private javax.swing.JMenuItem mnCtNotas;
    private javax.swing.JMenuItem mnCtPersona;
    private javax.swing.JMenuItem mnCtPrdLectivo;
    private javax.swing.JMenuItem mnCtRoles;
    private javax.swing.JMenuItem mnCtTipoNotas;
    private javax.swing.JMenuItem mnCtUsuarios;
    private javax.swing.JMenu mnEstilo;
    private javax.swing.JMenuItem mnIgAlumno;
    private javax.swing.JMenuItem mnIgCarrera;
    private javax.swing.JMenuItem mnIgCurso;
    private javax.swing.JMenuItem mnIgDocente;
    private javax.swing.JMenuItem mnIgInscripcion;
    private javax.swing.JMenuItem mnIgMatricula;
    private javax.swing.JMenuItem mnIgPersona;
    private javax.swing.JMenuItem mnIgPrdLectivo;
    private javax.swing.JMenu mnIngresar;
    private javax.swing.JMenu mnOpciones;
    private javax.swing.JRadioButtonMenuItem mnRbtnMetal;
    private javax.swing.JRadioButtonMenuItem mnRbtnNimbus;
    private javax.swing.JRadioButtonMenuItem mnRbtnWindows;
    private javax.swing.JMenu mnTipoNotas;
    private javax.swing.JPanel pnlMenu;
    // End of variables declaration//GEN-END:variables
}
