package s14lab04;

public interface EstadoReserva {
    String nombre();
    boolean confirmar(Reserva contexto);
    boolean ocupar(Reserva contexto);
    boolean cerrar(Reserva contexto);
}
