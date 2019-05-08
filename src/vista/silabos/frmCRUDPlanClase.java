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
public class frmCRUDPlanClase extends javax.swing.JInternalFrame {

    /**
     * Creates new form frmCRUDPlanClase
     */
    public frmCRUDPlanClase() {
        initComponents();
        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("vista/img/logo.png"));
        this.setFrameIcon(icon);
    }

    public JButton getBtnEditarPLC() {
        return btnEditarPLC;
    }

    public void setBtnEditarPLC(JButton btnEditarPLC) {
        this.btnEditarPLC = btnEditarPLC;
    }

    public JButton getBtnImplimirPlan() {
        return btnImplimirPlan;
    }

    public void setBtnImplimirPlan(JButton btnImplimirPlan) {
        this.btnImplimirPlan = btnImplimirPlan;
    }
    

    public JButton getBtnEliminarPLC() {
        return btnEliminarPLC;
    }

    public void setBtnEliminarPLC(JButton btnEliminarPLC) {
        this.btnEliminarPLC = btnEliminarPLC;
    }

    public JButton getBtnNuevoPLC() {
        return btnNuevoPLC;
    }

    public JComboBox<String> getCmb_periodos() {
        return Cmb_periodos;
    }

    public void setCmb_periodos(JComboBox<String> Cmb_periodos) {
        this.Cmb_periodos = Cmb_periodos;
    }

    public void setBtnNuevoPLC(JButton btnNuevoPLC) {
        this.btnNuevoPLC = btnNuevoPLC;
    }

   

    public JLabel getLbBuscarPLC() {
        return lbBuscarPLC;
    }

    public void setLbBuscarPLC(JLabel lbBuscarPLC) {
        this.lbBuscarPLC = lbBuscarPLC;
    }

    public JTable getTlbTablaPLC() {
        return tlbTablaPLC;
    }

    public void setTlbTablaPLC(JTable tlbTablaPLC) {
        this.tlbTablaPLC = tlbTablaPLC;
    }

   

    public JTextField getTxtBuscarPLC() {
        return txtBuscarPLC;
    }

    public void setTxtBuscarPLC(JTextField txtBuscarPLC) {
        this.txtBuscarPLC = txtBuscarPLC;
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtBuscarPLC = new javax.swing.JTextField();
        lbBuscarPLC = new javax.swing.JLabel();
        btnNuevoPLC = new javax.swing.JButton();
        btnEditarPLC = new javax.swing.JButton();
        btnEliminarPLC = new javax.swing.JButton();
        Cmb_Carreras = new javax.swing.JComboBox<>();
        Carreras = new javax.swing.JLabel();
        CmbJornadas = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tlbTablaPLC = new javax.swing.JTable();
        Cmb_periodos = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        btnImplimirPlan = new javax.swing.JButton();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconifiable(true);

        lbBuscarPLC.setText("Buscar:");

        btnNuevoPLC.setText("Nuevo");

        btnEditarPLC.setText("Editar");

        btnEliminarPLC.setText("Eliminar");

        Carreras.setText("Carrera:");

        jLabel2.setText("Jornada:");

        tlbTablaPLC.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Docente", "Materia", "Curso", "Plan de Clase N°", "Unidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tlbTablaPLC.getTableHeader().setResizingAllowed(false);
        tlbTablaPLC.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tlbTablaPLC);

        Cmb_periodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cmb_periodosActionPerformed(evt);
            }
        });

        jLabel3.setText("Periodo:");

        btnImplimirPlan.setText("Imprimir ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 807, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbBuscarPLC)
                            .addComponent(Carreras)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Cmb_Carreras, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtBuscarPLC, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(38, 38, 38)
                                .addComponent(btnNuevoPLC)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnEditarPLC)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnEliminarPLC))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(CmbJornadas, javax.swing.GroupLayout.Alignment.LEADING, 0, 168, Short.MAX_VALUE)
                                    .addComponent(Cmb_periodos, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnImplimirPlan)))))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnNuevoPLC)
                        .addComponent(btnEditarPLC)
                        .addComponent(btnEliminarPLC))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtBuscarPLC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbBuscarPLC)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Cmb_Carreras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Carreras))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Cmb_periodos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CmbJornadas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnImplimirPlan)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Cmb_periodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cmb_periodosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Cmb_periodosActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmCRUDPlanClase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmCRUDPlanClase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmCRUDPlanClase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmCRUDPlanClase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmCRUDPlanClase().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Carreras;
    private javax.swing.JComboBox<String> CmbJornadas;
    private javax.swing.JComboBox<String> Cmb_Carreras;
    private javax.swing.JComboBox<String> Cmb_periodos;
    private javax.swing.JButton btnEditarPLC;
    private javax.swing.JButton btnEliminarPLC;
    private javax.swing.JButton btnImplimirPlan;
    private javax.swing.JButton btnNuevoPLC;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbBuscarPLC;
    private javax.swing.JTable tlbTablaPLC;
    private javax.swing.JTextField txtBuscarPLC;
    // End of variables declaration//GEN-END:variables
}
