package s16demo00.demo00_1;

import java.util.Objects;

public final class Vendedor implements Runnable {
    private final Inventario inventario;
    private final int intentos;
    private int ventas;
    private boolean completado;

    public Vendedor(Inventario inventario, int intentos) {
        this.inventario = Objects.requireNonNull(inventario);
        if (intentos < 1 || intentos > 100_000) {
            throw new IllegalArgumentException("Intentos entre 1 y 100000");
        }
        this.intentos = intentos;
    }

    @Override
    public void run() {
        for (int intento = 0; intento < intentos; intento++) {
            if (Thread.currentThread().isInterrupted()) {
                return;
            }
            if (inventario.venderUnaUnidad()) {
                ventas++;
            }
        }
        completado = true;
    }

    // Solo consultar desde el controlador despues de join.
    public int consultarVentas() {
        return ventas;
    }

    public boolean completoIntentos() {
        return completado;
    }
}
