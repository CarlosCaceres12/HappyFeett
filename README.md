# 🐾 HappyFeet - Sistema de Gestión Integral para Veterinaria

## 📌 Descripción
HappyFeet es un sistema de software diseñado para gestionar de forma eficiente la información de la veterinaria **"Happy Feet"**.  
Permite administrar dueños, mascotas, inventario, citas, facturación y el historial médico de cada animal.

---

## 🚀 Tecnologías Utilizadas
- **Java 17**
- **Maven**
- **MySQL 8**
- **JDBC**
- **Git/GitHub**

---

## ⚙️ Funcionalidades Implementadas
- Gestión de **dueños** y sus mascotas.
- Control de **inventario** (productos, medicamentos).
- Registro y consulta de **citas veterinarias**.
- Manejo de **facturación** y detalle de productos.
- Historial médico de cada mascota.
- Menú de **consola interactivo** para navegar entre módulos.

---

## 🗄 Modelo de Base de Datos
La base de datos está compuesta por las tablas:
- `dueno`
- `mascota`
- `inventario`
- `factura`
- `factura_item`
- `cita`
- `historial_medico`

> 📌 Ver carpeta `/database/schema.sql` y `/database/data.sql` para la creación y carga de datos.  
Se recomienda incluir un **diagrama ER** con las relaciones.

---

## 📥 Instalación y Ejecución

### ✅ Requisitos previos
- Java 17
- Maven
- MySQL Server

### 🔧 Pasos de instalación
1. Clonar el repositorio:
   ```bash
   git clone <https://github.com/CarlosCaceres12/HappyFeett.git>

DROP DATABASE IF EXISTS HappyFest;
CREATE DATABASE IF NOT EXISTS HappyFest;
USE HappyFest;

-- Tabla Dueno
CREATE TABLE IF NOT EXISTS dueno (
id INT AUTO_INCREMENT PRIMARY KEY,
nombre_completo VARCHAR(100) NOT NULL,
documento_identidad VARCHAR(20) NOT NULL,
direccion VARCHAR(150),
telefono VARCHAR(20),
email VARCHAR(50),
contacto_emergencia VARCHAR(50)
);

-- Tabla Mascota
CREATE TABLE IF NOT EXISTS mascota (
id INT AUTO_INCREMENT PRIMARY KEY,
nombre VARCHAR(50) NOT NULL,
tipo VARCHAR(50) NOT NULL,
dueno_id INT NOT NULL,
raza_id INT,
fecha_nacimiento DATE,
sexo VARCHAR(10),
url_foto VARCHAR(255),
FOREIGN KEY (dueno_id) REFERENCES dueno(id)
);

-- Tabla Factura
CREATE TABLE IF NOT EXISTS factura (
id INT AUTO_INCREMENT PRIMARY KEY,
numero VARCHAR(50) NOT NULL,
descripcion VARCHAR(150),
metodo_pago VARCHAR(50),
total DOUBLE,
dueno_id INT NOT NULL,
fecha_emision TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
FOREIGN KEY (dueno_id) REFERENCES dueno(id)
);

-- Tabla Inventario (productos y servicios)
CREATE TABLE IF NOT EXISTS inventario (
id INT AUTO_INCREMENT PRIMARY KEY,
nombre VARCHAR(100) NOT NULL,
descripcion VARCHAR(150),
precio DOUBLE NOT NULL,
stock INT DEFAULT 0
);

-- Tabla FacturaItem (items de factura)
CREATE TABLE IF NOT EXISTS factura_item (
id INT AUTO_INCREMENT PRIMARY KEY,
factura_id INT NOT NULL,
inventario_id INT NOT NULL,
cantidad INT NOT NULL,
subtotal DOUBLE NOT NULL,
FOREIGN KEY (factura_id) REFERENCES factura(id) ON DELETE CASCADE,
FOREIGN KEY (inventario_id) REFERENCES inventario(id)
);

-- Tabla Cita
CREATE TABLE IF NOT EXISTS cita (
id INT AUTO_INCREMENT PRIMARY KEY,
mascota_id INT NOT NULL,
dueno_id INT NOT NULL,
fecha_hora DATETIME NOT NULL,
motivo VARCHAR(150),
estado VARCHAR(50) DEFAULT 'Pendiente',
FOREIGN KEY (mascota_id) REFERENCES mascota(id),
FOREIGN KEY (dueno_id) REFERENCES dueno(id)
);

-- Datos de prueba

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

-- Inventario (ejemplo)
INSERT INTO inventario (nombre, descripcion, precio, stock)
VALUES
('Alimento para perro', 'Bolsa de 5kg', 50.0, 10),
('Vacuna antirrábica', 'Vacuna anual', 80.0, 5);

-- FacturaItem (ejemplo)
INSERT INTO factura_item (factura_id, inventario_id, cantidad, subtotal)
VALUES
(1, 1, 2, 100.0),
(2, 2, 1, 80.0);

-- Citas (ejemplo)
INSERT INTO cita (mascota_id, dueno_id, fecha_hora, motivo, estado)
VALUES
(1, 1, '2025-10-02 10:00:00', 'Chequeo general', 'Pendiente'),
(2, 2, '2025-10-03 15:30:00', 'Vacunación anual', 'Pendiente');
