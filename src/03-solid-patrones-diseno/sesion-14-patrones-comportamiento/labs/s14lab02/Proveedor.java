package s14lab02;

public class Proveedor extends Soporte {
    public Proveedor(Soporte siguiente) {
        super(siguiente);
    }

    @Override
    protected boolean puedeAtender(Ticket ticket) {
        String categoria = ticket.getCategoria();
        return categoria.equals("CONEXION");
    }

    @Override
    protected String nombre() {
        return "Proveedor";
    }
}
