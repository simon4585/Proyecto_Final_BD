package controladores;


import dao.ReportesDAO;
import dto.ProductoPendienteClienteDTO;
import dto.ProductoPendienteDTO;
import modelo.Colegio;
import modelo.Pedido;
import modelo.Producto;
import modelo.Uniforme;

import java.math.BigDecimal;
import java.util.List;

public class ReportesControlador {

    private ReportesDAO dao;

    public ReportesControlador() {
        dao = new ReportesDAO();
    }

    // 1. Listado de productos encargados pendientes por entregar (ordenados por fecha)
    public List<ProductoPendienteDTO> productosPendientes() {
        return dao.productosEncargadosPendientes();
    }



    // 2. Por cada cliente, listar los productos encargados que no han sido entregados

    public List<ProductoPendienteClienteDTO> productosPendientesPorCliente(String dni) {
        return dao.productosPendientesPorCliente(dni);
    }


    // 3.Por cada producto, cantidad en existencia descontando los que están encargados

    public List<Producto> existenciaConEncargos() {
        return dao.existenciaConEncargos();
    }

    // 4.Listado de colegios de los que se fabrican uniformes

    public List<Colegio> listadoColegios() {
        return dao.listadoColegios();
    }


    // 5. Dado un colegio las características de su uniforme

    public List<Uniforme> uniformesPorColegio(int idColegio) {
        return dao.uniformesPorColegio(idColegio);
    }


    // 6. Calcular el total de productos vendidos por colegio

    public List<ReportesDAO.ProductosVendidosPorColegio> totalProductosVendidosPorColegio() {
        return dao.totalProductosVendidosPorColegio();
    }


    // 7. Calcular el total de ventas (dinero)
    public BigDecimal totalVentas() {
        return dao.totalVentas();
    }
}
