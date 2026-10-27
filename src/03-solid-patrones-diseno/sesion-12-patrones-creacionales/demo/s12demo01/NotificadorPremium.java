package s12demo01;
public class NotificadorPremium implements Notificador {
    @Override
    public String notificar(String mensaje) {
        return "PREMIUM: " + mensaje;
    }
}
