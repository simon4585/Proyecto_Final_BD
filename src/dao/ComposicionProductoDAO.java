package dao;


import conexionBD.SQLConnection;
import modelo.ComposicionProducto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;

public class ComposicionProductoDAO {

    public boolean insertarComposicion(ComposicionProducto c) {
        String sql = "INSERT INTO composicion_producto(id_producto, codigo, cantidad_usada) VALUES (?,?,?)";
        try (Connection con = SQLConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, c.getIdProducto());
            ps.setInt(2, c.getCodigo());
            ps.setBigDecimal(3, c.getCantidadUsada());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error insertar composicion: " + e.getMessage());
            return false;
        }
    }

    public boolean eliminarComposicion(int idComposicion) {
        String sql = "DELETE FROM composicion_producto WHERE id_composicion=?";
        try (Connection con = SQLConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idComposicion);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error eliminar composicion: " + e.getMessage());
            return false;
        }
    }

    public List<ComposicionProducto> listarPorProducto(int idProducto) {
        List<ComposicionProducto> lista = new ArrayList<>();
        String sql = "SELECT * FROM composicion_producto WHERE id_producto=?";
        try (Connection con = SQLConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idProducto);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ComposicionProducto c = new ComposicionProducto();
                c.setIdComposicion(rs.getInt("id_composicion"));
                c.setIdProducto(rs.getInt("id_producto"));
                c.setCodigo(rs.getInt("codigo"));
                c.setCantidadUsada(rs.getBigDecimal("cantidad_usada"));
                lista.add(c);
            }
        } catch (SQLException e) {
            System.out.println("Error listar composicion: " + e.getMessage());
        }
        return lista;
    }
}

