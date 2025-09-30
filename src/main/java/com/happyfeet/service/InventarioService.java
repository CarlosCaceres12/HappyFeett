package main.java.com.happyfeet.service;

import main.java.com.happyfeet.util.DBConnection;

import java.sql.*;

public class InventarioService {

    public boolean deductStock(int productoId, int cantidad) {
        String select = "SELECT cantidad_stock FROM inventario WHERE id = ?";
        String update = "UPDATE inventario SET cantidad_stock = ? WHERE id = ?";
        try (Connection conn = DBConnection.getInstance().getConnection();
             PreparedStatement ps = conn.prepareStatement(select)) {
            ps.setInt(1, productoId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    int actual = rs.getInt("cantidad_stock");
                    if (actual < cantidad) return false;
                    int nuevo = actual - cantidad;
                    try (PreparedStatement psu = conn.prepareStatement(update)) {
                        psu.setInt(1, nuevo);
                        psu.setInt(2, productoId);
                        psu.executeUpdate();
                    }
                    // Simple alert if below minimum
                    checkLowStock(productoId, conn);
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    private void checkLowStock(int productoId, Connection conn) throws SQLException {
        String q = "SELECT nombre_producto, cantidad_stock, stock_minimo FROM inventario WHERE id = ?";
        try (PreparedStatement ps = conn.prepareStatement(q)) {
            ps.setInt(1, productoId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    int stock = rs.getInt("cantidad_stock");
                    int minimo = rs.getInt("stock_minimo");
                    if (stock <= minimo) {
                        System.out.println("[ALERTA] Producto '" + rs.getString("nombre_producto") + "' con stock bajo: " + stock);
                    }
                }
            }
        }
    }
}
