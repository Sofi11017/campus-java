package s16demo02;

import java.util.Objects;

public final class TrabajadorContador implements Runnable {
    private final Contador contador;
    private final int incrementos;

    public TrabajadorContador(Contador contador, int incrementos) {
        this.contador = Objects.requireNonNull(contador);
        if (incrementos < 1 || incrementos > 100_000) {
            throw new IllegalArgumentException("Incrementos entre 1 y 100000");
        }
        this.incrementos = incrementos;
    }

    @Override
    public void run() {
        for (int indice = 0; indice < incrementos; indice++) {
            contador.incrementar();
        }
    }
}
