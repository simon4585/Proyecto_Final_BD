package modelo;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Factura {
    private Integer idFactura;
    private LocalDate fecha;
    private BigDecimal total;
    private Integer idPedido; // FK

    public Factura() {}

    public Factura(Integer idFactura, LocalDate fecha, BigDecimal total, Integer idPedido) {
        this.idFactura = idFactura;
        this.fecha = fecha;
        this.total = total;
        this.idPedido = idPedido;
    }

    public Integer getIdFactura() { return idFactura; }
    public void setIdFactura(Integer idFactura) { this.idFactura = idFactura; }

    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }

    public BigDecimal getTotal() { return total; }
    public void setTotal(BigDecimal total) { this.total = total; }

    public Integer getIdPedido() { return idPedido; }
    public void setIdPedido(Integer idPedido) { this.idPedido = idPedido; }

    @Override
    public String toString() {
        return "Factura{" +
                "idFactura=" + idFactura +
                ", fecha=" + fecha +
                ", total=" + total +
                '}';
    }
}
