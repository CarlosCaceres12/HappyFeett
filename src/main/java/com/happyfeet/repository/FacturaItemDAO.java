package main.java.com.happyfeet.repository;

import main.java.com.happyfeet.model.FacturaItem;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FacturaItemDAO {

    private static final String URL = "jdbc:mysql://localhost:3306/HappyFest";
    private static final String USER = "campus2023";
    private static final String PASSWORD = "campus2023";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // Agregar item a factura
    public void agregarItem(FacturaItem item) {
        String sql = "INSERT INTO factura_item (factura_id, inventario_id, cantidad, subtotal) VALUES (?, ?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, item.getFacturaId());
            ps.setInt(2, item.getInventarioId());
            ps.setInt(3, item.getCantidad());
            ps.setDouble(4, item.getSubtotal());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Obtener items de una factura
    public List<FacturaItem> getItemsPorFactura(int facturaId) {
        List<FacturaItem> lista = new ArrayList<>();
        String sql = "SELECT * FROM factura_item WHERE factura_id=?";

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, facturaId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                FacturaItem item = new FacturaItem(
                        rs.getInt("factura_id"),
                        rs.getInt("inventario_id"),
                        rs.getInt("cantidad"),
                        rs.getDouble("subtotal")
                );
                item.setId(rs.getInt("id"));
                lista.add(item);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
}
