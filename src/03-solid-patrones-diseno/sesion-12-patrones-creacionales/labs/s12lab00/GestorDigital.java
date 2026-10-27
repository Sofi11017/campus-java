package s12lab00;
public class GestorDigital extends GestorPrestamo {
    @Override
    protected ComprobantePrestamo crearComprobante() {
        return new ComprobantePrestamoDigital();
    }
}
