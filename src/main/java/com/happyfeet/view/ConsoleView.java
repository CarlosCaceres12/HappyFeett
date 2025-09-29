package com.happyfeet.view;

import com.happyfeet.model.Mascota;
import com.happyfeet.model.Dueno;
import java.util.List;
import java.util.Scanner;

public class ConsoleView {
    private Scanner sc = new Scanner(System.in);

    public void showWelcome() {
        System.out.println("=== Happy Feet - Sistema de Gestión ===");
    }

    public int mainMenu() {
        System.out.println("\n1) Listar Dueños\n2) Listar Mascotas\n3) Facturar (simulación)\n0) Salir");
        System.out.print("Seleccione una opción: ");
        try {
            return Integer.parseInt(sc.nextLine());
        } catch (Exception e) {
            return -1;
        }
    }

    public void listDuenos(List<Dueno> list) {
        System.out.println("-- Dueños --");
        list.forEach(d -> System.out.println(d));
    }

    public void listMascotas(List<Mascota> list) {
        System.out.println("-- Mascotas --");
        list.forEach(m -> System.out.println(m));
    }

    public void print(String msg) {
        System.out.println(msg);
    }
}
