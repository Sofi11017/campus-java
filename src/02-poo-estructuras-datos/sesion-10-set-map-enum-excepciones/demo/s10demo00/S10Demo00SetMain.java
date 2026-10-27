package s10demo00;

import java.util.*;

public class S10Demo00SetMain {
    // Esta normalización es una política del ejemplo, no de todo correo real.
    public static String normalizar(String correo) {
        return correo == null ? "" : correo.strip().toLowerCase(Locale.ROOT);
    }

    public static void main(String[] args) {
        // HashSet, LinkedHashSet y TreeSet utilizan los mismos métodos:
        // add(), remove() y contains(),
        // porque todos implementan la interfaz Set, que hereda estos métodos de Collection
        Set<String> llegada = new LinkedHashSet<>();
        System.out.println("Agregar Luis: " + llegada.add(normalizar("luis@ejemplo.test")));
        System.out.println("Agregar Ana: " + llegada.add(normalizar("ana@ejemplo.test")));
        System.out.println("Repetir Ana: " + llegada.add(normalizar(" ANA@ejemplo.test ")));

        Set<String> hash = new HashSet<>(llegada);
        Set<String> ordenado = new TreeSet<>(llegada);
        System.out.println("Orden de llegada: " + llegada);
        System.out.println("Orden natural: " + ordenado);
        System.out.println("HashSet mismo contenido: " + hash.equals(llegada));
        System.out.println("TreeSet mismo contenido: " + ordenado.equals(llegada));

        System.out.println("Cantidad: " + hash.size());
        System.out.println("Contiene Ana: " + hash.contains(normalizar("ANA@ejemplo.test")));
        System.out.println("Retirar Ana: " + llegada.remove(normalizar("ana@ejemplo.test")));
        System.out.println("Queda: " + llegada);
        System.out.println("Vacio: " + llegada.isEmpty());
        llegada.clear();
        System.out.println("Llegada: " + llegada);
        System.out.println("Vacio: " + llegada.isEmpty());

        // HashSet no garantiza un orden: no lo deducimos del que se observe al imprimirlo.

    }
}
