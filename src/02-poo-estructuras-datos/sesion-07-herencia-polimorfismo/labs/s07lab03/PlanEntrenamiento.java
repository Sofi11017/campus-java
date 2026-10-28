package s07lab03;

// TODO 1: Declarar PlanEntrenamiento como clase abstracta.
public abstract class PlanEntrenamiento {
    private final String nombre;

    public PlanEntrenamiento(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    // TODO 2
    public abstract int duracionMinutos();
}