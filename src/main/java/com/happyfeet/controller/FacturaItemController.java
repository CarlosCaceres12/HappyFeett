package main.java.com.happyfeet.controller;

import main.java.com.happyfeet.model.FacturaItem;
import main.java.com.happyfeet.repository.FacturaItemDAO;
import main.java.com.happyfeet.repository.InventarioDAO;
import main.java.com.happyfeet.model.Inventario;

import java.util.List;
import java.util.Scanner;

public class FacturaItemController {

    private static final FacturaItemDAO itemDAO = new FacturaItemDAO();
    private static final InventarioDAO inventarioDAO = new InventarioDAO();
    private static final Scanner scanner = new Scanner(System.in);

    // Agregar item a factura
    public static void agregarItemAFactura(int facturaId) {
        System.out.println("===== Agregar Item a Factura =====");
        List<Inventario> lista = inventarioDAO.getInventario();
        if (lista.isEmpty()) {
            System.out.println("No hay productos en inventario.");
            return;
        }

        // Mostrar inventario
        for (Inventario i : lista) {
            System.out.println(i.getId() + ". " + i.getNombre() + " - Precio: $" + i.getPrecio() + " - Stock: " + i.getStock());
        }

        System.out.print("Ingrese el ID del producto/servicio: ");
        int inventarioId = Integer.parseInt(scanner.nextLine());

        System.out.print("Cantidad: ");
        int cantidad = Integer.parseInt(scanner.nextLine());

        // Buscar el producto para obtener precio y stock
        Inventario producto = lista.stream().filter(p -> p.getId() == inventarioId).findFirst().orElse(null);
        if (producto == null) {
            System.out.println("Producto no encontrado.");
            return;
        }
        if (cantidad > producto.getStock()) {
            System.out.println("Stock insuficiente.");
            return;
        }

        double subtotal = cantidad * producto.getPrecio();

        // Crear item y guardarlo
        FacturaItem item = new FacturaItem(facturaId, inventarioId, cantidad, subtotal);
        itemDAO.agregarItem(item);

        System.out.println("Item agregado a la factura correctamente.");
    }

    // Mostrar items de una factura
    public static void mostrarItemsDeFactura(int facturaId) {
        System.out.println("===== Items de la Factura =====");
        List<FacturaItem> lista = itemDAO.getItemsPorFactura(facturaId);
        if (lista.isEmpty()) {
            System.out.println("No hay items en esta factura.");
            return;
        }
        for (FacturaItem item : lista) {
            System.out.println("ID Item: " + item.getId() +
                    ", Producto ID: " + item.getInventarioId() +
                    ", Cantidad: " + item.getCantidad() +
                    ", Subtotal: $" + item.getSubtotal());
        }
    }
}
