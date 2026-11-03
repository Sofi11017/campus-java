package s14lab01;

public final class EventoCupo {
    private final String curso;

    public EventoCupo(String curso) {
        this.curso = java.util.Objects.requireNonNull(curso);
        if (curso.isBlank()) {
            throw new IllegalArgumentException("Curso vacio");
        }
    }

    public String getCurso() {
        return curso;
    }
}
