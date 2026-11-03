# Lab 00 · Adapter · Duración de citas · 12 minutos

La aplicación consulta minutos, pero una biblioteca existente entrega segundos. Integra los contratos sin modificar el proveedor.

## Pasos para completar la actividad

1. Abre **S13Lab00AdapterMain.java**. El arreglo duracionesSegundos contiene 0, 2700 y 5400 segundos. Anota cuántos minutos esperas para cada valor.
2. Ejecuta **Run → S13Lab00AdapterMain** y compara con la salida de abajo. El caso -1 debe mostrar un rechazo, sin convertir la duración.
3. Abre DuracionCita.java, BibliotecaSegundos.java y AdaptadorDuracion.java, en ese orden. Identifica el contrato en minutos, el proveedor en segundos y la clase que traduce.
4. En el Main, cambia el arreglo a `{0, 2700, 5400, 61}`. Antes de ejecutar, predice si 61 segundos producirá 1 o más de 1 minuto. Ejecuta: debe añadirse `61 s = 1.0166666666666666 min` antes del rechazo.
5. Coloca un breakpoint en consultarMinutos y ejecuta en Debug. Inspecciona el valor de obtenerSegundos y la división entre 60.0. Explica qué se perdería si se dividieran dos enteros entre 60.
6. Guarda la salida y responde en una frase: ¿qué tendría que cambiar el cliente si no existiera el adaptador? ¿Sería necesario si la biblioteca ya devolviera minutos?

## Salida inicial esperada

```text
0 s = 0.0 min
2700 s = 45.0 min
5400 s = 90.0 min
Duracion negativa rechazada
```

[Volver a la sesión](../../README.md) · [Abrir el programa](S13Lab00AdapterMain.java)
