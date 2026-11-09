package s19demo00;

public class ReglaMontoMinimo implements ReglaMonto {
    private final int minimo;

    public ReglaMontoMinimo(int minimo) {
        if (minimo < 0) {
            throw new IllegalArgumentException("El minimo no puede ser negativo.");
        }
        this.minimo = minimo;
    }

    @Override
    public boolean cumple(int monto) {
        return monto >= minimo;
    }
}
