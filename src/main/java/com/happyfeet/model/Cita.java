package main.java.com.happyfeet.model;

import java.sql.Timestamp;

public class Cita {

    private int id;
    private int mascotaId;
    private int duenoId;
    private Timestamp fechaHora;
    private String motivo;
    private String estado;

    // Constructor completo
    public Cita(int mascotaId, int duenoId, Timestamp fechaHora, String motivo, String estado) {
        this.mascotaId = mascotaId;
        this.duenoId = duenoId;
        this.fechaHora = fechaHora;
        this.motivo = motivo;
        this.estado = estado;
    }

    // Constructor vacío
    public Cita() {}

    // Getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMascotaId() {
        return mascotaId;
    }

    public void setMascotaId(int mascotaId) {
        this.mascotaId = mascotaId;
    }

    public int getDuenoId() {
        return duenoId;
    }

    public void setDuenoId(int duenoId) {
        this.duenoId = duenoId;
    }

    public Timestamp getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Timestamp fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
