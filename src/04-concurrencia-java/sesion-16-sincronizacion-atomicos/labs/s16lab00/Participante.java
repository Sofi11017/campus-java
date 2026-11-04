package s16lab00;

import java.util.Objects;

public final class Participante implements Runnable {
    private final Cupos cupos;
    private final int intentos;
    private int reservas;

    public Participante(Cupos cupos, int intentos) {
        this.cupos = Objects.requireNonNull(cupos);
        if (intentos < 1 || intentos > 100_000) {
            throw new IllegalArgumentException("Intentos entre 1 y 100000");
        }
        this.intentos = intentos;
    }

    @Override
    public void run() {
        for (int intento = 0; intento < intentos; intento++) {
            if (cupos.reservar()) {
                reservas++;
            }
        }
    }

    public int consultarReservas() {
        return reservas;
    }
}
