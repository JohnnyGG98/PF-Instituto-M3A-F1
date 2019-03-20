package vista.notas_Grupo_16;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;

/**
 *
 * @author Alejandro
 */
public class VtnNotasAlumnoCurso extends javax.swing.JInternalFrame {

    public VtnNotasAlumnoCurso() {
        initComponents();
    }

    public JButton getBtnImprimir() {
        return btnImprimir;
    }

    public JComboBox<String> getCmbAsignatura() {
        return cmbAsignatura;
    }

    public JComboBox<String> getCmbCarrera() {
        return cmbCarrera;
    }

    public JComboBox<String> getCmbCiclo() {
        return cmbCiclo;
    }

    public JComboBox<String> getCmbDocente() {
        return cmbDocente;
    }

    public JComboBox<String> getCmbJornada() {
        return cmbJornada;
    }

    public JComboBox<String> getCmbParalelo() {
        return cmbParalelo;
    }

    public JComboBox<String> getCmb_periodolectivo() {
        return cmbPeriodolectivo;
    }

    public JLabel getLblMensajes() {
        return lblMensajes;
    }

    public JTable getTblNotas() {
        return tblNotas;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_periodolectivo = new javax.swing.JLabel();
        lbl_carrera = new javax.swing.JLabel();
        lbl_ciclo = new javax.swing.JLabel();
        lbl_paralelo = new javax.swing.JLabel();
        lbl_docente = new javax.swing.JLabel();
        lbl_asignatura = new javax.swing.JLabel();
        lbl_jornada = new javax.swing.JLabel();
        cmbPeriodolectivo = new javax.swing.JComboBox<>();
        cmbCarrera = new javax.swing.JComboBox<>();
        cmbCiclo = new javax.swing.JComboBox<>();
        cmbParalelo = new javax.swing.JComboBox<>();
        cmbJornada = new javax.swing.JComboBox<>();
        cmbAsignatura = new javax.swing.JComboBox<>();
        cmbDocente = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblNotas = new javax.swing.JTable();
        btnImprimir = new javax.swing.JButton();
        lblMensajes = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Notas");

        lbl_periodolectivo.setText("Periodo Lectivo:");

        lbl_carrera.setText("Carrera:");

        lbl_ciclo.setText("Ciclo:");

        lbl_paralelo.setText("Paralelo:");

        lbl_docente.setText("Docente:");

        lbl_asignatura.setText("Asignatura:");

        lbl_jornada.setText("Jornada:");

        cmbDocente.setEnabled(false);

        tblNotas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "N°", "Cedula", "Apellidos", "Nombres", "APORTE 1   /30", "EXAMEN INTERCICLO", "TOTAL INTERCICLO", "APORTE 2  /30", "EXAMEN FINAL  /25", "/25 SUSP.", "NOTA FINAL", "ESTADO", "Nro. Faltas", "% Faltas"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, true, true, true, true, true, true, true, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblNotas.setColumnSelectionAllowed(true);
        tblNotas.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblNotas);
        tblNotas.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (tblNotas.getColumnModel().getColumnCount() > 0) {
            tblNotas.getColumnModel().getColumn(0).setPreferredWidth(30);
        }

        btnImprimir.setText("Impromir");

        lblMensajes.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblMensajes.setForeground(new java.awt.Color(177, 65, 48));
        lblMensajes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMensajes.setText("MENSAJES DE ERROR");
        lblMensajes.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 0, 0, new java.awt.Color(153, 153, 153)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_periodolectivo)
                            .addComponent(lbl_ciclo, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbl_carrera, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cmbCiclo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lbl_paralelo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbParalelo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(cmbCarrera, 0, 300, Short.MAX_VALUE)
                            .addComponent(cmbPeriodolectivo, 0, 300, Short.MAX_VALUE))
                        .addGap(128, 128, 128)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addComponent(lbl_jornada))
                            .addComponent(lbl_asignatura, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbl_docente, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmbAsignatura, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cmbJornada, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnImprimir))
                            .addComponent(cmbDocente, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 138, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1)))
                .addContainerGap())
            .addComponent(lblMensajes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_periodolectivo, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_docente, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbPeriodolectivo, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbDocente, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_carrera, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_asignatura, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbAsignatura, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_ciclo, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_jornada, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_paralelo, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbCiclo, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbParalelo, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbJornada, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 361, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblMensajes, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnImprimir;
    private javax.swing.JComboBox<String> cmbAsignatura;
    private javax.swing.JComboBox<String> cmbCarrera;
    private javax.swing.JComboBox<String> cmbCiclo;
    private javax.swing.JComboBox<String> cmbDocente;
    private javax.swing.JComboBox<String> cmbJornada;
    private javax.swing.JComboBox<String> cmbParalelo;
    private javax.swing.JComboBox<String> cmbPeriodolectivo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblMensajes;
    private javax.swing.JLabel lbl_asignatura;
    private javax.swing.JLabel lbl_carrera;
    private javax.swing.JLabel lbl_ciclo;
    private javax.swing.JLabel lbl_docente;
    private javax.swing.JLabel lbl_jornada;
    private javax.swing.JLabel lbl_paralelo;
    private javax.swing.JLabel lbl_periodolectivo;
    private javax.swing.JTable tblNotas;
    // End of variables declaration//GEN-END:variables
}
