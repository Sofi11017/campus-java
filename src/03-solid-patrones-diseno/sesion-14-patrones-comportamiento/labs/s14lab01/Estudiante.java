package s14lab01;

public class Estudiante implements ObservadorCupo {
    private final String nombre;

    public Estudiante(String nombre) {
        this.nombre = java.util.Objects.requireNonNull(nombre);
    }

    @Override
    public void actualizar(EventoCupo evento) {
        System.out.println(nombre + ": cupo en " + evento.getCurso());
    }
}
