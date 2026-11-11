package s20lab01;

import java.util.List;

public class S20Lab01AsistenciaMain {

    /**
     * Procesa la lista de asistentes:
     * 1. distinct() elimina los duplicados basandose en el metodo equals() de String.
     * 2. sorted() ordena alfabeticamente segun el orden natural de String (Comparable).
     * 3. toList() recopila el flujo en una nueva lista inmutable sin alterar la original.
     */
    public static List<String> procesarAsistencia(List<String> asistentes) {
        return asistentes.stream()
                .distinct()
                .sorted()
                .toList();
    }

    public static void main(String[] args) {
        // Caso 1: Sofia, Ana, Sofia, Luis → Esperado: Ana, Luis, Sofia
        List<String> caso1 = List.of("Sofia", "Ana", "Sofia", "Luis");
        List<String> res1 = procesarAsistencia(caso1);
        imprimirResultado("Caso 1", caso1, res1);

        // Caso 2: Ana, Ana → Esperado: Ana
        List<String> caso2 = List.of("Ana", "Ana");
        List<String> res2 = procesarAsistencia(caso2);
        imprimirResultado("Caso 2", caso2, res2);

        // Caso 3: Lista vacia → Esperado: Lista vacia
        List<String> caso3 = List.of();
        List<String> res3 = procesarAsistencia(caso3);
        imprimirResultado("Caso 3", caso3, res3);
    }

    private static void imprimirResultado(String etiqueta, List<String> original, List<String> resultado) {
        String textoResultado = resultado.isEmpty() ? "Lista vacía" : String.join(", ", resultado);
        System.out.println(etiqueta + ":");
        System.out.println("  Original : " + (original.isEmpty() ? "Lista vacía" : String.join(", ", original)));
        System.out.println("  Resultado: " + textoResultado);
        System.out.println();
    }
}
