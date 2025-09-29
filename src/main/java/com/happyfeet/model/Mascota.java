package com.happyfeet.model;

import java.time.LocalDate;

public class Mascota {
    private int id;
    private int duenoId;
    private String nombre;
    private int razaId;
    private LocalDate fechaNacimiento;
    private String sexo;
    private String urlFoto;

    private Mascota() {}

    public static class Builder {
        private Mascota m = new Mascota();
        public Builder id(int id){ m.id = id; return this; }
        public Builder duenoId(int d){ m.duenoId = d; return this; }
        public Builder nombre(String n){ m.nombre = n; return this; }
        public Builder razaId(int r){ m.razaId = r; return this; }
        public Builder fechaNacimiento(LocalDate f){ m.fechaNacimiento = f; return this; }
        public Builder sexo(String s){ m.sexo = s; return this; }
        public Builder urlFoto(String u){ m.urlFoto = u; return this; }
        public Mascota build(){ return m; }
    }

    // getters
    public int getId(){ return id; }
    public int getDuenoId(){ return duenoId; }
    public String getNombre(){ return nombre; }
    public int getRazaId(){ return razaId; }
    public LocalDate getFechaNacimiento(){ return fechaNacimiento; }
    public String getSexo(){ return sexo; }
    public String getUrlFoto(){ return urlFoto; }

    @Override
    public String toString(){
        return id + ": " + nombre + " (duenoId=" + duenoId + ")";
    }
}
