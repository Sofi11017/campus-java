0# Reto 3 · Control de producción y calidad

**Sector:** manufactura. **Nivel:** intermedio. Integra repetición, contadores, acumulación, decisiones y salida anticipada.

El supervisor necesita inspeccionar las medidas de un lote y detener la línea si detecta tres rechazos consecutivos. El docente asignará el reto; termina lo pendiente para la siguiente clase.

## Antes de programar

1. ¿Qué dato indica cuántas inspecciones habrá como máximo?
2. ¿Qué diferencia hay entre rechazadas totales y consecutivas?
3. ¿Qué reinicia la racha de rechazos?
4. Si detienes antes de terminar el lote, ¿qué cantidad debe usarse para el promedio?

## Lo que debes construir

1. Crea `S03Reto03Calidad` con main y Scanner. Solicita cantidad de piezas como entero mayor que cero. Corrige valores inválidos antes de comenzar.
2. Para cada pieza solicita una medida positiva y finita en milímetros. Usa punto decimal, por ejemplo 9.8. Si el dato no es válido, vuelve a pedirlo para la misma pieza: no incrementes inspeccionadas ni cambies la racha.
3. Clasifica exactamente una vez cada medida válida: **aprobada de 9.8 a 10.2 inclusive**; **reprocesar desde 9.5 hasta menos de 9.8, o mayor que 10.2 hasta 10.5 inclusive**; **rechazada fuera de 9.5–10.5**.
4. Aumenta inspeccionadas, el contador de su categoría y la suma de medidas. Elige el ciclo que consideres adecuado y justifica tu elección; no uses arrays para guardar el lote.
5. Si la pieza es rechazada, aumenta rechazadasConsecutivas. Si es aprobada o va a reproceso, reinicia esa racha a cero. No reinicies rechazadas totales.
6. Al llegar a tres rechazos consecutivos, muestra `ALERTA: detener la linea de produccion.` y deja de pedir nuevas medidas. La tercera rechazada cuenta como inspeccionada y entra en el promedio.
7. Muestra piezas realmente inspeccionadas, aprobadas, reproceso y rechazadas. Calcula aprobación como `100.0 * aprobadas / inspeccionadas` y promedio como `sumaMedidas / inspeccionadas`, usando double para las medidas y las razones.
8. Si se detuvo temprano, no uses el tamaño original del lote como divisor. La suma de las tres categorías debe ser igual a inspeccionadas.

No hay obligación de usar continue; no lo añadas si vuelve menos clara la actualización de contadores. No necesitas métodos auxiliares, POO ni colecciones.

## Pruebas mínimas

| Lote y medidas, en orden | Resultado esperado |
| --- | --- |
| 6 piezas: 9.5, 9.8, 10.0, 10.2, 10.5, 10.6 | 6 inspeccionadas; 3 aprobadas; 2 reproceso; 1 rechazada; aprobación 50 %; promedio 10.1 mm |
| 5 piezas: 9.4, 10.6, 10.7 | Alerta y parada tras la tercera; 3 inspeccionadas, todas rechazadas; aprobación 0 %; promedio aproximado 10.2333 mm; no pedir medidas 4 y 5 |
| 4 piezas: 9.4, 10.6, 10.0, 9.4 | 4 inspeccionadas; 1 aprobada; 3 rechazadas; sin alerta: no hubo tres consecutivas |

Prueba además cantidad=0 y medida=0: deben corregirse sin contar una inspección. Se acepta una presentación razonable de decimales; no se exige que el texto del promedio tenga un número fijo de cifras.

## Extensión opcional

Registra mínimo y máximo sin arrays. Inicialízalos con la primera medida válida e incluye también la tercera pieza rechazada cuando provoque la parada.

## Entrega

Publica la clase y un README con decisiones y pruebas mínimas en tu repositorio personal; entrega el enlace por Campus. Explica qué ciclo elegiste y cómo garantizas la parada. Validar letras o tokens no numéricos es opcional.
