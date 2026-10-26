package s12demo01;
public class FabricaBasica implements FabricaAtencion {
    @Override
    public Notificador crearNotificador() {
        return new NotificadorBasica();
    }
    @Override
    public Comprobante crearComprobante() {
        return new ComprobanteBasica();
    }
}
