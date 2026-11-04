package s14lab03;

public class Devolver implements ComandoBiblioteca {
    private final Libro libro;

    public Devolver(Libro libro) {
        this.libro = java.util.Objects.requireNonNull(libro);
    }

    @Override
    public boolean ejecutar() {
        return libro.devolver();
    }
}
