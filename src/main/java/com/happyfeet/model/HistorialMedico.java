package main.java.com.happyfeet.model;

import java.sql.Date;

public class HistorialMedico {
    private int mascotaId;
    private String diagnostico;
    private String tratamiento;
    private Date fecha;

    public HistorialMedico(int mascotaId, String diagnostico, String tratamiento, Date fecha) {
        this.mascotaId = mascotaId;
        this.diagnostico = diagnostico;
        this.tratamiento = tratamiento;
        this.fecha = fecha;
    }

    // Getters y Setters
    public int getMascotaId() {
        return mascotaId;
    }

    public void setMascotaId(int mascotaId) {
        this.mascotaId = mascotaId;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "HistorialMedico{" +
                "mascotaId=" + mascotaId +
                ", diagnostico='" + diagnostico + '\'' +
                ", tratamiento='" + tratamiento + '\'' +
                ", fecha=" + fecha +
                '}';
    }
}
