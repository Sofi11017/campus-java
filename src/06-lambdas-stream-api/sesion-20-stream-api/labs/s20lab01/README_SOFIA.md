# Lab 01 · Asistencia sin Duplicados · Explicación y Sustentación

## 🎯 1. Situación

El coordinador de un evento o clase necesita obtener la lista definitiva de asistentes a partir de una lista inicial donde las personas pudieron registrarse varias veces. Los nombres deben aparecer:
1. **Una sola vez por persona** (sin duplicados).
2. **En orden alfabético** (de la A a la Z).
3. **Sin modificar la lista original** (inmutabilidad).

---

## ❗ 2. El Problema

Si intentamos resolver esto de forma imperativa clásica (con bucles `for` y listas mutables):
- Tendríamos que crear una nueva lista auxiliar, recorrer la lista original, verificar con `!nuevaLista.contains(nombre)` antes de agregar, y luego invocar `Collections.sort()`.
- Este enfoque es propenso a errores, requiere más líneas de código y mezcla la lógica de recorrido con las reglas de negocio.
- Si modificáramos la lista original directamente (ej. borrando elementos), romperíamos la fuente de datos original (pérdida de trazabilidad del historial).

---

## ✅ 3. La Solución con Stream API

Con **Stream API**, el procesamiento se formula de manera declarativa como un flujo (*pipeline*) en una sola secuencia clara:

```java
public static List<String> procesarAsistencia(List<String> asistentes) {
    return asistentes.stream()
            .distinct()
            .sorted()
            .toList();
}
```

### 🧩 Desglose del Pipeline:

| Paso | Código | Tipo de Operación | Qué hace |
| :---: | :--- | :---: | :--- |
| **1** | `asistentes.stream()` | **Fuente** | Abre un flujo de elementos a partir de la colección original sin alterarla. |
| **2** | `.distinct()` | **Intermedia** | Filtra los elementos repetidos, conservando solo la primera ocurrencia de cada uno según el método `equals()`. |
| **3** | `.sorted()` | **Intermedia** | Ordena los nombres alfabéticamente según el orden natural de `String` (que implementa `Comparable<String>`). |
| **4** | `.toList()` | **Terminal** | Cierra el stream y materializa los elementos resultantes en una nueva lista inmutable (`java.util.List`). |

---

## 📊 4. Casos Probados y Resultados

```text
Caso 1:
  Original : Sofia, Ana, Sofia, Luis
  Resultado: Ana, Luis, Sofia

Caso 2:
  Original : Ana, Ana
  Resultado: Ana

Caso 3:
  Original : Lista vacía
  Resultado: Lista vacía
```

---

## 🎤 5. Preguntas Clave para Sustentar con el Profesor

### P1: ¿Qué significa técnicamente que dos nombres se consideren repetidos?
> **Respuesta:**  
> En Java, la operación intermedia `.distinct()` utiliza el contrato de **`equals(Object)`** y **`hashCode()`** del tipo de dato. En este caso, para la clase `String`, dos cadenas se consideran iguales (`repetidas`) si tienen exactamente la misma secuencia de caracteres Unicode (respetando mayúsculas y minúsculas).

---

### P2: ¿Por qué pusimos `.distinct()` antes de `.sorted()` y no al revés?
> **Respuesta:**  
> Por **eficiencia de procesamiento**:
> - Si aplicamos `.distinct()` primero, reducimos la cantidad de elementos en el stream antes de ordenar.
> - Si aplicáramos `.sorted()` primero, el algoritmo de ordenamiento tendría que comparar y ordenar todos los elementos duplicados innecesariamente. Ambos dan el mismo resultado final, pero `distinct() -> sorted()` es más eficiente.

---

### P3: ¿Se modificó la lista original de asistentes?
> **Respuesta:**  
> **No.** Los Streams en Java nunca modifican su fuente de datos. Crean un flujo que procesa elementos sobre la marcha y `.toList()` genera una nueva lista independiente. La lista original de registro permanece intacta.

---

### P4: ¿Qué pasa si la lista inicial está vacía?
> **Respuesta:**  
> El Stream se abre vacío, `.distinct()` y `.sorted()` no procesan ningún elemento, y `.toList()` devuelve una lista vacía sin arrojar ninguna excepción (`NullPointerException` o `IndexOutOfBoundsException`). El flujo es completamente seguro ante listas vacías.
