package s14lab02;

public class NivelUno extends Soporte {
    public NivelUno(Soporte siguiente) {
        super(siguiente);
    }

    @Override
    protected boolean puedeAtender(Ticket ticket) {
        String categoria = ticket.getCategoria();
        return categoria.equals("CONTRASENA");
    }

    @Override
    protected String nombre() {
        return "NivelUno";
    }
}
