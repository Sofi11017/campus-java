package s19demo03;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class S19Demo03ReglasOrdenMain {
    public static void main(String[] args) {
        List<Pedido> pedidos = new ArrayList<>(List.of(
                new Pedido("A", 100_000),
                new Pedido("B", 80_000),
                new Pedido("C", 100_000)));

        Predicate<Pedido> cumpleMinimo = pedido -> pedido.getTotal() >= 100_000;
        List<Pedido> elegibles = new ArrayList<>();
        for (Pedido pedido : pedidos) {
            if (cumpleMinimo.test(pedido)) {
                elegibles.add(pedido);
            }
        }
        System.out.println("Original: " + pedidos);
        System.out.println("Elegibles: " + elegibles);

        Predicate<Pedido> noSuperaMaximo = pedido -> pedido.getTotal() <= 500_000;
        Predicate<Pedido> enRango = cumpleMinimo.and(noSuperaMaximo);
        Predicate<Pedido> esPromocional = pedido -> pedido.getCodigo().equals("PROMO");
        Predicate<Pedido> admiteBeneficio = cumpleMinimo.or(esPromocional);
        System.out.println("En rango A: " + enRango.test(pedidos.get(0)));
        System.out.println("Beneficio PROMO de 80000: "
                + admiteBeneficio.test(new Pedido("PROMO", 80_000)));
        System.out.println("No cumple minimo B: " + cumpleMinimo.negate().test(pedidos.get(1)));

        List<Pedido> ordenados = new ArrayList<>(pedidos);
        Comparator<Pedido> criterio = porTotalYCodigo();
        ordenados.sort(criterio);
        System.out.println("Orden total/codigo: " + ordenados);
        System.out.println("Original conservada: " + pedidos);

        System.out.println("Comparar B con A: " + criterio.compare(pedidos.get(1), pedidos.get(0)));
        System.out.println("Comparar A consigo: " + criterio.compare(pedidos.get(0), pedidos.get(0)));
        System.out.println("Comparar C con A: " + criterio.compare(pedidos.get(2), pedidos.get(0)));

        // Variante equivalente: descomenta ambas lineas para comparar el mismo orden.
        // ordenados.sort(Comparator.comparingInt(Pedido::getTotal).thenComparing(Pedido::getCodigo));
        // System.out.println("Variante: " + ordenados);
    }

    public static Comparator<Pedido> porTotalYCodigo() {
        return (primero, segundo) -> {
            int porTotal = Integer.compare(primero.getTotal(), segundo.getTotal());
            if (porTotal != 0) {
                return porTotal;
            }
            return primero.getCodigo().compareTo(segundo.getCodigo());
        };
    }
}
