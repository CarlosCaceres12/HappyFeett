package main.java.com.happyfeet;

import main.java.com.happyfeet.repository.EspecieDAO;

public class AgregarEspeciesPrueba {
    public static void main(String[] args) {
        EspecieDAO especieDAO = new EspecieDAO();

        // Agregar especies
        especieDAO.agregarEspecie("Perro"); // id 1
        especieDAO.agregarEspecie("Gato");  // id 2
        especieDAO.agregarEspecie("Ave");   // id 3

        System.out.println("✅ Especies agregadas correctamente.");
    }
}
