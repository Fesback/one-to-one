# 📚 Proyecto Hibernate One-to-One

> Este proyecto demuestra la implementación de una relación **One-to-One** entre entidades `Persona` y `Documento` usando **Java**, **Hibernate ORM**, y **MySQL**. Cada persona tiene un documento asociado.

---

## ⚙️ Tecnologías Utilizadas

- ☕ Java 22
- 🧱 Hibernate ORM 6.x
- 🐬 MySQL 8.x
- 💼 Maven
- 🧠 Lombok
- 🧰 MySQL Workbench

---

## 🧠 Descripción

Se modela una relación uno a uno en la cual una **persona** puede tener únicamente un **documento**.  
Esto se logra utilizando las anotaciones de **JPA** y la configuración correspondiente de Hibernate.

---

## 🗂️ Estructura del Proyecto

```
📦src
 ┣ 📂main
 ┃ ┣ 📂java
 ┃ ┃ ┣ 📂com.fescode.model     → Entidades: Persona, Documento
 ┃ ┃ ┣ 📂com.fescode.service   → Lógica del servicio
 ┃ ┃ ┗ 📜MainApp.java          → Clase principal
 ┃ ┗ 📂resources
 ┃   ┗ 📜META-INF/persistence.xml
 ┗ 📜pom.xml
```
## 🧪 Base de Datos

Ejecutar en la base de Datos lo siguiente

```
CREATE DATABASE IF NOT EXISTS one2one;

use one2one;

-- tabla persona
CREATE TABLE persona(
	id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre varchar(50) NOT NULL
);

-- TABLA DOCUMENTO
CREATE TABLE documento (
	id BIGINT AUTO_INCREMENT PRIMARY KEY,
    tipo varchar(50) NOT NULL,
    fecha_expedicion DATE,
    persona_id BIGINT,
    CONSTRAINT fk_persona FOREIGN KEY (persona_id) REFERENCES persona(id)
);

INSERT INTO persona (nombre) VALUES
('Persona 1'),
('Persona 2'),
('Persona 3'),
('Persona 4'),
('Persona 5');

-- Insertar datos en documento
INSERT INTO documento (tipo, fecha_expedicion, persona_id) VALUES
('DNI', '2021-01-01', 1),
('Pasaporte', '2020-06-15', 2),
('Carnet', '2022-03-10', 3),
('DNI', '2021-09-05', 4),
('Pasaporte', '2023-02-20', 5);

ALTER TABLE documento CHANGE tipo tipoDocumento VARCHAR(50) NOT NULL;
```
