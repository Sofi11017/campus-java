package s12lab00;
public class ComprobantePrestamoFisico implements ComprobantePrestamo {
    @Override
    public String describir(String titulo) {
        return "Retiro en mostrador: " + titulo;
    }
}
