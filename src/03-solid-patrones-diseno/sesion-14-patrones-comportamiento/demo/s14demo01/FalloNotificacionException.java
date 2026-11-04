package s14demo01;

public class FalloNotificacionException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public FalloNotificacionException(String mensaje) {
        super(mensaje);
    }
}
