package s16lab02;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public final class AgenteMensajes implements Runnable {
    private final AtomicInteger procesados;
    private final int mensajes;

    public AgenteMensajes(AtomicInteger procesados, int mensajes) {
        this.procesados = Objects.requireNonNull(procesados);
        if (mensajes < 1 || mensajes > 100_000) {
            throw new IllegalArgumentException("Mensajes entre 1 y 100000");
        }
        this.mensajes = mensajes;
    }

    @Override
    public void run() {
        for (int indice = 0; indice < mensajes; indice++) {
            procesados.incrementAndGet();
        }
    }
}
