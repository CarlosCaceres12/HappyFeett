package main.java.com.happyfeet.model;

public class FacturaItem {
    private int id;
    private int facturaId;
    private int inventarioId;
    private int cantidad;
    private double subtotal;

    public FacturaItem() {}

    public FacturaItem(int facturaId, int inventarioId, int cantidad, double subtotal) {
        this.facturaId = facturaId;
        this.inventarioId = inventarioId;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
    }

    // Getters y setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public int getFacturaId() { return facturaId; }
    public void setFacturaId(int facturaId) { this.facturaId = facturaId; }
    public int getInventarioId() { return inventarioId; }
    public void setInventarioId(int inventarioId) { this.inventarioId = inventarioId; }
    public int getCantidad() { return cantidad; }
    public void setCantidad(int cantidad) { this.cantidad = cantidad; }
    public double getSubtotal() { return subtotal; }
    public void setSubtotal(double subtotal) { this.subtotal = subtotal; }
}
