package s15lab00;

import java.util.Objects;

public final class TareaBiblioteca implements Runnable {
    private final String nombre;

    public TareaBiblioteca(String nombre) {
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
