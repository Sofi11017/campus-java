# Lab 02 · Asistencia · 20 minutos

Trabaja en tu copia personal. El Main está completo salvo los TODO indicados. Cada ejercicio usa su propia carpeta de datos, cuya ruta se imprime al ejecutar.

## Pasos para completar

1. Abre S17Lab02AsistenciaMain.java. Ejecuta para preparar asistencia.txt. La plantilla cuenta cero y avisa que debes revisar entrada/TODO; esa no es la respuesta final.
2. En importar, **TODO 1**: ignora solo la línea1 si coincide exactamente con estudiante;fecha;estado, usando continue. Después separa la línea mediante split(";", -1). Las líneas vacías ya se ignoran.
3. En **TODO 2**, comprueba exactamente tres campos y que ninguno esté vacío. Si no cumple, lanza IllegalArgumentException con un motivo. Con los datos válidos interpreta campos[1].strip con LocalDate.parse y campos[2].strip con Estado.valueOf. Conserva el estudiante de campos[0]; no inventes campos ausentes.
4. En **TODO 3**, incrementa validos solo después de todas las validaciones y aumenta invalidos dentro del catch ya preparado. El catch maneja DateTimeParseException e IllegalArgumentException de esa fila, no IOException global.
5. Ejecuta: los registros de Ana y José son válidos; María tiene una fila incompleta, Luis una fecha inválida y Sara un estado desconocido. Resultado:2válidos y3inválidos. Encabezado y líneas vacías no cuentan.
6. Abre el archivo real en la ruta Datos. Cambia únicamente Sara;2026-11-02;PENDIENTE por Sara;2026-11-02;TARDE. Ejecuta de nuevo:3válidos y2inválidos. La muestra no sobrescribe ese cambio.
7. Guarda el resumen y los números de las filas rechazadas. Para casa, depura la fila incompleta y el estado vacío final. No implementes un parser CSV general ni aceptes comillas/separadores dentro de campos.

## Resultado tras completar los TODO

```text
Validos: 2; invalidos: 3
```

También aparecen los motivos de las filas inválidas. Para probar ausencia sin generar muestra, usa como argumentos una carpeta de ensayo y solo-leer.

[Abrir el Main](S17Lab02AsistenciaMain.java) · [Volver a la sesión](../../README.md)
