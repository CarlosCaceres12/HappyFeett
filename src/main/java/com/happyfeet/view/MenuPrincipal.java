package main.java.com.happyfeet.view;

import main.java.com.happyfeet.controller.DuenoController;
import main.java.com.happyfeet.controller.MascotaController;
import main.java.com.happyfeet.controller.FacturaController;

import java.util.Scanner;

public class MenuPrincipal {

    private static final Scanner scanner = new Scanner(System.in);

    public static void mostrarMenu() {
        int opcion;
        do {
            System.out.println("\n======================================");
            System.out.println("         🐾 Veterinaria Happy Feet 🐾");
            System.out.println("======================================");
            System.out.println("1️⃣  Gestión de Dueños");
            System.out.println("2️⃣  Gestión de Mascotas");
            System.out.println("3️⃣  Facturación");
            System.out.println("4️⃣  Mostrar Facturas");
            System.out.println("0️⃣  Salir");
            System.out.println("--------------------------------------");
            System.out.print("Seleccione una opción: ");
            opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1:
                    menuDuenos();
                    break;
                case 2:
                    menuMascotas();
                    break;
                case 3:
                    FacturaController.registrarFactura();
                    break;
                case 4:
                    FacturaController.mostrarFacturas();
                    break;
                case 0:
                    System.out.println("¡Gracias por usar Veterinaria Happy Feet! 🐶🐱");
                    break;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        } while (opcion != 0);
    }

    private static void menuDuenos() {
        int opcion;
        do {
            System.out.println("\n----------- Gestión de Dueños -----------");
            System.out.println("1️⃣  Mostrar Dueños");
            System.out.println("2️⃣  Registrar Dueño");
            System.out.println("3️⃣  Editar Dueño");
            System.out.println("4️⃣  Eliminar Dueño");
            System.out.println("0️⃣  Volver");
            System.out.println("---------------------------------------");
            System.out.print("Seleccione una opción: ");
            opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1:
                    DuenoController.mostrarDuenos();
                    break;
                case 2:
                    DuenoController.registrarDueno();
                    break;
                case 3:
                    DuenoController.editarDueno();
                    break;
                case 4:
                    DuenoController.eliminarDueno();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        } while (opcion != 0);
    }

    private static void menuMascotas() {
        int opcion;
        do {
            System.out.println("\n----------- Gestión de Mascotas -----------");
            System.out.println("1️⃣  Mostrar Mascotas");
            System.out.println("2️⃣  Registrar Mascota");
            System.out.println("3️⃣  Editar Mascota");
            System.out.println("4️⃣  Eliminar Mascota");
            System.out.println("0️⃣  Volver");
            System.out.println("-----------------------------------------");
            System.out.print("Seleccione una opción: ");
            opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1:
                    MascotaController.mostrarMascotas();
                    break;
                case 2:
                    MascotaController.registrarMascota();
                    break;
                case 3:
                    MascotaController.editarMascota();
                    break;
                case 4:
                    MascotaController.eliminarMascota();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        } while (opcion != 0);
    }
}
