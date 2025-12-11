package dao;
import conexionBD.SQLConnection;
import modelo.Cliente;
import java.sql.*;
import java.util.ArrayList;
public class ClienteDAO {
    public boolean insertarCliente(Cliente cliente) {
        String sql = "INSERT INTO CLIENTE(dni,nombre,telefono) VALUES(?,?,?)";
        try (Connection con = SQLConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, cliente.getDni());
            ps.setString(2, cliente.getNombre());
            ps.setString(3, cliente.getTelefono());
            ps.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.out.println("Error al insertar cliente: " + e.getMessage());
            return false;
        }
    }

    public boolean eliminarCliente(String dni) throws SQLException {
        String sql = "DELETE FROM CLIENTE WHERE dni=?";
        try (Connection con = SQLConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1,dni);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al eliminar cliente: " + e.getMessage());
            return false;
        }
    }

    public ArrayList<Cliente> ListarClientes() {
        ArrayList<Cliente> arrayclientes = new ArrayList<>();
        String sql = "SELECT * FROM CLIENTE";
        try(Connection con = SQLConnection.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql)){
            while(rs.next()){
                Cliente cliente = new Cliente();
                cliente.setDni(rs.getString("dni"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setTelefono(rs.getString("telefono"));
                arrayclientes.add(cliente);
            }
        }
        catch (SQLException e) {
            System.out.println("Error al listar clientes: " + e.getMessage());
            throw new RuntimeException(e);
        }
        return arrayclientes;
    }
    public boolean actualizarCliente(Cliente cliente) {
        String sql = "UPDATE cliente SET nombre =?, telefono =? WHERE dni=?";
        try (Connection con = SQLConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getTelefono());
            ps.setString(3, cliente.getDni());
            ps.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.out.println("Error al actualizar cliente: " + e.getMessage());
            return false;
        }
    }
    public Cliente buscarCliente(String dni) {
        String sql = "SELECT * FROM CLIENTE WHERE dni=?";
        try (Connection con = SQLConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, dni);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                Cliente cliente = new Cliente();
                cliente.setDni(rs.getString("dni"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setTelefono(rs.getString("telefono"));
                return cliente;
            }

        }catch (SQLException e) {
            System.out.println("Error al buscar cliente: " + e.getMessage());
        }
        return null;
    }
}
