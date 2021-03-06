/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.silabos;

import java.awt.Component;
import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.TableCellRenderer;
import vista.silabos.MyCellRenderer.WordWrapCellRenderer;

/**
 *
 * @author Andres Ullauri
 */
public class FrmReferencias extends javax.swing.JInternalFrame {

    /**
     * Creates new form frmReferencias
     */
    public FrmReferencias() {
        initComponents();

        MyCellRenderer cellRenderer = new MyCellRenderer(300);
        lstBibliografiaBase.setCellRenderer(cellRenderer);

        tblBiblioteca.getColumnModel().getColumn(1).setCellRenderer(new WordWrapCellRenderer());

        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("vista/img/logo.png"));
        this.setFrameIcon(icon);

    }

    
    
    
    

    public JButton getBtnAtras() {
        return btnAtras;
    }

    public void setBtnAtras(JButton btnAtras) {
        this.btnAtras = btnAtras;
    }

    public JButton getBtnCancelar() {
        return btnCancelar;
    }

    public void setBtnCancelar(JButton btnCancelar) {
        this.btnCancelar = btnCancelar;
    }

    public JButton getBtnFinalizar() {
        return btnFinalizar;
    }

    public void setBtnFinalizar(JButton btnFinalizar) {
        this.btnFinalizar = btnFinalizar;
    }

    public JLabel getLblBibliografiaBase() {
        return lblBibliografiaBase;
    }

    public void setLblBibliografiaBase(JLabel lblBibliografiaBase) {
        this.lblBibliografiaBase = lblBibliografiaBase;
    }

    public JLabel getLblBibliografiaComplementaria() {
        return lblBibliografiaComplementaria;
    }

    public void setLblBibliografiaComplementaria(JLabel lblBibliografiaComplementaria) {
        this.lblBibliografiaComplementaria = lblBibliografiaComplementaria;
    }

    public JComboBox<String> getCmbBiblioteca() {
        return cmbBiblioteca;
    }

    public void setCmbBiblioteca(JComboBox<String> cmbBiblioteca) {
        this.cmbBiblioteca = cmbBiblioteca;
    }

    public JLabel getLblBibliotecs() {
        return lblBibliotecs;
    }

    public void setLblBibliotecs(JLabel lblBibliotecs) {
        this.lblBibliotecs = lblBibliotecs;
    }

    public JLabel getLblRecursos() {
        return lblRecursos;
    }

    public void setLblRecursos(JLabel lblRecursos) {
        this.lblRecursos = lblRecursos;
    }

    

    public JLabel getLblBuscar() {
        return lblBuscar;
    }

    public void setLblBuscar(JLabel lblBuscar) {
        this.lblBuscar = lblBuscar;
    }

    public JLabel getLblLinkografia() {
        return lblLinkografia;
    }

    public void setLblLinkografia(JLabel lblLinkografia) {
        this.lblLinkografia = lblLinkografia;
    }

    public JList<String> getLstBibliografiaBase() {
        return lstBibliografiaBase;
    }

    public void setLstBibliografiaBase(JList<String> lstBibliografiaBase) {
        this.lstBibliografiaBase = lstBibliografiaBase;
    }

    public JScrollPane getScrBibliografiaBase() {
        return scrBibliografiaBase;
    }

    public void setScrBibliografiaBase(JScrollPane scrBibliografiaBase) {
        this.scrBibliografiaBase = scrBibliografiaBase;
    }

    public JScrollPane getScrBibliografiaComplementaria() {
        return scrBibliografiaComplementaria;
    }

    public void setScrBibliografiaComplementaria(JScrollPane scrBibliografiaComplementaria) {
        this.scrBibliografiaComplementaria = scrBibliografiaComplementaria;
    }

    public JScrollPane getScrBiblioteca() {
        return scrBiblioteca;
    }

    public void setScrBiblioteca(JScrollPane scrBiblioteca) {
        this.scrBiblioteca = scrBiblioteca;
    }

    public JScrollPane getScrLinkografia() {
        return scrLinkografia;
    }

    public void setScrLinkografia(JScrollPane scrLinkografia) {
        this.scrLinkografia = scrLinkografia;
    }

    public JTable getTblBiblioteca() {
        return tblBiblioteca;
    }

    public void setTblBiblioteca(JTable tblBiblioteca) {
        this.tblBiblioteca = tblBiblioteca;
    }

    public JTextArea getTxrBibliografiaComplementaria() {
        return txrBibliografiaComplementaria;
    }

    public void setTxrBibliografiaComplementaria(JTextArea txrBibliografiaComplementaria) {
        this.txrBibliografiaComplementaria = txrBibliografiaComplementaria;
    }

    public JTextArea getTxrLinkografia() {
        return txrLinkografia;
    }

    public void setTxrLinkografia(JTextArea txrLinkografia) {
        this.txrLinkografia = txrLinkografia;
    }

    public JTextField getTxtBuscar() {
        return txtBuscar;
    }

    public void setTxtBuscar(JTextField txtBuscar) {
        this.txtBuscar = txtBuscar;
    }

    public JButton getBtnAgregarBibliografiaBase() {
        return btnAgregarBibliografiaBase;
    }

    public void setBtnAgregarBibliografiaBase(JButton btnAgregarBibliografiaBase) {
        this.btnAgregarBibliografiaBase = btnAgregarBibliografiaBase;
    }

    public JButton getBtnQuitarBibliografiaBase() {
        return btnQuitarBibliografiaBase;
    }

    public void setBtnQuitarBibliografiaBase(JButton btnQuitarBibliografiaBase) {
        this.btnQuitarBibliografiaBase = btnQuitarBibliografiaBase;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblBibliografiaBase = new javax.swing.JLabel();
        lblBibliografiaComplementaria = new javax.swing.JLabel();
        lblLinkografia = new javax.swing.JLabel();
        scrLinkografia = new javax.swing.JScrollPane();
        txrLinkografia = new javax.swing.JTextArea();
        scrBiblioteca = new javax.swing.JScrollPane();
        tblBiblioteca = new javax.swing.JTable();
        scrBibliografiaComplementaria = new javax.swing.JScrollPane();
        txrBibliografiaComplementaria = new javax.swing.JTextArea();
        scrBibliografiaBase = new javax.swing.JScrollPane();
        lstBibliografiaBase = new javax.swing.JList<>();
        lblRecursos = new javax.swing.JLabel();
        lblBuscar = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        btnCancelar = new javax.swing.JButton();
        btnFinalizar = new javax.swing.JButton();
        btnAtras = new javax.swing.JButton();
        btnAgregarBibliografiaBase = new javax.swing.JButton();
        btnQuitarBibliografiaBase = new javax.swing.JButton();
        cmbBiblioteca = new javax.swing.JComboBox<>();
        lblBibliotecs = new javax.swing.JLabel();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        lblBibliografiaBase.setText("Bibliografía Base:");

        lblBibliografiaComplementaria.setText("Bibliografía Complementaria:");

        lblLinkografia.setText("Linkografía:");

        txrLinkografia.setColumns(20);
        txrLinkografia.setLineWrap(true);
        txrLinkografia.setRows(5);
        txrLinkografia.setWrapStyleWord(true);
        scrLinkografia.setViewportView(txrLinkografia);

        tblBiblioteca.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Referencia"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scrBiblioteca.setViewportView(tblBiblioteca);
        if (tblBiblioteca.getColumnModel().getColumnCount() > 0) {
            tblBiblioteca.getColumnModel().getColumn(0).setMinWidth(90);
            tblBiblioteca.getColumnModel().getColumn(0).setPreferredWidth(90);
            tblBiblioteca.getColumnModel().getColumn(0).setMaxWidth(90);
        }

        txrBibliografiaComplementaria.setColumns(20);
        txrBibliografiaComplementaria.setLineWrap(true);
        txrBibliografiaComplementaria.setRows(5);
        txrBibliografiaComplementaria.setWrapStyleWord(true);
        scrBibliografiaComplementaria.setViewportView(txrBibliografiaComplementaria);

        scrBibliografiaBase.setViewportView(lstBibliografiaBase);

        lblRecursos.setText("Recursos Disponibles en Bibliotecta:");

        lblBuscar.setText("Buscar:");

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnFinalizar.setText("Finalizar");

        btnAtras.setText("Atrás");
        btnAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasActionPerformed(evt);
            }
        });

        btnAgregarBibliografiaBase.setText("Agregar >>");

        btnQuitarBibliografiaBase.setText("<< Quitar");

        cmbBiblioteca.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Biblioteca Física ISTA", "Biblioteca de Convenios" }));

        lblBibliotecs.setText("Biblioteca:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnAtras)
                        .addGap(18, 18, 18)
                        .addComponent(btnFinalizar)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancelar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblRecursos)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblBuscar)
                                    .addComponent(lblBibliotecs))
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtBuscar)
                                    .addComponent(cmbBiblioteca, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(scrBiblioteca))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnAgregarBibliografiaBase, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnQuitarBibliografiaBase, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblBibliografiaComplementaria)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(scrBibliografiaComplementaria, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(scrBibliografiaBase, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblLinkografia)
                            .addComponent(lblBibliografiaBase)
                            .addComponent(scrLinkografia, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(41, 41, 41))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblBibliografiaBase)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(scrBibliografiaBase, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblBibliografiaComplementaria)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(scrBibliografiaComplementaria, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(lblLinkografia)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(scrLinkografia, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblRecursos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnAgregarBibliografiaBase)
                                .addGap(19, 19, 19)
                                .addComponent(btnQuitarBibliografiaBase)
                                .addGap(347, 347, 347))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblBuscar)
                                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cmbBiblioteca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblBibliotecs))
                                .addGap(18, 18, 18)
                                .addComponent(scrBiblioteca, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFinalizar)
                    .addComponent(btnAtras)
                    .addComponent(btnCancelar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAtrasActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCancelarActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarBibliografiaBase;
    private javax.swing.JButton btnAtras;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnFinalizar;
    private javax.swing.JButton btnQuitarBibliografiaBase;
    private javax.swing.JComboBox<String> cmbBiblioteca;
    private javax.swing.JLabel lblBibliografiaBase;
    private javax.swing.JLabel lblBibliografiaComplementaria;
    private javax.swing.JLabel lblBibliotecs;
    private javax.swing.JLabel lblBuscar;
    private javax.swing.JLabel lblLinkografia;
    private javax.swing.JLabel lblRecursos;
    private javax.swing.JList<String> lstBibliografiaBase;
    private javax.swing.JScrollPane scrBibliografiaBase;
    private javax.swing.JScrollPane scrBibliografiaComplementaria;
    private javax.swing.JScrollPane scrBiblioteca;
    private javax.swing.JScrollPane scrLinkografia;
    private javax.swing.JTable tblBiblioteca;
    private javax.swing.JTextArea txrBibliografiaComplementaria;
    private javax.swing.JTextArea txrLinkografia;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables

}

class MyCellRenderer extends DefaultListCellRenderer {

    public static final String HTML_1 = "<html><body style='width: ";
    public static final String HTML_2 = "px'>";
    public static final String HTML_3 = "</html>";
    private int width;

    public MyCellRenderer(int width) {
        this.width = width;
    }

    @Override
    public Component getListCellRendererComponent(JList list, Object value,
            int index, boolean isSelected, boolean cellHasFocus) {
        String text = HTML_1 + String.valueOf(width) + HTML_2 + value.toString()
                + HTML_3;
        return super.getListCellRendererComponent(list, text, index, isSelected,
                cellHasFocus);
    }

    static class WordWrapCellRenderer extends JTextArea implements TableCellRenderer {

        WordWrapCellRenderer() {
            setLineWrap(true);
            setWrapStyleWord(true);
        }

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            setText(value.toString());
            setSize(table.getColumnModel().getColumn(column).getWidth(), getPreferredSize().height);
            if (table.getRowHeight(row) != getPreferredSize().height) {
                table.setRowHeight(row, getPreferredSize().height);
            }
            return this;
        }
    }
}
