package vista.silabos;

import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Daniel
 */
public class frmPlanClase extends javax.swing.JFrame {

    /**
     * Creates new form frmPlanClase
     */
    public frmPlanClase() {
        initComponents();
       
    }

    public JButton getBtmnGuardarPc() {
        return btmnGuardarPc;
    }

    public void setBtmnGuardarPc(JButton btmnGuardarPc) {
        this.btmnGuardarPc = btmnGuardarPc;
    }

    public JButton getBtnCancelarPC() {
        return btnCancelarPC;
    }

    public void setBtnCancelarPC(JButton btnCancelarPC) {
        this.btnCancelarPC = btnCancelarPC;
    }

    public JDateChooser getjDateChooserFechaFinPC() {
        return jDateChooserFechaFinPC;
    }

    public void setjDateChooserFechaFinPC(JDateChooser jDateChooserFechaFinPC) {
        this.jDateChooserFechaFinPC = jDateChooserFechaFinPC;
    }

    public JDateChooser getjDateChooserFechaInicioPC() {
        return jDateChooserFechaInicioPC;
    }

    public void setjDateChooserFechaInicioPC(JDateChooser jDateChooserFechaInicioPC) {
        this.jDateChooserFechaInicioPC = jDateChooserFechaInicioPC;
    }

    public JList<String> getJlistEstrategiasPC() {
        return jlistEstrategiasPC;
    }

    public void setJlistEstrategiasPC(JList<String> jlistEstrategiasPC) {
        this.jlistEstrategiasPC = jlistEstrategiasPC;
    }

    public JList<String> getJlistIns_Evaluacion() {
        return jlistIns_Evaluacion;
    }

    public void setJlistIns_Evaluacion(JList<String> jlistIns_Evaluacion) {
        this.jlistIns_Evaluacion = jlistIns_Evaluacion;
    }

    public JList<String> getJlistRecursos() {
        return jlistRecursos;
    }

    public void setJlistRecursos(JList<String> jlistRecursos) {
        this.jlistRecursos = jlistRecursos;
    }

    public JLabel getLbAsignatura() {
        return lbAsignatura;
    }

    public void setLbAsignatura(JLabel lbAsignatura) {
        this.lbAsignatura = lbAsignatura;
    }

    public JLabel getLbCarrera() {
        return lbCarrera;
    }

    public void setLbCarrera(JLabel lbCarrera) {
        this.lbCarrera = lbCarrera;
    }

    public JLabel getLbCicloparalelo() {
        return lbCicloparalelo;
    }

    public void setLbCicloparalelo(JLabel lbCicloparalelo) {
        this.lbCicloparalelo = lbCicloparalelo;
    }

    public JLabel getLbCod_Asignatura() {
        return lbCod_Asignatura;
    }

    public void setLbCod_Asignatura(JLabel lbCod_Asignatura) {
        this.lbCod_Asignatura = lbCod_Asignatura;
    }

    public JLabel getLbContenidosPC() {
        return lbContenidosPC;
    }

    public void setLbContenidosPC(JLabel lbContenidosPC) {
        this.lbContenidosPC = lbContenidosPC;
    }

    public JLabel getLbDocente() {
        return lbDocente;
    }

    public void setLbDocente(JLabel lbDocente) {
        this.lbDocente = lbDocente;
    }

    public JLabel getLbDuracion() {
        return lbDuracion;
    }

    public void setLbDuracion(JLabel lbDuracion) {
        this.lbDuracion = lbDuracion;
    }

    public JLabel getLbEstrategiasPC() {
        return lbEstrategiasPC;
    }

    public void setLbEstrategiasPC(JLabel lbEstrategiasPC) {
        this.lbEstrategiasPC = lbEstrategiasPC;
    }

    public JLabel getLbFechaInicioPC() {
        return lbFechaInicioPC;
    }

    public void setLbFechaInicioPC(JLabel lbFechaInicioPC) {
        this.lbFechaInicioPC = lbFechaInicioPC;
    }

    public JLabel getLbFechafinPC() {
        return lbFechafinPC;
    }

    public void setLbFechafinPC(JLabel lbFechafinPC) {
        this.lbFechafinPC = lbFechafinPC;
    }

    public JLabel getLbIns_Evaluacion() {
        return lbIns_Evaluacion;
    }

    public void setLbIns_Evaluacion(JLabel lbIns_Evaluacion) {
        this.lbIns_Evaluacion = lbIns_Evaluacion;
    }

    public JLabel getLbNumeroPlandeClase() {
        return lbNumeroPlandeClase;
    }

    public void setLbNumeroPlandeClase(JLabel lbNumeroPlandeClase) {
        this.lbNumeroPlandeClase = lbNumeroPlandeClase;
    }

    public JLabel getLbObjetivoPC() {
        return lbObjetivoPC;
    }

    public void setLbObjetivoPC(JLabel lbObjetivoPC) {
        this.lbObjetivoPC = lbObjetivoPC;
    }

    public JLabel getLbObservacionesPC() {
        return lbObservacionesPC;
    }

    public void setLbObservacionesPC(JLabel lbObservacionesPC) {
        this.lbObservacionesPC = lbObservacionesPC;
    }

    public JLabel getLbPlandeClase() {
        return lbPlandeClase;
    }

    public void setLbPlandeClase(JLabel lbPlandeClase) {
        this.lbPlandeClase = lbPlandeClase;
    }

    public JLabel getLbRecursosPC() {
        return lbRecursosPC;
    }

    public void setLbRecursosPC(JLabel lbRecursosPC) {
        this.lbRecursosPC = lbRecursosPC;
    }

    public JLabel getLbResultadosAprendizaje() {
        return lbResultadosAprendizaje;
    }

    public void setLbResultadosAprendizaje(JLabel lbResultadosAprendizaje) {
        this.lbResultadosAprendizaje = lbResultadosAprendizaje;
    }

    public JLabel getLbTituloUnidad() {
        return lbTituloUnidad;
    }

    public void setLbTituloUnidad(JLabel lbTituloUnidad) {
        this.lbTituloUnidad = lbTituloUnidad;
    }

    public JLabel getLbTrabajoAutonomo() {
        return lbTrabajoAutonomo;
    }

    public void setLbTrabajoAutonomo(JLabel lbTrabajoAutonomo) {
        this.lbTrabajoAutonomo = lbTrabajoAutonomo;
    }

    public JLabel getLbUnidad() {
        return lbUnidad;
    }

    public void setLbUnidad(JLabel lbUnidad) {
        this.lbUnidad = lbUnidad;
    }

    public JTextArea getTxrContenidosPC() {
        return txrContenidosPC;
    }

    public void setTxrContenidosPC(JTextArea txrContenidosPC) {
        this.txrContenidosPC = txrContenidosPC;
    }

    public JTextArea getTxrObjetivoPC() {
        return txrObjetivoPC;
    }

    public void setTxrObjetivoPC(JTextArea txrObjetivoPC) {
        this.txrObjetivoPC = txrObjetivoPC;
    }

    public JTextArea getTxrObservacionesPc() {
        return txrObservacionesPc;
    }

    public void setTxrObservacionesPc(JTextArea txrObservacionesPc) {
        this.txrObservacionesPc = txrObservacionesPc;
    }

    public JTextArea getTxrResulatdosAprendizaje() {
        return txrResulatdosAprendizaje;
    }

    public void setTxrResulatdosAprendizaje(JTextArea txrResulatdosAprendizaje) {
        this.txrResulatdosAprendizaje = txrResulatdosAprendizaje;
    }

    public JTextArea getTxrTrabajoAutonomo() {
        return txrTrabajoAutonomo;
    }

    public void setTxrTrabajoAutonomo(JTextArea txrTrabajoAutonomo) {
        this.txrTrabajoAutonomo = txrTrabajoAutonomo;
    }

    public JTextField getTxtAsignatura() {
        return txtAsignatura;
    }

    public void setTxtAsignatura(JTextField txtAsignatura) {
        this.txtAsignatura = txtAsignatura;
    }

    public JTextField getTxtCarrera() {
        return txtCarrera;
    }

    public void setTxtCarrera(JTextField txtCarrera) {
        this.txtCarrera = txtCarrera;
    }

    public JTextField getTxtCicloParalelo() {
        return txtCicloParalelo;
    }

    public void setTxtCicloParalelo(JTextField txtCicloParalelo) {
        this.txtCicloParalelo = txtCicloParalelo;
    }

    public JTextField getTxtCod_Asignatura() {
        return txtCod_Asignatura;
    }

    public void setTxtCod_Asignatura(JTextField txtCod_Asignatura) {
        this.txtCod_Asignatura = txtCod_Asignatura;
    }

    public JTextField getTxtDocente() {
        return txtDocente;
    }

    public void setTxtDocente(JTextField txtDocente) {
        this.txtDocente = txtDocente;
    }

    public JTextField getTxtDuracion() {
        return txtDuracion;
    }

    public void setTxtDuracion(JTextField txtDuracion) {
        this.txtDuracion = txtDuracion;
    }

    public JTextField getTxtTituloUnidad() {
        return txtTituloUnidad;
    }

    public void setTxtTituloUnidad(JTextField txtTituloUnidad) {
        this.txtTituloUnidad = txtTituloUnidad;
    }

    public JTextField getTxtUnidad() {
        return txtUnidad;
    }

    public void setTxtUnidad(JTextField txtUnidad) {
        this.txtUnidad = txtUnidad;
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
        txrObjetivoPC = new javax.swing.JTextArea();
        txtDocente = new javax.swing.JTextField();
        lbPlandeClase = new javax.swing.JLabel();
        lbDocente = new javax.swing.JLabel();
        txtCarrera = new javax.swing.JTextField();
        lbCarrera = new javax.swing.JLabel();
        lbNumeroPlandeClase = new javax.swing.JLabel();
        lbAsignatura = new javax.swing.JLabel();
        txtAsignatura = new javax.swing.JTextField();
        lbCod_Asignatura = new javax.swing.JLabel();
        txtCod_Asignatura = new javax.swing.JTextField();
        txtTituloUnidad = new javax.swing.JTextField();
        lbTituloUnidad = new javax.swing.JLabel();
        jDateChooserFechaInicioPC = new com.toedter.calendar.JDateChooser();
        lbFechaInicioPC = new javax.swing.JLabel();
        lbDuracion = new javax.swing.JLabel();
        txtDuracion = new javax.swing.JTextField();
        lbCicloparalelo = new javax.swing.JLabel();
        txtCicloParalelo = new javax.swing.JTextField();
        lbObjetivoPC = new javax.swing.JLabel();
        lbContenidosPC = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jlistRecursos = new javax.swing.JList<>();
        lbEstrategiasPC = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jlistIns_Evaluacion = new javax.swing.JList<>();
        lbRecursosPC = new javax.swing.JLabel();
        lbIns_Evaluacion = new javax.swing.JLabel();
        jDateChooserFechaFinPC = new com.toedter.calendar.JDateChooser();
        lbFechafinPC = new javax.swing.JLabel();
        lbTrabajoAutonomo = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        txrContenidosPC = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        txrTrabajoAutonomo = new javax.swing.JTextArea();
        lbObservacionesPC = new javax.swing.JLabel();
        btmnGuardarPc = new javax.swing.JButton();
        btnCancelarPC = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        jlistEstrategiasPC = new javax.swing.JList<>();
        jScrollPane7 = new javax.swing.JScrollPane();
        txrObservacionesPc = new javax.swing.JTextArea();
        txtUnidad = new javax.swing.JTextField();
        lbUnidad = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        txrResulatdosAprendizaje = new javax.swing.JTextArea();
        lbResultadosAprendizaje = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txrObjetivoPC.setEditable(false);
        txrObjetivoPC.setColumns(20);
        txrObjetivoPC.setRows(5);
        txrObjetivoPC.setText("SADASD\nDASD\nASDASD\nASDAS\nDAS\nDAS\nDAS\nDA\nSD\nAS\nDAS\nD\nASD\nAS\nDAS\nDAS\nD\nAS\nDAS\nDA\nSD");
        jScrollPane1.setViewportView(txrObjetivoPC);

        lbPlandeClase.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        lbPlandeClase.setText("Plan de Clase");

        lbDocente.setText("Docente:");

        txtCarrera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCarreraActionPerformed(evt);
            }
        });

        lbCarrera.setText("Carrera:");

        lbNumeroPlandeClase.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        lbNumeroPlandeClase.setText("N°");

        lbAsignatura.setText("Asignatura:");

        txtAsignatura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAsignaturaActionPerformed(evt);
            }
        });

        lbCod_Asignatura.setText("Código asignatura: ");

        txtCod_Asignatura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCod_AsignaturaActionPerformed(evt);
            }
        });

        txtTituloUnidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTituloUnidadActionPerformed(evt);
            }
        });

        lbTituloUnidad.setText("Titulo de la Unidad:");

        lbFechaInicioPC.setText("Fecha de inicio:");

        lbDuracion.setText("Duración:");

        txtDuracion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDuracionActionPerformed(evt);
            }
        });

        lbCicloparalelo.setText("Ciclo-Paralelo:");

        txtCicloParalelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCicloParaleloActionPerformed(evt);
            }
        });

        lbObjetivoPC.setText("Objetivos:");

        lbContenidosPC.setText("Contenidos:");

        jlistRecursos.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane3.setViewportView(jlistRecursos);

        lbEstrategiasPC.setText("Estrategias:");

        jlistIns_Evaluacion.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane4.setViewportView(jlistIns_Evaluacion);

        lbRecursosPC.setText("Recursos:");

        lbIns_Evaluacion.setText("Instrumento de Evaluación:");

        lbFechafinPC.setText("Fecha de fin:");

        lbTrabajoAutonomo.setText("Trabajo Autónomo");

        txrContenidosPC.setColumns(20);
        txrContenidosPC.setRows(5);
        jScrollPane5.setViewportView(txrContenidosPC);

        txrTrabajoAutonomo.setColumns(20);
        txrTrabajoAutonomo.setRows(5);
        jScrollPane2.setViewportView(txrTrabajoAutonomo);

        lbObservacionesPC.setText("Observaciones:");

        btmnGuardarPc.setText("Guardar");

        btnCancelarPC.setText("Cancelar");

        jlistEstrategiasPC.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane6.setViewportView(jlistEstrategiasPC);

        txrObservacionesPc.setColumns(20);
        txrObservacionesPc.setRows(5);
        jScrollPane7.setViewportView(txrObservacionesPc);

        lbUnidad.setText("Unidad:");

        txrResulatdosAprendizaje.setEditable(false);
        txrResulatdosAprendizaje.setColumns(20);
        txrResulatdosAprendizaje.setRows(5);
        txrResulatdosAprendizaje.setText("SADASD\nDASD\nASDASD\nASDAS\nDAS\nDAS\nDAS\nDA\nSD\nAS\nDAS\nD\nASD\nAS\nDAS\nDAS\nD\nAS\nDAS\nDA\nSD");
        jScrollPane8.setViewportView(txrResulatdosAprendizaje);

        lbResultadosAprendizaje.setText("Resultados de Aprendizaje:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(515, 515, 515)
                        .addComponent(lbPlandeClase)
                        .addGap(18, 18, 18)
                        .addComponent(lbNumeroPlandeClase))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(btnCancelarPC)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btmnGuardarPc))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(25, 25, 25)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(lbDocente)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(txtDocente, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(lbCarrera)
                                            .addGap(21, 21, 21)
                                            .addComponent(txtCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(12, 12, 12)
                                            .addComponent(lbFechaInicioPC)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jDateChooserFechaFinPC, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(19, 19, 19)
                                            .addComponent(lbFechafinPC)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jDateChooserFechaInicioPC, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(lbAsignatura)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txtAsignatura, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGap(24, 24, 24)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(lbCod_Asignatura)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txtCod_Asignatura, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(lbCicloparalelo)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(txtCicloParalelo, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(lbDuracion)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txtDuracion, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(lbUnidad)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txtUnidad, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(lbTituloUnidad)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(txtTituloUnidad))))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(lbEstrategiasPC)
                                                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGap(18, 18, 18)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(lbIns_Evaluacion))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(lbRecursosPC)
                                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(lbObjetivoPC))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(lbResultadosAprendizaje)
                                                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane5)
                                        .addComponent(jScrollPane7)
                                        .addComponent(jScrollPane2)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(lbTrabajoAutonomo)
                                                .addComponent(lbObservacionesPC)
                                                .addComponent(lbContenidosPC))
                                            .addGap(0, 0, Short.MAX_VALUE))))))))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbPlandeClase)
                    .addComponent(lbNumeroPlandeClase))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtCod_Asignatura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtCicloParalelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbCicloparalelo)
                        .addComponent(lbDuracion)
                        .addComponent(txtDuracion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbCarrera)
                        .addComponent(txtCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtAsignatura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbAsignatura)
                        .addComponent(lbCod_Asignatura)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbFechafinPC)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jDateChooserFechaFinPC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtDocente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbFechaInicioPC)
                                    .addComponent(lbDocente)))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lbUnidad)
                                .addComponent(txtUnidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbTituloUnidad)
                                .addComponent(txtTituloUnidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jDateChooserFechaInicioPC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbObjetivoPC)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 3, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(lbContenidosPC, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(lbResultadosAprendizaje)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbRecursosPC)
                            .addComponent(lbIns_Evaluacion)
                            .addComponent(lbTrabajoAutonomo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbObservacionesPC)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane7))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lbEstrategiasPC)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btmnGuardarPc)
                    .addComponent(btnCancelarPC))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtAsignaturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAsignaturaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAsignaturaActionPerformed

    private void txtCod_AsignaturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCod_AsignaturaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCod_AsignaturaActionPerformed

    private void txtTituloUnidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTituloUnidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTituloUnidadActionPerformed

    private void txtDuracionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDuracionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDuracionActionPerformed

    private void txtCicloParaleloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCicloParaleloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCicloParaleloActionPerformed

    private void txtCarreraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCarreraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCarreraActionPerformed

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
            java.util.logging.Logger.getLogger(frmPlanClase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmPlanClase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmPlanClase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmPlanClase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmPlanClase().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btmnGuardarPc;
    private javax.swing.JButton btnCancelarPC;
    private com.toedter.calendar.JDateChooser jDateChooserFechaFinPC;
    private com.toedter.calendar.JDateChooser jDateChooserFechaInicioPC;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JList<String> jlistEstrategiasPC;
    private javax.swing.JList<String> jlistIns_Evaluacion;
    private javax.swing.JList<String> jlistRecursos;
    private javax.swing.JLabel lbAsignatura;
    private javax.swing.JLabel lbCarrera;
    private javax.swing.JLabel lbCicloparalelo;
    private javax.swing.JLabel lbCod_Asignatura;
    private javax.swing.JLabel lbContenidosPC;
    private javax.swing.JLabel lbDocente;
    private javax.swing.JLabel lbDuracion;
    private javax.swing.JLabel lbEstrategiasPC;
    private javax.swing.JLabel lbFechaInicioPC;
    private javax.swing.JLabel lbFechafinPC;
    private javax.swing.JLabel lbIns_Evaluacion;
    private javax.swing.JLabel lbNumeroPlandeClase;
    private javax.swing.JLabel lbObjetivoPC;
    private javax.swing.JLabel lbObservacionesPC;
    private javax.swing.JLabel lbPlandeClase;
    private javax.swing.JLabel lbRecursosPC;
    private javax.swing.JLabel lbResultadosAprendizaje;
    private javax.swing.JLabel lbTituloUnidad;
    private javax.swing.JLabel lbTrabajoAutonomo;
    private javax.swing.JLabel lbUnidad;
    private javax.swing.JTextArea txrContenidosPC;
    private javax.swing.JTextArea txrObjetivoPC;
    private javax.swing.JTextArea txrObservacionesPc;
    private javax.swing.JTextArea txrResulatdosAprendizaje;
    private javax.swing.JTextArea txrTrabajoAutonomo;
    private javax.swing.JTextField txtAsignatura;
    private javax.swing.JTextField txtCarrera;
    private javax.swing.JTextField txtCicloParalelo;
    private javax.swing.JTextField txtCod_Asignatura;
    private javax.swing.JTextField txtDocente;
    private javax.swing.JTextField txtDuracion;
    private javax.swing.JTextField txtTituloUnidad;
    private javax.swing.JTextField txtUnidad;
    // End of variables declaration//GEN-END:variables
}
