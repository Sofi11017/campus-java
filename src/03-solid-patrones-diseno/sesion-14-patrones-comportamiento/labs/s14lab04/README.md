# Lab 04 · State · Reserva de habitación · 12 minutos

El cliente usa operaciones del contexto; no asigna libremente el estado. El método interno cambiarEstado tiene acceso de paquete para los colaboradores de la demostración. Un rechazo no agrega transiciones nuevas ni cambia el estado.

## Pasos para completar la actividad

1. Abre **S14Lab04StateMain.java**. La secuencia permitida es Solicitada → confirmar → Confirmada → ocupar → Ocupada → cerrar → Cerrada.
2. Predice los rechazos de ocupar antes de confirmar, cerrar sin ocupar y cerrar otra vez. Ejecuta **Run → S14Lab04StateMain** y compara con la salida: los rechazos conservan el estado.
3. Lee EstadoReserva.java y las clases Solicitada, Confirmada, Ocupada y Cerrada. Localiza en cada una qué operación puede cambiar el estado; las otras devuelven false.
4. En el Main, reemplaza la línea `System.out.println("Cerrar sin ocupar: " + reserva.cerrar());` por `System.out.println("Ocupar tras confirmar: " + reserva.ocupar());`.
5. Predice y ejecuta: la nueva línea devuelve true y el Estado siguiente es Ocupada. La línea Ocupar que ya existía después devuelve false porque se intenta ocupar otra vez. Cerrar sigue dando true y el estado final es Cerrada.
6. Coloca un breakpoint en ocupar de Reserva y usa Step Into para ver qué clase estado recibe cada intento. Guarda la salida y explica la diferencia de intención entre State y Strategy. ¿Cuándo bastaría un enum?

## Salida inicial esperada

```text
Inicial: Solicitada
Ocupar antes de confirmar: false
Estado: Solicitada
Confirmar: true
Cerrar sin ocupar: false
Estado: Confirmada
Ocupar: true
Cerrar: true
Cerrar otra vez: false
Final: Cerrada
```

[Abrir el programa](S14Lab04StateMain.java) · [Volver a la sesión](../../README.md)
