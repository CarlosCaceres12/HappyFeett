package main.java.com.happyfeet.model;

public class Raza {
    private int id;
    private int especieId;
    private String nombre;

    public Raza() {}

    public Raza(int especieId, String nombre) {
        this.especieId = especieId;
        this.nombre = nombre;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getEspecieId() { return especieId; }
    public void setEspecieId(int especieId) { this.especieId = especieId; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
}
