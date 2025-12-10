package modelo;

public class Suministro {
    private Integer idSuministro;
    private String nit; // FK proveedor
    private Integer codigo; // FK materia prima

    public Suministro() {}

    public Suministro(Integer idSuministro, String nit, Integer codigo) {
        this.idSuministro = idSuministro;
        this.nit = nit;
        this.codigo = codigo;
    }

    public Integer getIdSuministro() { return idSuministro; }
    public void setIdSuministro(Integer idSuministro) { this.idSuministro = idSuministro; }

    public String getNit() { return nit; }
    public void setNit(String nit) { this.nit = nit; }

    public Integer getCodigo() { return codigo; }
    public void setCodigo(Integer codigo) { this.codigo = codigo; }

    @Override
    public String toString() {
        return "Suministro{" +
                "idSuministro=" + idSuministro +
                ", nit='" + nit + '\'' +
                ", codigo=" + codigo +
                '}';
    }
}
