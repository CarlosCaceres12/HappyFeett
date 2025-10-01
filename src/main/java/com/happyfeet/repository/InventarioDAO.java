package main.java.com.happyfeet.repository;

import main.java.com.happyfeet.model.Inventario;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InventarioDAO {

    private static final String URL = "jdbc:mysql://localhost:3306/HappyFest";
    private static final String USER = "campus2023";
    private static final String PASSWORD = "campus2023";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // Agregar producto/servicio
    public void agregarInventario(Inventario item) {
        String sql = "INSERT INTO inventario (nombre, descripcion, precio, stock) VALUES (?, ?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, item.getNombre());
            ps.setString(2, item.getDescripcion());
            ps.setDouble(3, item.getPrecio());
            ps.setInt(4, item.getStock());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Listar inventario
    public List<Inventario> getInventario() {
        List<Inventario> lista = new ArrayList<>();
        String sql = "SELECT * FROM inventario";

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Inventario i = new Inventario(
                        rs.getString("nombre"),
                        rs.getString("descripcion"),
                        rs.getDouble("precio"),
                        rs.getInt("stock")
                );
                i.setId(rs.getInt("id"));
                lista.add(i);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
}
