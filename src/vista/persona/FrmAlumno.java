package vista.persona;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.JTextField;

/**
 *
 * @author Andres Novillo
 */
public class FrmAlumno extends javax.swing.JInternalFrame {

    /**
     * Creates new form Frm_Alumno
     */
    public FrmAlumno() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        Txt_Nombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        Txt_Cedula = new javax.swing.JTextField();
        CmBx_TipoBachillerato = new javax.swing.JComboBox<>();
        Txt_TlSuperior = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        Spnr_Anio = new javax.swing.JSpinner();
        CmBx_SecEconomico = new javax.swing.JComboBox<>();
        CmBx_ForMadre = new javax.swing.JComboBox<>();
        CmBx_Parentesco = new javax.swing.JComboBox<>();
        jLabel21 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        Btn_Cancelar = new javax.swing.JButton();
        Btn_Guardar = new javax.swing.JButton();
        Txt_ConEmergency = new javax.swing.JTextField();
        Txt_NomContacto = new javax.swing.JTextField();
        CmBx_ForPadre = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        ChkBx_Trabaja = new javax.swing.JCheckBox();
        Txt_Ocupacion = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        ChkBx_Pension = new javax.swing.JCheckBox();
        jLabel19 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        ChkBx_EdcSuperior = new javax.swing.JCheckBox();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        CmBx_TipoColegio = new javax.swing.JComboBox<>();
        CmBx_NvAcademico = new javax.swing.JComboBox<>();
        Btn_Buscar = new javax.swing.JButton();
        Lbl_ErrCedula = new javax.swing.JLabel();
        Lbl_ErrTipColegio = new javax.swing.JLabel();
        Lbl_ErrTipBachillerato = new javax.swing.JLabel();
        Lbl_ErrNvAcademico = new javax.swing.JLabel();
        Lbl_ErrTiSuperior = new javax.swing.JLabel();
        Lbl_ErrOcupacion = new javax.swing.JLabel();
        Lbl_ErrSecEconomico = new javax.swing.JLabel();
        Lbl_ErrForPadre = new javax.swing.JLabel();
        Lbl_ErrForMadre = new javax.swing.JLabel();
        Lbl_ErrNomContacto = new javax.swing.JLabel();
        Lbl_ErrParentesco = new javax.swing.JLabel();
        Lbl_ErrConEmergencia = new javax.swing.JLabel();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconifiable(true);
        setTitle("Formulario Alumno");

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("Cedula: ");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 10, -1, 20));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 860, 10));
        jPanel1.add(Txt_Nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 10, 430, -1));

        jLabel3.setText("Nombre:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 10, -1, 20));

        Txt_Cedula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Txt_CedulaActionPerformed(evt);
            }
        });
        jPanel1.add(Txt_Cedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 223, -1));

        CmBx_TipoBachillerato.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "|SELECCIONE|", "BGU", "BI", "TECNICO", "TECNICO PRODUCTIVO", "OTRO" }));
        jPanel1.add(CmBx_TipoBachillerato, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 60, 340, -1));

        Txt_TlSuperior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Txt_TlSuperiorActionPerformed(evt);
            }
        });
        jPanel1.add(Txt_TlSuperior, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 130, 340, -1));

        jLabel8.setText("Titulo Superior: ");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 130, -1, 20));

        jLabel5.setText("Tipo de Bachillerato:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 60, -1, -1));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 860, 7));

        Spnr_Anio.setModel(new javax.swing.SpinnerDateModel());
        jPanel1.add(Spnr_Anio, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 180, 137, -1));

        CmBx_SecEconomico.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "|SELECCIONE|" }));
        jPanel1.add(CmBx_SecEconomico, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 220, 340, -1));

        CmBx_ForMadre.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "|SELECCIONE|", "PRIMARIA", "SECUNDARIA", "SUPERIOR" }));
        jPanel1.add(CmBx_ForMadre, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 260, 340, -1));

        CmBx_Parentesco.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "|SELECCIONE|", "MADRE", "PADRE", "HERMANO/A", "ESPOSO/A", "OTRO" }));
        jPanel1.add(CmBx_Parentesco, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 300, 340, -1));

        jLabel21.setText("Parentesco Contacto: ");
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 300, -1, 20));

        jLabel20.setText("Formacion Madre:");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 260, -1, 20));

        jLabel15.setText("Sector Económico:");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 220, -1, 20));

        jLabel6.setText("Año de Bachiller:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 180, -1, 20));
        jPanel1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 370, 870, 10));

        Btn_Cancelar.setText("Cancelar");
        jPanel1.add(Btn_Cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 380, 90, -1));

        Btn_Guardar.setText("Guardar");
        jPanel1.add(Btn_Guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 380, 100, -1));
        jPanel1.add(Txt_ConEmergency, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 330, 194, -1));
        jPanel1.add(Txt_NomContacto, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 290, 194, -1));

        CmBx_ForPadre.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "|SELECCIONE|", "PRIMARIA", "SECUNDARIA", "SUPERIOR" }));
        jPanel1.add(CmBx_ForPadre, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 250, 200, -1));

        jLabel14.setText("Trabaja:");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 220, -1, 20));
        jPanel1.add(ChkBx_Trabaja, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 220, -1, -1));
        jPanel1.add(Txt_Ocupacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 180, 250, -1));

        jLabel13.setText("Ocupacion:");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, -1, -1));

        jLabel12.setText("Pension:");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, -1, 20));
        jPanel1.add(ChkBx_Pension, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 220, -1, -1));

        jLabel19.setText("Formacion Padre:");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, -1, -1));

        jLabel22.setText("Nombre Contacto:");
        jPanel1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, -1, 20));

        jLabel23.setText("Contacto Emergencia:");
        jPanel1.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, -1, 20));
        jPanel1.add(ChkBx_EdcSuperior, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 140, -1, -1));

        jLabel7.setText("Educación Superior: ");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, -1, 20));

        jLabel9.setText("Nivel Académico:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, -1));

        jLabel4.setText("Tipo de Colegio:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        CmBx_TipoColegio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "|SELECCIONE|", "FISCAL", "FISCOMISIONAL", "PRIVADA", "MUNICIPAL", "OTROS" }));
        jPanel1.add(CmBx_TipoColegio, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 60, 200, -1));

        CmBx_NvAcademico.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "|SELECCIONE|", "CENTRO DE ALFABETIZACIÓN", "EDUCACIÓN MEDIA", "EDUCACIÓN SUPERIOR", "POST-GRADO", "PRIMARIA", "SECUNDARIA", "SUPERIOR NO UNIVERSITARIO", "SUPERIOR UNIVERSITARIO", "NINGUNO" }));
        jPanel1.add(CmBx_NvAcademico, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 100, 200, -1));

        Btn_Buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/img/icons8_Search_15px.png"))); // NOI18N
        jPanel1.add(Btn_Buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 10, 31, -1));

        Lbl_ErrCedula.setForeground(new java.awt.Color(204, 0, 0));
        Lbl_ErrCedula.setText("Ingrese solo números");
        jPanel1.add(Lbl_ErrCedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 30, 160, -1));

        Lbl_ErrTipColegio.setForeground(new java.awt.Color(204, 0, 0));
        Lbl_ErrTipColegio.setText("Seleccione un Colegio");
        jPanel1.add(Lbl_ErrTipColegio, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 80, 130, -1));

        Lbl_ErrTipBachillerato.setForeground(new java.awt.Color(204, 0, 0));
        Lbl_ErrTipBachillerato.setText("Seleccione un Bachillerato");
        jPanel1.add(Lbl_ErrTipBachillerato, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 80, -1, -1));

        Lbl_ErrNvAcademico.setForeground(new java.awt.Color(204, 0, 0));
        Lbl_ErrNvAcademico.setText("Seleccione un Nivel Academico");
        jPanel1.add(Lbl_ErrNvAcademico, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 120, -1, -1));

        Lbl_ErrTiSuperior.setForeground(new java.awt.Color(204, 0, 0));
        Lbl_ErrTiSuperior.setText("Ingrese solo letras");
        jPanel1.add(Lbl_ErrTiSuperior, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 150, -1, -1));

        Lbl_ErrOcupacion.setForeground(new java.awt.Color(204, 0, 0));
        Lbl_ErrOcupacion.setText("Ingrese solo letras");
        jPanel1.add(Lbl_ErrOcupacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 200, 130, -1));

        Lbl_ErrSecEconomico.setForeground(new java.awt.Color(204, 0, 0));
        Lbl_ErrSecEconomico.setText("Seleccione un Sector");
        jPanel1.add(Lbl_ErrSecEconomico, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 240, 190, -1));

        Lbl_ErrForPadre.setForeground(new java.awt.Color(204, 0, 0));
        Lbl_ErrForPadre.setText("Seleccione la Formación del Padre");
        jPanel1.add(Lbl_ErrForPadre, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 270, 190, -1));

        Lbl_ErrForMadre.setForeground(new java.awt.Color(204, 0, 0));
        Lbl_ErrForMadre.setText("Seleccione la Formacion de la Madre");
        jPanel1.add(Lbl_ErrForMadre, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 280, 250, -1));

        Lbl_ErrNomContacto.setForeground(new java.awt.Color(204, 0, 0));
        Lbl_ErrNomContacto.setText("Ingrese solo letras");
        jPanel1.add(Lbl_ErrNomContacto, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 310, 190, -1));

        Lbl_ErrParentesco.setForeground(new java.awt.Color(204, 0, 0));
        Lbl_ErrParentesco.setText("Seleccione un Parentesco");
        jPanel1.add(Lbl_ErrParentesco, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 320, 250, -1));

        Lbl_ErrConEmergencia.setForeground(new java.awt.Color(204, 0, 0));
        Lbl_ErrConEmergencia.setText("Ingrese solo números");
        jPanel1.add(Lbl_ErrConEmergencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 350, 170, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Txt_CedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Txt_CedulaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Txt_CedulaActionPerformed

    private void Txt_TlSuperiorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Txt_TlSuperiorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Txt_TlSuperiorActionPerformed

    public JButton getBtn_Buscar() {
        return Btn_Buscar;
    }

    public void setBtn_Buscar(JButton Btn_Buscar) {
        this.Btn_Buscar = Btn_Buscar;
    }

    public JButton getBtn_Cancelar() {
        return Btn_Cancelar;
    }

    public void setBtn_Cancelar(JButton Btn_Cancelar) {
        this.Btn_Cancelar = Btn_Cancelar;
    }

    public JButton getBtn_Guardar() {
        return Btn_Guardar;
    }

    public void setBtn_Guardar(JButton Btn_Guardar) {
        this.Btn_Guardar = Btn_Guardar;
    }

    public JCheckBox getChkBx_EdcSuperior() {
        return ChkBx_EdcSuperior;
    }

    public void setChkBx_EdcSuperior(JCheckBox ChkBx_EdcSuperior) {
        this.ChkBx_EdcSuperior = ChkBx_EdcSuperior;
    }

    public JCheckBox getChkBx_Pension() {
        return ChkBx_Pension;
    }

    public void setChkBx_Pension(JCheckBox ChkBx_Pension) {
        this.ChkBx_Pension = ChkBx_Pension;
    }

    public JCheckBox getChkBx_Trabaja() {
        return ChkBx_Trabaja;
    }

    public void setChkBx_Trabaja(JCheckBox ChkBx_Trabaja) {
        this.ChkBx_Trabaja = ChkBx_Trabaja;
    }

    public JComboBox<String> getCmBx_ForMadre() {
        return CmBx_ForMadre;
    }

    public void setCmBx_ForMadre(JComboBox<String> CmBx_ForMadre) {
        this.CmBx_ForMadre = CmBx_ForMadre;
    }

    public JComboBox<String> getCmBx_ForPadre() {
        return CmBx_ForPadre;
    }

    public void setCmBx_ForPadre(JComboBox<String> CmBx_ForPadre) {
        this.CmBx_ForPadre = CmBx_ForPadre;
    }
    public JComboBox<String> getCmBx_NvAcademico() {
        return CmBx_NvAcademico;
    }

    public void setCmBx_NvAcademico(JComboBox<String> CmBx_NvAcademico) {
        this.CmBx_NvAcademico = CmBx_NvAcademico;
    }

    public JComboBox<String> getCmBx_Parentesco() {
        return CmBx_Parentesco;
    }

    public void setCmBx_Parentesco(JComboBox<String> CmBx_Parentesco) {
        this.CmBx_Parentesco = CmBx_Parentesco;
    }

    public JComboBox<String> getCmBx_SecEconomico() {
        return CmBx_SecEconomico;
    }

    public void setCmBx_SecEconomico(JComboBox<String> CmBx_SecEconomico) {
        this.CmBx_SecEconomico = CmBx_SecEconomico;
    }

    public JComboBox<String> getCmBx_TipoBachillerato() {
        return CmBx_TipoBachillerato;
    }

    public void setCmBx_TipoBachillerato(JComboBox<String> CmBx_TipoBachillerato) {
        this.CmBx_TipoBachillerato = CmBx_TipoBachillerato;
    }

    public JComboBox<String> getCmBx_TipoColegio() {
        return CmBx_TipoColegio;
    }

    public void setCmBx_TipoColegio(JComboBox<String> CmBx_TipoColegio) {
        this.CmBx_TipoColegio = CmBx_TipoColegio;
    }

    public JSpinner getSpnr_Anio() {
        return Spnr_Anio;
    }

    public void setSpnr_Anio(JSpinner Spnr_Anio) {
        this.Spnr_Anio = Spnr_Anio;
    }

    public JTextField getTxt_Cedula() {
        return Txt_Cedula;
    }

    public void setTxt_Cedula(JTextField Txt_Cedula) {
        this.Txt_Cedula = Txt_Cedula;
    }

    public JTextField getTxt_ConEmergency() {
        return Txt_ConEmergency;
    }

    public void setTxt_ConEmergency(JTextField Txt_ConEmergency) {
        this.Txt_ConEmergency = Txt_ConEmergency;
    }

    public JTextField getTxt_Nombre() {
        return Txt_Nombre;
    }

    public void setTxt_Nombre(JTextField Txt_Nombre) {
        this.Txt_Nombre = Txt_Nombre;
    }

    public JTextField getTxt_NomContacto() {
        return Txt_NomContacto;
    }

    public void setTxt_NomContacto(JTextField Txt_NumContacto) {
        this.Txt_NomContacto = Txt_NumContacto;
    }

    public JTextField getTxt_Ocupacion() {
        return Txt_Ocupacion;
    }

    public void setTxt_Ocupacion(JTextField Txt_Ocupacion) {
        this.Txt_Ocupacion = Txt_Ocupacion;
    }

    public JTextField getTxt_TlSuperior() {
        return Txt_TlSuperior;
    }

    public void setTxt_TlSuperior(JTextField Txt_TlSuperior) {
        this.Txt_TlSuperior = Txt_TlSuperior;
    }

    public JLabel getjLabel12() {
        return jLabel12;
    }

    public void setjLabel12(JLabel jLabel12) {
        this.jLabel12 = jLabel12;
    }

    public JLabel getjLabel13() {
        return jLabel13;
    }

    public void setjLabel13(JLabel jLabel13) {
        this.jLabel13 = jLabel13;
    }

    public JLabel getjLabel14() {
        return jLabel14;
    }

    public void setjLabel14(JLabel jLabel14) {
        this.jLabel14 = jLabel14;
    }

    public JLabel getjLabel15() {
        return jLabel15;
    }

    public void setjLabel15(JLabel jLabel15) {
        this.jLabel15 = jLabel15;
    }

    public JLabel getjLabel19() {
        return jLabel19;
    }

    public void setjLabel19(JLabel jLabel19) {
        this.jLabel19 = jLabel19;
    }

    public JLabel getjLabel2() {
        return jLabel2;
    }

    public void setjLabel2(JLabel jLabel2) {
        this.jLabel2 = jLabel2;
    }

    public JLabel getjLabel20() {
        return jLabel20;
    }

    public void setjLabel20(JLabel jLabel20) {
        this.jLabel20 = jLabel20;
    }

    public JLabel getjLabel21() {
        return jLabel21;
    }

    public void setjLabel21(JLabel jLabel21) {
        this.jLabel21 = jLabel21;
    }

    public JLabel getjLabel22() {
        return jLabel22;
    }

    public void setjLabel22(JLabel jLabel22) {
        this.jLabel22 = jLabel22;
    }

    public JLabel getjLabel23() {
        return jLabel23;
    }

    public void setjLabel23(JLabel jLabel23) {
        this.jLabel23 = jLabel23;
    }

    public JLabel getjLabel3() {
        return jLabel3;
    }

    public void setjLabel3(JLabel jLabel3) {
        this.jLabel3 = jLabel3;
    }

    public JLabel getjLabel4() {
        return jLabel4;
    }

    public void setjLabel4(JLabel jLabel4) {
        this.jLabel4 = jLabel4;
    }

    public JLabel getjLabel5() {
        return jLabel5;
    }

    public void setjLabel5(JLabel jLabel5) {
        this.jLabel5 = jLabel5;
    }

    public JLabel getjLabel6() {
        return jLabel6;
    }

    public void setjLabel6(JLabel jLabel6) {
        this.jLabel6 = jLabel6;
    }

    public JLabel getjLabel7() {
        return jLabel7;
    }

    public void setjLabel7(JLabel jLabel7) {
        this.jLabel7 = jLabel7;
    }

    public JLabel getjLabel8() {
        return jLabel8;
    }

    public void setjLabel8(JLabel jLabel8) {
        this.jLabel8 = jLabel8;
    }

    public JLabel getjLabel9() {
        return jLabel9;
    }

    public void setjLabel9(JLabel jLabel9) {
        this.jLabel9 = jLabel9;
    }

    public JPanel getjPanel1() {
        return jPanel1;
    }

    public void setjPanel1(JPanel jPanel1) {
        this.jPanel1 = jPanel1;
    }

    public JSeparator getjSeparator1() {
        return jSeparator1;
    }

    public void setjSeparator1(JSeparator jSeparator1) {
        this.jSeparator1 = jSeparator1;
    }

    public JSeparator getjSeparator2() {
        return jSeparator2;
    }

    public void setjSeparator2(JSeparator jSeparator2) {
        this.jSeparator2 = jSeparator2;
    }

    public JSeparator getjSeparator3() {
        return jSeparator3;
    }

    public void setjSeparator3(JSeparator jSeparator3) {
        this.jSeparator3 = jSeparator3;
    }

    public JLabel getLbl_ErrCedula() {
        return Lbl_ErrCedula;
    }

    public void setLbl_ErrCedula(JLabel Lbl_ErrCedula) {
        this.Lbl_ErrCedula = Lbl_ErrCedula;
    }

    public JLabel getLbl_ErrConEmergencia() {
        return Lbl_ErrConEmergencia;
    }

    public void setLbl_ErrConEmergencia(JLabel Lbl_ErrConEmergencia) {
        this.Lbl_ErrConEmergencia = Lbl_ErrConEmergencia;
    }

    public JLabel getLbl_ErrForMadre() {
        return Lbl_ErrForMadre;
    }

    public void setLbl_ErrForMadre(JLabel Lbl_ErrForMadre) {
        this.Lbl_ErrForMadre = Lbl_ErrForMadre;
    }

    public JLabel getLbl_ErrForPadre() {
        return Lbl_ErrForPadre;
    }

    public void setLbl_ErrForPadre(JLabel Lbl_ErrForPadre) {
        this.Lbl_ErrForPadre = Lbl_ErrForPadre;
    }

    public JLabel getLbl_ErrNomContacto() {
        return Lbl_ErrNomContacto;
    }

    public void setLbl_ErrNomContacto(JLabel Lbl_ErrNomContacto) {
        this.Lbl_ErrNomContacto = Lbl_ErrNomContacto;
    }

    public JLabel getLbl_ErrNvAcademico() {
        return Lbl_ErrNvAcademico;
    }

    public void setLbl_ErrNvAcademico(JLabel Lbl_ErrNvAcademico) {
        this.Lbl_ErrNvAcademico = Lbl_ErrNvAcademico;
    }

    public JLabel getLbl_ErrOcupacion() {
        return Lbl_ErrOcupacion;
    }

    public void setLbl_ErrOcupacion(JLabel Lbl_ErrOcupacion) {
        this.Lbl_ErrOcupacion = Lbl_ErrOcupacion;
    }

    public JLabel getLbl_ErrParentesco() {
        return Lbl_ErrParentesco;
    }

    public void setLbl_ErrParentesco(JLabel Lbl_ErrParentesco) {
        this.Lbl_ErrParentesco = Lbl_ErrParentesco;
    }

    public JLabel getLbl_ErrSecEconomico() {
        return Lbl_ErrSecEconomico;
    }

    public void setLbl_ErrSecEconomico(JLabel Lbl_ErrSecEconomico) {
        this.Lbl_ErrSecEconomico = Lbl_ErrSecEconomico;
    }

    public JLabel getLbl_ErrTiSuperior() {
        return Lbl_ErrTiSuperior;
    }

    public void setLbl_ErrTiSuperior(JLabel Lbl_ErrTiSuperior) {
        this.Lbl_ErrTiSuperior = Lbl_ErrTiSuperior;
    }

    public JLabel getLbl_ErrTipBachillerato() {
        return Lbl_ErrTipBachillerato;
    }

    public void setLbl_ErrTipBachillerato(JLabel Lbl_ErrTipBachillerato) {
        this.Lbl_ErrTipBachillerato = Lbl_ErrTipBachillerato;
    }

    public JLabel getLbl_ErrTipColegio() {
        return Lbl_ErrTipColegio;
    }

    public void setLbl_ErrTipColegio(JLabel Lbl_ErrTipColegio) {
        this.Lbl_ErrTipColegio = Lbl_ErrTipColegio;
    }



    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btn_Buscar;
    private javax.swing.JButton Btn_Cancelar;
    private javax.swing.JButton Btn_Guardar;
    private javax.swing.JCheckBox ChkBx_EdcSuperior;
    private javax.swing.JCheckBox ChkBx_Pension;
    private javax.swing.JCheckBox ChkBx_Trabaja;
    private javax.swing.JComboBox<String> CmBx_ForMadre;
    private javax.swing.JComboBox<String> CmBx_ForPadre;
    private javax.swing.JComboBox<String> CmBx_NvAcademico;
    private javax.swing.JComboBox<String> CmBx_Parentesco;
    private javax.swing.JComboBox<String> CmBx_SecEconomico;
    private javax.swing.JComboBox<String> CmBx_TipoBachillerato;
    private javax.swing.JComboBox<String> CmBx_TipoColegio;
    private javax.swing.JLabel Lbl_ErrCedula;
    private javax.swing.JLabel Lbl_ErrConEmergencia;
    private javax.swing.JLabel Lbl_ErrForMadre;
    private javax.swing.JLabel Lbl_ErrForPadre;
    private javax.swing.JLabel Lbl_ErrNomContacto;
    private javax.swing.JLabel Lbl_ErrNvAcademico;
    private javax.swing.JLabel Lbl_ErrOcupacion;
    private javax.swing.JLabel Lbl_ErrParentesco;
    private javax.swing.JLabel Lbl_ErrSecEconomico;
    private javax.swing.JLabel Lbl_ErrTiSuperior;
    private javax.swing.JLabel Lbl_ErrTipBachillerato;
    private javax.swing.JLabel Lbl_ErrTipColegio;
    private javax.swing.JSpinner Spnr_Anio;
    private javax.swing.JTextField Txt_Cedula;
    private javax.swing.JTextField Txt_ConEmergency;
    private javax.swing.JTextField Txt_NomContacto;
    private javax.swing.JTextField Txt_Nombre;
    private javax.swing.JTextField Txt_Ocupacion;
    private javax.swing.JTextField Txt_TlSuperior;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    // End of variables declaration//GEN-END:variables
}
