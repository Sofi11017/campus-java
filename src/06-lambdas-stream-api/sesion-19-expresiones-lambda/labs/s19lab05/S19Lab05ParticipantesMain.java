package s19lab05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class S19Lab05ParticipantesMain {
    public static void main(String[] args) {
        // Interfaz elegida: Comparator<String>
        // Recibe: dos Strings (nombres)
        // Devuelve: int negativo (primero va antes), cero (iguales), positivo (segundo va antes)
        // Metodo que ejecuta la lambda: compare(primero, segundo)
        Comparator<String> alfabetico = (a, b) -> a.compareTo(b);

        // Lista 1: Sofia, Luis, Ana → Ana, Luis, Sofia
        List<String> lista1 = new ArrayList<>(Arrays.asList("Sofia", "Luis", "Ana"));
        lista1.sort(alfabetico);
        System.out.println(String.join(", ", lista1));

        // Lista 2: Luis, Ana, Ana → Ana, Ana, Luis
        List<String> lista2 = new ArrayList<>(Arrays.asList("Luis", "Ana", "Ana"));
        lista2.sort(alfabetico);
        System.out.println(String.join(", ", lista2));

        // Lista 3: vacia → Vacía, sin error
        List<String> lista3 = new ArrayList<>();
        lista3.sort(alfabetico);
        System.out.println(lista3.isEmpty() ? "Vacía, sin error" : String.join(", ", lista3));
        // Explicacion: comparar con compareTo devuelve negativo si a < b (a va primero),
        // cero si son iguales (conserva ambos Ana, no elimina duplicados) y positivo si
        // a > b (b va primero). Conservar ambos Ana es correcto porque son dos participantes
        // distintos con el mismo nombre; la lista refleja la realidad del grupo.
    }
}

