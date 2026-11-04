package s16demo01;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public final class TrabajadorCalculador implements Runnable {
    private static final int MAX_LOTES = 1_000_000;
    private volatile boolean activo = true;
    private final int tamanoLote;
    private final CountDownLatch primerLote = new CountDownLatch(1);
    private int lotes;
    private long muestras;
    private long comprobacion;
    private String resultado = "NO_INICIADO";

    public TrabajadorCalculador(int tamanoLote) {
        if (tamanoLote < 16 || tamanoLote > 4096) {
            throw new IllegalArgumentException("Tamano de lote entre 16 y 4096");
        }
        this.tamanoLote = tamanoLote;
    }

    public void esperarPrimerLote() throws InterruptedException {
        if (!primerLote.await(5, TimeUnit.SECONDS)) {
            throw new IllegalStateException("El trabajador no inicio");
        }
    }

    public void solicitarDetencion() {
        activo = false;
    }

    @Override
    public void run() {
        while (lotes < MAX_LOTES) {
            if (!activo) {
                resultado = "DETENIDO_POR_BANDERA";
                return;
            }
            if (Thread.currentThread().isInterrupted()) {
                resultado = "INTERRUMPIDO_EN_LIMPIEZA";
                return;
            }
            // Trabajo calculado: no es un bucle vacio esperando una bandera.
            for (int indice = 0; indice < tamanoLote; indice++) {
                comprobacion += (indice % 10);
            }
            muestras += tamanoLote;
            lotes++;
            if (lotes == 1) {
                primerLote.countDown();
            }
        }
        resultado = "LIMITE_DE_SEGURIDAD";
    }

    // El controlador consulta estos datos solamente despues de join.
    public String consultarResultado() {
        return resultado;
    }

    public int consultarLotes() {
        return lotes;
    }

    public long consultarMuestras() {
        return muestras;
    }

    public boolean resumenCoherente() {
        long sumaPorLote = 0;
        for (int indice = 0; indice < tamanoLote; indice++) {
            sumaPorLote += indice % 10;
        }
        return muestras == (long) lotes * tamanoLote
                && comprobacion == sumaPorLote * lotes;
    }
}
