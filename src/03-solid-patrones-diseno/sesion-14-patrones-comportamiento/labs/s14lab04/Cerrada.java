package s14lab04;

public class Cerrada implements EstadoReserva {
    @Override
    public String nombre() {
        return "Cerrada";
    }

    @Override
    public boolean confirmar(Reserva contexto) {
        return false;
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
