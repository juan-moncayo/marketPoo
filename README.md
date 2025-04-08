Juan david moncayo muñoz,
Maria valentina vasquez delgado,
Jose manuel mafla muñoz


#crear base de datos
CREATE DATABASE market_db;
USE market_db;

#productos 
CREATE TABLE productos (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    descripcion TEXT,
    precio DECIMAL(10, 2) NOT NULL,
    stock INT NOT NULL
);

#clientes
CREATE TABLE clientes (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    direccion VARCHAR(255),
    telefono VARCHAR(20)
);

#ordenes
CREATE TABLE ordenes (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    fecha DATETIME NOT NULL,
    total DECIMAL(10, 2) NOT NULL,
    estado VARCHAR(20) NOT NULL,
    cliente_id BIGINT NOT NULL,
    FOREIGN KEY (cliente_id) REFERENCES clientes(id)
);

#item ordenes 
CREATE TABLE orden_items (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    cantidad INT NOT NULL,
    precio_unitario DECIMAL(10, 2) NOT NULL,
    producto_id BIGINT NOT NULL,
    orden_id BIGINT NOT NULL,
    FOREIGN KEY (producto_id) REFERENCES productos(id),
    FOREIGN KEY (orden_id) REFERENCES ordenes(id) ON DELETE CASCADE
);

#pagos
CREATE TABLE pagos (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    fecha_pago DATETIME NOT NULL,
    monto DECIMAL(10, 2) NOT NULL,
    metodo VARCHAR(50) NOT NULL,
    estado VARCHAR(20) NOT NULL,
    orden_id BIGINT NOT NULL,
    FOREIGN KEY (orden_id) REFERENCES ordenes(id)
);