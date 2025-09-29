package com.happyfeet.repository;

import com.happyfeet.model.Dueno;
import com.happyfeet.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DuenoDAO {

    public List<Dueno> findAll() {
        List<Dueno> list = new ArrayList<>();
        String sql = "SELECT id, nombre_completo, documento_identidad, direccion, telefono, email FROM duenos";
        try (Connection conn = DBConnection.getInstance().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Dueno d = new Dueno(
                        rs.getInt("id"),
                        rs.getString("nombre_completo"),
                        rs.getString("documento_identidad"),
                        rs.getString("direccion"),
                        rs.getString("telefono"),
                        rs.getString("email")
                );
                list.add(d);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public Dueno findById(int id) {
        String sql = "SELECT id, nombre_completo, documento_identidad, direccion, telefono, email FROM duenos WHERE id = ?";
        try (Connection conn = DBConnection.getInstance().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Dueno(
                            rs.getInt("id"),
                            rs.getString("nombre_completo"),
                            rs.getString("documento_identidad"),
                            rs.getString("direccion"),
                            rs.getString("telefono"),
                            rs.getString("email")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
