package dto;

public class ProductoPendienteClienteDTO {

    private int idProducto;
    private String tipoProducto;
    private String descripcion;
    private int cantidad;
    private int idPedido;

    public ProductoPendienteClienteDTO() {}

    public ProductoPendienteClienteDTO(int idProducto, String tipoProducto, String descripcion,
                                       int cantidad, int idPedido) {
        this.idProducto = idProducto;
        this.tipoProducto = tipoProducto;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.idPedido = idPedido;
    }

    public int getIdProducto() { return idProducto; }
    public void setIdProducto(int idProducto) { this.idProducto = idProducto; }

    public String getTipoProducto() { return tipoProducto; }
    public void setTipoProducto(String tipoProducto) { this.tipoProducto = tipoProducto; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public int getCantidad() { return cantidad; }
    public void setCantidad(int cantidad) { this.cantidad = cantidad; }

    public int getIdPedido() { return idPedido; }
    public void setIdPedido(int idPedido) { this.idPedido = idPedido; }
}
