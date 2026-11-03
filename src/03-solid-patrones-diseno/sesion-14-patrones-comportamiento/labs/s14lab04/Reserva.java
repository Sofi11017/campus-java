package s14lab04;

public class Reserva {
    private EstadoReserva estado = new Solicitada();

    void cambiarEstado(EstadoReserva estado) {
        this.estado = java.util.Objects.requireNonNull(estado);
    }

    public String consultarEstado() {
        return estado.nombre();
    }

    public boolean confirmar() {
        return estado.confirmar(this);
    }

    public boolean ocupar() {
        return estado.ocupar(this);
    }

    public boolean cerrar() {
        return estado.cerrar(this);
    }
}
