package s12lab04;
public final class ContadorMetricas {
    private static final ContadorMetricas INSTANCIA = new ContadorMetricas();
    private long total;

    private ContadorMetricas() {
    }
    public static ContadorMetricas obtenerInstancia() {
        return INSTANCIA;
    }
    // Ejemplo monohilo: no promete incrementos seguros desde varios hilos.
    public void incrementar() {
        total++;
    }
    public long consultar() {
        return total;
    }
}
