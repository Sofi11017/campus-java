# Lab 02 · Builder · Reserva hotelera

**Tiempo: 10 minutos. Código completo, sin TODO.**

## Archivos y ejecución

Lee [Reserva.java](Reserva.java) → [ReservaBuilder.java](ReservaBuilder.java) y ejecuta [S12Lab02BuilderMain.java](S12Lab02BuilderMain.java). Copia todos los archivos del paquete s12lab02 bajo la raíz de código de tu proyecto personal.

## Actividad paso a paso

Una reserva exige huésped y fecha; desayuno, estacionamiento y lateCheckout son opciones. No se calculan precios ni disponibilidad real.

1. Lee Reserva: sus campos son finales y no ofrece setters. Después identifica en ReservaBuilder los datos temporales, los métodos que retornan this y la validación de build.
2. Predice qué ocurre al construir la primera reserva y reutilizar el builder con lateCheckout true. Ejecuta el Main y observa que la primera no se modifica.
3. Sigue en Debug cada build: se crea un producto nuevo. Señala la diferencia entre configurar el builder y cambiar una reserva ya construida.
4. En una copia del Main cambia el huésped a `Luis` y la fecha a `LocalDate.of(2026, 3, 5)`. Ambas reservas deben reflejar esos datos y conservar sus distintas opciones de lateCheckout.
5. En otra ejecución, crea `new ReservaBuilder().huesped("Ana").build()` dentro del try ya preparado: debe indicar `La fecha es obligatoria`. No cambies la lógica del builder. Explica qué estado incompleto se impide publicar.

La fecha fija se construye con año, mes y día; no se consulta el reloj. Constructor con pocos parámetros puede ser más simple para una reserva sin muchas opciones: menciona ese costo en una frase.

## Salida inicial esperada

```text
Ana | 2026-02-10 | desayuno=true | estacionamiento=true | lateCheckout=false
Ana | 2026-02-10 | desayuno=true | estacionamiento=true | lateCheckout=true
Primera conserva lateCheckout: false
Objetos distintos: true
Reserva rechazada: El huesped es obligatorio
```

Guarda dos comprobaciones cortas con entrada, esperado y obtenido, y responde la pregunta conceptual. No debes construir otro patrón ni dibujar un UML completo en este tiempo. Completa lo pendiente para la siguiente clase según indique el docente.
