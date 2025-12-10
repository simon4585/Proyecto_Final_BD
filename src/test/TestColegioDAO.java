package test;

import dao.ColegioDAO;
import modelo.Colegio;

import java.sql.SQLException;

public class TestColegioDAO {

    public static void main(String[] args) throws SQLException {

        ColegioDAO dao = new ColegioDAO();

        /*// 1️⃣ Insertar un colegio
        Colegio nuevo = new Colegio(0, "Diego rengifo", "Calle 123", "3004567890");

        boolean insertado = dao.insertarColegio(nuevo);
        System.out.println("Insertado: " + insertado);*/


        // 2️⃣ Listar colegios
        /*
        System.out.println("\nListado de colegios:");
        for (Colegio c : dao.ListarColegios()) {
            System.out.println(c);
        }
        */

        // 3️⃣ Buscar colegio
        /*
        System.out.println("\nBuscando colegio con id 4:");
        Colegio buscado = dao.buscarColegio(4);
        System.out.println("Encontrado: " + buscado);
        */

        // 4️⃣ Actualizar colegio
        /*
        nuevo.setIdColegio(4);
        nuevo.setNombre("Colegio Actualizado");
        nuevo.setDireccion("Nueva Dirección 555");
        nuevo.setTelefono("3119001122");

        boolean actualizado = dao.actualizarColegio(nuevo);
        System.out.println("\nActualizado: " + actualizado);
        */

        // 5️⃣ Eliminar colegio
        /*boolean eliminado = dao.eliminarColegio(4);
        System.out.println("\nEliminado: " + eliminado);*/
    }
}
