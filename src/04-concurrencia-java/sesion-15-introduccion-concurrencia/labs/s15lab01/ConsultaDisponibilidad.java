package s15lab01;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public final class ConsultaDisponibilidad implements Runnable {
    private enum Estado {
        NO_INICIADA, EN_CURSO, COMPLETADA, CANCELADA
    }

    private final long esperaMs;
    private final CountDownLatch inicio = new CountDownLatch(1);
    private Estado estado = Estado.NO_INICIADA;

    public ConsultaDisponibilidad(long esperaMs) {
        if (esperaMs < 0 || esperaMs > 5_000) {
            throw new IllegalArgumentException("Espera entre 0 y 5000 ms");
        }
        this.esperaMs = esperaMs;
    }

    public void esperarInicio() throws InterruptedException {
        // Una senal evita intentar acertar el inicio mediante sleep o espera activa.
        if (!inicio.await(5, TimeUnit.SECONDS)) {
            throw new IllegalStateException("La consulta no inicio en el plazo previsto");
        }
    }

    @Override
    public void run() {
        estado = Estado.EN_CURSO;
        inicio.countDown();
        try {
            if (Thread.currentThread().isInterrupted()) {
                estado = Estado.CANCELADA;
                return;
            }
            Thread.sleep(esperaMs);
            if (Thread.currentThread().isInterrupted()) {
                estado = Estado.CANCELADA;
                return;
            }
            estado = Estado.COMPLETADA;
        } catch (InterruptedException error) {
            Thread.currentThread().interrupt();
            estado = Estado.CANCELADA;
        }
    }

    // Leer desde main solo despues de join: no es una consulta concurrente del progreso.
    public String consultarResultado() {
        return estado.name();
    }
}
