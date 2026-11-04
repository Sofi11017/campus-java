package s13demo01;

import java.util.Objects;

public class ModuloCompras {
    private final CheckoutFacade checkout;

    public ModuloCompras(CheckoutFacade checkout) {
        this.checkout = Objects.requireNonNull(checkout);
    }

    public String comprar(boolean pagoAprobado) {
        return checkout.confirmarPedido(pagoAprobado);
    }
}
