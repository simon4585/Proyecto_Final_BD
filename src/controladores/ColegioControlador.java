package controladores;
import java.sql.SQLException;
import java.util.ArrayList;
import dao.ColegioDAO;
import modelo.Colegio;


public class ColegioControlador {
    private ColegioDAO dao= new ColegioDAO();

    public boolean insertarColegio(Colegio colegio) {
        return dao.insertarColegio(colegio);
    }
    public boolean actualizarColegio(Colegio colegio) {
        return dao.actualizarColegio(colegio);
    }
    public boolean eliminarColegio(int id) throws SQLException {
        return dao.eliminarColegio(id);
    }
    public Colegio buscarColegio(int id) throws SQLException {
        return dao.buscarColegio(id);
    }
    public ArrayList<Colegio> listarColegio() throws SQLException {
        return dao.ListarColegios();
    }
}
