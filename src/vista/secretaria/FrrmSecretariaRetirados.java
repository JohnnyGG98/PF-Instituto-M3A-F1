/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.secretaria;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author ana96
 */
public class FrrmSecretariaRetirados extends javax.swing.JInternalFrame {

    /**
     * Creates new form secretariaRetirados
     */
    public FrrmSecretariaRetirados() {
        initComponents();
    }

    public JButton getBtnBuscar() {
        return btnBuscar;
    }

    public void setBtnBuscar(JButton btnBuscar) {
        this.btnBuscar = btnBuscar;
    }

    public JButton getBtnRetirados() {
        return btnRetirados;
    }

    public void setBtnRetirados(JButton btnRetirados) {
        this.btnRetirados = btnRetirados;
    }

    public JCheckBox getCbxAlumnoRetirado() {
        return cbxAlumnoRetirado;
    }

    public void setCbxAlumnoRetirado(JCheckBox cbxAlumnoRetirado) {
        this.cbxAlumnoRetirado = cbxAlumnoRetirado;
    }

    public JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    public void setjScrollPane1(JScrollPane jScrollPane1) {
        this.jScrollPane1 = jScrollPane1;
    }

    public JComboBox<String> getJcbxFiltrarSecretaria() {
        return jcbxFiltrarSecretaria;
    }

    public void setJcbxFiltrarSecretaria(JComboBox<String> jcbxFiltrarSecretaria) {
        this.jcbxFiltrarSecretaria = jcbxFiltrarSecretaria;
    }

    public JTable getJtbSecretaria() {
        return jtbSecretaria;
    }

    public void setJtbSecretaria(JTable jtbSecretaria) {
        this.jtbSecretaria = jtbSecretaria;
    }

    public JLabel getLblBuscar() {
        return lblBuscar;
    }

    public void setLblBuscar(JLabel lblBuscar) {
        this.lblBuscar = lblBuscar;
    }

    public JLabel getLblFiltrar() {
        return lblFiltrar;
    }

    public void setLblFiltrar(JLabel lblFiltrar) {
        this.lblFiltrar = lblFiltrar;
    }

    public JTextField getTxtBuscar() {
        return txtBuscar;
    }

    public void setTxtBuscar(JTextField txtBuscar) {
        this.txtBuscar = txtBuscar;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblBuscar = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        btnRetirados = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbSecretaria = new javax.swing.JTable();
        jcbxFiltrarSecretaria = new javax.swing.JComboBox<>();
        lblFiltrar = new javax.swing.JLabel();
        cbxAlumnoRetirado = new javax.swing.JCheckBox();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Secretaria-Alumnos Retirados");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/img/logo.png"))); // NOI18N
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblBuscar.setText("Buscar");
        getContentPane().add(lblBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 14, -1, -1));
        getContentPane().add(txtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 11, 146, -1));

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/img/icons8_Search_20px_2.png"))); // NOI18N
        getContentPane().add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(204, 11, 34, 19));

        btnRetirados.setText("Retirar Alumno");
        getContentPane().add(btnRetirados, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 10, -1, -1));

        jtbSecretaria.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Alumno", "Materia", "Estado", "Matricula"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jtbSecretaria);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 640, 170));

        jcbxFiltrarSecretaria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "[FILTRAR]" }));
        getContentPane().add(jcbxFiltrarSecretaria, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 140, -1));

        lblFiltrar.setText("Filtrar");
        getContentPane().add(lblFiltrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        cbxAlumnoRetirado.setText("Mostrar Alumnos Retirados");
        getContentPane().add(cbxAlumnoRetirado, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 50, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnRetirados;
    private javax.swing.JCheckBox cbxAlumnoRetirado;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> jcbxFiltrarSecretaria;
    private javax.swing.JTable jtbSecretaria;
    private javax.swing.JLabel lblBuscar;
    private javax.swing.JLabel lblFiltrar;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
