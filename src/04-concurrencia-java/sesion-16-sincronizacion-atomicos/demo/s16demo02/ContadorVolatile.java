package s16demo02;

public final class ContadorVolatile implements Contador {
    private volatile int valor;

    @Override
    public void incrementar() {
        valor++;
    }

    @Override
    public int consultar() {
        return valor;
    }
}
