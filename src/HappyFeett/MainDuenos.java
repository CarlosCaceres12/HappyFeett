package HappyFeett;

import HappyFeett.dao.DuenoDAO;
import HappyFeett.model.Dueno;
import HappyFeett.bd.ConexionSingleton; // 👈 importa el singleton

import java.sql.Connection;
import java.sql.Statement;
import java.util.List;

public class MainDuenos {
    public static void main(String[] args) {
        try {
// Obtenemos la conexión
            Connection conn = ConexionSingleton.getInstance().getConnection();


            // Seleccionamos la base de datos (solo una vez)
            try (Statement stmt = conn.createStatement()) {
                stmt.execute("USE HappyFeet"); // 👈 cambia "HappyFeet" por el nombre real de tu BD
            }

            DuenoDAO dao = new DuenoDAO();

            // Insertar un nuevo dueño
            Dueno nuevo = new Dueno("Carlos Ruiz", "987654321", "Av. Principal 123", "3112233445", "carlos@example.com");
            dao.insertar(nuevo);

            // Listar dueños
            System.out.println("📋 Lista de dueños:");
            List<Dueno> lista = dao.listar();
            for (Dueno d : lista) {
                System.out.println(d);
            }

            // Actualizar (ejemplo: el primero si existe)
            if (!lista.isEmpty()) {
                Dueno primero = lista.get(0);
                primero.setTelefono("3001122333");
                dao.actualizar(primero);
            }
            // Cerrar la conexión
            ConexionSingleton.closeConnection();

        } catch (Exception e) {
            System.out.println("❌ Error en MainDuenos: " + e.getMessage());
        }

    }


}

