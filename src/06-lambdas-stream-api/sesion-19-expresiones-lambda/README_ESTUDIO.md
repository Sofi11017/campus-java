# 📚 Guía de Estudio y Sustentación · Sesión 19: Expresiones Lambda e Interfaces Funcionales

Esta guía está diseñada para entender a fondo los 6 laboratorios de la **Sesión 19**, dominar la elección de interfaces funcionales y responder con total seguridad en la sustentación con el profesor.

---

## 🧠 1. Conceptos Fundamentales

### ¿Qué es una Interfaz Funcional?
Es una interfaz que tiene **exactamente un método abstracto** (patrón SAM: *Single Abstract Method*). Puede tener métodos `default` o `static`, pero solo uno sin implementar. La anotación `@FunctionalInterface` le indica al compilador que valide esta regla.

### ¿Qué es una Expresión Lambda?
Es una forma concisa y directa de implementar ese único método abstracto sin tener que crear una clase anónima (`new Runnable() { ... }`).
- Sintaxis básica: `(parámetros) -> { cuerpo }`
- Si recibe un solo parámetro, se pueden omitir los paréntesis: `edad -> edad >= 15`
- Si el cuerpo es una sola expresión, se omiten las llaves `{}` y el `return`: `(a, b) -> a - b`

### ⚠️ Regla de Oro: "Mostrar no es Devolver"
- `System.out.println(...)`: Imprime texto en la consola (**efecto secundario**, tipo `void`). No entrega ningún dato reutilizable al programa.
- `return valor`: Entrega un resultado al código que llamó la función para que pueda seguir operando con él (guardar en base de datos, calcular impuestos, etc.).

---

## 📊 2. La Matriz de Elección (Las 6 Interfaces Clave)

| Interfaz | Paquete | Recibe | Devuelve | Método para invocar | Intención de negocio |
| :--- | :--- | :---: | :---: | :---: | :--- |
| **`Predicate<T>`** | `java.util.function` | `T` (1 valor) | `boolean` | `.test(valor)` | **Evaluar una condición** (¿cumple o no cumple?). |
| **`Consumer<T>`** | `java.util.function` | `T` (1 valor) | `void` (nada) | `.accept(valor)` | **Ejecutar una acción** (mostrar aviso, registrar log). |
| **`Supplier<T>`** | `java.util.function` | *(nada)* | `T` (1 valor) | `.get()` | **Suministrar/proveer un dato** bajo demanda. |
| **`Function<T, R>`** | `java.util.function` | `T` (1 valor) | `R` (resultado) | `.apply(valor)` | **Transformar/convertir** una entrada en una salida. |
| **`BiFunction<T, U, R>`** | `java.util.function` | `T, U` (2 valores) | `R` (resultado) | `.apply(a, b)` | **Combinar o calcular** dos entradas independientes. |
| **`Comparator<T>`** | `java.util` | `T, T` (2 valores) | `int` (negativo/cero/pos) | `.compare(a, b)` | **Determinar el orden relativo** entre dos elementos. |

---

## 🔍 3. Análisis Detallado de Cada Laboratorio

---

### 🟢 Lab 00 · Acceso a un taller (Admisión por edad)

- **Contexto:** Un centro cultural admite al taller a personas de **15 años o más**. Se requiere una regla reutilizable que reciba la edad y responda `true` si puede ingresar o `false` si no.
- **Entrada:** `Integer` (la edad).
- **Salida:** `boolean` (`true`/`false`).
- **Interfaz elegida:** `Predicate<Integer>`
- **Método que ejecuta la lambda:** `.test(valor)`
- **Código implementado:**
  ```java
  Predicate<Integer> puedeIngresar = edad -> edad >= 15;
  ```
- **Pruebas y Resultados:**
  - `puedeIngresar.test(14)` ➔ `false`
  - `puedeIngresar.test(15)` ➔ `true`
  - `puedeIngresar.test(20)` ➔ `true`

> 🗣️ **Cómo explicarlo al profesor:**  
> *"Elegí `Predicate<Integer>` porque la regla de negocio necesita evaluar una condición booleana sobre un único dato de entrada (la edad) sin modificarla. El método abstracto que la invoca es `test()`."*

> 🔄 **Posible variación del profesor:**  
> *"¿Y si ahora entran solo personas mayores de edad (18 años o más)?"*  
> 👉 Solución: `Predicate<Integer> puedeIngresar = edad -> edad >= 18;`

---

### 🟢 Lab 01 · Aviso de lavandería (Notificación al cliente)

- **Contexto:** Una lavandería necesita una acción que reciba el nombre del cliente y muestre `"Tu pedido esta listo, NOMBRE"`. Solo emite el aviso, no retorna ningún valor para cálculos posteriores.
- **Entrada:** `String` (nombre del cliente).
- **Salida:** `void` (ningún retorno).
- **Interfaz elegida:** `Consumer<String>`
- **Método que ejecuta la lambda:** `.accept(valor)`
- **Código implementado:**
  ```java
  Consumer<String> avisar = nombre -> System.out.println("Tu pedido esta listo, " + nombre);
  ```
- **Pruebas y Resultados:**
  - `avisar.accept("Ana")` ➔ `Tu pedido esta listo, Ana`
  - `avisar.accept("Luis")` ➔ `Tu pedido esta listo, Luis`
  - `avisar.accept("Sara")` ➔ `Tu pedido esta listo, Sara`

> 🗣️ **Cómo explicarlo al profesor:**  
> *"Elegí `Consumer<String>` porque representa un consumidor de datos: recibe un parámetro para realizar una acción de efecto secundario (imprimir en consola) sin producir un resultado de retorno. Imprimir en pantalla no es devolver un valor; si necesitáramos el texto para guardarlo en un archivo o enviarlo por correo, usaríamos `Function`."*

> 🔄 **Posible variación del profesor:**  
> *"¿Y si el mensaje debe estar en mayúsculas?"*  
> 👉 Solución: `Consumer<String> avisar = nombre -> System.out.println("Tu pedido esta listo, " + nombre.toUpperCase());`

---

### 🟢 Lab 02 · Horario de atención (Proveedor de información)

- **Contexto:** Una oficina necesita obtener el aviso `"Horario: 8:00 a 17:00"` cuando lo solicite. La operación no recibe datos de entrada y devuelve el texto para que el solicitante decida qué hacer con él.
- **Entrada:** Ninguna `()`.
- **Salida:** `String` (el texto del horario).
- **Interfaz elegida:** `Supplier<String>`
- **Método que ejecuta la lambda:** `.get()`
- **Código implementado:**
  ```java
  Supplier<String> horario = () -> "Horario: 8:00 a 17:00";
  ```
- **Pruebas y Resultados:**
  - `horario.get()` ➔ `"Horario: 8:00 a 17:00"` (Solicitud 1)
  - `horario.get()` ➔ `"Horario: 8:00 a 17:00"` (Solicitud 2)
  - `horario.get()` ➔ `"Horario: 8:00 a 17:00"` (Solicitud 3)

> 🗣️ **Cómo explicarlo al profesor:**  
> *"Elegí `Supplier<String>` porque actúa como un proveedor o fábrica diferida: no recibe ningún argumento y entrega un valor cada vez que se le invoca mediante `.get()`. Esto separa la obtención del dato de su presentación en consola."*

> 🔄 **Posible variación del profesor:**  
> *"¿Por qué no usamos simplemente una variable String?"*  
> 👉 Solución: *"Porque `Supplier` es una función diferida (lazy evaluation). Si el horario viniera de una consulta externa o cálculo dinámico, solo se ejecuta en el momento exacto en que se llama a `.get()`."*

---

### 🟢 Lab 03 · Peso de un paquete (Conversión de unidades)

- **Contexto:** Una transportadora recibe el peso en **gramos enteros** (`Integer`) y necesita transformarlo a **kilogramos con decimales** (`Double`) para usarlo en tarifas posteriores. No debe imprimir internamente.
- **Entrada:** `Integer` (gramos).
- **Salida:** `Double` (kilogramos).
- **Interfaz elegida:** `Function<Integer, Double>`
- **Método que ejecuta la lambda:** `.apply(valor)`
- **Código implementado:**
  ```java
  Function<Integer, Double> aKilogramos = gramos -> gramos / 1000.0;
  ```
  *(Nota: Se divide entre `1000.0` con decimal para evitar la división entera de Java que truncaría los decimales).*
- **Pruebas y Resultados:**
  - `aKilogramos.apply(500)` ➔ `0.5 kg`
  - `aKilogramos.apply(1000)` ➔ `1.0 kg`
  - `aKilogramos.apply(2500)` ➔ `2.5 kg`

> 🗣️ **Cómo explicarlo al profesor:**  
> *"Elegí `Function<Integer, Double>` porque la necesidad del negocio es transformar un tipo de entrada (`Integer`) en un tipo de salida diferente (`Double`). El resultado se retorna mediante `.apply()` para que otros módulos puedan calcular precios o pesos totales."*

> 🔄 **Posible variación del profesor:**  
> *"¿Y si queremos convertir de kilogramos a libras (1 kg ≈ 2.20462 lb)?"*  
> 👉 Solución: `Function<Double, Double> aLibras = kg -> kg * 2.20462;`

---

### 🟢 Lab 04 · Minutos disponibles de una sala (Cálculo con dos entradas)

- **Contexto:** Una sala de reuniones se reserva por bloques. Se necesita calcular los minutos restantes recibiendo dos datos independientes: **minutos contratados** y **minutos utilizados**.
- **Entrada:** Dos valores `Integer, Integer`.
- **Salida:** `Integer` (minutos restantes).
- **Interfaz elegida:** `BiFunction<Integer, Integer, Integer>`
- **Método que ejecuta la lambda:** `.apply(primero, segundo)`
- **Código implementado:**
  ```java
  BiFunction<Integer, Integer, Integer> minutosRestantes = 
          (contratados, utilizados) -> contratados - utilizados;
  ```
- **Pruebas y Resultados:**
  - `minutosRestantes.apply(120, 45)` ➔ `75`
  - `minutosRestantes.apply(120, 0)` ➔ `120`
  - `minutosRestantes.apply(120, 120)` ➔ `0`

> 🗣️ **Cómo explicarlo al profesor:**  
> *"Elegí `BiFunction` porque la operación depende de dos entradas independientes que no pueden deducirse una de la otra (tiempo contratado y tiempo consumido) y produce un único resultado numérico. Su método de ejecución es `apply(a, b)`."*

> 🔄 **Posible variación del profesor:**  
> *"¿Podríamos haber usado `BinaryOperator<Integer>`?"*  
> 👉 Solución: *"Sí, porque los dos tipos de entrada y el tipo de retorno son exactamente el mismo (`Integer`). `BinaryOperator<T>` es una especialización de `BiFunction<T, T, T>`."*

---

### 🟢 Lab 05 · Lista de participantes (Ordenamiento con Comparator)

- **Contexto:** Un instructor tiene una lista de nombres de participantes y desea ordenarlos alfabéticamente de forma ascendente. La lista debe ser modificable (`ArrayList`).
- **Entrada:** Dos cadenas `String, String`.
- **Salida:** `int` (negativo si el primero va antes, `0` si son iguales, positivo si el segundo va antes).
- **Interfaz elegida:** `Comparator<String>`
- **Método que ejecuta la lambda:** `.compare(a, b)` (usado internamente por `List.sort(...)`).
- **Código implementado:**
  ```java
  Comparator<String> alfabetico = (a, b) -> a.compareTo(b);
  ```
- **Pruebas y Resultados:**
  - `["Sofia", "Luis", "Ana"]` ➔ `Ana, Luis, Sofia`
  - `["Luis", "Ana", "Ana"]` ➔ `Ana, Ana, Luis`
  - `[]` (lista vacía) ➔ `Vacía, sin error`

> 🗣️ **Cómo explicarlo al profesor:**  
> *"Elegí `Comparator<String>` porque es el contrato que exige el método `List.sort()`. La lambda compara lexicográficamente dos cadenas usando `a.compareTo(b)`. Si dos nombres son iguales devuelve `0`, lo que garantiza estabilidad (conserva ambos registros de 'Ana' sin descartar a ninguno de los dos participantes reales)."*

> 🔄 **Posible variación del profesor:**  
> *"¿Cómo invertirías el orden para que sea descendente (de la Z a la A)?"*  
> 👉 Solución 1: Invertir los parámetros: `(a, b) -> b.compareTo(a)`  
> 👉 Solución 2: Usar reversed: `alfabetico.reversed()`

---

## 🎯 4. Resumen Rápido para Memorizar (Chuleta)

| Problema | Pregunta clave | Interfaz | Invocación |
| :--- | :--- | :---: | :---: |
| **Lab 00: Edad taller** | ¿Tiene 15 o más? (Sí/No) | `Predicate<T>` | `test(x)` |
| **Lab 01: Aviso lavandería** | Avisar a cliente (Solo mostrar) | `Consumer<T>` | `accept(x)` |
| **Lab 02: Horario oficina** | Dame el horario (Sin argumentos) | `Supplier<T>` | `get()` |
| **Lab 03: Paquete gramos→kg** | Convierte 1 dato en otro tipo | `Function<T, R>` | `apply(x)` |
| **Lab 04: Minutos sala** | Resta 2 números independientes | `BiFunction<T, U, R>` | `apply(x, y)` |
| **Lab 05: Participantes** | Ordena nombres alfabéticamente | `Comparator<T>` | `compare(a, b)` en `sort()` |
