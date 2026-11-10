# Lab 01 · MVC + DAO · Inventario · Explicación completa

## 🎯 Situación

Una tienda necesita gestionar productos en su inventario (nombre y cantidad en stock). Debe poder registrarlos, listarlos y actualizar el stock por su ID. La aplicación debe separar claramente la presentación, la lógica de control y el acceso a la base de datos MySQL, siguiendo el patrón arquitectónico **MVC + DAO**.

---

## ❗ El problema

1. **Código espagueti**: Mezclar sentencias SQL (`SELECT`, `UPDATE`), lecturas por consola (`Scanner`, `System.out.println`) y validaciones de negocio en un solo archivo hace que el código sea difícil de mantener, testear y escalar.
2. **Stock negativo y nombres inválidos**: La base de datos tiene una restricción `CHECK (stock >= 0)`, pero la aplicación Java debe validar las reglas antes de llegar a la base de datos para no depender exclusivamente del motor.
3. **Actualizaciones inseguras**: Si se actualizara el stock por nombre en vez de por ID, se podrían modificar múltiples productos con el mismo nombre por error.
4. **Manejo de conexiones**: Mantener una única conexión abierta para toda la vida del programa puede causar desconexiones por inactividad o bloqueos.

---

## ✅ La solución: Patrón MVC + DAO

Se dividió el proyecto en 5 capas con responsabilidades únicas:

```
[Usuario / Consola]
       ↕
[VistaInventario]    (Solo Scanner y System.out; NO importa java.sql)
       ↕
[ProductoController] (Coordina el flujo, valida IDs y captura errores)
       ↕
[ProductoDAO]        (Solo SQL parametrizado; NO usa Scanner ni println)
       ↕  usa ConexionFactory (entrega una Connection limpia por operación)
[MySQL Database]
```

### 1. Modelo (`Producto.java`)
Contiene los datos del producto e implementa las reglas de dominio:
- `nombre`: obligatorio, hasta 100 caracteres.
- `stock`: obligatorio, no negativo (`stock >= 0`). Si es negativo, lanza `IllegalArgumentException("El stock no puede ser negativo.")`.

### 2. Conexión (`ConexionFactory.java`)
Entrega conexiones nuevas bajo demanda con `abrir()`, evitando una conexión global compartida.

### 3. DAO (`ProductoDAO.java`)
Encapsula todas las consultas SQL (`INSERT`, `SELECT`, `UPDATE`) usando `PreparedStatement` y `try-with-resources`. No conoce la consola ni la interfaz gráfica.

### 4. Vista (`VistaInventario.java`)
Se encarga exclusivamente de la interacción con el usuario (leer entradas y mostrar menús/mensajes). Si se cambia el formato de visualización (por ejemplo, de ` | ` a ` - `), **solo se toca esta clase**.

### 5. Controlador (`ProductoController.java`)
Recibe las peticiones de la vista, invoca al DAO y decide qué mensaje devolver según el resultado o las excepciones (`SQLException`, `IllegalArgumentException`).

---

## 📊 Resultados obtenidos

```text
1 Registrar | 2 Listar | 3 Actualizar stock | 0 Salir

-- 1. Listado inicial (semilla de la base de datos)
1 | Marcador | 15

-- 2. Registro de nuevo producto
Nombre: Cuaderno
Stock: 10
Filas insertadas: 1

-- 3. Listado con el nuevo producto registrado
1 | Marcador | 15
2 | Cuaderno | 10

-- 4. Actualización válida de stock
Id: 2
Nuevo stock: 7
Filas afectadas: 1

-- 5. Listado tras la actualización
1 | Marcador | 15
2 | Cuaderno | 7

-- 6. Rechazo de stock negativo (regla de validación)
Id: 2
Nuevo stock: -1
El stock no puede ser negativo.

-- 7. ID inexistente
Id: 999
Nuevo stock: 5
Sin coincidencias para ese id.

-- 8. Persistencia tras reiniciar la aplicación
1 | Marcador | 15
2 | Cuaderno | 7
```

---

## 💡 Conclusión para explicar al profesor

> En este laboratorio aplicamos el patrón **MVC + DAO** para lograr una **alta cohesión y bajo acoplamiento**:
> - **Vista**: no sabe nada de JDBC ni de SQL.
> - **DAO**: no sabe nada de consola ni de Scanner.
> - **Controlador**: orquesta el flujo y captura las excepciones.
> - **Modelo**: custodia las reglas de negocio (stock no negativo).
> - **ConexionFactory**: genera conexiones bajo demanda y desacopla las credenciales del código de acceso a datos.
