/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador.silabo;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import modelo.ConexionBD;

import modelo.silabo.SilaboMD;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import vista.principal.VtnPrincipal;
import vista.silabos.frmSilabos;

/**
 * 
 * @author Andres Ullauri
 */
public class ControladorSilaboR {

    private SilaboMD silabo;

    private ConexionBD conexion;
    
    private frmSilabos crud;
    
    private VtnPrincipal principal;

    public ControladorSilaboR( frmSilabos crud, SilaboMD silabo, ConexionBD conexion, VtnPrincipal principal  ) {
        this.silabo = silabo;
        this.conexion = conexion;
        this.crud = crud;
        this.principal=principal;
    }

   

    public ControladorSilaboR() {
    }

    public void iniciarControlador(){
        
       crud.getBtnGenerar().addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent ae) {
               
               if (crud.getChbSilabo().isSelected()){
                   imprimirSilabo();
                   
               }else if (crud.getChbProgramaAnalitico().isSelected()){
                   imprimirProgramaAnalitico();
                   
               }else{
                   JOptionPane.showMessageDialog(null, "Debe seleccionar el documento antes de imprimir");
               }
               
             
              crud.dispose();
              
              principal.getBtnConsultarSilabo().doClick();
       
           }
           
       });
       
       
       crud.getChbProgramaAnalitico().addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent ae) {
               
               crud.getChbSilabo().setSelected(false);
           }
           
       });
       
       crud.getChbSilabo().addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent ae) {
               crud.getChbProgramaAnalitico().setSelected(false);
           }
           
       });
    }
    
    public void imprimirSilabo(){
        try {

            System.out.println("Imprimiendo.......");
            JasperReport jr = (JasperReport) JRLoader.loadObject(getClass().getResource("/vista/silabos/reportes/silabo2/primera_pag.jasper"));
            Map parametro = new HashMap();
            String par = "47";

            parametro.put("parameter1", String.valueOf(silabo.getIdMateria().getId()));
            parametro.put("id_silabo", String.valueOf(silabo.getIdSilabo()));
            JasperPrint jp = JasperFillManager.fillReport(jr, parametro, conexion.getCon());
            JasperViewer pv = new JasperViewer(jp, false);
            pv.setVisible(true);
            pv.setTitle("Sílabo");

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "error" + e);
        }
        
        
    }
    
    
    public void imprimirProgramaAnalitico(){
        try {

            System.out.println("Imprimiendo.......");
            JasperReport jr = (JasperReport) JRLoader.loadObject(getClass().getResource("/vista/silabos/reportes/silabo2/formato2/primerapag.jasper"));
            Map parametro = new HashMap();
            String par = "47";

            parametro.put("parameter1", String.valueOf(silabo.getIdMateria().getId()));
            parametro.put("id_silabo", String.valueOf(silabo.getIdSilabo()));
            JasperPrint jp = JasperFillManager.fillReport(jr, parametro, conexion.getCon());
            JasperViewer pv = new JasperViewer(jp, false);
            pv.setVisible(true);
            pv.setTitle("Programa Analítico");
            

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, " error" + e);
        }
    }
}