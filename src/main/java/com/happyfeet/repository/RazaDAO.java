package main.java.com.happyfeet.repository;

import main.java.com.happyfeet.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RazaDAO {

    private final Connection conn;

    public RazaDAO() {
        this.conn = DBConnection.getInstance().getConnection();
    }

    public boolean agregarRaza(int especieId, String nombre) {
        String sql = "INSERT INTO razas (especie_id, nombre) VALUES (?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, especieId);
            ps.setString(2, nombre);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al agregar raza: " + nombre);
            return false;
        }
    }
}
