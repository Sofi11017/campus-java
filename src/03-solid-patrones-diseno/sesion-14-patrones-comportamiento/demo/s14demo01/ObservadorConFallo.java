package s14demo01;

public class ObservadorConFallo implements ObservadorPedido {
    @Override
    public void actualizar(EventoPedido evento) {
        throw new FalloNotificacionException("Canal simulado no disponible");
    }
}
