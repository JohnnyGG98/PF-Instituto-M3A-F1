package modelo.silabo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.estrategiasUnidad.EstrategiasUnidadMD;
import modelo.silabo.mbd.IEstrategiaUnidadSilaboBD;
import utils.CONBD;

/**
 *
 * @author gus
 */
public class NEWEstrategiaUnidadBD extends CONBD implements IEstrategiaUnidadSilaboBD {

    private static NEWEstrategiaUnidadBD EUBD;

    public static NEWEstrategiaUnidadBD single() {
        if (EUBD == null) {
            EUBD = new NEWEstrategiaUnidadBD();
        }
        return EUBD;
    }

    private static final String QUERYBYS = "SELECT id_estrategia_unidad, "
            + "eu.id_unidad, "
            + "eu.id_estrategia, "
            + "ea.descripcion_estrategia, "
            + "us.numero_unidad  "
            + "FROM public.\"EstrategiasUnidad\" eu, "
            + "public.\"UnidadSilabo\" us, "
            + "public.\"EstrategiasAprendizaje\" ea "
            + "WHERE eu.id_unidad = us.id_unidad "
            + "AND eu.id_estrategia = ea.id_estrategia "
            + "AND id_silabo=?;";

    private static final String DELETE = "DELETE FROM public.\"EstrategiasUnidad\" "
            + "WHERE id_estrategia_unidad = ?;";

    @Override
    public int guardar(EstrategiasUnidadMD e, int idUnidad) {
        String sql = "INSERT INTO public.\"EstrategiasUnidad\"("
                + " id_unidad, "
                + "id_estrategia) "
                + "VALUES (?, ?);";
        PreparedStatement ps = CON.getPSID(sql);
        try {
            ps.setInt(1, idUnidad);
            ps.setInt(2, e.getEstrategia().getIdEstrategia());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,
                    "Error al guardar la estrategia unidad. \n"
                    + ex.getMessage(),
                    "Error estragia unidad",
                    JOptionPane.ERROR_MESSAGE
            );
        }
        return CON.getIDGenerado(ps);
    }

    public int editar(EstrategiasUnidadMD e) {
        String sql = "UPDATE public.\"EstrategiasUnidad\" "
                + "SET id_estrategia=? "
                + "WHERE id_estrategia_unidad=?;";
        PreparedStatement ps = CON.getPSID(sql);
        try {
            ps.setInt(1, e.getEstrategia().getIdEstrategia());
            ps.setInt(2, e.getIdEstrategiaUnidad());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,
                    "Error al guardar la estrategia unidad. \n"
                    + ex.getMessage(),
                    "Error estragia unidad",
                    JOptionPane.ERROR_MESSAGE
            );
        }
        return CON.getIDGenerado(ps);
    }

    @Override
    public List<EstrategiasUnidadMD> getBySilabo(int idSilabo) {
        String sql = QUERYBYS;
        List<EstrategiasUnidadMD> EUS = new ArrayList<>();
        PreparedStatement ps = CON.getPSPOOL(sql);
        try {
            ps.setInt(1, idSilabo);
            ResultSet res = ps.executeQuery();
            while (res.next()) {
                EstrategiasUnidadMD eu = new EstrategiasUnidadMD();
                eu.setIdEstrategiaUnidad(res.getInt(1));
                eu.getUnidad().setId(res.getInt(2));
                eu.getEstrategia().setIdEstrategia(res.getInt(3));
                eu.getEstrategia().setDescripcionEstrategia(res.getString(4));
                eu.getUnidad().setNumeroUnidad(res.getInt(5));

                EUS.add(eu);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,
                    "No consultamos estrategias por id silabo. \n"
                    + e.getMessage(),
                    "Error al consultar",
                    JOptionPane.ERROR_MESSAGE
            );
        } finally {
            CON.cerrarCONPS(ps);
        }
        return EUS;
    }

    public List<EstrategiasUnidadMD> getBySilaboReferencia(int idSilabo) {
        String sql = QUERYBYS;
        List<EstrategiasUnidadMD> EUS = new ArrayList<>();
        PreparedStatement ps = CON.getPSPOOL(sql);
        try {
            ps.setInt(1, idSilabo);
            ResultSet res = ps.executeQuery();
            while (res.next()) {
                EstrategiasUnidadMD eu = new EstrategiasUnidadMD();
                eu.setIdEstrategiaUnidad(0);
                eu.getUnidad().setId(res.getInt(2));
                eu.getEstrategia().setIdEstrategia(res.getInt(3));
                eu.getEstrategia().setDescripcionEstrategia(res.getString(4));
                eu.getUnidad().setNumeroUnidad(res.getInt(5));

                EUS.add(eu);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,
                    "No consultamos estrategias por id silabo. \n"
                    + e.getMessage(),
                    "Error al consultar",
                    JOptionPane.ERROR_MESSAGE
            );
        } finally {
            CON.cerrarCONPS(ps);
        }
        return EUS;
    }

    @Override
    public List<EstrategiasUnidadMD> getBySilaboUnidad(int idSilabo, int numUnidad) {
        String sql = "SELECT "
                + "DISTINCT ea.descripcion_estrategia "
                + "FROM public.\"EstrategiasUnidad\" eu, "
                + "public.\"UnidadSilabo\" us, "
                + "public.\"EstrategiasAprendizaje\" ea "
                + "WHERE eu.id_unidad = us.id_unidad "
                + "AND eu.id_estrategia = ea.id_estrategia "
                + "AND id_silabo=? AND numero_unidad=?";
        List<EstrategiasUnidadMD> EUS = new ArrayList<>();
        PreparedStatement ps = CON.getPSPOOL(sql);
        try {
            ps.setInt(1, idSilabo);
            ps.setInt(2, numUnidad);
            ResultSet res = ps.executeQuery();
            while (res.next()) {
                EstrategiasUnidadMD eu = new EstrategiasUnidadMD();
                eu.getEstrategia().setDescripcionEstrategia(res.getString(1));

                EUS.add(eu);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,
                    "No consultamos estrategias por id silabo y unidad. \n"
                    + e.getMessage(),
                    "Error al consultar",
                    JOptionPane.ERROR_MESSAGE
            );
        } finally {
            CON.cerrarCONPS(ps);
        }
        return EUS;
    }

    public void eliminarAll(List<EstrategiasUnidadMD> estrategias) {
        String sql = DELETE;
        PreparedStatement ps = CON.getPSPOOL(sql);

        estrategias.forEach(e -> {
            try {
                ps.setInt(1, e.getIdEstrategiaUnidad());
                ps.addBatch();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,
                        "No pudimos agregar delete al banch\n"
                        + ex.getMessage(),
                        "Error al eliminar",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        });

        try {
            ps.executeBatch();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,
                    "No ejecutamos el batch \n"
                    + e.getMessage(),
                    "Error al eliminar",
                    JOptionPane.ERROR_MESSAGE
            );
        } finally {
            CON.cerrarCONPS(ps);
        }
    }
    
    public boolean eliminar(int idEstrategiaUnidad){
        return CON.deleteById(DELETE, idEstrategiaUnidad);
    }

}
