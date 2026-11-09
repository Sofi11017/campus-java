# Demo 01 · Usuarios con MVC + DAO · 25 minutos

**Problema:** cambiar mensajes y consultas obliga a recorrer una clase que mezcla responsabilidades. Conservaremos la misma tabla y el mismo CRUD del demo00 y distribuiremos el trabajo.

## Preparar y ejecutar

1. Completa la [preparación de MySQL e IntelliJ](../../README.md#preparación-anterior-a-clase).
2. Abre el POM de la sesión, sincroniza Maven y selecciona este módulo en la configuración Run del Main.
3. En el cliente MySQL, ejecuta el siguiente bloque. Las semillas son opcionales: puedes omitir los INSERT para comenzar con la tabla vacía.

```sql
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
```

El mismo contenido está en [preparar.sql](preparar.sql). `IF NOT EXISTS` no modifica una tabla antigua: si las columnas no coinciden, comprueba `SHOW CREATE TABLE usuarios;` y consulta al docente. No borres la tabla para reiniciar. La carga opcional evita repetir estas semillas en una preparación local secuencial; no es una solución para inserciones concurrentes. Los id los asigna MySQL y pueden tener saltos.

4. **Si hiciste demo00, conserva sus datos.** No necesitas repetir las semillas; ambos diseños usan la misma tabla.
5. Ejecuta [S18Demo01UsuariosMain](src/main/java/s18demo01/S18Demo01UsuariosMain.java) con las mismas variables de entorno. Aquí cada operación abre/cierra su conexión; el menú puede abrirse antes de conectar.

## Maven · ciclo de vida y comandos de esta práctica

En **Maven → Lifecycle**, haz doble clic en una fase para ejecutarla. Desde Terminal, sitúate en **s18demo01**, donde está su pom.xml, y usa los comandos de la tabla. Si ejecutas desde el POM de sesión, se procesan los dos módulos.

| Comando | Qué hace | Cuándo usarlo |
| --- | --- | --- |
| `mvn validate` | Comprueba la información básica del proyecto/POM; no demuestra que Java compile. | Revisar la configuración inicial. |
| `mvn compile` | Compila fuentes principales en target/classes. | Comprobar sintaxis y tipos tras editar código. |
| `mvn test` | Compila y ejecuta las pruebas automatizadas configuradas. | Cuando el proyecto tenga pruebas; no prueba MySQL por sí solo. |
| `mvn package` | Empaqueta el código compilado en un JAR dentro de target. | Obtener el artefacto del proyecto. |
| `mvn verify` | Llega hasta las verificaciones configuradas, después de empaquetar. | Comprobar la construcción y controles disponibles. |
| `mvn install` | Guarda el JAR y su POM en el repositorio Maven local, normalmente ~/.m2/repository. | Permitir que otro proyecto local lo use como dependencia. |
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

Primero elimina target; después recorre el ciclo default hasta install: compila, ejecuta las pruebas existentes, empaqueta, aplica las verificaciones configuradas y guarda el artefacto en el repositorio local.

Es útil para reconstruir y dejar una biblioteca disponible a otros proyectos locales. **No es necesario para ejecutar este demo**, cuyos ejemplos no dependen entre sí. No instala MySQL ni la aplicación en Windows, y clean no borra la base de datos ni el repositorio ~/.m2.

### Qué usar ahora

1. Cambiaste el POM: **Reload All Maven Projects** para sincronizar dependencias en IntelliJ.
2. Cambiaste Java y quieres comprobar compilación: `mvn compile`.
3. Quieres reconstruir el JAR sin resultados previos: `mvn clean package`.
4. Quieres usar el CRUD: **Run → S18Demo01UsuariosMain**.

Reload sincroniza el modelo y las dependencias; no sustituye ejecutar el programa. Ninguno de los comandos anteriores ejecuta nuestro main. El JAR generado tampoco incluye automáticamente Connector/J ni queda configurado como ejecutable: para esta clase usamos Run, que proporciona el classpath del módulo.

Referencia: [ciclo de vida de Apache Maven](https://maven.apache.org/guides/introduction/introduction-to-the-lifecycle.html).

## Orden de lectura y comprobación

1. **Main:** crea vista, DAO y controlador. Solo ensambla; no contiene SQL.
2. **Usuario:** identifica id, nombre y correo. Constructor y `validarNombre` protegen datos básicos; no importan JDBC ni Scanner.
3. **VistaConsola:** muestra el menú y lee texto. Cambia un mensaje: no debes tocar el DAO.
4. **UsuarioController:** sigue la opción 1; obtiene datos de la vista, crea Usuario y pide al DAO registrarlo.
5. **UsuarioDAO:** sigue `registrar`: abre conexión, prepara INSERT, asigna parámetros y devuelve filas afectadas. No imprime resultados.
6. **ConexionFactory:** obtiene credenciales externas y entrega una conexión nueva. No guarda una conexión global ni devuelve null cuando falla.
7. Ejecuta **1 Registrar** con `Elena Demo MVC` / `elena.mvc@example.com`; comprueba `Filas insertadas: 1`. Con **2 Listar**, anota su id real.
8. Elige **3**, escribe ese id y `Elena Actualizada`; lista para verificarlo. Elige **4** y confirma `SI`; verifica que desapareció.
9. Repite una inserción con un correo existente, prueba id inexistente y nombre vacío. El controlador pide a la vista mostrar el error o ausencia; no inventa un resultado exitoso.

```sql
SELECT id, nombre, correo FROM usuarios ORDER BY id;
SELECT id, nombre, correo FROM usuarios WHERE correo = 'elena.mvc@example.com';
```

En Debug, sigue registrar desde controlador hasta DAO; usa Step Into para ver el cambio de responsabilidad. El ResultSet se transforma en `List<Usuario>` dentro del DAO y se cierra antes de entregar la lista.

| Cambio | Componente principal |
| --- | --- |
| Texto mostrado | VistaConsola |
| Regla de nombre obligatorio | Usuario |
| Acción del menú | UsuarioController |
| Consulta SQL | UsuarioDAO |
| Apertura de conexión | ConexionFactory |

El DAO concreto complementa MVC; no es una cuarta parte del nombre MVC. Para este caso no necesitamos Service, interfaces adicionales ni frameworks. Comparado con demo00, mantenemos comportamiento y tabla; cambiamos la distribución del código.

## UML

Las seis clases propias están representadas. Las relaciones muestran colaboración, sin atribuir propiedad exclusiva de ciclo de vida.

```mermaid
classDiagram
class S18Demo01UsuariosMain {
    +main(String[] args)$ void
}
class Usuario {
    -int id
    -String nombre
    -String correo
    +getId() int
    +getNombre() String
    +getCorreo() String
    +validarNombre(String nombre)$ String
}
class VistaConsola {
    +pedirOpcion() String
    +leerTexto(String etiqueta) String
    +leerEntero(String etiqueta) int
    +mostrar(String mensaje) void
    +mostrarListado(List elementos) void
}
class UsuarioController {
    +iniciar() void
}
class UsuarioDAO {
    +registrar(Usuario elemento) int
    +listar() List
    +actualizarNombre(int id, String nombre) int
    +eliminar(int id) int
}
class ConexionFactory {
    +abrir() Connection
}
S18Demo01UsuariosMain ..> UsuarioController : ensambla
S18Demo01UsuariosMain ..> VistaConsola : crea
S18Demo01UsuariosMain ..> UsuarioDAO : crea
S18Demo01UsuariosMain ..> ConexionFactory : crea
UsuarioController --> VistaConsola : pide y muestra
UsuarioController --> UsuarioDAO : coordina
UsuarioController ..> Usuario : valida
VistaConsola ..> Usuario : muestra lista
UsuarioDAO --> ConexionFactory : abre conexiones
UsuarioDAO ..> Usuario : guarda y reconstruye
```

[Volver a la sesión](../../README.md)
