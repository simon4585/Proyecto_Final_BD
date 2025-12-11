package modelo;

public class Uniforme {
    private Integer idUniforme;
    private String tipo;
    private String color;
    private String tipoTela;
    private boolean llevaBordado;
    private String lugarBordado;
    private String tipoBordado;
    private String estampado;
    private Integer idColegio;   // FK
    private Integer idProducto;  // FK

    public Uniforme() {}

    public Uniforme(Integer idUniforme, String tipo, String color, String tipoTela, boolean llevaBordado, String lugarBordado, String tipoBordado, String estampado, Integer idColegio, Integer idProducto) {
        this.idUniforme = idUniforme;
        this.tipo = tipo;
        this.color = color;
        this.tipoTela = tipoTela;
        this.llevaBordado = llevaBordado;
        this.lugarBordado = lugarBordado;
        this.tipoBordado = tipoBordado;
        this.estampado = estampado;
        this.idColegio = idColegio;
        this.idProducto = idProducto;
    }

    public Integer getIdUniforme() { return idUniforme; }
    public void setIdUniforme(Integer idUniforme) { this.idUniforme = idUniforme; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }

    public String getTipoTela() { return tipoTela; }
    public void setTipoTela(String tipoTela) { this.tipoTela = tipoTela; }

    public boolean isLlevaBordado() { return llevaBordado; }
    public void setLlevaBordado(boolean llevaBordado) { this.llevaBordado = llevaBordado; }

    public String getLugarBordado() { return lugarBordado; }
    public void setLugarBordado(String lugarBordado) { this.lugarBordado = lugarBordado; }

    public String getTipoBordado() { return tipoBordado; }
    public void setTipoBordado(String tipoBordado) { this.tipoBordado = tipoBordado; }

    public String getEstampado() { return estampado; }
    public void setEstampado(String estampado) { this.estampado = estampado; }

    public Integer getIdColegio() { return idColegio; }
    public void setIdColegio(Integer idColegio) { this.idColegio = idColegio; }

    public Integer getIdProducto() { return idProducto; }
    public void setIdProducto(Integer idProducto) { this.idProducto = idProducto; }

    @Override
    public String toString() {
        return "Uniforme{" +
                "idUniforme=" + idUniforme +
                ", tipo='" + tipo + '\'' +
                ", idColegio=" + idColegio +
                '}';
    }
}
