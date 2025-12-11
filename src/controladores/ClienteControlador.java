package controladores;

import dao.ClienteDAO;
import modelo.Cliente;

import java.sql.SQLException;
import java.util.ArrayList;

public class ClienteControlador {

    private ClienteDAO dao = new ClienteDAO();

    public boolean insertarCliente(Cliente c) {
        return dao.insertarCliente(c);
    }

    public boolean actualizarCliente(Cliente c) {
        return dao.actualizarCliente(c);
    }

    public boolean eliminarCliente(String dni) throws SQLException {
        return dao.eliminarCliente(dni);
    }

    public Cliente buscarCliente(String dni) {
        return dao.buscarCliente(dni);
    }

    public ArrayList<Cliente> listarClientes() {
        return dao.ListarClientes();
    }
}
