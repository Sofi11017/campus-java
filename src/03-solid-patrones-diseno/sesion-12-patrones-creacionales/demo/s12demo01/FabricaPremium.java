package s12demo01;
public class FabricaPremium implements FabricaAtencion {
    @Override
    public Notificador crearNotificador() {
        return new NotificadorPremium();
    }
    @Override
    public Comprobante crearComprobante() {
        return new ComprobantePremium();
    }
}
