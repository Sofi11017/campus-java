package s19lab04;

import java.util.function.BiFunction;

public class S19Lab04SalaMain {
    public static void main(String[] args) {
        // Interfaz elegida: BiFunction<Integer, Integer, Integer>
        // Recibe: minutos contratados (Integer) y minutos utilizados (Integer)
        // Devuelve: minutos restantes (Integer)
        // Metodo que ejecuta la lambda: apply(primero, segundo)
        BiFunction<Integer, Integer, Integer> minutosRestantes =
                (contratados, utilizados) -> contratados - utilizados;

        System.out.println("120 - 45  = " + minutosRestantes.apply(120, 45));
        System.out.println("120 - 0   = " + minutosRestantes.apply(120, 0));
        System.out.println("120 - 120 = " + minutosRestantes.apply(120, 120));
        // Explicacion: la operacion necesita dos argumentos independientes (contratados
        // y utilizados) porque ninguno se puede deducir del otro. BiFunction es el
        // contrato que acepta exactamente dos entradas y devuelve un resultado.
        // El metodo que ejecuta la lambda es apply(primero, segundo).
    }
}

