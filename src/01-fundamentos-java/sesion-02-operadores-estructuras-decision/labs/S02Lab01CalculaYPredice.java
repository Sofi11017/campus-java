public class S02Lab01CalculaYPredice {
    public static void main(String[] args) {
        int unidades = 7;
        int capacidad = 2;
        int contador = 3;

        // TODO 1: Predecir los resultados en un comentario antes de ejecutar.
        // No deberia de aparecer nada ya que solo estamos declarando una variable

        // TODO 2: Calcular y mostrar suma, resta, producto, división entera y resto.
        int suma = unidades + capacidad;
        int resta = unidades - capacidad;
        int producto = unidades * capacidad;
        int divisionEntera = unidades / capacidad;
        int resto = unidades % capacidad;

        System.out.println("Suma: " + suma);
        System.out.println("Resta: " + resta);
        System.out.println("Producto: " + producto);
        System.out.println("Division entera: " + divisionEntera);

        // TODO 3: Mostrar 7.0 / capacidad y explicar por qué conserva decimales.
        double divisionDecimal = 7.0 / capacidad;
        System.out.println("Division decimal: " + divisionDecimal);
        // Explicación: Al ser 7.0  de tipo 'double', Java realiza una promoción numérica automática
        // del valor de 'capacidad' a 'double'. La operación se ejecuta en punto flotante y conserva los decimales.

        // TODO 4: Comparar 2 + 3 * 4 con (2 + 3) * 4.
        System.out.println("Sin parentesis: " + (2 + 3 * 4));
        System.out.println("Con parentesis: " + ((2 + 3) * 4));

        // TODO 5: Incrementar contador en una sentencia, mostrarlo; decrementar y mostrarlo.
        contador++;
        System.out.println("Contador incrementado: " + contador);
        contador--;
        System.out.println("Contador decrementado: " + contador);

        // TODO 6 (opcional): Probar unidades = 8 y explicar qué cambia. Mantener capacidad = 2.


        // TODO 7: Registrar predicción, resultado y causa de cualquier diferencia.
        // Todos los resultados en consola coincidieron exactamente con la predicción realizada.

    }
}
