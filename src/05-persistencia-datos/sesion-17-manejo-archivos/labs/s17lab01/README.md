# Lab 01 · Bitacora · 15 minutos

Trabaja en tu copia personal. El Main está completo salvo los TODO indicados. Cada ejercicio usa su propia carpeta de datos, cuya ruta se imprime al ejecutar.

## Pasos para completar

1. Abre S17Lab01BitacoraMain.java y localiza registrar. Sin completar imprime PENDIENTE y no anuncia escritura.
2. En **TODO 1**, abre un BufferedWriter mediante Files.newBufferedWriter para archivo, con StandardCharsets.UTF_8 y opciones StandardOpenOption.CREATE y APPEND. Decláralo en try-with-resources.
3. En **TODO 2**, escribe Revisión eléctrica y después Limpieza de área común. Usa write para cada mensaje y newLine después de cada uno, dentro del bloque.
4. Sustituye el return false por return true **después** del try-with-resources. No pongas true en finally ni ocultes IOException.
5. Ejecuta en una carpeta nueva: Antes:0 y Despues:2. Cierra y vuelve a ejecutar: Antes:2 y Despues:4. Abre mantenimiento.txt y comprueba las cuatro líneas y acentos.
6. Cambia solo Revisión eléctrica por Revisión hidráulica y ejecuta una tercera vez: Despues:6; las primeras cuatro líneas permanecen.
7. Guarda la salida y explica por qué APPEND difiere de truncar. En Debug localiza la ruta y las opciones; no cambies el archivo de destino para la segunda ejecución.

## Resultado tras completar los TODO

```text
Antes: 0
Despues: 2
Revisión eléctrica
Limpieza de área común
```

Si ya existía historial, los valores dependen de ese contenido; usa una carpeta nueva para comprobar la primera ejecución.

[Abrir el Main](S17Lab01BitacoraMain.java) · [Volver a la sesión](../../README.md)
