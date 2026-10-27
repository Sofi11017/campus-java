# Reto 3 · Control de calidad · Refactorización con SOLID

**Punto de partida:** [reto original de la sesión 3](../../../../01-fundamentos-java/sesion-03-estructuras-repetitivas/labs/reto-03-calidad/README.md).

Trabaja sobre tu solución previa en tu repositorio personal. No modifiques el material docente ni comiences otro sistema. La meta es conservar el comportamiento y mejorar una responsabilidad o dependencia concreta.

Puedes usar las herramientas de Java estudiadas hasta la sesión 10; las restricciones iniciales de trabajar sin clases auxiliares o colecciones no se trasladan a esta adaptación. Usa IntelliJ y JDK 21 o 17, sin frameworks ni dependencias nuevas.

## Reglas que debes conservar

- Cantidad máxima del lote positiva; medidas positivas y finitas. Un dato inválido se corrige para la misma pieza sin aumentar contadores ni cambiar la racha.
- Aprobada: **9.8–10.2 inclusive**. Reproceso: **9.5–<9.8** o **>10.2–10.5**. Rechazada: fuera de 9.5–10.5.
- Tres rechazos consecutivos detienen el proceso. Aprobación **o reproceso** reinician la racha; no reinician rechazos totales.
- La tercera rechazada cuenta en inspeccionadas, suma y promedio. Se divide por las piezas **realmente inspeccionadas**, no por la cantidad máxima del lote.

## Diagnostica antes de mover código

Ejecuta las tres secuencias de abajo. Localiza lectura, clasificación, racha, totales y reporte. Imagina cambiar los intervalos de calidad y cambiar el formato del reporte sin tocar la detención. Identifica qué dependencias dificultarían hacerlo en tu solución.

## Cambios sugeridos según SOLID

| Principio | Cambio concreto que puedes evaluar |
| --- | --- |
| **SRP** | Separa captura de mediciones, criterio de clasificación, seguimiento de lote y presentación cuando estén mezclados. Mantén la racha y las actualizaciones que deben ser coherentes bajo una responsabilidad clara. |
| **OCP** | El seguimiento del lote recibe un criterio y usa su clasificación. Un criterio futuro puede cambiar sin reescribir la suma, los contadores y la parada por tres rechazos. |
| **LSP** | Un criterio acepta todas las medidas positivas y finitas acordadas y devuelve exactamente una categoría. No cambia el lote, no pide otro dato ni lanza «no soportado» ante una medida válida. |
| **ISP** | El contrato del criterio necesita clasificar, no imprimir reportes ni detener físicamente una máquina. No agregues esas funciones solo para uniformar componentes. |
| **DIP** | Recibe el criterio en el procesador de lote, conectado desde Main. No mezcles la regla de negocio con Scanner o con un criterio concreto creado dentro del recorrido. |

**Contrato observable:** una medida válida produce una categoría, sin efectos sobre los acumuladores. El procesador, no el criterio, registra esa categoría y decide si continúa. El rechazo de una entrada inválida no debe confundirse con la categoría RECHAZADA de una pieza válida.

## Pasos de refactorización

1. Conserva una versión y registra las tres secuencias originales. Señala qué bloque mezcla una regla de calidad con el control del lote.
2. Extrae la clasificación; dale una medida por parámetro y recupera su categoría. Mantén los límites inclusivos y exclusivos exactos.
3. Define el contrato y entrega el criterio original al procesador desde Main. Decide con claridad dónde se valida que la medida sea positiva y finita.
4. Deja que el seguimiento actualice una sola vez contadores, suma y racha. Al llegar a tres rechazos, no solicites otra medición.
5. Ejecuta regresión. Para aislar la racha puedes usar un criterio controlado que entregue categorías previstas, pero sigue probando aparte las fronteras numéricas del criterio real.
6. Explica cómo conectarías otro criterio sin cambiar el recorrido estable. No implementes sensores, archivos o alarmas externas para demostrar DIP.

## Pruebas de regresión

| Lote y medidas | Resultado que debe conservarse |
| --- | --- |
| 6: 9.5, 9.8, 10.0, 10.2, 10.5, 10.6 | 6 inspeccionadas; 3 aprobadas; 2 reproceso; 1 rechazo; 50 % de aprobación; promedio 10.1 mm |
| Máximo 5: 9.4, 10.6, 10.7 | Alerta y parada en la tercera; 3 inspeccionadas; 3 rechazadas; promedio aproximado 10.2333 mm; no pedir piezas 4 y 5 |
| 4: 9.4, 10.6, 10.0, 9.4 | 4 inspeccionadas; 1 aprobada; 3 rechazadas; sin alerta |

Cantidad 0, medida 0, NaN e infinito no deben registrarse como inspección. Comprueba también que una pieza de reproceso interrumpe la racha: 9.4, 10.6, 9.5, 10.7 no debe activar la alerta.

## Cómo demostrar la mejora

En tu README registra dos cambios que hoy serían costosos, una tabla **principio → problema → cambio → beneficio**, y las pruebas antes/después. Si un principio ya se respeta o no requiere otra interfaz, justifícalo: no inventes métodos vacíos para completar las cinco letras.

Indica qué archivos tocarías al conectar una variante futura y cuáles quedarían estables. Main puede cambiar para ensamblar objetos; eso no obliga a reescribir el cliente de negocio. Un esquema de dependencias o UML pequeño puede mostrar la diferencia.

Primero termina la regresión de las reglas originales. Una extensión que cambie requisitos debe probarse por separado y no sustituye las pruebas anteriores. No necesitas una arquitectura fija, un número mínimo de clases ni JUnit.

Trabaja en **este reto** durante la hora prevista: 10 minutos de diagnóstico, 15 de separación de responsabilidades, 20 para el punto de variación, 10 de pruebas y 5 de evidencia. Completa lo pendiente en casa según indique el docente.
