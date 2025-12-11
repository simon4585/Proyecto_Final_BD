package controladores;

import dao.SuministroDAO;
import modelo.Suministro;
import java.util.List;

public class SuministroControlador {

    private SuministroDAO dao = new SuministroDAO();

    public boolean insertarSuministro(Suministro s) {
        return dao.insertarSuministro(s);
    }


    public boolean eliminarSuministro(int id) {
        return dao.eliminarSuministro(id);
    }

    public Suministro buscarSuministro(int id) {
        return dao.buscarSuministro(id);
    }

    public List<Suministro> listarSuministros() {
        return dao.listarSuministros();
    }
}
