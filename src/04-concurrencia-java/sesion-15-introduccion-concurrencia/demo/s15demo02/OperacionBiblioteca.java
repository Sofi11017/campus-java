package s15demo02;

import java.util.Objects;

public final class OperacionBiblioteca implements Runnable {
    private final String nombre;

    public OperacionBiblioteca(String nombre) {
        this.nombre = Objects.requireNonNull(nombre);
        if (nombre.isBlank()) {
            throw new IllegalArgumentException("Nombre vacio");
        }
    }

    @Override
    public void run() {
        System.out.println("[OperacionBiblioteca] :" + nombre + " atendido por " + Thread.currentThread().getName());
    }
}
