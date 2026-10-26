package s12lab02;
import java.time.LocalDate;

public class ReservaBuilder {
    private String huesped;
    private LocalDate fecha;
    private boolean desayuno;
    private boolean estacionamiento;
    private boolean lateCheckout;

    public ReservaBuilder huesped(String valor) {
        huesped = valor;
        return this;
    }
    public ReservaBuilder fecha(LocalDate valor) {
        fecha = valor;
        return this;
    }
    public ReservaBuilder desayuno(boolean valor) {
        desayuno = valor;
        return this;
    }
    public ReservaBuilder estacionamiento(boolean valor) {
        estacionamiento = valor;
        return this;
    }
    public ReservaBuilder lateCheckout(boolean valor) {
        lateCheckout = valor;
        return this;
    }
    public Reserva build() {
        if (huesped == null || huesped.isBlank()) {
            throw new IllegalStateException("El huesped es obligatorio");
        }
        if (fecha == null) {
            throw new IllegalStateException("La fecha es obligatoria");
        }
        return new Reserva(huesped.strip(), fecha, desayuno, estacionamiento, lateCheckout);
    }
}
