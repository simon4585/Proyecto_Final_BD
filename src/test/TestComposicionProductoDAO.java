package test;

import dao.ComposicionProductoDAO;
import modelo.ComposicionProducto;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

public class TestComposicionProductoDAO {

    public static void main(String[] args) throws SQLException {

        ComposicionProductoDAO dao = new ComposicionProductoDAO();

        // 1️⃣ Insertar una composición
        // Ajusta el constructor si tu modelo tiene otro orden/firmas
        /*ComposicionProducto nueva = new ComposicionProducto();
        // si tienes constructor: new ComposicionProducto(idComposicion, idProducto, codigo, cantidadUsada)
        // nueva = new ComposicionProducto(0, 1, 101, new BigDecimal("2.5"));

        nueva.setIdProducto(1);                    // id del producto al que pertenece la composición
        nueva.setCodigo(10);                      // código de materia prima (o lo que use tu app)
        nueva.setCantidadUsada(new BigDecimal("2.5"));


        boolean insertado = dao.insertarComposicion(nueva);
        System.out.println("Insertado: " + insertado);*/


        // 2️⃣ Listar composiciones por producto
        /*
        int idProductoParaListar = 1;
        List<ComposicionProducto> lista = dao.listarPorProducto(idProductoParaListar);
        System.out.println("\nComposiciones para producto id=" + idProductoParaListar + ":");
        for (ComposicionProducto c : lista) {
            System.out.println(c);
        }*/


        // 3️⃣ Eliminar composición (usa el id_composicion real de la fila que quieras borrar)
        /*
        int idAEliminar = 1;
        boolean eliminado = dao.eliminarComposicion(idAEliminar);
        System.out.println("\nEliminado composicion id=" + idAEliminar + ": " + eliminado);
        */

        // 4️⃣ Flujo completo de prueba: insertar -> listar -> eliminar -> listar
        /*
        // insertar
        boolean okIns = dao.insertarComposicion(nueva);
        System.out.println("Insertado: " + okIns);

        // listar después de insertar (buscar por el mismo idProducto)
        List<ComposicionProducto> despuesIns = dao.listarPorProducto(nueva.getIdProducto());
        System.out.println("\nDespues de insertar:");
        despuesIns.forEach(System.out::println);

        // si obtienes el id_composicion desde la BD (si tu DAO lo devuelve o lo buscas), elimina uno:
        if (!despuesIns.isEmpty()) {
            int idReciente = despuesIns.get(despuesIns.size() - 1).getIdComposicion(); // último insertado (si aplica)
            boolean okDel = dao.eliminarComposicion(idReciente);
            System.out.println("\nEliminado id " + idReciente + ": " + okDel);

            // listar de nuevo
            List<ComposicionProducto> despuesDel = dao.listarPorProducto(nueva.getIdProducto());
            System.out.println("\nDespues de eliminar:");
            despuesDel.forEach(System.out::println);
        } else {
            System.out.println("No se encontraron composiciones después de insertar. Revisa la inserción.");
        }
        */

        System.out.println("\nTest finalizado.");
    }
}
