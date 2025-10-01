package main.java.com.happyfeet.controller;

import main.java.com.happyfeet.model.Inventario;
import main.java.com.happyfeet.repository.InventarioDAO;

import java.util.List;
import java.util.Scanner;

public class InventarioController {

    private static final InventarioDAO inventarioDAO = new InventarioDAO();
    private static final Scanner scanner = new Scanner(System.in);

    // Opción para agregar producto/servicio
    public static void agregarInventario() {
        System.out.println("===== Agregar Producto/Servicio =====");
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Descripción: ");
        String descripcion = scanner.nextLine();
        System.out.print("Precio: ");
        double precio = Double.parseDouble(scanner.nextLine());
        System.out.print("Stock: ");
        int stock = Integer.parseInt(scanner.nextLine());

        Inventario item = new Inventario(nombre, descripcion, precio, stock);
        inventarioDAO.agregarInventario(item);
        System.out.println("Producto/Servicio agregado correctamente.");
    }

    // Opción para listar inventario
    public static void mostrarInventario() {
        System.out.println("===== Inventario =====");
        List<Inventario> lista = inventarioDAO.getInventario();
        if (lista.isEmpty()) {
            System.out.println("No hay productos en inventario.");
            return;
        }
        for (Inventario i : lista) {
            System.out.println("ID: " + i.getId() +
                    ", Nombre: " + i.getNombre() +
                    ", Descripción: " + i.getDescripcion() +
                    ", Precio: $" + i.getPrecio() +
                    ", Stock: " + i.getStock());
        }
    }
}
