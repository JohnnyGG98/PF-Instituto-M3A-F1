package modelo.EstrategiasMetodologicas;

import modelo.PlanClases.PlandeClasesMD;
import modelo.estrategiasUnidad.EstrategiasUnidadMD;

public class EstrategiasMetodologicasMD {

    private Integer id_estrategias_metodologicas;
    private String tipo_estrategias_metodologicas;
    private PlandeClasesMD id_plan_clases;
    private EstrategiasUnidadMD id_estrategias_unidad;
    private String nombre_estrategia;
    private String UUID;

    public String getNombre_estrategia() {
        return nombre_estrategia;
    }

    public void setNombre_estrategia(String nombre_estrategia) {
        this.nombre_estrategia = nombre_estrategia;
    }

    public EstrategiasMetodologicasMD() {
        this.id_plan_clases = new PlandeClasesMD();
        this.id_estrategias_unidad = new EstrategiasUnidadMD();
    }

    public EstrategiasMetodologicasMD(String tipo_estrategias_metodologicas, String nombre_estrategia) {
        this.tipo_estrategias_metodologicas = tipo_estrategias_metodologicas;
        this.nombre_estrategia = nombre_estrategia;
        this.id_plan_clases = new PlandeClasesMD();
    }

    public Integer getId_estrategias_metodologicas() {
        return id_estrategias_metodologicas;
    }

    public void setId_estrategias_metodologicas(Integer id_estrategias_metodologicas) {
        this.id_estrategias_metodologicas = id_estrategias_metodologicas;
    }

    public String getTipo_estrategias_metodologicas() {
        return tipo_estrategias_metodologicas;
    }

    public void setTipo_estrategias_metodologicas(String tipo_estrategias_metodologicas) {
        this.tipo_estrategias_metodologicas = tipo_estrategias_metodologicas;
    }

    public PlandeClasesMD getId_plan_clases() {
        return id_plan_clases;
    }

    public void setId_plan_clases(PlandeClasesMD id_plan_clases) {
        this.id_plan_clases = id_plan_clases;
    }

    public EstrategiasUnidadMD getId_estrategias_unidad() {
        return id_estrategias_unidad;
    }

    public void setId_estrategias_unidad(EstrategiasUnidadMD id_estrategias_unidad) {
        this.id_estrategias_unidad = id_estrategias_unidad;
    }

    public String getUUID() {
        return UUID;
    }

    public void setUUID(String UUID) {
        this.UUID = UUID;
    }

}
