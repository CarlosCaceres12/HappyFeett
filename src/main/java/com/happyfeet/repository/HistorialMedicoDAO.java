package main.java.com.happyfeet.repository;

import main.java.com.happyfeet.model.HistorialMedico;
import java.util.ArrayList;
import java.util.List;

public class HistorialMedicoDAO {

    private static final List<HistorialMedico> historiales = new ArrayList<>();

    // Agregar historial
    public void agregarHistorial(HistorialMedico historial) {
        historiales.add(historial);
    }

    // Obtener todos los historiales
    public List<HistorialMedico> getHistoriales() {
        return historiales;
    }

    // Editar historial
    public void editarHistorial(int index, HistorialMedico historial) {
        if (index >= 0 && index < historiales.size()) {
            historiales.set(index, historial);
        }
    }

    // Eliminar historial
    public void eliminarHistorial(int index) {
        if (index >= 0 && index < historiales.size()) {
            historiales.remove(index);
        }
    }
}
