package main.java.com.happyfeet.service;

import main.java.com.happyfeet.util.DBConnection;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.sql.*;
import java.time.LocalDateTime;

public class FacturaService {

    public int createFactura(int duenoId, double total) {
        String insert = "INSERT INTO facturas (dueno_id, fecha_emision, total) VALUES (?, ?, ?)";
        try (Connection conn = DBConnection.getInstance().getConnection();
             PreparedStatement ps = conn.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1, duenoId);
            ps.setTimestamp(2, Timestamp.valueOf(LocalDateTime.now()));
            ps.setDouble(3, total);
            ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) return rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public void generateInvoiceText(int facturaId) {
        String q = "SELECT f.id, f.fecha_emision, f.total, d.nombre_completo, d.documento_identidad FROM facturas f JOIN duenos d ON f.dueno_id = d.id WHERE f.id = ?";
        try (Connection conn = DBConnection.getInstance().getConnection();
             PreparedStatement ps = conn.prepareStatement(q)) {
            ps.setInt(1, facturaId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    // write to invoices/invoice_<id>.txt
                    File dir = new File("invoices");
                    if (!dir.exists()) dir.mkdirs();
                    File out = new File(dir, "invoice_" + facturaId + ".txt");
                    try (PrintWriter w = new PrintWriter(new FileWriter(out))) {
                        w.println("Happy Feet - Factura #" + rs.getInt("id"));
                        w.println("Fecha: " + rs.getTimestamp("fecha_emision"));
                        w.println("Cliente: " + rs.getString("nombre_completo") + " - " + rs.getString("documento_identidad"));
                        w.println("Total: " + rs.getDouble("total"));
                        w.println("--- Gracias por su visita ---");
                    }
                    System.out.println("Factura generada: " + out.getAbsolutePath());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
