# Lab 00 · JDBC Básico · Biblioteca · Explicación completa

## 🎯 Situación

Una biblioteca necesita gestionar sus libros (título e ISBN) mediante una aplicación de consola en Java, conectándose a una base de datos relacional MySQL para que los datos persistan después de cerrar el programa.

---

## ❗ El problema

1. **Pérdida de datos en memoria**: Si los libros se guardaran en una lista en memoria (`List<Libro>`), al cerrar la aplicación todos los datos se perderían.
2. **Inyección SQL y errores de sintaxis**: Si concatenamos la entrada del usuario (`"INSERT INTO libros VALUES ('" + titulo + "')"`), cualquier carácter especial (como una comilla simple `'`) rompe la sentencia o abre vulnerabilidades de seguridad (SQL Injection).
3. **Duplicidad de ISBN**: El ISBN debe ser único en el catálogo. Si se intenta registrar un ISBN duplicado, la base de datos debe rechazarlo sin que la aplicación se caiga o termine abruptamente.
4. **Fuga de conexiones y recursos**: No cerrar las conexiones, sentencias o conjuntos de resultados satura el servidor de base de datos.

---

## ✅ La solución

Se implementó una aplicación Java estructurada con JDBC puro:

1. **Uso de `PreparedStatement`**:
   - Se parametriza con `?` en lugar de concatenar cadenas:
   ```java
   String sql = "INSERT INTO libros (titulo, isbn) VALUES (?, ?)";
   try (PreparedStatement sentencia = conexion.prepareStatement(sql)) {
       sentencia.setString(1, titulo);
       sentencia.setString(2, isbn);
       sentencia.executeUpdate();
   }
   ```
   Esto previene inyecciones SQL y maneja caracteres especiales automáticamente (como la `ñ` de *Cien años de soledad*).

2. **Gestión de recursos con `try-with-resources`**:
   - `Connection`, `PreparedStatement` y `ResultSet` se abren dentro de bloques `try (...)`, garantizando su cierre automático al salir.

3. **Manejo controlado de excepciones**:
   - Si se detecta el código de error `1062` de MySQL (violación de clave única por ISBN duplicado), se informa amablemente al usuario sin cerrar el menú:
   ```java
   if (error.getErrorCode() == 1062) {
       System.out.println("Error: El ISBN ya se encuentra registrado (debe ser unico).");
   }
   ```

4. **Búsqueda sin excepciones**:
   - Si un ISBN no existe (`filas.next()` devuelve `false`), se muestra `"Sin resultados."` como un flujo normal de negocio, no como un error técnico.

---

## 📊 Resultados obtenidos

```text
Conexion comprobada a la biblioteca.
1 Registrar | 2 Listar | 3 Buscar ISBN | 0 Salir

-- 1. Registro de libros
Titulo: El principito
ISBN: 9780156012195
Filas insertadas: 1

Titulo: Cien años de soledad
ISBN: 9780307474728
Filas insertadas: 1

-- 2. Listado completo (conserva ñ y semilla)
1 | Don Quijote de la Mancha | 9788420412146
2 | El principito | 9780156012195
3 | Cien años de soledad | 9780307474728

-- 3. Búsqueda por ISBN
ISBN a buscar: 9780156012195
2 | El principito | 9780156012195

ISBN a buscar: 0000000000000
Sin resultados.

-- 4. Rechazo de duplicado
Titulo: Otro Libro
ISBN: 9780156012195
Error: El ISBN ya se encuentra registrado (debe ser unico).
```

---

## 💡 Conclusión para explicar al profesor

> En este laboratorio aplicamos los fundamentos de **JDBC**: cómo cargar el driver Connector/J mediante Maven, abrir una conexión con `DriverManager`, validar su disponibilidad con `isValid()`, y ejecutar operaciones DML y DQL usando siempre `PreparedStatement` para proteger la integridad de los datos frente a inyecciones SQL y caracteres especiales. Además, demostramos cómo manejar el error de clave duplicada (`UNIQUE` en ISBN) a nivel de aplicación sin romper el ciclo del menú.

