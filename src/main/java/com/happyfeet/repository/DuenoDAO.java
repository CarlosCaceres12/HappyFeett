package com.happyfeet.repository;

import com.happyfeet.util.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DuenoDAO {
    public List<String> getDuenos() {
        List<String> duenos = new ArrayList<>();
        try (Connection conn = DBConnection.getInstance().getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT nombre FROM dueno")) {
            while (rs.next()) {
                duenos.add(rs.getString("nombre"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return duenos;
    }
}
