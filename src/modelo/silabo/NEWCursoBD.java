package modelo.silabo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.ConnDBPool;
import modelo.curso.CursoMD;
import modelo.silabo.mbd.ICursoBD;

/**
 *
 * @author gus
 */
public class NEWCursoBD implements ICursoBD {

    private final ConnDBPool CON = ConnDBPool.single();

    private static NEWCursoBD CBD;

    public static NEWCursoBD single() {
        if (CBD == null) {
            CBD = new NEWCursoBD();
        }
        return CBD;
    }

    @Override
    public List<CursoMD> getDocentePeriodoMateria(String nombreMateria, int idDocente, int idPeriodo) {
        String sql = "SELECT DISTINCT c.id_curso,"
                + "c.curso_nombre "
                + "FROM public.\"Cursos\" c "
                + "JOIN public.\"Docentes\" d ON c.id_docente = d.id_docente "
                + "JOIN public.\"Personas\" p ON d.id_persona = p.id_persona "
                + "JOIN public.\"Materias\" m on c.id_materia = m.id_materia\n"
                + "WHERE p.id_persona=? "
                + "AND c.id_prd_lectivo = ? "
                + "AND m.materia_nombre=?";
        PreparedStatement ps = CON.getPSPOOL(sql);
        List<CursoMD> CS = new ArrayList<>();

        try {
            ps.setInt(1, idDocente);
            ps.setInt(2, idPeriodo);
            ps.setString(3, nombreMateria);
            ResultSet res = ps.executeQuery();
            while (res.next()) {
                CursoMD cur = new CursoMD();
                cur.setId(res.getInt(1));
                cur.setNombre(res.getString(2));
                CS.add(cur);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,
                    "Error al consultar cursos por periodo . "
                    + e.getMessage());
        } finally {
            CON.cerrarCONPS(ps);
        }
        return CS;
    }

    @Override
    public int getNumeroAlumnos(int idCurso) {
        int num = 0;
        String sql = "SELECT count(id_alumno) "
                + "FROM public.\"AlumnoCurso\" "
                + "WHERE id_curso = ?;";
        PreparedStatement ps = CON.getPSPOOL(sql);
        try {
            ps.setInt(1, idCurso);
            ResultSet res = ps.executeQuery();
            while (res.next()) {
                num = res.getInt(1);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,
                    "Error al consultar numero de alumnos. "
                    + e.getMessage());
        } finally {
            CON.cerrarCONPS(ps);
        }
        return num;
    }

    @Override
    public List<CursoMDS> getByCurso(int idCurso) {
        String sql = "";
        List<CursoMDS> CS = new ArrayList<>();
        PreparedStatement ps = CON.getPSPOOL(sql);
        try {
            ps.setInt(1, idCurso);
            ResultSet res = ps.executeQuery();
            while (res.next()) {
                CursoMDS c = new CursoMDS();
                c.getId_carrera().setNombre(res.getString(1));
                c.getId_materia().setNombre(res.getString(2));
                c.getId_materia().setCodigo(res.getString(3));
                c.setCurso_nombre(res.getString(4));
                c.getId_persona().setPrimerNombre(res.getString(5));
                c.getId_persona().setPrimerApellido(res.getString(6));
                CS.add(c);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,
                    "Error al consultar curso para silabo. "
                    + e.getMessage());
        } finally {
            CON.cerrarCONPS(ps);
        }
        return CS;
    }

}