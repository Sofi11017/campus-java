# Lab 00 · Biblioteca digital · 6 minutos

La biblioteca debe validar datos del préstamo y preparar un **borrador** de aviso. Son tareas simuladas independientes: preparar el borrador no envía una confirmación ni presupone aprobación.

## Pasos para completar la actividad

1. Abre [S15Lab00BibliotecaMain.java](S15Lab00BibliotecaMain.java) y [TareaBiblioteca.java](TareaBiblioteca.java). El código ya está completo.
2. Antes de ejecutar, predice qué hilo imprimirá Consulta directa: se llama directa.run sin crear un hilo nuevo.
3. Ejecuta **Run → S15Lab00BibliotecaMain**. Comprueba que Consulta directa aparece en main, Validar datos del prestamo en prestamos y Preparar borrador de aviso en avisos. El cierre debe aparecer al final.
4. En tu copia personal, sustituye únicamente `directa.run();` por estas tres líneas:

   ```java
   Thread consulta = new Thread(directa, "consulta");
   consulta.start();
   consulta.join();
   ```

5. Ejecuta otra vez: la primera línea debe cambiar a `Consulta directa atendido por consulta`. Las dos tareas restantes conservan sus hilos y el cierre sigue al final. Guarda la salida.
6. Responde una frase en tu README: ¿por qué join espera algo diferente de sleep? No cambies las dos llamadas join de los trabajadores para producir la salida.

## Una salida inicial posible

```text
Consulta directa atendido por main
Validar datos del prestamo atendido por prestamos
Preparar borrador de aviso atendido por avisos
Fin: tareas de biblioteca terminadas
```

Las dos líneas de los trabajadores pueden intercambiarse. No necesitas repetir hasta conseguir ese orden. La lectura en Debug y las repeticiones adicionales quedan para casa.

Después verás cómo se conserva la tarea Runnable y se cambia la administración de hilos en el [Demo 02](../../demo/s15demo02/README.md).

[Volver a la sesión](../../README.md)
