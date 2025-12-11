package controladores;

import dao.ComposicionProductoDAO;
import modelo.ComposicionProducto;

import java.util.ArrayList;

public class ComposicionProductoControlador {

    private ComposicionProductoDAO composicionProductoDAO = new ComposicionProductoDAO();
    public boolean insertarComposicionProducto(ComposicionProducto composicionProducto) {
        return composicionProductoDAO.insertarComposicion(composicionProducto);
    }
    public boolean actualizarComposicionProducto(ComposicionProducto composicionProducto) {
        return composicionProductoDAO.actualizarComposicion(composicionProducto);
    }
    public boolean eliminarComposicionProducto(int id) {
        return composicionProductoDAO.eliminarComposicion(id);
    }
    public ComposicionProducto consultarComposicion(int id) {
        return composicionProductoDAO.consultarComposicion(id);

    }
    public ArrayList<ComposicionProducto> listarComposicionProducto() {
        return composicionProductoDAO.listarComposiciones();

    }

}
