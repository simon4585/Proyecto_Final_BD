package controladores;

import dao.DetallePedidoDAO;
import modelo.DetallePedido;
import java.util.List;

public class DetallePedidoControlador {

    private DetallePedidoDAO dao = new DetallePedidoDAO();

    public boolean insertarDetalle(DetallePedido d) {
        return dao.insertarDetalle(d);
    }

    public boolean actualizarDetalle(DetallePedido d) {
        return dao.actualizarDetalle(d);
    }

    public boolean eliminarDetalle(int id) {
        return dao.eliminarDetalle(id);
    }

    public List<DetallePedido> ConsultarPorPedido(int idPedido) {
        return dao.ConsultarPedido(idPedido);
    }
    public List<DetallePedido> listarDetallesPedido(){
        return dao.listarDetallesPedido();
    }
}
