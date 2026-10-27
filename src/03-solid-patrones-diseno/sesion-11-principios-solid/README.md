# Sesión 11 · Aplicar SOLID a los retos de la sesión 3

Trabajaremos sobre **la solución que ya desarrollaste** de estacionamiento, créditos, control de calidad o restaurante. El objetivo es mejorar su estructura conservando las reglas y los resultados. No hay demos ni nuevos problemas independientes.

Elige el reto que resolviste o el que indique el docente. **No tienes que refactorizar los cuatro en una hora.** Si aún no tienes una solución funcional, recupérala o complétala antes de comenzar esta adaptación.

| Tu reto anterior | Guía de refactorización |
| --- | --- |
| Estacionamiento | [Responsabilidades y políticas de cobro](labs/reto-01-estacionamiento/README.md) |
| Créditos | [Evaluación, precisión y dependencias](labs/reto-02-creditos/README.md) |
| Control de calidad | [Clasificación y seguimiento del lote](labs/reto-03-calidad/README.md) |
| Restaurante | [Pedido, descuento y cuenta](labs/reto-04-restaurante/README.md) |

## Qué cambia en esta sesión

Puedes usar clases, objetos, interfaces, enum y colecciones ya estudiados cuando ayuden a resolver un problema de diseño. Las restricciones de la sesión 3 de resolver ciertos retos dentro de un solo main eran propias de aquel nivel; no limitan esta refactorización.

Mantén los enunciados y materiales originales del docente. Trabaja en una copia o versión de tu repositorio personal con IntelliJ IDEA y JDK 21 o 17. No necesitas Maven, Gradle, frameworks, persistencia ni patrones de diseño nuevos.

## Cómo usar SOLID con criterio

| Principio | Pregunta para revisar tu solución |
| --- | --- |
| **SRP · Responsabilidad única** | ¿Cambiar el menú obliga a tocar cálculos o contadores que no deberían cambiar? |
| **OCP · Abierto/cerrado** | ¿Dónde hay una variación real que podría cambiar sin reescribir el flujo estable? |
| **LSP · Sustitución** | ¿Todas las implementaciones cumplen las mismas condiciones, resultados y efectos prometidos? |
| **ISP · Segregación de interfaces** | ¿Un cliente depende de operaciones que no necesita o una clase debe fingir que las soporta? |
| **DIP · Inversión de dependencias** | ¿Las reglas de negocio dependen directamente de consola o implementaciones concretas que conviene sustituir? |

No debes crear una clase por método ni una interfaz por cada letra. Las guías de cada reto sugieren cambios; elige los que solucionen un problema que puedas demostrar. Si un principio ya se respeta o no justifica otra extracción, explícalo con evidencia.

SRP no significa tener un solo método. OCP no prohíbe modificar código ni exige borrar todos los if. LSP no se demuestra solo con extends u Override. ISP no busca la máxima cantidad de interfaces. DIP necesita un contrato útil entre política y detalle; recibir por constructor una dependencia concreta no demuestra por sí solo inversión de dependencias.

## Trabajo en clase: máximo una hora sobre un reto

| Minutos | Acción |
| --- | --- |
| 0–10 | Ejecutar los casos originales y diagnosticar dos cambios difíciles. |
| 10–25 | Separar responsabilidades que estén mezcladas, conservando el comportamiento. |
| 25–45 | Mejorar un punto de variación, definir su contrato y conectarlo desde Main. |
| 45–55 | Repetir las pruebas y comprobar límites, rechazos y contadores. |
| 55–60 | Guardar antes/después y explicar el beneficio y el costo del cambio. |

Haz cambios pequeños y ejecuta después de cada extracción. Main puede seguir creando objetos y seleccionando las implementaciones: ese es el punto de ensamblaje. La lógica de negocio que quieres probar debe poder trabajar sin pedir datos por Scanner ni imprimir sus cálculos.

Una nueva tarifa o política que cambie resultados es **un cambio de requisito**, no la refactorización base. Si la exploras después, mantén la implementación original y sus pruebas como referencia.

## Evidencia breve de la mejora

En tu README personal incluye:

1. Dos solicitudes de cambio concretas y dónde se mezclaban sus responsabilidades.
2. Una tabla con principio considerado, problema observado, cambio realizado y beneficio. Puedes indicar «sin cambio adicional» si lo justificas.
3. Los mismos casos de prueba antes y después, con sus resultados. No elimines casos que empezaron a fallar.
4. Los archivos que cambiarían para conectar una nueva variante; distingue el ensamblaje de la lógica estable. Un pequeño UML o esquema de dependencias antes/después puede ayudarte.
5. Un costo o alternativa más simple que consideraste. El diseño debe seguir siendo entendible.

No se exige un número de clases, interfaces ni un sistema nuevo de pruebas. Puedes validar con un Main de pruebas y comparaciones verificables. Completa lo pendiente en casa y comparte el enlace de tu repositorio por Campus según indique el docente.
