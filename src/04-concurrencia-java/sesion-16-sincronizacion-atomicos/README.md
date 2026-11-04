# Sesión 16 · Sincronización, visibilidad y operaciones atómicas

Varios hilos pueden ejecutar tareas correctamente por separado y, aun así, dañar un dato compartido. En esta sesión identificarás **qué se comparte, qué regla debe conservarse y qué mecanismo la protege**.

## Ruta de clase · 120 minutos

| Actividad | Tiempo |
| --- | ---: |
| Identificar recurso compartido, intercalación y sección crítica | 8 min |
| [Demo 00 · Inventario progresivo con synchronized](demo/s16demo00/README.md) | 28 min |
| [Lab 00 · Reservas de taller](labs/s16lab00/README.md) | 20 min |
| [Demo 01 · Señal de parada volatile](demo/s16demo01/README.md) | 12 min |
| [Lab 01 · Sensor simulado](labs/s16lab01/README.md) | 10 min |
| [Demo 02 · volatile int frente a AtomicInteger](demo/s16demo02/README.md) | 15 min |
| [Lab 02 · Mensajes procesados](labs/s16lab02/README.md) | 15 min |
| Cierre: elegir el mecanismo y justificarlo | 7 min |
| Preguntas e imprevistos | 5 min |
| **Total** | **120 min** |

El Demo 00 se explica en tres ejemplos separados: [00-1: inventario progresivo](demo/s16demo00/demo00_1/S16Demo00InventarioMain.java), [00-2: monitores distintos](demo/s16demo00/demo00_2/S16Demo00MonitoresMain.java) y [00-3: static synchronized](demo/s16demo00/demo00_3/S16Demo00StaticMain.java). Su README reúne los tres diagramas y el orden de lectura.

Los labs tienen código completo y cambios acotados. Completa en casa lo pendiente. No necesitas desarrollar tres aplicaciones desde cero.

## Ejecutar

Usa IntelliJ IDEA con JDK 17 o 21. Conserva el paquete y sus clases; demo y labs son raíces de código fuente. Abre el Main indicado en cada guía y selecciona **Run → nombre del Main**. Los apoyos de inicio y comprobación están preparados; no son un ejercicio nuevo de APIs de coordinación.

Cada demo tiene su propio README con UML Mermaid, orden de lectura, resultados y límites. Los programas trabajan en memoria; no usan frameworks, lambdas, archivos ni servicios externos.

## Cuatro conceptos del inventario

- **Recurso compartido:** el mismo objeto inventario al que acceden todos los vendedores.
- **Sección crítica:** comprobar que hay existencias y descontar una unidad como operación completa.
- **Monitor:** bloqueo intrínseco asociado a un objeto; synchronized adquiere ese monitor antes de entrar.
- **Exclusión mutua:** mientras un hilo posee un monitor, otro no puede entrar a una sección que requiera ese mismo monitor.

El monitor no bloquea automáticamente todas las instrucciones que usan una variable. Un acceso que lo evita queda fuera de esa coordinación.

## Qué mecanismo elegir

| Problema | Herramienta | Límite |
| --- | --- | --- |
| Comprobar cupo y descontarlo juntos | synchronized | Todos los accesos dependientes deben coordinarse con el mismo monitor |
| Comunicar una petición simple de parada | volatile boolean | No despierta por sí solo un hilo bloqueado ni hace atómico ++ |
| Incrementar un contador compartido | AtomicInteger.incrementAndGet | No vuelve atómicas varias llamadas separadas o toda una regla de negocio |
| Leer el resultado final de un trabajador | join | Espera terminación y permite observar su resultado; no evita carreras durante el trabajo |

**Método synchronized de instancia:** usa this. **Bloque con monitor privado:** usa el objeto indicado. **Método static synchronized:** usa el objeto Class de esa clase. No son monitores intercambiables.

## Cómo interpretar las pruebas

Las versiones correctas verifican resultados e invariantes. Una ejecución sin protección que coincide con lo esperado **no demuestra seguridad**. No se exige ver un error espontáneo en cada intento ni obtener un orden fijo de mensajes.

Los ejemplos dirigidos fuerzan dos lecturas antes de escribir para reproducir una actualización perdida. Están identificados y separados de las pruebas naturales. No se usa sleep para coordinar, no se mide velocidad y no se promete que más hilos sean más rápidos.

> synchronized no protege mágicamente una variable. Coordina la ejecución de los hilos que utilizan el mismo monitor.
