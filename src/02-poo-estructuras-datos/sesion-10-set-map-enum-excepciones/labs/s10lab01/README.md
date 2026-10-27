# Lab 01 · Recuento de votos

**Tiempo: 13 minutos. Código completo, sin TODO.**

## Archivos

1. [RecuentoVotos.java](RecuentoVotos.java).
2. [S10Lab01MapMain.java](S10Lab01MapMain.java): ejecuta este Main.

Copia todos los archivos al paquete s10lab01 de tu proyecto personal y ejecuta con JDK 21 o 17.

## Actividad paso a paso

Tres opciones de una encuesta ficticia, A, B y C, comienzan con cero votos. El mapa relaciona una opción con su contador. Solo se aceptan esas tres claves después de quitar espacios y normalizar a mayúsculas.

1. Antes de ejecutar, cuenta manualmente la secuencia A, B, A, C, B, A. Predice los tres valores y el total.
2. Lee `votar`: identifica la validación con containsKey y la actualización que consulta el valor anterior y suma uno. Explica por qué put debe reemplazar el contador en este caso.
3. Ejecuta el Main y compara la salida. La solicitud X debe rechazarse sin crear otra clave ni cambiar el total.
4. En una copia del Main, cambia la secuencia a C, A, B, A, B, A: el resultado final debe seguir siendo A=3, B=2, C=1. TreeMap ordena las claves; no uses el orden de ingreso para interpretar los contadores.
5. En otra ejecución usa una secuencia vacía: el reporte debe mostrar A=0, B=0, C=0 y total 0. Después prueba `" a "` (aceptado, A=1), null y X (rechazados). Registra dos comprobaciones y una explicación corta.

`consultar` devuelve cero si no hay clave, pero `votar` solo permite las claves iniciales. No agregues opciones ni cambies la lógica del recuento.

## Salida inicial esperada

```text
Recuento: {A=3, B=2, C=1}
Total: 6
Votar X: false
Total conservado: 6
```

Guarda la respuesta breve y las dos comprobaciones en tu README personal o el del equipo indicado. Completa lo pendiente para la siguiente clase y entrega por Campus según indique el docente.
