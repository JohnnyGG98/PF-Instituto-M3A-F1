/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.silabos.new_planes_de_clase;

import controlador.notas.ux.RowStyle;
import java.awt.Color;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;
import vista.AbstracView;

/**
 *
 * @author MrRainx
 */
public class VtnPlanClase extends AbstracView {

    public VtnPlanClase() {
        initComponents();
        InitDiseño();

    }

    private void InitDiseño() {
        tbl.setRowHeight(23);
        RowStyle rowStyleTrad = new RowStyle(0);

        Map<String, Color> estados = new HashMap<String, Color>() {
            {
                put("APROBADO", new Color(37, 107, 187));
                put("REPROBADO", new Color(214, 48, 12));
                put("RETIRADO", new Color(0, 0, 0));
                put("", new Color(0, 0, 0));
            }
        };

        rowStyleTrad.setEstados(estados);

        tbl.setDefaultRenderer(Object.class, rowStyleTrad);

        centrarCabecera(tbl);

    }

    public JComboBox<String> getCmbJornadas() {
        return CmbJornadas;
    }

    public JButton getBtnCopiar() {
        return btnCopiar;
    }

    public JButton getBtnEditar() {
        return btnEditar;
    }

    public JButton getBtnEditarFecha() {
        return btnEditarFecha;
    }

    public JButton getBtnEliminar() {
        return btnEliminar;
    }

    public JButton getBtnImprimir() {
        return btnImprimir;
    }

    public JButton getBtnNuevo() {
        return btnNuevo;
    }

    public JComboBox<String> getCmbPeriodos() {
        return cmbPeriodos;
    }

    public JTable getTbl() {
        return tbl;
    }

    public JTextField getTxtBuscar() {
        return txtBuscar;
    }
    
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtBuscar = new javax.swing.JTextField();
        lblBuscar = new javax.swing.JLabel();
        btnNuevo = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        CmbJornadas = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl = new javax.swing.JTable();
        cmbPeriodos = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        btnImprimir = new javax.swing.JButton();
        btnEditarFecha = new javax.swing.JButton();
        btnCopiar = new javax.swing.JButton();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconifiable(true);
        setMaximizable(true);

        lblBuscar.setText("Buscar:");

        btnNuevo.setText("Nuevo");

        btnEditar.setText("Editar");

        btnEliminar.setText("Eliminar");

        jLabel2.setText("Jornada:");

        tbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "PlanCod", "Docente", "Materia", "Curso", "Unidad", "Estado", "Estado", "Fecha"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tbl.getTableHeader().setResizingAllowed(false);
        tbl.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tbl);
        if (tbl.getColumnModel().getColumnCount() > 0) {
            tbl.getColumnModel().getColumn(0).setMinWidth(0);
            tbl.getColumnModel().getColumn(0).setPreferredWidth(0);
            tbl.getColumnModel().getColumn(0).setMaxWidth(0);
            tbl.getColumnModel().getColumn(1).setPreferredWidth(250);
            tbl.getColumnModel().getColumn(1).setMaxWidth(250);
            tbl.getColumnModel().getColumn(3).setMinWidth(50);
            tbl.getColumnModel().getColumn(3).setPreferredWidth(50);
            tbl.getColumnModel().getColumn(3).setMaxWidth(50);
            tbl.getColumnModel().getColumn(4).setMinWidth(50);
            tbl.getColumnModel().getColumn(4).setPreferredWidth(50);
            tbl.getColumnModel().getColumn(4).setMaxWidth(50);
            tbl.getColumnModel().getColumn(5).setPreferredWidth(80);
            tbl.getColumnModel().getColumn(5).setMaxWidth(80);
            tbl.getColumnModel().getColumn(6).setPreferredWidth(80);
            tbl.getColumnModel().getColumn(6).setMaxWidth(80);
            tbl.getColumnModel().getColumn(7).setMinWidth(80);
            tbl.getColumnModel().getColumn(7).setPreferredWidth(80);
            tbl.getColumnModel().getColumn(7).setMaxWidth(80);
        }

        jLabel3.setText("Periodo:");

        btnImprimir.setText("Imprimir ");

        btnEditarFecha.setText("Editar Fecha");

        btnCopiar.setText("Copiar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(lblBuscar)
                                .addGap(9, 9, 9)
                                .addComponent(txtBuscar))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(CmbJornadas, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 231, Short.MAX_VALUE))
                                    .addComponent(cmbPeriodos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnNuevo)
                                .addGap(18, 18, 18)
                                .addComponent(btnEditar))
                            .addComponent(btnEditarFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnEliminar)
                                .addGap(18, 18, 18)
                                .addComponent(btnImprimir))
                            .addComponent(btnCopiar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblBuscar)
                    .addComponent(btnNuevo)
                    .addComponent(btnEditar)
                    .addComponent(btnEliminar)
                    .addComponent(btnImprimir))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnEditarFecha)
                        .addComponent(btnCopiar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbPeriodos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CmbJornadas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CmbJornadas;
    private javax.swing.JButton btnCopiar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEditarFecha;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnImprimir;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JComboBox<String> cmbPeriodos;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblBuscar;
    private javax.swing.JTable tbl;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
