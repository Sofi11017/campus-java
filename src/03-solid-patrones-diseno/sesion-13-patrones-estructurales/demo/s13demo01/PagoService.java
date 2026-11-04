package s13demo01;

public class PagoService {
    private int intentos;

    public boolean procesar(boolean aprobado) {
        intentos++;
        return aprobado;
    }

    public int consultarIntentos() {
        return intentos;
    }
}
