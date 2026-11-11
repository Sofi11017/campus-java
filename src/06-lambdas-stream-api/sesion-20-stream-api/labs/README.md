# Laboratorios · Sesión 20 · Resolver con Stream API

**Seis casos de diez minutos.** Crea tu solución en un proyecto Java personal preparado y explica qué procesamiento responde a la necesidad. Aquí no hay código inicial, TODO ni POM.

## Recordatorio antes de elegir

**Fuente → operaciones intermedias → terminal → resultado.** La colección contiene datos; el Stream procesa elementos. Cada pregunta independiente puede necesitar un stream nuevo.

| Fuente | Forma de crear el flujo |
| --- | --- |
| Lista | lista.stream() |
| Arreglo | Arrays.stream(arreglo) |
| Valores directos | Stream.of(...) |

| Necesidad general | Operaciones disponibles | Resultado o efecto |
| --- | --- | --- |
| Seleccionar elementos | filter | Otro stream con los que cumplen |
| Transformar cada elemento | map | Otro stream con los resultados |
| Reunir elementos internos | flatMap | Un flujo plano |
| Quitar valores repetidos | distinct | Otro stream según igualdad |
| Ordenar | sorted | Otro stream ordenado |
| Trabajar con enteros | mapToInt | IntStream; todavía no es un total |
| Obtener un total | sum o reduce | Un valor acumulado |
| Contar | count | long |
| Consultar existencia | anyMatch | boolean |
| Materializar elementos | toList | Lista no modificable |

Esta tabla es una ayuda, **no una receta por laboratorio**. Puedes elegir distintas soluciones correctas. No tienes que usar todos los métodos en cada actividad.

## Forma de trabajo

Por caso: analiza datos y resultado2min, implementa5min, comprueba2min y justifica1min. Puedes usar una clase Main por lab en el mismo proyecto. Escribe los datos directamente; sin Scanner, menús, archivos, bases, Maven ni paralelismo.

Antes de programar, describe tus pasos en español. Usa Stream API para el procesamiento; no sustituyas todo por ciclos. No modifiques la fuente ni uses acumuladores externos mutables dentro del flujo.

## Lab00 · Resultados académicos · 10 minutos

**Contexto:** un centro de formación necesita la lista de notas aprobadas: **70 o más**, manteniendo el orden de registro.

| Notas registradas | Resultado esperado |
| --- | --- |
| 50,70,90,65 | 70,90 |
| 40,60 | Lista vacía |
| Lista vacía | Lista vacía |

1. Crea los datos y define qué resultado necesitas.
2. Escribe un procesamiento con Stream API que responda a la regla.
3. Ejecuta los tres casos y muestra los resultados.
4. Explica el límite inclusivo y por qué se conserva70.

No calcules promedios ni crees clases de alumno. Comprueba que la lista original permanece igual.

## Lab01 · Asistencia sin duplicados · 10 minutos

**Contexto:** el coordinador necesita los nombres de asistentes **una sola vez por persona y en orden alfabético**.

| Registro inicial | Resultado esperado |
| --- | --- |
| Sofia,Ana,Sofia,Luis | Ana,Luis,Sofia |
| Ana,Ana | Ana |
| Lista vacía | Lista vacía |

1. Representa los nombres como datos en memoria.
2. Elige cómo obtener el resultado sin eliminar manualmente elementos de la fuente.
3. Comprueba los tres casos.
4. Explica qué significa que dos nombres se consideren repetidos.

Usa nombres sin tildes y con inicial mayúscula, tal como aparecen; no se exige resolver reglas lingüísticas.

## Lab02 · Pesos para una etiqueta · 10 minutos

**Contexto:** una transportadora recibe pesos de cajas en kilogramos enteros y necesita su lista equivalente en gramos, en el mismo orden. **1kg equivale a1000g.**

| Kilogramos | Gramos esperados |
| --- | --- |
| 5,12,8 | 5000,12000,8000 |
| 0,2 | 0,2000 |
| Lista vacía | Lista vacía |

1. Decide si representarás la fuente como lista o arreglo.
2. Obtén los pesos convertidos mediante Stream API.
3. Comprueba los resultados, incluido el cero.
4. Explica qué dato entra y qué dato sale de la operación.

Todos los valores son pequeños y no negativos. No agregues cálculo de fletes ni redondeos.

## Lab03 · Tiempo total de soporte · 10 minutos

**Contexto:** una mesa de ayuda necesita un único número: el total de minutos de sus atenciones.

| Minutos por atención | Total esperado |
| --- | ---: |
| 12,8,20 | 40 |
| 8,8 | 16 |
| Lista vacía | 0 |

1. Crea los datos y elige cómo obtener el total con Stream API.
2. Comprueba que dos atenciones de8min aportan16min, no8.
3. Verifica el caso vacío.
4. Justifica la operación que produce el número final y cómo resuelve la ausencia de datos.

No necesitas dos implementaciones. No alteres un total externo desde forEach: el resultado debe obtenerse del procesamiento.

## Lab04 · Recursos por curso · 10 minutos

**Contexto:** cada curso conserva su lista de recursos. El campus necesita **un único catálogo general, sin repetidos y ordenado**.

| Curso | Recursos |
| --- | --- |
| Programación | Java,SQL |
| Bases de datos | SQL,Git |
| Curso nuevo | Lista vacía |

**Resultado esperado:** Git,Java,SQL.

1. Representa los datos como una lista de listas de texto; no necesitas clases Course ni Student.
2. Describe en palabras cómo pasarás de los grupos a sus recursos individuales.
3. Obtén el catálogo usando Stream API y comprueba que SQL aparece una vez.
4. Repite con todos los cursos vacíos y luego sin cursos: ambos resultados deben ser listas vacías.

Explica por qué el catálogo debe contener textos, no listas dentro de otras listas. Elige las operaciones tú mismo.

## Lab05 · Control de tiempos de ruta · 10 minutos

**Contexto:** una empresa de transporte necesita dos respuestas sobre las duraciones de sus recorridos:

- Cuántos superan **20min**.
- Si existe al menos uno que supera **35min**.

| Duraciones | Cantidad que supera20 | ¿Existe alguna que supera35? |
| --- | ---: | --- |
| 18,25,12,30 | 2 | false |
| 20,36 | 1 | true |
| Lista vacía | 0 | false |

1. Crea los datos y distingue los dos tipos de respuesta.
2. Resuelve ambas preguntas con Stream API.
3. Comprueba las tres filas. Un recorrido de20min no supera20.
4. Explica cómo evitas reutilizar un stream ya consumido.

No se pide el recorrido más largo ni un informe de cada conductor; limita el trabajo a estas dos preguntas.

## Evidencia y sustentación

Entrega tu código y una evidencia de los casos. Por lab, anota brevemente: fuente/tipos, pasos en español, operaciones elegidas y por qué producen el resultado requerido.

Durante la sustentación ejecutarás un caso y una variación sencilla que indique el docente. Se aceptan estrategias distintas si son claras, usan Stream API y satisfacen los criterios. Completa en casa lo pendiente.

[Ver los tres demos y la agenda](../README.md)
