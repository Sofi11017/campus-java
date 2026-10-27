package s12lab00;
public abstract class GestorPrestamo {
    protected abstract ComprobantePrestamo crearComprobante();

    public String registrarPrestamo(String titulo) {
        if (titulo == null || titulo.isBlank()) {
            throw new IllegalArgumentException("Titulo obligatorio");
        }
        return crearComprobante().describir(titulo.strip());
    }
}
