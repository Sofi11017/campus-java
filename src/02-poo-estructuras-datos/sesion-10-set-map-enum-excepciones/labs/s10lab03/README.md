# Lab 03 · Carga de mediciones

**Tiempo: 17 minutos. Código completo, sin TODO.**

## Archivos

1. [RegistroTemperaturas.java](RegistroTemperaturas.java).
2. [S10Lab03ExcepcionesMain.java](S10Lab03ExcepcionesMain.java): ejecuta este Main.

Copia todos los archivos al paquete s10lab03 de tu proyecto personal y ejecuta con JDK 21 o 17.

## Actividad paso a paso

El registro recibe texto y conserva solo temperaturas enteras entre **-10 y 50**, inclusive. Cada intento se acepta o se cuenta como rechazado una sola vez. Los errores de conversión no deben detener las siguientes lecturas ni convertirse en un cero inventado.

1. Predice qué datos se aceptan de `"20", "abc", " 25 ", "80", "", "-10"`. Distingue texto no convertible, dato obligatorio ausente y número fuera del rango.
2. Lee registrar: localiza la validación inicial, el try de Integer.parseInt, el catch específico y la validación posterior del rango. Señala dónde se agrega la lectura y por qué no se alcanza esa línea tras un rechazo.
3. Ejecuta el Main. Compara lecturas, aceptadas, rechazadas y promedio. El formato usa cuatro decimales y Locale.ROOT, por lo que el separador decimal es punto.
4. En Debug, coloca un breakpoint en parseInt. Sigue primero `"20"` y después `"abc"`: observa el salto al catch y la continuación con el siguiente dato. `"80"` se convierte correctamente, pero se rechaza por regla de dominio.
5. En una ejecución separada, cambia entradas a `{"abc", "", "80"}`: aceptadas 0, rechazadas 3 y promedio `Sin datos`. Después prueba `{"-10", "50"}`: aceptadas 2 y promedio `20.0000`. No cambies métodos ni añadas un catch genérico.
6. Registra esos dos casos y responde en una frase qué diferencia hay entre un error de conversión y un rechazo de rango. Comprobarlo no requiere programar sensores, archivos ni Scanner.

El fallo conserva la lista de lecturas válidas; el contador de rechazadas sí aumenta porque registra el intento fallido. Una lista vacía no calcula promedio.

## Salida inicial esperada

```text
Rechazada: no es entero [abc]
Rechazada: fuera de rango [80]
Rechazada: dato obligatorio
Lecturas: [20, 25, -10]
Aceptadas: 3
Rechazadas: 3
Promedio: 11.6667
```

Guarda la respuesta breve y las dos comprobaciones en tu README personal o el del equipo indicado. Completa lo pendiente para la siguiente clase y entrega por Campus según indique el docente.
