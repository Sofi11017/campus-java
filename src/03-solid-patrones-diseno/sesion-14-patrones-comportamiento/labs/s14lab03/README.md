# Lab 03 · Command · Préstamos bibliotecarios · 11 minutos

Un libro puede renovarse una sola vez por préstamo. Devolver reinicia esa marca. Las reglas se validan al ejecutar, porque el estado puede cambiar después de crear un comando. El registro contiene resultados por intento, no solo éxitos.

## Pasos para completar la actividad

1. Abre **S14Lab03CommandMain.java**. El libro comienza disponible y sin renovación. Predice cuáles de las cinco acciones serán aceptadas.
2. Ejecuta **Run → S14Lab03CommandMain** y compara con la salida. Renovar sin préstamo y prestar dos veces deben devolver false. El estado final queda disponible.
3. Lee ComandoBiblioteca.java, Prestar.java, Renovar.java, Devolver.java y Libro.java. Identifica quién encapsula la solicitud y quién aplica la regla del préstamo.
4. Antes de devolver el libro en el Main, agrega `System.out.println("Renovar otra vez: " + gestor.ejecutar(new Renovar(libro)));`. Predice y ejecuta: la nueva línea imprime false; el registro final debe ser `[false, true, false, true, false, true]`.
5. Coloca un breakpoint en ejecutar de GestorBiblioteca y usa Step Into para llegar a renovar de Libro. Comprueba que el segundo intento de renovación no cambia el libro.
6. Guarda la salida y explica por qué false se registra como intento rechazado y por qué un comando no ofrece undo automáticamente. ¿Cuándo llamarías al método del libro directamente?

## Salida inicial esperada

```text
Renovar sin prestamo: false
Prestar: true
Prestar otra vez: false
Renovar: true
Devolver: true
Estado: prestado=false, renovado=false
Resultados: [false, true, false, true, true]
```

[Abrir el programa](S14Lab03CommandMain.java) · [Volver a la sesión](../../README.md)
