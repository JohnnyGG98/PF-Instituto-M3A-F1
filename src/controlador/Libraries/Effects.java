package controlador.Libraries;

import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyVetoException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.Timer;
import org.slf4j.LoggerFactory;

/**
 *
 * @author MrRainx
 */
public class Effects {

    private static final Cursor LOAD_CURSOR;
    private static final Cursor DEFAULT_CURSOR;

    private static org.slf4j.Logger LOGGER = LoggerFactory.getLogger(Effects.class);

    static {
        LOAD_CURSOR = new Cursor(Cursor.WAIT_CURSOR);
        DEFAULT_CURSOR = new Cursor(Cursor.DEFAULT_CURSOR);
    }

    public static void addInDesktopPane(JInternalFrame component, JDesktopPane desktop) {
        try {
            centerFrame(component, desktop);
            desktop.add(component);
            component.setSelected(true);
            component.setVisible(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(Middlewares.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println("-------THREADS-------->" + Thread.activeCount());
    }

    public static synchronized void eliminarThread(Thread thread) {
        thread = null;
    }

    public static void centerFrame(JInternalFrame view, JDesktopPane desktop) {

        int deskWidth = (desktop.getWidth() / 2) - (view.getWidth() / 2);
        int deskHeight = (desktop.getHeight() / 2) - (view.getHeight() / 2);

        if (desktop.getHeight() < 500) {
            deskHeight = 0;
        }
        view.setLocation(deskWidth, deskHeight);
    }

    public static void setTextInLabel(JLabel component, String message, Color color, int time) {
        if (color != null) {
            component.setForeground(color);
        }
        setText(component, message, time);
    }

    public static void setText(JLabel component, String text, int time) {
        component.setText(text);
        Timer task = new Timer(time * 1000, e -> {
            component.setText("");
        });
        task.setRepeats(false);
        task.start();
    }

    public static void setLoadCursor(Container view) {
        view.setCursor(LOAD_CURSOR);

    }

    public static void setDefaultCursor(Container view) {
        view.setCursor(DEFAULT_CURSOR);
    }

    public static void btnHover(JButton btnIngresar, JLabel lblBtnHover, Color enterColor, Color exitColor) {
        btnIngresar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                lblBtnHover.setBackground(enterColor);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                lblBtnHover.setBackground(exitColor);
            }
        });
    }

}
