package s10demo03;

import java.io.Serial;

public class DatoObligatorioException extends Exception {
    @Serial
    private static final long serialVersionUID = 1L;

    public DatoObligatorioException(String mensaje) {
        super(mensaje);
    }
}
