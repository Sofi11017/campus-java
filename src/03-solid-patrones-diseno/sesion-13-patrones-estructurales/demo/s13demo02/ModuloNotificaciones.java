package s13demo02;

import java.util.Objects;

public class ModuloNotificaciones {
    private final Notificador notificador;

    public ModuloNotificaciones(Notificador notificador) {
        this.notificador = Objects.requireNonNull(notificador);
    }

    public void avisar(String mensaje) {
        notificador.enviar(mensaje);
    }
}
