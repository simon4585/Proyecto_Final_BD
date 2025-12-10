package modelo;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Pedido {
    private Integer idPedido;
    private LocalDate fechaPedido;
    private LocalDate fechaEntregaEstimada;
    private BigDecimal abono;
    private String medidas;
    private String estado;
    private String dniCliente; // FK hacia CLIENTE.DNI

    public Pedido() {}

    public Pedido(Integer idPedido, LocalDate fechaPedido, LocalDate fechaEntregaEstimada, BigDecimal abono, String medidas, String estado, String dniCliente) {
        this.idPedido = idPedido;
        this.fechaPedido = fechaPedido;
        this.fechaEntregaEstimada = fechaEntregaEstimada;
        this.abono = abono;
        this.medidas = medidas;
        this.estado = estado;
        this.dniCliente = dniCliente;
    }

    public Integer getIdPedido() { return idPedido; }
    public void setIdPedido(Integer idPedido) { this.idPedido = idPedido; }

    public LocalDate getFechaPedido() { return fechaPedido; }
    public void setFechaPedido(LocalDate fechaPedido) { this.fechaPedido = fechaPedido; }

    public LocalDate getFechaEntregaEstimada() { return fechaEntregaEstimada; }
    public void setFechaEntregaEstimada(LocalDate fechaEntregaEstimada) { this.fechaEntregaEstimada = fechaEntregaEstimada; }

    public BigDecimal getAbono() { return abono; }
    public void setAbono(BigDecimal abono) { this.abono = abono; }

    public String getMedidas() { return medidas; }
    public void setMedidas(String medidas) { this.medidas = medidas; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public String getDniCliente() { return dniCliente; }
    public void setDniCliente(String dniCliente) { this.dniCliente = dniCliente; }

    @Override
    public String toString() {
        return "Pedido{" +
                "idPedido=" + idPedido +
                ", fechaPedido=" + fechaPedido +
                ", estado='" + estado + '\'' +
                ", dniCliente='" + dniCliente + '\'' +
                '}';
    }
}
