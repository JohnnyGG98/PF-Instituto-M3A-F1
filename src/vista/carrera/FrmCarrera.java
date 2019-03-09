package vista.carrera;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Johnny
 */
public class FrmCarrera extends javax.swing.JInternalFrame {

    /**
     * Creates new form FrmCarrera
     */
    public FrmCarrera() {
        initComponents();
    }

    public JButton getBtnGuardar() {
        return btnGuardar;
    }

    public JComboBox<String> getCmbCoordinador() {
        return cmbCoordinador;
    }

    public JComboBox<String> getCmbModalidad() {
        return cmbModalidad;
    }

    public JTextField getTxtAnio() {
        return txtAnio;
    }

    public JTextField getTxtCodigo() {
        return txtCodigo;
    }

    public JTextField getTxtDia() {
        return txtDia;
    }

    public JTextField getTxtMes() {
        return txtMes;
    }

    public JTextField getTxtNombre() {
        return txtNombre;
    }

    public JLabel getLblErrorCodigo() {
        return lblErrorCodigo;
    }

    public JLabel getLblErrorFecha() {
        return lblErrorFecha;
    }

    public JLabel getLblErrorNombre() {
        return lblErrorNombre;
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        cmbCoordinador = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        lblErrorCodigo = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        cmbModalidad = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblErrorFecha = new javax.swing.JLabel();
        txtDia = new javax.swing.JTextField();
        txtMes = new javax.swing.JTextField();
        txtAnio = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblErrorNombre = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        btnGuardar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();

        setClosable(true);
        setIconifiable(true);
        setTitle("Formulario Carrera");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.add(cmbCoordinador, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 209, 268, -1));

        jLabel6.setText("Coordinador:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 189, -1, -1));

        lblErrorCodigo.setForeground(new java.awt.Color(204, 0, 0));
        lblErrorCodigo.setText("Solo debe ingresar letras.");
        jPanel1.add(lblErrorCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 173, 268, -1));
        jPanel1.add(txtCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 80, -1));

        jPanel1.add(cmbModalidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(108, 151, 170, -1));

        jLabel5.setText("Modalidad:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(108, 131, -1, -1));

        jLabel1.setText("Codigo:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, -1));

        lblErrorFecha.setForeground(new java.awt.Color(204, 0, 0));
        lblErrorFecha.setText("Ingrese una fecha valida. dd/mm/aaaa");
        jPanel1.add(lblErrorFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 268, -1));
        jPanel1.add(txtDia, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 30, -1));
        jPanel1.add(txtMes, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, 30, -1));
        jPanel1.add(txtAnio, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, 50, 20));

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("/");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, 10, 20));

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("/");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 10, 20));

        jLabel3.setText("Fecha inicio:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        lblErrorNombre.setForeground(new java.awt.Color(204, 0, 0));
        lblErrorNombre.setText("Solo debe ingresar letras.");
        jPanel1.add(lblErrorNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 268, -1));

        jLabel7.setText("Nombre:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, -1, -1));
        jPanel1.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 31, 268, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 294, -1));

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnGuardar.setText("Guardar");
        jPanel2.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 20, 80, -1));
        jPanel2.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 11, 294, 5));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 235, 294, 50));

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<String> cmbCoordinador;
    private javax.swing.JComboBox<String> cmbModalidad;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblErrorCodigo;
    private javax.swing.JLabel lblErrorFecha;
    private javax.swing.JLabel lblErrorNombre;
    private javax.swing.JTextField txtAnio;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtDia;
    private javax.swing.JTextField txtMes;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
