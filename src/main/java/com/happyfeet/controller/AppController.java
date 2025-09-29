package com.happyfeet;

import com.happyfeet.repository.DuenoDAO;
import com.happyfeet.repository.MascotaDAO;
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
                    duenoDAO.getDuenos().forEach(System.out::println);
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

