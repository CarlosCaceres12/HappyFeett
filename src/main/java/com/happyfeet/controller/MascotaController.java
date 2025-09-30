package main.java.com.happyfeet.controller;

import main.java.com.happyfeet.model.Mascota;
import main.java.com.happyfeet.repository.MascotaDAO;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

public class MascotaController {

    private static final MascotaDAO mascotaDAO = new MascotaDAO();
    private static final Scanner scanner = new Scanner(System.in);

    // Mostrar lista de mascotas
    public static void mostrarMascotas() {
        System.out.println("===== Lista de Mascotas =====");
        List<Mascota> mascotas = mascotaDAO.getMascotas();

        if (mascotas.isEmpty()) {
            System.out.println("No hay mascotas registradas.");
            return;
        }

        for (int i = 0; i < mascotas.size(); i++) {
            Mascota m = mascotas.get(i);
            System.out.println((i + 1) + ". " + m.getNombre() + " - Tipo: " + m.getTipo() +
                    " - Dueño ID: " + m.getDuenoId());
        }
    }

    // Registrar mascota
    public static void registrarMascota() {
        System.out.println("===== Registrar Mascota =====");
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Tipo: ");
        String tipo = scanner.nextLine();
        System.out.print("ID del dueño: ");
        int duenoId = Integer.parseInt(scanner.nextLine());
        System.out.print("ID de la raza: ");
        int razaId = Integer.parseInt(scanner.nextLine());
        System.out.print("Fecha de nacimiento (YYYY-MM-DD): ");
        Date fechaNacimiento = Date.valueOf(scanner.nextLine());
        System.out.print("Sexo: ");
        String sexo = scanner.nextLine();
        System.out.print("URL de la foto: ");
        String urlFoto = scanner.nextLine();

        Mascota m = new Mascota(nombre, tipo, duenoId, razaId, fechaNacimiento, sexo, urlFoto);
        mascotaDAO.agregarMascota(m);
        System.out.println("Mascota registrada correctamente.");
    }

    // Editar mascota
    public static void editarMascota() {
        mostrarMascotas();
        System.out.print("Seleccione el número de la mascota a editar: ");
        int index = Integer.parseInt(scanner.nextLine()) - 1;

        System.out.print("Nuevo nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Nuevo tipo: ");
        String tipo = scanner.nextLine();
        System.out.print("Nuevo ID del dueño: ");
        int duenoId = Integer.parseInt(scanner.nextLine());
        System.out.print("Nuevo ID de la raza: ");
        int razaId = Integer.parseInt(scanner.nextLine());
        System.out.print("Nueva fecha de nacimiento (YYYY-MM-DD): ");
        Date fechaNacimiento = Date.valueOf(scanner.nextLine());
        System.out.print("Nuevo sexo: ");
        String sexo = scanner.nextLine();
        System.out.print("Nueva URL de la foto: ");
        String urlFoto = scanner.nextLine();

        Mascota m = new Mascota(nombre, tipo, duenoId, razaId, fechaNacimiento, sexo, urlFoto);
        mascotaDAO.editarMascota(index, m);
        System.out.println("Mascota editada correctamente.");
    }

    // Eliminar mascota
    public static void eliminarMascota() {
        mostrarMascotas();
        System.out.print("Seleccione el número de la mascota a eliminar: ");
        int index = Integer.parseInt(scanner.nextLine()) - 1;
        mascotaDAO.eliminarMascota(index);
        System.out.println("Mascota eliminada correctamente.");
    }
}
