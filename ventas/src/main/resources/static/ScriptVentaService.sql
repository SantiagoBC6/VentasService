CREATE DATABASE IF NOT EXISTS ventas;
USE ventas;

CREATE TABLE IF NOT EXISTS clientes (
'id' int NOT NULL AUTO_INCREMENT,
  'nombre' varchar(100) NOT NULL,
  'correo' varchar(100) NOT NULL,
  'telefono' varchar(15) DEFAULT NULL,
  'direccion' varchar(500) DEFAULT NULL,
  PRIMARY KEY ('id'),
  UNIQUE KEY 'correo' ('correo')
);

CREATE TABLE IF NOT EXISTS 'productos' (
  'id' int NOT NULL AUTO_INCREMENT,
  'nombre' varchar(100) NOT NULL,
  'descripcion' text,
  'precio' double NOT NULL,
  'cantidad_stock' int NOT NULL,
  PRIMARY KEY ('id')
);

CREATE TABLE IF NOT EXISTS 'envios' (
  'id' int NOT NULL AUTO_INCREMENT,
  'venta_id' int NOT NULL,
  'estado' varchar(50) NOT NULL,
  'fecha_envio' timestamp NOT NULL,
  'fecha_entrega' timestamp NULL DEFAULT NULL,
  PRIMARY KEY ('id'),
  KEY 'venta_id' ('venta_id'),
  CONSTRAINT 'envios_ibfk_1' FOREIGN KEY ('venta_id') REFERENCES 'ventas' ('id') ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS 'ventas' (
  'id' int NOT NULL AUTO_INCREMENT,
  'producto_id' int NOT NULL,
  'cantidad' int NOT NULL,
  'fecha_venta' timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  'cliente_id' int DEFAULT NULL,
  'estado' varchar(50) DEFAULT 'Completada',
  PRIMARY KEY ('id'),
  KEY 'producto_id' ('producto_id'),
  KEY 'cliente_id' ('cliente_id'),
  CONSTRAINT 'ventas_ibfk_1' FOREIGN KEY ('producto_id') REFERENCES 'productos' ('id'),
  CONSTRAINT 'ventas_ibfk_2' FOREIGN KEY ('cliente_id') REFERENCES 'clientes' ('id')
);
