/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.materia;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Lina
 */
public class FrmMaterias extends javax.swing.JInternalFrame {

    /**
     * Creates new form FrmMaterias
     */
    public FrmMaterias() {
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
        btnCancelar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        Btn_Anterior = new javax.swing.JButton();
        jTPMaterias = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        lblNombreMateria = new javax.swing.JLabel();
        txtCodigoMateria = new javax.swing.JTextField();
        cbTipoAcreditacion = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        lblCategoriaMateria = new javax.swing.JLabel();
        lblActivo = new javax.swing.JLabel();
        lblCiclo = new javax.swing.JLabel();
        chBNucleo = new javax.swing.JCheckBox();
        lblCategoriaMateria1 = new javax.swing.JLabel();
        lblCategoriaMateria2 = new javax.swing.JLabel();
        lblCategoriaMateria4 = new javax.swing.JLabel();
        lblCategoriaMateria5 = new javax.swing.JLabel();
        cbMateriaTipo = new javax.swing.JComboBox<>();
        cbCategoria = new javax.swing.JComboBox<>();
        txtCreditos = new javax.swing.JTextField();
        cbEjeFormacion = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        cbCarrera = new javax.swing.JComboBox<>();
        txtNombreMateria = new javax.swing.JTextField();
        lblErrorCarrera = new javax.swing.JLabel();
        lblErrorCodigoMateria = new javax.swing.JLabel();
        lblErrorNombreMateria = new javax.swing.JLabel();
        lblErrorMateriaCiclo = new javax.swing.JLabel();
        lblErrorCreditos = new javax.swing.JLabel();
        lblErrorEjeFormacion = new javax.swing.JLabel();
        lblErrorMateriaTipo = new javax.swing.JLabel();
        lblErrorCategoria = new javax.swing.JLabel();
        lblErrorTipoAcreditacion = new javax.swing.JLabel();
        Cbx_Ciclo = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        lblTeoricas = new javax.swing.JLabel();
        lblPracticas = new javax.swing.JLabel();
        lblAutoEvaluacion = new javax.swing.JLabel();
        lblTeoricas1 = new javax.swing.JLabel();
        lblTeoricas2 = new javax.swing.JLabel();
        txtHorasDocencia = new javax.swing.JTextField();
        txtHorasPracticas = new javax.swing.JTextField();
        txtHorasAutoEstudio = new javax.swing.JTextField();
        txtTotalHoras = new javax.swing.JTextField();
        txtHorasPresenciales = new javax.swing.JTextField();
        lblErrorHorasDocencia = new javax.swing.JLabel();
        lblErrorHorasPracticas = new javax.swing.JLabel();
        lblErrorHorasPresenciales = new javax.swing.JLabel();
        lblErrorHorasAutoEstudio = new javax.swing.JLabel();
        lblErrorTotalHoras = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lblTeoricas3 = new javax.swing.JLabel();
        lblTeoricas5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtObjetivoEspecifico = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtObjetivoGeneral = new javax.swing.JTextArea();
        lblErrorObjetivoGeneral = new javax.swing.JLabel();
        lblErrorObjetivoEspecifico = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        lblTeoricas4 = new javax.swing.JLabel();
        lblTeoricas6 = new javax.swing.JLabel();
        lblTeoricas7 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtDescripcionMateria = new javax.swing.JTextArea();
        lblErrorDescripcionMateria = new javax.swing.JLabel();
        lblErrorOrganizacionCurricular = new javax.swing.JLabel();
        lblErrorCampoFormacion = new javax.swing.JLabel();
        Cbx_OrgCurricular = new javax.swing.JComboBox<>();
        Cbx_CamFormacion = new javax.swing.JComboBox<>();

        setClosable(true);
        setIconifiable(true);
        setTitle("Ingreso de Materias");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnCancelar.setText("Cancelar");

        btnGuardar.setText("Guardar");

        Btn_Anterior.setText("Anterior");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(413, Short.MAX_VALUE)
                .addComponent(btnCancelar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Btn_Anterior)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnGuardar)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnGuardar)
                    .addComponent(Btn_Anterior))
                .addGap(32, 32, 32))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, 690, 40));

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblNombreMateria.setText("Nombre de Materia *");
        jPanel3.add(lblNombreMateria, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, -1, -1));

        txtCodigoMateria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoMateriaActionPerformed(evt);
            }
        });
        jPanel3.add(txtCodigoMateria, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 130, 177, 20));

        cbTipoAcreditacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECCIONE", "Tipos" }));
        jPanel3.add(cbTipoAcreditacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(487, 177, 178, -1));

        jLabel4.setText("Eje de Formación *");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        lblCategoriaMateria.setText("Categoría");
        jPanel3.add(lblCategoriaMateria, new org.netbeans.lib.awtextra.AbsoluteConstraints(352, 128, -1, -1));

        lblActivo.setText("Materia Núcleo");
        jPanel3.add(lblActivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(352, 229, -1, 21));

        lblCiclo.setText("Ciclo *");
        jPanel3.add(lblCiclo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, -1, -1));
        jPanel3.add(chBNucleo, new org.netbeans.lib.awtextra.AbsoluteConstraints(487, 229, -1, -1));

        lblCategoriaMateria1.setText("Tipo de Acreditación *");
        jPanel3.add(lblCategoriaMateria1, new org.netbeans.lib.awtextra.AbsoluteConstraints(352, 180, -1, -1));

        lblCategoriaMateria2.setText("Materia Tipo");
        jPanel3.add(lblCategoriaMateria2, new org.netbeans.lib.awtextra.AbsoluteConstraints(352, 72, -1, -1));

        lblCategoriaMateria4.setText("Créditos *");
        jPanel3.add(lblCategoriaMateria4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, -1, -1));

        lblCategoriaMateria5.setText("Código de Materia *");
        jPanel3.add(lblCategoriaMateria5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, -1));

        cbMateriaTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECCIONE" }));
        jPanel3.add(cbMateriaTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(485, 70, 178, -1));

        cbCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECCIONE", "BÁSICO", "PROFESIONAL", "TITULACIÓN" }));
        cbCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCategoriaActionPerformed(evt);
            }
        });
        jPanel3.add(cbCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(485, 125, 178, -1));

        txtCreditos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCreditosActionPerformed(evt);
            }
        });
        jPanel3.add(txtCreditos, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 280, 176, -1));

        cbEjeFormacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECCIONE" }));
        cbEjeFormacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbEjeFormacionActionPerformed(evt);
            }
        });
        jPanel3.add(cbEjeFormacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 70, 178, -1));

        jLabel5.setText("Carrera *");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 23, -1, -1));

        cbCarrera.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECCIONE" }));
        cbCarrera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCarreraActionPerformed(evt);
            }
        });
        jPanel3.add(cbCarrera, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, 510, -1));

        txtNombreMateria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreMateriaActionPerformed(evt);
            }
        });
        jPanel3.add(txtNombreMateria, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 180, 177, -1));

        lblErrorCarrera.setForeground(new java.awt.Color(204, 0, 0));
        lblErrorCarrera.setText("Seleccione una carrera");
        jPanel3.add(lblErrorCarrera, new org.netbeans.lib.awtextra.AbsoluteConstraints(147, 43, -1, -1));

        lblErrorCodigoMateria.setForeground(new java.awt.Color(204, 0, 0));
        lblErrorCodigoMateria.setText("Ingrese solo letras");
        jPanel3.add(lblErrorCodigoMateria, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 150, -1, -1));

        lblErrorNombreMateria.setForeground(new java.awt.Color(204, 0, 0));
        lblErrorNombreMateria.setText("Ingrese solo letras");
        jPanel3.add(lblErrorNombreMateria, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 200, -1, -1));

        lblErrorMateriaCiclo.setForeground(new java.awt.Color(204, 0, 0));
        lblErrorMateriaCiclo.setText("Seleccione un Ciclo");
        jPanel3.add(lblErrorMateriaCiclo, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 250, -1, -1));

        lblErrorCreditos.setForeground(new java.awt.Color(204, 0, 0));
        lblErrorCreditos.setText("Ingrese solo números");
        jPanel3.add(lblErrorCreditos, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 300, -1, 20));

        lblErrorEjeFormacion.setForeground(new java.awt.Color(204, 0, 0));
        lblErrorEjeFormacion.setText("Seleccione un Eje de Formación");
        jPanel3.add(lblErrorEjeFormacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, -1, -1));

        lblErrorMateriaTipo.setForeground(new java.awt.Color(204, 0, 0));
        lblErrorMateriaTipo.setText("Seleccion un Tipo");
        jPanel3.add(lblErrorMateriaTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(485, 99, -1, -1));

        lblErrorCategoria.setForeground(new java.awt.Color(204, 0, 0));
        lblErrorCategoria.setText("Seleccione una Categoría");
        jPanel3.add(lblErrorCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(485, 154, -1, -1));

        lblErrorTipoAcreditacion.setForeground(new java.awt.Color(204, 0, 0));
        lblErrorTipoAcreditacion.setText("Seleccione un Tipo de Acreditación");
        jPanel3.add(lblErrorTipoAcreditacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 200, -1, -1));

        Cbx_Ciclo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECCIONE", "Ciclo 1", "Ciclo 2", "Ciclo 3", "Ciclo 4", "Ciclo 5" }));
        jPanel3.add(Cbx_Ciclo, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 230, 170, -1));

        jTPMaterias.addTab("Datos Principales", jPanel3);

        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTeoricas.setText("Horas de Docencia *");
        jPanel4.add(lblTeoricas, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 40, -1, -1));

        lblPracticas.setText("Horas Prácticas *");
        jPanel4.add(lblPracticas, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 90, -1, -1));

        lblAutoEvaluacion.setText("Horas de Auto-Estudio *");
        jPanel4.add(lblAutoEvaluacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 190, -1, -1));

        lblTeoricas1.setText("Horas Presenciales *");
        jPanel4.add(lblTeoricas1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 140, -1, -1));

        lblTeoricas2.setText("Total de Horas *");
        jPanel4.add(lblTeoricas2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 240, -1, -1));
        jPanel4.add(txtHorasDocencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 40, 137, -1));

        txtHorasPracticas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHorasPracticasActionPerformed(evt);
            }
        });
        jPanel4.add(txtHorasPracticas, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 90, 137, -1));
        jPanel4.add(txtHorasAutoEstudio, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 190, 137, -1));

        txtTotalHoras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalHorasActionPerformed(evt);
            }
        });
        jPanel4.add(txtTotalHoras, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 240, 137, -1));
        jPanel4.add(txtHorasPresenciales, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 140, 137, -1));

        lblErrorHorasDocencia.setForeground(new java.awt.Color(204, 0, 0));
        lblErrorHorasDocencia.setText("Ingrese solo números");
        jPanel4.add(lblErrorHorasDocencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 60, -1, -1));

        lblErrorHorasPracticas.setForeground(new java.awt.Color(204, 0, 0));
        lblErrorHorasPracticas.setText("Ingrese solo números");
        jPanel4.add(lblErrorHorasPracticas, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 110, -1, -1));

        lblErrorHorasPresenciales.setForeground(new java.awt.Color(204, 0, 0));
        lblErrorHorasPresenciales.setText("Ingrese solo números");
        jPanel4.add(lblErrorHorasPresenciales, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 160, -1, -1));

        lblErrorHorasAutoEstudio.setForeground(new java.awt.Color(204, 0, 0));
        lblErrorHorasAutoEstudio.setText("Ingrese solo números");
        jPanel4.add(lblErrorHorasAutoEstudio, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 220, -1, -1));

        lblErrorTotalHoras.setForeground(new java.awt.Color(204, 0, 0));
        lblErrorTotalHoras.setText("Ingrese solo números");
        jPanel4.add(lblErrorTotalHoras, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 270, -1, -1));

        jTPMaterias.addTab("Horas de Materia", jPanel4);

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTeoricas3.setText("Objetivo General *");
        jPanel2.add(lblTeoricas3, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 13, -1, -1));

        lblTeoricas5.setText("Objetivo Específico*");
        jPanel2.add(lblTeoricas5, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 10, -1, -1));

        txtObjetivoEspecifico.setColumns(20);
        txtObjetivoEspecifico.setRows(5);
        jScrollPane1.setViewportView(txtObjetivoEspecifico);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 40, 320, 220));

        txtObjetivoGeneral.setColumns(20);
        txtObjetivoGeneral.setRows(5);
        jScrollPane2.setViewportView(txtObjetivoGeneral);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 320, 220));

        lblErrorObjetivoGeneral.setForeground(new java.awt.Color(204, 0, 0));
        lblErrorObjetivoGeneral.setText("Ingrese solo letras");
        jPanel2.add(lblErrorObjetivoGeneral, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, -1, -1));

        lblErrorObjetivoEspecifico.setForeground(new java.awt.Color(204, 0, 0));
        lblErrorObjetivoEspecifico.setText("Ingrese solo letras");
        jPanel2.add(lblErrorObjetivoEspecifico, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 270, -1, -1));

        jTPMaterias.addTab("Observaciones", jPanel2);

        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTeoricas4.setText("Descripción de la Materia *");
        jPanel5.add(lblTeoricas4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));

        lblTeoricas6.setText("Organización Curricular *");
        jPanel5.add(lblTeoricas6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, -1));

        lblTeoricas7.setText("Campo de Formación *");
        jPanel5.add(lblTeoricas7, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 30, -1, -1));

        txtDescripcionMateria.setColumns(20);
        txtDescripcionMateria.setRows(5);
        jScrollPane4.setViewportView(txtDescripcionMateria);

        jPanel5.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 650, 130));

        lblErrorDescripcionMateria.setForeground(new java.awt.Color(204, 0, 0));
        lblErrorDescripcionMateria.setText("Ingrese solo letras");
        jPanel5.add(lblErrorDescripcionMateria, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, -1, -1));

        lblErrorOrganizacionCurricular.setForeground(new java.awt.Color(204, 0, 0));
        lblErrorOrganizacionCurricular.setText("Seleccione una Organización");
        jPanel5.add(lblErrorOrganizacionCurricular, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, -1));

        lblErrorCampoFormacion.setForeground(new java.awt.Color(204, 0, 0));
        lblErrorCampoFormacion.setText("Ingrese solo letras");
        jPanel5.add(lblErrorCampoFormacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 80, -1, -1));

        Cbx_OrgCurricular.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECCIONE", "ejemplo" }));
        Cbx_OrgCurricular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cbx_OrgCurricularActionPerformed(evt);
            }
        });
        jPanel5.add(Cbx_OrgCurricular, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 220, -1));

        Cbx_CamFormacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECCIONE", "EJEMPLO" }));
        jPanel5.add(Cbx_CamFormacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 60, 220, -1));

        jTPMaterias.addTab("Finalización", jPanel5);

        getContentPane().add(jTPMaterias, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 690, 360));
        jTPMaterias.getAccessibleContext().setAccessibleName("Datos Relevantes");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCodigoMateriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoMateriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoMateriaActionPerformed

    private void txtCreditosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCreditosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCreditosActionPerformed

    private void cbEjeFormacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbEjeFormacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbEjeFormacionActionPerformed

    private void cbCarreraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCarreraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbCarreraActionPerformed

    private void txtNombreMateriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreMateriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreMateriaActionPerformed

    private void cbCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCategoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbCategoriaActionPerformed

    private void txtTotalHorasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalHorasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalHorasActionPerformed

    private void Cbx_OrgCurricularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cbx_OrgCurricularActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Cbx_OrgCurricularActionPerformed

    private void txtHorasPracticasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHorasPracticasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHorasPracticasActionPerformed

    public JButton getBtnCancelar() {
        return btnCancelar;
    }

    public void setBtnCancelar(JButton btnCancelar) {
        this.btnCancelar = btnCancelar;
    }

    public JButton getBtnGuardar() {
        return btnGuardar;
    }

    public void setBtnGuardar(JButton btnGuardar) {
        this.btnGuardar = btnGuardar;
    }

    public JComboBox<String> getCbCarrera() {
        return cbCarrera;
    }

    public void setCbCarrera(JComboBox<String> cbCarrera) {
        this.cbCarrera = cbCarrera;
    }

    public JComboBox<String> getCbCategoria() {
        return cbCategoria;
    }

    public void setCbCategoria(JComboBox<String> cbCategoria) {
        this.cbCategoria = cbCategoria;
    }

    public JComboBox<String> getCbEjeFormacion() {
        return cbEjeFormacion;
    }

    public JTabbedPane getjTPMaterias() {
        return jTPMaterias;
    }

    public void setjTPMaterias(JTabbedPane jTPMaterias) {
        this.jTPMaterias = jTPMaterias;
    }

    public void setCbEjeFormacion(JComboBox<String> cbEjeFormacion) {
        this.cbEjeFormacion = cbEjeFormacion;
    }

    public JComboBox<String> getCbMateriaTipo() {
        return cbMateriaTipo;
    }

    public void setCbMateriaTipo(JComboBox<String> cbMateriaTipo) {
        this.cbMateriaTipo = cbMateriaTipo;
    }

    public JComboBox<String> getCbTipoAcreditacion() {
        return cbTipoAcreditacion;
    }

    public void setCbTipoAcreditacion(JComboBox<String> cbTipoAcreditacion) {
        this.cbTipoAcreditacion = cbTipoAcreditacion;
    }

    public JCheckBox getChBNucleo() {
        return chBNucleo;
    }

    public void setChBNucleo(JCheckBox chBNucleo) {
        this.chBNucleo = chBNucleo;
    }

    public JTabbedPane getjTabbedPane1() {
        return jTPMaterias;
    }

    public void setjTabbedPane1(JTabbedPane jTabbedPane1) {
        this.jTPMaterias = jTabbedPane1;
    }

    public JLabel getLblActivo() {
        return lblActivo;
    }

    public void setLblActivo(JLabel lblActivo) {
        this.lblActivo = lblActivo;
    }

    public JLabel getLblAutoEvaluacion() {
        return lblAutoEvaluacion;
    }

    public void setLblAutoEvaluacion(JLabel lblAutoEvaluacion) {
        this.lblAutoEvaluacion = lblAutoEvaluacion;
    }

    public JLabel getLblCiclo() {
        return lblCiclo;
    }

    public void setLblCiclo(JLabel lblCiclo) {
        this.lblCiclo = lblCiclo;
    }

    public JLabel getLblErrorCampoFormacion() {
        return lblErrorCampoFormacion;
    }

    public void setLblErrorCampoFormacion(JLabel lblErrorCampoFormacion) {
        this.lblErrorCampoFormacion = lblErrorCampoFormacion;
    }

    public JLabel getLblErrorCarrera() {
        return lblErrorCarrera;
    }

    public void setLblErrorCarrera(JLabel lblErrorCarrera) {
        this.lblErrorCarrera = lblErrorCarrera;
    }

    public JLabel getLblErrorCategoria() {
        return lblErrorCategoria;
    }

    public void setLblErrorCategoria(JLabel lblErrorCategoria) {
        this.lblErrorCategoria = lblErrorCategoria;
    }

    public JLabel getLblErrorCodigoMateria() {
        return lblErrorCodigoMateria;
    }

    public void setLblErrorCodigoMateria(JLabel lblErrorCodigoMateria) {
        this.lblErrorCodigoMateria = lblErrorCodigoMateria;
    }

    public JLabel getLblErrorCreditos() {
        return lblErrorCreditos;
    }

    public void setLblErrorCreditos(JLabel lblErrorCreditos) {
        this.lblErrorCreditos = lblErrorCreditos;
    }

    public JLabel getLblErrorDescripcionMateria() {
        return lblErrorDescripcionMateria;
    }

    public void setLblErrorDescripcionMateria(JLabel lblErrorDescripcionMateria) {
        this.lblErrorDescripcionMateria = lblErrorDescripcionMateria;
    }

    public JLabel getLblErrorEjeFormacion() {
        return lblErrorEjeFormacion;
    }

    public void setLblErrorEjeFormacion(JLabel lblErrorEjeFormacion) {
        this.lblErrorEjeFormacion = lblErrorEjeFormacion;
    }

    public JLabel getLblErrorHorasAutoEstudio() {
        return lblErrorHorasAutoEstudio;
    }

    public void setLblErrorHorasAutoEstudio(JLabel lblErrorHorasAutoEstudio) {
        this.lblErrorHorasAutoEstudio = lblErrorHorasAutoEstudio;
    }

    public JLabel getLblErrorHorasDocencia() {
        return lblErrorHorasDocencia;
    }

    public void setLblErrorHorasDocencia(JLabel lblErrorHorasDocencia) {
        this.lblErrorHorasDocencia = lblErrorHorasDocencia;
    }

    public JLabel getLblErrorHorasPracticas() {
        return lblErrorHorasPracticas;
    }

    public void setLblErrorHorasPracticas(JLabel lblErrorHorasPracticas) {
        this.lblErrorHorasPracticas = lblErrorHorasPracticas;
    }

    public JLabel getLblErrorHorasPresenciales() {
        return lblErrorHorasPresenciales;
    }

    public void setLblErrorHorasPresenciales(JLabel lblErrorHorasPresenciales) {
        this.lblErrorHorasPresenciales = lblErrorHorasPresenciales;
    }

    public JLabel getLblErrorMateriaCiclo() {
        return lblErrorMateriaCiclo;
    }

    public void setLblErrorMateriaCiclo(JLabel lblErrorMateriaCiclo) {
        this.lblErrorMateriaCiclo = lblErrorMateriaCiclo;
    }

    public JLabel getLblErrorMateriaTipo() {
        return lblErrorMateriaTipo;
    }

    public void setLblErrorMateriaTipo(JLabel lblErrorMateriaTipo) {
        this.lblErrorMateriaTipo = lblErrorMateriaTipo;
    }

    public JLabel getLblErrorNombreMateria() {
        return lblErrorNombreMateria;
    }

    public void setLblErrorNombreMateria(JLabel lblErrorNombreMateria) {
        this.lblErrorNombreMateria = lblErrorNombreMateria;
    }

    public JLabel getLblErrorObjetivoEspecifico() {
        return lblErrorObjetivoEspecifico;
    }

    public void setLblErrorObjetivoEspecifico(JLabel lblErrorObjetivoEspecifico) {
        this.lblErrorObjetivoEspecifico = lblErrorObjetivoEspecifico;
    }

    public JLabel getLblErrorObjetivoGeneral() {
        return lblErrorObjetivoGeneral;
    }

    public void setLblErrorObjetivoGeneral(JLabel lblErrorObjetivoGeneral) {
        this.lblErrorObjetivoGeneral = lblErrorObjetivoGeneral;
    }

    public JLabel getLblErrorOrganizacionCurricular() {
        return lblErrorOrganizacionCurricular;
    }

    public void setLblErrorOrganizacionCurricular(JLabel lblErrorOrganizacionCurricular) {
        this.lblErrorOrganizacionCurricular = lblErrorOrganizacionCurricular;
    }

    public JLabel getLblErrorTipoAcreditacion() {
        return lblErrorTipoAcreditacion;
    }

    public void setLblErrorTipoAcreditacion(JLabel lblErrorTipoAcreditacion) {
        this.lblErrorTipoAcreditacion = lblErrorTipoAcreditacion;
    }

    public JLabel getLblErrorTotalHoras() {
        return lblErrorTotalHoras;
    }

    public void setLblErrorTotalHoras(JLabel lblErrorTotalHoras) {
        this.lblErrorTotalHoras = lblErrorTotalHoras;
    }

    public JLabel getLblNombreMateria() {
        return lblNombreMateria;
    }

    public void setLblNombreMateria(JLabel lblNombreMateria) {
        this.lblNombreMateria = lblNombreMateria;
    }

    public JTextField getTxtCodigoMateria() {
        return txtCodigoMateria;
    }

    public void setTxtCodigoMateria(JTextField txtCodigoMateria) {
        this.txtCodigoMateria = txtCodigoMateria;
    }

    public JTextField getTxtCreditos() {
        return txtCreditos;
    }

    public void setTxtCreditos(JTextField txtCreditos) {
        this.txtCreditos = txtCreditos;
    }

    public JTextArea getTxtDescripcionMateria() {
        return txtDescripcionMateria;
    }

    public void setTxtDescripcionMateria(JTextArea txtDescripcionMateria) {
        this.txtDescripcionMateria = txtDescripcionMateria;
    }

    public JTextField getTxtHorasAutoEstudio() {
        return txtHorasAutoEstudio;
    }

    public void setTxtHorasAutoEstudio(JTextField txtHorasAutoEstudio) {
        this.txtHorasAutoEstudio = txtHorasAutoEstudio;
    }

    public JTextField getTxtHorasDocencia() {
        return txtHorasDocencia;
    }

    public void setTxtHorasDocencia(JTextField txtHorasDocencia) {
        this.txtHorasDocencia = txtHorasDocencia;
    }

    public JTextField getTxtHorasPracticas() {
        return txtHorasPracticas;
    }

    public void setTxtHorasPracticas(JTextField txtHorasPracticas) {
        this.txtHorasPracticas = txtHorasPracticas;
    }

    public JTextField getTxtHorasPresenciales() {
        return txtHorasPresenciales;
    }

    public void setTxtHorasPresenciales(JTextField txtHorasPresenciales) {
        this.txtHorasPresenciales = txtHorasPresenciales;
    }

    public JTextField getTxtNombreMateria() {
        return txtNombreMateria;
    }

    public void setTxtNombreMateria(JTextField txtNombreMateria) {
        this.txtNombreMateria = txtNombreMateria;
    }

    public JTextArea getTxtObjetivoEspecifico() {
        return txtObjetivoEspecifico;
    }

    public void setTxtObjetivoEspecifico(JTextArea txtObjetivoEspecifico) {
        this.txtObjetivoEspecifico = txtObjetivoEspecifico;
    }

    public JTextArea getTxtObjetivoGeneral() {
        return txtObjetivoGeneral;
    }

    public void setTxtObjetivoGeneral(JTextArea txtObjetivoGeneral) {
        this.txtObjetivoGeneral = txtObjetivoGeneral;
    }

    public JTextField getTxtTotalHoras() {
        return txtTotalHoras;
    }

    public void setTxtTotalHoras(JTextField txtTotalHoras) {
        this.txtTotalHoras = txtTotalHoras;
    }

    public JButton getBtn_Anterior() {
        return Btn_Anterior;
    }

    public void setBtn_Anterior(JButton Btn_Anterior) {
        this.Btn_Anterior = Btn_Anterior;
    }

    public JComboBox<String> getCbx_CamFormacion() {
        return Cbx_CamFormacion;
    }

    public void setCbx_CamFormacion(JComboBox<String> Cbx_CamFormacion) {
        this.Cbx_CamFormacion = Cbx_CamFormacion;
    }

    public JComboBox<String> getCbx_Ciclo() {
        return Cbx_Ciclo;
    }

    public void setCbx_Ciclo(JComboBox<String> Cbx_Ciclo) {
        this.Cbx_Ciclo = Cbx_Ciclo;
    }

    public JComboBox<String> getCbx_OrgCurricular() {
        return Cbx_OrgCurricular;
    }

    public void setCbx_OrgCurricular(JComboBox<String> Cbx_OrgCurricular) {
        this.Cbx_OrgCurricular = Cbx_OrgCurricular;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btn_Anterior;
    private javax.swing.JComboBox<String> Cbx_CamFormacion;
    private javax.swing.JComboBox<String> Cbx_Ciclo;
    private javax.swing.JComboBox<String> Cbx_OrgCurricular;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<String> cbCarrera;
    private javax.swing.JComboBox<String> cbCategoria;
    private javax.swing.JComboBox<String> cbEjeFormacion;
    private javax.swing.JComboBox<String> cbMateriaTipo;
    private javax.swing.JComboBox<String> cbTipoAcreditacion;
    private javax.swing.JCheckBox chBNucleo;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTPMaterias;
    private javax.swing.JLabel lblActivo;
    private javax.swing.JLabel lblAutoEvaluacion;
    private javax.swing.JLabel lblCategoriaMateria;
    private javax.swing.JLabel lblCategoriaMateria1;
    private javax.swing.JLabel lblCategoriaMateria2;
    private javax.swing.JLabel lblCategoriaMateria4;
    private javax.swing.JLabel lblCategoriaMateria5;
    private javax.swing.JLabel lblCiclo;
    private javax.swing.JLabel lblErrorCampoFormacion;
    private javax.swing.JLabel lblErrorCarrera;
    private javax.swing.JLabel lblErrorCategoria;
    private javax.swing.JLabel lblErrorCodigoMateria;
    private javax.swing.JLabel lblErrorCreditos;
    private javax.swing.JLabel lblErrorDescripcionMateria;
    private javax.swing.JLabel lblErrorEjeFormacion;
    private javax.swing.JLabel lblErrorHorasAutoEstudio;
    private javax.swing.JLabel lblErrorHorasDocencia;
    private javax.swing.JLabel lblErrorHorasPracticas;
    private javax.swing.JLabel lblErrorHorasPresenciales;
    private javax.swing.JLabel lblErrorMateriaCiclo;
    private javax.swing.JLabel lblErrorMateriaTipo;
    private javax.swing.JLabel lblErrorNombreMateria;
    private javax.swing.JLabel lblErrorObjetivoEspecifico;
    private javax.swing.JLabel lblErrorObjetivoGeneral;
    private javax.swing.JLabel lblErrorOrganizacionCurricular;
    private javax.swing.JLabel lblErrorTipoAcreditacion;
    private javax.swing.JLabel lblErrorTotalHoras;
    private javax.swing.JLabel lblNombreMateria;
    private javax.swing.JLabel lblPracticas;
    private javax.swing.JLabel lblTeoricas;
    private javax.swing.JLabel lblTeoricas1;
    private javax.swing.JLabel lblTeoricas2;
    private javax.swing.JLabel lblTeoricas3;
    private javax.swing.JLabel lblTeoricas4;
    private javax.swing.JLabel lblTeoricas5;
    private javax.swing.JLabel lblTeoricas6;
    private javax.swing.JLabel lblTeoricas7;
    private javax.swing.JTextField txtCodigoMateria;
    private javax.swing.JTextField txtCreditos;
    private javax.swing.JTextArea txtDescripcionMateria;
    private javax.swing.JTextField txtHorasAutoEstudio;
    private javax.swing.JTextField txtHorasDocencia;
    private javax.swing.JTextField txtHorasPracticas;
    private javax.swing.JTextField txtHorasPresenciales;
    private javax.swing.JTextField txtNombreMateria;
    private javax.swing.JTextArea txtObjetivoEspecifico;
    private javax.swing.JTextArea txtObjetivoGeneral;
    private javax.swing.JTextField txtTotalHoras;
    // End of variables declaration//GEN-END:variables
}
