package main.java.com.happyfeet;

import main.java.com.happyfeet.model.Factura;
import main.java.com.happyfeet.repository.FacturaDAO;
import main.java.com.happyfeet.util.DBConnection;

import java.sql.Timestamp;

public class AgregarFacturasPrueba {

    public static void main(String[] args) {
        // Inicializar conexión
        DBConnection.getInstance();
        FacturaDAO facturaDAO = new FacturaDAO();

        // Factura 1
        Factura f1 = new Factura();
        f1.setDuenoId(1); // ID de dueño existente
        f1.setFechaEmision(new Timestamp(System.currentTimeMillis()));
        f1.setTotal(150000.0);
        facturaDAO.agregarFactura(f1);

        // Factura 2
        Factura f2 = new Factura();
        f2.setDuenoId(2); // ID de dueño existente
        f2.setFechaEmision(new Timestamp(System.currentTimeMillis()));
        f2.setTotal(95000.0);
        facturaDAO.agregarFactura(f2);

        // Factura 3
        Factura f3 = new Factura();
        f3.setDuenoId(3); // ID de dueño existente
        f3.setFechaEmision(new Timestamp(System.currentTimeMillis()));
        f3.setTotal(120000.0);
        facturaDAO.agregarFactura(f3);

        System.out.println("✅ Facturas de prueba agregadas correctamente");
    }
}
