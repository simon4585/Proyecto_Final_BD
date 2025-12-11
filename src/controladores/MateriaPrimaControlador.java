package controladores;

import dao.MateriaPrimaDAO;
import modelo.MateriaPrima;
import java.util.List;

public class MateriaPrimaControlador {

    private MateriaPrimaDAO dao = new MateriaPrimaDAO();

    public boolean insertarMateriaPrima(MateriaPrima m) {
        return dao.insertarMateriaPrima(m);
    }

    public boolean actualizarMateriaPrima(MateriaPrima m) {
        return dao.actualizarMateriaPrima(m);
    }

    public boolean eliminarMateriaPrima(int codigo) {
        return dao.eliminarMateriaPrima(codigo);
    }

    public MateriaPrima buscarMateriaPrima(int codigo) {
        return dao.buscarMateriaPrima(codigo);
    }

    public List<MateriaPrima> listarMateriasPrimas() {
        return dao.listarMateriaPrima();
    }
}
