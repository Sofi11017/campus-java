package s14lab02;

public abstract class Soporte {
    private final Soporte siguiente;

    protected Soporte(Soporte siguiente) {
        this.siguiente = siguiente;
    }

    protected abstract boolean puedeAtender(Ticket ticket);
    protected abstract String nombre();

    public final String resolver(Ticket ticket) {
        java.util.Objects.requireNonNull(ticket);
        if (puedeAtender(ticket)) {
            return nombre();
        }
        return siguiente == null ? "Sin responsable" : siguiente.resolver(ticket);
    }
}
