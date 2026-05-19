-- Limpiar por si ya existen
DROP TABLE IF EXISTS Cuenta;
DROP TABLE IF EXISTS Cliente;

-- Tabla Cliente
CREATE TABLE Cliente (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    dni VARCHAR(20) UNIQUE NOT NULL,
    telefono VARCHAR(20)
);

-- Tabla Cuenta
CREATE TABLE Cuenta (
    id INT AUTO_INCREMENT PRIMARY KEY,
    saldo DOUBLE NOT NULL DEFAULT 0,
    cliente_id INT NOT NULL,
    
    FOREIGN KEY (cliente_id) REFERENCES Cliente(id)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);

-- Insertar clientes
INSERT INTO Cliente (nombre, dni, telefono) VALUES
('Juan Pérez', '12345678A', '600123456'),
('María López', '87654321B', '611987654'),
('Carlos García', '11223344C', '622334455'),
('Ana Torres', '44332211D', '633556677');

-- Insertar cuentas
INSERT INTO Cuenta (saldo, cliente_id) VALUES
(1500.50, 1),
(230.00, 1),
(3200.75, 2),
(50.00, 3),
(780.20, 3),
(12000.00, 4);
