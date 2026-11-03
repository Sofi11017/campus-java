package s16lab00;

public final class CuposMetodo implements Cupos {
    private int disponibles;

    public CuposMetodo(int disponibles) {
        if (disponibles < 0 || disponibles > 1_000_000) {
            throw new IllegalArgumentException("Disponibles entre 0 y 1000000");
        }
        this.disponibles = disponibles;
    }

    @Override
    public synchronized boolean reservar() {
        if (disponibles <= 0) {
            return false;
        }
        int observado = disponibles;
        disponibles = observado - 1;
        return true;
    }

    @Override
    public synchronized int consultarDisponibles() {
        return disponibles;
    }
}
