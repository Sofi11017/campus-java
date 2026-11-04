# Lab 02 · Chain of Responsibility · Mesa de ayuda · 10 minutos

Las categorías del ejercicio son textos exactos en mayúsculas. Toda categoría no reconocida devuelve Sin responsable. La referencia al siguiente se fija al construir la cadena; el cliente no sabe quién terminará resolviendo.

## Pasos para completar la actividad

1. Abre **S14Lab02ChainMain.java**. Lee puedeAtender en NivelUno, Especialista y Proveedor. NivelUno atiende CONTRASENA; Especialista atiende EQUIPO y también CONTRASENA; Proveedor atiende CONEXION.
2. Predice el responsable para las cuatro categorías del arreglo. Ejecuta **Run → S14Lab02ChainMain** y compara con la salida.
3. Observa la cadena invertida: Especialista está antes de NivelUno y resuelve CONTRASENA. No cambia la categoría, cambia el primer responsable capaz de atender.
4. En la cadena inicial, cambia `new NivelUno(new Especialista(new Proveedor(null)))` por `new Especialista(new NivelUno(new Proveedor(null)))`. Predice y ejecuta: la primera línea pasa a `CONTRASENA: Especialista`; EQUIPO, CONEXION y OTRA mantienen sus resultados.
5. Coloca un breakpoint en resolver de Soporte. En Debug sigue el ticket OTRA hasta llegar al último eslabón y a Sin responsable.
6. Guarda la salida nueva. Explica por qué la cadena se detiene al resolver, por qué el orden importa en CONTRASENA y cuándo una condición sencilla sería suficiente.

## Salida inicial esperada

```text
CONTRASENA: NivelUno
EQUIPO: Especialista
CONEXION: Proveedor
OTRA: Sin responsable
Invertida CONTRASENA: Especialista
```

[Abrir el programa](S14Lab02ChainMain.java) · [Volver a la sesión](../../README.md)
