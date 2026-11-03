package s16demo00.demo00_2;

import java.util.Objects;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public final class VentaConMonitorPropio implements Runnable {
    private final Object monitor = new Object();
    private final StockCompartido stock;
    private final CountDownLatch ambosLeyeron;

    public VentaConMonitorPropio(StockCompartido stock, CountDownLatch ambosLeyeron) {
        this.stock = Objects.requireNonNull(stock);
        this.ambosLeyeron = Objects.requireNonNull(ambosLeyeron);
    }

    public boolean usaMismoMonitor(VentaConMonitorPropio otra) {
        return monitor == otra.monitor;
    }

    @Override
    public void run() {
        // DEFECTO deliberado: cada vendedor bloquea un objeto diferente.
        synchronized (monitor) {
            int observado = stock.leerSinProteccion();
            ambosLeyeron.countDown();
            try {
                if (!ambosLeyeron.await(2, TimeUnit.SECONDS)) {
                    throw new IllegalStateException("No llegaron ambos lectores");
                }
            } catch (InterruptedException error) {
                Thread.currentThread().interrupt();
                throw new IllegalStateException("Prueba dirigida interrumpida", error);
            }
            stock.escribirSinProteccion(observado - 1);
        }
    }
}
