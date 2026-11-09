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

## Maven · ciclo de vida y comandos de esta práctica

En **Maven → Lifecycle**, haz doble clic en una fase para ejecutarla. Desde Terminal, sitúate en la carpeta **sesion-18-jdbc**, donde está el POM agregador, y usa los comandos de la tabla. Se procesan demo00-2 y demo01; la versión manual y los labs no forman parte de esta construcción.

| Comando | Qué hace | Cuándo usarlo |
| --- | --- | --- |
| `mvn validate` | Comprueba la información básica del proyecto/POM; no demuestra que Java compile. | Revisar la configuración inicial. |
| `mvn compile` | Compila fuentes principales en target/classes. | Comprobar sintaxis y tipos tras editar código. |
| `mvn test` | Compila y ejecuta las pruebas automatizadas configuradas. | Cuando el proyecto tenga pruebas; no prueba MySQL por sí solo. |
| `mvn package` | Empaqueta cada módulo Java en su target; el agregador de tipo pom no produce JAR. | Obtener el artefacto del proyecto. |
| `mvn verify` | Llega hasta las verificaciones configuradas, después de empaquetar. | Comprobar la construcción y controles disponibles. |
| `mvn install` | Guarda los artefactos de los módulos y sus POM en el repositorio local; el padre instala solo su POM. | Permitir que otro proyecto local lo use como dependencia. |
| `mvn clean` | Elimina los resultados de construcción de target. | Empezar una construcción sin resultados anteriores. |
| `mvn deploy` | Publica el artefacto en un repositorio remoto configurado. | Compartir una biblioteca; no se utiliza en esta práctica. |
| `mvn site` | Genera documentación del proyecto, normalmente HTML en target/site. | Solo si se solicita documentación web; no se utiliza aquí. |

### Las fases se acumulan

Orden simplificado del ciclo **default**:

```text
validate → compile → test → package → verify → install → deploy
```

Hay fases intermedias no mostradas. Al pedir package, Maven recorre también las anteriores: no necesitas ejecutar compile y test por separado antes. Las pruebas y comprobaciones dependen de lo que realmente esté configurado; llegar a verify no inventa pruebas de integración ni comprueba automáticamente el CRUD.

**clean** y **site** pertenecen a ciclos distintos: install no limpia ni genera un sitio HTML automáticamente. Los nombres aparecen juntos en IntelliJ por comodidad, no porque todos pertenezcan a una única secuencia.

### ¿Por qué se utiliza mvn clean install?

```bash
mvn clean install
```

Primero elimina target; después recorre el ciclo default hasta install: compila, ejecuta las pruebas existentes, empaqueta, aplica las verificaciones configuradas y guarda los artefactos de los módulos y el POM padre en el repositorio local.

Es útil para reconstruir y dejar una biblioteca disponible a otros proyectos locales. **No es necesario para ejecutar este demo**, cuyos ejemplos no dependen entre sí. No instala MySQL ni la aplicación en Windows, y clean no borra la base de datos ni el repositorio ~/.m2.

### Qué usar ahora

1. Cambiaste el POM: **Reload All Maven Projects** para sincronizar dependencias en IntelliJ.
2. Cambiaste Java y quieres comprobar compilación: `mvn compile`.
3. Quieres reconstruir el JAR sin resultados previos: `mvn clean package`.
4. Quieres usar el CRUD: **Run del Main del módulo correspondiente**: S18Demo00UsuariosMain o S18Demo01UsuariosMain.

Reload sincroniza el modelo y las dependencias; no sustituye ejecutar el programa. Ninguno de los comandos anteriores ejecuta nuestro main. El JAR generado tampoco incluye automáticamente Connector/J ni queda configurado como ejecutable: para esta clase usamos Run, que proporciona el classpath del módulo.

Referencia: [ciclo de vida de Apache Maven](https://maven.apache.org/guides/introduction/introduction-to-the-lifecycle.html).

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
