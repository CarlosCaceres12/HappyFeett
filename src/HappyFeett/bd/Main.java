
import HappyFeett.bd.ConexionSingleton;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        ConexionSingleton.getInstance(); // inicializa la conexión
        Connection conn = ConexionSingleton.getConnection();

        if (conn != null) {
            System.out.println("✔ Conectado desde Main.");

            try {
                Statement stmt = conn.createStatement();

                // 👇 Seleccionamos la base de datos
                stmt.execute("USE HappyFeet;");

                // 👇 Insertar un dueño de prueba
                String insertSQL = "INSERT INTO duenos (nombre_completo, documento_identidad, direccion, telefono, email) " +
                        "VALUES ('Carlos Ruiz', '987654321', 'Av. Principal 123', '3112233445', 'carlos@example.com')";
                int filas = stmt.executeUpdate(insertSQL);
                System.out.println("✔ Dueño insertado. Filas afectadas: " + filas);

                // 👇 Consultar todos los dueños
                ResultSet rs = stmt.executeQuery("SELECT * FROM duenos;");

                System.out.println("📋 Lista de dueños:");
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String nombre = rs.getString("nombre_completo");
                    String telefono = rs.getString("telefono");
                    String email = rs.getString("email");
                    System.out.println("ID: " + id + " | Nombre: " + nombre + " | Tel: " + telefono + " | Email: " + email);
                }

                rs.close();
                stmt.close();
            } catch (Exception e) {
                System.out.println("✘ Error ejecutando consulta: " + e.getMessage());
            } finally {
                ConexionSingleton.closeConnection();
            }
        }
    }
}



