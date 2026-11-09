# Lab 01 · Detener un Sensor Simulado · Explicación completa

## 🎯 Situación

Un programa simula un **sensor de mediciones** que trabaja en un hilo separado. El sensor genera lotes de datos calculados de forma continua. El programa principal (controlador) necesita poder **pedirle al sensor que se detenga** en algún momento, sin forzarlo de golpe ni interrumpirlo de forma violenta.

El sensor no es un dispositivo real ni hace operaciones de red o disco: simplemente hace cálculos para simular trabajo. El controlador y el sensor corren en hilos distintos, así que necesitan una forma segura de **comunicar la señal de parada**.

---

## ❗ El problema: visibilidad entre hilos

Cuando dos hilos acceden a una variable compartida, en Java cada hilo puede tener su propia **copia en caché** de esa variable. Esto significa que si el controlador cambia el valor de `activo = false`, el hilo del sensor podría **no verlo nunca** (o verlo con retraso), porque está leyendo su copia local desactualizada.

```
// Sin volatile:
Controlador escribe: activo = false
Sensor lee su caché: activo = true  ← ¡Nunca se detiene!
```

---

## ✅ La solución: `volatile`

La palabra clave `volatile` le dice a Java que **nunca cachée esa variable**: cada lectura va directo a la memoria principal, y cada escritura también. Así, cuando el controlador escribe `activo = false`, el sensor lo ve de inmediato en su próxima lectura.

```java
private volatile boolean activo = true;

// En el hilo sensor:
while (lotes < MAX_LOTES) {
    if (!activo) {               // ← lee siempre de memoria principal
        resultado = "DETENIDO_POR_BANDERA";
        return;
    }
    // ... hace trabajo ...
}

// En el controlador:
public void solicitarDetencion() {
    activo = false;              // ← escribe en memoria principal
}
```

---

## 🔎 ¿Cómo funciona el flujo completo?

```
[Main/Controlador]            [Hilo Sensor]
       |                            |
  hilo.start() ──────────────→ empieza a correr
       |                       procesa lote 1
  esperarPrimerLote() ←─────── primerLote.countDown()
       |                       procesa lotes...
  solicitarDetencion()
  (activo = false) ──────────→ if (!activo) → DETENIDO_POR_BANDERA
       |                            |
  hilo.join() ───────────────→ hilo termina
       |
  imprime resultados
```

El `CountDownLatch` del primer lote garantiza que el controlador espere a que el sensor haya arrancado antes de pedir la parada. `join()` espera a que el hilo termine completamente antes de leer los resultados.

---

## 📊 Resultados obtenidos

### Con lote de 64 (configuración original):
```
Resultado: DETENIDO_POR_BANDERA
Lotes: 1
Muestras: 64
Resumen coherente: true
Hilo vivo: false
```

### Con lote de 128 (modificación del paso 4):
```
Resultado: DETENIDO_POR_BANDERA
Lotes: 2
Muestras: 256
Resumen coherente: true
Hilo vivo: false
```

> `Muestras = Lotes × TamañoLote` → 2 × 128 = 256 ✔  
> Con lotes más grandes, el sensor tarda más en revisar la bandera, por eso puede completar más lotes antes de detenerse. El número de lotes no es fijo entre ejecuciones.

---

## 🧩 Clases del ejercicio

| Clase | Rol |
|-------|-----|
| `SensorSimulado` | Hilo trabajador que genera lotes y revisa la bandera `volatile activo` |
| `S16Lab01SensorMain` | Controlador: lanza el hilo, espera el primer lote, pide parada y lee resultados |

---

## ⚠️ Limitaciones de `volatile`

| Situación | ¿`volatile` es suficiente? |
|-----------|---------------------------|
| Un hilo escribe, otro lee | ✅ Sí |
| Incrementar un contador (`contador++`) con varios hilos | ❌ No (no es atómico) |
| Despertar un hilo bloqueado en `sleep()` o `wait()` | ❌ No (no despierta hilos bloqueados) |

---

## 💡 Conclusión para explicar al profesor

> Este laboratorio muestra el problema de **visibilidad** entre hilos: sin `volatile`, un hilo puede no ver los cambios que otro hilo hace en una variable compartida. `volatile` soluciona esto garantizando que cada lectura y escritura va directamente a la memoria principal, sin cachés. Es la herramienta correcta para **banderas de parada** (un hilo escribe, otro lee), pero no reemplaza a `synchronized` ni a los atómicos cuando se necesitan operaciones compuestas.

