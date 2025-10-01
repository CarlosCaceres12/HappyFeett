package main.java.com.happyfeet.repository;

import main.java.com.happyfeet.model.Dueno;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DuenoDAO {

    // Configura aquí tu usuario y contraseña
    private static final String URL = "jdbc:mysql://localhost:3306/HappyFest";
    private static final String USER = "campus2023"; // cambia si no es root
    private static final String PASSWORD = "campus2023"; // pon tu contraseña real

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // Obtener todos los dueños
    public List<Dueno> getDuenos() {
        List<Dueno> duenos = new ArrayList<>();
        String sql = "SELECT * FROM dueno";
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Dueno d = new Dueno(
                        rs.getString("nombre_completo"),
                        rs.getString("documento_identidad"),
                        rs.getString("direccion"),
                        rs.getString("telefono"),
                        rs.getString("email"),
                        rs.getString("contacto_emergencia")
                );
                duenos.add(d);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return duenos;
    }

    // Agregar dueño
    public void agregarDueno(Dueno dueno) {
        String sql = "INSERT INTO duenos(nombre_completo, documento_identidad, direccion, telefono, email, contacto_emergencia) VALUES (?,?,?,?,?,?)";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, dueno.getNombreCompleto());
            ps.setString(2, dueno.getDocumentoIdentidad());
            ps.setString(3, dueno.getDireccion());
            ps.setString(4, dueno.getTelefono());
            ps.setString(5, dueno.getEmail());
            ps.setString(6, dueno.getContactoEmergencia());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Editar dueño
    public void editarDueno(int index, Dueno dueno) {
        String sql = "UPDATE duenos SET nombre_completo=?, documento_identidad=?, direccion=?, telefono=?, email=?, contacto_emergencia=? WHERE id=?";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, dueno.getNombreCompleto());
            ps.setString(2, dueno.getDocumentoIdentidad());
            ps.setString(3, dueno.getDireccion());
            ps.setString(4, dueno.getTelefono());
            ps.setString(5, dueno.getEmail());
            ps.setString(6, dueno.getContactoEmergencia());
            ps.setInt(7, index + 1); // asumiendo que el index viene del listado
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Eliminar dueño
    public void eliminarDueno(int index) {
        String sql = "DELETE FROM duenos WHERE id=?";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, index + 1);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}