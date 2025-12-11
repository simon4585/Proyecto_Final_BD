package controladores;

import dao.PedidoDAO;
import modelo.Pedido;
import java.util.List;

public class PedidoControlador {

    private PedidoDAO dao = new PedidoDAO();

    public int insertarPedido(Pedido p) {
        return dao.insertarPedido(p);
    }

    public boolean actualizarEstadoPedido(int idPedido, String nuevoEstado) {
        return dao.actualizarEstadoPedido(idPedido, nuevoEstado);
    }

    public boolean eliminarPedido(int id) {
        return dao.eliminarPedido(id);
    }

    public Pedido buscarPedido(int id) {
        return dao.buscarPedido(id);
    }

    public List<Pedido> listarPedidos() {
        return dao.listarPedidos();
    }
}
