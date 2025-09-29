package com.happyfeet.model;

public class Dueno {
    private int id;
    private String nombreCompleto;
    private String documentoIdentidad;
    private String direccion;
    private String telefono;
    private String email;

    public Dueno() {}

    public Dueno(int id, String nombreCompleto, String documentoIdentidad, String direccion, String telefono, String email) {
        this.id = id;
        this.nombreCompleto = nombreCompleto;
        this.documentoIdentidad = documentoIdentidad;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
    }

    // getters and setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getNombreCompleto() { return nombreCompleto; }
    public void setNombreCompleto(String n) { this.nombreCompleto = n; }
    public String getDocumentoIdentidad() { return documentoIdentidad; }
    public void setDocumentoIdentidad(String d) { this.documentoIdentidad = d; }
    public String getDireccion() { return direccion; }
    public void setDireccion(String d) { this.direccion = d; }
    public String getTelefono() { return telefono; }
    public void setTelefono(String t) { this.telefono = t; }
    public String getEmail() { return email; }
    public void setEmail(String e) { this.email = e; }

    @Override
    public String toString() {
        return id + ": " + nombreCompleto + " (" + documentoIdentidad + ")";
    }
}
