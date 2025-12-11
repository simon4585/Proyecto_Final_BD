package controladores;

import dao.FacturaDAO;
import modelo.Factura;
import java.util.List;

public class FacturaControlador {

    private FacturaDAO dao = new FacturaDAO();

    public int insertarFactura(Factura f) {
        return dao.insertarFactura(f);
    }

    public Factura buscarFactura(int id) {
        return dao.buscarFactura(id);
    }

    public List<Factura> listarFacturas() {
        return dao.listarFacturas();
    }
}
