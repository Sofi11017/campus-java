package s13demo02;

public class DecoradorAuditoria extends DecoradorNotificador {
    public DecoradorAuditoria(Notificador notificador) {
        super(notificador);
    }

    @Override
    public void enviar(String mensaje) {
        System.out.println("[DecoradorAuditoria] AUDITORIA: " + mensaje);
        super.enviar(mensaje);
    }
}
