# Lab 00 · JDBC básico · Biblioteca · Clase: 30 minutos

**Problema:** una biblioteca necesita registrar libros y encontrarlos por ISBN sin perder los datos al cerrar el programa.

Debes crear tu propia aplicación Java de consola. **Esta carpeta contiene solo el planteamiento: no hay código inicial, TODO ni POM preparado.** Usa Maven para Connector/J; consulta el demo00-2 como referencia y trabaja en tu repositorio personal.

## Preparación SQL

Con la base y el usuario de práctica de la [sesión](../../README.md#preparación-anterior-a-clase) ya preparados, ejecuta con la cuenta administrativa:

```sql
USE campus_java_s18;
CREATE TABLE IF NOT EXISTS libros (
    id INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(150) NOT NULL,
    isbn VARCHAR(20) NOT NULL UNIQUE
);

-- Semilla opcional: permite consultar antes de registrar desde Java.
INSERT INTO libros (titulo, isbn)
SELECT 'Don Quijote de la Mancha', '9788420412146'
WHERE NOT EXISTS (SELECT 1 FROM libros WHERE isbn = '9788420412146');

SELECT id, titulo, isbn FROM libros ORDER BY id;
```

Puedes omitir el INSERT para empezar sin libros. Repetir esta carga local no duplica la semilla; no es una garantía frente a inserciones concurrentes. IF NOT EXISTS no corrige una tabla antigua: consulta SHOW CREATE TABLE libros si hay diferencias; no borres los datos.

## Qué debes hacer

1. **Proyecto y conexión · 5 min.** Crea un proyecto Maven personal con JDK 17/21, incorpora Connector/J como en demo00-2 y crea una clase con main. Configura DB_URL, DB_USER y DB_PASSWORD en Run. Abre una conexión con DriverManager y comprueba isValid(5).
2. **Registro · 8 min.** Crea un método para registrar título e ISBN. Rechaza textos vacíos; título admite hasta 150 caracteres e ISBN hasta 20. Prepara INSERT con dos parámetros; asigna ambos con setString y usa executeUpdate. Informa las filas insertadas. El ISBN es texto, no un número para calcular.
3. Desde el menú registra **El principito / 9780156012195** y **Cien años de soledad / 9780307474728**. Cada operación debe insertar una fila. Estos dos registros se crean desde Java, no con el bloque SQL anterior.
4. **Listado · 6 min.** Añade una opción que consulte id, titulo e isbn, ordenados por id. Recorre ResultSet con next y muestra una línea por libro: `id | titulo | isbn`. Si no hay filas, muestra `Sin libros.`. No escribas el listado como texto fijo.
5. **Búsqueda · 7 min.** Añade una opción que pida ISBN y consulte mediante `WHERE isbn = ?`. Con 9780156012195 debe mostrar El principito; con 0000000000000 debe mostrar `Sin resultados.`, sin tratarlo como una excepción.
6. **Verificación · 4 min.** Sal, ejecuta otra vez y lista: ambos libros deben permanecer. Confirma los datos en MySQL con las consultas siguientes. Conserva los id realmente asignados; no tienen que empezar en 1.

```sql
SELECT id, titulo, isbn FROM libros ORDER BY id;
SELECT id, titulo, isbn FROM libros WHERE isbn = '9780156012195';
```

Organiza un menú sencillo: registrar, listar, buscar ISBN y salir. Puedes mantener una clase con métodos pequeños; **no se requiere MVC en este lab**. Usa PreparedStatement y try-with-resources para Connection, sentencias y resultados. Si reutilizas la conexión en el menú, ciérrala al salir, no dentro de cada método. Captura SQLException donde puedas informar el fallo; no anuncies éxito si una operación falla.

## Criterios de comprobación

- Los registros se guardan en MySQL y se recuperan después de reiniciar.
- El listado conserva la ñ de Cien años de soledad. Si cargaste la semilla habrá un libro adicional.
- Un ISBN inexistente produce un mensaje normal de ausencia.
- Un ISBN duplicado es rechazado por UNIQUE y se informa el error sin detener innecesariamente el menú.
- No se concatena la entrada del usuario al SQL y se cierran los recursos.

Entrega el proyecto en tu repositorio y una breve evidencia de registro, listado y búsqueda. Si ya existían esos ISBN, no los insertes otra vez para comprobar persistencia; utiliza otro ISBN ficticio para una nueva prueba de registro.

**Pistas:** los parámetros comienzan en 1; executeUpdate devuelve un entero y executeQuery un ResultSet; el cursor empieza antes de la primera fila. Completa en casa lo pendiente. Como ampliación, prueba un título con apóstrofo y explica la diferencia entre búsqueda vacía y fallo JDBC.

[Volver a la sesión](../../README.md)
