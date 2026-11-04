package s13demo03;

public class ActividadSimple implements Actividad {
    private final long costo;

    public ActividadSimple(long costo) {
        if (costo < 0 || costo > 1_000_000) {
            throw new IllegalArgumentException("Costo entre 0 y 1000000");
        }
        this.costo = costo;
    }

    @Override
    public long calcularCosto() {
        return costo;
    }
}
