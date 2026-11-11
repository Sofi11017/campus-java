package s20demo02;

import java.util.List;

public class S20Demo02OrdenesMain {
    public static void main(String[] args) {
        List<Orden> ordenes = List.of(
                new Orden("O1", List.of(new Item("Cuaderno", 2), new Item("Lapiz", 3))),
                new Orden("O2", List.of(new Item("Cuaderno", 1), new Item("Borrador", 4))),
                new Orden("O3", List.of()));

        List<List<Item>> anidados = ordenes.stream()
                .map(Orden::getItems) // map(orden -> orden.getItems())
                .toList();
        System.out.println("1. Listas internas: " + anidados);

        List<Item> planos = ordenes.stream()
                .flatMap(orden -> orden.getItems().stream())
                .toList();
        System.out.println("2. Items planos: " + planos);

        System.out.println("3. Nombres unicos ordenados: " + nombresUnicos(ordenes));
        System.out.println("4. Unidades con sum: " + totalConSum(ordenes));
        System.out.println("5. Unidades con reduce: " + totalConReduce(ordenes));
        System.out.println("Original: " + ordenes.stream().map(Orden::getItems).toList());

        List<Orden> sinItems = List.of(new Orden("Vacia", List.of()));
        System.out.println("Todas vacias: " + nombresUnicos(sinItems));
        System.out.println("Suma vacia: " + totalConSum(sinItems));
        System.out.println("Reduccion vacia: " + totalConReduce(sinItems));
    }

    public static List<String> nombresUnicos(List<Orden> ordenes) {
        return ordenes.stream()
                .flatMap(orden -> orden.getItems().stream())
                .map(Item::getNombre)
                .distinct()
                .sorted()
                .toList();
    }

    public static int totalConSum(List<Orden> ordenes) {
        return ordenes.stream()
                .flatMap(orden -> orden.getItems().stream())
                .mapToInt(Item::getUnidades)
                .sum();
    }

    public static int totalConReduce(List<Orden> ordenes) {
        return ordenes.stream()
                .flatMap(orden -> orden.getItems().stream())
                .mapToInt(Item::getUnidades)
                .reduce(0, Integer::sum); // Es lo mismo que el sum(). 0 es el valor inicial.
                // Integer::sum -> .reduce(0, (acumulado, unidades) -> acumulado + unidades)
    }
}
