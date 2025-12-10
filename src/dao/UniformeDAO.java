package dao;
import conexionBD.SQLConnection;
import modelo.Producto;
import modelo.Colegio;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;
import conexionBD.SQLConnection;
import modelo.Uniforme;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UniformeDAO {

    public boolean insertarUniforme(Uniforme u) {
        String sql = "INSERT INTO uniforme(tipo, color, tipo_tela, lleva_bordado, lugar_bordado, tipo_bordado, estampado, id_colegio, id_producto) VALUES (?,?,?,?,?,?,?,?,?)";
        try (Connection con = SQLConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, u.getTipo());
            ps.setString(2, u.getColor());
            ps.setString(3, u.getTipoTela());
            ps.setBoolean(4, u.isLlevaBordado());
            ps.setString(5, u.getLugarBordado());
            ps.setString(6, u.getTipoBordado());
            ps.setString(7, u.getEstampado());
            ps.setInt(8, u.getIdColegio());
            ps.setInt(9, u.getIdProducto());

            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error insertar uniforme: " + e.getMessage());
            return false;
        }
    }

    public boolean actualizarUniforme(Uniforme u) {
        String sql = "UPDATE uniforme SET tipo=?, color=?, tipo_tela=?, lleva_bordado=?, lugar_bordado=?, tipo_bordado=?, estampado=?, id_colegio=?, id_producto=? WHERE id_uniforme=?";
        try (Connection con = SQLConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, u.getTipo());
            ps.setString(2, u.getColor());
            ps.setString(3, u.getTipoTela());
            ps.setBoolean(4, u.isLlevaBordado());
            ps.setString(5, u.getLugarBordado());
            ps.setString(6, u.getTipoBordado());
            ps.setString(7, u.getEstampado());
            ps.setInt(8, u.getIdColegio());
            ps.setInt(9, u.getIdProducto());
            ps.setInt(10, u.getIdUniforme());

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error actualizar uniforme: " + e.getMessage());
            return false;
        }
    }

    public boolean eliminarUniforme(int idUniforme) {
        String sql = "DELETE FROM uniforme WHERE id_uniforme=?";
        try (Connection con = SQLConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idUniforme);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error eliminar uniforme: " + e.getMessage());
            return false;
        }
    }

    public List<Uniforme> listarUniformes() {
        List<Uniforme> lista = new ArrayList<>();
        String sql = "SELECT * FROM uniforme";
        try (Connection con = SQLConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                Uniforme u = new Uniforme();
                u.setIdUniforme(rs.getInt("id_uniforme"));
                u.setTipo(rs.getString("tipo"));
                u.setColor(rs.getString("color"));
                u.setTipoTela(rs.getString("tipo_tela"));
                u.setLlevaBordado(rs.getBoolean("lleva_bordado"));
                u.setLugarBordado(rs.getString("lugar_bordado"));
                u.setTipoBordado(rs.getString("tipo_bordado"));
                u.setEstampado(rs.getString("estampado"));
                u.setIdColegio(rs.getInt("id_colegio"));
                u.setIdProducto(rs.getInt("id_producto"));
                lista.add(u);
            }
        } catch (SQLException e) {
            System.out.println("Error listar uniformes: " + e.getMessage());
        }
        return lista;
    }

    public Uniforme buscarUniforme(int idUniforme) {
        String sql = "SELECT * FROM uniforme WHERE id_uniforme=?";
        try (Connection con = SQLConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idUniforme);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Uniforme u = new Uniforme();
                u.setIdUniforme(rs.getInt("id_uniforme"));
                u.setTipo(rs.getString("tipo"));
                u.setColor(rs.getString("color"));
                u.setTipoTela(rs.getString("tipo_tela"));
                u.setLlevaBordado(rs.getBoolean("lleva_bordado"));
                u.setLugarBordado(rs.getString("lugar_bordado"));
                u.setTipoBordado(rs.getString("tipo_bordado"));
                u.setEstampado(rs.getString("estampado"));
                u.setIdColegio(rs.getInt("id_colegio"));
                u.setIdProducto(rs.getInt("id_producto"));
                return u;
            }
        } catch (SQLException e) {
            System.out.println("Error buscar uniforme: " + e.getMessage());
        }
        return null;
    }
}
