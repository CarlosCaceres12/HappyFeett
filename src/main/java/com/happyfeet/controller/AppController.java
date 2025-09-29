package com.happyfeet.controller;

import com.happyfeet.repository.DuenoDAO;
import com.happyfeet.repository.MascotaDAO;
import com.happyfeet.service.FacturaService;
import com.happyfeet.service.InventarioService;
import com.happyfeet.view.ConsoleView;

import java.util.Scanner;

public class AppController {
    private ConsoleView view = new ConsoleView();
    private DuenoDAO duenoDAO = new DuenoDAO();
    private MascotaDAO mascotaDAO = new MascotaDAO();
    private InventarioService inventarioService = new InventarioService();
    private FacturaService facturaService = new FacturaService();

    public static void main(String[] args) {
        new AppController().run();
    }

    public void run() {
        view.showWelcome();
        Scanner sc = new Scanner(System.in);
        boolean loop = true;
        while (loop) {
            int opt = view.mainMenu();
            switch (opt) {
                case 1:
                    view.listDuenos(duenoDAO.findAll());
                    break;
                case 2:
                    view.listMascotas(mascotaDAO.findAll());
                    break;
                case 3:
                    view.print("Simulando facturación: se deducirá 1 unidad del producto ID 1");
                    boolean ok = inventarioService.deductStock(1, 1);
                    if (ok) {
                        int id = facturaService.createFactura(1, 65.00);
                        if (id > 0) facturaService.generateInvoiceText(id);
                    } else {
                        view.print("No hay stock suficiente para el producto solicitado.");
                    }
                    break;
                case 0:
                    loop = false;
                    break;
                default:
                    view.print("Opción inválida");
            }
        }
        view.print("Saliendo...");
        sc.close();
    }
}
