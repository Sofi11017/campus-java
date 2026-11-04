package s14demo07;

import java.time.LocalDate;

public class S14Demo07MediatorMain {
    public static void main(String[] args) {
        MediadorReserva mediador = new MediadorReserva();
        mediador.getSelectorSala().seleccionar("A");
        System.out.println("Solo sala: " + mediador.estaDisponible());
        mediador.getSelectorFecha().seleccionar(LocalDate.of(2026, 11, 2));
        System.out.println("Sala y fecha: " + mediador.estaDisponible());
        mediador.getSelectorSala().seleccionar("B");
        System.out.println("Cambio de sala: " + mediador.estaDisponible());
    }
}
