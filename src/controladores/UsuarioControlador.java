package controladores;

import dao.UsuarioDAO;
import modelo.Usuario;
import java.util.List;

public class UsuarioControlador {

    private UsuarioDAO dao = new UsuarioDAO();

    public Usuario login(String user, String pass) {
        return dao.login(user, pass); }

    public boolean insertarUsuario(Usuario u) { return dao.insertarUsuario(u);
    }

    public boolean eliminarUsuario(int id) {
        return dao.eliminarUsuario(id);
    }

    public boolean actualizarUsuario(int id,Usuario u) {
        return dao.actualizarUsuario(id,u);
    }

    public Usuario buscarUsuario(int id) {
        return dao.buscarUsuario(id);
    }

    public List<Usuario> listarUsuarios() {
        return dao.listarUsuarios();
    }
}
