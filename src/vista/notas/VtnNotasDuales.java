/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.notas;

import controlador.notas.ux.RowStyle;
import vista.AbstracView;

/**
 *
 * @author MrRainx
 */
public class VtnNotasDuales extends AbstracView {

    /**
     * Creates new form VtnNotasDuales
     */
    public VtnNotasDuales() {
        initComponents();
        InitDiseño();
    }

    private void InitDiseño() {
        tbl.setRowHeight(23);
        tbl.setDefaultRenderer(Object.class, new RowStyle(13));

        centrarCabecera(tbl);

    }

    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_periodolectivo = new javax.swing.JLabel();
        btnVerNotas = new javax.swing.JButton();
        lbl_carrera = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        lbl_ciclo = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        lbl_docente = new javax.swing.JLabel();
        lbl_asignatura = new javax.swing.JLabel();
        cmbPeriodoLectivo = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        cmbCiclo = new javax.swing.JComboBox<>();
        lblHoras = new javax.swing.JLabel();
        cmbAsignatura = new javax.swing.JComboBox<>();
        cmbDocente = new javax.swing.JComboBox<>();
        btnImprimir = new javax.swing.JButton();
        lblCarrera = new javax.swing.JLabel();
        tabDuales = new javax.swing.JScrollPane();
        tbl = new javax.swing.JTable();
        lblResultados = new javax.swing.JLabel();
        lblEstado = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Notas Duales");
        setMinimumSize(new java.awt.Dimension(1060, 550));

        lbl_periodolectivo.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_periodolectivo.setText("Período lectivo:");
        lbl_periodolectivo.setMinimumSize(null);

        btnVerNotas.setText("Cargar Notas");
        btnVerNotas.setEnabled(false);

        lbl_carrera.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_carrera.setText("Carrera:");
        lbl_carrera.setMinimumSize(null);

        txtBuscar.setMinimumSize(null);

        lbl_ciclo.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_ciclo.setText("Ciclo:");
        lbl_ciclo.setMinimumSize(null);

        btnBuscar.setText("Buscar");
        btnBuscar.setMinimumSize(null);

        lbl_docente.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_docente.setText("Docente:");
        lbl_docente.setMinimumSize(null);

        lbl_asignatura.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_asignatura.setText("Asignatura:");
        lbl_asignatura.setMinimumSize(null);

        cmbPeriodoLectivo.setMinimumSize(null);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Horas Presenciales:");
        jLabel1.setMinimumSize(null);

        cmbCiclo.setMinimumSize(null);

        lblHoras.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHoras.setMinimumSize(null);

        cmbAsignatura.setMinimumSize(null);

        cmbDocente.setMinimumSize(null);

        btnImprimir.setText("Imprimir");
        btnImprimir.setMinimumSize(null);

        lblCarrera.setMinimumSize(null);

        tbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "No.", "Alumno", "No. F. T.", "No. T. E.", "No. T. A.", "No. D. G.", "PTI", "F.P", "No. Final", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl.setSelectionBackground(new java.awt.Color(102, 102, 102));
        tbl.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tbl.getTableHeader().setReorderingAllowed(false);
        tabDuales.setViewportView(tbl);
        if (tbl.getColumnModel().getColumnCount() > 0) {
            tbl.getColumnModel().getColumn(0).setMinWidth(5);
            tbl.getColumnModel().getColumn(0).setPreferredWidth(5);
            tbl.getColumnModel().getColumn(0).setMaxWidth(5);
            tbl.getColumnModel().getColumn(1).setMinWidth(50);
            tbl.getColumnModel().getColumn(1).setPreferredWidth(50);
            tbl.getColumnModel().getColumn(1).setMaxWidth(50);
            tbl.getColumnModel().getColumn(2).setPreferredWidth(200);
            tbl.getColumnModel().getColumn(3).setMinWidth(80);
            tbl.getColumnModel().getColumn(3).setPreferredWidth(80);
            tbl.getColumnModel().getColumn(3).setMaxWidth(80);
            tbl.getColumnModel().getColumn(4).setMinWidth(80);
            tbl.getColumnModel().getColumn(4).setPreferredWidth(80);
            tbl.getColumnModel().getColumn(4).setMaxWidth(80);
            tbl.getColumnModel().getColumn(5).setMinWidth(80);
            tbl.getColumnModel().getColumn(5).setPreferredWidth(80);
            tbl.getColumnModel().getColumn(5).setMaxWidth(80);
            tbl.getColumnModel().getColumn(6).setMinWidth(80);
            tbl.getColumnModel().getColumn(6).setPreferredWidth(80);
            tbl.getColumnModel().getColumn(6).setMaxWidth(80);
            tbl.getColumnModel().getColumn(7).setMinWidth(80);
            tbl.getColumnModel().getColumn(7).setPreferredWidth(80);
            tbl.getColumnModel().getColumn(7).setMaxWidth(80);
            tbl.getColumnModel().getColumn(8).setMinWidth(80);
            tbl.getColumnModel().getColumn(8).setPreferredWidth(80);
            tbl.getColumnModel().getColumn(8).setMaxWidth(80);
            tbl.getColumnModel().getColumn(9).setMinWidth(100);
            tbl.getColumnModel().getColumn(9).setPreferredWidth(100);
            tbl.getColumnModel().getColumn(9).setMaxWidth(100);
        }

        lblResultados.setText("0 Resultados");

        lblEstado.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblEstado.setForeground(new java.awt.Color(153, 255, 153));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tabDuales)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_periodolectivo, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbl_ciclo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbl_carrera, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cmbPeriodoLectivo, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lblCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(lbl_asignatura, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lbl_docente, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(cmbCiclo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmbDocente, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cmbAsignatura, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lblHoras, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(btnVerNotas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(btnImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(12, 12, 12)
                                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(64, 64, 64)
                                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblResultados, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(113, 113, 113)
                                .addComponent(lblEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 445, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lbl_periodolectivo, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmbPeriodoLectivo, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lbl_carrera, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbl_docente, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbl_asignatura, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lbl_ciclo, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cmbCiclo, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbDocente, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbAsignatura, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnVerNotas, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblHoras, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(tabDuales, javax.swing.GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblResultados, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnBuscar;
    public javax.swing.JButton btnImprimir;
    public javax.swing.JButton btnVerNotas;
    public javax.swing.JComboBox<String> cmbAsignatura;
    public javax.swing.JComboBox<String> cmbCiclo;
    public javax.swing.JComboBox<String> cmbDocente;
    public javax.swing.JComboBox<String> cmbPeriodoLectivo;
    private javax.swing.JLabel jLabel1;
    public javax.swing.JLabel lblCarrera;
    public javax.swing.JLabel lblEstado;
    public javax.swing.JLabel lblHoras;
    public javax.swing.JLabel lblResultados;
    private javax.swing.JLabel lbl_asignatura;
    private javax.swing.JLabel lbl_carrera;
    private javax.swing.JLabel lbl_ciclo;
    private javax.swing.JLabel lbl_docente;
    private javax.swing.JLabel lbl_periodolectivo;
    private javax.swing.JScrollPane tabDuales;
    public javax.swing.JTable tbl;
    public javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
