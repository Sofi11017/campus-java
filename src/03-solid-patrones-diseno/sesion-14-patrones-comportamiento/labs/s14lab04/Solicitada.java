package s14lab04;

public class Solicitada implements EstadoReserva {
    @Override
    public String nombre() {
        return "Solicitada";
    }

    @Override
    public boolean confirmar(Reserva contexto) {
        contexto.cambiarEstado(new Confirmada());
        return true;
    }

    @Override
    public boolean ocupar(Reserva contexto) {
        return false;
    }

    @Override
    public boolean cerrar(Reserva contexto) {
        return false;
    }
}
