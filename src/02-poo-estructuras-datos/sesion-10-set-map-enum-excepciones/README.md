# Sesión 10 · Set, Map, enum y excepciones

Cuatro demos acompañan la explicación y cuatro labs **completamente codificados** permiten practicar en contextos distintos. En los labs debes predecir, ejecutar, cambiar datos de prueba y explicar resultados; no hay TODO ni una aplicación que construir desde cero.

## Preparación y orden

Usa IntelliJ IDEA con JDK 21 o 17, sin Maven ni Gradle. Marca `demo/` y `labs/` de esta sesión como **Sources Root**. Conserva los paquetes `s10demo00` a `s10demo03` y `s10lab00` a `s10lab03` bajo sus raíces. Si copias los ejemplos a otro proyecto, conserva esas carpetas bajo su `src`.

| Orden | Tema | Demo ejecutable | Lab |
| --- | --- | --- | --- |
| 00 | Set | [Correos únicos](demo/s10demo00/S10Demo00SetMain.java) | [Materiales pendientes](labs/s10lab00/README.md) |
| 01 | Map | [Agenda por código](demo/s10demo01/S10Demo01MapMain.java) | [Recuento de votos](labs/s10lab01/README.md) |
| 02 | Enum | [Días laborables](demo/s10demo02/S10Demo02EnumMain.java) | [Prioridad de incidencias](labs/s10lab02/README.md) |
| 03 | Excepciones | [Conversión y división](demo/s10demo03/S10Demo03ExcepcionesMain.java) | [Carga de mediciones](labs/s10lab03/README.md) |

## Demo 00 · Set: pertenencia única

Ejecuta el Main y observa el resultado booleano de `add`. La normalización de correos es una regla del ejemplo: quitar espacios externos y convertir a minúsculas con Locale.ROOT. No pretende validar direcciones reales.

```text
Agregar Luis: true
Agregar Ana: true
Repetir Ana: false
Orden de llegada: [luis@ejemplo.test, ana@ejemplo.test]
Orden natural: [ana@ejemplo.test, luis@ejemplo.test]
HashSet mismo contenido: true
Cantidad: 2
Contiene Ana: true
Retirar Ana: true
Queda: [luis@ejemplo.test]
```

Predice el tamaño antes de ejecutar. Compara LinkedHashSet (inserción) con TreeSet (orden natural). HashSet **no garantiza orden**, aunque observes uno estable en tu equipo; por eso el demo comprueba contenido y tamaño sin prometer una secuencia. No uses índices para consultar un Set.

En estructuras hash, la igualdad de objetos propios requiere equals/hashCode coherentes. TreeSet utiliza comparación igual a cero para decidir equivalencia. Aquí usamos String para centrarnos en las operaciones, sin comparadores propios.

## Demo 01 · Map: clave y valor

Ejecuta el Main. `put` puede crear o reemplazar una asociación y devuelve el valor previo; `putIfAbsent` evita reemplazar un valor existente no nulo. La agenda de este ejemplo no guarda valores null.

```text
Primer put: null
Valor reemplazado: Ana
putIfAbsent devuelve: Andrea
Valor actual P-01: Andrea
Existe P-99: false
Consulta P-99: null
Cantidad: 2
P-01 -> Andrea
P-02 -> Luis
Claves por llegada: [P-02, P-01]
```

Sigue en Debug el reemplazo de P-01. La clave no se duplica y el tamaño no aumenta. El reporte recorre `entrySet()` de una **copia TreeMap** para ordenar por clave. LinkedHashMap ilustra orden de llegada; HashMap no lo garantiza.

Map no extiende Collection. `get` puede devolver null por ausencia y, si se permiten valores null, también por una asociación con ese valor: `containsKey` distingue ambos casos. `keySet`, `values` y `entrySet` son vistas del mapa, no copias independientes.

## Demo 02 · Enum: opciones cerradas

Lee primero [DiaSemana.java](demo/s10demo02/DiaSemana.java), con constantes, campo final, constructor y consulta. Después ejecuta el Main.

```text
LUNES laborable=true
MARTES laborable=true
MIERCOLES laborable=true
JUEVES laborable=true
VIERNES laborable=true
SABADO laborable=false
DOMINGO laborable=false
Comparar lunes: true
Entrada aceptada: LUNES
Dia desconocido: FESTIVO
```

El modelo considera laborables lunes a viernes; no incorpora calendarios regionales. `DiaSemana.values()` entrega las constantes; `name()` entrega el identificador y `valueOf` exige coincidencia exacta. El programa normaliza antes de convertir y captura IllegalArgumentException para una opción desconocida. Nulo/blanco se valida antes.

Compara constantes con `==`. No guardes `ordinal()` como código de negocio: cambia si reordenas constantes. `values()` se genera para el enum y se invoca mediante el nombre del tipo. Su constructor no puede ser público.

## Demo 03 · Excepciones: comunicar y recuperar

Lee [DatoObligatorioException.java](demo/s10demo03/DatoObligatorioException.java) y después ejecuta el Main. Sigue `exigirTexto`: `throw` lanza la excepción y `throws` declara su posible propagación. Esta excepción es checked: el cliente debe capturarla o declararla.

```text
Dato rechazado: El nombre es obligatorio
Dato corregido: Ana
Resultado entero: 4
Fin del intento
No es un entero: abc
Fin del intento
Divisor cero: corrige el divisor
Fin del intento
Resultado entero: 5
Fin del intento
Division decimal: Infinity
```

Coloca un breakpoint en la conversión y otro en la división. Observa a qué catch llega cada fallo y cómo el siguiente intento válido sigue ejecutándose. No se captura Exception genéricamente ni se inventa un resultado después de fallar.

| Elemento | Función en el ejemplo |
| --- | --- |
| try | Delimita la operación que puede fallar. |
| catch específico | Comunica el dato que debe corregirse y permite seguir con otro caso. |
| finally | Informa el cierre del intento, incluso cuando se capturó un fallo. No significa éxito. |
| throw | Lanza un objeto de excepción. |
| throws | Declara el contrato de propagación. |

NumberFormatException y ArithmeticException son unchecked (RuntimeException); no exigen captura/declaración como las checked. Un valor fuera de rango también puede rechazarse con una validación normal: no toda regla incumplida necesita una excepción.

**División entera entre cero** lanza ArithmeticException. La división `12.0 / 0.0` usa double y produce Infinity; `0.0 / 0.0` produce NaN. No esperes que ese cálculo decimal active el catch aritmético.

finally se ejecuta al salir del try/catch bajo el flujo normal de este programa; no es una garantía ante toda terminación de la JVM. No pongas return en finally. Para recursos cerrables, la herramienta habitual es try-with-resources; aquí no abrimos archivos ni necesitamos cerrar System.in.

## Hora de laboratorios

| Minutos | Actividad |
| --- | --- |
| 0–12 | Lab 00: materiales pendientes con Set |
| 12–25 | Lab 01: recuento de votos con Map |
| 25–38 | Lab 02: prioridades con enum |
| 38–55 | Lab 03: mediciones y recuperación de conversión |
| 55–60 | Comparar resultados y guardar avances |

Copia las clases del lab a tu proyecto personal y conserva el paquete. Cada README tiene entre cuatro y seis pasos: cambia solo datos de los escenarios, no la lógica. Registra una tabla pequeña con entrada, esperado y obtenido, y una respuesta breve. No se exige UML, capturas ni un informe extenso. Completa lo pendiente en casa y entrega por Campus según indique el docente.
