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

---

## Solución y Respuestas del Laboratorio

### 1. Predicción inicial (Paso 1)
- Entradas: `"20", "abc", " 25 ", "80", "", "-10"`.
  - `"20"`: Aceptada (entero dentro de [-10, 50]).
  - `"abc"`: Rechazada por formato no convertible (`NumberFormatException`).
  - `" 25 "`: Aceptada (`strip()` produce `"25"`, dentro de [-10, 50]).
  - `"80"`: Rechazada por dominio (fuera de rango: 80 > 50).
  - `""`: Rechazada por dato obligatorio ausente (`isBlank()`).
  - `"-10"`: Aceptada (entero en el límite inferior permitido).
- **Resultados globales:** Aceptadas: 3 (`[20, 25, -10]`), Rechazadas: 3, Promedio: `11.6667` ((20 + 25 - 10) / 3 = 35 / 3).

### 2. Control de flujo en `registrar()` (Paso 2)
La adición `lecturas.add(valor)` está al final del método (línea 30). Si el texto es nulo/blanco, falla la conversión en `parseInt` (capturada en `catch (NumberFormatException)`), o el valor está fuera del rango [-10, 50], se incrementa `rechazadas`, se imprime el mensaje correspondiente y se ejecuta un `return false;` inmediato, impidiendo que el dato inválido llegue a la lista.

### 3. Diferencia entre error de conversión y rechazo de rango (Paso 6)
> **Respuesta:** Un error de conversión ocurre a nivel sintáctico cuando el texto no se puede transformar a una representación binaria entera válida en Java (lanzando `NumberFormatException`), mientras que un rechazo de rango ocurre a nivel de reglas de negocio/dominio sobre un entero ya convertido válidamente que incumple los límites establecidos (-10 a 50).

### 4. Comprobaciones de escenarios alternativos (Paso 5)

#### Tabla de comprobaciones

| Entradas evaluadas | Aceptadas | Rechazadas | Promedio | Observación |
| --- | --- | --- | --- | --- |
| `{"abc", "", "80"}` | 0 | 3 | `Sin datos` | Cada entrada falla por un motivo distinto; la lista queda vacía y retorna `"Sin datos"` sin provocar división por cero. |
| `{"-10", "50"}` | 2 | 0 | `20.0000` | Los valores límites inclusivos son ambos aceptados; promedio exacto `(-10 + 50) / 2 = 20.0000`. |

