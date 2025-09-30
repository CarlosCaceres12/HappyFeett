package main.java.com.happyfeet.controller;

import main.java.com.happyfeet.model.Factura;
import main.java.com.happyfeet.repository.FacturaDAO;

import java.util.List;
import java.util.Scanner;

public class FacturaController {

    private static final FacturaDAO facturaDAO = new FacturaDAO();
    private static final Scanner scanner = new Scanner(System.in);

    // Registrar factura
    public static void registrarFactura() {
        System.out.println("===== Registrar Factura =====");
        System.out.print("Número de factura: ");
        String numero = scanner.nextLine();
        System.out.print("Descripción: ");
        String descripcion = scanner.nextLine();
        System.out.print("Método de pago: ");
        String metodoPago = scanner.nextLine();
        System.out.print("Total: ");
        double total = Double.parseDouble(scanner.nextLine());
        System.out.print("ID del dueño: ");
        int duenoId = Integer.parseInt(scanner.nextLine());

        Factura factura = new Factura(numero, descripcion, metodoPago, total);
        factura.setDuenoId(duenoId);

        facturaDAO.agregarFactura(factura);
        System.out.println("Factura registrada correctamente.");
    }

    // Mostrar todas las facturas
    public static void mostrarFacturas() {
        System.out.println("===== Lista de Facturas =====");
        List<Factura> facturas = facturaDAO.getFacturas();
        if (facturas.isEmpty()) {
            System.out.println("No hay facturas registradas.");
            return;
        }

        for (int i = 0; i < facturas.size(); i++) {
            Factura f = facturas.get(i);
            System.out.println((i + 1) + ". Dueño ID: " + f.getDuenoId() +
                    ", Fecha: " + f.getFechaEmision() +
                    ", Total: $" + f.getTotal());
        }
    }
}
