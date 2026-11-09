# Demo00-2 · JDBC básico con Maven

Este proyecto ejecuta el CRUD de usuarios. Sigue la [guía completa del demo00](../README.md) para preparar SQL, conexión y recorrer el código; aquí tienes los comandos Maven del proyecto.

Abre este pom.xml en IntelliJ, recarga Maven y ejecuta s18demo00.S18Demo00UsuariosMain. No agregues el JAR de Connector/J manualmente.

## Maven · ciclo de vida y comandos de esta práctica

En **Maven → Lifecycle**, haz doble clic en una fase para ejecutarla. Desde Terminal, sitúate en **demo00-2**, donde está su pom.xml, y usa los comandos de la tabla. Si ejecutas desde el POM de sesión, se procesan los dos módulos.

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
4. Quieres usar el CRUD: **Run → S18Demo00UsuariosMain**.

Reload sincroniza el modelo y las dependencias; no sustituye ejecutar el programa. Ninguno de los comandos anteriores ejecuta nuestro main. El JAR generado tampoco incluye automáticamente Connector/J ni queda configurado como ejecutable: para esta clase usamos Run, que proporciona el classpath del módulo.

Referencia: [ciclo de vida de Apache Maven](https://maven.apache.org/guides/introduction/introduction-to-the-lifecycle.html).
