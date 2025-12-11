package controladores;

import dao.ProductoDAO;
import modelo.Producto;
import java.util.List;

public class ProductoControlador {

    private ProductoDAO dao = new ProductoDAO();

    public boolean insertarProducto(Producto p) {
        return dao.insertarProducto(p);
    }

    public boolean actualizarProducto(Producto p) {
        return dao.actualizarProducto(p);
    }

    public boolean eliminarProducto(int id) {
        return dao.eliminarProducto(id);
    }

    public Producto buscarProducto(int id) {
        return dao.buscarProducto(id);
    }

    public List<Producto> listarProductos() {
        return dao.listarProductos(); }
}
