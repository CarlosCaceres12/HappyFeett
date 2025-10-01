package main.java.com.happyfeet.controller;

import main.java.com.happyfeet.model.HistorialMedico;
import main.java.com.happyfeet.repository.HistorialMedicoDAO;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

public class HistorialMedicoController {

    private static final HistorialMedicoDAO historialDAO = new HistorialMedicoDAO();
    private static final Scanner scanner = new Scanner(System.in);

    // Mostrar todos los historiales
    public static void mostrarHistoriales() {
        System.out.println("===== Lista de Historiales Médicos =====");
        List<HistorialMedico> historiales = historialDAO.getHistoriales();

        if (historiales.isEmpty()) {
            System.out.println("No hay historiales médicos registrados.");
            return;
        }

        for (int i = 0; i < historiales.size(); i++) {
            HistorialMedico h = historiales.get(i);
            System.out.println((i + 1) + ". Mascota ID: " + h.getMascotaId() +
                    " | Diagnóstico: " + h.getDiagnostico() +
                    " | Tratamiento: " + h.getTratamiento() +
                    " | Fecha: " + h.getFecha());
        }
    }

    // Registrar historial médico
    public static void registrarHistorial() {
        System.out.println("===== Registrar Historial Médico =====");
        System.out.print("ID de la mascota: ");
        int mascotaId = Integer.parseInt(scanner.nextLine());
        System.out.print("Diagnóstico: ");
        String diagnostico = scanner.nextLine();
        System.out.print("Tratamiento: ");
        String tratamiento = scanner.nextLine();
        System.out.print("Fecha (YYYY-MM-DD): ");
        Date fecha = Date.valueOf(scanner.nextLine());

        HistorialMedico historial = new HistorialMedico(mascotaId, diagnostico, tratamiento, fecha);
        historialDAO.agregarHistorial(historial);

        System.out.println("Historial médico registrado correctamente.");
    }

    // Editar historial médico
    public static void editarHistorial() {
        mostrarHistoriales();
        System.out.print("Seleccione el número del historial a editar: ");
        int index = Integer.parseInt(scanner.nextLine()) - 1;

        System.out.print("Nuevo ID de la mascota: ");
        int mascotaId = Integer.parseInt(scanner.nextLine());
        System.out.print("Nuevo diagnóstico: ");
        String diagnostico = scanner.nextLine();
        System.out.print("Nuevo tratamiento: ");
        String tratamiento = scanner.nextLine();
        System.out.print("Nueva fecha (YYYY-MM-DD): ");
        Date fecha = Date.valueOf(scanner.nextLine());

        HistorialMedico historial = new HistorialMedico(mascotaId, diagnostico, tratamiento, fecha);
        historialDAO.editarHistorial(index, historial);

        System.out.println("Historial médico editado correctamente.");
    }

    // Eliminar historial médico
    public static void eliminarHistorial() {
        mostrarHistoriales();
        System.out.print("Seleccione el número del historial a eliminar: ");
        int index = Integer.parseInt(scanner.nextLine()) - 1;
        historialDAO.eliminarHistorial(index);
        System.out.println("Historial médico eliminado correctamente.");
    }
}
