-- =====================================================
-- DATOS DE PRUEBA PARA HappyFest
-- =====================================================

USE HappyFest;

-- Dueños
INSERT INTO dueno (nombre_completo, documento_identidad, direccion, telefono, email, contacto_emergencia)
VALUES 
('Juan Pérez', '12345678', 'Calle 1 #2-3', '3001234567', 'juan@mail.com', 'Ana Pérez'),
('María Gómez', '87654321', 'Calle 4 #5-6', '3007654321', 'maria@mail.com', 'Luis Gómez');

-- Mascotas
INSERT INTO mascota (nombre, tipo, dueno_id, raza_id, fecha_nacimiento, sexo, url_foto)
VALUES
('Firulais', 'Perro', 1, 1, '2020-01-01', 'Macho', NULL),
('Michi', 'Gato', 2, 2, '2021-06-15', 'Hembra', NULL);

-- Facturas
INSERT INTO factura (numero, descripcion, metodo_pago, total, dueno_id)
VALUES
('F001', 'Compra de alimento', 'TC', 120.0, 1),
('F002', 'Vacunación', 'EF', 80.0, 2);

-- Inventario
INSERT INTO inventario (nombre, descripcion, precio, stock)
VALUES
('Alimento para perro', 'Bolsa de 5kg', 50.0, 10),
('Vacuna antirrábica', 'Vacuna anual', 80.0, 5);

-- Factura Items
INSERT INTO factura_item (factura_id, inventario_id, cantidad, subtotal)
VALUES
(1, 1, 2, 100.0),
(2, 2, 1, 80.0);

-- Citas
INSERT INTO cita (mascota_id, dueno_id, fecha_hora, motivo, estado)
VALUES
(1, 1, '2025-10-02 10:00:00', 'Chequeo general', 'Pendiente'),
(2, 2, '2025-10-03 15:30:00', 'Vacunación anual', 'Pendiente');

