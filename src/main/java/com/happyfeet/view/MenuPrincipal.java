package com.happyfeet.view;

import java.util.Scanner;

public class MenuPrincipal {
    public static void mostrarMenu() {
        Scanner sc = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("===== Veterinaria Happy Feet =====");
            System.out.println("1. Gestión de Dueños");
            System.out.println("2. Gestión de Mascotas");
            System.out.println("3. Facturación");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();
            switch (opcion) {
                case 1 -> System.out.println("Módulo Dueños (ejemplo)");
                case 2 -> System.out.println("Módulo Mascotas (ejemplo)");
                case 3 -> System.out.println("Módulo Facturación (ejemplo)");
                case 0 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción inválida");
            }
        } while (opcion != 0);
        sc.close();
    }
}
