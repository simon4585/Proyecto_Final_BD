package modelo;

import java.math.BigDecimal;

public class Producto {
    private Integer idProducto;
    private String tipoProducto;
    private Integer cantidadExistente;
    private BigDecimal precioVenta;
    private String sexo;
    private String talla;
    private String descripcion;

    public Producto() {}

    public Producto(Integer idProducto, String tipoProducto, Integer cantidadExistente, BigDecimal precioVenta, String sexo, String talla, String descripcion) {
        this.idProducto = idProducto;
        this.tipoProducto = tipoProducto;
        this.cantidadExistente = cantidadExistente;
        this.precioVenta = precioVenta;
        this.sexo = sexo;
        this.talla = talla;
        this.descripcion = descripcion;
    }

    public Integer getIdProducto() { return idProducto; }
    public void setIdProducto(Integer idProducto) { this.idProducto = idProducto; }

    public String getTipoProducto() { return tipoProducto; }
    public void setTipoProducto(String tipoProducto) { this.tipoProducto = tipoProducto; }

    public Integer getCantidadExistente() { return cantidadExistente; }
    public void setCantidadExistente(Integer cantidadExistente) { this.cantidadExistente = cantidadExistente; }

    public BigDecimal getPrecioVenta() { return precioVenta; }
    public void setPrecioVenta(BigDecimal precioVenta) { this.precioVenta = precioVenta; }

    public String getSexo() { return sexo; }
    public void setSexo(String sexo) { this.sexo = sexo; }

    public String getTalla() { return talla; }
    public void setTalla(String talla) { this.talla = talla; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    @Override
    public String toString() {
        return "Producto{" +
                "idProducto=" + idProducto +
                ", tipoProducto='" + tipoProducto + '\'' +
                ", cantidadExistente=" + cantidadExistente +
                ", precioVenta=" + precioVenta +
                '}';
    }
}
