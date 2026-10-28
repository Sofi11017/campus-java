package s07lab03;

public class PlanCardio extends PlanEntrenamiento {
    public PlanCardio() {
        super("Cardio");
    }

    // TODO 4: Agregar @Override y devolver 2 * 15 minutos.
    @Override
    public int duracionMinutos() {
        return 2 * 15;
    }
}