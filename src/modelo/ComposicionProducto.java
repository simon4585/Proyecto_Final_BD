package modelo;

import java.math.BigDecimal;

public class ComposicionProducto {
    private Integer idComposicion;
    private Integer idProducto;
    private Integer codigo; // materia prima
    private BigDecimal cantidadUsada;

    public ComposicionProducto() {}

    public ComposicionProducto(Integer idComposicion, Integer idProducto, Integer codigo, BigDecimal cantidadUsada) {
        this.idComposicion = idComposicion;
        this.idProducto = idProducto;
        this.codigo = codigo;
        this.cantidadUsada = cantidadUsada;
    }

    public Integer getIdComposicion() { return idComposicion; }
    public void setIdComposicion(Integer idComposicion) { this.idComposicion = idComposicion; }

    public Integer getIdProducto() { return idProducto; }
    public void setIdProducto(Integer idProducto) { this.idProducto = idProducto; }

    public Integer getCodigo() { return codigo; }
    public void setCodigo(Integer codigo) { this.codigo = codigo; }

    public BigDecimal getCantidadUsada() { return cantidadUsada; }
    public void setCantidadUsada(BigDecimal cantidadUsada) { this.cantidadUsada = cantidadUsada; }

    @Override
    public String toString() {
        return "ComposicionProducto{" +
                "idComposicion=" + idComposicion +
                ", idProducto=" + idProducto +
                ", codigo=" + codigo +
                ", cantidadUsada=" + cantidadUsada +
                '}';
    }
}
