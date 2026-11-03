# Lab 02 · Mensajes de mesa de ayuda · 15 minutos

Cuatro agentes procesan **250 mensajes cada uno**. Cada mensaje completado incrementa un contador AtomicInteger compartido. Todos los trabajos son simulados.

## Pasos para completar la actividad

1. Abre [S16Lab02MensajesMain.java](S16Lab02MensajesMain.java) y [AgenteMensajes.java](AgenteMensajes.java). Identifica agentes=4, mensajesPorAgente=250 y el incremento dentro del ciclo.
2. Calcula 4 × 250 antes de ejecutar. Selecciona **Run → S16Lab02MensajesMain** y comprueba Esperado: 1000, Procesados: 1000 y Correcto: true.
3. Localiza contador.get después de EjecutorPrueba.ejecutar. Explica por qué esperar a todos es necesario para revisar el total final, aunque cada incremento sea atómico.
4. Cambia únicamente `int agentes = 4;` por `int agentes = 6;`. Conserva 250 mensajes por agente. Predice y ejecuta: esperado y procesados deben ser 1500; Correcto sigue en true. Guarda esa salida.
5. Lee el ejemplo secuencial al final del Main. Parte de cero: incrementAndGet devuelve 1; getAndIncrement devuelve 1 pero deja 2 almacenado. Confirma que Valor final del ejemplo secuencial es 2.
6. Para comprobarlo por tu cuenta, sustituye solo la segunda operación `secuencial.getAndIncrement()` por `secuencial.incrementAndGet()` y actualiza su etiqueta. Ahora la segunda operación devuelve 2 y el valor final sigue 2. El conteo concurrente de mensajes no cambia.
7. En Debug, coloca un breakpoint en run de AgenteMensajes y localiza el mismo contador referenciado por los agentes. La pausa altera el orden; se valida el total, no quién termina primero.
8. Responde: ¿por qué volatile int con ++ no ofrece la misma garantía? ¿Sería atómica una regla que primero consulta un AtomicInteger y después modifica otro campo? Justifica sin añadir otro mecanismo al ejercicio.

## Salida inicial esperada

```text
Esperado: 1000
Procesados: 1000
Correcto: true
incrementAndGet retorna: 1
getAndIncrement retorna: 1
Valor final del ejemplo secuencial: 2
```

Los límites admitidos son 1..16 agentes y 1..100000 mensajes por agente; no se comparan tiempos ni se mide rendimiento.

[Volver a la sesión](../../README.md)
