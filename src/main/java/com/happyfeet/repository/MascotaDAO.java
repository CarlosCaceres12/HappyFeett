package com.happyfeet.repository;

import com.happyfeet.util.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MascotaDAO {
    public List<String> findAll() {
        List<String> results = new ArrayList<>();
        String sql = "SELECT id, nombre FROM mascotas";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                results.add(rs.getInt("id") + " - " + rs.getString("nombre"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return results;
    }
}
