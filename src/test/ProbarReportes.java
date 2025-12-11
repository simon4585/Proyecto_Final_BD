package test;

import dao.ReportesDAO;
import modelo.Producto;
import modelo.Colegio;
import modelo.Uniforme;

import java.util.List;

public class ProbarReportes {

    public static void main(String[] args) {

        ReportesDAO reportes = new ReportesDAO();

        System.out.println("========== 1. PRODUCTOS PENDIENTES ==========");
        List<Producto> pendientes = reportes.productosEncargadosPendientes();
        pendientes.forEach(p -> System.out.println(
                p.getIdProducto() + " - " + p.getTipoProducto() + " - " + p.getDescripcion()
        ));

        System.out.println("\n========== 2. PENDIENTES POR CLIENTE ==========");
        List<Producto> porCliente = reportes.productosPendientesPorCliente("1001"); // cambia el dni
        porCliente.forEach(p -> System.out.println(
                p.getIdProducto() + " - " + p.getTipoProducto() + " - " + p.getDescripcion()
        ));

        System.out.println("\n========== 3. EXISTENCIA CON ENCARGOS ==========");
        List<Producto> existencia = reportes.existenciaConEncargos();
        existencia.forEach(p -> System.out.println(
                p.getIdProducto() + " - " + p.getTipoProducto() + " - Disponible: " + p.getCantidadExistente()
        ));

        System.out.println("\n========== 4. LISTADO COLEGIOS ==========");
        List<Colegio> colegios = reportes.listadoColegios();
        colegios.forEach(c -> System.out.println(
                c.getIdColegio() + " - " + c.getNombre()
        ));

        System.out.println("\n========== 5. UNIFORMES POR COLEGIO ==========");
        List<Uniforme> uniformes = reportes.uniformesPorColegio(5); // cambia el id
        uniformes.forEach(u -> {
            System.out.println("------ UNIFORME ------");
            System.out.println("ID: " + u.getIdUniforme());
            System.out.println("Tipo: " + u.getTipo());
            System.out.println("Color: " + u.getColor());
            System.out.println("Tipo de Tela: " + u.getTipoTela());
            System.out.println("Lleva Bordado: " + u.isLlevaBordado());
            System.out.println("Lugar Bordado: " + u.getLugarBordado());
            System.out.println("Tipo Bordado: " + u.getTipoBordado());
            System.out.println("Estampado: " + u.getEstampado());
            System.out.println("ID Colegio: " + u.getIdColegio());
            System.out.println("ID Producto: " + u.getIdProducto());
        });


        System.out.println("\n========== 6. PRODUCTOS VENDIDOS POR COLEGIO ==========");
        List<ReportesDAO.ProductosVendidosPorColegio> vendidos =
                reportes.totalProductosVendidosPorColegio();
        vendidos.forEach(v -> System.out.println(
                "Colegio: " + v.getNombreColegio() +
                        " | Producto: " + v.getIdProducto() +
                        " | Vendidos: " + v.getTotalVendidos()
        ));

        System.out.println("\n========== 7. TOTAL DE VENTAS ==========");
        System.out.println("TOTAL VENTAS: " + reportes.totalVentas());

    }
}