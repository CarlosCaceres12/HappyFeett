INSERT INTO especies (nombre) VALUES ('Perro'), ('Gato') ON DUPLICATE KEY UPDATE nombre=nombre;
INSERT INTO razas (especie_id, nombre) VALUES (1, 'Labrador'), (1, 'Bulldog'), (2, 'Siamés') ON DUPLICATE KEY UPDATE nombre=nombre;
INSERT INTO producto_tipos (nombre) VALUES ('Medicamento'), ('Vacuna'), ('Insumo Médico') ON DUPLICATE KEY UPDATE nombre=nombre;
INSERT INTO evento_tipos (nombre) VALUES ('Vacunación'), ('Consulta'), ('Cirugía') ON DUPLICATE KEY UPDATE nombre=nombre;
INSERT INTO cita_estados (nombre) VALUES ('Programada'), ('En Proceso'), ('Finalizada'), ('Cancelada') ON DUPLICATE KEY UPDATE nombre=nombre;

INSERT INTO duenos (nombre_completo, documento_identidad, direccion, telefono, email)
VALUES 
('Juan Perez', '12345678', 'Calle 1 #2-3', '3001234567', 'juan@example.com'),
('Maria Gomez', '87654321', 'Calle 4 #5-6', '3007654321', 'maria@example.com')
ON DUPLICATE KEY UPDATE nombre_completo=nombre_completo;

INSERT INTO mascotas (dueno_id, nombre, raza_id, fecha_nacimiento, sexo, url_foto)
VALUES
(1, 'Firulais', 1, '2018-05-01', 'Macho', ''),
(2, 'Mishka', 3, '2020-02-10', 'Hembra', '')
ON DUPLICATE KEY UPDATE nombre=nombre;

INSERT INTO inventario (nombre_producto, producto_tipo_id, descripcion, fabricante, lote, cantidad_stock, stock_minimo, fecha_vencimiento, precio_venta)
VALUES
('Antiparásito', 1, 'Tabletas antiparasitarias', 'VetPharm', 'L001', 50, 10, '2026-01-01', 25.00),
('Vacuna Rabia', 2, 'Vacuna antirrábica', 'BioVet', 'V2025', 30, 5, '2025-12-31', 40.00)
ON DUPLICATE KEY UPDATE nombre_producto=nombre_producto;
