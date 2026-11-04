package s14lab03;

public class Renovar implements ComandoBiblioteca {
    private final Libro libro;

    public Renovar(Libro libro) {
        this.libro = java.util.Objects.requireNonNull(libro);
    }

    @Override
    public boolean ejecutar() {
        return libro.renovar();
    }
}
