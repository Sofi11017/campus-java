# Lab 01 · Detener un sensor simulado · 10 minutos

Un trabajador genera lotes de mediciones calculadas. El controlador pide detenerlo con una bandera volatile. No hay un sensor real ni operaciones de entrada/salida.

## Pasos para completar la actividad

1. Abre [SensorSimulado.java](SensorSimulado.java) y [S16Lab01SensorMain.java](S16Lab01SensorMain.java). Localiza activo, solicitarDetencion y la comprobación !activo en run.
2. Ejecuta **Run → S16Lab01SensorMain**. Espera DETENIDO_POR_BANDERA, Resumen coherente: true y Hilo vivo: false. Anota los lotes y las muestras observados, que no tienen un valor fijo.
3. Identifica qué se comparte: el controlador escribe activo y el trabajador lo lee. Lotes, muestras y suma los modifica solamente el trabajador; main los consulta después de join.
4. En el Main cambia solo `final int TAMANO_LOTE = 64;` por `final int TAMANO_LOTE = 128;`. No quites volatile ni cambies el apoyo de inicio.
5. Ejecuta otra vez. Comprueba que muestras=lotes×128 y Resumen coherente: true. No esperes que el número de lotes coincida con la primera ejecución; guarda la salida.
6. Coloca un breakpoint en solicitarDetencion y localiza en el trabajador dónde podrá atender la señal. Explica en una frase por qué aumentar el lote podría retrasar la respuesta y por qué volatile no despierta un hilo bloqueado en otra operación.
7. Si aparece LIMITE_DE_SEGURIDAD, el cálculo alcanzó el límite antes de observar la petición. No lo registres como parada por bandera; repite sin pausar main en Debug y conserva la explicación.

## Formato esperado

```text
Resultado: DETENIDO_POR_BANDERA
Lotes: N
Muestras: M
Resumen coherente: true
Hilo vivo: false
```

N y M representan números variables; no se imprimen esas letras. Inicialmente M=N×64; después del cambio M=N×128. No se exige un número idéntico en ejecuciones repetidas.

El latch comunica el primer lote del trabajador hacia main. La petición de parada viaja por la bandera; join espera el cierre. No agregues sleep, println por vuelta ni otro bloqueo que oculte esa comparación.

[Volver a la sesión](../../README.md)
