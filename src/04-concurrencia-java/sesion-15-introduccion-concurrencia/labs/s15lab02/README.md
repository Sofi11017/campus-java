# Lab 02 · Certificados con Thread y Executor · 10 minutos

Debes preparar certificados de Ana, Luis y Sara. El código está completo; observarás cómo se asigna cada tarea y cambiarás el tamaño del pool.

## Pasos para completar la actividad

1. Abre [S15Lab02ThreadExecutorMain.java](S15Lab02ThreadExecutorMain.java) y [PrepararCertificado.java](PrepararCertificado.java). Predice cuántas tareas se ejecutarán en cada bloque: hay tres nombres y los dos bloques procesan los mismos tres.
2. Ejecuta **Run → S15Lab02ThreadExecutorMain**. En el primer bloque, comprueba que cada nombre aparece una vez y que usa un hilo manual distinto: manual-1, manual-2 y manual-3.
3. En el segundo bloque, comprueba que los tres nombres aparecen una vez, atendidos por como máximo dos trabajadores del pool. Anota qué nombres comparten trabajador en tu ejecución. No necesitas obtener un reparto específico.
4. Localiza `Executors.newFixedThreadPool(2)` dentro de ejecutarConExecutor y cambia únicamente 2 por 1. Antes de ejecutar, predice si se perderá algún certificado.
5. Ejecuta otra vez: el bloque manual conserva tres hilos; el bloque Executor procesa los tres certificados con un único trabajador. El orden de las impresiones manuales puede variar. Guarda esa salida.
6. Coloca un breakpoint en run. Ejecuta en Debug y observa el nombre del hilo actual. Sigue la llamada a submit y distingue crear la tarea de crear un hilo.
7. En tu README personal responde en dos frases: ¿por qué tres tareas no necesitan tres trabajadores del pool? ¿Por qué shutdown no significa que ya terminaron todas las tareas? Identifica Future.get y awaitTermination como las esperas usadas en este programa.

## Salida posible con el pool inicial de 2

```text
=== Thread: un hilo nuevo por tarea ===
Ana atendido por manual-1
Luis atendido por manual-2
Sara atendido por manual-3
=== Executor: pool de 2 hilos ===
Ana atendido por pool-1-thread-1
Luis atendido por pool-1-thread-2
Sara atendido por pool-1-thread-1
Fin: todas las tareas terminaron
```

Con el cambio a 1, las tres líneas del bloque Executor deben mencionar el mismo trabajador. La etiqueta del encabezado debe actualizarse también a pool de 1 hilo. No cambies el arreglo de nombres, las esperas ni el cierre del ejecutor.

**No se exige copiar el orden de esta salida.** Comprueba cada certificado y los nombres de los trabajadores, no tiempos exactos ni cuál tarea termina primero.

[Ver la comparación explicada](../../demo/s15demo02/README.md)
