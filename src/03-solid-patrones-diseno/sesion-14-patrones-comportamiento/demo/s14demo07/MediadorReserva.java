package s14demo07;

import java.time.LocalDate;

public final class MediadorReserva {
    private final SelectorSala sala = new SelectorSala(this);
    private final SelectorFecha fecha = new SelectorFecha(this);
    private boolean disponible;

    public SelectorSala getSelectorSala() {
        return sala;
    }

    public SelectorFecha getSelectorFecha() {
        return fecha;
    }

    public void actualizarDisponibilidad() {
        // Regla ficticia y determinista; actualizar el resultado no emite otro evento.
        disponible = sala.consultar().equals("A")
                && LocalDate.of(2026, 11, 2).equals(fecha.consultar());
    }

    public boolean estaDisponible() {
        return disponible;
    }
}
