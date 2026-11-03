# Sesión 15 · Introducción a la concurrencia

Una aplicación puede avanzar con varias tareas durante el mismo período. Eso es **concurrencia**; no implica que se ejecuten al mismo instante. **Paralelismo** significa ejecución simultánea real.

Un proceso tiene recursos y memoria propios; los hilos son flujos de ejecución dentro de ese proceso. Runnable describe **qué hacer**; Thread y ExecutorService permiten organizar **dónde se ejecuta**.

## Ruta de clase · 60 minutos en total

| Orden | Actividad | Tiempo |
| --- | --- | ---: |
| 1 | Conceptos iniciales | 3 min |
| 2 | [Demo 00: iniciar y esperar hilos](demo/s15demo00/README.md) | 10 min |
| 3 | [Lab 00: biblioteca digital](labs/s15lab00/README.md) | 6 min |
| 4 | [Demo 01: cancelar una consulta](demo/s15demo01/README.md) | 8 min |
| 5 | [Lab 01: disponibilidad de citas](labs/s15lab01/README.md) | 8 min |
| 6 | [Demo 02: biblioteca de Thread a Executor](demo/s15demo02/README.md) | 8 min |
| 7 | [Lab 02: certificados y tamaño del pool](labs/s15lab02/README.md) | 10 min |
| 8 | Comparación final | 3 min |
| 9 | Preguntas e imprevistos | 4 min |
| | **Total** | **60 min** |

El Demo 02 retoma la biblioteca del Lab 00: mantiene tareas Runnable y compara un hilo por tarea con un pool fijo de dos trabajadores. El Lab 02 practica con otro caso.

Los labs tienen código completo. Haz la ejecución y el cambio indicado; guarda una salida y una explicación breve. Completa en casa lo pendiente. Repeticiones extensas y Debug adicional quedan para casa.

## Ejecutar en IntelliJ IDEA

1. Usa JDK 17 o 21 y conserva el paquete de cada ejemplo con sus clases.
2. Abre el Main enlazado en cada guía y selecciona **Run → nombre del Main**.
3. Las carpetas demo y labs son raíces de código fuente; las carpetas organizativas con guiones no son paquetes Java.
4. Cada demo incluye su diagrama UML Mermaid, orden de lectura, resultados observables y límites. Los programas no usan servicios reales ni generan archivos.

## Qué debes distinguir

| Operación | Qué hace | Qué no garantiza |
| --- | --- | --- |
| tarea.run() | Llama a un método en el hilo actual | Crear un hilo nuevo |
| hilo.start() | Inicia el hilo y programa su run | Ejecutarse antes que otro trabajador |
| Thread.sleep(...) | Pausa el hilo actual | Coordinar tareas o medir tiempo exacto |
| hilo.interrupt() | Solicita interrupción cooperativa | Terminar por la fuerza o revertir trabajo |
| hilo.join() | Espera la terminación de ese hilo | Éxito de su tarea |
| executor.submit(tarea) | Entrega trabajo al servicio y devuelve un Future | Un hilo nuevo por cada tarea |
| future.get() | Espera la tarea y permite conocer su fallo | Éxito sin comprobar la excepción |
| executor.shutdown() | Deja de aceptar trabajo y permite terminar lo enviado | Esperar por sí solo a que todo termine |

**Estados:** NEW se observa antes de start y TERMINATED después de join. RUNNABLE incluye ejecutable y ejecutándose; WAITING/TIMED_WAITING y BLOCKED describen esperas distintas. Una lectura de estado durante la ejecución es una instantánea, no una garantía del orden.

## Cierre

- ¿Qué cambió entre el lab de biblioteca y el demo con Executor? La administración de la ejecución; las tareas siguen implementando Runnable.
- ¿Por qué un pool de dos hilos puede procesar tres tareas? Reutiliza trabajadores y deja pendientes las tareas que todavía no pueden ejecutarse.
- ¿Por qué dos salidas distintas pueden ser correctas? La planificación puede intercalar tareas; validamos los resultados y las relaciones de orden que sí garantiza el código.

No se mide aceleración. No se usa prioridad para forzar orden, Thread.stop, espera activa, lambdas, sincronización manual ni APIs preview. Hilos virtuales quedan como referencia conceptual para muchas esperas de entrada/salida en Java 21; no son necesarios para esta práctica. Recursos compartidos y operaciones atómicas se trabajarán en la sesión siguiente.
