package main.java.com.happyfeet.repository;

import main.java.com.happyfeet.model.Mascota;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MascotaDAO {

    private static final String URL = "jdbc:mysql://localhost:3306/HappyFest";
    private static final String USER = "campus2023";
    private static final String PASSWORD = "campus2023"; // tu contraseña

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // Obtener todas las mascotas
    public List<Mascota> getMascotas() {
        List<Mascota> mascotas = new ArrayList<>();
        String sql = "SELECT * FROM mascota";

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Mascota m = new Mascota(
                        rs.getString("nombre"),
                        rs.getString("tipo"),
                        rs.getInt("dueno_id"),
                        rs.getInt("raza_id"),
                        rs.getDate("fecha_nacimiento"),
                        rs.getString("sexo"),
                        rs.getString("url_foto")
                );
                mascotas.add(m);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mascotas;
    }

    // Agregar mascota
    public void agregarMascota(Mascota m) {
        String sql = "INSERT INTO mascota(nombre, tipo, dueno_id, raza_id, fecha_nacimiento, sexo, url_foto) VALUES(?,?,?,?,?,?,?)";

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, m.getNombre());
            ps.setString(2, m.getTipo());
            ps.setInt(3, m.getDuenoId());
            ps.setInt(4, m.getRazaId());
            ps.setDate(5, m.getFechaNacimiento());
            ps.setString(6, m.getSexo());
            ps.setString(7, m.getUrlFoto());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Editar mascota
    public void editarMascota(int index, Mascota m) {
        String sql = "UPDATE mascota SET nombre=?, tipo=?, dueno_id=?, raza_id=?, fecha_nacimiento=?, sexo=?, url_foto=? WHERE id=?";

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, m.getNombre());
            ps.setString(2, m.getTipo());
            ps.setInt(3, m.getDuenoId());
            ps.setInt(4, m.getRazaId());
            ps.setDate(5, m.getFechaNacimiento());
            ps.setString(6, m.getSexo());
            ps.setString(7, m.getUrlFoto());
            ps.setInt(8, index);

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Eliminar mascota
    public void eliminarMascota(int index) {
        String sql = "DELETE FROM mascota WHERE id=?";

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, index);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
