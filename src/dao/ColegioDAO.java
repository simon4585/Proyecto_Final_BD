package dao;

import conexionBD.SQLConnection;
import modelo.Cliente;
import modelo.Colegio;

import java.sql.*;
import java.util.ArrayList;

public class ColegioDAO {

    public boolean insertarColegio(Colegio colegio) {
        String sql = "INSERT INTO COLEGIO(nombre,direccion,telefono) VALUES(?,?,?)";
        try (Connection con = SQLConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, colegio.getNombre() );
            ps.setString(2, colegio.getDireccion());
            ps.setString(3, colegio.getTelefono());
            ps.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.out.println("Error al insertar colegio: " + e.getMessage());
            return false;
        }
    }
    public boolean actualizarColegio(Colegio colegio) {
        String sql = "UPDATE COLEGIO SET nombre = ?, direccion = ?, telefono = ? WHERE id_colegio = ?";

        try (Connection con = SQLConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, colegio.getNombre());
            ps.setString(2, colegio.getDireccion());
            ps.setString(3, colegio.getTelefono());
            ps.setInt(4, colegio.getIdColegio());   // 👈 ESTE FALTABA

            ps.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.out.println("Error al actualizar colegio: " + e.getMessage());
            return false;
        }
    }



    public ArrayList<Colegio> ListarColegios() {
        ArrayList<Colegio> arraycolegio = new ArrayList<>();
        String sql = "SELECT * FROM COLEGIO";
        try(Connection con = SQLConnection.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql)){
            while(rs.next()){
                Colegio colegio = new Colegio();
                colegio.setIdColegio(rs.getInt("id_colegio"));
                colegio.setNombre(rs.getString("nombre"));
                colegio.setDireccion(rs.getString("direccion"));
                colegio.setTelefono(rs.getString("telefono"));
                arraycolegio.add(colegio);
            }
        }
        catch (SQLException e) {
            System.out.println("Error al listar clientes: " + e.getMessage());
            throw new RuntimeException(e);
        }
        return arraycolegio;
    }
    public boolean eliminarColegio(int id) throws SQLException {
        String sql = "DELETE FROM COLEGIO WHERE id_colegio=?";
        try (Connection con = SQLConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1,id);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al eliminar colegio: " + e.getMessage());
            return false;
        }
    }

    public Colegio buscarColegio(int id) {
        String sql = "SELECT * FROM COLEGIO WHERE id_colegio=?";
        try (Connection con = SQLConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Colegio colegio = new Colegio();
                colegio.setIdColegio(rs.getInt("id_colegio"));
                colegio.setNombre(rs.getString("nombre"));
                colegio.setTelefono(rs.getString("telefono"));
                colegio.setDireccion(rs.getString("direccion"));
                return colegio;
            }

        }catch (SQLException e) {
            System.out.println("Error al buscar cliente: " + e.getMessage());
        }
        return null;
    }
}
