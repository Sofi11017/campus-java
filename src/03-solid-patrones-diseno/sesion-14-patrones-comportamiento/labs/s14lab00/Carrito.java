package s14lab00;

import java.util.Objects;

public class Carrito {
    private final Descuento descuento;

    public Carrito(Descuento descuento) {
        this.descuento = Objects.requireNonNull(descuento);
    }

    public static void validar(long precioUnitario, int unidades) {
        if (precioUnitario < 100 || precioUnitario > 1_000_000
                || precioUnitario % 100 != 0 || unidades < 1 || unidades > 100) {
            throw new IllegalArgumentException("Precio multiplo de 100 entre 100 y 1000000; unidades 1 a 100");
        }
    }

    public long total(long precioUnitario, int unidades) {
        validar(precioUnitario, unidades);
        return precioUnitario * unidades - descuento.calcular(precioUnitario, unidades);
    }
}
