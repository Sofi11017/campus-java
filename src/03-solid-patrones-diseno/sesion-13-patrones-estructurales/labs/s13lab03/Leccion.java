package s13lab03;

public class Leccion implements ElementoFormativo {
    private final long minutos;

    public Leccion(long minutos) {
        if (minutos < 1 || minutos > 240) {
            throw new IllegalArgumentException("Leccion entre 1 y 240 minutos");
        }
        this.minutos = minutos;
    }

    @Override
    public long calcularMinutos() {
        return minutos;
    }
}
