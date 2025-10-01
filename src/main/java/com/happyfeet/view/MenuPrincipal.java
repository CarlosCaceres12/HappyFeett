package main.java.com.happyfeet.view;

import main.java.com.happyfeet.controller.DuenoController;
import main.java.com.happyfeet.controller.MascotaController;
import main.java.com.happyfeet.controller.FacturaController;
import main.java.com.happyfeet.controller.HistorialMedicoController;

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
            System.out.println("3️⃣  Gestión de Facturas");
            System.out.println("4️⃣  Gestión de Historial Médico");
            System.out.println("0️⃣  Salir");
            System.out.println("--------------------------------------");
            System.out.print("Seleccione una opción: ");
            opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1 -> menuDuenos();
                case 2 -> menuMascotas();
                case 3 -> menuFacturas();
                case 4 -> menuHistorialMedico();
                case 0 -> System.out.println("¡Gracias por usar Veterinaria Happy Feet! 🐶🐱");
                default -> System.out.println("⚠️ Opción inválida, intente de nuevo.");
            }
        } while (opcion != 0);
    }

    // ===== SUBMENÚ DUEÑOS =====
    private static void menuDuenos() {
        boolean volver = false;
        while (!volver) {
            System.out.println("\n===== MENÚ DUEÑOS =====");
            System.out.println("1. Registrar Dueño");
            System.out.println("2. Mostrar Dueños");
            System.out.println("3. Editar Dueño");
            System.out.println("4. Eliminar Dueño");
            System.out.println("0. Volver");
            System.out.print("Seleccione una opción: ");
            int opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1 -> DuenoController.registrarDueno();
                case 2 -> DuenoController.mostrarDuenos();
                case 3 -> DuenoController.editarDueno();
                case 4 -> DuenoController.eliminarDueno();
                case 0 -> volver = true;
                default -> System.out.println("⚠️ Opción inválida.");
            }
        }
    }

    // ===== SUBMENÚ MASCOTAS =====
    private static void menuMascotas() {
        boolean volver = false;
        while (!volver) {
            System.out.println("\n===== MENÚ MASCOTAS =====");
            System.out.println("1. Registrar Mascota");
            System.out.println("2. Mostrar Mascotas");
            System.out.println("3. Editar Mascota");
            System.out.println("4. Eliminar Mascota");
            System.out.println("0. Volver");
            System.out.print("Seleccione una opción: ");
            int opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1 -> MascotaController.registrarMascota();
                case 2 -> MascotaController.mostrarMascotas();
                case 3 -> MascotaController.editarMascota();
                case 4 -> MascotaController.eliminarMascota();
                case 0 -> volver = true;
                default -> System.out.println("⚠️ Opción inválida.");
            }
        }
    }

    // ===== SUBMENÚ FACTURAS =====
    private static void menuFacturas() {
        boolean volver = false;
        while (!volver) {
            System.out.println("\n===== MENÚ FACTURAS =====");
            System.out.println("1. Registrar Factura");
            System.out.println("2. Mostrar Facturas");
            System.out.println("3. Editar Factura");
            System.out.println("4. Eliminar Factura");
            System.out.println("0. Volver");
            System.out.print("Seleccione una opción: ");
            int opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1 -> FacturaController.registrarFactura();
                case 2 -> FacturaController.mostrarFacturas();
                case 3 -> FacturaController.editarFactura();
                case 4 -> FacturaController.eliminarFactura();
                case 0 -> volver = true;
                default -> System.out.println("⚠️ Opción inválida.");
            }
        }
    }

    // ===== SUBMENÚ HISTORIAL MÉDICO =====
    private static void menuHistorialMedico() {
        boolean volver = false;
        while (!volver) {
            System.out.println("\n===== MENÚ HISTORIAL MÉDICO =====");
            System.out.println("1. Registrar Historial Médico");
            System.out.println("2. Mostrar Historiales Médicos");
            System.out.println("3. Editar Historial Médico");
            System.out.println("4. Eliminar Historial Médico");
            System.out.println("0. Volver");
            System.out.print("Seleccione una opción: ");
            int opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1 -> HistorialMedicoController.registrarHistorial();
                case 2 -> HistorialMedicoController.mostrarHistoriales();
                case 3 -> HistorialMedicoController.editarHistorial();
                case 4 -> HistorialMedicoController.eliminarHistorial();
                case 0 -> volver = true;
                default -> System.out.println("⚠️ Opción inválida.");
            }
        }
    }
}
