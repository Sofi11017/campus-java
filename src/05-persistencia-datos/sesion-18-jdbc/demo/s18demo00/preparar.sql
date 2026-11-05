-- Ejecuta primero la preparación administrativa del README de la sesión.
USE campus_java_s18;

CREATE TABLE IF NOT EXISTS usuarios (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    correo VARCHAR(150) NOT NULL UNIQUE
);

-- Semillas opcionales. No reemplazan los registros creados desde Java.
INSERT INTO usuarios (nombre, correo)
SELECT 'Ana Torres', 'ana.torres@example.com'
WHERE NOT EXISTS (SELECT 1 FROM usuarios WHERE correo = 'ana.torres@example.com');
INSERT INTO usuarios (nombre, correo)
SELECT 'Luis Rojas', 'luis.rojas@example.com'
WHERE NOT EXISTS (SELECT 1 FROM usuarios WHERE correo = 'luis.rojas@example.com');

SELECT id, nombre, correo FROM usuarios ORDER BY id;
