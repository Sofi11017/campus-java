package s12lab02;
import java.time.LocalDate;

public final class Reserva {
    private final String huesped;
    private final LocalDate fecha;
    private final boolean desayuno;
    private final boolean estacionamiento;
    private final boolean lateCheckout;

    Reserva(String huesped, LocalDate fecha, boolean desayuno,
            boolean estacionamiento, boolean lateCheckout) {
        this.huesped = huesped;
        this.fecha = fecha;
        this.desayuno = desayuno;
        this.estacionamiento = estacionamiento;
        this.lateCheckout = lateCheckout;
    }
    public boolean tieneLateCheckout() {
        return lateCheckout;
    }
    public String resumen() {
        return huesped + " | " + fecha + " | desayuno=" + desayuno
                + " | estacionamiento=" + estacionamiento + " | lateCheckout=" + lateCheckout;
    }
}
