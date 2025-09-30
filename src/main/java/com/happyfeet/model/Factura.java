package main.java.com.happyfeet.model;

import java.sql.Timestamp;

public class Factura {

    private int id;
    private String numero;
    private String descripcion;
    private String metodoPago;
    private double total;
    private int duenoId;
    private Timestamp fechaEmision;

    // Constructor completo
    public Factura(String numero, String descripcion, String metodoPago, double total) {
        this.numero = numero;
        this.descripcion = descripcion;
        this.metodoPago = metodoPago;
        this.total = total;
        this.fechaEmision = new Timestamp(System.currentTimeMillis());
    }

    // Constructor vacío
    public Factura() {}

    // Getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getDuenoId() {
        return duenoId;
    }

    public void setDuenoId(int duenoId) {
        this.duenoId = duenoId;
    }

    public Timestamp getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Timestamp fechaEmision) {
        this.fechaEmision = fechaEmision;
    }
}
