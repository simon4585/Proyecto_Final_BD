package controladores;
import dao.UniformeDAO;
import modelo.Uniforme;
import java.util.List;

public class UniformeControlador {

    private UniformeDAO dao = new UniformeDAO();

    public boolean insertarUniforme(Uniforme u) {
        return dao.insertarUniforme(u);
    }

    public boolean actualizarUniforme(Uniforme u) {
        return dao.actualizarUniforme(u);
    }

    public boolean eliminarUniforme(int id) {
        return dao.eliminarUniforme(id);
    }

    public Uniforme buscarUniforme(int id) {
        return dao.buscarUniforme(id);
    }

    public List<Uniforme> listarUniformes() {
        return dao.listarUniformes(); }

}
