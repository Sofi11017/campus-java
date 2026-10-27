# Reto 2 · Créditos · Refactorización con SOLID

**Punto de partida:** [reto original de la sesión 3](../../../../01-fundamentos-java/sesion-03-estructuras-repetitivas/labs/reto-02-creditos/README.md).

Trabaja sobre tu solución previa en tu repositorio personal. No modifiques el material docente ni comiences otro sistema. La meta es conservar el comportamiento y mejorar una responsabilidad o dependencia concreta.

Puedes usar las herramientas de Java estudiadas hasta la sesión 10; las restricciones iniciales de trabajar sin clases auxiliares o colecciones no se trasladan a esta adaptación. Usa IntelliJ y JDK 21 o 17, sin frameworks ni dependencias nuevas.

## Reglas que debes conservar

- Datos de entrada: edad 0–120, ingresos y gastos 0–1000000000 pesos, crédito 1–1000000000 y meses 1–360. Los datos fuera de rango se corrigen antes de contar una evaluación.
- Solo son elegibles edades **18–70 inclusive** y disponible = ingresos − gastos positivo. Los demás casos se rechazan sin dividir por cero o por un disponible negativo.
- Endeudamiento **≤35 %** aprobado; **>35 % y ≤45 %** revisión manual; **>45 %** rechazado. Clasifica y cuenta una sola vez.
- Dentro de los rangos indicados, puedes conservar la comparación exacta de `credito * 100` con `disponible * meses * 35` y `disponible * meses * 45`, usando long. Una cuota truncada para mostrar nunca decide la categoría.
- No agregues intereses, puntaje o umbrales nuevos durante la refactorización. Es un modelo didáctico sin intereses ni comisiones.

## Diagnostica antes de mover código

Ejecuta los seis casos de abajo. Localiza validación de entrada, elegibilidad, evaluación de razón, contadores y presentación. Imagina cambiar los mensajes del menú y sustituir la política de endeudamiento de una cooperativa por otra. ¿Afectan hoy el mismo bloque? No supongas que toda solución necesita la misma extracción.

## Cambios sugeridos según SOLID

| Principio | Cambio concreto que puedes evaluar |
| --- | --- |
| **SRP** | Separa reintentos de captura, evaluación y resumen. La evaluación recibe una solicitud con datos válidos y devuelve una decisión; no pide nuevamente la edad. |
| **OCP** | Aísla una política de endeudamiento si esa regla es el cambio previsto. El flujo de solicitudes y el reporte no deberían reescribirse al conectar otra política. La política original conserva 35/45. |
| **LSP** | Para toda solicitud dentro del dominio, el evaluador devuelve una sola clasificación y motivo coherente, sin pedir datos, alterar contadores ni rechazar como «no soportado» una entrada prometida. Las políticas no pueden saltarse elegibilidad obligatoria. |
| **ISP** | El cliente de evaluación no necesita imprimir, almacenar ni corregir entradas. No lo obligues a depender de esas operaciones mediante una interfaz universal. |
| **DIP** | El coordinador recibe el contrato de evaluación o de política y Main suministra la implementación. No crees la regla concreta dentro del método de negocio que quieres sustituir o probar. |

**Contrato observable:** resultado único para cada solicitud válida, sin efectos de consola ni cambios de conteo. Si separas la elegibilidad de la política de razón, deja explícito quién rechaza edad no elegible o disponible no positivo antes de invocar el cálculo.

## Pasos de refactorización

1. Guarda la versión funcional y los seis resultados originales. Anota el método o bloque que quieres poder cambiar sin afectar los demás.
2. Extrae la evaluación de los bucles de Scanner. Conserva los rangos y la precisión; no rediseñes simultáneamente el formato de todos los mensajes.
3. Define qué datos recibe la política, qué devuelve y qué casos garantiza. Si recibe solo disponible, crédito y meses válidos, el coordinador debe haber comprobado primero la elegibilidad.
4. Conecta la política original desde Main y actualiza los contadores a partir de una única decisión. Un dato corregido no es una solicitud adicional.
5. Repite los casos y compara conteos. Un evaluador controlado puede ayudarte a comprobar el reporte; no uses sus resultados como sustituto de probar la evaluación real.
6. Describe qué cambiaría al introducir otra política y qué pruebas comunes debe cumplir. Probar nuevos umbrales es opcional y debe hacerse separado del comportamiento original.

## Pruebas de regresión

| Edad | Ingresos | Gastos | Crédito | Meses | Resultado |
| --- | --- | --- | --- | --- | --- |
| 30 | 3000000 | 1800000 | 6000000 | 12 | REVISIÓN MANUAL, aproximadamente 41.67 % |
| 30 | 1000000 | 0 | 350000 | 1 | APROBADA, exactamente 35 % |
| 30 | 1000000 | 0 | 450000 | 1 | REVISIÓN MANUAL, exactamente 45 % |
| 30 | 1000000 | 0 | 450001 | 1 | RECHAZADA, supera 45 % |
| 17 | 1000000 | 0 | 100000 | 1 | RECHAZADA por edad |
| 30 | 1000000 | 1000000 | 100000 | 1 | RECHAZADA sin dividir |

Resumen: **6 evaluadas, 1 aprobada, 2 en revisión y 3 rechazadas**. Meses 0 se corrige antes de evaluar; cerrar sin solicitudes deja ceros. Comprueba además que 18 y 70 son edades elegibles cuando los demás requisitos se cumplen.

## Cómo demostrar la mejora

En tu README registra dos cambios que hoy serían costosos, una tabla **principio → problema → cambio → beneficio**, y las pruebas antes/después. Si un principio ya se respeta o no requiere otra interfaz, justifícalo: no inventes métodos vacíos para completar las cinco letras.

Indica qué archivos tocarías al conectar una variante futura y cuáles quedarían estables. Main puede cambiar para ensamblar objetos; eso no obliga a reescribir el cliente de negocio. Un esquema de dependencias o UML pequeño puede mostrar la diferencia.

Primero termina la regresión de las reglas originales. Una extensión que cambie requisitos debe probarse por separado y no sustituye las pruebas anteriores. No necesitas una arquitectura fija, un número mínimo de clases ni JUnit.

Trabaja en **este reto** durante la hora prevista: 10 minutos de diagnóstico, 15 de separación de responsabilidades, 20 para el punto de variación, 10 de pruebas y 5 de evidencia. Completa lo pendiente en casa según indique el docente.
