package s16demo00.demo00_3;

public final class Numerador {
    private static int siguiente;

    private Numerador() {
    }

    public static synchronized int obtenerSiguiente() {
        return ++siguiente;
    }
}
