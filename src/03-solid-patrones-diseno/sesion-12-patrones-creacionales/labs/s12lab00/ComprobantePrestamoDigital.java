package s12lab00;
public class ComprobantePrestamoDigital implements ComprobantePrestamo {
    @Override
    public String describir(String titulo) {
        return "Acceso en plataforma: " + titulo;
    }
}
