# Lab 00 · Reservas de Taller · Explicación completa

## 🎯 Situación

Imaginemos un taller con **20 cupos disponibles**. Cuatro personas (participantes) intentan reservar un cupo **10 veces cada una**, al mismo tiempo, desde distintos hilos de ejecución. Esto da un total de **40 intentos** para solo 20 cupos.

El reto está en que, si varios hilos intentan reservar al mismo tiempo sin ningún control, pueden "chocar": dos hilos leen que hay 1 cupo disponible, ambos lo descuentan, y el sistema termina con -1 cupos (un valor imposible). Eso se llama **condición de carrera** (*race condition*).

---

## ❗ El problema: condición de carrera

Cuando múltiples hilos acceden y modifican un valor compartido (`disponibles`) sin sincronización, pueden ocurrir resultados incorrectos:

```
Hilo A lee disponibles = 1  ← ambos leen al mismo tiempo
Hilo B lee disponibles = 1
Hilo A descuenta → disponibles = 0
Hilo B descuenta → disponibles = -1  ← ¡ERROR!
```

Esto hace que el sistema quede **incoherente**: se aceptan más reservas de las que había cupos, o el contador queda en negativo.

---

## ✅ La solución: `synchronized`

Para proteger el recurso compartido, se usó la palabra clave `synchronized` en Java, que garantiza que **solo un hilo a la vez** puede ejecutar el bloque protegido.

Se implementaron **dos versiones** que hacen lo mismo pero con diferente técnica:

### Versión 1 — `CuposMetodo.java` (synchronized en el método)
```java
public synchronized boolean reservar() {
    if (disponibles <= 0) return false;
    disponibles--;
    return true;
}
```
Aquí el monitor (el "candado") es **`this`**, es decir, la propia instancia del objeto. Mientras un hilo ejecuta `reservar()`, ningún otro puede entrar.

### Versión 2 — `CuposBloque.java` (synchronized en un bloque con objeto privado)
```java
private final Object monitor = new Object();

public boolean reservar() {
    synchronized (monitor) {
        if (disponibles <= 0) return false;
        disponibles--;
        return true;
    }
}
```
Aquí el monitor es un **objeto privado separado**. Esto da más control: podría tener distintos monitores para distintas secciones críticas. El resultado es idéntico, pero la técnica es más flexible.

---

## 🔎 ¿Por qué proteger AMBAS instrucciones juntas?

La comprobación `disponibles <= 0` y el descuento `disponibles--` deben estar en el **mismo bloque sincronizado**. Si no, otro hilo podría colarse entre las dos instrucciones y causar el error mencionado arriba.

---

## 📊 Resultados obtenidos

### Con 20 cupos iniciales (configuración original):
```
Metodo: disponibles=0 reservas=20 rechazos=20 coherente=true
Bloque:  disponibles=0 reservas=20 rechazos=20 coherente=true
```
✔ 20 reservas aceptadas + 20 rechazos = 40 intentos. ¡Correcto!

### Con 30 cupos iniciales (modificación del paso 5):
```
Metodo: disponibles=0 reservas=30 rechazos=10 coherente=true
Bloque:  disponibles=0 reservas=30 rechazos=10 coherente=true
```
✔ 30 reservas + 10 rechazos = 40 intentos. ¡Correcto!

> Las dos versiones siempre dan el mismo resultado porque ambas garantizan exclusión mutua. No importa qué participante obtenga cada cupo, el total siempre cuadra.

---

## 🧩 Clases del ejercicio

| Clase / Interfaz | Rol |
|-----------------|-----|
| `Cupos` | Interfaz con `reservar()` y `consultarDisponibles()` |
| `CuposMetodo` | Implementa con `synchronized` en el método (`this`) |
| `CuposBloque` | Implementa con `synchronized` en bloque + objeto privado |
| `Participante` | Hilo que intenta reservar N veces |
| `PruebaReservas` | Coordina la prueba y valida la coherencia |
| `EjecutorPrueba` | Lanza todos los hilos al mismo tiempo y espera |
| `S16Lab00ReservasMain` | Punto de entrada: prueba ambas versiones |

---

## 💡 Conclusión para explicar al profesor

> Este laboratorio demuestra que cuando múltiples hilos comparten un recurso mutable, es **obligatorio sincronizar el acceso** para evitar condiciones de carrera. Java ofrece `synchronized` como mecanismo básico. El monitor puede ser `this` (método sincronizado) o un objeto privado (bloque sincronizado). Ambas estrategias producen resultados idénticos y coherentes, independientemente del orden en que los hilos ejecuten sus pasos.

