package dao;

import conexionBD.SQLConnection;
import modelo.Colegio;
import modelo.Proveedor;

import java.sql.*;
import java.util.ArrayList;



import conexionBD.SQLConnection;
import java.sql.*;
import java.util.ArrayList;

public class ProveedorDAO {

    public boolean insertarProveedor(Proveedor proveedor) {
        String sql = "INSERT INTO PROVEEDOR(nit, nombre, direccion, telefono, nombre_contacto) VALUES (?, ?, ?, ?, ?)";

        try (Connection con = SQLConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, proveedor.getNit());
            ps.setString(2, proveedor.getNombre());
            ps.setString(3, proveedor.getDireccion());
            ps.setString(4, proveedor.getTelefono());
            ps.setString(5, proveedor.getNombreContacto());

            ps.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.out.println("Error al insertar proveedor: " + e.getMessage());
            return false;
        }
    }


    public ArrayList<Proveedor> listarProveedores() {
        ArrayList<Proveedor> listaProveedor= new ArrayList<>();
        String sql = "SELECT * FROM PROVEEDOR";

        try (Connection con = SQLConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Proveedor p = new Proveedor();
                p.setNit(rs.getString("nit"));
                p.setNombre(rs.getString("nombre"));
                p.setDireccion(rs.getString("direccion"));
                p.setTelefono(rs.getString("telefono"));
                p.setNombreContacto(rs.getString("nombre_contacto"));

                listaProveedor.add(p);
            }

        } catch (SQLException e) {
            System.out.println("Error al listar proveedores: " + e.getMessage());
        }

        return listaProveedor;
    }


    public Proveedor buscarProveedor(String nit) {
        String sql = "SELECT * FROM PROVEEDOR WHERE nit = ?";
        Proveedor p = null;

        try (Connection con = SQLConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, nit);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                p = new Proveedor();
                p.setNit(rs.getString("nit"));
                p.setNombre(rs.getString("nombre"));
                p.setDireccion(rs.getString("direccion"));
                p.setTelefono(rs.getString("telefono"));
                p.setNombreContacto(rs.getString("nombre_contacto"));
            }

        } catch (SQLException e) {
            System.out.println("Error al buscar proveedor: " + e.getMessage());
        }

        return p;
    }


    public boolean actualizarProveedor(Proveedor proveedor) {
        String sql = "UPDATE PROVEEDOR SET nombre=?, direccion=?, telefono=?, nombre_contacto=? WHERE nit=?";

        try (Connection con = SQLConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, proveedor.getNombre());
            ps.setString(2, proveedor.getDireccion());
            ps.setString(3, proveedor.getTelefono());
            ps.setString(4, proveedor.getNombreContacto());
            ps.setString(5, proveedor.getNit());

            int filas = ps.executeUpdate();
            return filas > 0;

        } catch (SQLException e) {
            System.out.println("Error al actualizar proveedor: " + e.getMessage());
            return false;
        }
    }


    public boolean eliminarProveedor(String nit) {
        String sql = "DELETE FROM PROVEEDOR WHERE nit = ?";

        try (Connection con = SQLConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, nit);
            int filas = ps.executeUpdate();
            return filas > 0;

        } catch (SQLException e) {
            System.out.println("Error al eliminar proveedor: " + e.getMessage());
            return false;
        }
    }

}
