package vista.principal;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

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

    //avance
    public JMenuItem getMnCAvanceSilabo() {
        return MnCAvanceSilabo;
    }

    public void setMnCAvanceSilabo(JMenuItem MnCAvanceSilabo) {
        this.MnCAvanceSilabo = MnCAvanceSilabo;
    }

    public JButton getBtn_avance_si() {
        return btn_avance_si;
    }

    public void setBtn_avance_si(JButton btn_avance_si) {
        this.btn_avance_si = btn_avance_si;
    }

    //
    public JMenuItem getMnCtPlandeClase() {
        return mnCtPlandeClase;
    }

    public JMenuItem getMnCtAsistencia() {
        return mnCtAsistencia;
    }

    public JMenuItem getMnCtRendimientoAcademico() {
        return mnCtRendimientoAcademico;
    }

    public JMenuItem getMnIgPlandeClase() {
        return mnIgPlandeClase;
    }

    public void setMnIgPlandeClase(JMenuItem mnIgPlandeClase) {
        this.mnIgPlandeClase = mnIgPlandeClase;
    }

    public JButton getBtnIngresarRol() {
        return btnIngresarRol;
    }

    public JButton getBtnConsultarSilabo() {
        return btnConsultarSilabo;
    }

    public JMenuItem getMnBiblioteca() {
        return MnBiblioteca;
    }

    public JButton getBtnIngresarSilabo() {
        return btnIngresarSilabo;
    }

    public JMenuItem getMnCtSilabos() {
        return mnCtSilabos;
    }

    public JMenuItem getMnIgSilabo() {
        return mnIgSilabo;
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

    public JMenuItem getMnIgMateria() {
        return mnIgMateria;
    }

    public void setMnIgMateria(JMenuItem mnIgMateria) {
        this.mnIgMateria = mnIgMateria;
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

    public JMenuItem getMnCtRolesPeriodo() {
        return mnCtRolesPeriodo;
    }

    public JMenuItem getMnIgRolesPeriodo() {
        return mnIgRolesPeriodo;
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

    public JButton getBtnDocenteMateria() {
        return btnDocenteMateria;
    }

    public JMenuItem getMnCtDocenteMateria() {
        return mnCtDocenteMateria;
    }

    public JMenuItem getMnIgDocenteMt() {
        return mnIgDocenteMt;
    }

    public JMenuItem getMnCtTipoNotas() {
        return mnCtTipoNotas;
    }

    public JButton getBtnAyuda() {
        return btnAyuda;
    }

    public JLabel getBtnEstado() {
        return btnEstado;
    }

    public JLabel getLblEstado() {
        return lblEstado;
    }

    public JButton getBtnConsola() {
        return btnConsola;
    }

    public JMenuItem getMnCtHistorialUsers() {
        return mnCtHistorialUsers;
    }

    public JLabel getLblIP() {
        return lblIP;
    }

    public JButton getBtnCambiarRol() {
        return btnCambiarRol;
    }

    public JMenu getMnNotas() {
        return mnNotas;
    }

    public JMenuItem getMnIgActivarNotas1() {
        return mnIgActivarNotas1;
    }

    public JMenuItem getMnIgNotas1() {
        return mnIgNotas1;
    }

    public JMenuItem getMnIgPrdIngrNotas1() {
        return mnIgPrdIngrNotas1;
    }

    public JMenuItem getMnIgRoles1() {
        return mnIgRoles1;
    }

    public JMenuItem getMnIgUsuarios1() {
        return mnIgUsuarios1;
    }

    public JMenu getMnNotas1() {
        return mnNotas1;
    }

    public JMenuItem getMnCtComprobantes() {
        return mnCtComprobantes;
    }

    public JMenuItem getMnCtAccesos() {
        return mnCtAccesos;
    }

    public JMenuItem getMnCtMiPerfil() {
        return mnCtMiPerfil;
    }

    public JMenuItem getMnCtListaAlumnos() {
        return mnCtListaAlumnos;
    }

    public JMenuItem getMnCtAlmnRetirados() {
        return mnCtAlmnRetirados;
    }

    public JMenu getMnTipoNotas() {
        return mnTipoNotas;
    }

    public JMenuItem getMnCtReportesEstado() {
        return mnCtReportesEstado;
    }

    public JButton getBtnActualizar() {
        return btnActualizar;
    }

    public JMenuItem getMnCtAlmnMatri() {
        return mnCtAlmnMatri;
    }

    public JMenuItem getMnRepNumAlumno() {
        return mnRepNumAlumno;
    }

    public JLabel getLblUsuario() {
        return lblUsuario;
    }

    public JMenuItem getMnCtGestionAcademica() {
        return mnCtGestionAcademica;
    }

    public JMenuItem getMnCtAlumnosRetirados() {
        return mnCtAlumnosRetirados;
    }

    public JMenuItem getMnCtAlumnosEgresados() {
        return mnCtAlumnosEgresados;
    }

    public JMenuItem getMnCtAlumnosGraduados() {
        return mnCtAlumnosGraduados;
    }

    public JMenuItem getMnIgComprobantePago() {
        return mnIgComprobantePago;
    }

    public JMenuItem getMnIgMatriculaEspecial() {
        return mnIgMatriculaEspecial;
    }

    public JMenuItem getMnRepFichasSinResponder() {
        return mnRepFichasSinResponder;
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
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
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
        btnDocenteMateria = new javax.swing.JButton();
        btnIngresarSilabo = new javax.swing.JButton();
        btnConsultarSilabo = new javax.swing.JButton();
        btnIngresarRol = new javax.swing.JButton();
        btn_avance_si = new javax.swing.JButton();
        dpnlPrincipal = new javax.swing.JDesktopPane();
        jPanel1 = new javax.swing.JPanel();
        btnEstado = new javax.swing.JLabel();
        lblEstado = new javax.swing.JLabel();
        lblUsuario = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnCerrarSesion = new javax.swing.JButton();
        btnCambiarRol = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        btnAyuda = new javax.swing.JButton();
        btnConsola = new javax.swing.JButton();
        lblIP = new javax.swing.JLabel();
        btnActualizar = new javax.swing.JButton();
        menuCrud = new javax.swing.JMenuBar();
        mnTipoNotas = new javax.swing.JMenu();
        mnCtPersona = new javax.swing.JMenuItem();
        mnCtDocente = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        mnCtAlumno = new javax.swing.JMenuItem();
        mnCtInscripcion = new javax.swing.JMenuItem();
        mnCtAlumnosRetirados = new javax.swing.JMenuItem();
        mnCtMallaAlumno = new javax.swing.JMenuItem();
        mnCtAlumnosEgresados = new javax.swing.JMenuItem();
        mnCtAlumnosGraduados = new javax.swing.JMenuItem();
        mnCtCarrera = new javax.swing.JMenuItem();
        mnCtCurso = new javax.swing.JMenuItem();
        mnCtPrdLectivo = new javax.swing.JMenuItem();
        mnCtMateria = new javax.swing.JMenuItem();
        mnCtMatricula = new javax.swing.JMenuItem();
        mnCtAlmnRetirados = new javax.swing.JMenuItem();
        mnCtAlmnMatri = new javax.swing.JMenuItem();
        mnCtListaAlumnos = new javax.swing.JMenuItem();
        mnCtDocenteMateria = new javax.swing.JMenuItem();
        mnCtRolesPeriodo = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        mnCtSilabos = new javax.swing.JMenuItem();
        MnCAvanceSilabo = new javax.swing.JMenuItem();
        mnCtPlandeClase = new javax.swing.JMenuItem();
        mnCtGestionAcademica = new javax.swing.JMenuItem();
        mnNotas = new javax.swing.JMenu();
        mnCtTipoNotas = new javax.swing.JMenuItem();
        mnCtNotas = new javax.swing.JMenuItem();
        mnCtRendimientoAcademico = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        mnCtUsuarios = new javax.swing.JMenuItem();
        mnCtRoles = new javax.swing.JMenuItem();
        mnCtHistorialUsers = new javax.swing.JMenuItem();
        mnCtAccesos = new javax.swing.JMenuItem();
        mnCtMiPerfil = new javax.swing.JMenuItem();
        mnCtAsistencia = new javax.swing.JMenuItem();
        mnCtReportesEstado = new javax.swing.JMenuItem();
        MnBiblioteca = new javax.swing.JMenuItem();
        mnCtComprobantes = new javax.swing.JMenuItem();
        mnIngresar = new javax.swing.JMenu();
        mnIgPersona = new javax.swing.JMenuItem();
        mnIgDocente = new javax.swing.JMenuItem();
        mnIgAlumno = new javax.swing.JMenuItem();
        mnIgCarrera = new javax.swing.JMenuItem();
        mnIgCurso = new javax.swing.JMenuItem();
        mnIgPrdLectivo = new javax.swing.JMenuItem();
        mnIgMateria = new javax.swing.JMenuItem();
        mnIgInscripcion = new javax.swing.JMenuItem();
        mnIgMatricula = new javax.swing.JMenuItem();
        mnIgMatriculaEspecial = new javax.swing.JMenuItem();
        mnIgComprobantePago = new javax.swing.JMenuItem();
        mnIgDocenteMt = new javax.swing.JMenuItem();
        mnIgRolesPeriodo = new javax.swing.JMenuItem();
        mnIgSilabo = new javax.swing.JMenuItem();
        mnIgPlandeClase = new javax.swing.JMenuItem();
        mnIgUsuarios1 = new javax.swing.JMenuItem();
        mnIgRoles1 = new javax.swing.JMenuItem();
        mnNotas1 = new javax.swing.JMenu();
        mnIgPrdIngrNotas1 = new javax.swing.JMenuItem();
        mnIgNotas1 = new javax.swing.JMenuItem();
        mnIgActivarNotas1 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        mnRepNumAlumno = new javax.swing.JMenuItem();
        mnRepFichasSinResponder = new javax.swing.JMenuItem();
        mnOpciones = new javax.swing.JMenu();
        mnEstilo = new javax.swing.JMenu();

        jMenuItem1.setText("jMenuItem1");

        jMenuItem3.setText("jMenuItem3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 500));

        pnlMenu.setBackground(new java.awt.Color(47, 76, 113));

        btnDocente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/img/icons8_School_Director_25px.png"))); // NOI18N
        btnDocente.setToolTipText("Ingresar docente.");
        btnDocente.setFocusPainted(false);

        btnAlumno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/img/icons8_User_25px.png"))); // NOI18N
        btnAlumno.setToolTipText("Ingresar alumno.");
        btnAlumno.setFocusPainted(false);

        btnCarrera.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/img/icons8_Graduation_Cap_25px.png"))); // NOI18N
        btnCarrera.setToolTipText("Ingresar carrera.");
        btnCarrera.setFocusPainted(false);

        btnCurso.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/img/icons8_Class_25px.png"))); // NOI18N
        btnCurso.setToolTipText("Ingresar curso.");
        btnCurso.setFocusPainted(false);

        btnPrdLectivo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/img/icons8_Calendar_25px.png"))); // NOI18N
        btnPrdLectivo.setToolTipText("Ingresar período lectivo.");
        btnPrdLectivo.setFocusPainted(false);

        btnMateria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/img/icons8_Course_25px.png"))); // NOI18N
        btnMateria.setToolTipText("Ver materias");
        btnMateria.setFocusPainted(false);

        btnPersona.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/img/icons8_Team_25px_1.png"))); // NOI18N
        btnPersona.setToolTipText("Ingresar persona.");
        btnPersona.setFocusPainted(false);

        btnInscripcion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/img/icons8_Resume_25px.png"))); // NOI18N
        btnInscripcion.setToolTipText("Ingresar inscripcion");
        btnInscripcion.setFocusPainted(false);

        btnMatricula.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/img/icons8_Documents_25px.png"))); // NOI18N
        btnMatricula.setToolTipText("Ingresar matricula");
        btnMatricula.setFocusPainted(false);

        btnDocenteMateria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/img/icons8_Literature_25px.png"))); // NOI18N
        btnDocenteMateria.setToolTipText("Asignar materia a docente.");
        btnDocenteMateria.setFocusPainted(false);

        btnIngresarSilabo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/img/consulta_silabo.png"))); // NOI18N
        btnIngresarSilabo.setToolTipText("Ingresar Silabo");
        btnIngresarSilabo.setFocusPainted(false);
        btnIngresarSilabo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarSilaboActionPerformed(evt);
            }
        });

        btnConsultarSilabo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/img/ingreso_silabo.png"))); // NOI18N
        btnConsultarSilabo.setToolTipText("Consultar Silabo");
        btnConsultarSilabo.setFocusPainted(false);

        btnIngresarRol.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/img/icons8_Permanent_Job_25px.png"))); // NOI18N
        btnIngresarRol.setToolTipText("Ingresar Roles");
        btnIngresarRol.setFocusPainted(false);

        btn_avance_si.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/img/avanceSilabo.png"))); // NOI18N

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
                .addComponent(btnDocenteMateria, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnMateria, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnIngresarSilabo, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnConsultarSilabo, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnIngresarRol, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_avance_si, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
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
                    .addComponent(btnDocenteMateria, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnIngresarSilabo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnConsultarSilabo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnIngresarRol, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_avance_si, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(2, 2, 2))
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
            .addGap(0, 370, Short.MAX_VALUE)
        );

        jPanel1.setBackground(new java.awt.Color(47, 76, 113));

        btnEstado.setBackground(new java.awt.Color(51, 51, 51));
        btnEstado.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnEstado.setForeground(new java.awt.Color(255, 255, 255));
        btnEstado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnEstado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/img/animacion/LogoPosFinal.png"))); // NOI18N
        btnEstado.setToolTipText("");

        lblEstado.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblEstado.setForeground(new java.awt.Color(255, 255, 255));
        lblEstado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        lblUsuario.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblUsuario.setForeground(new java.awt.Color(255, 255, 255));
        lblUsuario.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblUsuario.setText("H");
        lblUsuario.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(btnEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblEstado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(btnEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(lblEstado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(47, 76, 113));

        btnCerrarSesion.setBackground(new java.awt.Color(51, 51, 51));
        btnCerrarSesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/img/icons8_Sign_Out_25px.png"))); // NOI18N
        btnCerrarSesion.setToolTipText("Cerrar Sesión");
        btnCerrarSesion.setBorder(null);
        btnCerrarSesion.setBorderPainted(false);
        btnCerrarSesion.setContentAreaFilled(false);
        btnCerrarSesion.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnCerrarSesion.setFocusPainted(false);
        btnCerrarSesion.setOpaque(true);

        btnCambiarRol.setBackground(new java.awt.Color(51, 51, 51));
        btnCambiarRol.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/img/icons8_Theatre_Mask_25px.png"))); // NOI18N
        btnCambiarRol.setToolTipText("Seleccionar otro rol.");
        btnCambiarRol.setBorder(null);
        btnCambiarRol.setBorderPainted(false);
        btnCambiarRol.setContentAreaFilled(false);
        btnCambiarRol.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnCambiarRol.setFocusPainted(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCambiarRol, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnCerrarSesion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnCambiarRol, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new java.awt.Color(47, 76, 113));

        btnAyuda.setBackground(new java.awt.Color(51, 51, 51));
        btnAyuda.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnAyuda.setForeground(new java.awt.Color(255, 255, 255));
        btnAyuda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/img/icons8_Info_25px.png"))); // NOI18N
        btnAyuda.setToolTipText("Ayuda");
        btnAyuda.setBorder(null);
        btnAyuda.setBorderPainted(false);
        btnAyuda.setContentAreaFilled(false);
        btnAyuda.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        btnConsola.setBackground(new java.awt.Color(51, 51, 51));
        btnConsola.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnConsola.setForeground(new java.awt.Color(255, 255, 255));
        btnConsola.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/img/icons8_Console_25px.png"))); // NOI18N
        btnConsola.setToolTipText("Version");
        btnConsola.setBorder(null);
        btnConsola.setBorderPainted(false);
        btnConsola.setContentAreaFilled(false);
        btnConsola.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnConsola.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnConsola.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/img/icons8_Console_20px.png"))); // NOI18N

        lblIP.setForeground(new java.awt.Color(255, 255, 255));
        lblIP.setText("35.193.226.187");

        btnActualizar.setBackground(new java.awt.Color(51, 51, 51));
        btnActualizar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnActualizar.setForeground(new java.awt.Color(255, 255, 255));
        btnActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/img/icons8_Cat_Profile_25px.png"))); // NOI18N
        btnActualizar.setToolTipText("Comprobar actualizacion del sistema.");
        btnActualizar.setBorder(null);
        btnActualizar.setBorderPainted(false);
        btnActualizar.setContentAreaFilled(false);
        btnActualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnActualizar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(lblIP, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnConsola, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAyuda, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnAyuda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnConsola, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblIP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(btnActualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        mnTipoNotas.setText("Consultar");

        mnCtPersona.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/img/icons8_Team_20px.png"))); // NOI18N
        mnCtPersona.setText("Persona");
        mnTipoNotas.add(mnCtPersona);

        mnCtDocente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/img/icons8_School_Director_20px.png"))); // NOI18N
        mnCtDocente.setText("Docente");
        mnTipoNotas.add(mnCtDocente);

        jMenu4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/img/icons8_User_20px.png"))); // NOI18N
        jMenu4.setText("Alumno");

        mnCtAlumno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/img/icons8_User_20px.png"))); // NOI18N
        mnCtAlumno.setText("Todos");
        jMenu4.add(mnCtAlumno);

        mnCtInscripcion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/img/icons8_Resume_20px.png"))); // NOI18N
        mnCtInscripcion.setText("Inscripción");
        jMenu4.add(mnCtInscripcion);

        mnCtAlumnosRetirados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/img/icons8-persona-mareada-20.png"))); // NOI18N
        mnCtAlumnosRetirados.setText("Retirados");
        jMenu4.add(mnCtAlumnosRetirados);

        mnCtMallaAlumno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/img/icons8_Report_Card_20px.png"))); // NOI18N
        mnCtMallaAlumno.setText("Malla alumnos");
        jMenu4.add(mnCtMallaAlumno);

        mnCtAlumnosEgresados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/img/icons8-diploma-20.png"))); // NOI18N
        mnCtAlumnosEgresados.setText("Egresados");
        jMenu4.add(mnCtAlumnosEgresados);

        mnCtAlumnosGraduados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/img/icons8-estudiante-masculino-20.png"))); // NOI18N
        mnCtAlumnosGraduados.setText("Graduados");
        jMenu4.add(mnCtAlumnosGraduados);

        mnTipoNotas.add(jMenu4);

        mnCtCarrera.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/img/icons8_Graduation_Cap_20px.png"))); // NOI18N
        mnCtCarrera.setText("Carrera");
        mnTipoNotas.add(mnCtCarrera);

        mnCtCurso.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/img/icons8_Class_20px.png"))); // NOI18N
        mnCtCurso.setText("Curso (Lista por docente)");
        mnTipoNotas.add(mnCtCurso);

        mnCtPrdLectivo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/img/icons8_Calendar_20px.png"))); // NOI18N
        mnCtPrdLectivo.setText("Período lectivo");
        mnTipoNotas.add(mnCtPrdLectivo);

        mnCtMateria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/img/icons8_Course_20px.png"))); // NOI18N
        mnCtMateria.setText("Materia");
        mnTipoNotas.add(mnCtMateria);

        mnCtMatricula.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/img/icons8_Documents_20px.png"))); // NOI18N
        mnCtMatricula.setText("Matricula");
        mnTipoNotas.add(mnCtMatricula);

        mnCtAlmnRetirados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/img/icons8_Delete_File_20px_1.png"))); // NOI18N
        mnCtAlmnRetirados.setText("Matriculas Anuladas");
        mnTipoNotas.add(mnCtAlmnRetirados);

        mnCtAlmnMatri.setText("Alumno Matricula");
        mnTipoNotas.add(mnCtAlmnMatri);

        mnCtListaAlumnos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/img/icons8_Classroom_20px.png"))); // NOI18N
        mnCtListaAlumnos.setText("Lista general alumnos");
        mnTipoNotas.add(mnCtListaAlumnos);

        mnCtDocenteMateria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/img/icons8_Literature_20px.png"))); // NOI18N
        mnCtDocenteMateria.setText("Materia docentes");
        mnTipoNotas.add(mnCtDocenteMateria);

        mnCtRolesPeriodo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/img/icons8_Permanent_Job_20px.png"))); // NOI18N
        mnCtRolesPeriodo.setText("Roles periodo");
        mnTipoNotas.add(mnCtRolesPeriodo);

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/img/icons8-carpeta-de-documentos-20.png"))); // NOI18N
        jMenu2.setText("Documentos Académicos");

        mnCtSilabos.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.CTRL_MASK));
        mnCtSilabos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/img/consultar_silabo_menu.png"))); // NOI18N
        mnCtSilabos.setText("Sílabos");
        jMenu2.add(mnCtSilabos);

        MnCAvanceSilabo.setText("Avance de Sílabo");
        jMenu2.add(MnCAvanceSilabo);

        mnCtPlandeClase.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_K, java.awt.event.InputEvent.CTRL_MASK));
        mnCtPlandeClase.setText("Plan de clase");
        jMenu2.add(mnCtPlandeClase);

        mnCtGestionAcademica.setText("Cuadro de Gestión Académica ");
        jMenu2.add(mnCtGestionAcademica);

        mnTipoNotas.add(jMenu2);

        mnNotas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/img/icons8-notas-20px .png"))); // NOI18N
        mnNotas.setText("Notas");

        mnCtTipoNotas.setText("Tipos de notas");
        mnNotas.add(mnCtTipoNotas);

        mnCtNotas.setText("Registro de notas");
        mnNotas.add(mnCtNotas);

        mnCtRendimientoAcademico.setText("Rendimiento Académico");
        mnNotas.add(mnCtRendimientoAcademico);

        mnTipoNotas.add(mnNotas);

        jMenu3.setText("Administracion");

        mnCtUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/img/icons8_User_Groups_20px.png"))); // NOI18N
        mnCtUsuarios.setText("Usuarios");
        jMenu3.add(mnCtUsuarios);

        mnCtRoles.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/img/icons8_Protect_20px.png"))); // NOI18N
        mnCtRoles.setText("Roles usuarios");
        jMenu3.add(mnCtRoles);

        mnCtHistorialUsers.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/img/icons8_Analyze_20px_1.png"))); // NOI18N
        mnCtHistorialUsers.setText("Historial usuarios");
        jMenu3.add(mnCtHistorialUsers);

        mnCtAccesos.setText("Accesos");
        jMenu3.add(mnCtAccesos);

        mnTipoNotas.add(jMenu3);

        mnCtMiPerfil.setText("Mi Perfil");
        mnTipoNotas.add(mnCtMiPerfil);

        mnCtAsistencia.setText("Asistencia");
        mnTipoNotas.add(mnCtAsistencia);

        mnCtReportesEstado.setText("Estado Asistencia");
        mnTipoNotas.add(mnCtReportesEstado);

        MnBiblioteca.setText("Biblioteca");
        mnTipoNotas.add(MnBiblioteca);

        mnCtComprobantes.setText("Comprobantes");
        mnCtComprobantes.setToolTipText("");
        mnTipoNotas.add(mnCtComprobantes);

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
        mnIgPrdLectivo.setText("Período lectivo");
        mnIgPrdLectivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnIgPrdLectivoActionPerformed(evt);
            }
        });
        mnIngresar.add(mnIgPrdLectivo);

        mnIgMateria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/img/icons8_Course_20px.png"))); // NOI18N
        mnIgMateria.setText("Materia");
        mnIngresar.add(mnIgMateria);

        mnIgInscripcion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/img/icons8_Resume_20px.png"))); // NOI18N
        mnIgInscripcion.setText("Inscripción");
        mnIngresar.add(mnIgInscripcion);

        mnIgMatricula.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/img/icons8_Documents_20px.png"))); // NOI18N
        mnIgMatricula.setText("Matrícula");
        mnIngresar.add(mnIgMatricula);

        mnIgMatriculaEspecial.setText("Matricula Especial");
        mnIngresar.add(mnIgMatriculaEspecial);

        mnIgComprobantePago.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/img/icons8-tarjeta-bancaria-faltante-20.png"))); // NOI18N
        mnIgComprobantePago.setText("Comprobante pago");
        mnIngresar.add(mnIgComprobantePago);

        mnIgDocenteMt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/img/icons8_Literature_20px.png"))); // NOI18N
        mnIgDocenteMt.setText("Materia docente");
        mnIngresar.add(mnIgDocenteMt);

        mnIgRolesPeriodo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/img/icons8_Permanent_Job_20px.png"))); // NOI18N
        mnIgRolesPeriodo.setText("Roles periodo");
        mnIngresar.add(mnIgRolesPeriodo);

        mnIgSilabo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.ALT_MASK));
        mnIgSilabo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/img/ingresar_silabo_menu.png"))); // NOI18N
        mnIgSilabo.setText("Silabo");
        mnIngresar.add(mnIgSilabo);

        mnIgPlandeClase.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.ALT_MASK));
        mnIgPlandeClase.setText("Plan de clase");
        mnIngresar.add(mnIgPlandeClase);

        mnIgUsuarios1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/img/icons8_User_Groups_20px.png"))); // NOI18N
        mnIgUsuarios1.setText("Usuarios");
        mnIngresar.add(mnIgUsuarios1);

        mnIgRoles1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/img/icons8_Protect_20px.png"))); // NOI18N
        mnIgRoles1.setText("Roles usuarios");
        mnIngresar.add(mnIgRoles1);

        mnNotas1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/img/icons8-notas-20px .png"))); // NOI18N
        mnNotas1.setText("Notas");

        mnIgPrdIngrNotas1.setText("Periodos de ingreso de notas");
        mnNotas1.add(mnIgPrdIngrNotas1);

        mnIgNotas1.setText("Ingreso notas");
        mnNotas1.add(mnIgNotas1);

        mnIgActivarNotas1.setText("Activar ingreso de notas");
        mnNotas1.add(mnIgActivarNotas1);

        mnIngresar.add(mnNotas1);

        menuCrud.add(mnIngresar);

        jMenu1.setText("Reportes");

        mnRepNumAlumno.setText("Numero Alumnos");
        jMenu1.add(mnRepNumAlumno);

        mnRepFichasSinResponder.setText("Fichas sin responder");
        jMenu1.add(mnRepFichasSinResponder);

        menuCrud.add(jMenu1);

        mnOpciones.setText("Opciones");

        mnEstilo.setText("Estilo");
        mnOpciones.add(mnEstilo);

        menuCrud.add(mnOpciones);

        setJMenuBar(menuCrud);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(dpnlPrincipal)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0)
                .addComponent(dpnlPrincipal)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnIngresarSilaboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarSilaboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnIngresarSilaboActionPerformed

    private void mnIgPrdLectivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnIgPrdLectivoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mnIgPrdLectivoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem MnBiblioteca;
    private javax.swing.JMenuItem MnCAvanceSilabo;
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAlumno;
    private javax.swing.JButton btnAyuda;
    private javax.swing.JButton btnCambiarRol;
    private javax.swing.JButton btnCarrera;
    private javax.swing.JButton btnCerrarSesion;
    private javax.swing.JButton btnConsola;
    private javax.swing.JButton btnConsultarSilabo;
    private javax.swing.JButton btnCurso;
    private javax.swing.JButton btnDocente;
    private javax.swing.JButton btnDocenteMateria;
    private javax.swing.JLabel btnEstado;
    private javax.swing.JButton btnIngresarRol;
    private javax.swing.JButton btnIngresarSilabo;
    private javax.swing.JButton btnInscripcion;
    private javax.swing.JButton btnMateria;
    private javax.swing.JButton btnMatricula;
    private javax.swing.JButton btnPersona;
    private javax.swing.JButton btnPrdLectivo;
    private javax.swing.JButton btn_avance_si;
    private javax.swing.ButtonGroup btngEstilo;
    private javax.swing.JDesktopPane dpnlPrincipal;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblIP;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JMenuBar menuCrud;
    private javax.swing.JMenuItem mnCtAccesos;
    private javax.swing.JMenuItem mnCtAlmnMatri;
    private javax.swing.JMenuItem mnCtAlmnRetirados;
    private javax.swing.JMenuItem mnCtAlumno;
    private javax.swing.JMenuItem mnCtAlumnosEgresados;
    private javax.swing.JMenuItem mnCtAlumnosGraduados;
    private javax.swing.JMenuItem mnCtAlumnosRetirados;
    private javax.swing.JMenuItem mnCtAsistencia;
    private javax.swing.JMenuItem mnCtCarrera;
    private javax.swing.JMenuItem mnCtComprobantes;
    private javax.swing.JMenuItem mnCtCurso;
    private javax.swing.JMenuItem mnCtDocente;
    private javax.swing.JMenuItem mnCtDocenteMateria;
    private javax.swing.JMenuItem mnCtGestionAcademica;
    private javax.swing.JMenuItem mnCtHistorialUsers;
    private javax.swing.JMenuItem mnCtInscripcion;
    private javax.swing.JMenuItem mnCtListaAlumnos;
    private javax.swing.JMenuItem mnCtMallaAlumno;
    private javax.swing.JMenuItem mnCtMateria;
    private javax.swing.JMenuItem mnCtMatricula;
    private javax.swing.JMenuItem mnCtMiPerfil;
    private javax.swing.JMenuItem mnCtNotas;
    private javax.swing.JMenuItem mnCtPersona;
    private javax.swing.JMenuItem mnCtPlandeClase;
    private javax.swing.JMenuItem mnCtPrdLectivo;
    private javax.swing.JMenuItem mnCtRendimientoAcademico;
    private javax.swing.JMenuItem mnCtReportesEstado;
    private javax.swing.JMenuItem mnCtRoles;
    private javax.swing.JMenuItem mnCtRolesPeriodo;
    private javax.swing.JMenuItem mnCtSilabos;
    private javax.swing.JMenuItem mnCtTipoNotas;
    private javax.swing.JMenuItem mnCtUsuarios;
    private javax.swing.JMenu mnEstilo;
    private javax.swing.JMenuItem mnIgActivarNotas1;
    private javax.swing.JMenuItem mnIgAlumno;
    private javax.swing.JMenuItem mnIgCarrera;
    private javax.swing.JMenuItem mnIgComprobantePago;
    private javax.swing.JMenuItem mnIgCurso;
    private javax.swing.JMenuItem mnIgDocente;
    private javax.swing.JMenuItem mnIgDocenteMt;
    private javax.swing.JMenuItem mnIgInscripcion;
    private javax.swing.JMenuItem mnIgMateria;
    private javax.swing.JMenuItem mnIgMatricula;
    private javax.swing.JMenuItem mnIgMatriculaEspecial;
    private javax.swing.JMenuItem mnIgNotas1;
    private javax.swing.JMenuItem mnIgPersona;
    private javax.swing.JMenuItem mnIgPlandeClase;
    private javax.swing.JMenuItem mnIgPrdIngrNotas1;
    private javax.swing.JMenuItem mnIgPrdLectivo;
    private javax.swing.JMenuItem mnIgRoles1;
    private javax.swing.JMenuItem mnIgRolesPeriodo;
    private javax.swing.JMenuItem mnIgSilabo;
    private javax.swing.JMenuItem mnIgUsuarios1;
    private javax.swing.JMenu mnIngresar;
    private javax.swing.JMenu mnNotas;
    private javax.swing.JMenu mnNotas1;
    private javax.swing.JMenu mnOpciones;
    private javax.swing.JMenuItem mnRepFichasSinResponder;
    private javax.swing.JMenuItem mnRepNumAlumno;
    private javax.swing.JMenu mnTipoNotas;
    private javax.swing.JPanel pnlMenu;
    // End of variables declaration//GEN-END:variables
}
