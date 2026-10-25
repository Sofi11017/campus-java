# Reto 4 · Restaurante · Refactorización con SOLID

**Punto de partida:** [reto original de la sesión 3](../../../../01-fundamentos-java/sesion-03-estructuras-repetitivas/labs/reto-04-restaurante/README.md).

Trabaja sobre tu solución previa en tu repositorio personal. No modifiques el material docente ni comiences otro sistema. La meta es conservar el comportamiento y mejorar una responsabilidad o dependencia concreta.

Puedes usar las herramientas de Java estudiadas hasta la sesión 10; las restricciones iniciales de trabajar sin clases auxiliares o colecciones no se trasladan a esta adaptación. Usa IntelliJ y JDK 21 o 17, sin frameworks ni dependencias nuevas.

## Reglas que debes conservar

- Hamburguesa 18000, pizza 25000, ensalada 15000 y bebida 6000 pesos. Cantidades enteras positivas; dinero y acumulaciones con long.
- Unidades cuenta productos individuales, no selecciones de menú. Opción inválida o cantidad rechazada no cambia el pedido.
- Un único descuento: **15 % si subtotal>150000**; si no, **10 % si subtotal>100000**; en los demás casos cero. Exactamente 150000 tiene 10 % y exactamente 100000 no tiene descuento.
- Conserva tu decisión documentada de domicilio sobre subtotal o neto: 5000 cuando el importe elegido sea menor que 30000. Pedido vacío no paga domicilio.
- Neto = subtotal − descuento y total = neto + domicilio. No agregues impuestos, nuevos precios ni servicios reales durante la refactorización.

## Diagnostica antes de mover código

Ejecuta las seis filas de abajo como pedidos separados. Localiza menú, acumulación, descuento, domicilio y cuenta final. Imagina cambiar el texto del menú y cambiar solo la política de descuento. Señala qué partes de tu código afectarían hoy ambas peticiones.

## Cambios sugeridos según SOLID

| Principio | Cambio concreto que puedes evaluar |
| --- | --- |
| **SRP** | Separa captura, estado del pedido, reglas de cuenta y presentación cuando tengan motivos de cambio distintos. No crees una clase por cada suma o línea impresa. |
| **OCP** | El cliente que calcula la cuenta puede usar una política de descuento sin conocer todas sus variantes. Registrar productos o sumar neto y domicilio no debería reescribirse al conectar otra política. |
| **LSP** | La política acepta el subtotal válido acordado y devuelve un descuento entre cero y subtotal, sin cambiar unidades ni agregar domicilio. Todas las variantes aceptadas deben cumplir ese contrato. |
| **ISP** | La política no necesita imprimir menú, registrar clientes ni despachar productos. Evita un contrato universal que exija esas funciones o deje métodos vacíos. |
| **DIP** | El servicio recibe la política necesaria desde Main, en lugar de construir la regla concreta o Scanner dentro del cálculo. El detalle de presentación no debe determinar cómo se calcula el descuento. |

**Contrato observable:** descuento válido para todo subtotal permitido, cero para pedido vacío en el conjunto de políticas de este ejercicio y ningún cambio en productos o unidades. La regla de domicilio conserva la base que elegiste. No presentes el método como una política de porcentaje si el contrato real solo promete un importe de descuento.

## Pasos de refactorización

1. Guarda una versión funcional y los resultados de las seis filas. Anota qué quieres poder cambiar de manera independiente.
2. Extrae las reglas mezcladas con el menú. El pedido conserva su estado; las operaciones de cálculo reciben datos y devuelven resultados, sin pedir nuevas cantidades.
3. Si está justificado, introduce el contrato de descuento y conecta la política original desde Main. Separa domicilio solo si aporta una responsabilidad o variación real, no para aumentar la cantidad de interfaces.
4. Conserva el orden: calcular subtotal, descuento, neto, domicilio y total. No permitas que una política vuelva a agregar productos o cobre el domicilio dos veces.
5. Ejecuta regresión y comprueba los límites. Un colaborador controlado puede ayudar a probar cómo se arma la cuenta, pero no reemplaza las pruebas de la política comercial original.
6. Describe qué archivos cambiarías para otra promoción y cuáles permanecerían iguales. Si implementas esa promoción como ampliación, mantenla separada de los casos base y documenta el nuevo requisito.

## Pruebas de regresión

Cada fila representa un pedido nuevo.

| Productos | Unidades | Subtotal | Descuento | Domicilio | Total |
| --- | --- | --- | --- | --- | --- |
| Bebida × 1 | 1 | 6000 | 0 | 5000 | 11000 |
| Ensalada × 2 | 2 | 30000 | 0 | 0 | 30000 |
| Pizza × 4 | 4 | 100000 | 0 | 0 | 100000 |
| Pizza × 6 | 6 | 150000 | 15000 | 0 | 135000 |
| Pizza × 7 | 7 | 175000 | 26250 | 0 | 148750 |
| Hamburguesa × 4 y pizza × 2 | 6 | 122000 | 12200 | 0 | 109800 |

Finalizar inmediatamente produce todos los valores en cero. Opción 7 y cantidad −2 se corrigen sin alterar acumuladores. Para estos precios y umbrales, las dos bases admitidas para domicilio producen los mismos resultados de la tabla; conserva y explica tu elección igualmente.

## Cómo demostrar la mejora

En tu README registra dos cambios que hoy serían costosos, una tabla **principio → problema → cambio → beneficio**, y las pruebas antes/después. Si un principio ya se respeta o no requiere otra interfaz, justifícalo: no inventes métodos vacíos para completar las cinco letras.

Indica qué archivos tocarías al conectar una variante futura y cuáles quedarían estables. Main puede cambiar para ensamblar objetos; eso no obliga a reescribir el cliente de negocio. Un esquema de dependencias o UML pequeño puede mostrar la diferencia.

Primero termina la regresión de las reglas originales. Una extensión que cambie requisitos debe probarse por separado y no sustituye las pruebas anteriores. No necesitas una arquitectura fija, un número mínimo de clases ni JUnit.

Trabaja en **este reto** durante la hora prevista: 10 minutos de diagnóstico, 15 de separación de responsabilidades, 20 para el punto de variación, 10 de pruebas y 5 de evidencia. Completa lo pendiente en casa según indique el docente.
