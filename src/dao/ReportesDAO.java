package dao;


import conexionBD.SQLConnection;
import modelo.Producto;
import modelo.Colegio;
import modelo.Uniforme;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;

public class ReportesDAO {

    // 1) Listado de productos encargados pendientes por entregar (ordenados por fecha)
    public List<Producto> productosEncargadosPendientes() {
        List<Producto> lista = new ArrayList<>();
        String sql = """
            SELECT pr.id_producto, pr.tipo_producto, pr.descripcion, dp.cantidad, p.fecha_pedido
            FROM pedido p
            JOIN detalle_pedido dp ON p.id_pedido = dp.id_pedido
            JOIN producto pr ON dp.id_producto = pr.id_producto
            WHERE p.estado <> 'Entregado'
            ORDER BY p.fecha_pedido;
            """;
        try (Connection con = SQLConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Producto pr = new Producto();
                pr.setIdProducto(rs.getInt("id_producto"));
                pr.setTipoProducto(rs.getString("tipo_producto"));
                pr.setDescripcion(rs.getString("descripcion"));
                pr.setCantidadExistente(rs.getInt("cantidad"));

                // opcional: set cantidad en el modelo si existe
                lista.add(pr);
            }
        } catch (SQLException e) {
            System.out.println("Error reporte pendientes: " + e.getMessage());
        }
        return lista;
    }

    // 2) Por cada cliente, listar los productos encargados que no han sido entregados
    public List<Producto> productosPendientesPorCliente(String dni) {
        List<Producto> lista = new ArrayList<>();
        String sql = """
            SELECT pr.id_producto, pr.tipo_producto, pr.descripcion, dp.cantidad, p.id_pedido
            FROM pedido p
            JOIN detalle_pedido dp ON p.id_pedido = dp.id_pedido
            JOIN producto pr ON dp.id_producto = pr.id_producto
            WHERE p.dni = ? AND p.estado <> 'Entregado'
            ORDER BY p.fecha_pedido;
            """;
        try (Connection con = SQLConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, dni);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Producto pr = new Producto();
                pr.setIdProducto(rs.getInt("id_producto"));
                pr.setTipoProducto(rs.getString("tipo_producto"));
                pr.setDescripcion(rs.getString("descripcion"));
                // si quieres, set cantidad con un setter en Producto
                lista.add(pr);
            }
        } catch (SQLException e) {
            System.out.println("Error reporte por cliente: " + e.getMessage());
        }
        return lista;
    }

    // 3) Por cada producto, cantidad en existencia descontando los que están encargados
    public List<Producto> existenciaConEncargos() {
        List<Producto> lista = new ArrayList<>();
        String sql = """
            SELECT pr.id_producto, pr.tipo_producto, pr.cantidad_existente - COALESCE(sum(dp.cantidad) FILTER (WHERE p.estado <> 'Entregado'),0) AS disponible
            FROM producto pr
            LEFT JOIN detalle_pedido dp ON pr.id_producto = dp.id_producto
            LEFT JOIN pedido p ON dp.id_pedido = p.id_pedido
            GROUP BY pr.id_producto, pr.tipo_producto, pr.cantidad_existente;
            """;
        try (Connection con = SQLConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Producto pr = new Producto();
                pr.setIdProducto(rs.getInt("id_producto"));
                pr.setTipoProducto(rs.getString("tipo_producto"));
                pr.setCantidadExistente(rs.getInt("disponible"));
                lista.add(pr);
            }
        } catch (SQLException e) {
            System.out.println("Error existencia con encargos: " + e.getMessage());
        }
        return lista;
    }

    // 4) Listado de colegios de los que se fabrican uniformes
    public List<Colegio> listadoColegios() {
        List<Colegio> lista = new ArrayList<>();
        String sql = "SELECT DISTINCT c.* FROM colegio c JOIN uniforme u ON c.id_colegio = u.id_colegio";
        try (Connection con = SQLConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Colegio c = new Colegio();
                c.setIdColegio(rs.getInt("id_colegio"));
                c.setNombre(rs.getString("nombre"));
                c.setDireccion(rs.getString("direccion"));
                c.setTelefono(rs.getString("telefono"));
                lista.add(c);
            }
        } catch (SQLException e) {
            System.out.println("Error listado colegios: " + e.getMessage());
        }
        return lista;
    }

    // 5) Dado un colegio las características de su uniforme
    public List<Uniforme> uniformesPorColegio(int idColegio) {
        List<Uniforme> lista = new ArrayList<>();
        String sql = "SELECT * FROM uniforme WHERE id_colegio = ?";
        try (Connection con = SQLConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idColegio);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Uniforme u = new Uniforme();
                u.setIdUniforme(rs.getInt("id_uniforme"));
                u.setTipo(rs.getString("tipo"));
                u.setColor(rs.getString("color"));
                u.setTipoTela(rs.getString("tipo_tela"));
                u.setLlevaBordado(rs.getBoolean("lleva_bordado"));
                u.setLugarBordado(rs.getString("lugar_bordado"));
                u.setTipoBordado(rs.getString("tipo_bordado"));
                u.setEstampado(rs.getString("estampado"));
                u.setIdColegio(rs.getInt("id_colegio"));
                u.setIdProducto(rs.getInt("id_producto"));
                lista.add(u);
            }
        } catch (SQLException e) {
            System.out.println("Error uniformes por colegio: " + e.getMessage());
        }
        return lista;
    }

    // 6) Calcular el total de productos vendidos por colegio
    public List<ProductosVendidosPorColegio> totalProductosVendidosPorColegio() {
        List<ProductosVendidosPorColegio> lista = new ArrayList<>();
        String sql = """
                SELECT
                c.id_colegio,
                c.nombre AS nombre_colegio,
                pr.id_producto,
                pr.tipo_producto,
                SUM(dp.cantidad) AS total_vendidos
            FROM colegio c
            JOIN uniforme u ON c.id_colegio = u.id_colegio
            JOIN producto pr ON u.id_producto = pr.id_producto
            JOIN detalle_pedido dp ON pr.id_producto = dp.id_producto
            JOIN pedido ped ON dp.id_pedido = ped.id_pedido
            WHERE ped.estado = 'Entregado'
            GROUP BY
                c.id_colegio,
                c.nombre,
                pr.id_producto,
                pr.tipo_producto
            ORDER BY c.nombre;
            
            """;
        try (Connection con = SQLConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            ResultSetMetaData md = rs.getMetaData();


            while (rs.next()) {
                ProductosVendidosPorColegio item = new ProductosVendidosPorColegio();
                item.setIdColegio(rs.getInt("id_colegio"));
                item.setNombreColegio(rs.getString("nombre_colegio"));
                item.setIdProducto(rs.getInt("id_producto"));
                item.setTipoProducto(rs.getString("tipo_producto"));
                item.setTotalVendidos(rs.getInt("total_vendidos"));
                lista.add(item);
            }
        } catch (SQLException e) {
            System.out.println("Error total vendidos por colegio: " + e.getMessage());
        }
        return lista;
    }

    // 7) Calcular el total de ventas (dinero)
    public BigDecimal totalVentas() {
        String sql = "SELECT COALESCE(SUM(total),0) AS total_ventas FROM factura";
        try (Connection con = SQLConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                return rs.getBigDecimal("total_ventas");
            }
        } catch (SQLException e) {
            System.out.println("Error total ventas: " + e.getMessage());
        }
        return BigDecimal.ZERO;
    }

    // ayuda aguardar el reporte, ya que viene de varias tablas juntas,es decir no pertenece a una sola tabla
    //y no hay un modelo que los integre todas
    //por cada fila crea un objeto
    //controlador lo recibe y se lo pasa la interfaz
    public static class ProductosVendidosPorColegio {
        private int idColegio;
        private String nombreColegio;
        private int idProducto;
        private String tipoProducto;
        private int totalVendidos;

        // getters y setters
        public int getIdColegio() { return idColegio; }
        public void setIdColegio(int idColegio) { this.idColegio = idColegio; }
        public String getNombreColegio() { return nombreColegio; }
        public void setNombreColegio(String nombreColegio) { this.nombreColegio = nombreColegio; }
        public int getIdProducto() { return idProducto; }
        public void setIdProducto(int idProducto) { this.idProducto = idProducto; }
        public String getTipoProducto() { return tipoProducto; }
        public void setTipoProducto(String tipoProducto) { this.tipoProducto = tipoProducto; }
        public int getTotalVendidos() { return totalVendidos; }
        public void setTotalVendidos(int totalVendidos) { this.totalVendidos = totalVendidos; }
    }
}
