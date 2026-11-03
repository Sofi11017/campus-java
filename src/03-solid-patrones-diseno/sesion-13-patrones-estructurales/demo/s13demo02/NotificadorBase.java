package s13demo02;

public class NotificadorBase implements Notificador {
    @Override
    public void enviar(String mensaje) {
        System.out.println("[NotificadorBase] ENVIO: " + mensaje);
    }
}
