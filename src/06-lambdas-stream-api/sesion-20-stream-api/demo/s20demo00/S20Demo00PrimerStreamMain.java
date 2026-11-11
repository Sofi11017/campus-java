package s20demo00;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class S20Demo00PrimerStreamMain {
    public static void main(String[] args) {
        List<Integer> temperaturas = List.of(24, 30, 35, 28);
        List<Integer> conCiclo = new ArrayList<>();
        for (int temperatura : temperaturas) {
            if (temperatura >= 30) {
                conCiclo.add(temperatura);
            }
        }
        System.out.println("Antes Con ciclo: " + conCiclo);

        Stream<Integer> seleccion = temperaturas.stream()
                .filter(temperatura -> temperatura >= 30);
        System.out.println("Pipeline definido; falta obtener el resultado.");
        List<Integer> conStream = seleccion.toList();
        System.out.println("Ahora Con stream: " + conStream);
        System.out.println("Original: " + temperaturas);

        System.out.println("Sin coincidencias: " + seleccionar(List.of(20, 25)));
        System.out.println("Fuente vacia: " + seleccionar(List.of()));
    }

    public static List<Integer> seleccionar(List<Integer> temperaturas) {
        return temperaturas.stream()
                .filter(temperatura -> temperatura >= 30)
                .toList();
    }
}
