# Lab 00 · Factory Method · Préstamos de biblioteca

**Tiempo: 9 minutos. Código completo, sin TODO.**

## Archivos y ejecución

Lee [ComprobantePrestamo.java](ComprobantePrestamo.java) → [GestorPrestamo.java](GestorPrestamo.java) → [ComprobantePrestamoFisico.java](ComprobantePrestamoFisico.java) → [ComprobantePrestamoDigital.java](ComprobantePrestamoDigital.java) → [GestorFisico.java](GestorFisico.java) → [GestorDigital.java](GestorDigital.java) y ejecuta [S12Lab00FactoryMethodMain.java](S12Lab00FactoryMethodMain.java). Copia todos los archivos del paquete s12lab00 bajo la raíz de código de tu proyecto personal.

## Actividad paso a paso

Dos gestores registran préstamos y producen comprobantes distintos. Uno indica retiro físico y otro acceso digital. No hay catálogo, usuarios ni una plataforma real.

1. Lee ComprobantePrestamo y GestorPrestamo. Identifica el producto, el método protegido de creación y el flujo registrarPrestamo que lo utiliza.
2. Lee los dos gestores y sus productos. Antes de ejecutar, predice qué comprobante crea cada subclase y qué título aparecerá.
3. Ejecuta el Main. En Debug, entra desde registrarPrestamo a crearComprobante: observa qué implementación se selecciona sin cambiar el flujo del creador base.
4. En una copia del Main cambia ambos títulos a `POO aplicada`. Deben aparecer `Retiro en mostrador: POO aplicada` y `Acceso en plataforma: POO aplicada`. No edites gestores ni productos.
5. Explica qué creador y producto añadirías para otra modalidad, sin implementarlos. ¿Por qué un único método estático que eligiera por un String no demostraría este mismo patrón?

El título nulo o en blanco se rechaza con IllegalArgumentException. Los escenarios de la actividad usan títulos válidos; no necesitas añadir una gestión nueva de excepciones.

## Salida inicial esperada

```text
Retiro en mostrador: Java inicial
Acceso en plataforma: Java inicial
```

Guarda dos comprobaciones cortas con entrada, esperado y obtenido, y responde la pregunta conceptual. No debes construir otro patrón ni dibujar un UML completo en este tiempo. Completa lo pendiente para la siguiente clase según indique el docente.
