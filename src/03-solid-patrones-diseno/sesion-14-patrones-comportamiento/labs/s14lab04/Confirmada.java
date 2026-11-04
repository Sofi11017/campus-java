package s14lab04;

public class Confirmada implements EstadoReserva {
    @Override
    public String nombre() {
        return "Confirmada";
    }

    @Override
    public boolean confirmar(Reserva contexto) {
        return false;
    }

    @Override
    public boolean ocupar(Reserva contexto) {
        contexto.cambiarEstado(new Ocupada());
        return true;
    }

    @Override
    public boolean cerrar(Reserva contexto) {
        return false;
    }
}
