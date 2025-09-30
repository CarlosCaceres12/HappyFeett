package main.java.com.happyfeet.controller;

import main.java.com.happyfeet.model.Dueno;
import main.java.com.happyfeet.repository.DuenoDAO;

import java.util.List;
import java.util.Scanner;

public class DuenoController {

    private static final DuenoDAO duenoDAO = new DuenoDAO();
    private static final Scanner scanner = new Scanner(System.in);

    public static void mostrarDuenos() {
        System.out.println("===== Lista de Dueños =====");
        List<Dueno> duenos = duenoDAO.getDuenos();
        if (duenos.isEmpty()) {
            System.out.println("No hay dueños registrados.");
        } else {
            for (int i = 0; i < duenos.size(); i++) {
                Dueno d = duenos.get(i);
                System.out.println((i + 1) + ". " + d.getNombreCompleto() + " - " + d.getDocumentoIdentidad());
            }
        }
    }

    public static void registrarDueno() {
        System.out.println("===== Registrar Dueño =====");
        System.out.print("Nombre completo: ");
        String nombre = scanner.nextLine();
        System.out.print("Documento: ");
        String documento = scanner.nextLine();
        System.out.print("Dirección: ");
        String direccion = scanner.nextLine();
        System.out.print("Teléfono: ");
        String telefono = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Contacto de emergencia: ");
        String contacto = scanner.nextLine();

        Dueno dueno = new Dueno(nombre, documento, direccion, telefono, email, contacto);
        duenoDAO.agregarDueno(dueno);
        System.out.println("Dueño registrado correctamente.");
    }

    public static void editarDueno() {
        mostrarDuenos();
        System.out.print("Seleccione el número del dueño a editar: ");
        int index = Integer.parseInt(scanner.nextLine()) - 1;

        System.out.print("Nuevo nombre completo: ");
        String nombre = scanner.nextLine();
        System.out.print("Nueva dirección: ");
        String direccion = scanner.nextLine();
        System.out.print("Nuevo teléfono: ");
        String telefono = scanner.nextLine();
        System.out.print("Nuevo email: ");
        String email = scanner.nextLine();
        System.out.print("Nuevo contacto de emergencia: ");
        String contacto = scanner.nextLine();

        Dueno d = new Dueno(nombre, "", direccion, telefono, email, contacto);
        duenoDAO.editarDueno(index, d);
        System.out.println("Dueño editado correctamente.");
    }

    public static void eliminarDueno() {
        mostrarDuenos();
        System.out.print("Seleccione el número del dueño a eliminar: ");
        int index = Integer.parseInt(scanner.nextLine()) - 1;
        duenoDAO.eliminarDueno(index);
        System.out.println("Dueño eliminado correctamente.");
    }
}
