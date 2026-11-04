package s14demo07;

public class SelectorSala {
    private final MediadorReserva mediador;
    private String sala = "";

    public SelectorSala(MediadorReserva mediador) {
        this.mediador = java.util.Objects.requireNonNull(mediador);
    }

    public void seleccionar(String sala) {
        this.sala = java.util.Objects.requireNonNull(sala);
        mediador.actualizarDisponibilidad();
    }

    public String consultar() {
        return sala;
    }
}
