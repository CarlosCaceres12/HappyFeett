package main.java.com.happyfeet.controller;

import main.java.com.happyfeet.repository.DuenoDAO;
import main.java.com.happyfeet.repository.MascotaDAO;
import java.util.List;
import main.java.com.happyfeet.model.Dueno;
import java.util.Scanner;

public class AppController {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DuenoDAO duenoDAO = new DuenoDAO();
        MascotaDAO mascotaDAO = new MascotaDAO();

        while (true) {
            System.out.println("===== HAPPYFEET MENU =====");
            System.out.println("1. Listar Dueños");
            System.out.println("2. Listar Mascotas");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            int op = sc.nextInt();
            sc.nextLine();

            switch (op) {
                case 1 -> {
                    System.out.println("Dueños:");
                    List<Dueno> duenos = duenoDAO.getDuenos();
        System.out.println("✅ Total dueños encontrados: " + duenos.size());
        duenos.forEach(System.out::println); // imprime usando toString() de Dueno
                }
                case 2 -> {
                    System.out.println("Mascotas:");
                    mascotaDAO.getMascotas().forEach(System.out::println);
                }
                case 0 -> {
                    System.out.println("Saliendo...");
                    return;
                }
                default -> System.out.println("Opción no válida.");
            }
        }
    }
}

