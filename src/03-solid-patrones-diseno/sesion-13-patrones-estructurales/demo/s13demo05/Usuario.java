package s13demo05;

import java.util.Objects;

public final class Usuario {
    private final String nombre;
    private final boolean autorizado;

    public Usuario(String nombre, boolean autorizado) {
        this.nombre = Objects.requireNonNull(nombre);
        this.autorizado = autorizado;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean estaAutorizado() {
        return autorizado;
    }
}
