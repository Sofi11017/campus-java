package s12demo01;
public class Atencion {
    private final FabricaAtencion fabrica;
    public Atencion(FabricaAtencion fabrica) {
        if (fabrica == null) {
            throw new IllegalArgumentException("La fabrica es obligatoria");
        }
        this.fabrica = fabrica;
    }
    public String procesar() {
        Notificador notificador = fabrica.crearNotificador();
        Comprobante comprobante = fabrica.crearComprobante();
        return notificador.notificar("Atencion registrada") + " | " + comprobante.generar();
    }
}
