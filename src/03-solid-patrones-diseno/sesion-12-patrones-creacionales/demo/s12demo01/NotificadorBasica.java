package s12demo01;
public class NotificadorBasica implements Notificador {
    @Override
    public String notificar(String mensaje) {
        return "BASICA: " + mensaje;
    }
}
