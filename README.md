# Gasolineras API

API REST para la gestión de gasolineras y sus precios por tipo de combustible,
desarrollada con **Spring Boot**. Proyecto personal con el que reconstruyo en backend
el dominio de datos de mi TFG (**AhorraGas**), aplicando arquitectura en capas,
validación y tests.

## 🛠️ Tecnologías
- **Java 21**
- **Spring Boot** (Spring Web, Spring Data JPA)
- **H2** (base de datos en memoria)
- **Bean Validation** (`@Valid`)
- **JUnit 5 + MockMvc** (tests de la API)
- **Maven**

## 🏗️ Arquitectura
Arquitectura en capas:
`Controller` (REST) → `Service` (lógica de negocio) → `Repository` (acceso a datos)

Una `Gasolinera` tiene una lista de precios (`PrecioCombustible`), modelada con
`@ElementCollection`. Los precios usan `BigDecimal` (correcto para dinero).

## 🔌 Endpoints

| Método | Ruta | Descripción |
|--------|------|-------------|
| GET    | `/gasolineras` | Lista todas |
| GET    | `/gasolineras/{id}` | Obtiene una por id (404 si no existe) |
| POST   | `/gasolineras` | Crea una (201); valida los datos (400 si no) |
| PUT    | `/gasolineras/{id}` | Actualiza una |
| DELETE | `/gasolineras/{id}` | Borra una (204) |

## ▶️ Cómo ejecutarlo
Requisitos: **Java 21**.

```bash
./mvnw spring-boot:run
```

La API queda en `http://localhost:8080`.
Consola de la base de datos H2: `http://localhost:8080/h2-console`
(JDBC URL: `jdbc:h2:mem:gasolinerasdb`, usuario: `sa`, sin contraseña).

### Ejemplo: crear una gasolinera
```bash
curl -X POST http://localhost:8080/gasolineras \
  -H "Content-Type: application/json" \
  -d '{"rotulo":"Repsol","municipio":"Madrid","precios":[{"tipo":"Gasolina 95","precio":1.529}]}'
```

## ✅ Tests
```bash
./mvnw test
```

## 👤 Autor
**Cristofer Fernández** — [GitHub](https://github.com/Anticlub) · [LinkedIn](https://linkedin.com/in/cristofer-fdz)
