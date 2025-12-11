package test;

//import dao.ClienteDAO;
import dao.ColegioDAO;
import java.sql.SQLException;
import modelo.Colegio;

public class TestClienteDAO {
    public static void main(String[] args) throws SQLException {

        ColegioDAO dao = new ColegioDAO();

        // 1️⃣ Insertar un cliente
        @SuppressWarnings("unused")
        Colegio nuevoColegio = new Colegio(3,"Antonio nariño", "cra11#312","12341314");
        /*
        boolean insertado = dao.insertarColegio(nuevo);
        System.out.println("Insertado: " + insertado);

        // 2️⃣ Listar clientes
        System.out.println("\nListado de colegio:");
        for (Colegio c : dao.ListarColegios()) {
            System.out.println(c);
        }*/
        /*
        // 3️⃣ Buscar cliente
        System.out.println("\nBuscando cliente con DNI 123:");
        Colegio buscado = dao.buscarColegio(4);
        System.out.println("Encontrado: " + buscado);*/
    /*
        // 4️⃣ Actualizar cliente
        nuevoColegio.setIdColegio(4);
        nuevoColegio.setNombre("colegio actualizado");
        nuevoColegio.setTelefono("3148887777");
        nuevoColegio.setDireccion("Santa Clara");
        boolean actualizado = dao.actualizarColegio(nuevoColegio);
        System.out.println("\nActualizado: " + actualizado);*/
        // 5️⃣ Eliminar cliente
        boolean eliminado = dao.eliminarColegio(4);
        System.out.println("\nEliminado: " + eliminado);
    }
}
