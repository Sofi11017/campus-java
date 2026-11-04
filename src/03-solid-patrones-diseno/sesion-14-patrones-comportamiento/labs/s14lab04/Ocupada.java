package s14lab04;

public class Ocupada implements EstadoReserva {
    @Override
    public String nombre() {
        return "Ocupada";
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
        contexto.cambiarEstado(new Cerrada());
        return true;
    }
}
