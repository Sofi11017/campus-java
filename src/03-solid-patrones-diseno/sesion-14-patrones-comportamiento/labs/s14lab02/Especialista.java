package s14lab02;

public class Especialista extends Soporte {
    public Especialista(Soporte siguiente) {
        super(siguiente);
    }

    @Override
    protected boolean puedeAtender(Ticket ticket) {
        String categoria = ticket.getCategoria();
        return categoria.equals("EQUIPO") || categoria.equals("CONTRASENA");
    }

    @Override
    protected String nombre() {
        return "Especialista";
    }
}
