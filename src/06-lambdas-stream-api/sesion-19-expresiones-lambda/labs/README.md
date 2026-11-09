# Laboratorios · Sesión 19 · Elegir una interfaz funcional

**Seis problemas, diez minutos cada uno.** Debes identificar el contrato adecuado, escribir una lambda, invocarla y explicar tu elección.

## Recordatorio: las seis opciones

T,U,R representan tipos que tú eliges, por ejemplo String,Integer o Double.

| Interfaz | Qué recibe | Qué devuelve | Método para ejecutar | Intención |
| --- | --- | --- | --- | --- |
| Predicate<T> | Un valor T | boolean: true/false | test(valor) | Comprobar una condición. |
| Consumer<T> | Un valor T | void: no devuelve resultado | accept(valor) | Realizar una acción, por ejemplo mostrar un aviso. |
| Supplier<T> | Ningún argumento | Un valor T | get() | Proporcionar un valor cuando se solicita. |
| Function<T,R> | Un valor T | Un resultado R | apply(valor) | Transformar una entrada en un resultado. |
| BiFunction<T,U,R> | Dos valores, T y U | Un resultado R | apply(primero, segundo) | Calcular o combinar dos entradas. |
| Comparator<T> | Dos valores del mismo tipo T | int: negativo,cero o positivo | compare(primero, segundo) | Decidir el orden relativo de dos elementos. |

Las primeras cinco están en **java.util.function**; Comparator está en **java.util**. List.sort recibe un Comparator. Aunque una operación tenga dos parámetros, su intención y el tipo que pide el método receptor también importan.

**Mostrar no es devolver:** println escribe en consola; return entrega un valor al código que llamó. Una lambda se ejecuta al invocar el método de su contrato; no basta declararla.

## Cómo trabajar

Usa un único proyecto Java personal preparado, JDK 17/21 y una clase con main por lab. En esta carpeta solo hay enunciados: no hay fuentes iniciales ni POM. Escribe los datos directamente en main; no necesitas Scanner, menús, archivos, bases de datos ni Streams.

Para cada actividad dedica aproximadamente2min a leer y elegir,5min a implementar,2min a probar y1min a justificar. Escribe la lambda tú mismo, selecciona los tipos genéricos y utiliza el método de invocación correspondiente.

## Lab00 · Acceso a un taller · 10 minutos

**Contexto:** un centro cultural admite al taller a personas de **15 años o más**. Necesita una regla reutilizable que reciba la edad y responda si puede ingresar. La operación no cambia la edad.

1. Identifica el tipo de dato de entrada y el tipo de la respuesta.
2. Elige una interfaz de la tabla y escribe una lambda que represente la regla.
3. Invoca esa misma regla con las tres edades siguientes y muestra edad y resultado.

| Edad | Resultado esperado |
| ---: | --- |
| 14 | false |
| 15 | true |
| 20 | true |

4. Explica en una frase por qué elegiste ese contrato y qué método ejecuta tu lambda.

Usa estas edades válidas; no agregues registro de personas, aforo ni otras condiciones.

## Lab01 · Aviso de lavandería · 10 minutos

**Contexto:** una lavandería necesita una acción reutilizable que reciba el nombre del cliente y muestre **Tu pedido esta listo, NOMBRE**. Solo avisa; no devuelve un texto para otro cálculo.

1. Define qué recibe la acción y si necesita un valor de retorno.
2. Elige una interfaz y crea una lambda que muestre el mensaje.
3. Ejecuta la misma acción con Ana,Luis,Sara. Debes obtener una línea por llamada:

| Nombre | Salida esperada |
| --- | --- |
| Ana | Tu pedido esta listo, Ana |
| Luis | Tu pedido esta listo, Luis |
| Sara | Tu pedido esta listo, Sara |

4. Explica por qué imprimir el mensaje no significa devolverlo.

No envíes correo ni crees un archivo. Los nombres se escriben como datos en main.

## Lab02 · Horario de atención · 10 minutos

**Contexto:** una oficina necesita obtener el aviso **Horario: 8:00 a 17:00** cuando lo solicite. La operación no recibe datos y devuelve el texto; quien lo solicita decide cuándo mostrarlo.

1. Identifica cuántos argumentos necesitas y qué tipo de resultado debes obtener.
2. Elige una interfaz y escribe una lambda que entregue el aviso, sin imprimir dentro de ella.
3. Solicita el valor tres veces y muestra cada resultado.

| Solicitud | Resultado esperado |
| --- | --- |
| Primera | Horario: 8:00 a 17:00 |
| Segunda | Horario: 8:00 a 17:00 |
| Tercera | Horario: 8:00 a 17:00 |

4. Explica la diferencia entre obtener el aviso y mostrarlo.

No uses reloj, aleatorios ni códigos únicos; devolver el mismo valor en las tres llamadas es correcto.

## Lab03 · Peso de un paquete · 10 minutos

**Contexto:** una transportadora recibe el peso en **gramos enteros** y necesita convertirlo a **kilogramos con decimales** para un cálculo posterior. La operación recibe un peso y devuelve el convertido; no imprime dentro de ella.

1. Identifica los tipos de entrada y salida y selecciona el contrato.
2. Escribe una lambda con la regla: kilogramos = gramos /1000.0. El divisor con decimal evita perder la parte fraccionaria.
3. Invoca la transformación y muestra sus resultados para:

| Gramos | Kilogramos esperados |
| ---: | ---: |
| 500 | 0.5 |
| 1000 | 1.0 |
| 2500 | 2.5 |

4. Explica por qué el resultado debe devolverse, en lugar de solo mostrarse dentro de la operación.

Trabaja con esos pesos válidos; no agregues tarifas, redondeos ni cálculos de envío.

## Lab04 · Minutos disponibles de una sala · 10 minutos

**Contexto:** una sala se reserva por bloques de minutos. Se necesita una operación que reciba **minutos contratados y minutos utilizados** y devuelva los minutos restantes.

1. Identifica las dos entradas independientes y la salida; elige el contrato.
2. Escribe una lambda con la regla restantes = contratados - utilizados.
3. Invócala y muestra los resultados siguientes.

| Contratados | Utilizados | Restantes esperados |
| ---: | ---: | ---: |
| 120 | 45 | 75 |
| 120 | 0 | 120 |
| 120 | 120 | 0 |

4. Explica por qué la operación necesita dos argumentos y cuál método la ejecuta.

Los datos ya son válidos: utilizados está entre0 y contratados. No añadas fechas, cobros ni clases de reserva.

## Lab05 · Lista de participantes · 10 minutos

**Contexto:** un instructor tiene una lista de nombres y quiere ordenarlos alfabéticamente en forma ascendente. La regla de orden debe poder cambiarse.

1. Crea una lista **modificable** con los nombres; por ejemplo, una ArrayList que contenga esos datos. No intentes ordenar directamente una lista inmutable de List.of.
2. Elige el contrato que recibe List.sort y escribe su comparación con una lambda. Compara el contenido de los nombres, no sus referencias.
3. Ordena y muestra cada una de estas listas:

| Lista inicial | Orden esperado |
| --- | --- |
| Sofia,Luis,Ana | Ana,Luis,Sofia |
| Luis,Ana,Ana | Ana,Ana,Luis |
| Vacía | Vacía, sin error |

4. Explica qué significa que la comparación devuelva un número negativo,cero o positivo y por qué conservar ambos Ana es correcto.

Usa los nombres tal como aparecen, sin tildes y con inicial mayúscula. No uses Streams ni sustituyas la lambda por un criterio de orden ya construido.

## Evidencia y sustentación

Para cada lab entrega el código propio y sus tres resultados. Anota brevemente:

- Qué recibe y qué devuelve la operación.
- Qué interfaz elegiste y qué método invoca la lambda.
- Por qué esa elección representa la necesidad del negocio.

En la sustentación ejecutarás un caso y explicarás una variación sencilla que indique el docente, por ejemplo otro límite de edad o invertir el orden. No se evalúa la cantidad de lambdas, sino que el contrato, el comportamiento y los resultados sean coherentes. Completa en casa lo pendiente.

[Consultar los demos y la agenda](../README.md)
