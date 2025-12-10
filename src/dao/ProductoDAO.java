package dao;

import conexionBD.SQLConnection;
import modelo.Producto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;

public class ProductoDAO {

    public boolean insertarProducto(Producto p) {
        String sql = "INSERT INTO producto(tipo_producto, cantidad_existente, precio_venta, sexo, talla, descripcion) VALUES (?,?,?,?,?,?)";
        try (Connection con = SQLConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, p.getTipoProducto());
            ps.setInt(2, p.getCantidadExistente());
            ps.setBigDecimal(3, p.getPrecioVenta());
            ps.setString(4, p.getSexo());
            ps.setString(5, p.getTalla());
            ps.setString(6, p.getDescripcion());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error insertar producto: " + e.getMessage());
            return false;
        }
    }

    public boolean actualizarProducto(Producto p) {
        String sql = "UPDATE producto SET tipo_producto=?, cantidad_existente=?, precio_venta=?, sexo=?, talla=?, descripcion=? WHERE id_producto=?";
        try (Connection con = SQLConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, p.getTipoProducto());
            ps.setInt(2, p.getCantidadExistente());
            ps.setBigDecimal(3, p.getPrecioVenta());
            ps.setString(4, p.getSexo());
            ps.setString(5, p.getTalla());
            ps.setString(6, p.getDescripcion());
            ps.setInt(7, p.getIdProducto());
            int filas = ps.executeUpdate();
            return filas> 0;
        } catch (SQLException e) {
            System.out.println("Error actualizar producto: " + e.getMessage());
            return false;
        }
    }

    public boolean eliminarProducto(int idProducto) {
        String sql = "DELETE FROM producto WHERE id_producto=?";
        try (Connection con = SQLConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idProducto);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error eliminar producto: " + e.getMessage());
            return false;
        }
    }

    public List<Producto> listarProductos() {
        List<Producto> listaProductos = new ArrayList<>();
        String sql = "SELECT * FROM producto ORDER BY tipo_producto";
        try (Connection con = SQLConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Producto p = new Producto();
                p.setIdProducto(rs.getInt("id_producto"));
                p.setTipoProducto(rs.getString("tipo_producto"));
                p.setCantidadExistente(rs.getInt("cantidad_existente"));
                p.setPrecioVenta(rs.getBigDecimal("precio_venta"));
                p.setSexo(rs.getString("sexo"));
                p.setTalla(rs.getString("talla"));
                p.setDescripcion(rs.getString("descripcion"));
                listaProductos.add(p);
            }
        } catch (SQLException e) {
            System.out.println("Error listar productos: " + e.getMessage());
        }
        return listaProductos;
    }

    public Producto buscarProducto(int idProducto) {
        String sql = "SELECT * FROM producto WHERE id_producto=?";
        try (Connection con = SQLConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idProducto);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Producto(
                        rs.getInt("id_producto"),
                        rs.getString("tipo_producto"),
                        rs.getInt("cantidad_existente"),
                        rs.getBigDecimal("precio_venta"),
                        rs.getString("sexo"),
                        rs.getString("talla"),
                        rs.getString("descripcion")
                );
            }
        } catch (SQLException e) {
            System.out.println("Error buscar producto: " + e.getMessage());
        }
        return null;
    }
}

