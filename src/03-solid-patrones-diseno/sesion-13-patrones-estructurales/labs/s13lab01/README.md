# Lab 01 · Facade · Préstamo bibliotecario · 15 minutos

Una biblioteca debe comprobar membresía y disponibilidad antes de registrar el préstamo y emitir un recibo simulado.

## Pasos para completar la actividad

1. Abre **S13Lab01FacadeMain.java**. Cada llamada a ejecutar crea una biblioteca nueva con un único ejemplar. Los argumentos son `disponible, vigente`, en ese orden.
2. Predice las tres situaciones: ejemplar disponible con membresía vigente; ejemplar no disponible; membresía vencida. Ejecuta **Run → S13Lab01FacadeMain** y compara con la salida.
3. Abre PrestamoFacade.java. Sigue prestar: primero verifica membresía, luego reserva el ejemplar y finalmente registra y emite recibo. Identifica qué clase realiza cada tarea.
4. En Debug, coloca un breakpoint en prestar. Ejecuta los tres casos: en los dos rechazados, registrar y emitir no deben ejecutarse. Comprueba los contadores en la consola.
5. Cambia únicamente la tercera llamada `ejecutar(true, false)` por `ejecutar(true, true)`. Predice y ejecuta: las últimas dos líneas deben pasar a `Prestamo registrado` y `Prestamos=1 recibos=1 disponible=false`.
6. Guarda las salidas anterior y nueva. Explica por qué la fachada coordina servicios en lugar de guardar todos sus contadores dentro de sí misma. ¿Aportaría valor si el préstamo requiriera una única operación sencilla?

## Salida inicial esperada

```text
Prestamo registrado
Prestamos=1 recibos=1 disponible=false
Ejemplar no disponible
Prestamos=0 recibos=0 disponible=false
Membresia vencida o ausente
Prestamos=0 recibos=0 disponible=true
```

[Volver a la sesión](../../README.md) · [Abrir el programa](S13Lab01FacadeMain.java)
