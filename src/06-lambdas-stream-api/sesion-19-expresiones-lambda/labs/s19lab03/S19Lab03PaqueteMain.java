package s19lab03;

import java.util.function.Function;

public class S19Lab03PaqueteMain {
    public static void main(String[] args) {
        // Interfaz elegida: Function<Integer, Double>
        // Recibe: peso en gramos (Integer)
        // Devuelve: peso en kilogramos (Double)
        // Metodo que ejecuta la lambda: apply(valor)
        Function<Integer, Double> aKilogramos = gramos -> gramos / 1000.0;

        int[] pesos = {500, 1000, 2500};
        for (int gramos : pesos) {
            System.out.println(gramos + " g → " + aKilogramos.apply(gramos) + " kg");
        }
        // Explicacion: el resultado debe devolverse (no solo mostrarse dentro de la
        // operacion) porque quien convierte el peso no sabe que se hara con el resultado:
        // podria usarse en otro calculo de tarifa, en un reporte, etc. Function<T,R>
        // es el contrato correcto: transforma una entrada en un resultado reutilizable.
    }
}

