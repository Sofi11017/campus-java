package s14demo07;

import java.time.LocalDate;

public class SelectorFecha {
    private final MediadorReserva mediador;
    private LocalDate fecha;

    public SelectorFecha(MediadorReserva mediador) {
        this.mediador = java.util.Objects.requireNonNull(mediador);
    }

    public void seleccionar(LocalDate fecha) {
        this.fecha = java.util.Objects.requireNonNull(fecha);
        mediador.actualizarDisponibilidad();
    }

    public LocalDate consultar() {
        return fecha;
    }
}
