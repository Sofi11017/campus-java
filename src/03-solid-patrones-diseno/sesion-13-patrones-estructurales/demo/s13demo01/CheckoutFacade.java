package s13demo01;

import java.util.Objects;

public class CheckoutFacade {
    private final InventarioService inventario;
    private final PagoService pago;
    private final NotificacionService notificacion;

    public CheckoutFacade(InventarioService inventario, PagoService pago,
                          NotificacionService notificacion) {
        this.inventario = Objects.requireNonNull(inventario);
        this.pago = Objects.requireNonNull(pago);
        this.notificacion = Objects.requireNonNull(notificacion);
    }

    public String confirmarPedido(boolean pagoAprobado) {
        if (!inventario.reservar()) {
            return "Sin existencias";
        }
        if (!pago.procesar(pagoAprobado)) {
            inventario.liberarReserva();
            return "Pago rechazado; reserva liberada";
        }
        notificacion.confirmar();
        return "Compra confirmada";
    }
}
