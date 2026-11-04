package s15demo00;

import java.util.Objects;

public final class VerificacionPedido implements Runnable {
    private final String nombre;
    private final int pasos;
    private final long pausaMs;

    public VerificacionPedido(String nombre, int pasos, long pausaMs) {
        this.nombre = Objects.requireNonNull(nombre);
        if (nombre.isBlank() || pasos < 1 || pasos > 5 || pausaMs < 0 || pausaMs > 500) {
            throw new IllegalArgumentException("Nombre no vacio, pasos 1..5 y pausa 0..500 ms");
        }
        this.pasos = pasos;
        this.pausaMs = pausaMs;
    }

    @Override
    public void run() {
        for (int paso = 1; paso <= pasos; paso++) {
            if (Thread.currentThread().isInterrupted()) {
                System.out.println("[VerificacionPedido] : " + nombre + ": cancelada");
                return;
            }
            System.out.println("[VerificacionPedido] : " + nombre + " paso " + paso + " en " + Thread.currentThread().getName());
            try {
                Thread.sleep(pausaMs);
            } catch (InterruptedException error) {
                Thread.currentThread().interrupt();
                System.out.println("[VerificacionPedido] : " + nombre + ": cancelada");
                return;
            }
        }
        System.out.println("[VerificacionPedido] : " + nombre + ": terminada");
    }
}
