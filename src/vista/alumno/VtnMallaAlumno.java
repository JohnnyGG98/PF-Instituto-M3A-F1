package vista.alumno;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Johnny
 */
public class VtnMallaAlumno extends javax.swing.JInternalFrame {

    /**
     * Creates new form VtnMallaAlumno
     */
    public VtnMallaAlumno() {
        initComponents();
    }

    public JComboBox<String> getCmbAlumnos() {
        return cmbAlumnos;
    }

    public JTable getTblMallaAlumno() {
        return tblMallaAlumno;
    }

    public JTextField getTxtBuscar() {
        return txtBuscar;
    }

    public JButton getBtnReporteMallaAlumno() {
        return btnReporteMallaAlumno;
    }

    public void setBtnReporteMallaAlumno(JButton btnReporteMallaAlumno) {
        this.btnReporteMallaAlumno = btnReporteMallaAlumno;
    }

    public JComboBox<String> getCmbCarreras() {
        return cmbCarreras;
    }

    public JComboBox<String> getCmbEstado() {
        return cmbEstado;
    }

    public JButton getBtnIngNota() {
        return btnIngNota;
    }

    public JButton getBtnBuscar() {
        return btnBuscar;
    }

    public JLabel getLblResultados() {
        return lblResultados;
    }

    public JButton getBtnActualizarNota() {
        return btnActualizarNota;
    }

    public JComboBox<String> getCmbCiclo() {
        return cmbCiclo;
    }

    public JButton getBtnReporteCarrera() {
        return btnReporteCarrera;
    }

    public JButton getBtnExportarExcel() {
        return btnExportarExcel;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblMallaAlumno = new javax.swing.JTable();
        cmbAlumnos = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cmbEstado = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        cmbCarreras = new javax.swing.JComboBox<>();
        btnIngNota = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        lblResultados = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnReporteMallaAlumno = new javax.swing.JButton();
        btnActualizarNota = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        cmbCiclo = new javax.swing.JComboBox<>();
        btnReporteCarrera = new javax.swing.JButton();
        btnExportarExcel = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Malla Alumnos");

        jLabel1.setText("Buscar");

        txtBuscar.setToolTipText("Unicamente se puede buscar por cedula.");

        tblMallaAlumno.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblMallaAlumno);

        jLabel2.setText("Alumno:");

        jLabel3.setText("Estado:");

        jLabel4.setText("Carrera:");

        btnIngNota.setText("Ingresar nota");

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/img/icons8_Search_15px.png"))); // NOI18N

        lblResultados.setText("0 Resultados obtenidos.");

        jLabel5.setText("Reporte:");

        btnReporteMallaAlumno.setText("Malla de Alumno");

        btnActualizarNota.setText("Actualizar nota");

        jLabel6.setText("Ciclo:");

        btnReporteCarrera.setText("Reporte Carrera");

        btnExportarExcel.setText("Exportar Excel");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4))
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnActualizarNota)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnIngNota)
                                .addGap(4, 4, 4))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cmbCarreras, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbAlumnos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbCiclo, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblResultados, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 133, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnExportarExcel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnReporteCarrera)
                        .addGap(13, 13, 13)
                        .addComponent(btnReporteMallaAlumno))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(btnIngNota)
                        .addComponent(btnBuscar)
                        .addComponent(btnActualizarNota))
                    .addComponent(txtBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbAlumnos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(cmbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(cmbCarreras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(cmbCiclo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblResultados)
                    .addComponent(jLabel5)
                    .addComponent(btnReporteMallaAlumno)
                    .addComponent(btnReporteCarrera)
                    .addComponent(btnExportarExcel))
                .addGap(5, 5, 5))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizarNota;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnExportarExcel;
    private javax.swing.JButton btnIngNota;
    private javax.swing.JButton btnReporteCarrera;
    private javax.swing.JButton btnReporteMallaAlumno;
    private javax.swing.JComboBox<String> cmbAlumnos;
    private javax.swing.JComboBox<String> cmbCarreras;
    private javax.swing.JComboBox<String> cmbCiclo;
    private javax.swing.JComboBox<String> cmbEstado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblResultados;
    private javax.swing.JTable tblMallaAlumno;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
