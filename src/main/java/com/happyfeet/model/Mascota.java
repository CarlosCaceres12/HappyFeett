package main.java.com.happyfeet.model;

import java.sql.Date;

public class Mascota {

    private int id;
    private String nombre;
    private String tipo;
    private int duenoId;
    private int razaId;
    private Date fechaNacimiento;
    private String sexo;
    private String urlFoto;

    // Constructor vacío
    public Mascota() {}

    // Constructor completo (sin id, para registrar)
    public Mascota(String nombre, String tipo, int duenoId, int razaId, Date fechaNacimiento, String sexo, String urlFoto) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.duenoId = duenoId;
        this.razaId = razaId;
        this.fechaNacimiento = fechaNacimiento;
        this.sexo = sexo;
        this.urlFoto = urlFoto;
    }

    // Constructor con id (para consultas)
    public Mascota(int id, String nombre, String tipo, int duenoId, int razaId, Date fechaNacimiento, String sexo, String urlFoto) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.duenoId = duenoId;
        this.razaId = razaId;
        this.fechaNacimiento = fechaNacimiento;
        this.sexo = sexo;
        this.urlFoto = urlFoto;
    }

    // Getters y setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public int getDuenoId() { return duenoId; }
    public void setDuenoId(int duenoId) { this.duenoId = duenoId; }

    public int getRazaId() { return razaId; }
    public void setRazaId(int razaId) { this.razaId = razaId; }

    public Date getFechaNacimiento() { return fechaNacimiento; }
    public void setFechaNacimiento(Date fechaNacimiento) { this.fechaNacimiento = fechaNacimiento; }

    public String getSexo() { return sexo; }
    public void setSexo(String sexo) { this.sexo = sexo; }

    public String getUrlFoto() { return urlFoto; }
    public void setUrlFoto(String urlFoto) { this.urlFoto = urlFoto; }
}
