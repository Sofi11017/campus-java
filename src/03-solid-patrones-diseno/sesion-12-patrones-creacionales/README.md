# Sesión 12 · Patrones creacionales

Cinco demos continúan los ejemplos de la presentación: envíos, atención básica/premium, solicitudes, campañas y configuración. Los cinco labs usan otros contextos y están **completamente codificados, sin TODO**. Tu trabajo consiste en comprender la creación, ejecutar y comprobar cambios de datos.

## Preparación y orden

Usa IntelliJ IDEA con JDK 21 o 17, sin Maven/Gradle ni librerías externas. Marca `demo/` y `labs/` como **Sources Root** y conserva los paquetes `s12demo00` a `s12demo04` y `s12lab00` a `s12lab04`. Si copias el material a otro proyecto, conserva esos paquetes bajo su `src`. Cada Main requiere los archivos de su paquete, no solo el ejecutable.

| Orden | Patrón | Demo ejecutable | Lab |
| --- | --- | --- | --- |
| 00 | Factory Method | [Envíos urbanos e internacionales](demo/s12demo00/S12Demo00FactoryMethodMain.java) | [Actividad 00](labs/s12lab00/README.md) |
| 01 | Abstract Factory | [Atención básica y premium](demo/s12demo01/S12Demo01AbstractFactoryMain.java) | [Actividad 01](labs/s12lab01/README.md) |
| 02 | Builder | [Solicitudes con opciones](demo/s12demo02/S12Demo02BuilderMain.java) | [Actividad 02](labs/s12lab02/README.md) |
| 03 | Prototype | [Campañas desde plantillas](demo/s12demo03/S12Demo03PrototypeMain.java) | [Actividad 03](labs/s12lab03/README.md) |
| 04 | Singleton | [Configuración compartida](demo/s12demo04/S12Demo04SingletonMain.java) | [Actividad 04](labs/s12lab04/README.md) |

## Primero el problema, después el patrón

new no está mal. Identifica qué cambia: tipo concreto, familia, opciones de construcción, copia o alcance de una instancia. Compara la solución con un constructor o método sencillo; el costo en clases y conceptos también cuenta.

| Necesidad | Candidato | Límite o costo |
| --- | --- | --- |
| Subclases creadoras eligen un producto dentro de un flujo común | Factory Method | Requiere una variación real de creador; no basta llamar Factory a una clase. |
| Varios productos de la misma variante | Abstract Factory | Un nuevo tipo de producto afecta contratos y fábricas. |
| Construcción con datos obligatorios y muchas opciones | Builder | Puede ser excesivo si hay pocos datos simples. |
| Reutilizar una plantilla configurada mediante copia | Prototype | Decidir qué objetos internos deben copiarse. |
| Una instancia controlada por contexto | Singleton | Estado global y aislamiento de pruebas pueden complicarse. |

## Demo 00 · Factory Method: Envíos urbanos e internacionales

**Lectura:** [Transporte.java](demo/s12demo00/Transporte.java) → [CreadorEnvio.java](demo/s12demo00/CreadorEnvio.java) → [Camion.java](demo/s12demo00/Camion.java) → [Avion.java](demo/s12demo00/Avion.java) → [EnvioUrbano.java](demo/s12demo00/EnvioUrbano.java) → [EnvioInternacional.java](demo/s12demo00/EnvioInternacional.java) → [S12Demo00FactoryMethodMain.java](demo/s12demo00/S12Demo00FactoryMethodMain.java), que debes ejecutar.

Lee primero el producto Transporte y el creador CreadorEnvio. Después revisa sus implementaciones. El flujo procesarEnvio llama a crearTransporte, redefinido por EnvioUrbano y EnvioInternacional; la subclase decide qué producto crear.

Coloca un breakpoint en crearTransporte y usa Step Into desde procesarEnvio. Una fábrica estática con if/switch centraliza una selección, pero no demuestra esta variación por subclases. Añadir otro creador no exige reescribir el flujo común; Main sí puede cambiar para seleccionarlo. Si un constructor o un selector local basta, Factory Method puede ser innecesario.

**Salida esperada:**

```text
Entrega urbana por camion
Entrega internacional por avion
```

## Demo 01 · Abstract Factory: Atención básica y premium

**Lectura:** [Notificador.java](demo/s12demo01/Notificador.java) → [Comprobante.java](demo/s12demo01/Comprobante.java) → [FabricaAtencion.java](demo/s12demo01/FabricaAtencion.java) → [FabricaBasica.java](demo/s12demo01/FabricaBasica.java) → [FabricaPremium.java](demo/s12demo01/FabricaPremium.java) → [Atencion.java](demo/s12demo01/Atencion.java) → [S12Demo01AbstractFactoryMain.java](demo/s12demo01/S12Demo01AbstractFactoryMain.java), que debes ejecutar.

Atencion recibe una FabricaAtencion y obtiene de ella Notificador y Comprobante. Revisa los productos básicos y premium dentro del mismo paquete: el cliente no instancia esos productos concretos.

Cambiar la fábrica cambia la familia completa. No se envían mensajes reales: se devuelve texto para consola. La fábrica favorece la consistencia del cliente, pero no impide toda mezcla que alguien programe por fuera. Agregar otra familia puede conservar el cliente; agregar otro tipo de producto exige ampliar el contrato y sus fábricas. Si solo hay un producto simple, considera una alternativa menor.

**Salida esperada:**

```text
BASICA: Atencion registrada | Comprobante BASICA
PREMIUM: Atencion registrada | Comprobante PREMIUM
```

## Demo 02 · Builder: Solicitudes con opciones

**Lectura:** [Prioridad.java](demo/s12demo02/Prioridad.java) → [Solicitud.java](demo/s12demo02/Solicitud.java) → [SolicitudBuilder.java](demo/s12demo02/SolicitudBuilder.java) → [S12Demo02BuilderMain.java](demo/s12demo02/S12Demo02BuilderMain.java), que debes ejecutar.

Solicitud es el producto inmutable; SolicitudBuilder conserva la configuración temporal. Solicitante, fecha y prioridad son obligatorios; instrucciones, dirección alternativa y seguro son opciones. build valida antes de devolver una nueva solicitud.

Sigue la reutilización del builder: la segunda construcción usa BAJA sin cambiar la primera. LocalDate.of(año, mes, día) crea una fecha fija, no consulta el reloj; no necesitas programar calendarios. El mensaje de fallo se captura específicamente en Main para continuar. Un builder no necesita obligatoriamente Director o una interfaz adicional; en un objeto con dos datos un constructor puede ser suficiente.

**Salida esperada:**

```text
Carlos | 2026-01-15 | ALTA | seguro=true | instrucciones=[] | direccion=[]
Primera conserva: ALTA
Segunda usa: BAJA
Objetos distintos: true
Construccion rechazada: El solicitante es obligatorio
```

## Demo 03 · Prototype: Campañas desde plantillas

**Lectura:** [Campania.java](demo/s12demo03/Campania.java) → [S12Demo03PrototypeMain.java](demo/s12demo03/S12Demo03PrototypeMain.java), que debes ejecutar.

Campania mantiene listas privadas de etiquetas y segmentos. copiar(nuevoNombre) crea otro objeto y copia ambas listas. El nombre nuevo personaliza la derivada; la plantilla conserva su configuración.

alias = plantilla comparte identidad; no copia. Las listas de la copia son independientes y sus elementos String son inmutables. Esto no implica que copiar cualquier lista duplique sus objetos internos: contrástalo con el lab de ejercicios mutables. Prototype no requiere Cloneable; aquí la copia es explícita. Evalúa si construir directamente sería más sencillo para un objeto pequeño.

**Salida esperada:**

```text
Alias mismo objeto: true
Copia distinta: true
Bienvenida etiquetas=[Inicio] segmentos=[Nuevos]
Octubre etiquetas=[Inicio, Oferta] segmentos=[Nuevos, Frecuentes]
```

## Demo 04 · Singleton: Configuración compartida

**Lectura:** [ConfiguracionSistema.java](demo/s12demo04/ConfiguracionSistema.java) → [ModuloVentas.java](demo/s12demo04/ModuloVentas.java) → [ModuloFacturacion.java](demo/s12demo04/ModuloFacturacion.java) → [S12Demo04SingletonMain.java](demo/s12demo04/S12Demo04SingletonMain.java), que debes ejecutar.

ConfiguracionSistema usa constructor privado, instancia static final y campos finales sin setters. Main obtiene dos referencias y entrega la configuración a los módulos por constructor; ellos no buscan un global por su cuenta.

La unicidad corresponde al class loader/contexto, no a todas las máquinas o JVM. La inicialización estática es segura, pero no convertiría automáticamente en seguras las operaciones sobre estado mutable. Una configuración compartida puede ser un objeto normal inyectado si no necesitas controlar su unicidad. No guardes contraseñas en el código.

**Salida esperada:**

```text
Misma instancia: true
ModuloVentas: Campus moneda=COP limite=100
ModuloFacturacion: Campus moneda=COP limite=100
```

## Hora de práctica

Los demos acompañan la explicación conceptual; la siguiente hora es para los labs:

| Minutos | Actividad |
| --- | --- |
| 0–5 | Ubicar paquetes, leer la actividad y preparar ejecución. |
| 5–14 | Lab 00: Factory Method en biblioteca. |
| 14–25 | Lab 01: Abstract Factory con documentos ficticios. |
| 25–35 | Lab 02: Builder para reserva hotelera. |
| 35–47 | Lab 03: Prototype con ejercicios mutables. |
| 47–55 | Lab 04: Singleton para métricas monohilo. |
| 55–60 | Comparar resultados y guardar la evidencia. |

En cada lab entrega dos comprobaciones cortas (entrada, esperado y obtenido) y una respuesta sobre participantes o costo del patrón. No tienes que escribir un patrón nuevo, desarrollar cinco UML completos ni completar TODO. Cambia solo los datos indicados y usa implementaciones ya preparadas. Completa lo pendiente en casa y entrega por Campus según indique el docente.

Las fechas de los ejemplos son datos fijos reproducibles; no son fechas de entrega ni deben ser futuras. No se ejecutan transportes, notificaciones, pagos o impuestos reales.
