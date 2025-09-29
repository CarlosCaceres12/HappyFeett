package com.happyfeet.controller;

import com.happyfeet.repository.DuenoDAO;
import com.happyfeet.repository.MascotaDAO;
import com.happyfeet.view.ConsoleView;
import java.util.Scanner;

public class AppController {
    private ConsoleView view = new ConsoleView();
    private DuenoDAO duenoDAO = new DuenoDAO();
    private MascotaDAO mascotaDAO = new MascotaDAO();

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
