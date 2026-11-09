# Sesión 19 · Interfaces funcionales y expresiones lambda

**Objetivo:** reconocer qué datos recibe una operación y qué resultado produce, elegir su contrato y expresar el comportamiento con una lambda.

Una interfaz funcional define un contrato abstracto funcional; la lambda aporta su comportamiento. Declararla no ejecuta su cuerpo: se ejecuta cuando se invoca el método correspondiente.

| Orden | Actividad | Tiempo |
| --- | --- | ---: |
| 1 | Introducción: firma y tipo objetivo | 10 min |
| 2 | [Demo00 · de interfaz a lambda](demo/s19demo00/README.md) | 8 min |
| 3 | [Demo01 · acción y proveedor](demo/s19demo01/README.md) | 10 min |
| 4 | [Demo02 · transformaciones](demo/s19demo02/README.md) | 10 min |
| 5 | [Demo03 · reglas y ordenación](demo/s19demo03/README.md) | 12 min |
| 6 | [Seis labs, diez minutos cada uno](labs/README.md) | 60 min |
| 7 | Cierre y dos sustentaciones de muestra | 10 min |
| | **Total** | **120 min** |

Primero los demos y después los labs: así conoces las seis opciones antes de elegir. Las sustentaciones restantes se organizan en los espacios que indique el docente.

## Antes de comenzar

- Usa JDK 17/21 e IntelliJ IDEA. Marca únicamente la carpeta `demo/` de esta sesión como Sources Root.
- Cada demo es independiente y tiene un solo Main. Sus README muestran orden de lectura, resultados esperados y UML.
- Usa List, ciclos y sort cuando sea necesario. **Stream API se trabaja en la sesión 20**, no en estos ejercicios.
- No necesitas Maven, bibliotecas externas, archivos, bases de datos ni argumentos de main.

## Trabajo del estudiante

El [README único de labs](labs/README.md) comienza con un recordatorio de contratos. Después encontrarás seis problemas breves, sin fuentes de arranque. Crea el código en tu proyecto personal, comprueba los casos y explica por qué elegiste cada interfaz.

Distingue siempre: **dato de entrada → comportamiento → resultado**. No todas las lambdas deben devolver un valor: una acción puede tener retorno void. Una referencia de método es útil cuando delegar a un método existente aclara la intención.

Referencias: [interfaces funcionales del JDK](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/function/package-summary.html), [Comparator](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/Comparator.html).
