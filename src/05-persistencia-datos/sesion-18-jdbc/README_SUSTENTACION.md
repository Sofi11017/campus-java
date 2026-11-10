# 🎓 Guía Completa de Sustentación · Sesión 18: JDBC y Patrón MVC + DAO

Este documento reúne toda la explicación técnica, arquitectura, decisiones de diseño y preguntas clave de sustentación para la **Sesión 18 (Persistencia con JDBC y MySQL)**.

---

## 📌 1. Visión General de la Sesión

### ¿Cuál es el objetivo principal?
Aprender a conectar una aplicación Java a una base de datos relacional (**MySQL**) mediante **JDBC** (*Java Database Connectivity*), evolucionando desde un código monolítico directo hasta una **arquitectura por capas desacoplada** usando los patrones **MVC** (*Modelo - Vista - Controlador*) y **DAO** (*Data Access Object*).

---

## 🛠️ 2. Demo 00: JDBC Básico (CRUD de Usuarios)

### 🎯 Planteamiento y Problema
Se necesita una aplicación de consola para gestionar usuarios (`id`, `nombre`, `correo`) en MySQL. El reto didáctico del profesor era comparar **dos formas de incorporar el driver `Connector/J`**:
1. **Demo00-1 (Manual)**: Añadiendo el archivo binario `.jar` manualmente al módulo de IntelliJ.
2. **Demo00-2 (Maven)**: Declarando la dependencia `com.mysql:mysql-connector-j:8.4.0` en el `pom.xml`.

### 💡 Solución y Conceptos Clave
- **El código Java es idéntico**: Lo que cambia es la gestión de dependencias en el *classpath*. Con Maven, la herramienta descarga automáticamente el driver y sus dependencias transitivas sin ensuciar el repositorio con archivos binarios `.jar`.
- **Conexión mediante `DriverManager`**:
  ```java
  Connection conexion = DriverManager.getConnection(URL, DB_USER, DB_PASSWORD);
  if (!conexion.isValid(5)) {
      throw new SQLException("Conexión no válida.");
  }
  ```
- **Uso estricto de `PreparedStatement`**:
  Evita concatenaciones directas (`"SELECT ... WHERE id = " + id`), protegiendo la base de datos contra ataques de **Inyección SQL** y manejando correctamente comillas y tildes.

---

## 🏛️ 3. Demo 01: Introducción a MVC + DAO

### 🎯 Planteamiento y Problema
En el Demo 00, toda la lógica (interfaz de usuario, sentencias SQL, validaciones y conexión) estaba mezclada en un único archivo `Main`. Si mañana se cambia la consola por una página web o por una base de datos PostgreSQL, habría que reescribir todo el código.

### 💡 Solución: Separación de Responsabilidades
Se dividió el sistema en capas:

```
[VistaConsola]        <-- Solo entrada/salida (Scanner, println). NO importa java.sql.
      ↕
[UsuarioController]   <-- Coordina el flujo, valida entradas y captura excepciones.
      ↕
[UsuarioDAO]          <-- Solo consultas SQL y mapeo a objetos. NO conoce la consola.
      ↕ usa
[ConexionFactory]     <-- Genera una Connection limpia por cada operación.
```

- **Modelo (`Usuario.java`)**: Es inmutable y custodia las reglas de negocio (nombre obligatorio ≤ 100 caracteres, correo con `@` ≤ 150 caracteres).
- **`ConexionFactory`**: No guarda una conexión estática global; entrega una nueva conexión limpia en cada llamado para evitar caídas por desconexión (*timeouts*).

---

## 📖 4. Lab 00: Biblioteca (Libros por ISBN)

### 🎯 Planteamiento y Problema
Una biblioteca necesita registrar libros y encontrarlos por su código **ISBN**.
- **Problema 1**: El ISBN no es un número para operar matemáticamente, es un identificador alfanumérico que debe tratarse como `String` (hasta 20 caracteres).
- **Problema 2**: Dos libros no pueden tener el mismo ISBN (`UNIQUE` en MySQL). Si un usuario ingresa un duplicado, la aplicación debe rechazarlo sin colapsar el menú.
- **Problema 3**: Si un libro no existe en una búsqueda, no debe considerarse un fallo de sistema ni una excepción, sino un resultado vacío normal.

### 💡 Cómo lo solucionamos
1. **Configuración de Tabla SQL**:
   ```sql
   CREATE TABLE IF NOT EXISTS libros (
       id INT AUTO_INCREMENT PRIMARY KEY,
       titulo VARCHAR(150) NOT NULL,
       isbn VARCHAR(20) NOT NULL UNIQUE
   );
   ```
2. **Control de duplicados mediante error codes**:
   ```java
   private static void mostrarError(SQLException error) {
       if (error.getErrorCode() == 1062) { // 1062 es el código MySQL para Duplicate Key
           System.out.println("Error: El ISBN ya se encuentra registrado (debe ser unico).");
       } else {
           System.out.println("Operación no completada: " + error.getMessage());
       }
   }
   ```
3. **Búsqueda limpia**:
   Usando `ResultSet.next()`: si devuelve `true`, mostramos el libro; si devuelve `false`, imprimimos `"Sin resultados."`.

---

## 📦 5. Lab 01: Inventario (MVC + DAO)

### 🎯 Planteamiento y Problema
Una tienda necesita registrar productos (`id`, `nombre`, `stock`) y modificar su stock:
- **Problema 1**: El stock nunca puede ser negativo. Debe validarse tanto en Java como en MySQL (`CHECK (stock >= 0)`).
- **Problema 2**: La actualización de stock debe hacerse por `id` y no por nombre, porque pueden existir dos productos con el mismo nombre pero diferente lote/código.
- **Problema 3**: Mantener la regla arquitectónica: **la vista no puede importar `java.sql` y el DAO no puede importar `Scanner` ni usar `System.out.println`**.

### 💡 Cómo lo solucionamos
1. **Modelo `Producto.java`**:
   ```java
   public static int validarStock(int stock) {
       if (stock < 0) {
           throw new IllegalArgumentException("El stock no puede ser negativo.");
       }
       return stock;
   }
   ```
   Si el usuario intenta ingresar un stock de `-1`, Java lo frena antes de enviar la consulta al motor de base de datos.

2. **DAO (`ProductoDAO.java`)**:
   Implementa `actualizarStock(int id, int stock)` devolviendo el número de filas afectadas (`executeUpdate()`):
   - Si devuelve `0`: El controlador informa `"Sin coincidencias para ese id."`.
   - Si devuelve `1`: El controlador informa `"Filas afectadas: 1"`.

3. **Ciclo de vida de conexiones**:
   Cada método del DAO usa `try-with-resources`:
   ```java
   try (Connection conexion = conexiones.abrir();
        PreparedStatement sentencia = conexion.prepareStatement(...)) { ... }
   ```
   Esto asegura que la conexión se cierre inmediatamente después de ejecutar la consulta, liberando memoria y recursos en el servidor MySQL.

---

## 🎤 6. Banco de Preguntas Típicas para la Sustentación

### P1: ¿Por qué usamos `PreparedStatement` en lugar de `Statement`?
> **Respuesta:**  
> Por dos razones principales:  
> 1. **Seguridad**: `PreparedStatement` precompila la consulta en la base de datos y envía los parámetros por separado, eliminando el riesgo de **Inyección SQL**.  
> 2. **Tipado y formato**: Gestiona automáticamente caracteres conflictivos como comillas simples (`'`), apóstrofes o tildes (como en *"Cien años de soledad"*), evitando errores de sintaxis SQL.

---

### P2: ¿Por qué cerramos las conexiones con `try-with-resources`?
> **Respuesta:**  
> Porque las interfaces `Connection`, `PreparedStatement` y `ResultSet` implementan `AutoCloseable`. El bloque `try-with-resources` garantiza que, ocurra o no una excepción, los recursos del socket TCP y cursores en MySQL se liberen automáticamente sin necesidad de bloques `finally` repetitivos.

---

### P3: ¿Por qué en el patrón MVC la Vista no debe importar `java.sql`?
> **Respuesta:**  
> Para mantener el **Bajo Acoplamiento**. La responsabilidad de la vista es únicamente interactuar con el usuario (interfaz gráfica o consola). Si la vista supiera de SQL, cambiar el motor de base de datos o migrar a una API REST rompería la vista.

---

### P4: ¿Por qué el DAO no debe tener `System.out.println` ni `Scanner`?
> **Respuesta:**  
> Por el principio de **Responsabilidad Única**. El DAO solo debe preocuparse por la persistencia de datos (comunicarse con MySQL). Si imprime en consola, ese DAO no podría reutilizarse en una aplicación web, móvil o servicio backend. Los errores deben propagarse al controlador mediante `SQLException`.

---

### P5: ¿Qué diferencia hay entre `executeUpdate()` y `executeQuery()`?
> **Respuesta:**  
> - `executeQuery()` se usa para consultas de lectura (`SELECT`) y retorna un objeto `ResultSet` con los registros encontrados.  
> - `executeUpdate()` se usa para sentencias de manipulación (`INSERT`, `UPDATE`, `DELETE`) o definición (`DDL`) y retorna un número entero (`int`) que representa la cantidad de filas afectadas en la base de datos.
