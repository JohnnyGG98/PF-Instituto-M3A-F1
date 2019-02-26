/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.prdlectivo;

import datechooser.beans.DateChooserCombo;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JTextField;

/**
 *
 * @author Johnny
 */
public class FrmPrdLectivo extends javax.swing.JInternalFrame {

    /**
     * Creates new form FrmPrdLectivo
     */
    public FrmPrdLectivo() {
        initComponents();
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

    public JComboBox<String> getCbx_Carreras() {
        return Cbx_Carreras;
    }

    public void setCbx_Carreras(JComboBox<String> Cbx_Carreras) {
        this.Cbx_Carreras = Cbx_Carreras;
    }

    public DateChooserCombo getDcr_FecConclusion() {
        return Dcr_FecConclusion;
    }

    public void setDcr_FecConclusion(DateChooserCombo Dcr_FecConclusion) {
        this.Dcr_FecConclusion = Dcr_FecConclusion;
    }

    public DateChooserCombo getDcr_FecInicio() {
        return Dcr_FecInicio;
    }

    public void setDcr_FecInicio(DateChooserCombo Dcr_FecInicio) {
        this.Dcr_FecInicio = Dcr_FecInicio;
    }

    public JTextField getTxt_Nombre() {
        return Txt_Nombre;
    }

    public void setTxt_Nombre(JTextField Txt_Nombre) {
        this.Txt_Nombre = Txt_Nombre;
    }

    public JLabel getjLabel1() {
        return jLabel1;
    }

    public void setjLabel1(JLabel jLabel1) {
        this.jLabel1 = jLabel1;
    }

    public JLabel getjLabel2() {
        return jLabel2;
    }

    public void setjLabel2(JLabel jLabel2) {
        this.jLabel2 = jLabel2;
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

    public JSeparator getjSeparator1() {
        return jSeparator1;
    }

    public void setjSeparator1(JSeparator jSeparator1) {
        this.jSeparator1 = jSeparator1;
    }

    public JTextField getTxtObservacion() {
        return txtObservacion;
    }

    public void setTxtObservacion(JTextField txtObservacion) {
        this.txtObservacion = txtObservacion;
    }

    public JLabel getLbl_ErrCarrera() {
        return Lbl_ErrCarrera;
    }

    public void setLbl_ErrCarrera(JLabel Lbl_ErrCarrera) {
        this.Lbl_ErrCarrera = Lbl_ErrCarrera;
    }

    public JLabel getLbl_ErrNombre() {
        return Lbl_ErrNombre;
    }

    public void setLbl_ErrNombre(JLabel Lbl_ErrNombre) {
        this.Lbl_ErrNombre = Lbl_ErrNombre;
    }

    public JLabel getLbl_ErrObservacion() {
        return Lbl_ErrObservacion;
    }

    public void setLbl_ErrObservacion(JLabel Lbl_ErrObservacion) {
        this.Lbl_ErrObservacion = Lbl_ErrObservacion;
    }

    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        txtObservacion = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        Btn_Guardar = new javax.swing.JButton();
        Btn_Cancelar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        Txt_Nombre = new javax.swing.JTextField();
        Cbx_Carreras = new javax.swing.JComboBox<>();
        Dcr_FecInicio = new datechooser.beans.DateChooserCombo();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Dcr_FecConclusion = new datechooser.beans.DateChooserCombo();
        Lbl_ErrCarrera = new javax.swing.JLabel();
        Lbl_ErrNombre = new javax.swing.JLabel();
        Lbl_ErrObservacion = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setTitle("Formulario Periodo Lectivo");

        jLabel4.setText("Observación:");

        Btn_Guardar.setText("Guardar");

        Btn_Cancelar.setText("Cancelar");

        jLabel5.setText("Carrera:");

        jLabel6.setText("Nombre:");

        Cbx_Carreras.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "|SELECCIONE|" }));

        try {
            Dcr_FecInicio.setDefaultPeriods(new datechooser.model.multiple.PeriodSet(new datechooser.model.multiple.Period(new java.util.GregorianCalendar(2019, 1, 1),
                new java.util.GregorianCalendar(2019, 1, 1))));
    } catch (datechooser.model.exeptions.IncompatibleDataExeption e1) {
        e1.printStackTrace();
    }

    jLabel1.setText("Fecha de Inicio:");

    jLabel2.setText("Fecha de Conclusion:");

    try {
        Dcr_FecConclusion.setDefaultPeriods(new datechooser.model.multiple.PeriodSet(new datechooser.model.multiple.Period(new java.util.GregorianCalendar(2019, 1, 1),
            new java.util.GregorianCalendar(2019, 1, 1))));
} catch (datechooser.model.exeptions.IncompatibleDataExeption e1) {
    e1.printStackTrace();
    }

    Lbl_ErrCarrera.setForeground(new java.awt.Color(204, 0, 0));
    Lbl_ErrCarrera.setText("Seleccione una Carrera");

    Lbl_ErrNombre.setForeground(new java.awt.Color(204, 0, 0));
    Lbl_ErrNombre.setText("Ingrese solo letras");

    Lbl_ErrObservacion.setForeground(new java.awt.Color(204, 0, 0));
    Lbl_ErrObservacion.setText("Ingrese solo letras");

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jLabel4)
                    .addGap(53, 53, 53)
                    .addComponent(txtObservacion))
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel5)
                            .addGap(91, 91, 91)
                            .addComponent(Cbx_Carreras, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel1)
                                .addComponent(jLabel6))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(Dcr_FecInicio, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Dcr_FecConclusion, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Txt_Nombre, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addContainerGap())
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addComponent(Lbl_ErrCarrera)
                    .addGap(135, 135, 135))
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addComponent(Lbl_ErrNombre)
                    .addGap(143, 143, 143))
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addComponent(Lbl_ErrObservacion)
                    .addGap(146, 146, 146))))
        .addComponent(jSeparator1)
        .addGroup(layout.createSequentialGroup()
            .addGap(83, 83, 83)
            .addComponent(Btn_Guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(143, 143, 143)
            .addComponent(Btn_Cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addGap(14, 14, 14)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel5)
                .addComponent(Cbx_Carreras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(Lbl_ErrCarrera)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel6)
                .addComponent(Txt_Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(Lbl_ErrNombre)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel1)
                .addComponent(Dcr_FecInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(18, 18, 18)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel2)
                .addComponent(Dcr_FecConclusion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(18, 18, 18)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(txtObservacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel4))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(Lbl_ErrObservacion)
            .addGap(18, 18, 18)
            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(18, 18, 18)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(Btn_Guardar)
                .addComponent(Btn_Cancelar))
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btn_Cancelar;
    private javax.swing.JButton Btn_Guardar;
    private javax.swing.JComboBox<String> Cbx_Carreras;
    private datechooser.beans.DateChooserCombo Dcr_FecConclusion;
    private datechooser.beans.DateChooserCombo Dcr_FecInicio;
    private javax.swing.JLabel Lbl_ErrCarrera;
    private javax.swing.JLabel Lbl_ErrNombre;
    private javax.swing.JLabel Lbl_ErrObservacion;
    private javax.swing.JTextField Txt_Nombre;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField txtObservacion;
    // End of variables declaration//GEN-END:variables
}
