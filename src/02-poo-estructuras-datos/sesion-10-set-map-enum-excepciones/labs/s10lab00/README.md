# Lab 00 · Materiales pendientes

**Tiempo: 12 minutos. Código completo, sin TODO.**

## Archivos

1. [MaterialesTaller.java](MaterialesTaller.java).
2. [S10Lab00SetMain.java](S10Lab00SetMain.java): ejecuta este Main.

Copia todos los archivos al paquete s10lab00 de tu proyecto personal y ejecuta con JDK 21 o 17.

## Actividad paso a paso

Un taller necesita saber qué materiales requeridos todavía no tiene. Los nombres se normalizan quitando espacios externos y usando mayúsculas. LinkedHashSet mantiene el orden de carga; nulo y blanco se rechazan.

1. Lee los campos `requeridos` y `disponibles`. Antes de ejecutar, predice qué falta si se requieren CARTULINA, PEGAMENTO y TIJERAS, y hay cartulina y REGLA.
2. Ejecuta el Main y compara la salida. REGLA no reduce faltantes porque no es un material requerido.
3. Ubica `faltantes()`: crea una copia de requeridos y aplica `removeAll(disponibles)` sobre ella. Explica en una frase por qué modificar el conjunto original perdería información para futuras consultas.
4. En una copia del Main, añade `taller.disponer("TIJERAS");` al final e imprime otra vez faltantes: debe ser `[]`. Comprueba que requeridos sigue teniendo 3 elementos. No cambies la clase MaterialesTaller.
5. Prueba disponer null y `"   "`: ambas devuelven false y no aumentan la cantidad. Repetir `" cartulina "` tampoco aumenta el conjunto. Registra dos comprobaciones en una tabla pequeña.

La colección devuelta por faltantes es una copia independiente: modificarla no altera los conjuntos internos. No tienes que desarrollar una nueva función.

## Salida inicial esperada

```text
Faltantes: [PEGAMENTO, TIJERAS]
Faltantes despues: [TIJERAS]
Repetir cartulina: false
Requeridos: 3
Disponibles: 3
```

Guarda la respuesta breve y las dos comprobaciones en tu README personal o el del equipo indicado. Completa lo pendiente para la siguiente clase y entrega por Campus según indique el docente.

---

## Solución y Respuestas del Laboratorio

### 1. Predicción inicial (Paso 1)
- **Materiales requeridos:** `CARTULINA`, `PEGAMENTO`, `TIJERAS`.
- **Materiales disponibles:** `cartulina` (normalizado a `CARTULINA`), `REGLA` (normalizado a `REGLA`).
- **Faltantes previstos:** `[PEGAMENTO, TIJERAS]`.
- **Observación:** `REGLA` no reduce faltantes porque no forma parte del conjunto de materiales requeridos (`requeridos` no contiene `REGLA`).

### 2. Explicación de copia en `faltantes()` (Paso 3)
> **Respuesta:** Si se modificara directamente el conjunto `requeridos` con `removeAll`, se eliminarían de forma irreversible los elementos ya disponibles del conjunto original, destruyendo el registro histórico de qué materiales requería el taller y haciendo imposible reevaluar los faltantes si el inventario de disponibles cambia.

### 3. Comprobaciones de los Pasos 4 y 5
Al añadir `taller.disponer("TIJERAS")`, el conjunto de faltantes pasa a ser `[]` (conjunto vacío), mientras que `requeridos` conserva intactos sus 3 elementos originales (`CARTULINA`, `PEGAMENTO`, `TIJERAS`).

#### Tabla de comprobaciones

| Entrada | Operación | Esperado | Obtenido | Justificación |
| --- | --- | --- | --- | --- |
| `null` | `taller.disponer(null)` | `false`, cant=4 | `false`, cant=4 | `normalizar()` produce `""`, rechazada por `!valor.isEmpty()`. |
| `"   "` | `taller.disponer("   ")` | `false`, cant=4 | `false`, cant=4 | `strip()` elimina espacios resultando en `""`, rechazada por `!valor.isEmpty()`. |
| `" cartulina "` | `taller.disponer(" cartulina ")` | `false`, cant=4 | `false`, cant=4 | `normalizar` produce `"CARTULINA"`; `LinkedHashSet.add()` rechaza duplicados. |
| `"TIJERAS"` | `taller.disponer("TIJERAS")` | `true`, faltantes `[]` | `true`, faltantes `[]` | Se agrega a disponibles y reduce los faltantes a conjunto vacío sin alterar requeridos. |

