package HappyFeett.bd;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        ConexionSingleton conexion = ConexionSingleton.getInstance();

        Connection conn = conexion.getConnection();
        if (conn != null) {
            System.out.println("🚀 Conectado desde Main.");
        }
        ConexionSingleton.closeConnection();
    }
}