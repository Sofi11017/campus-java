# Lab 02 · Decorator · Empaque de pedidos · 13 minutos

Un pedido puede combinar un empaque base con recargos opcionales. Usa los objetos ya codificados para comprobar las combinaciones.

## Pasos para completar la actividad

1. Abre **S13Lab02DecoratorMain.java**. El costo base es 5000 pesos, el recargo ecológico 2000 y el seguro 3000. Calcula en papel los cinco totales impresos.
2. Ejecuta **Run → S13Lab02DecoratorMain** y compara con la salida. Las dos combinaciones deben costar lo mismo aunque el orden sea distinto.
3. Lee Empaque.java, EmpaqueEstandar.java, DecoradorEmpaque.java, EmpaqueEcologico.java y SeguroEmpaque.java. Localiza la referencia al objeto envuelto y la llamada a su calcularCosto.
4. Coloca un breakpoint en calcularCosto de SeguroEmpaque. En Debug, usa Step Into para ver cómo llega al costo base a través del otro decorador.
5. En EmpaqueEcologico.java, cambia solo el recargo `2_000` por `2_500`. Predice y ejecuta otra vez: Base=5000, Ecologico=7500, Seguro=8000 y ambas combinaciones=10500.
6. Guarda los cinco totales nuevos. Explica por qué intercambiar recargos fijos no cambia el total y por qué el orden sí afectaba al mensaje de auditoría en el demo. ¿Necesitarías decoradores si siempre hubiera una única opción fija?

## Salida inicial esperada

```text
Base: 5000
Ecologico: 7000
Seguro: 8000
Ecologico y seguro: 10000
Seguro y ecologico: 10000
```

[Volver a la sesión](../../README.md) · [Abrir el programa](S13Lab02DecoratorMain.java)
