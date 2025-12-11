package dao;

import conexionBD.SQLConnection;
import modelo.Usuario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {

    public boolean insertarUsuario(Usuario u) {
        String sql = "INSERT INTO usuarios(username, password, rol) VALUES (?,?,?)";
        try (Connection con = SQLConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, u.getUsername());
            ps.setString(2, u.getPassword());
            ps.setString(3, u.getRol());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error insertar usuario: " + e.getMessage());
            return false;
        }
    }

    public Usuario buscarUsuario(int id) {
        String sql = "SELECT * FROM usuarios WHERE id_usuario=?";
        try (Connection con = SQLConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Usuario u = new Usuario();
                u.setIdUsuario(rs.getInt("id_usuario"));
                u.setUsername(rs.getString("username"));
                u.setPassword(rs.getString("password"));
                u.setRol(rs.getString("rol"));
                return u;
            }
        } catch (SQLException e) {
            System.out.println("Error buscar usuario: " + e.getMessage());
        }
        return null;
    }

    public boolean validarLogin(String username, String password) {
        String sql = "SELECT password FROM usuarios WHERE username=?";
        try (Connection con = SQLConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String passBD = rs.getString("password");
                return password.equals(passBD);
            }
        } catch (SQLException e) {
            System.out.println("Error validar login: " + e.getMessage());
        }
        return false;
    }

    public List<Usuario> listarUsuarios() {
        List<Usuario> lista = new ArrayList<>();
        String sql = "SELECT * FROM usuarios";
        try (Connection con = SQLConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Usuario u = new Usuario();
                u.setIdUsuario(rs.getInt("id_usuario"));
                u.setUsername(rs.getString("username"));
                u.setPassword(rs.getString("password"));
                u.setRol(rs.getString("rol"));
                lista.add(u);
            }
        } catch (SQLException e) {
            System.out.println("Error listar usuarios: " + e.getMessage());
        }
        return lista;
    }

    public boolean eliminarUsuario(int idUsuario) {
        String sql = "DELETE FROM usuarios WHERE id_usuario = ?";
        try (Connection con = SQLConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idUsuario);
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error al eliminar usuario: " + e.getMessage());
            return false;
        }
    }

    public boolean actualizarUsuario(int idUsuario, Usuario nuevo) {
        String sql = "UPDATE usuarios SET username = ?, password = ?, rol = ? WHERE id_usuario = ?";

        try (Connection con = SQLConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, nuevo.getUsername());
            ps.setString(2, nuevo.getPassword());
            ps.setString(3, nuevo.getRol());
            ps.setInt(4, idUsuario);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error al actualizar usuario: " + e.getMessage());
            return false;
        }
    }

    public Usuario login(String username, String password) {
        String sql = "SELECT * FROM usuarios WHERE username=? AND password=?";
        try (Connection con = SQLConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Usuario u = new Usuario();
                u.setIdUsuario(rs.getInt("id_usuario"));
                u.setUsername(rs.getString("username"));
                u.setPassword(rs.getString("password"));
                u.setRol(rs.getString("rol"));
                return u;
            }

        } catch (SQLException e) {
            System.out.println("Error login: " + e.getMessage());
        }

        return null;
    }
}
