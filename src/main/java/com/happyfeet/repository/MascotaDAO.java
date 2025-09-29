package com.happyfeet.repository;

import com.happyfeet.model.Mascota;
import com.happyfeet.util.DBConnection;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MascotaDAO {

    public List<Mascota> findAll() {
        List<Mascota> list = new ArrayList<>();
        String sql = "SELECT id, dueno_id, nombre, raza_id, fecha_nacimiento, sexo, url_foto FROM mascotas";
        try (Connection conn = DBConnection.getInstance().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Mascota m = new Mascota.Builder()
                        .id(rs.getInt("id"))
                        .duenoId(rs.getInt("dueno_id"))
                        .nombre(rs.getString("nombre"))
                        .razaId(rs.getInt("raza_id"))
                        .fechaNacimiento(rs.getDate("fecha_nacimiento") != null ? rs.getDate("fecha_nacimiento").toLocalDate() : null)
                        .sexo(rs.getString("sexo"))
                        .urlFoto(rs.getString("url_foto"))
                        .build();
                list.add(m);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public Mascota findById(int id) {
        String sql = "SELECT id, dueno_id, nombre, raza_id, fecha_nacimiento, sexo, url_foto FROM mascotas WHERE id = ?";
        try (Connection conn = DBConnection.getInstance().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Mascota.Builder()
                            .id(rs.getInt("id"))
                            .duenoId(rs.getInt("dueno_id"))
                            .nombre(rs.getString("nombre"))
                            .razaId(rs.getInt("raza_id"))
                            .fechaNacimiento(rs.getDate("fecha_nacimiento") != null ? rs.getDate("fecha_nacimiento").toLocalDate() : null)
                            .sexo(rs.getString("sexo"))
                            .urlFoto(rs.getString("url_foto"))
                            .build();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
