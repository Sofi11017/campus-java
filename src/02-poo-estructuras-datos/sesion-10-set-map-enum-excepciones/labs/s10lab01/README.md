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

---

## Solución y Respuestas del Laboratorio

### 1. Predicción inicial (Paso 1)
- **Secuencia:** `A`, `B`, `A`, `C`, `B`, `A`.
- **Conteo previsto:** `A=3`, `B=2`, `C=1`.
- **Total previsto:** 6 votos.

### 2. Explicación de `votar()` y `put()` (Paso 2)
> **Respuesta:** En la estructura `Map`, cada clave es única y está asociada a un solo valor. Dado que `Integer` es inmutable en Java, para incrementar el contador de una opción existente es necesario invocar `put(clave, nuevoValor)`, el cual reemplaza el valor anterior asociado a esa clave con el nuevo total sumado.

### 3. Secuencia alterna y ordenamiento con `TreeMap` (Paso 4)
- **Secuencia:** `C`, `A`, `B`, `A`, `B`, `A`.
- **Resultado:** `{A=3, B=2, C=1}`, Total: 6.
- **Observación:** `TreeMap` ordena sus claves siguiendo el orden natural (alfabético para `String`), por lo que el orden en que se emitan los votos no altera la estructura ni el orden de presentación del reporte `{A=..., B=..., C=...}`.

### 4. Casos borde y comprobaciones (Paso 5)
- Secuencia vacía inicializa correctamente el mapa en `{A=0, B=0, C=0}` y total en `0`.
- Votos con espacios como `" a "` se limpian con `strip()` y se normalizan con `toUpperCase()`, resultando en la clave `"A"` (válida).
- Votos inválidos como `null` o `"X"` son rechazados inmediatamente por validación sin modificar contadores.

#### Tabla de comprobaciones

| Entrada | Operación | Esperado | Obtenido | Justificación |
| --- | --- | --- | --- | --- |
| Secuencia vacía | `new RecuentoVotos()` | `{A=0, B=0, C=0}`, total: 0 | `{A=0, B=0, C=0}`, total: 0 | El constructor inicializa las tres claves con valor cero. |
| `" a "` | `votar(" a ")` | `true`, total: 1 | `true`, total: 1 | Se normaliza a `"A"`, clave existente; suma 1 al contador de A. |
| `null` | `votar(null)` | `false`, total conservado | `false`, total conservado | Validación `entrada == null` retorna `false` inmediatamente. |
| `"X"` | `votar("X")` | `false`, total conservado | `false`, total conservado | Clave no existe en el mapa inicial; `containsKey("X")` retorna `false`. |

