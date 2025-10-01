package main.java.com.happyfeet.controller;

import main.java.com.happyfeet.model.Cita;
import main.java.com.happyfeet.repository.CitaDAO;

import java.sql.Timestamp;
import java.util.List;
import java.util.Scanner;

public class CitaController {

    private static final CitaDAO citaDAO = new CitaDAO();
    private static final Scanner scanner = new Scanner(System.in);

    // Registrar cita
    public static void registrarCita() {
        System.out.println("===== Registrar Cita =====");
        System.out.print("ID de la mascota: ");
        int mascotaId = Integer.parseInt(scanner.nextLine().trim());
        System.out.print("ID del dueño: ");
        int duenoId = Integer.parseInt(scanner.nextLine().trim());
        System.out.print("Fecha y hora (YYYY-MM-DD HH:MM:SS): ");
        String fechaHoraStr = scanner.nextLine().trim().replace("/", "-");
        Timestamp fechaHora = Timestamp.valueOf(fechaHoraStr);
        System.out.print("Motivo: ");
        String motivo = scanner.nextLine();
        System.out.print("Estado (Pendiente/Completada/Cancelada): ");
        String estado = scanner.nextLine();

        Cita cita = new Cita(mascotaId, duenoId, fechaHora, motivo, estado);
        citaDAO.agregarCita(cita);
        System.out.println("Cita registrada correctamente.");
    }

    // Mostrar todas las citas
    public static void mostrarCitas() {
        System.out.println("===== Lista de Citas =====");
        List<Cita> citas = citaDAO.getCitas();
        if (citas.isEmpty()) {
            System.out.println("No hay citas registradas.");
            return;
        }

        for (Cita c : citas) {
            System.out.println("ID: " + c.getId() +
                    ", Mascota ID: " + c.getMascotaId() +
                    ", Dueño ID: " + c.getDuenoId() +
                    ", Fecha y Hora: " + c.getFechaHora() +
                    ", Motivo: " + c.getMotivo() +
                    ", Estado: " + c.getEstado());
        }
    }

    // Editar cita
    public static void editarCita() {
        mostrarCitas();
        System.out.print("Ingrese el ID de la cita a editar: ");
        int id = Integer.parseInt(scanner.nextLine().trim());

        System.out.print("ID de la mascota: ");
        int mascotaId = Integer.parseInt(scanner.nextLine().trim());
        System.out.print("ID del dueño: ");
        int duenoId = Integer.parseInt(scanner.nextLine().trim());
        System.out.print("Fecha y hora (YYYY-MM-DD HH:MM:SS): ");
        String fechaHoraStr = scanner.nextLine().trim().replace("/", "-");
        Timestamp fechaHora = Timestamp.valueOf(fechaHoraStr);
        System.out.print("Motivo: ");
        String motivo = scanner.nextLine();
        System.out.print("Estado: ");
        String estado = scanner.nextLine();

        Cita cita = new Cita(mascotaId, duenoId, fechaHora, motivo, estado);
        citaDAO.editarCita(id, cita);
        System.out.println("Cita editada correctamente.");
    }

    // Eliminar cita
    public static void eliminarCita() {
        mostrarCitas();
        System.out.print("Ingrese el ID de la cita a eliminar: ");
        int id = Integer.parseInt(scanner.nextLine().trim());
        citaDAO.eliminarCita(id);
        System.out.println("Cita eliminada correctamente.");
    }
}
