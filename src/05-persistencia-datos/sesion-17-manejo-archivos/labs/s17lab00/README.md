# Lab 00 · Biblioteca · 12 minutos

Trabaja en tu copia personal. El Main está completo salvo los TODO indicados. Cada ejercicio usa su propia carpeta de datos, cuya ruta se imprime al ejecutar.

## Pasos para completar

1. Abre S17Lab00BibliotecaMain.java. Ejecuta sin modificar: debe mostrar PENDIENTE; no se afirma que creó el archivo.
2. En preparar, completa **TODO 1** creando carpeta y padres con Files.createDirectories sobre la variable carpeta ya calculada.
3. En **TODO 2**, dentro del try ya proporcionado, crea la ruta archivo con Files.createFile. Conserva el catch: si el archivo existe, no lo vacía; si la ruta es un directorio, informa el conflicto.
4. Ejecuta: debe mostrar Seccion preparada:infantil. Abre la ruta Datos y comprueba infantil/inventario.txt.
5. Escribe manualmente Libro de prueba dentro de ese archivo y vuelve a ejecutar: el contenido debe permanecer.
6. Cambia solo String seccion de infantil a ciencia. Ejecuta y verifica que existen ambas secciones y que infantil conserva su texto.
7. Guarda las rutas y una frase: ¿por qué resolve no crea un archivo? En Debug observa carpeta antes de crearla. No uses secciones distintas de infantil/ciencia/arte.

## Resultado tras completar los TODO

```text
Seccion preparada: infantil
```

Si ya existía historial, los valores dependen de ese contenido; usa una carpeta nueva para comprobar la primera ejecución.

[Abrir el Main](S17Lab00BibliotecaMain.java) · [Volver a la sesión](../../README.md)
