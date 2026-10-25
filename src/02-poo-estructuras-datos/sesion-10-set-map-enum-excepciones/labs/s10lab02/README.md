# Lab 02 · Prioridad de incidencias

**Tiempo: 13 minutos. Código completo, sin TODO.**

## Archivos

1. [Prioridad.java](Prioridad.java).
2. [Incidencia.java](Incidencia.java).
3. [S10Lab02EnumMain.java](S10Lab02EnumMain.java): ejecuta este Main.

Copia todos los archivos al paquete s10lab02 de tu proyecto personal y ejecuta con JDK 21 o 17.

## Actividad paso a paso

Una incidencia tiene prioridad BAJA, MEDIA o ALTA. Los límites para responder son 120, 60 y 15 minutos. Está vencida solo cuando el tiempo transcurrido **supera** el límite; en el límite exacto todavía no está vencida. Son reglas fijas del ejercicio.

1. Lee Prioridad: localiza constantes, campo final, constructor y consulta. Predice qué valores recorre values y de dónde sale el límite de cada uno.
2. Lee Incidencia: identifica cómo se conserva la prioridad y cómo esta decide el límite. No se usa ordinal ni se comparan Strings para calcularlo.
3. Ejecuta el Main. Explica por qué ALTA con 15 minutos no está vencida y con 16 sí. Identifica el operador que expresa esa diferencia.
4. Observa el rechazo de -1: registrarMinutos devuelve false y conserva los 121 minutos anteriores. El método registra un tiempo absoluto, no suma minutos; una solicitud aceptada reemplaza el valor previo.
5. En una copia del Main, construye una incidencia MEDIA y prueba 60 y 61 minutos; luego una BAJA con 120. Deben dar false, true y false al consultar vencimiento. Cambia solo datos del escenario, no las constantes ni los métodos. Registra dos comprobaciones.

Los escenarios usan una prioridad no nula. El constructor rechaza null mediante IllegalArgumentException para impedir un objeto inválido; no necesitas activar ese error para resolver este lab.

## Salida inicial esperada

```text
BAJA: 120 min
MEDIA: 60 min
ALTA: 15 min
ALTA 15 min: vencida=false
ALTA 16 min: vencida=true
MEDIA 45 min: vencida=false
BAJA 121 min: vencida=true
Minutos negativos: false
BAJA 121 min: vencida=true
```

Guarda la respuesta breve y las dos comprobaciones en tu README personal o el del equipo indicado. Completa lo pendiente para la siguiente clase y entrega por Campus según indique el docente.
