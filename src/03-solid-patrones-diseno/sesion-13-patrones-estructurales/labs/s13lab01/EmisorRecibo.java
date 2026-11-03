package s13lab01;

public class EmisorRecibo {
    private int cantidad;

    public void emitir() {
        cantidad++;
    }

    public int consultarCantidad() {
        return cantidad;
    }
}
