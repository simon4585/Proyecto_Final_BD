package dao;
import conexionBD.SQLConnection;
import modelo.Suministro;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SuministroDAO {

    public boolean insertarSuministro(Suministro s) {
        String sql = "INSERT INTO suministro(nit, codigo) VALUES (?,?)";
        try (Connection con = SQLConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, s.getNit());
            ps.setInt(2, s.getCodigo());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error insertar suministro: " + e.getMessage());
            return false;
        }
    }

    public boolean eliminarSuministro(int idSuministro) {
        String sql = "DELETE FROM suministro WHERE id_suministro=?";
        try (Connection con = SQLConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idSuministro);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error eliminar suministro: " + e.getMessage());
            return false;
        }
    }

    public List<Suministro> listarSuministros() {
        List<Suministro> lista = new ArrayList<>();
        String sql = "SELECT * FROM suministro";
        try (Connection con = SQLConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                Suministro s = new Suministro();
                s.setIdSuministro(rs.getInt("id_suministro"));
                s.setNit(rs.getString("nit"));
                s.setCodigo(rs.getInt("codigo"));
                lista.add(s);
            }
        } catch (SQLException e) {
            System.out.println("Error listar suministros: " + e.getMessage());
        }
        return lista;
    }

    public Suministro buscarSuministro(int idSuministro) {
        String sql = "SELECT * FROM SUMINISTRO WHERE id_suministro = ?";

        try (Connection con = SQLConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idSuministro);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Suministro s = new Suministro();
                    s.setIdSuministro(rs.getInt("id_suministro"));
                    s.setNit(rs.getString("nit"));
                    s.setCodigo(rs.getInt("codigo"));
                    return s;
                }
            }

        } catch (SQLException e) {
            System.out.println("Error al buscar suministro: " + e.getMessage());
        }

        return null; // no encontrado
    }

}
