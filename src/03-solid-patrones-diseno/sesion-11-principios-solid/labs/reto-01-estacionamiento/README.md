# Reto 1 · Estacionamiento · Refactorización con SOLID

**Punto de partida:** [reto original de la sesión 3](../../../../01-fundamentos-java/sesion-03-estructuras-repetitivas/labs/reto-01-estacionamiento/README.md).

Trabaja sobre tu solución previa en tu repositorio personal. No modifiques el material docente ni comiences otro sistema. La meta es conservar el comportamiento y mejorar una responsabilidad o dependencia concreta.

Puedes usar las herramientas de Java estudiadas hasta la sesión 10; las restricciones iniciales de trabajar sin clases auxiliares o colecciones no se trasladan a esta adaptación. Usa IntelliJ y JDK 21 o 17, sin frameworks ni dependencias nuevas.

## Reglas que debes conservar

- Automóvil: 4000 pesos/hora; motocicleta: 2000. Horas enteras positivas; dinero con long.
- Automóvil tiene 10 % de descuento solo con **más de 5 horas**; moto 5 % solo con **más de 8**. En el límite exacto no hay descuento.
- Tipo u horas inválidos se corrigen sin registrar un vehículo. Cada vehículo válido aumenta sus contadores y recaudación **una sola vez**.
- Cerrar sin vehículos deja todos los totales en cero. No actives un nuevo límite diario o una tarifa adicional durante la refactorización base.

## Diagnostica antes de mover código

Ejecuta las cuatro pruebas de abajo y guarda la salida. Localiza dónde lees datos, eliges la tarifa, calculas el descuento y acumulas la jornada. Imagina dos solicitudes: cambiar el texto del menú y cambiar solo la tarifa de motocicletas. ¿Qué bloques tendrías que editar para cada una? Si ya están separados, conserva lo que funciona.

## Cambios sugeridos según SOLID

| Principio | Cambio concreto que puedes evaluar |
| --- | --- |
| **SRP** | Separa captura de datos, cálculo de cobro y resumen de jornada si están mezclados. Mantén juntos los contadores que representan el mismo estado de jornada. |
| **OCP** | Define un contrato de cálculo e implementaciones para automóvil y moto. El cliente solicita el cobro a la política recibida sin repetir un if por tipo dentro de la fórmula. El menú puede seguir seleccionando el tipo. |
| **LSP** | Ambas políticas aceptan las horas válidas acordadas, devuelven importes coherentes y no actualizan la jornada ni leen consola. Sustituir una por otra no debe exigir que el cliente adivine restricciones nuevas. |
| **ISP** | El contrato de tarifa debe ofrecer lo que necesita el calculador. No le agregues leerMenu o imprimirReporte. Si no hay una interfaz amplia innecesaria, explica por qué no necesitas dividirla. |
| **DIP** | Entrega al servicio una política de cálculo por constructor o parámetro. Main crea y conecta la implementación; el cálculo no instancia Scanner ni una tarifa concreta cada vez que opera. |

**Contrato observable:** para horas positivas dentro del rango aceptado por tu programa, importe inicial no negativo, descuento entre cero e inicial y total = inicial − descuento. El cálculo no modifica contadores ni imprime. Mantén el mismo dominio de horas en todas las políticas y valida antes de multiplicar para evitar importes desbordados.

## Pasos de refactorización

1. Guarda una versión funcional y ejecuta las pruebas originales. No renombres todo al mismo tiempo.
2. Extrae el cálculo mezclado con entrada/salida. Dale datos por parámetros y recupera un resultado; conserva exactamente las tarifas y fronteras.
3. Si tu diagnóstico justifica el punto de variación, introduce el contrato de cobro y conecta las dos políticas desde Main. Los nombres de las clases los decides tú.
4. Haz que la jornada registre el resultado válido una vez. Comprueba que cambiar la presentación no afecta ni recalcula la recaudación.
5. Ejecuta el mismo cliente con ambas políticas y repite las pruebas. No hagas casts ni captures un «no soportado» para ocultar una implementación incompatible.
6. Explica cómo conectarías otra tarifa sin editar el cliente estable. Implementarla es opcional y no debe alterar las pruebas de las tarifas originales.

## Pruebas de regresión

| Tipo | Horas | Inicial | Descuento | Total |
| --- | --- | --- | --- | --- |
| Automóvil | 5 | 20000 | 0 | 20000 |
| Automóvil | 6 | 24000 | 2400 | 21600 |
| Motocicleta | 8 | 16000 | 0 | 16000 |
| Motocicleta | 9 | 18000 | 900 | 17100 |

En una jornada con esos cuatro vehículos: **4 vehículos, 2 automóviles, 2 motos y 74700 pesos**. Prueba también tipo 7 y horas 0 sin cambios en los acumuladores; cerrar inmediatamente deja cero.

## Cómo demostrar la mejora

En tu README registra dos cambios que hoy serían costosos, una tabla **principio → problema → cambio → beneficio**, y las pruebas antes/después. Si un principio ya se respeta o no requiere otra interfaz, justifícalo: no inventes métodos vacíos para completar las cinco letras.

Indica qué archivos tocarías al conectar una variante futura y cuáles quedarían estables. Main puede cambiar para ensamblar objetos; eso no obliga a reescribir el cliente de negocio. Un esquema de dependencias o UML pequeño puede mostrar la diferencia.

Primero termina la regresión de las reglas originales. Una extensión que cambie requisitos debe probarse por separado y no sustituye las pruebas anteriores. No necesitas una arquitectura fija, un número mínimo de clases ni JUnit.

Trabaja en **este reto** durante la hora prevista: 10 minutos de diagnóstico, 15 de separación de responsabilidades, 20 para el punto de variación, 10 de pruebas y 5 de evidencia. Completa lo pendiente en casa según indique el docente.
