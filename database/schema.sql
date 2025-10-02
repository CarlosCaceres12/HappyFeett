-- =====================================================
-- SCHEMA DE LA BASE DE DATOS: HappyFest
-- =====================================================
-- =====================================================
-- SCHEMA DE LA BASE DE DATOS: HappyFest
-- =====================================================

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

