public class Lab02OrdenaLaSalida {
    public static void main(String[] args) {
        // TODO 1: Predecir la salida de estas tres instrucciones en un comentario.
        // Instrucciones originales analizadas:
        System.out.print("A");
        System.out.println("B");
        System.out.println("C");
        //
        // Predicción original:
        // Línea 1: AB (porque print("A") no salta de línea y println("B") escribe al lado y luego salta).
        // Línea 2: C (porque println("C") se imprime en la nueva línea y salta).

        // TODO 2: Ejecutar y explicar cualquier diferencia con tu predicción.
        // Resultado: Coincidió exactamente con la predicción; se observó "AB" en la
        // primera línea y "C" en la segunda.

        // TODO 3: Modificar las instrucciones anteriores para obtener: A - B - C
        // Se modifican las tres instrucciones: 'A - ' y 'B - ' con print, y 'C' con
        // println:
        System.out.print("A - ");
        System.out.print("B - ");
        System.out.println("C");

        // TODO 4: Agregar debajo una segunda línea que diga "Fin del laboratorio".
        System.out.println("Fin del laboratorio");

        // TODO 5: Explicar qué instrucción produce cada salto de línea.
        // Explicación:
        // 1. Primer salto de línea: Lo produce 'System.out.println("C");' en el TODO 3. 'System.out.print("A - ")'
        //  y 'System.out.print("B - ")' NO realizan salto de línea, por lo que mantienen el cursor en la misma fila acumulando el texto.
        //  El método 'println' al imprimir "C" es el que genera el salto de línea
        // (\n), cerrando la línea "A - B - C".

        // 2. Segundo salto de línea: Lo produce 'System.out.println("Fin del laboratorio");' en el TODO 4, imprimiendo el mensaje y
        //  envia el cursor al inicio de la siguiente fila.
    }
}