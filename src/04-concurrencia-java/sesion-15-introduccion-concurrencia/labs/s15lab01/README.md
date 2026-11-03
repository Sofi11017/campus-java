# Lab 01 · Disponibilidad de citas · 8 minutos

Una consulta de disponibilidad puede completarse o cancelarse. No debes anunciar un resultado disponible si la tarea salió por interrupción.

## Pasos para completar la actividad

1. Abre [S15Lab01CitasMain.java](S15Lab01CitasMain.java) y [ConsultaDisponibilidad.java](ConsultaDisponibilidad.java). Consulta-A ejecuta sin cancelar; Consulta-B usa la variable cancelarSegunda.
2. Ejecuta **Run → S15Lab01CitasMain**. Comprueba Consulta-A: COMPLETADA y Consulta-B: CANCELADA; después de cada join el hilo ya no está vivo.
3. En la clase de la tarea, localiza el catch de InterruptedException. Identifica las dos acciones: restaurar la marca con Thread.currentThread().interrupt y conservar CANCELADA como resultado. Al terminar el catch se llega al final de run.
4. En el Main cambia únicamente `boolean cancelarSegunda = true;` por `boolean cancelarSegunda = false;`. Predice el resultado y ejecuta: Consulta-B debe mostrar COMPLETADA; ambas líneas Vivo tras join siguen en false.
5. Guarda ambas salidas y restaura true. Responde: ¿qué línea solicita la cancelación y qué línea espera la terminación? No agregues sleeps en main ni cambies esperarInicio.
6. Para casa, si necesitas reforzarlo, coloca un breakpoint en el catch y sigue la salida con Step Over. Debug puede alterar la planificación; no compares tiempos exactos ni exijas observar un Thread.State transitorio.

## Salida inicial esperada

```text
Consulta-A: COMPLETADA
Vivo tras join: false
Consulta-B: CANCELADA
Vivo tras join: false
Fin: consultas de citas terminadas
```

El inicio usa una señal CountDownLatch ya preparada; no forma parte de lo que debes implementar. La interrupción se solicita al anunciarse la consulta. Si detienes main durante toda la espera con el depurador, la cancelación puede llegar después de completarse; no revierte una tarea terminada.

COMPLETADA/CANCELADA son resultados de la consulta; no son valores de Thread.State. No se consulta ese resultado desde main hasta después de join.

[Volver a la sesión](../../README.md)
