

import java.util.Map;

public class RespuestaAPI {
    private String base;
    private String fecha;
    private Map<String, Double> tasa;

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Map<String, Double> getTasa() {
        return tasa;
    }

    public void setTasa(Map<String, Double> tasa) {
        this.tasa = tasa;
    }
}


