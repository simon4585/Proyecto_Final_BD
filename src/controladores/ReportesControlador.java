package controladores;


import dao.ReportesDAO;
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

    // 1. Productos pendientes por entregar (ordenados por fecha)

    public List<Producto> productosEncargadosPendientes() {
        return dao.productosEncargadosPendientes();
    }


    // 2. Productos encargados por cliente

    public List<Producto> productosPendientesPorCliente(String dni) {
        return dao.productosPendientesPorCliente(dni);
    }


    // 3. Cantidad en existencia descontando encargados

    public List<Producto> existenciaConEncargos() {
        return dao.existenciaConEncargos();
    }

    // 4. Listado de colegios en los que se fabrican uniforme

    public List<Colegio> listadoColegios() {
        return dao.listadoColegios();
    }


    // 5. Dado un colegio las características de su uniforme

    public List<Uniforme> caracteristicasUniformePorColegio(int idColegio) {
        return dao.uniformesPorColegio(idColegio);
    }


    // 6. Calcular el total de productos vendidos por colegio

    public List<ReportesDAO.ProductosVendidosPorColegio> totalProductosVendidosPorColegio() {
        return dao.totalProductosVendidosPorColegio();
    }


    // 7. Calcular el total de productos vendidos por colegio
    public BigDecimal totalVentas() {
        return dao.totalVentas();
    }
}
