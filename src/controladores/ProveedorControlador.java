package controladores;

import dao.ProveedorDAO;
import modelo.Proveedor;
import java.util.List;

public class ProveedorControlador {

    private ProveedorDAO dao = new ProveedorDAO();

    public boolean insertarProveedor(Proveedor p) {
        return dao.insertarProveedor(p);
    }

    public boolean actualizarProveedor(Proveedor p) {
        return dao.actualizarProveedor(p);
    }

    public boolean eliminarProveedor(String nit) {
        return dao.eliminarProveedor(nit); }

    public Proveedor buscarProveedor(String nit) {return dao.buscarProveedor(nit);
    }

    public List<Proveedor> listarProveedores() {
        return dao.listarProveedores(); }
}
