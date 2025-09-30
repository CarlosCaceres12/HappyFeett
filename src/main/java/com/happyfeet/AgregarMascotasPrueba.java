package main.java.com.happyfeet;

import main.java.com.happyfeet.model.Mascota;
import main.java.com.happyfeet.repository.MascotaDAO;

import java.sql.Date;

public class AgregarMascotasPrueba {
    public static void main(String[] args) {
        MascotaDAO mascotaDAO = new MascotaDAO();

        // Mascota 1
        Mascota m1 = new Mascota();
        m1.setDuenoId(1);
        m1.setNombre("Firulais");
        m1.setRazaId(1); // Labrador
        m1.setFechaNacimiento(Date.valueOf("2020-05-10"));
        m1.setSexo("Macho");
        m1.setUrlFoto("foto1.jpg");
        mascotaDAO.agregarMascota(m1);

        // Mascota 2
        Mascota m2 = new Mascota();
        m2.setDuenoId(2);
        m2.setNombre("Michi");
        m2.setRazaId(4); // Siames
        m2.setFechaNacimiento(Date.valueOf("2021-02-15"));
        m2.setSexo("Hembra");
        m2.setUrlFoto("foto2.jpg");
        mascotaDAO.agregarMascota(m2);

        // Mascota 3
        Mascota m3 = new Mascota();
        m3.setDuenoId(3);
        m3.setNombre("Tweety");
        m3.setRazaId(7); // Canario
        m3.setFechaNacimiento(Date.valueOf("2022-01-01"));
        m3.setSexo("Hembra");
        m3.setUrlFoto("foto3.jpg");
        mascotaDAO.agregarMascota(m3);

        System.out.println("✅ Mascotas agregadas correctamente.");
    }
}
