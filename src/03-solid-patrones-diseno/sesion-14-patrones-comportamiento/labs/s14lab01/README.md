# Lab 01 · Observer · Cupos académicos · 12 minutos

Publicación síncrona en memoria. Una misma instancia no se suscribe dos veces. El recorrido usa una copia: cambiar suscripciones durante una publicación afecta la siguiente. Solo se maneja la excepción específica simulada; esto no garantiza entrega distribuida ni realiza reintentos.

## Pasos para completar la actividad

1. Abre **S14Lab01ObserverMain.java**. Identifica los cuatro suscriptores: Ana, Luis, el canal con fallo y el tablero. Predice cuántas entregas serán exitosas antes y después de retirar a Luis.
2. Ejecuta **Run → S14Lab01ObserverMain**. Compara con la salida: 3 entregas iniciales, 2 después de la baja y 0 sin observadores. El error simulado se imprime, pero el tablero recibe el aviso.
3. Lee ObservadorCupo.java, EventoCupo.java y PublicadorCupos.java. Localiza suscribir, retirar y publicar. El publicador conoce el contrato, no los nombres de estudiantes.
4. En el Main cambia únicamente `curso.retirar(luis)` por `curso.retirar(ana)`. Predice quién recibirá la segunda publicación. Ejecuta: las entregas siguen siendo 2; en la segunda publicación aparece Luis y deja de aparecer Ana.
5. Coloca un breakpoint en publicar. Usa Debug y Step Over para observar el incremento de entregas; cuando ocurre FalloAvisoException no debe incrementarse.
6. Guarda la salida modificada. Explica por qué un aviso fallido no significa que no exista cupo y cuándo sería suficiente una llamada directa a un único destinatario.

## Salida inicial esperada

```text
Ana: cupo en Java
Luis: cupo en Java
Fallo de entrega: Canal temporalmente no disponible
Tablero: cupo en Java
Entregas: 3
Ana: cupo en Java
Fallo de entrega: Canal temporalmente no disponible
Tablero: cupo en Java
Tras baja: 2
Vacio: 0
```

[Abrir el programa](S14Lab01ObserverMain.java) · [Volver a la sesión](../../README.md)
