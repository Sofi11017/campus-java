package s07lab03;

public class PlanFuerza extends PlanEntrenamiento {
    public PlanFuerza() {
        super("Fuerza");
    }

    // TODO 3: Agregar @Override y devolver 3 * 8 minutos.
    @Override
    public int duracionMinutos() {
        return 3 * 8;
    }
}