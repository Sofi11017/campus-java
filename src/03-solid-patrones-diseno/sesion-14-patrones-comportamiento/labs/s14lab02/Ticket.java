package s14lab02;

public final class Ticket {
    private final String categoria;

    public Ticket(String categoria) {
        this.categoria = java.util.Objects.requireNonNull(categoria);
    }

    public String getCategoria() {
        return categoria;
    }
}
