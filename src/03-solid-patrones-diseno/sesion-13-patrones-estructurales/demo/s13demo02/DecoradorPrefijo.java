package s13demo02;

public class DecoradorPrefijo extends DecoradorNotificador {
    public DecoradorPrefijo(Notificador notificador) {
        super(notificador);
    }

    @Override
    public void enviar(String mensaje) {
        super.enviar("[Campus] " + mensaje);
    }
}
