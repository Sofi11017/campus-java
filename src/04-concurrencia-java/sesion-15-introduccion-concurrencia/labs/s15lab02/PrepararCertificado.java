package s15lab02;

import java.util.Objects;

public final class PrepararCertificado implements Runnable {
    private final String nombre;

    public PrepararCertificado(String nombre) {
        this.nombre = Objects.requireNonNull(nombre);
        if (nombre.isBlank()) {
            throw new IllegalArgumentException("Nombre vacio");
        }
    }

    @Override
    public void run() {
        System.out.println(nombre + " atendido por " + Thread.currentThread().getName());
    }
}
