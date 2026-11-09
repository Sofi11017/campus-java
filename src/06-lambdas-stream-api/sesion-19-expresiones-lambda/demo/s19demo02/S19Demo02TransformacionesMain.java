package s19demo02;

import java.util.function.BiFunction;
import java.util.function.Function;

public class S19Demo02TransformacionesMain {
    public static void main(String[] args) {
        Function<String, Integer> contarLetras = texto -> texto.length();
        System.out.println("Letras de Maria: " + contarLetras.apply("Maria"));

        int descuento = 10_000;
        Function<Integer, Integer> aplicarDescuento = precio -> precio - descuento;
        System.out.println("90000 menos 10000: " + aplicarDescuento.apply(90_000));

        BiFunction<Integer, Integer, Integer> calcularSubtotal =
                (precioUnitario, cantidad) -> precioUnitario * cantidad;
        System.out.println("30000 por 2: " + calcularSubtotal.apply(30_000, 2));
        System.out.println("30000 por 0: " + calcularSubtotal.apply(30_000, 0));

        Function<String, Integer> contarConReferencia = String::length;
        System.out.println("Lambda con Java: " + contarLetras.apply("Java"));
        System.out.println("Referencia con Java: " + contarConReferencia.apply("Java"));
    }
}
