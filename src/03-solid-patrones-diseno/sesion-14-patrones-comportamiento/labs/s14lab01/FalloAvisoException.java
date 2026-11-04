package s14lab01;

public class FalloAvisoException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public FalloAvisoException(String mensaje) {
        super(mensaje);
    }
}
