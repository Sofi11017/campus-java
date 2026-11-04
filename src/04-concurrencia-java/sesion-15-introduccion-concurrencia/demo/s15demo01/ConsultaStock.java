package s15demo01;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public final class ConsultaStock implements Runnable {
    private enum Estado {
        NO_INICIADA, EN_CURSO, COMPLETADA, CANCELADA
    }

    private final long esperaMs;
    // CountDownLatch es una clase de sincronización que permite que uno o varios hilos esperen
    // hasta que se hayan completado determinadas acciones realizadas por otros hilos.
    private final CountDownLatch inicio = new CountDownLatch(1);
    private Estado estado = Estado.NO_INICIADA;

    public ConsultaStock(long esperaMs) {
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
        System.out.println("[ConsultaStock - run()] : " + estado.toString());
        try {
            if (Thread.currentThread().isInterrupted()) {
                estado = Estado.CANCELADA;
                System.out.println("[ConsultaStock - isInterrupted()] : " + estado.toString());
                return;
            }
            Thread.sleep(esperaMs);
            if (Thread.currentThread().isInterrupted()) {
                estado = Estado.CANCELADA;
                System.out.println("[ConsultaStock - isInterrupted()] : " + estado.toString());
                return;
            }
            estado = Estado.COMPLETADA;
        } catch (InterruptedException error) {
            Thread.currentThread().interrupt();
            estado = Estado.CANCELADA;
            System.out.println("[ConsultaStock - InterruptedException] : " + estado.toString());
        }
    }

    // Leer desde main solo despues de join: no es una consulta concurrente del progreso.
    public String consultarResultado() {
        return estado.name();
    }
}
