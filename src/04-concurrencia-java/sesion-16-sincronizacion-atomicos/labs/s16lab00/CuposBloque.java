package s16lab00;

public final class CuposBloque implements Cupos {
    private int disponibles;
    private final Object monitor = new Object();

    public CuposBloque(int disponibles) {
        if (disponibles < 0 || disponibles > 1_000_000) {
            throw new IllegalArgumentException("Disponibles entre 0 y 1000000");
        }
        this.disponibles = disponibles;
    }

    @Override
    public boolean reservar() {
        synchronized (monitor) {
            if (disponibles <= 0) {
                return false;
            }
            int observado = disponibles;
            disponibles = observado - 1;
            return true;
        }
    }

    @Override
    public int consultarDisponibles() {
        synchronized (monitor) {
            return disponibles;
        }
    }
}
