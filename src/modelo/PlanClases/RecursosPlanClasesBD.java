package modelo.PlanClases;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import modelo.ConnDBPool;

public class RecursosPlanClasesBD extends RecursosPlanClasesMD {

    private static final ConnDBPool CON = ConnDBPool.single();

    public RecursosPlanClasesBD() {
    }

    public boolean insertarRecursosPlanClases2(RecursosPlanClasesMD rP, int id_plan_clase) {
        PreparedStatement st = CON.prepareStatement("INSERT INTO public.\"RecursosPlanClases\"(\n"
                + "	 id_plan_clases, id_recurso)\n"
                + "	VALUES ( " + id_plan_clase + ", ?)");

        try {
            st.setInt(1, rP.getId_recursos().getId_recurso());
            st.executeUpdate();
            System.out.println(st);
        } catch (SQLException ex) {
            Logger.getLogger(RecursosPlanClasesBD.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            CON.close(st);
        }
        return true;
    }

    public boolean ActualizarRecursosPlanClases(RecursosPlanClasesMD rP) {

        PreparedStatement st = CON.prepareStatement("UPDATE public.\"RecursosPlanClases\"\n"
                + "	  set id_recurso =? \n"
                + "	WHERE id_plan_clases=? and id_recurso=?");
        try {
            st.setInt(1, rP.getId_recursos().getId_recurso());
            st.setInt(2, rP.getId_plan_clases().getID());
            st.setInt(3, rP.getId_recursos().getId_recurso());
            st.executeUpdate();
            System.out.println(st);
        } catch (SQLException ex) {
            Logger.getLogger(RecursosPlanClasesBD.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            CON.close(st);
        }
        return true;
    }

    public static List<RecursosPlanClasesMD> consultarRecursos() {
        List<RecursosPlanClasesMD> recursos = new ArrayList<>();

        PreparedStatement st = CON.prepareStatement("select id_recurso,nombre_recursos,tipo_recurso from \"Recursos\" order by nombre_recursos ");

        try {

            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                RecursosPlanClasesMD re = new RecursosPlanClasesMD();
                re.getId_recursos().setId_recurso(rs.getInt(1));
                re.getId_recursos().setNombre_recursos(rs.getString(2));
                re.getId_recursos().setTipo_recurso(rs.getString(3));

                recursos.add(re);
            }

        } catch (SQLException ex) {
            Logger.getLogger(RecursosPlanClasesBD.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            CON.close(st);
        }
        return recursos;
    }

    public static List<RecursosPlanClasesMD> consultarRecursosPlanClase(int id_plan_clase) {
        List<RecursosPlanClasesMD> recursos = new ArrayList<>();

        PreparedStatement st = CON.prepareStatement("select r.id_recurso,r.nombre_recursos from \"Recursos\" r join \"RecursosPlanClases\" rp on r.id_recurso=rp.id_recurso \n"
                + "where rp.id_plan_clases=? ");
        try {
            st.setInt(1, id_plan_clase);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                RecursosPlanClasesMD re = new RecursosPlanClasesMD();
                re.getId_recursos().setId_recurso(rs.getInt(1));
                re.getId_recursos().setNombre_recursos(rs.getString(2));
                recursos.add(re);
            }

        } catch (SQLException ex) {
            Logger.getLogger(RecursosPlanClasesBD.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            CON.close(st);
        }
        return recursos;
    }

}
