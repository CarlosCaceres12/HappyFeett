package main.java.com.happyfeet.repository;

import main.java.com.happyfeet.model.Factura;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FacturaDAO {

    private static final String URL = "jdbc:mysql://localhost:3306/HappyFest";
    private static final String USER = "campus2023";
    private static final String PASSWORD = "campus2023"; // pon tu contraseña si tienes

    // Conexión a la base de datos
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // Agregar factura
    public void agregarFactura(Factura factura) {
        String sql = "INSERT INTO factura (numero, descripcion, metodo_pago, total, dueno_id, fecha_emision) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, factura.getNumero());
            stmt.setString(2, factura.getDescripcion());
            stmt.setString(3, factura.getMetodoPago());
            stmt.setDouble(4, factura.getTotal());
            stmt.setInt(5, factura.getDuenoId());
            stmt.setTimestamp(6, factura.getFechaEmision());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Obtener todas las facturas
    public List<Factura> getFacturas() {
        List<Factura> facturas = new ArrayList<>();
        String sql = "SELECT * FROM factura";

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Factura f = new Factura(
                        rs.getString("numero"),
                        rs.getString("descripcion"),
                        rs.getString("metodo_pago"),
                        rs.getDouble("total")
                );
                f.setId(rs.getInt("id"));
                f.setDuenoId(rs.getInt("dueno_id"));
                f.setFechaEmision(rs.getTimestamp("fecha_emision"));

                facturas.add(f);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return facturas;
    }
}
