/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.silabos;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Daniel
 */
public class frmCRUDAvanceSilabo extends javax.swing.JInternalFrame {

    /**
     * Creates new form frmCRUDAvanceSilabo
     */
    public frmCRUDAvanceSilabo() {
        initComponents();
        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("vista/img/logo.png"));
        this.setFrameIcon(icon);
    }

    public JButton getBtnEditar() {
        return btnEditar;
    }

    public void setBtnEditar(JButton btnEditar) {
        this.btnEditar = btnEditar;
    }

    public JButton getBtnEliminar() {
        return btnEliminar;
    }

    public void setBtnEliminar(JButton btnEliminar) {
        this.btnEliminar = btnEliminar;
    }

    public JButton getBtnNuevo() {
        return btnNuevo;
    }

    public void setBtnNuevo(JButton btnNuevo) {
        this.btnNuevo = btnNuevo;
    }

    public JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    public void setjScrollPane1(JScrollPane jScrollPane1) {
        this.jScrollPane1 = jScrollPane1;
    }

    public JLabel getLblBuscar() {
        return lblBuscar;
    }

    public void setLblBuscar(JLabel lblBuscar) {
        this.lblBuscar = lblBuscar;
    }

    public JTable getTlbAvanceSilabo() {
        return tlbAvanceSilabo;
    }

    public void setTlbAvanceSilabo(JTable tlbAvanceSilabo) {
        this.tlbAvanceSilabo = tlbAvanceSilabo;
    }

    public JTextField getTxtBuscar() {
        return txtBuscar;
    }

    public void setTxtBuscar(JTextField txtBuscar) {
        this.txtBuscar = txtBuscar;
    }

    public JComboBox<String> getCmbJornadas() {
        return CmbJornadas;
    }

    public void setCmbJornadas(JComboBox<String> CmbJornadas) {
        this.CmbJornadas = CmbJornadas;
    }

    public JComboBox<String> getCmb_Carreras() {
        return Cmb_Carreras;
    }

    public void setCmb_Carreras(JComboBox<String> Cmb_Carreras) {
        this.Cmb_Carreras = Cmb_Carreras;
    }

    public JComboBox<String> getCmb_periodos() {
        return Cmb_periodos;
    }

    public void setCmb_periodos(JComboBox<String> Cmb_periodos) {
        this.Cmb_periodos = Cmb_periodos;
    }

    public JButton getBtn_Imprimir() {
        return btn_Imprimir;
    }

    public void setBtn_Imprimir(JButton btn_Imprimir) {
        this.btn_Imprimir = btn_Imprimir;
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnEliminar = new javax.swing.JButton();
        txtBuscar = new javax.swing.JTextField();
        lblBuscar = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tlbAvanceSilabo = new javax.swing.JTable();
        btnEditar = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        Cmb_Carreras = new javax.swing.JComboBox<>();
        Cmb_periodos = new javax.swing.JComboBox<>();
        CmbJornadas = new javax.swing.JComboBox<>();
        lblBuscar1 = new javax.swing.JLabel();
        lblBuscar2 = new javax.swing.JLabel();
        lblBuscar3 = new javax.swing.JLabel();
        btn_Imprimir = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);

        btnEliminar.setText("Eliminar");

        lblBuscar.setText("Buscar");

        tlbAvanceSilabo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Docente", "Materia", "Curso", "Estado", "Estado", "Fecha Entrega", "Corresponde a"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tlbAvanceSilabo.getTableHeader().setResizingAllowed(false);
        tlbAvanceSilabo.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tlbAvanceSilabo);
        if (tlbAvanceSilabo.getColumnModel().getColumnCount() > 0) {
            tlbAvanceSilabo.getColumnModel().getColumn(0).setMinWidth(0);
            tlbAvanceSilabo.getColumnModel().getColumn(0).setPreferredWidth(0);
            tlbAvanceSilabo.getColumnModel().getColumn(0).setMaxWidth(0);
            tlbAvanceSilabo.getColumnModel().getColumn(3).setPreferredWidth(80);
            tlbAvanceSilabo.getColumnModel().getColumn(3).setMaxWidth(80);
            tlbAvanceSilabo.getColumnModel().getColumn(4).setPreferredWidth(80);
            tlbAvanceSilabo.getColumnModel().getColumn(4).setMaxWidth(80);
            tlbAvanceSilabo.getColumnModel().getColumn(5).setPreferredWidth(80);
            tlbAvanceSilabo.getColumnModel().getColumn(5).setMaxWidth(80);
            tlbAvanceSilabo.getColumnModel().getColumn(6).setPreferredWidth(90);
            tlbAvanceSilabo.getColumnModel().getColumn(6).setMaxWidth(90);
            tlbAvanceSilabo.getColumnModel().getColumn(7).setPreferredWidth(90);
            tlbAvanceSilabo.getColumnModel().getColumn(7).setMaxWidth(90);
        }

        btnEditar.setText("Editar");

        btnNuevo.setText("Nuevo");

        lblBuscar1.setText("Carreras:");

        lblBuscar2.setText("Período:");

        lblBuscar3.setText("Jornada:");

        btn_Imprimir.setText("Imprimir");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblBuscar)
                    .addComponent(lblBuscar1)
                    .addComponent(lblBuscar2)
                    .addComponent(lblBuscar3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Cmb_Carreras, 0, 435, Short.MAX_VALUE)
                            .addComponent(txtBuscar)
                            .addComponent(CmbJornadas, 0, 435, Short.MAX_VALUE)
                            .addComponent(Cmb_periodos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(btnNuevo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEditar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_Imprimir))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 740, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(56, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar)
                    .addComponent(btnEditar)
                    .addComponent(btnNuevo)
                    .addComponent(lblBuscar)
                    .addComponent(btn_Imprimir))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBuscar1)
                    .addComponent(Cmb_Carreras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Cmb_periodos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblBuscar2))
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBuscar3)
                    .addComponent(CmbJornadas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CmbJornadas;
    private javax.swing.JComboBox<String> Cmb_Carreras;
    private javax.swing.JComboBox<String> Cmb_periodos;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btn_Imprimir;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblBuscar;
    private javax.swing.JLabel lblBuscar1;
    private javax.swing.JLabel lblBuscar2;
    private javax.swing.JLabel lblBuscar3;
    private javax.swing.JTable tlbAvanceSilabo;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
