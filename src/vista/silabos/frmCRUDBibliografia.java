
package vista.silabos;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;


public class frmCRUDBibliografia extends javax.swing.JInternalFrame {

   
    public frmCRUDBibliografia() {
        initComponents();
    }

    public JComboBox<String> getCmblibros() {
        return cmblibros;
    }

    public void setCmblibros(JComboBox<String> cmblibros) {
        this.cmblibros = cmblibros;
    }

    public JButton getBtnEditarCB() {
        return btnEditarCB;
    }

    public void setBtnEditarCB(JButton btnEditarCB) {
        this.btnEditarCB = btnEditarCB;
    }

    public JButton getBtnEliminarCB() {
        return btnEliminarCB;
    }

    public void setBtnEliminarCB(JButton btnEliminarCB) {
        this.btnEliminarCB = btnEliminarCB;
    }

    public JButton getBtnNuevoCB() {
        return btnNuevoCB;
    }

    public JButton getBtnimprimir() {
        return btnimprimir;
    }

    public void setBtnimprimir(JButton btnimprimir) {
        this.btnimprimir = btnimprimir;
    }

    public void setBtnNuevoCB(JButton btnNuevoCB) {
        this.btnNuevoCB = btnNuevoCB;
    }

    public JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    public JButton getBtnmostrar() {
        return btnmostrar;
    }

    public void setBtnmostrar(JButton btnmostrar) {
        this.btnmostrar = btnmostrar;
    }

    public void setjScrollPane1(JScrollPane jScrollPane1) {
        this.jScrollPane1 = jScrollPane1;
    }

    public JLabel getLbBuscarCB() {
        return lbBuscarCB;
    }

    public void setLbBuscarCB(JLabel lbBuscarCB) {
        this.lbBuscarCB = lbBuscarCB;
    }

    public JTable getTblTablaCB() {
        return tblTablaCB;
    }

    public void setTblTablaCB(JTable tblTablaCB) {
        this.tblTablaCB = tblTablaCB;
    }

    public JTextField getTxtBuscarCB() {
        return txtBuscarCB;
    }

    public void setTxtBuscarCB(JTextField txtBuscarCB) {
        this.txtBuscarCB = txtBuscarCB;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblTablaCB = new javax.swing.JTable();
        lbBuscarCB = new javax.swing.JLabel();
        txtBuscarCB = new javax.swing.JTextField();
        btnEliminarCB = new javax.swing.JButton();
        btnEditarCB = new javax.swing.JButton();
        btnNuevoCB = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        cmblibros = new javax.swing.JComboBox<>();
        btnmostrar = new javax.swing.JButton();
        btnimprimir = new javax.swing.JButton();

        setClosable(true);

        tblTablaCB.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Referencia"
            }
        ));
        jScrollPane1.setViewportView(tblTablaCB);
        if (tblTablaCB.getColumnModel().getColumnCount() > 0) {
            tblTablaCB.getColumnModel().getColumn(0).setMinWidth(150);
            tblTablaCB.getColumnModel().getColumn(0).setPreferredWidth(150);
            tblTablaCB.getColumnModel().getColumn(0).setMaxWidth(150);
        }

        lbBuscarCB.setText("Buscar:");

        btnEliminarCB.setText("Eliminar");

        btnEditarCB.setText("Editar");

        btnNuevoCB.setText("Nuevo");

        jLabel1.setText("Libros por carreras:");

        cmblibros.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnmostrar.setText("Mostrar");

        btnimprimir.setText("Imprimir");
        btnimprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnimprimirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(lbBuscarCB))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cmblibros, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnmostrar, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnimprimir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(txtBuscarCB, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(btnNuevoCB)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEditarCB)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminarCB)))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscarCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminarCB)
                    .addComponent(btnEditarCB)
                    .addComponent(btnNuevoCB)
                    .addComponent(lbBuscarCB, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(cmblibros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnmostrar))
                        .addGap(7, 7, 7))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnimprimir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnimprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnimprimirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnimprimirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnEditarCB;
    public javax.swing.JButton btnEliminarCB;
    public javax.swing.JButton btnNuevoCB;
    private javax.swing.JButton btnimprimir;
    private javax.swing.JButton btnmostrar;
    private javax.swing.JComboBox<String> cmblibros;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JLabel lbBuscarCB;
    public javax.swing.JTable tblTablaCB;
    public javax.swing.JTextField txtBuscarCB;
    // End of variables declaration//GEN-END:variables
}
