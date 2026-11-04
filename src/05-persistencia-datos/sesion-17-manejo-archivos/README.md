# Sesión 17 · Manejo de archivos en Java

Persistir es conservar información para recuperarla en otra ejecución. Usaremos Path/Files, UTF-8 y validación de datos antes de pasar a JDBC.

## Ruta de clase · 120 minutos

| Actividad | Tiempo |
| --- | ---: |
| Memoria frente a persistencia | 5 min |
| [Demo 00: rutas](demo/s17demo00/README.md) | 10 min |
| [Lab 00: biblioteca](labs/s17lab00/README.md) | 12 min |
| [Demo 01: escritura](demo/s17demo01/README.md) | 15 min |
| [Lab 01: bitácora](labs/s17lab01/README.md) | 15 min |
| [Demo 02: lectura y validación](demo/s17demo02/README.md) | 15 min |
| [Lab 02: asistencia](labs/s17lab02/README.md) | 20 min |
| [Demo 03: copiar, mover y eliminar](demo/s17demo03/README.md) | 10 min |
| [Demo 04: elegir formato](demo/s17demo04/README.md) | 8 min |
| Cierre y evidencias | 5 min |
| Preguntas | 5 min |
| **Total** | **120 min** |

## Dónde se guardan los datos

Cada Main imprime **Datos: ruta absoluta**. Por defecto usa una carpeta distinta por ejercicio en java.io.tmpdir/campus-java-s17. Esa carpeta se conserva entre ejecuciones, pero el sistema puede limpiarla: es un espacio didáctico, no almacenamiento de producción.

En IntelliJ, usa Run sobre el Main indicado. Para elegir una carpeta personal, agrega su ruta como primer argumento en **Run → Edit Configurations → Program arguments**; si tiene espacios, escríbela entre comillas. No es un parámetro de la JVM.

Conserva la misma carpeta al probar dos ejecuciones; para empezar desde cero usa otra carpeta de ensayo vacía. No borres archivos personales para reiniciar un ejemplo. Las rutas relativas se resuelven contra el directorio de trabajo del proceso, no contra el .java.

Los demos son independientes y tienen UML con todas sus clases propias. Usa JDK 17 o21; demo y labs son raíces de código fuente. Los labs compilan, pero muestran pendiente o conteos incompletos hasta completar sus TODO.

## Qué comprobar

| Operación | Comprobación |
| --- | --- |
| Crear | Existe y tiene el tipo esperado; representar Path no lo crea |
| Agregar | Conserva contenido anterior y aumenta líneas |
| Leer | Recupera datos de un proceso anterior |
| Interpretar | Rechaza filas inválidas sin detener las válidas |
| Copiar/mover | Conserva el contenido y respeta origen/destino |
| Eliminar | Solo borra el borrador creado por ese programa |

No usamos una base de datos, Streams de colecciones, frameworks o servicios externos. La serialización nativa solo se muestra sobre el archivo propio del demo. No deserialices contenido desconocido.

Completa en casa lo pendiente. Como ampliación opcional puedes diseñar un respaldo de notas y describir qué harías si el destino ya existe, o integrar un historial de soporte; no son laboratorios obligatorios de esta clase.
