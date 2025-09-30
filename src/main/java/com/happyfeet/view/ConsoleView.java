package main.java.com.happyfeet.view;

import java.util.List;
import java.util.Scanner;

public class ConsoleView {
    private Scanner sc = new Scanner(System.in);

    public void showWelcome() {
        System.out.println("=== Bienvenido a HappyFeet Veterinaria ===");
    }

    public int mainMenu() {
        System.out.println("\nMenú principal:");
        System.out.println("1. Listar dueños");
        System.out.println("2. Listar mascotas");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");
        return Integer.parseInt(sc.nextLine());
    }

    public void listDuenos(List<String> data) {
        System.out.println("\n--- Dueños ---");
        data.forEach(System.out::println);
    }

    public void listMascotas(List<String> data) {
        System.out.println("\n--- Mascotas ---");
        data.forEach(System.out::println);
    }

    public void print(String msg) {
        System.out.println(msg);
    }
}
