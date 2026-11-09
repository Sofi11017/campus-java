package s19lab00;

import java.util.function.Predicate;

public class S19Lab00AccesoTallerMain {
    public static void main(String[] args) {
        // Interfaz elegida: Predicate<Integer>
        // Recibe: edad (int/Integer)
        // Devuelve: boolean (true si puede ingresar, false si no)
        // Método que ejecuta la lambda: test(valor)
        Predicate<Integer> puedeIngresar = edad -> edad >= 15;

        int[] edades = {14, 15, 20};
        for (int edad : edades) {
            System.out.println("Edad: " + edad + " → " + puedeIngresar.test(edad));
        }
        // Explicacion: se eligio Predicate<Integer> porque la operacion recibe un valor
        // (la edad) y responde con true/false segun una condicion. El metodo que ejecuta
        // la lambda es test(valor).
    }
}

