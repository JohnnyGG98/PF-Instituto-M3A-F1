package controlador;

import controlador.principal.VtnPrincipalCTR;
import modelo.ConectarDB;
import modelo.persona.UsuarioMD;
import vista.principal.VtnPrincipal;

/**
 *
 * @author Johnny
 */
public class run {

    public static void main(String[] args) {
        estiloWindows();
        
        UsuarioMD usuario = new UsuarioMD();
        VtnPrincipal vtn = new VtnPrincipal(); 
        //Coneccion a la base de datos 
        ConectarDB conecta = new ConectarDB("Run.");
        VtnPrincipalCTR ctrVtnPrin = new VtnPrincipalCTR(vtn, usuario, conecta); 
        ctrVtnPrin.iniciar();
    }
    
    public static void estiloWindows(){
         try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VtnPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }
}
