package s13demo02;

import java.util.Objects;

public abstract class DecoradorNotificador implements Notificador {
    protected final Notificador notificador;

    protected DecoradorNotificador(Notificador notificador) {
        this.notificador = Objects.requireNonNull(notificador);
    }

    @Override
    public void enviar(String mensaje) {
        notificador.enviar(mensaje);
    }
}
