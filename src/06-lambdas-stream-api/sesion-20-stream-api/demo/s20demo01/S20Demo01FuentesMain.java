package s20demo01;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class S20Demo01FuentesMain {
    public static void main(String[] args) {
        List<String> lista = List.of("Ana", "Luis", "Luz", "Pablo");
        String[] arreglo = {"Ana", "Luis", "Luz", "Pablo"};

        List<String> desdeLista = lista.stream()
                .filter(nombre -> nombre.startsWith("L"))
                .toList();
        List<String> desdeArreglo = Arrays.stream(arreglo)
                .filter(nombre -> nombre.startsWith("L"))
                .toList();
        List<String> desdeValores = Stream.of("Ana", "Luis", "Luz", "Pablo")
                .filter(nombre -> nombre.startsWith("L"))
                .toList();

        System.out.println("1. Lista: " + desdeLista);
        System.out.println("2. Arreglo: " + desdeArreglo);
        System.out.println("3. Valores: " + desdeValores);

        // Cada pregunta inicia un stream nuevo desde la misma fuente.
        long cantidad = lista.stream()
                .filter(nombre -> nombre.startsWith("L"))
                .count();
        boolean existeZ = lista.stream()
                .anyMatch(nombre -> nombre.startsWith("Z"));
        System.out.println("Cantidad con L: " + cantidad);
        System.out.println("Existe nombre con Z: " + existeZ);
        System.out.println("Lista original: " + lista);
        System.out.println("Arreglo original: " + Arrays.toString(arreglo));
    }
}
