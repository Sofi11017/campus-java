# Sesión 18 · JDBC: de la conexión a MVC + DAO

**Meta:** guardar y consultar datos reales en MySQL; después separar presentación, coordinación y persistencia sin cambiar el caso de usuarios.

| Orden | Actividad | Tiempo |
| --- | --- | ---: |
| 1 | [Demo00 · JDBC básico: JAR manual y Maven](demo/s18demo00/README.md) | 30 min |
| 2 | [Lab00 · JDBC básico: biblioteca](labs/s18lab00/README.md) | 30 min |
| 3 | [Demo01 · MVC + DAO: usuarios](demo/s18demo01/README.md) | 25 min |
| 4 | [Lab01 · MVC + DAO: inventario](labs/s18lab01/README.md) | 30 min |
| 5 | Verificación y cierre | 5 min |
| | **Total** | **120 min** |

Los entornos se preparan antes de clase. Demo00-1 y demo00-2 contienen el mismo CRUD JDBC; solo cambia la incorporación del driver. Los dos labs suman 60 minutos y contienen únicamente el planteamiento: cada estudiante crea su proyecto y código. Completa en casa lo pendiente.

## Preparación anterior a clase

### 1. MySQL: crear base y usuario

Usaremos MySQL 8.0.16 o posterior (preferentemente 8.4 para esta práctica), JDK 17/21 y Connector/J 8.4.0 fijado en los POM. Verifica compatibilidad si tu instalación es distinta. Necesitas MySQL Server en ejecución y un cliente como MySQL Workbench; Maven **no instala** MySQL.

Con una cuenta administrativa, ejecuta en el editor SQL de tu cliente el siguiente bloque. **Antes de ejecutarlo, sustituye el marcador de contraseña por una clave local**. No guardes esa clave en el repositorio. Estos son datos de una base exclusivamente de práctica.

```sql
SELECT VERSION();
CREATE DATABASE IF NOT EXISTS campus_java_s18 CHARACTER SET utf8mb4;
USE campus_java_s18;

-- Solo el docente/administrador: reemplazar el marcador por una clave local.
-- Si el usuario ya existe, IF NOT EXISTS conserva su clave previa.
CREATE USER IF NOT EXISTS 'app_campus_s18'@'localhost'
    IDENTIFIED BY 'REEMPLAZA_POR_TU_CLAVE_LOCAL';
GRANT SELECT, INSERT, UPDATE, DELETE ON campus_java_s18.*
    TO 'app_campus_s18'@'localhost';

SELECT DATABASE();
```

La cuenta administrativa crea también las tablas con los bloques de cada README; Java se ejecuta con `app_campus_s18`, que solo puede manipular registros. Si el usuario ya existía, utiliza su clave vigente: este bloque no la cambia. No necesitas FLUSH PRIVILEGES después de CREATE USER/GRANT.

**Orden:** base y usuario → tablas/semillas de cada ejercicio con cuenta administrativa → aplicación Java con cuenta limitada. Las sentencias no borran ni reemplazan tablas/datos existentes. Si tu servidor no es local, el docente debe proporcionar host y cuenta adecuados; no amplíes permisos a cualquier servidor por tu cuenta.

### 2. Abrir Maven en IntelliJ

1. Abre [pom.xml](pom.xml) de **esta sesión** como proyecto Maven. No conviertas toda la raíz campus-java a Maven.
2. Selecciona JDK 17 o 21 en Project SDK y en el importador/runner de Maven. Espera la sincronización; la primera descarga de dependencias y plugins necesita Internet.
3. En Maven usa **Reload All Maven Projects**. El agregador incluye únicamente demo00-2 (JDBC con Maven) y demo01 (MVC). Demo01 hereda la configuración del padre; demo00-2 conserva su POM autónomo. Ambos fijan Connector/J 8.4.0 y no dependen entre sí.
4. Comprueba Connector/J en External Libraries. Maven reconoce `src/main/java`; no marques las carpetas demo/labs completas como Sources Root.
5. Ejecuta el Main del módulo que corresponde. No copies fuentes entre módulos ni agregues JAR manual a estos módulos.
6. Demo00-1 (JAR manual) se abre como proyecto Java separado. No se incorpora al agregador porque duplica deliberadamente la clase del demo00-2. Los labs no tienen POM ni código inicial: el estudiante los crea en su proyecto personal.

Solo necesitas comprender `dependencies`, coordenadas y versión del driver; no construiremos una arquitectura de Maven durante la clase. En terminal, `mvn compile` compila y **no ejecuta** el menú Java. Para ejecutar usamos Run en IntelliJ. La biblioteca necesaria puede tener dependencias transitivas que Maven también resuelve.

### 3. Variables de conexión en Run

En **Run → Edit Configurations → Environment variables**, configura para cada Main:

| Variable | Valor |
| --- | --- |
| DB_URL | `jdbc:mysql://localhost:3306/campus_java_s18` |
| DB_USER | `app_campus_s18` |
| DB_PASSWORD | La clave local configurada anteriormente |

No son Program arguments ni opciones de la JVM. No publiques la configuración local con contraseñas. Los ejemplos no necesitan rutas de archivos para conectarse ni argumentos main.

## Preparar tablas y datos

Los README incluyen el SQL completo. Los demos tienen preparar.sql equivalente; los labs contienen solo README con su preparación SQL y el problema. Ejecuta sus bloques en el cliente MySQL, después de `USE campus_java_s18;`.

| Tabla | Se usa en | Semillas opcionales | Registro desde Java |
| --- | --- | --- | --- |
| usuarios | Demo00 y demo01 | Ana Torres y Luis Rojas | María / Elena de práctica |
| libros | Lab00 | Don Quijote de la Mancha | El principito y Cien años de soledad |
| productos | Lab01 | Marcador, stock 15 | Cuaderno, stock 10 |

Las semillas permiten consultar desde el inicio y se pueden omitir. Se conservan los datos entre ejecuciones. `IF NOT EXISTS` no migra una tabla antigua: comprueba `SHOW CREATE TABLE nombre_tabla;` si hay diferencias y consulta al docente. Nunca ejecutes DROP/TRUNCATE para seguir la clase.

## Qué debes poder explicar

- Qué hacen Connection, PreparedStatement y ResultSet.
- Por qué los parámetros `?` separan datos de instrucciones SQL.
- Por qué executeUpdate devuelve filas y executeQuery devuelve un cursor.
- Qué diferencia hay entre cero coincidencias y SQLException.
- Quién abre y cierra cada recurso.
- Qué cambia en la vista, modelo, controlador y DAO cuando cambia un requisito.

Las operaciones de esta sesión son sentencias individuales con auto-commit. Una transacción con commit/rollback será necesaria cuando varias modificaciones deban confirmarse como unidad; no se agrega esa complejidad a estos labs.

Fuentes: [JDBC y procesamiento de sentencias](https://docs.oracle.com/javase/tutorial/jdbc/basics/processingsqlstatements.html), [Connector/J 8.4.0](https://dev.mysql.com/doc/relnotes/connector-j/en/news-8-4-0.html).
