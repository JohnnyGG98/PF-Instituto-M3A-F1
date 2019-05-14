/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.asistenciaAlumnos;

import controlador.notas.ux.RowStyle;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Lushito
 */
public class FrmAsistencia extends javax.swing.JInternalFrame {

    /**
     * Creates new form FrmAsistencia
     */
    public FrmAsistencia() {
        initComponents();
        InitDiseño();
    }

    private void InitDiseño() {
        RowStyle row = new RowStyle(7);
        tblAsistencia.setDefaultRenderer(Object.class, row);
    }

    public JButton getBtnBuscarAsis() {
        return btnBuscarAsis;
    }

    public JButton getBtnImprimir() {
        return btnImprimir;
    }

    public JButton getBtnVerAsistencia() {
        return btnVerAsistencia;
    }

    public JComboBox<String> getCmbAsignaturaAsis() {
        return cmbAsignaturaAsis;
    }

    public JComboBox<String> getCmbCicloAsis() {
        return cmbCicloAsis;
    }

    public JComboBox<String> getCmbDocenteAsis() {
        return cmbDocenteAsis;
    }

    public JComboBox<String> getCmbPeriodoLectivoAsis() {
        return cmbPeriodoLectivoAsis;
    }

    public JLabel getjLabel2() {
        return jLabel2;
    }

    public JLabel getjLabel3() {
        return jLabel3;
    }

    public JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    public JSeparator getjSeparator1() {
        return jSeparator1;
    }

    public JTable getTblAsistencia() {
        return tblAsistencia;
    }

    public JLabel getLblCarreraAsis() {
        return lblCarreraAsis;
    }

    public JLabel getLblCarreraAsistencia() {
        return lblCarreraAsistencia;
    }

    public JLabel getLblCicloAsis() {
        return lblCicloAsis;
    }

    public JLabel getLblDocenteAsis() {
        return lblDocenteAsis;
    }

    public JLabel getLblHorasAsis() {
        return lblHorasAsis;
    }

    public JLabel getLblPeriodoLectivoAsis() {
        return lblPeriodoLectivoAsis;
    }

    public JLabel getLblResultados() {
        return lblResultados;
    }

    public JTextField getTxtBuscarAsis() {
        return txtBuscarAsis;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblPeriodoLectivoAsis = new javax.swing.JLabel();
        lblCarreraAsis = new javax.swing.JLabel();
        lblCicloAsis = new javax.swing.JLabel();
        cmbPeriodoLectivoAsis = new javax.swing.JComboBox<>();
        lblCarreraAsistencia = new javax.swing.JLabel();
        cmbCicloAsis = new javax.swing.JComboBox<>();
        lblDocenteAsis = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cmbDocenteAsis = new javax.swing.JComboBox<>();
        cmbAsignaturaAsis = new javax.swing.JComboBox<>();
        lblHorasAsis = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        btnBuscarAsis = new javax.swing.JButton();
        btnVerAsistencia = new javax.swing.JButton();
        btnImprimir = new javax.swing.JButton();
        txtBuscarAsis = new javax.swing.JTextField();
        lblResultados = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAsistencia = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Asistencia Alumnos");
        setMaximumSize(new java.awt.Dimension(1243, 500));
        setMinimumSize(new java.awt.Dimension(1243, 500));
        setPreferredSize(new java.awt.Dimension(1074, 543));

        lblPeriodoLectivoAsis.setText("Período Lectivo:");

        lblCarreraAsis.setText("Carrera:");

        lblCicloAsis.setText("Ciclo:");

        cmbPeriodoLectivoAsis.setMinimumSize(new java.awt.Dimension(28, 20));
        cmbPeriodoLectivoAsis.setPreferredSize(new java.awt.Dimension(28, 20));

        lblDocenteAsis.setText("Docente:");

        jLabel2.setText("Asignatura:");

        jLabel3.setText("Horas Presenciales:");

        cmbDocenteAsis.setMinimumSize(new java.awt.Dimension(28, 20));
        cmbDocenteAsis.setPreferredSize(new java.awt.Dimension(28, 20));

        btnBuscarAsis.setText("Buscar");

        btnVerAsistencia.setText("Ver Asistencia");

        btnImprimir.setText("Imprimir");

        lblResultados.setText("0 Resultados");

        tblAsistencia.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Nro.", "Cedula", "P.Apellido", "S.Apellido", "P.Nombre", "S.Nombre", "Faltas", "% Faltas", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblAsistencia);
        if (tblAsistencia.getColumnModel().getColumnCount() > 0) {
            tblAsistencia.getColumnModel().getColumn(1).setMinWidth(0);
            tblAsistencia.getColumnModel().getColumn(1).setPreferredWidth(0);
            tblAsistencia.getColumnModel().getColumn(1).setMaxWidth(0);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblResultados, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblCicloAsis)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cmbCicloAsis, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel3))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(lblPeriodoLectivoAsis)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(cmbPeriodoLectivoAsis, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(4, 4, 4)
                                                .addComponent(lblCarreraAsis)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(lblCarreraAsistencia, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(59, 59, 59)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(lblDocenteAsis)
                                            .addComponent(jLabel2))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblHorasAsis, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(cmbDocenteAsis, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(cmbAsignaturaAsis, 0, 269, Short.MAX_VALUE))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtBuscarAsis)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                    .addComponent(btnImprimir, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(btnVerAsistencia, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGap(0, 96, Short.MAX_VALUE)))
                                        .addGap(10, 10, 10)
                                        .addComponent(btnBuscarAsis))))
                            .addComponent(jScrollPane1))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPeriodoLectivoAsis)
                    .addComponent(lblDocenteAsis, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbDocenteAsis, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbPeriodoLectivoAsis, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarAsis)
                    .addComponent(txtBuscarAsis, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(lblCarreraAsis))
                            .addComponent(lblCarreraAsistencia, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2)
                                .addComponent(cmbAsignaturaAsis, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(btnVerAsistencia)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblCicloAsis)
                        .addComponent(jLabel3)
                        .addComponent(lblHorasAsis, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cmbCicloAsis, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnImprimir))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblResultados, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarAsis;
    private javax.swing.JButton btnImprimir;
    private javax.swing.JButton btnVerAsistencia;
    private javax.swing.JComboBox<String> cmbAsignaturaAsis;
    private javax.swing.JComboBox<String> cmbCicloAsis;
    private javax.swing.JComboBox<String> cmbDocenteAsis;
    private javax.swing.JComboBox<String> cmbPeriodoLectivoAsis;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblCarreraAsis;
    private javax.swing.JLabel lblCarreraAsistencia;
    private javax.swing.JLabel lblCicloAsis;
    private javax.swing.JLabel lblDocenteAsis;
    private javax.swing.JLabel lblHorasAsis;
    private javax.swing.JLabel lblPeriodoLectivoAsis;
    private javax.swing.JLabel lblResultados;
    private javax.swing.JTable tblAsistencia;
    private javax.swing.JTextField txtBuscarAsis;
    // End of variables declaration//GEN-END:variables
}
