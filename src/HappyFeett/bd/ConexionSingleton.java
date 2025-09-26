package HappyFeett.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionSingleton {

    private static ConexionSingleton instancia;
    private static Connection connection;

    private static final String URL = "jdbc:mysql://localhost:3306/";
    private static final String USER = "campus2023";
    private static final String PASS = "campus2023";

    private ConexionSingleton() {
        try {
            connection = DriverManager.getConnection(URL, USER, PASS);
            System.out.println("✅ Conexión exitosa a la base de datos.");
        } catch (SQLException e) {
            System.out.println("❌ Error al conectar: " + e.getMessage());
        }
    }

    public static ConexionSingleton getInstance() {
        if (instancia == null) {
            instancia = new ConexionSingleton();
        }
        return instancia;
    }

    public static Connection getConnection() {
        return connection;
    }

    public static void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("🔒 Conexión cerrada correctamente.");
            }
        } catch (SQLException e) {
            System.out.println("❌ Error al cerrar la conexión: " + e.getMessage());
        }
    }
}
