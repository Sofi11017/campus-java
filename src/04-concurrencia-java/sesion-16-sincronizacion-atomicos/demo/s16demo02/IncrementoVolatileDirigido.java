package s16demo02;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public final class IncrementoVolatileDirigido {
    private volatile int valor;
    private final CountDownLatch lecturas = new CountDownLatch(2);

    public void incrementarDesglosado() {
        int observado = valor;
        lecturas.countDown();
        try {
            if (!lecturas.await(2, TimeUnit.SECONDS)) {
                throw new IllegalStateException("Falta un lector");
            }
        } catch (InterruptedException error) {
            Thread.currentThread().interrupt();
            throw new IllegalStateException("Prueba dirigida interrumpida", error);
        }
        valor = observado + 1;
    }

    public int consultar() {
        return valor;
    }
}
