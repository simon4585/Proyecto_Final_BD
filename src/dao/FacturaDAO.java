package dao;

import conexionBD.SQLConnection;
import modelo.Factura;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FacturaDAO {

    public int insertarFactura(Factura f) {
        String sql = "INSERT INTO factura(fecha, total, id_pedido) VALUES (?,?,?) RETURNING id_factura"; //returning devuelve la id, por si se llega a necesitar
        try (Connection con = SQLConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setDate(1, Date.valueOf(f.getFecha()));
            ps.setBigDecimal(2, f.getTotal());
            ps.setInt(3, f.getIdPedido());

            ResultSet rs = ps.executeQuery();
            if (rs.next()) return rs.getInt(1);
        } catch (SQLException e) {
            System.out.println("Error insertar factura: " + e.getMessage());
        }
        return -1;
    }

    public boolean eliminarFactura(int idFactura) {
        String sql = "DELETE FROM factura WHERE id_factura=?";
        try (Connection con = SQLConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idFactura);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error eliminar factura: " + e.getMessage());
            return false;
        }
    }

    public List<Factura> listarFacturas() {
        List<Factura> lista = new ArrayList<>();
        String sql = "SELECT * FROM factura ORDER BY fecha DESC";
        try (Connection con = SQLConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                Factura f = new Factura();
                f.setIdFactura(rs.getInt("id_factura"));
                Date d = rs.getDate("fecha");
                if (d != null) f.setFecha(d.toLocalDate());
                f.setTotal(rs.getBigDecimal("total"));
                f.setIdPedido(rs.getInt("id_pedido"));
                lista.add(f);
            }
        } catch (SQLException e) {
            System.out.println("Error listar facturas: " + e.getMessage());
        }
        return lista;
    }

    public Factura buscarFactura(int idFactura) {
        String sql = "SELECT * FROM factura WHERE id_factura=?";
        try (Connection con = SQLConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idFactura);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Factura f = new Factura();
                f.setIdFactura(rs.getInt("id_factura"));
                Date d = rs.getDate("fecha");
                if (d != null) f.setFecha(d.toLocalDate());
                f.setTotal(rs.getBigDecimal("total"));
                f.setIdPedido(rs.getInt("id_pedido"));
                return f;
            }
        } catch (SQLException e) {
            System.out.println("Error buscar factura: " + e.getMessage());
        }
        return null;
    }
}

