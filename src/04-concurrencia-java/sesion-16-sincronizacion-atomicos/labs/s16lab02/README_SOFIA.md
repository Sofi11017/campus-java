# Lab 02 · Mensajes de Mesa de Ayuda · Explicación completa

## 🎯 Situación

Una mesa de ayuda tiene **4 agentes** (en la configuración original). Cada agente atiende **250 mensajes**. Los 4 agentes trabajan **al mismo tiempo** (en hilos distintos), y cada vez que un agente termina un mensaje, debe registrarlo en un **contador compartido**.

Al final, el sistema debe reportar exactamente **1000 mensajes procesados** (4 agentes × 250 mensajes). El reto está en garantizar que el contador no pierda ningún incremento aunque varios hilos lo modifiquen simultáneamente.

---

## ❗ El problema: `++` no es atómico

La operación `contador++` parece simple, pero en realidad son **tres pasos separados** a nivel de CPU:

```
1. Leer el valor actual de contador
2. Sumarle 1
3. Guardar el resultado
```

Si dos hilos ejecutan esto al mismo tiempo, pueden sobreescribirse:

```
Hilo A lee contador = 5
Hilo B lee contador = 5   ← lee antes de que A guarde
Hilo A guarda 6
Hilo B guarda 6           ← ¡perdemos un incremento! Debería ser 7
```

Esto significa que con `volatile int contador` y el operador `++`, **se pierden mensajes** cuando hay concurrencia.

---

## ✅ La solución: `AtomicInteger`

Java ofrece la clase `AtomicInteger` en el paquete `java.util.concurrent.atomic`. Esta clase realiza operaciones de forma **atómica** usando instrucciones especiales del procesador (CAS - *Compare And Swap*), sin necesitar `synchronized`.

```java
AtomicInteger contador = new AtomicInteger();

// En cada agente, por cada mensaje procesado:
procesados.incrementAndGet();  // Lee + suma + guarda en UNA sola operación atómica
```

No importa cuántos hilos llamen a `incrementAndGet()` al mismo tiempo: **nunca se pierde un incremento**.

---

## 🔎 ¿Por qué esperar a todos antes de leer el total?

Aunque cada `incrementAndGet()` es atómico, el controlador debe hacer `join()` (esperar a que todos los hilos terminen) antes de leer el total. Si lo lee antes, podría ver un valor incompleto porque algunos agentes aún estarían procesando.

```
// Incorrecto: leer mientras los hilos aún corren
int total = contador.get();   ← podría ser 743, aunque al final sea 1000

// Correcto: esperar a todos primero
EjecutorPrueba.ejecutar(tareas);  ← join() interno, espera a todos
int total = contador.get();       ← ahora sí es 1000
```

---

## 🔢 Diferencia entre `incrementAndGet` y `getAndIncrement`

Ambos suman 1, pero difieren en el valor que **retornan**:

```java
AtomicInteger secuencial = new AtomicInteger(0);

secuencial.incrementAndGet();  // Suma 1, retorna el NUEVO valor → retorna 1
secuencial.getAndIncrement();  // Retorna el ACTUAL valor y luego suma 1 → retorna 1, queda en 2

System.out.println(secuencial.get());  // → 2
```

| Método | Retorna | Luego el valor queda en |
|--------|---------|------------------------|
| `incrementAndGet()` | Valor **después** del incremento | mismo que retorna |
| `getAndIncrement()` | Valor **antes** del incremento | retornado + 1 |

---

## 📊 Resultados obtenidos

### Con 4 agentes (configuración original):
```
Esperado: 1000
Procesados: 1000
Correcto: true
incrementAndGet retorna: 1
getAndIncrement retorna: 1
Valor final del ejemplo secuencial: 2
```

### Con 6 agentes (modificación del paso 4):
```
Esperado: 1500
Procesados: 1500
Correcto: true
incrementAndGet retorna: 1
getAndIncrement retorna: 1
Valor final del ejemplo secuencial: 2
```

> Con 6 agentes × 250 mensajes = 1500. `Correcto: true` confirma que no se perdió ningún mensaje. ✔

---

## 🧩 Clases del ejercicio

| Clase | Rol |
|-------|-----|
| `AgenteMensajes` | Hilo que procesa N mensajes llamando `incrementAndGet()` en el contador compartido |
| `EjecutorPrueba` | Lanza todos los hilos simultáneamente y espera a que terminen |
| `S16Lab02MensajesMain` | Configura agentes, ejecuta, verifica el total y muestra el ejemplo secuencial |

---

## ⚖️ ¿`volatile` vs `AtomicInteger`?

| Característica | `volatile int` | `AtomicInteger` |
|----------------|---------------|-----------------|
| Visibilidad entre hilos | ✅ Sí | ✅ Sí |
| `++` es seguro con múltiples hilos | ❌ No | ✅ Sí |
| Necesita `synchronized` | ❌ No aplica | ❌ No necesita |
| Operaciones compuestas (check-then-act) | ❌ No | ✅ Con `compareAndSet` |

---

## 💡 Conclusión para explicar al profesor

> Este laboratorio demuestra que `volatile` no es suficiente para operaciones como el incremento de un contador cuando intervienen múltiples hilos, porque `++` no es atómica. `AtomicInteger` resuelve esto con operaciones CAS a nivel de hardware, garantizando que cada incremento se registre sin importar cuántos hilos compitan. Es la solución más eficiente y limpia para **contadores concurrentes** sin necesidad de bloqueos (`synchronized`).

