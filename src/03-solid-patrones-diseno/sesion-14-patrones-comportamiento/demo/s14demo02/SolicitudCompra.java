package s14demo02;

public final class SolicitudCompra {
    private final long monto;

    public SolicitudCompra(long monto) {
        if (monto <= 0) {
            throw new IllegalArgumentException("Monto positivo");
        }
        this.monto = monto;
    }

    public long getMonto() {
        return monto;
    }
}
