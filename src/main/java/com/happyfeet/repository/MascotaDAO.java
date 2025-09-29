package com.happyfeet.repository;

import com.happyfeet.util.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MascotaDAO {
    public List<String> getMascotas() {
        List<String> mascotas = new ArrayList<>();
        try (Connection conn = DBConnection.getInstance().getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT nombre FROM mascota")) {
            while (rs.next()) {
                mascotas.add(rs.getString("nombre"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mascotas;
    }
}
