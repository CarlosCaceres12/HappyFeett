package main.java.com.happyfeet;

import main.java.com.happyfeet.repository.RazaDAO;

public class AgregarRazasPrueba {
    public static void main(String[] args) {
        RazaDAO razaDAO = new RazaDAO();

        // Razas para Perro (especie_id = 1)
        razaDAO.agregarRaza(1, "Labrador");
        razaDAO.agregarRaza(1, "Pastor Alemán");
        razaDAO.agregarRaza(1, "Bulldog");

        // Razas para Gato (especie_id = 2)
        razaDAO.agregarRaza(2, "Siames");
        razaDAO.agregarRaza(2, "Persa");
        razaDAO.agregarRaza(2, "Maine Coon");

        // Razas para Ave (especie_id = 3)
        razaDAO.agregarRaza(3, "Canario");
        razaDAO.agregarRaza(3, "Loro");

        System.out.println("✅ Razas agregadas correctamente.");
    }
}
