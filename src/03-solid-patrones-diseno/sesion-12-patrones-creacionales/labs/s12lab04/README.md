# Lab 04 · Singleton · Métricas de laboratorio

**Tiempo: 8 minutos. Código completo, sin TODO.**

## Archivos y ejecución

Lee [ContadorMetricas.java](ContadorMetricas.java) → [ProcesoLaboratorio.java](ProcesoLaboratorio.java) y ejecuta [S12Lab04SingletonMain.java](S12Lab04SingletonMain.java). Copia todos los archivos del paquete s12lab04 bajo la raíz de código de tu proyecto personal.

## Actividad paso a paso

Dos procesos lógicos registran eventos en un contador compartido. No son procesos del sistema operativo ni hilos: el ejemplo ejecuta todo secuencialmente en una sola JVM.

1. Lee constructor privado, instancia static final y obtenerInstancia. Predice si primera y segunda son dos objetos o dos referencias.
2. Ejecuta el Main con Run en una **JVM nueva**. Proceso A registra 2 eventos y B registra 1; ambos observan total 3.
3. Identifica cómo ProcesoLaboratorio recibe el contador por constructor. No obtiene el global por su cuenta ni crea otro contador.
4. En una copia del Main cambia las cantidades a 1 y 1. Vuelve a ejecutar desde cero: total inicial 0 y total final 2 desde ambas referencias. No añadas un reset público ni invoques dos veces Main en la misma JVM para esta prueba.
5. Explica en una frase qué dificultaría el estado global en pruebas y cuándo preferirías un contador normal entregado por ejecución.

No se implementa concurrencia. La creación de la instancia está inicializada con seguridad, pero total++ **no promete seguridad con varios hilos**. La unicidad no abarca otras JVM o máquinas.

## Salida inicial esperada

```text
Misma instancia: true
Total inicial: 0
Total desde A: 3
Total desde B: 3
```

Guarda dos comprobaciones cortas con entrada, esperado y obtenido, y responde la pregunta conceptual. No debes construir otro patrón ni dibujar un UML completo en este tiempo. Completa lo pendiente para la siguiente clase según indique el docente.
