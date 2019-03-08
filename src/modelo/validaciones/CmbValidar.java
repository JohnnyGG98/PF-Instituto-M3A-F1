package modelo.validaciones;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;
import javax.swing.JLabel;

/**
 *
 * @author Johnny
 */
public class CmbValidar implements ActionListener {

    private final JComboBox cmb;
    private final JLabel lbl;

    private int pos;

    public CmbValidar(JComboBox cmb, JLabel lbl) {
        this.cmb = cmb;
        this.lbl = lbl;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        pos = cmb.getSelectedIndex();
        if (pos > 0) {
            cmb.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
            lbl.setVisible(false);
        } else {
            cmb.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
            lbl.setVisible(true);
        }
    }

}
