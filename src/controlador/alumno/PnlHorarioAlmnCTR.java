package controlador.alumno;

import java.time.LocalTime;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.curso.SesionClaseMD;
import modelo.estilo.TblEstilo;
import vista.curso.PnlHorarioClase;

/**
 *
 * @author Johnny
 */
public class PnlHorarioAlmnCTR {

    private final String[] hm = {"07:00", "08:00", "09:00", "10:00", "11:00", "12:00", "13:00",
        "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00", "22:00"};
    private final String[] hmc = {
        "<html>07:00<br>08:00</html>",
        "<html>08:00<br>09:00</html>",
        "<html>09:00<br>10:00</html>",
        "<html>10:00<br>11:00</html>",
        "<html>11:00<br>12:00</html>",
        "<html>12:00<br>13:00</html>",
        "<html>14:00<br>15:00</html>",
        "<html>15:00<br>16:00</html>",
        "<html>16:00<br>17:00</html>",
        "<html>17:00<br>18:00</html>",
        "<html>18:00<br>19:00</html>",
        "<html>19:00<br>20:00</html>",
        "<html>20:00<br>21:00</html>",
        "<html>21:00<br>22:00</html>"};
    private DefaultTableModel mdTbl;
    private final ArrayList<SesionClaseMD> sesiones;
    private final PnlHorarioClase pnl;

    public PnlHorarioAlmnCTR(ArrayList<SesionClaseMD> sesion, PnlHorarioClase pnl) {
        this.sesiones = sesion;
        this.pnl = pnl;
    }

    public void iniciar() {
        iniciaTbl();
        
        llenarTbl(sesiones);
    }

    private void iniciaTbl() {
        String[][] datos = {};
        String[] t = {"H", "Lunes", "Martes", "Miercoles", "Jueves", "Viernes"};

        mdTbl = TblEstilo.modelTblSinEditar(datos, t);
        formatoTbl(pnl.getTblHorario());
        llenarHoras(hmc);

    }

    private void formatoTbl(JTable tbl) {
        tbl.setModel(mdTbl);
        //TblEstilo.formatoTblConColor(tbl);
        TblEstilo.formatoTblHCurso(tbl);
    }

    private void llenarHoras(String[] horas) {
        for (String h : horas) {
            Object[] v = {h};
            mdTbl.addRow(v);
        }
    }

    private void llenarTbl(ArrayList<SesionClaseMD> sesiones) {
        if (sesiones != null) {
            sesiones.forEach(s -> {
                buscarClm(s);
            });
        }
    }

    private ArrayList<SesionClaseMD> sesionesDia(ArrayList<SesionClaseMD> sesiones, int dia) {
        ArrayList<SesionClaseMD> sd = new ArrayList<>();
        sesiones.forEach(s -> {
            if (s.getDia() == dia) {
                sd.add(s);
            }
        });
        return sd;
    }

    private void buscarClm(SesionClaseMD s) {
        int posI = -1, posF = -1;
        int dia = s.getDia();

        for (int i = 0; i < hm.length; i++) {
            if (hm[i].equals(tranformar(s.getHoraIni()))) {
                posI = i;
                break;
            }
        }

        for (int i = 0; i < hm.length; i++) {
            if (hm[i].equals(tranformar(s.getHoraFin()))) {
                posF = i;
                break;
            }
        }

        if (posI >= 0 && posF >= 0) {
            for (int i = posI; i < posF; i++) {
                mdTbl.setValueAt("<html> <center>" + s.getId() + "" + s.getCurso().getId_curso() + "<br>"
                        + s.getCurso().getId_materia().getCodigo() + "<br>"
                        + s.getCurso().getId_docente().getNombreCorto() + "</center></html>",
                        i, dia);
            }
        }
    }

    private String tranformar(LocalTime hora) {
        String horaString, minutoString;
        if (hora.getHour() < 10) {
            horaString = "0" + hora.getHour();
        } else {
            horaString = "" + hora.getHour();
        }

        if (hora.getMinute() < 10) {
            minutoString = "0" + hora.getMinute();
        } else {
            minutoString = "" + hora.getMinute();
        }
        return horaString + ":" + minutoString;
    }

}
