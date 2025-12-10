package dao;

import conexionBD.SQLConnection;
import modelo.Pedido;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;
import java.time.LocalDate;

public class PedidoDAO {

    public int insertarPedido(Pedido p) {
        // devuelve id_pedido generado (o -1 si error)
        String sql = "INSERT INTO pedido(fecha_pedido, fecha_entrega_estimada, abono, medidas, estado, dni) VALUES (?,?,?,?,?,?) RETURNING id_pedido";
        try (Connection con = SQLConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setDate(1, Date.valueOf(p.getFechaPedido()));
            if (p.getFechaEntregaEstimada() != null)
                ps.setDate(2, Date.valueOf(p.getFechaEntregaEstimada()));
            else
                ps.setNull(2, Types.DATE);
            ps.setBigDecimal(3, p.getAbono() != null ? p.getAbono() : BigDecimal.ZERO);
            ps.setString(4, p.getMedidas());
            ps.setString(5, p.getEstado());
            ps.setString(6, p.getDniCliente());

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println("Error insertar pedido: " + e.getMessage());
        }
        return -1;
    }

    public boolean actualizarEstadoPedido(int idPedido, String nuevoEstado) {
        String sql = "UPDATE pedido SET estado=? WHERE id_pedido=?";
        try (Connection con = SQLConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, nuevoEstado);
            ps.setInt(2, idPedido);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error actualizar estado pedido: " + e.getMessage());
            return false;
        }
    }

    public boolean eliminarPedido(int idPedido) {
        String sql = "DELETE FROM pedido WHERE id_pedido=?";
        try (Connection con = SQLConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idPedido);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error eliminar pedido: " + e.getMessage());
            return false;
        }
    }

    public List<Pedido> listarPedidos() {
        List<Pedido> lista = new ArrayList<>();
        String sql = "SELECT * FROM pedido ORDER BY fecha_pedido DESC";
        try (Connection con = SQLConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Pedido p = new Pedido();
                p.setIdPedido(rs.getInt("id_pedido"));
                Date fp = rs.getDate("fecha_pedido");
                if (fp != null) p.setFechaPedido(fp.toLocalDate());
                Date fe = rs.getDate("fecha_entrega_estimada");
                if (fe != null) p.setFechaEntregaEstimada(fe.toLocalDate());
                p.setAbono(rs.getBigDecimal("abono"));
                p.setMedidas(rs.getString("medidas"));
                p.setEstado(rs.getString("estado"));
                p.setDniCliente(rs.getString("dni"));
                lista.add(p);
            }
        } catch (SQLException e) {
            System.out.println("Error listar pedidos: " + e.getMessage());
        }
        return lista;
    }

    public Pedido buscarPedido(int idPedido) {
        String sql = "SELECT * FROM pedido WHERE id_pedido=?";
        try (Connection con = SQLConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idPedido);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Pedido p = new Pedido();
                p.setIdPedido(rs.getInt("id_pedido"));
                Date fp = rs.getDate("fecha_pedido");
                if (fp != null) p.setFechaPedido(fp.toLocalDate());
                Date fe = rs.getDate("fecha_entrega_estimada");
                if (fe != null) p.setFechaEntregaEstimada(fe.toLocalDate());
                p.setAbono(rs.getBigDecimal("abono"));
                p.setMedidas(rs.getString("medidas"));
                p.setEstado(rs.getString("estado"));
                p.setDniCliente(rs.getString("dni"));
                return p;
            }
        } catch (SQLException e) {
            System.out.println("Error buscar pedido: " + e.getMessage());
        }
        return null;
    }
}
