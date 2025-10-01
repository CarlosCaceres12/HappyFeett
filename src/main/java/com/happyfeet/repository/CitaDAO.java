package main.java.com.happyfeet.repository;

import main.java.com.happyfeet.model.Cita;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CitaDAO {

    private static final String URL = "jdbc:mysql://localhost:3306/HappyFest";
    private static final String USER = "campus2023";
    private static final String PASSWORD = "campus2023";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // Agregar cita
    public void agregarCita(Cita cita) {
        String sql = "INSERT INTO cita (mascota_id, dueno_id, fecha_hora, motivo, estado) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, cita.getMascotaId());
            ps.setInt(2, cita.getDuenoId());
            ps.setTimestamp(3, cita.getFechaHora());
            ps.setString(4, cita.getMotivo());
            ps.setString(5, cita.getEstado());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Obtener todas las citas
    public List<Cita> getCitas() {
        List<Cita> citas = new ArrayList<>();
        String sql = "SELECT * FROM cita";

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Cita c = new Cita();
                c.setId(rs.getInt("id"));
                c.setMascotaId(rs.getInt("mascota_id"));
                c.setDuenoId(rs.getInt("dueno_id"));
                c.setFechaHora(rs.getTimestamp("fecha_hora"));
                c.setMotivo(rs.getString("motivo"));
                c.setEstado(rs.getString("estado"));

                citas.add(c);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return citas;
    }

    // Editar cita
    public void editarCita(int id, Cita cita) {
        String sql = "UPDATE cita SET mascota_id=?, dueno_id=?, fecha_hora=?, motivo=?, estado=? WHERE id=?";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, cita.getMascotaId());
            ps.setInt(2, cita.getDuenoId());
            ps.setTimestamp(3, cita.getFechaHora());
            ps.setString(4, cita.getMotivo());
            ps.setString(5, cita.getEstado());
            ps.setInt(6, id);

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Eliminar cita
    public void eliminarCita(int id) {
        String sql = "DELETE FROM cita WHERE id=?";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
