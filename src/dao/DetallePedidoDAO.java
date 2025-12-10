package dao;



import conexionBD.SQLConnection;
import modelo.DetallePedido;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DetallePedidoDAO {

    public boolean insertarDetalle(DetallePedido d) {
        String sql = "INSERT INTO detalle_pedido(id_pedido, id_producto, cantidad) VALUES (?,?,?)";
        try (Connection con = SQLConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, d.getIdPedido());
            ps.setInt(2, d.getIdProducto());
            ps.setInt(3, d.getCantidad());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error insertar detalle pedido: " + e.getMessage());
            return false;
        }
    }

    public boolean actualizarDetalle(DetallePedido d) {
        String sql = "UPDATE detalle_pedido SET id_producto=?, cantidad=? WHERE id_detalle_pedido=?";
        try (Connection con = SQLConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, d.getIdProducto());
            ps.setInt(2, d.getCantidad());
            ps.setInt(3, d.getIdDetallePedido());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error actualizar detalle: " + e.getMessage());
            return false;
        }
    }

    public boolean eliminarDetalle(int idDetalle) {
        String sql = "DELETE FROM detalle_pedido WHERE id_detalle_pedido=?";
        try (Connection con = SQLConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idDetalle);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error eliminar detalle: " + e.getMessage());
            return false;
        }
    }

    public List<DetallePedido> listarPorPedido(int idPedido) {
        List<DetallePedido> lista = new ArrayList<>();
        String sql = "SELECT * FROM detalle_pedido WHERE id_pedido=?";
        try (Connection con = SQLConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idPedido);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                DetallePedido d = new DetallePedido();
                d.setIdDetallePedido(rs.getInt("id_detalle_pedido"));
                d.setIdPedido(rs.getInt("id_pedido"));
                d.setIdProducto(rs.getInt("id_producto"));
                d.setCantidad(rs.getInt("cantidad"));
                lista.add(d);
            }
        } catch (SQLException e) {
            System.out.println("Error listar detalles: " + e.getMessage());
        }
        return lista;
    }
}
