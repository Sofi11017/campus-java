# Lab 03 · Composite · Ruta formativa · 15 minutos

Una ruta contiene módulos y lecciones. Calcula la duración con la misma operación para elementos individuales y grupos.

## Pasos para completar la actividad

1. Abre **S13Lab03CompositeMain.java**. introduccion es un módulo con lecciones de 10 y 20 minutos; ruta contiene ese módulo y otra lección de 15. Predice los totales del módulo vacío, introduccion y ruta.
2. Ejecuta **Run → S13Lab03CompositeMain**. Compara con la salida: 0, 30 y 45 minutos. El intento final de añadir ruta dentro de introduccion debe rechazarse porque formaría un ciclo.
3. Lee ElementoFormativo.java, Leccion.java y ModuloFormativo.java. Localiza dónde una hoja devuelve minutos y dónde el compuesto recorre sus elementos y suma.
4. En el Main, inmediatamente después de añadir la lección de 15 minutos a ruta, agrega `introduccion.agregarElementoFormativo(new Leccion(5));`. Predice y ejecuta: introduccion debe dar 35 y ruta 50. El módulo vacío sigue mostrando 0 porque se imprimió antes de agregar lecciones.
5. Coloca un breakpoint en calcularMinutos de ModuloFormativo y usa Step Into para seguir la llamada del módulo ruta al módulo introduccion y a sus hojas. Observa el retorno de cada subtotal.
6. Guarda la salida nueva y dibuja un árbol sencillo de los dos módulos y sus cuatro lecciones. Explica qué ocurriría con la recursión si se permitiera el ciclo y cuándo bastaría una lista plana sin Composite.

## Salida inicial esperada

```text
Modulo vacio: 0
Introduccion: 30
Ruta: 45
Ciclo rechazado
```

[Volver a la sesión](../../README.md) · [Abrir el programa](S13Lab03CompositeMain.java)
