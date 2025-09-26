package HappyFeett.dao;

import HappyFeett.bd.ConexionSingleton;
import HappyFeett.model.Dueno;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DuenoDAO {

    private Connection conn;

    public DuenoDAO() {
        this.conn = ConexionSingleton.getInstance().getConnection();
    }

    // Insertar dueño
    public void insertar(Dueno dueno) {
        String sql = "INSERT INTO duenos (nombre_completo, documento_identidad, direccion, telefono, email) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, dueno.getNombreCompleto());
            stmt.setString(2, dueno.getDocumentoIdentidad());
            stmt.setString(3, dueno.getDireccion());
            stmt.setString(4, dueno.getTelefono());
            stmt.setString(5, dueno.getEmail());
            stmt.executeUpdate();
            System.out.println("✅ Dueño insertado correctamente");
        } catch (SQLException e) {
            System.out.println("❌ Error insertando dueño: " + e.getMessage());
        }
    }

    // Listar dueños
    public List<Dueno> listar() {
        List<Dueno> lista = new ArrayList<>();
        String sql = "SELECT * FROM duenos";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Dueno d = new Dueno(
                        rs.getInt("id"),
                        rs.getString("nombre_completo"),
                        rs.getString("documento_identidad"),
                        rs.getString("direccion"),
                        rs.getString("telefono"),
                        rs.getString("email")
                );
                lista.add(d);
            }
        } catch (SQLException e) {
            System.out.println("❌ Error listando dueños: " + e.getMessage());
        }
        return lista;
    }

    // Actualizar dueño
    public void actualizar(Dueno dueno) {
        String sql = "UPDATE duenos SET nombre_completo=?, documento_identidad=?, direccion=?, telefono=?, email=? WHERE id=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, dueno.getNombreCompleto());
            stmt.setString(2, dueno.getDocumentoIdentidad());
            stmt.setString(3, dueno.getDireccion());
            stmt.setString(4, dueno.getTelefono());
            stmt.setString(5, dueno.getEmail());
            stmt.setInt(6, dueno.getId());
            stmt.executeUpdate();
            System.out.println("✅ Dueño actualizado correctamente");
        } catch (SQLException e) {
            System.out.println("❌ Error actualizando dueño: " + e.getMessage());
        }
    }

    // Eliminar dueño
    public void eliminar(int id) {
        String sql = "DELETE FROM duenos WHERE id=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("✅ Dueño eliminado correctamente");
        } catch (SQLException e) {
            System.out.println("❌ Error eliminando dueño: " + e.getMessage());
        }
    }
}


