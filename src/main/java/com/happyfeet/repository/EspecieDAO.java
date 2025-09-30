package main.java.com.happyfeet.repository;

import main.java.com.happyfeet.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EspecieDAO {

    private final Connection conn;

    public EspecieDAO() {
        this.conn = DBConnection.getInstance().getConnection();
    }

    public boolean agregarEspecie(String nombre) {
        String sql = "INSERT INTO especies (nombre) VALUES (?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, nombre);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al agregar especie: " + nombre);
            return false;
        }
    }
}
