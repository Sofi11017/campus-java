package s12lab00;
public class GestorFisico extends GestorPrestamo {
    @Override
    protected ComprobantePrestamo crearComprobante() {
        return new ComprobantePrestamoFisico();
    }
}
