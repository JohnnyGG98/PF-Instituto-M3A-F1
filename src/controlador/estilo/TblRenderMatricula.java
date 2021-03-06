package controlador.estilo;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Johnny
 */
public class TblRenderMatricula extends DefaultTableCellRenderer {

    private final int clm;

    public TblRenderMatricula(int clm) {
        this.clm = clm;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean selected,
            boolean focused, int row, int column) {
        super.getTableCellRendererComponent(table, value, selected, focused, row, column);
        setBackground(Color.white);
        setForeground(Color.BLACK);
        if (clm == column) {
            if (value != null) {
                if (value.toString().charAt(0) == 'C') {
                    setBackground(Color.red);
                } else if (value.toString().charAt(0) == '0') {
                    setBackground(Color.YELLOW);
                }
            }
        }
        return this;
    }

}
