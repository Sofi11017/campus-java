package s14lab03;

public class Prestar implements ComandoBiblioteca {
    private final Libro libro;

    public Prestar(Libro libro) {
        this.libro = java.util.Objects.requireNonNull(libro);
    }

    @Override
    public boolean ejecutar() {
        return libro.prestar();
    }
}
