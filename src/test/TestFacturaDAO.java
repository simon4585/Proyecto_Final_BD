package test;

import dao.FacturaDAO;
import modelo.Factura;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.sql.SQLException;
import java.util.List;

public class TestFacturaDAO {

    public static void main(String[] args) throws SQLException {

        FacturaDAO dao = new FacturaDAO();

        // 1️⃣ Insertar una factura
        Factura nueva = new Factura();
        // si tu modelo tiene un constructor, puedes usarlo en vez de setters:
        // new Factura(0, LocalDate.now(), new BigDecimal("12345.67"), 1);

        /*nueva.setFecha(LocalDate.now());
        nueva.setTotal(new BigDecimal("45000.50"));
        nueva.setIdPedido(1); // asegúrate que exista el pedido con id 1 en la BD


        int idGenerado = dao.insertarFactura(nueva);
        System.out.println("ID generado de la factura: " + idGenerado);*/


        // 2️⃣ Listar facturas
        /*
        System.out.println("\nListado de facturas:");
        List<Factura> lista = dao.listarFacturas();
        for (Factura f : lista) {
            System.out.println(f);
        }
        */


        // 3️⃣ Buscar factura por id
        /*
        int idABuscar = 7;
        Factura encontrada = dao.buscarFactura(idABuscar);
        System.out.println("\nFactura buscada (id=" + idABuscar + "): " + encontrada);
        */

        // 4️⃣ Eliminar factura
        /*
        int idAEliminar = 6; // cambia por el id que quieras eliminar
        boolean eliminado = dao.eliminarFactura(idAEliminar);
        System.out.println("\nEliminado factura id=" + idAEliminar + ": " + eliminado);
        */

        // 5️⃣ Flujo completo: insertar -> listar -> buscar -> eliminar

        /*
        int idInsert = dao.insertarFactura(nueva);
        System.out.println("Insertada factura con id: " + idInsert);

        if (idInsert > 0) {
            System.out.println("\nListado después de insertar:");
            dao.listarFacturas().forEach(System.out::println);

            System.out.println("\nBuscando factura insertada:");
            System.out.println(dao.buscarFactura(idInsert));

            System.out.println("\nEliminando factura insertada...");
            boolean ok = dao.eliminarFactura(idInsert);
            System.out.println("Eliminada: " + ok);

            System.out.println("\nListado después de eliminar:");
            dao.listarFacturas().forEach(System.out::println);
        } else {
            System.out.println("La inserción devolvió id inválido. Revisa la inserción.");
        }*/


        System.out.println("\nTest finalizado.");
    }
}
