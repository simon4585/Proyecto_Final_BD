package modelo;

import java.math.BigDecimal;

public class MateriaPrima {
    private Integer codigo;
    private String tipo;
    private String descripcion;
    private BigDecimal cantidadDispo;
    private String unidadMedida;
    private boolean certificadoDispo;

    public MateriaPrima() {}

    public MateriaPrima(Integer codigo, String tipo, String descripcion, BigDecimal cantidadDispo, String unidadMedida, boolean certificadoDispo) {
        this.codigo = codigo;
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.cantidadDispo = cantidadDispo;
        this.unidadMedida = unidadMedida;
        this.certificadoDispo = certificadoDispo;
    }

    public Integer getCodigo() { return codigo; }
    public void setCodigo(Integer codigo) { this.codigo = codigo; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public BigDecimal getCantidadDispo() { return cantidadDispo; }
    public void setCantidadDispo(BigDecimal cantidadDispo) { this.cantidadDispo = cantidadDispo; }

    public String getUnidadMedida() { return unidadMedida; }
    public void setUnidadMedida(String unidadMedida) { this.unidadMedida = unidadMedida; }

    public boolean isCertificadoDispo() { return certificadoDispo; }
    public void setCertificadoDispo(boolean certificadoDispo) { this.certificadoDispo = certificadoDispo; }

    @Override
    public String toString() {
        return "MateriaPrima{" +
                "codigo=" + codigo +
                ", tipo='" + tipo + '\'' +
                ", cantidadDispo=" + cantidadDispo +
                '}';
    }
}
