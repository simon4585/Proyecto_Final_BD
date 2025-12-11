package dao;

import conexionBD.SQLConnection;
import modelo.MateriaPrima;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MateriaPrimaDAO {

    // INSERTAR
    public boolean insertarMateriaPrima(MateriaPrima mp) {
        String sql = "INSERT INTO materia_prima(codigo, tipo, descripcion, cantidad_dispo, unidad_medida, certificado_dispo) " +
                "VALUES (?,?,?,?,?,?)";

        try (Connection con = SQLConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, mp.getCodigo());
            ps.setString(2, mp.getTipo());
            ps.setString(3, mp.getDescripcion());
            ps.setBigDecimal(4, mp.getCantidadDispo());
            ps.setString(5, mp.getUnidadMedida());
            ps.setBoolean(6, mp.isCertificadoDispo());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error al insertar materia prima: " + e.getMessage());
            return false;
        }
    }

    // ACTUALIZAR
    public boolean actualizarMateriaPrima(MateriaPrima mp) {
        String sql = "UPDATE materia_prima SET tipo=?, descripcion=?, cantidad_dispo=?, unidad_medida=?, certificado_dispo=? " +
                "WHERE codigo=?";

        try (Connection con = SQLConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, mp.getTipo());
            ps.setString(2, mp.getDescripcion());
            ps.setBigDecimal(3, mp.getCantidadDispo());
            ps.setString(4, mp.getUnidadMedida());
            ps.setBoolean(5, mp.isCertificadoDispo());
            ps.setInt(6, mp.getCodigo());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error al actualizar materia prima: " + e.getMessage());
            return false;
        }
    }

    // ELIMINAR
    public boolean eliminarMateriaPrima(int codigo) {
        String sql = "DELETE FROM materia_prima WHERE codigo=?";

        try (Connection con = SQLConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, codigo);
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error al eliminar materia prima: " + e.getMessage());
            return false;
        }
    }

    // BUSCAR UNA
    public MateriaPrima buscarMateriaPrima(int codigo) {
        String sql = "SELECT * FROM materia_prima WHERE codigo=?";

        try (Connection con = SQLConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, codigo);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                MateriaPrima mp = new MateriaPrima();
                mp.setCodigo(rs.getInt("codigo"));
                mp.setTipo(rs.getString("tipo"));
                mp.setDescripcion(rs.getString("descripcion"));
                mp.setCantidadDispo(rs.getBigDecimal("cantidad_dispo"));
                mp.setUnidadMedida(rs.getString("unidad_medida"));
                mp.setCertificadoDispo(rs.getBoolean("certificado_dispo"));
                return mp;
            }

        } catch (SQLException e) {
            System.out.println("Error al buscar materia prima: " + e.getMessage());
        }

        return null;
    }

    // LISTAR TODAS
    public List<MateriaPrima> listarMateriaPrima() {
        List<MateriaPrima> lista = new ArrayList<>();
        String sql = "SELECT * FROM materia_prima ORDER BY codigo";

        try (Connection con = SQLConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                MateriaPrima mp = new MateriaPrima();
                mp.setCodigo(rs.getInt("codigo"));
                mp.setTipo(rs.getString("tipo"));
                mp.setDescripcion(rs.getString("descripcion"));
                mp.setCantidadDispo(rs.getBigDecimal("cantidad_dispo"));
                mp.setUnidadMedida(rs.getString("unidad_medida"));
                mp.setCertificadoDispo(rs.getBoolean("certificado_dispo"));
                lista.add(mp);
            }

        } catch (SQLException e) {
            System.out.println("Error al listar materia prima: " + e.getMessage());
        }

        return lista;
    }
}

