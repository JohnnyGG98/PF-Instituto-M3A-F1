/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.asistenciaAlumnos;

import controlador.notas.ux.RowStyle;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

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
        
        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("vista/img/logo.png"));
        this.setFrameIcon(icon);
        
        
        InitDiseño();
    }

    private void InitDiseño() {
//        RowStyle row = new RowStyle(7);
//        tblAsistencia.setDefaultRenderer(Object.class, row);

        tblAsistencia.setRowHeight(23);
        DefaultTableCellRenderer headerTrad = (DefaultTableCellRenderer) tblAsistencia.getTableHeader().getDefaultRenderer();
        headerTrad.setHorizontalAlignment(SwingConstants.CENTER);
    }

    public void setCmbSemana(JComboBox<String> cmbSemana) {
        this.cmbSemana = cmbSemana;
    }

    public JComboBox<String> getCmbSemana() {
        return cmbSemana;
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
        return lblAsignaturaAsis;
    }

    public JLabel getjLabel3() {
        return lblHorasPresencialesAsis;
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
        lblAsignaturaAsis = new javax.swing.JLabel();
        lblHorasPresencialesAsis = new javax.swing.JLabel();
        cmbDocenteAsis = new javax.swing.JComboBox<>();
        cmbAsignaturaAsis = new javax.swing.JComboBox<>();
        lblHorasAsis = new javax.swing.JLabel();
        btnBuscarAsis = new javax.swing.JButton();
        btnVerAsistencia = new javax.swing.JButton();
        btnImprimir = new javax.swing.JButton();
        txtBuscarAsis = new javax.swing.JTextField();
        lblResultados = new javax.swing.JLabel();
        lblSemana = new javax.swing.JLabel();
        cmbSemana = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblAsistencia = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Asistencia Alumnos");
        setMaximumSize(new java.awt.Dimension(1280, 720));
        setMinimumSize(new java.awt.Dimension(1060, 550));
        setPreferredSize(new java.awt.Dimension(1060, 558));

        lblPeriodoLectivoAsis.setText("Período Lectivo:");

        lblCarreraAsis.setText("Carrera:");

        lblCicloAsis.setText("Ciclo:");

        cmbPeriodoLectivoAsis.setMinimumSize(new java.awt.Dimension(28, 20));
        cmbPeriodoLectivoAsis.setPreferredSize(new java.awt.Dimension(28, 20));

        lblDocenteAsis.setText("Docente:");

        lblAsignaturaAsis.setText("Asignatura:");

        lblHorasPresencialesAsis.setText("Horas Presenciales:");

        cmbDocenteAsis.setMinimumSize(new java.awt.Dimension(28, 20));
        cmbDocenteAsis.setPreferredSize(new java.awt.Dimension(28, 20));

        btnBuscarAsis.setText("Buscar");

        btnVerAsistencia.setText("Ver Asistencia");

        btnImprimir.setText("Imprimir");

        lblResultados.setText("0 Resultados");

        lblSemana.setText("Semana");

        tblAsistencia.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nro.", "Cédula", "P.Apellido", "S.Apellido", "P.Nombre", "S.Nombre", "Faltas", "Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true, true, true, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblAsistencia);
        if (tblAsistencia.getColumnModel().getColumnCount() > 0) {
            tblAsistencia.getColumnModel().getColumn(6).setResizable(false);
            tblAsistencia.getColumnModel().getColumn(7).setResizable(false);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblResultados, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                                            .addComponent(lblAsignaturaAsis))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(cmbDocenteAsis, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(cmbAsignaturaAsis, 0, 269, Short.MAX_VALUE))
                                        .addGap(18, 18, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblCicloAsis)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cmbCicloAsis, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(38, 38, 38)
                                        .addComponent(lblSemana)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cmbSemana, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                                        .addComponent(lblHorasPresencialesAsis)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(lblHorasAsis, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(127, 127, 127)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtBuscarAsis)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(btnImprimir, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(btnVerAsistencia, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(0, 56, Short.MAX_VALUE)))
                                .addGap(10, 10, 10)
                                .addComponent(btnBuscarAsis)))
                        .addGap(7, 7, 7))))
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
                                .addComponent(lblAsignaturaAsis)
                                .addComponent(cmbAsignaturaAsis, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(btnVerAsistencia)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblCicloAsis)
                        .addComponent(lblHorasPresencialesAsis)
                        .addComponent(lblHorasAsis, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cmbCicloAsis, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblSemana)
                        .addComponent(cmbSemana, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnImprimir))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 335, Short.MAX_VALUE)
                .addGap(18, 18, 18)
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
    private javax.swing.JComboBox<String> cmbSemana;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblAsignaturaAsis;
    private javax.swing.JLabel lblCarreraAsis;
    private javax.swing.JLabel lblCarreraAsistencia;
    private javax.swing.JLabel lblCicloAsis;
    private javax.swing.JLabel lblDocenteAsis;
    private javax.swing.JLabel lblHorasAsis;
    private javax.swing.JLabel lblHorasPresencialesAsis;
    private javax.swing.JLabel lblPeriodoLectivoAsis;
    private javax.swing.JLabel lblResultados;
    private javax.swing.JLabel lblSemana;
    public static javax.swing.JTable tblAsistencia;
    private javax.swing.JTextField txtBuscarAsis;
    // End of variables declaration//GEN-END:variables
}
